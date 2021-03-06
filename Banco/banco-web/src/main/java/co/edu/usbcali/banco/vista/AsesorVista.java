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
import org.primefaces.component.inputtext.InputText;
import org.primefaces.component.selectonemenu.SelectOneMenu;

import co.edu.usbcali.banco.modelo.Cliente;
import co.edu.usbcali.banco.modelo.Cuenta;
import co.edu.usbcali.banco.modelo.TipoDocumento;
import co.edu.usbcali.banco.modelo.Usuario;
import co.edu.usbcali.banco.util.FacesUtils;

@ViewScoped
@ManagedBean(name = "asesorVista")
public class AsesorVista {

	@ManagedProperty("#{delegadoDeNegocio}")
	private IDelegadoDeNegocio delegadoDeNegocio;

	private String nombreUsuario;
	// cuentas
	private List<Cuenta> lasCuentas;
	private InputText txtClienteId;
	private InputText txtClienteNombre;

	private CommandButton btnCrearCuenta;
	// clientes
	private List<Cliente> losClientes;

	private InputText txtId;
	private InputText txtNombre;
	private InputText txtDireccion;
	private InputText txtTelefono;
	private InputText txtMail;

	private SelectOneMenu somTipoDocumento;
	private SelectOneMenu somActivo;

	private CommandButton btnCrear;
	private CommandButton btnModificar;
	private CommandButton btnLimpiar;

	private List<SelectItem> losTipoDocumentoSelectItem;

	// gestion clienta
	public void limpiarAction() {

		btnCrear.setDisabled(true);
		btnModificar.setDisabled(true);
		btnCrearCuenta.setDisabled(true);

		txtClienteId.resetValue();
		txtClienteNombre.resetValue();
		txtId.resetValue();
		txtDireccion.resetValue();
		txtMail.resetValue();
		txtNombre.resetValue();
		txtTelefono.resetValue();

		somActivo.resetValue();
		somTipoDocumento.resetValue();

		lasCuentas = new ArrayList<Cuenta>();

	}

