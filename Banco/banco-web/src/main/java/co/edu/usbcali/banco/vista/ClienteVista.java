package co.edu.usbcali.banco.vista;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;

import org.primefaces.component.commandbutton.CommandButton;
import org.primefaces.component.inputnumber.InputNumber;
import org.primefaces.component.inputtext.InputText;
import org.primefaces.component.password.Password;
import org.primefaces.component.selectonemenu.SelectOneMenu;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import co.edu.usbcali.banco.modelo.Cliente;
import co.edu.usbcali.banco.modelo.Cuenta;
import co.edu.usbcali.banco.modelo.CuentaRegistrada;
import co.edu.usbcali.banco.modelo.TipoDocumento;
import co.edu.usbcali.banco.modelo.TipoUsuario;
import co.edu.usbcali.banco.modelo.Transaccion;
import co.edu.usbcali.banco.modelo.Usuario;
import co.edu.usbcali.banco.util.FacesUtils;

@ViewScoped
@ManagedBean(name = "clienteVista")
public class ClienteVista {

	private final static Logger log = LoggerFactory.getLogger(ClienteVista.class);

	@ManagedProperty("#{delegadoDeNegocio}")
	private IDelegadoDeNegocio delegadoDeNegocio;
	
	private String nombreCliente;
	private String txtClienId;
	private List<Cuenta> lasCuentas;
	private List<Transaccion> lasTransacciones;
	private List<CuentaRegistrada> lasCuentasRegistradas;

	private List<SelectItem> lasCuentasCliente;
	private List<SelectItem> lasCuentasClienteRegistradas;
	private List<SelectItem> lasCuentasClienteRegistradasOnly;
	private List<SelectItem> losTipoDocumentoSelectItem;
	// perfil
	private String txtClienNombre;
	private String txtClienDireccion;
	private String txtClienTelefono;
	private String txtClienCorreo;
	// cuenta
	private InputText txtCuenId;
	private Password txtCuenPass1;
	private Password txtCuenPass2;
	private CommandButton btnGuardarPass;

	// transaccion

	private SelectOneMenu somCuentaCliente;

	// cuentas registrada

	private SelectOneMenu somTipoDocumentoRegistrar;
	private InputText txtIdentificacionRegistrar;
	private InputText txtCuentaRegistrar;

	// transaccion
	private SelectOneMenu somCuentaOrigen;
	private SelectOneMenu somCuentaDestino;
	private InputNumber txtValorTrasferencia;

	public String trasferencia() {
		BigDecimal valor;
		try {
			valor = new BigDecimal(txtValorTrasferencia.getValue().toString());
		} catch (Exception e) {
			valor = null;
		}
		try {
			String cuenIdOrigen = somCuentaOrigen.getValue().toString();
			String cuenIdDestino = somCuentaDestino.getValue().toString();
			String userId = "aadamoco";
			
			
			Cuenta cuentaOrigen = delegadoDeNegocio.findCuenta(cuenIdOrigen);
			Cuenta cuentaDestino = delegadoDeNegocio.findCuenta(cuenIdDestino);
			
						
			delegadoDeNegocio.transferenciaTransaccionBanco("ukernockecx", cuenIdOrigen, cuenIdDestino,
					cuentaOrigen.getCliente().getClieId(), 
				    cuentaDestino.getCliente().getClieId(), valor);
			

			FacesContext.getCurrentInstance().addMessage("",
					new FacesMessage(FacesMessage.SEVERITY_INFO, "La trasferencia es correcta", ""));

			
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage("",
					new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), ""));
		}

		return "";
	}

	
	//registrar cuenta
	public String registrarCuenta() {

		BigDecimal identificacion;
		
		try {
			identificacion = new BigDecimal(txtIdentificacionRegistrar.getValue().toString().trim());
		} catch (Exception e) {
			identificacion = null;
		}
		try {
			Long tipoDocumento = new Long(somTipoDocumentoRegistrar.getValue().toString());
			
			String cuenId = txtCuentaRegistrar.getValue().toString().trim();

			CuentaRegistrada cuentaRegistrada = delegadoDeNegocio.registrarCuentaRegistrada(tipoDocumento,identificacion,
					cuenId, new BigDecimal(txtClienId));

			FacesContext.getCurrentInstance().addMessage("",
					new FacesMessage(FacesMessage.SEVERITY_INFO, "Se registro correctamente", ""));

			lasCuentasRegistradas = delegadoDeNegocio.findClienteCuentaRegistrada(new BigDecimal(txtClienId));
			
			lasCuentasClienteRegistradas = null;
			lasCuentasClienteRegistradasOnly = null;
			
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage("",
					new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), ""));
		}

		return "";
	}

	// transaccion metodo

	public String listenerCuentaTransaccion() {

		String cuenId = somCuentaCliente.getValue().toString();
		Cuenta cuenta = delegadoDeNegocio.findCuenta(cuenId);
		if (cuenta != null) {
			lasTransacciones = delegadoDeNegocio.findAllCuentaTransaccion(cuenId);
		} else {
			lasTransacciones = new ArrayList<>();
		}

		return "";
	}

	// cuenta metodo

	public String cambiarClaveCuenta() {
		try {
			String pass1 = txtCuenPass1.getValue().toString();
			String pass2 = txtCuenPass2.getValue().toString();
			String cuenId = txtCuenId.getValue().toString().trim();

			Cuenta cuenta = delegadoDeNegocio.findCuenta(cuenId);
			if (pass1.equals(pass2)) {
				cuenta.setClave(pass1);

				delegadoDeNegocio.updateCuenta(cuenta);

				FacesContext.getCurrentInstance().addMessage("",
						new FacesMessage(FacesMessage.SEVERITY_INFO, "Sus cambio la clave correctamente", ""));

				lasCuentas = delegadoDeNegocio.findAllClienteCuenta(new BigDecimal(txtClienId));
			} else {
				FacesContext.getCurrentInstance().addMessage("",
						new FacesMessage(FacesMessage.SEVERITY_ERROR, "las contraseñas no coinciden", ""));
			}
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage("",
					new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), ""));
		}
		return "";
	}

	public String listernerIdCuenta() {
		try {
			String cuenId = txtCuenId.getValue().toString().trim();
			Cuenta cuenta = delegadoDeNegocio.findCuenta(cuenId);

			if (cuenta == null) {
				btnGuardarPass.setDisabled(true);
				txtCuenPass1.setDisabled(true);
				txtCuenPass2.setDisabled(true);
				txtCuenPass1.resetValue();
				txtCuenPass2.resetValue();
				
				FacesContext.getCurrentInstance().addMessage("",
						new FacesMessage(FacesMessage.SEVERITY_ERROR,"formato cuenta no valido", ""));
			} else {
				btnGuardarPass.setDisabled(false);
				txtCuenPass1.setDisabled(false);
				txtCuenPass2.setDisabled(false);
			}
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage("",
					new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), ""));
		}
		return "";
	}

	// perfil metodo

	public String actualizarCliente() {
		try {
			Cliente cliente = delegadoDeNegocio.findCliente(new BigDecimal(txtClienId));
			cliente.setDireccion(txtClienDireccion);
			cliente.setTelefono(txtClienTelefono);
			cliente.setEmail(txtClienCorreo);

			delegadoDeNegocio.updateCliente(cliente);

			FacesContext.getCurrentInstance().addMessage("",
					new FacesMessage(FacesMessage.SEVERITY_INFO, "Sus datos se actualizaron correctamente", ""));

		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage("",
					new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), ""));

		}

		return "";
	}

	// binding

	public IDelegadoDeNegocio getDelegadoDeNegocio() {
		return delegadoDeNegocio;
	}

	public void setDelegadoDeNegocio(IDelegadoDeNegocio delegadoDeNegocio) {
		this.delegadoDeNegocio = delegadoDeNegocio;
	}

	public String getTxtClienId() {
		try {
			Cliente cliente = (Cliente)FacesUtils.getfromSession("cliente");
			txtClienId = cliente.getClieId()+"";
			return txtClienId;
		} catch (Exception e) {
			return "";
		}
	}

	public void setTxtClienId(String txtClienId) {
		this.txtClienId = txtClienId;
	}

	public String getTxtClienNombre() {
		Cliente cliente = delegadoDeNegocio.findCliente(new BigDecimal(txtClienId));
		txtClienNombre = cliente.getNombre();
		return txtClienNombre;
	}

	public void setTxtClienNombre(String txtClienNombre) {
		this.txtClienNombre = txtClienNombre;
	}

	public String getTxtClienDireccion() {
		if (txtClienDireccion == null) {
			Cliente cliente = delegadoDeNegocio.findCliente(new BigDecimal(txtClienId));
			txtClienDireccion = cliente.getDireccion();
		}
		return txtClienDireccion;
	}

	public void setTxtClienDireccion(String txtClienDireccion) {
		this.txtClienDireccion = txtClienDireccion;
	}

	public String getTxtClienTelefono() {
		if (txtClienTelefono == null) {
			Cliente cliente = delegadoDeNegocio.findCliente(new BigDecimal(txtClienId));
			txtClienTelefono = cliente.getTelefono();
		}
		return txtClienTelefono;
	}

	public void setTxtClienTelefono(String txtClienTelefono) {
		this.txtClienTelefono = txtClienTelefono;
	}

	public String getTxtClienCorreo() {
		if (txtClienCorreo == null) {
			Cliente cliente = delegadoDeNegocio.findCliente(new BigDecimal(txtClienId));
			txtClienCorreo = cliente.getEmail();
		}
		return txtClienCorreo;
	}

	public void setTxtClienCorreo(String txtClienCorreo) {
		this.txtClienCorreo = txtClienCorreo;
	}

	public List<Cuenta> getLasCuentas() {
		if (lasCuentas == null)
			lasCuentas = delegadoDeNegocio.findAllClienteCuenta(new BigDecimal(txtClienId));
		return lasCuentas;
	}

	public void setLasCuentas(List<Cuenta> lasCuentas) {
		this.lasCuentas = lasCuentas;
	}

	public InputText getTxtCuenId() {
		return txtCuenId;
	}

	public void setTxtCuenId(InputText txtCuenId) {
		this.txtCuenId = txtCuenId;
	}

	public Password getTxtCuenPass1() {
		return txtCuenPass1;
	}

	public void setTxtCuenPass1(Password txtCuenPass1) {
		this.txtCuenPass1 = txtCuenPass1;
	}

	public Password getTxtCuenPass2() {
		return txtCuenPass2;
	}

	public void setTxtCuenPass2(Password txtCuenPass2) {
		this.txtCuenPass2 = txtCuenPass2;
	}

	public CommandButton getBtnGuardarPass() {
		return btnGuardarPass;
	}

	public void setBtnGuardarPass(CommandButton btnGuardarPass) {
		this.btnGuardarPass = btnGuardarPass;
	}

	public List<Transaccion> getLasTransacciones() {
		return lasTransacciones;
	}

	public void setLasTransacciones(List<Transaccion> lasTransacciones) {
		this.lasTransacciones = lasTransacciones;
	}

	public List<SelectItem> getLasCuentasCliente() {
		if (lasCuentasCliente == null) {
			lasCuentasCliente = new ArrayList<>();
			for (Cuenta cuenta : lasCuentas) {
				lasCuentasCliente.add(new SelectItem(cuenta.getCuenId(), cuenta.getCuenId()));
			}
		}
		return lasCuentasCliente;
	}

	public void setLasCuentasCliente(List<SelectItem> lasCuentasCliente) {
		this.lasCuentasCliente = lasCuentasCliente;
	}

	public SelectOneMenu getSomCuentaCliente() {
		return somCuentaCliente;
	}

	public void setSomCuentaCliente(SelectOneMenu somCuentaCliente) {
		this.somCuentaCliente = somCuentaCliente;
	}

	public List<SelectItem> getLosTipoDocumentoSelectItem() {
		if (losTipoDocumentoSelectItem == null) {
			losTipoDocumentoSelectItem = new ArrayList<>();
			List<TipoDocumento> losTipoDocumento = delegadoDeNegocio.findAllTipoDocumento();
			for (TipoDocumento tipoDocumento : losTipoDocumento) {
				losTipoDocumentoSelectItem
						.add(new SelectItem("" + tipoDocumento.getTdocId(), tipoDocumento.getNombre()));
			}
		}
		return losTipoDocumentoSelectItem;
	}

	public void setLosTipoDocumentoSelectItem(List<SelectItem> losTipoDocumentoSelectItem) {
		this.losTipoDocumentoSelectItem = losTipoDocumentoSelectItem;
	}

	public SelectOneMenu getSomTipoDocumentoRegistrar() {
		return somTipoDocumentoRegistrar;
	}

	public void setSomTipoDocumentoRegistrar(SelectOneMenu somTipoDocumentoRegistrar) {
		this.somTipoDocumentoRegistrar = somTipoDocumentoRegistrar;
	}

	public InputText getTxtIdentificacionRegistrar() {
		return txtIdentificacionRegistrar;
	}

	public void setTxtIdentificacionRegistrar(InputText txtIdentificacionRegistrar) {
		this.txtIdentificacionRegistrar = txtIdentificacionRegistrar;
	}

	public InputText getTxtCuentaRegistrar() {
		return txtCuentaRegistrar;
	}

	public void setTxtCuentaRegistrar(InputText txtCuentaRegistrar) {
		this.txtCuentaRegistrar = txtCuentaRegistrar;
	}

	public List<CuentaRegistrada> getLasCuentasRegistradas() {
		if (lasCuentasRegistradas == null)
			lasCuentasRegistradas = delegadoDeNegocio.findClienteCuentaRegistrada(new BigDecimal(txtClienId));
		return lasCuentasRegistradas;
	}

	public void setLasCuentasRegistradas(List<CuentaRegistrada> lasCuentasRegistradas) {
		this.lasCuentasRegistradas = lasCuentasRegistradas;
	}

	public List<SelectItem> getLasCuentasClienteRegistradas() {
		if (lasCuentasClienteRegistradas == null) {
			lasCuentasClienteRegistradas = new ArrayList<>();
			for (Cuenta cuenta : delegadoDeNegocio.findAllClienteCuenta(new BigDecimal(txtClienId))) {
				lasCuentasClienteRegistradas.add(new SelectItem(cuenta.getCuenId(),
						cuenta.getCuenId()));
			}
			for (CuentaRegistrada cuentaRegistrada : lasCuentasRegistradas) {
				lasCuentasClienteRegistradas.add(new SelectItem(cuentaRegistrada.getCuenta().getCuenId(),
						cuentaRegistrada.getCuenta().getCuenId()));
			}
			
		}
		return lasCuentasClienteRegistradas;
	}

	public void setLasCuentasClienteRegistradas(List<SelectItem> lasCuentasClienteRegistradas) {
		this.lasCuentasClienteRegistradas = lasCuentasClienteRegistradas;
	}

	public SelectOneMenu getSomCuentaOrigen() {
		return somCuentaOrigen;
	}

	public void setSomCuentaOrigen(SelectOneMenu somCuentaOrigen) {
		this.somCuentaOrigen = somCuentaOrigen;
	}

	public SelectOneMenu getSomCuentaDestino() {
		return somCuentaDestino;
	}

	public void setSomCuentaDestino(SelectOneMenu somCuentaDestino) {
		this.somCuentaDestino = somCuentaDestino;
	}


	public List<SelectItem> getLasCuentasClienteRegistradasOnly() {
		if (lasCuentasClienteRegistradasOnly == null) {
			lasCuentasClienteRegistradasOnly = new ArrayList<>();
			for (Cuenta cuenta : delegadoDeNegocio.findAllClienteCuenta(new BigDecimal(txtClienId))) {
				lasCuentasClienteRegistradasOnly.add(new SelectItem(cuenta.getCuenId(),
						cuenta.getCuenId()));
			}
		}
		return lasCuentasClienteRegistradasOnly;
	}


	public void setLasCuentasClienteRegistradasOnly(List<SelectItem> lasCuentasClienteRegistradasOnly) {
		this.lasCuentasClienteRegistradasOnly = lasCuentasClienteRegistradasOnly;
	}


	public InputNumber getTxtValorTrasferencia() {
		return txtValorTrasferencia;
	}


	public void setTxtValorTrasferencia(InputNumber txtValorTrasferencia) {
		this.txtValorTrasferencia = txtValorTrasferencia;
	}


	public String getNombreCliente() {
		try {
			Cliente cliente = (Cliente)FacesUtils.getfromSession("cliente");
			nombreCliente = cliente.getNombre();
			return nombreCliente;
			
		} catch (Exception e) {
			return "";
		}
		
	}


	public void setNombreCliente(String nombreCliente) {
		this.nombreCliente = nombreCliente;
	}

}