	public void crearAction() {

		BigDecimal identificacion;

		try {
			identificacion = new BigDecimal(txtId.getValue().toString().trim());
		} catch (Exception e) {
			identificacion = null;
		}

		try {

			Cliente cliente = new Cliente();

			cliente.setClieId(identificacion);
			cliente.setNombre(txtNombre.getValue().toString().trim());
			cliente.setActivo(somActivo.getValue().toString().charAt(0));
			cliente.setDireccion(txtDireccion.getValue().toString().trim());
			cliente.setEmail(txtMail.getValue().toString().trim());
			cliente.setTelefono(txtTelefono.getValue().toString().trim());

			TipoDocumento tipoDocumento = delegadoDeNegocio
					.findTipoDocumento(new Long(somTipoDocumento.getValue().toString()));

			cliente.setTipoDocumento(tipoDocumento);

			delegadoDeNegocio.createCliente(cliente);

			Cuenta cuenta = new Cuenta();
			cuenta.setActiva('N');
			cuenta.setClave(generarPass());
			cuenta.setCliente(cliente);
			cuenta.setCuenId(generarCuenta());
			cuenta.setSaldo(new BigDecimal(0));

			delegadoDeNegocio.createCuenta(cuenta);

			FacesContext.getCurrentInstance().addMessage("", new FacesMessage(FacesMessage.SEVERITY_INFO,
					"El cliente se creo exitosamente y se le creo su respectiva cuenta", ""));
			FacesContext.getCurrentInstance().addMessage("", new FacesMessage(FacesMessage.SEVERITY_INFO,
					"El cliente se la cuenta con id " + cuenta.getCuenId() + " con clave " + cuenta.getClave(), ""));

			limpiarAction();

		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage("",
					new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), ""));
		}

	}

	public void updateAction() {

		BigDecimal identificacion;

		try {
			identificacion = new BigDecimal(txtId.getValue().toString().trim());
		} catch (Exception e) {
			identificacion = null;
		}
		try {

			Cliente cliente = new Cliente();

			cliente.setClieId(identificacion);
			cliente.setNombre(txtNombre.getValue().toString().trim());
			cliente.setActivo(somActivo.getValue().toString().charAt(0));
			cliente.setDireccion(txtDireccion.getValue().toString().trim());
			cliente.setEmail(txtMail.getValue().toString().trim());
			cliente.setTelefono(txtTelefono.getValue().toString().trim());

			TipoDocumento tipoDocumento = delegadoDeNegocio
					.findTipoDocumento(new Long(somTipoDocumento.getValue().toString()));

			cliente.setTipoDocumento(tipoDocumento);

			delegadoDeNegocio.updateCliente(cliente);

			FacesContext.getCurrentInstance().addMessage("",
					new FacesMessage(FacesMessage.SEVERITY_INFO, "El cliente se actualizo exitosamente", ""));

		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage("",
					new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), ""));
		}

	}

	public void txtIdListener() {
		try {

			BigDecimal clieId = new BigDecimal(txtId.getValue().toString().trim());
			Cliente cliente = delegadoDeNegocio.findCliente(clieId);

			if (cliente == null) {
				btnCrear.setDisabled(false);
				btnModificar.setDisabled(true);
				btnCrearCuenta.setDisabled(true);

				txtClienteId.resetValue();
				txtClienteNombre.resetValue();
				txtDireccion.resetValue();
				txtMail.resetValue();
				txtNombre.resetValue();
				txtTelefono.resetValue();

				somActivo.resetValue();
				somTipoDocumento.resetValue();

				lasCuentas = new ArrayList<Cuenta>();
			} else {
				// gestion cliente
				btnCrear.setDisabled(true);
				btnModificar.setDisabled(false);

				txtDireccion.setValue(cliente.getDireccion());
				txtMail.setValue(cliente.getEmail());
				txtNombre.setValue(cliente.getNombre());
				txtTelefono.setValue(cliente.getTelefono());

				somActivo.setValue(cliente.getActivo());
				somTipoDocumento.setValue(cliente.getTipoDocumento().getTdocId());
				// gestion cuenta
				txtClienteId.setValue(cliente.getClieId());
				txtClienteNombre.setValue(cliente.getNombre());

				lasCuentas = delegadoDeNegocio.findAllClienteCuenta(cliente.getClieId());

				btnCrearCuenta.setDisabled(false);
			}
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage("",
					new FacesMessage(FacesMessage.SEVERITY_ERROR,"Identificacion formato no valido", ""));
		}
	}
	
	public void txtIdCuentaListener() {
		try {

			BigDecimal clieId = new BigDecimal(txtClienteId.getValue().toString().trim());
			Cliente cliente = delegadoDeNegocio.findCliente(clieId);

			if (cliente == null) {				

				lasCuentas = new ArrayList<Cuenta>();
				
				FacesContext.getCurrentInstance().addMessage("",
						new FacesMessage(FacesMessage.SEVERITY_ERROR,"Identificacion no existe", ""));
			} else {
				
				// gestion cuenta
				txtClienteId.setValue(cliente.getClieId());
				txtClienteNombre.setValue(cliente.getNombre());

				lasCuentas = delegadoDeNegocio.findAllClienteCuenta(cliente.getClieId());

				btnCrearCuenta.setDisabled(false);
			}
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage("",
					new FacesMessage(FacesMessage.SEVERITY_ERROR,"Identificacion formato no valido", ""));
		}
	}

	// cuenta
	public void crearCuenta() {

		try {

			BigDecimal clieId = new BigDecimal(txtId.getValue().toString().trim());

			Cliente cliente = delegadoDeNegocio.findCliente(clieId);

			Cuenta cuenta = new Cuenta();
			cuenta.setActiva('N');
			cuenta.setClave(generarPass());
			cuenta.setCliente(cliente);
			cuenta.setCuenId(generarCuenta());
			cuenta.setSaldo(new BigDecimal(0));

			delegadoDeNegocio.createCuenta(cuenta);

			lasCuentas = delegadoDeNegocio.findAllClienteCuenta(cliente.getClieId());

			FacesContext.getCurrentInstance().addMessage("", new FacesMessage(FacesMessage.SEVERITY_INFO,
					"El cliente se creo le creo su respectiva cuenta", ""));

		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage("",
					new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), ""));
		}

	}

	public String generarPass() {
		return String.format("%08d", ((int) (Math.random() * 99999999)));
	}

	public String generarCuenta() {
		String cuenId = "";
		for (int i = 0; i < 4; i++) {
			int num = (int) (Math.random() * 9999) + 1;
			cuenId = cuenId + String.format("%04d", num);
			if (i < 3) {
				cuenId = cuenId + "-";
			}
		}

		Cuenta cuenta = delegadoDeNegocio.findCuenta(cuenId);
		if (cuenta == null) {
			return cuenId;
		}
		return generarCuenta();
	}

	// binding
	public InputText getTxtId() {
		return txtId;
	}

	public void setTxtId(InputText txtId) {
		this.txtId = txtId;
	}

	public InputText getTxtNombre() {
		return txtNombre;
	}

	public void setTxtNombre(InputText txtNombre) {
		this.txtNombre = txtNombre;
	}

	public InputText getTxtDireccion() {
		return txtDireccion;
	}

	public void setTxtDireccion(InputText txtDireccion) {
		this.txtDireccion = txtDireccion;
	}

	public InputText getTxtTelefono() {
		return txtTelefono;
	}

	public void setTxtTelefono(InputText txtTelefono) {
		this.txtTelefono = txtTelefono;
	}

	public InputText getTxtMail() {
		return txtMail;
	}

	public void setTxtMail(InputText txtMail) {
		this.txtMail = txtMail;
	}

	public SelectOneMenu getSomTipoDocumento() {
		return somTipoDocumento;
	}

	public void setSomTipoDocumento(SelectOneMenu somTipoDocumento) {
		this.somTipoDocumento = somTipoDocumento;
	}

	public SelectOneMenu getSomActivo() {
		return somActivo;
	}

	public void setSomActivo(SelectOneMenu somActivo) {
		this.somActivo = somActivo;
	}

	public CommandButton getBtnCrear() {
		return btnCrear;
	}

	public void setBtnCrear(CommandButton btnCrear) {
		this.btnCrear = btnCrear;
	}

	public CommandButton getBtnModificar() {
		return btnModificar;
	}

	public void setBtnModificar(CommandButton btnModificar) {
		this.btnModificar = btnModificar;
	}

	public CommandButton getBtnLimpiar() {
		return btnLimpiar;
	}

	public void setBtnLimpiar(CommandButton btnLimpiar) {
		this.btnLimpiar = btnLimpiar;
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

	public List<Cliente> getLosClientes() {
		if (losClientes == null) {
			losClientes = delegadoDeNegocio.findAllCliente();
		}
		return losClientes;
	}

	public void setLosClientes(List<Cliente> losClientes) {
		this.losClientes = losClientes;
	}

	public IDelegadoDeNegocio getDelegadoDeNegocio() {
		return delegadoDeNegocio;
	}

	public void setDelegadoDeNegocio(IDelegadoDeNegocio delegadoDeNegocio) {
		this.delegadoDeNegocio = delegadoDeNegocio;
	}

	public List<Cuenta> getLasCuentas() {
		return lasCuentas;
	}

	public void setLasCuentas(List<Cuenta> lasCuentas) {
		this.lasCuentas = lasCuentas;
	}

	public InputText getTxtClienteId() {
		return txtClienteId;
	}

	public void setTxtClienteId(InputText txtClienteId) {
		this.txtClienteId = txtClienteId;
	}

	public InputText getTxtClienteNombre() {
		return txtClienteNombre;
	}

	public void setTxtClienteNombre(InputText txtClienteNombre) {
		this.txtClienteNombre = txtClienteNombre;
	}

	public CommandButton getBtnCrearCuenta() {
		return btnCrearCuenta;
	}

	public void setBtnCrearCuenta(CommandButton btnCrearCuenta) {
		this.btnCrearCuenta = btnCrearCuenta;
	}

	public String getNombreUsuario() {
		Usuario usuario = (Usuario) FacesUtils.getfromSession("usuario");
		nombreUsuario = usuario.getNombre();
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

}
