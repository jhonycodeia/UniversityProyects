package co.edu.usbcali.banco.vista;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;

import org.primefaces.component.commandbutton.CommandButton;
import org.primefaces.component.inputtext.InputText;
import org.primefaces.component.password.Password;
import org.primefaces.component.selectonemenu.SelectOneMenu;

import co.edu.usbcali.banco.modelo.TipoDocumento;
import co.edu.usbcali.banco.modelo.TipoTransaccion;
import co.edu.usbcali.banco.modelo.TipoUsuario;
import co.edu.usbcali.banco.modelo.Transaccion;
import co.edu.usbcali.banco.modelo.Usuario;
import co.edu.usbcali.banco.util.FacesUtils;

@ManagedBean
@ViewScoped
public class AdministradorVista {

	@ManagedProperty("#{delegadoDeNegocio}")
	private IDelegadoDeNegocio delegadoDeNegocio;

	private String nombreUsuario;

	// tablas
	private List<Usuario> losUsuarios;
	private List<Transaccion> lasTransacciones;
	private List<TipoDocumento> losTipoDocumento;
	private List<TipoUsuario> losTipoUsuario;
	private List<TipoTransaccion> losTipoTransaccion;

	// usuarios propiedades
	private InputText txtId;
	private InputText txtIdentificacion;
	private InputText txtNombre;

	private Password txtClave1;
	private Password txtClave2;

	private SelectOneMenu somTipoUsuario;
	private SelectOneMenu somActivo;

	private CommandButton btnCrear;
	private CommandButton btnModificar;
	private CommandButton btnLimpiar;

	private List<SelectItem> losTipoUsuarioSelectItem;

	// Tipo documento propiedades

	private InputText txtNombreTipoDocumento;
	private SelectOneMenu somActivoTipoDocumento;

	private CommandButton btnCrearTipoDocumento;
	private CommandButton btnModificarTipoDocumento;
	private CommandButton btnLimpiarTipoDocumento;

	// Tipo usuario propiedades

	private InputText txtNombreTipoUsuario;
	private SelectOneMenu somActivoTipoUsuario;

	private CommandButton btnCrearTipoUsuario;
	private CommandButton btnModificarTipoUsuario;
	private CommandButton btnLimpiarTipoUsuario;
	
	//Tipo transaccion
	
	private InputText txtNombreTipoTransaccion;
	private SelectOneMenu somActivoTipoTransaccion;

	private CommandButton btnCrearTipoTransaccion;
	private CommandButton btnModificarTipoTransaccion;
	private CommandButton btnLimpiarTipoTransaccion;
	
	//Tipo transaccion metodo
	public void txtListenerTipoTransaccion() {

		try {

			String name = txtNombreTipoTransaccion.getValue().toString().trim().toUpperCase();

			TipoTransaccion tipoTransaccion= delegadoDeNegocio.findNameTipoTransaccion(name);

			if (tipoTransaccion == null) {
				somActivoTipoTransaccion.resetValue();

				btnCrearTipoTransaccion.setDisabled(false);
				btnModificarTipoTransaccion.setDisabled(true);
			} else {
				txtNombreTipoTransaccion.setValue(tipoTransaccion.getNombre());
				somActivoTipoTransaccion.setValue(tipoTransaccion.getActivo());

				btnCrearTipoTransaccion.setDisabled(true);
				btnModificarTipoTransaccion.setDisabled(false);

			}

		} catch (Exception e) {
			//
		}

	}
	
	public void limpiarTipoTransaccion() {
		txtNombreTipoTransaccion.resetValue();
		somActivoTipoTransaccion.resetValue();
		btnCrearTipoTransaccion.setDisabled(true);
		btnModificarTipoTransaccion.setDisabled(true);
	}
	
	public void createTipoTransaccion() {
		try {
			String name = txtNombreTipoTransaccion.getValue().toString().trim().toUpperCase();

			TipoTransaccion tipoTransaccion = new TipoTransaccion();

			tipoTransaccion.setNombre(name);
			tipoTransaccion.setActivo(somActivoTipoTransaccion.getValue().toString().charAt(0));

			delegadoDeNegocio.createTipoTransaccion(tipoTransaccion);

			FacesContext.getCurrentInstance().addMessage("",
					new FacesMessage(FacesMessage.SEVERITY_INFO, "El Tipo de Transaccion se creo exitosamente", ""));

			losTipoTransaccion = delegadoDeNegocio.findAllTipoTransaccion();

			limpiarTipoTransaccion();

		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage("",
					new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), ""));
		}
	}

	public void modificarTipoTransaccion() {
		try {
			String name = txtNombreTipoTransaccion.getValue().toString().trim().toUpperCase();

			TipoTransaccion tipoTransaccion = delegadoDeNegocio.findNameTipoTransaccion(name);

			tipoTransaccion.setActivo(somActivoTipoTransaccion.getValue().toString().charAt(0));

			delegadoDeNegocio.updateTipoTransaccion(tipoTransaccion);

			FacesContext.getCurrentInstance().addMessage("",
					new FacesMessage(FacesMessage.SEVERITY_INFO, "El Tipo de Transaccion se modifico exitosamente", ""));

			losTipoTransaccion = delegadoDeNegocio.findAllTipoTransaccion();

			limpiarTipoTransaccion();

		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage("",
					new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), ""));
		}
	}


	
	//Tipo usuario metodo
	public void txtListenerTipoUsuario() {

		try {

			String name = txtNombreTipoUsuario.getValue().toString().trim().toUpperCase();

			TipoUsuario tipoUsuario= delegadoDeNegocio.findNameTipoUsuario(name);

			if (tipoUsuario == null) {
				somActivoTipoUsuario.resetValue();

				btnCrearTipoUsuario.setDisabled(false);
				btnModificarTipoUsuario.setDisabled(true);
			} else {
				txtNombreTipoUsuario.setValue(tipoUsuario.getNombre());
				somActivoTipoUsuario.setValue(tipoUsuario.getActivo());

				btnCrearTipoUsuario.setDisabled(true);
				btnModificarTipoUsuario.setDisabled(false);

			}

		} catch (Exception e) {
			//
		}

	}

	public void limpiarTipoUsuario() {
		txtNombreTipoUsuario.resetValue();
		somActivoTipoUsuario.resetValue();
		
		btnCrearTipoUsuario.setDisabled(true);
		btnModificarTipoUsuario.setDisabled(true);
	}

	public void createTipoUsuario() {
		try {
			String name = txtNombreTipoUsuario.getValue().toString().trim().toUpperCase();

			TipoUsuario tipoUsuario = new TipoUsuario();

			tipoUsuario.setNombre(name);
			tipoUsuario.setActivo(somActivoTipoUsuario.getValue().toString().charAt(0));

			delegadoDeNegocio.createTipoUsuario(tipoUsuario);

			FacesContext.getCurrentInstance().addMessage("",
					new FacesMessage(FacesMessage.SEVERITY_INFO, "El Tipo de usuario se creo exitosamente", ""));

			losTipoUsuario = delegadoDeNegocio.findAllTipoUsuario();

			limpiarTipoUsuario();

		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage("",
					new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), ""));
		}
	}

	public void modificarTipoUsuario() {
		try {
			String name = txtNombreTipoUsuario.getValue().toString().trim().toUpperCase();

			TipoUsuario tipoUsuario = delegadoDeNegocio.findNameTipoUsuario(name);

			tipoUsuario.setActivo(somActivoTipoUsuario.getValue().toString().charAt(0));

			delegadoDeNegocio.updateTipoUsuario(tipoUsuario);

			FacesContext.getCurrentInstance().addMessage("",
					new FacesMessage(FacesMessage.SEVERITY_INFO, "El Tipo de usuario se modifico exitosamente", ""));

			losTipoUsuario = delegadoDeNegocio.findAllTipoUsuario();

			limpiarTipoUsuario();

		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage("",
					new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), ""));
		}
	}

	// Tipo documento metodo

	public void txtListenerTipoDocumento() {

		try {

			String name = txtNombreTipoDocumento.getValue().toString().trim().toUpperCase();

			TipoDocumento tipoDocumento = delegadoDeNegocio.findNameTipoDocumento(name);

			if (tipoDocumento == null) {
				somActivoTipoDocumento.resetValue();

				btnCrearTipoDocumento.setDisabled(false);
				btnModificarTipoDocumento.setDisabled(true);
			} else {
				txtNombreTipoDocumento.setValue(tipoDocumento.getNombre());
				somActivoTipoDocumento.setValue(tipoDocumento.getActivo());

				btnCrearTipoDocumento.setDisabled(true);
				btnModificarTipoDocumento.setDisabled(false);

			}

		} catch (Exception e) {
			//
		}

	}

	public void limpiarTipoDocumento() {
		txtNombreTipoDocumento.resetValue();
		somActivoTipoDocumento.resetValue();
		
		btnCrearTipoDocumento.setDisabled(true);
		btnModificarTipoDocumento.setDisabled(true);
	}

	public void createTipoDocumento() {
		try {
			String name = txtNombreTipoDocumento.getValue().toString().trim().toUpperCase();

			TipoDocumento tipoDocumento = new TipoDocumento();

			tipoDocumento.setNombre(name);
			tipoDocumento.setActivo(somActivoTipoDocumento.getValue().toString().charAt(0));

			delegadoDeNegocio.createTipoDocumento(tipoDocumento);

			FacesContext.getCurrentInstance().addMessage("",
					new FacesMessage(FacesMessage.SEVERITY_INFO, "El Tipo de documento se creo exitosamente", ""));

			losTipoDocumento = delegadoDeNegocio.findAllTipoDocumento();

			limpiarTipoDocumento();

		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage("",
					new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), ""));
		}
	}

	public void modificarTipoDocumento() {
		try {
			String name = txtNombreTipoDocumento.getValue().toString().trim().toUpperCase();

			TipoDocumento tipoDocumento = delegadoDeNegocio.findNameTipoDocumento(name);

			tipoDocumento.setActivo(somActivoTipoDocumento.getValue().toString().charAt(0));

			delegadoDeNegocio.updateTipoDocumento(tipoDocumento);

			FacesContext.getCurrentInstance().addMessage("",
					new FacesMessage(FacesMessage.SEVERITY_INFO, "El Tipo de documento se modifico exitosamente", ""));

			losTipoDocumento = delegadoDeNegocio.findAllTipoDocumento();

			limpiarTipoDocumento();

		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage("",
					new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), ""));
		}
	}

	// Usuario metodos
	public void limpiarAction() {

		btnCrear.setDisabled(true);
		btnModificar.setDisabled(true);

		txtId.resetValue();
		txtIdentificacion.resetValue();
		txtNombre.resetValue();

		somActivo.resetValue();
		somTipoUsuario.resetValue();

	}

	public void crearAction() {
		
		BigDecimal identificacion = null;
		try {
			identificacion = new BigDecimal(txtIdentificacion.getValue().toString().trim());
		} catch (Exception e) {
			identificacion = null;
		}
		try {
			
			String pass1 = txtClave1.getValue().toString();
			
			String pass2 = txtClave2.getValue().toString();
			
			if (pass1.equals(pass2)) {
				Usuario usuario = new Usuario();
				
				usuario.setUsuUsuario(txtId.getValue().toString().trim());
				
				usuario.setNombre(txtNombre.getValue().toString().trim());
				
				usuario.setActivo(somActivo.getValue().toString().charAt(0));
				
				usuario.setIdentificacion(identificacion);
				
				usuario.setClave(pass1);
				

				TipoUsuario tipoUsuario = delegadoDeNegocio
						.findTipoUsuario(new Long(somTipoUsuario.getValue().toString()));
				
				usuario.setTipoUsuario(tipoUsuario);
				
				delegadoDeNegocio.createUsuario(usuario);
				
				FacesContext.getCurrentInstance().addMessage("",
						new FacesMessage(FacesMessage.SEVERITY_INFO, "El Usuario se creo exitosamente ", ""));
				limpiarAction();

				losUsuarios = delegadoDeNegocio.findAllUsuario();
			}

			else {
				FacesContext.getCurrentInstance().addMessage("",
						new FacesMessage(FacesMessage.SEVERITY_ERROR, "Las constraseñas no coinciden", ""));
			}

		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage("",
					new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), ""));
		}

	}

	public void updateAction() {

		BigDecimal identificacion = null;
		try {
			identificacion = new BigDecimal(txtIdentificacion.getValue().toString().trim());
		} catch (Exception e) {
			identificacion = null;
		}
		try {

			
			String pass1 = txtClave1.getValue().toString();
			String pass2 = txtClave2.getValue().toString();

			Usuario usuario = delegadoDeNegocio.findUsuario(txtId.getValue().toString().trim());

			usuario.setNombre(txtNombre.getValue().toString().trim());
			usuario.setActivo(somActivo.getValue().toString().charAt(0));
			usuario.setIdentificacion(identificacion);

			TipoUsuario tipoUsuario = delegadoDeNegocio.findTipoUsuario(new Long(somTipoUsuario.getValue().toString()));

			usuario.setTipoUsuario(tipoUsuario);

			if (pass1.isEmpty() && pass2.isEmpty()) {

				delegadoDeNegocio.updateUsuario(usuario);

				FacesContext.getCurrentInstance().addMessage("",
						new FacesMessage(FacesMessage.SEVERITY_INFO, "El Usuario se actualizo exitosamente", ""));
			}

			else if (pass1.equals(pass2)) {
				usuario.setClave(pass1);

				delegadoDeNegocio.updateUsuario(usuario);

				FacesContext.getCurrentInstance().addMessage("",
						new FacesMessage(FacesMessage.SEVERITY_INFO, "El Usuario se actualizo exitosamente", ""));
			}

			else {
				FacesContext.getCurrentInstance().addMessage("",
						new FacesMessage(FacesMessage.SEVERITY_ERROR, "Las constraseñas no coinciden", ""));
			}

			losUsuarios = delegadoDeNegocio.findAllUsuario();

		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage("",
					new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), ""));
		}

	}

	public void txtIdListener() {
		try {

			Usuario usuario = delegadoDeNegocio.findUsuario(txtId.getValue().toString().trim());

			if (usuario == null) {
				btnCrear.setDisabled(false);
				btnModificar.setDisabled(true);

				txtIdentificacion.resetValue();
				txtNombre.resetValue();

				somActivo.resetValue();
				somTipoUsuario.resetValue();

			} else {
				btnCrear.setDisabled(true);
				btnModificar.setDisabled(false);

				txtIdentificacion.setValue(usuario.getIdentificacion());
				txtNombre.setValue(usuario.getNombre());
				txtClave1.setValue(usuario.getClave());
				txtClave2.setValue(usuario.getClave());

				somActivo.setValue(usuario.getActivo());
				;
				somTipoUsuario.setValue(usuario.getTipoUsuario().getTiusId());
				;
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	// binding
	public List<SelectItem> getLosTipoUsuarioSelectItem() {
		if (losTipoUsuarioSelectItem == null) {
			losTipoUsuarioSelectItem = new ArrayList<>();
			List<TipoUsuario> losTipoUsuario = delegadoDeNegocio.findAllTipoUsuario();
			for (TipoUsuario tipoUsuario : losTipoUsuario) {
				losTipoUsuarioSelectItem.add(new SelectItem("" + tipoUsuario.getTiusId(), tipoUsuario.getNombre()));
			}
		}
		return losTipoUsuarioSelectItem;
	}

	public void setLosTipoUsuarioSelectItem(List<SelectItem> losTipoUsuarioSelectItem) {
		this.losTipoUsuarioSelectItem = losTipoUsuarioSelectItem;
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

	public SelectOneMenu getSomTipoUsuario() {
		return somTipoUsuario;
	}

	public void setSomTipoUsuario(SelectOneMenu somTipoUsuario) {
		this.somTipoUsuario = somTipoUsuario;
	}

	public SelectOneMenu getSomActivo() {
		return somActivo;
	}

	public void setSomActivo(SelectOneMenu somActivo) {
		this.somActivo = somActivo;
	}

	public InputText getTxtId() {
		return txtId;
	}

	public void setTxtId(InputText txtId) {
		this.txtId = txtId;
	}

	public InputText getTxtIdentificacion() {
		return txtIdentificacion;
	}

	public void setTxtIdentificacion(InputText txtIdentificacion) {
		this.txtIdentificacion = txtIdentificacion;
	}

	public InputText getTxtNombre() {
		return txtNombre;
	}

	public void setTxtNombre(InputText txtNombre) {
		this.txtNombre = txtNombre;
	}

	public IDelegadoDeNegocio getDelegadoDeNegocio() {
		return delegadoDeNegocio;
	}

	public void setDelegadoDeNegocio(IDelegadoDeNegocio delegadoDeNegocio) {
		this.delegadoDeNegocio = delegadoDeNegocio;
	}

	public List<Usuario> getLosUsuarios() {
		if (losUsuarios == null) {
			losUsuarios = delegadoDeNegocio.findAllUsuario();
		}
		return losUsuarios;
	}

	public void setLosUsuarios(List<Usuario> losUsuarios) {
		this.losUsuarios = losUsuarios;
	}

	public Password getTxtClave1() {
		return txtClave1;
	}

	public void setTxtClave1(Password txtClave1) {
		this.txtClave1 = txtClave1;
	}

	public Password getTxtClave2() {
		return txtClave2;
	}

	public void setTxtClave2(Password txtClave2) {
		this.txtClave2 = txtClave2;
	}

	public String getNombreUsuario() {
		Usuario usuario = (Usuario) FacesUtils.getfromSession("usuario");
		nombreUsuario = usuario.getNombre();
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public List<Transaccion> getLasTransacciones() {
		if (lasTransacciones == null)
			lasTransacciones = delegadoDeNegocio.findAllTransaccion();
		return lasTransacciones;
	}

	public void setLasTransacciones(List<Transaccion> lasTransacciones) {
		this.lasTransacciones = lasTransacciones;
	}

	public List<TipoDocumento> getLosTipoDocumento() {
		if (losTipoDocumento == null)
			losTipoDocumento = delegadoDeNegocio.findAllTipoDocumento();
		return losTipoDocumento;
	}

	public void setLosTipoDocumento(List<TipoDocumento> losTipoDocumento) {
		this.losTipoDocumento = losTipoDocumento;
	}

	public SelectOneMenu getSomActivoTipoDocumento() {
		return somActivoTipoDocumento;
	}

	public void setSomActivoTipoDocumento(SelectOneMenu somActivoTipoDocumento) {
		this.somActivoTipoDocumento = somActivoTipoDocumento;
	}

	public InputText getTxtNombreTipoDocumento() {
		return txtNombreTipoDocumento;
	}

	public void setTxtNombreTipoDocumento(InputText txtNombreTipoDocumento) {
		this.txtNombreTipoDocumento = txtNombreTipoDocumento;
	}

	public CommandButton getBtnCrearTipoDocumento() {
		return btnCrearTipoDocumento;
	}

	public void setBtnCrearTipoDocumento(CommandButton btnCrearTipoDocumento) {
		this.btnCrearTipoDocumento = btnCrearTipoDocumento;
	}

	public CommandButton getBtnModificarTipoDocumento() {
		return btnModificarTipoDocumento;
	}

	public void setBtnModificarTipoDocumento(CommandButton btnModificarTipoDocumento) {
		this.btnModificarTipoDocumento = btnModificarTipoDocumento;
	}

	public CommandButton getBtnLimpiarTipoDocumento() {
		return btnLimpiarTipoDocumento;
	}

	public void setBtnLimpiarTipoDocumento(CommandButton btnLimpiarTipoDocumento) {
		this.btnLimpiarTipoDocumento = btnLimpiarTipoDocumento;
	}

	public List<TipoUsuario> getLosTipoUsuario() {
		if (losTipoUsuario == null)
			losTipoUsuario = delegadoDeNegocio.findAllTipoUsuario();
		return losTipoUsuario;
	}

	public void setLosTipoUsuario(List<TipoUsuario> losTipoUsuario) {
		this.losTipoUsuario = losTipoUsuario;
	}

	public InputText getTxtNombreTipoUsuario() {
		return txtNombreTipoUsuario;
	}

	public void setTxtNombreTipoUsuario(InputText txtNombreTipoUsuario) {
		this.txtNombreTipoUsuario = txtNombreTipoUsuario;
	}

	public SelectOneMenu getSomActivoTipoUsuario() {
		return somActivoTipoUsuario;
	}

	public void setSomActivoTipoUsuario(SelectOneMenu somActivoTipoUsuario) {
		this.somActivoTipoUsuario = somActivoTipoUsuario;
	}

	public CommandButton getBtnModificarTipoUsuario() {
		return btnModificarTipoUsuario;
	}

	public void setBtnModificarTipoUsuario(CommandButton btnModificarTipoUsuario) {
		this.btnModificarTipoUsuario = btnModificarTipoUsuario;
	}

	public CommandButton getBtnLimpiarTipoUsuario() {
		return btnLimpiarTipoUsuario;
	}

	public void setBtnLimpiarTipoUsuario(CommandButton btnLimpiarTipoUsuario) {
		this.btnLimpiarTipoUsuario = btnLimpiarTipoUsuario;
	}

	public CommandButton getBtnCrearTipoUsuario() {
		return btnCrearTipoUsuario;
	}

	public void setBtnCrearTipoUsuario(CommandButton btnCrearTipoUsuario) {
		this.btnCrearTipoUsuario = btnCrearTipoUsuario;
	}

	public List<TipoTransaccion> getLosTipoTransaccion() {
		if(losTipoTransaccion==null)
			losTipoTransaccion = delegadoDeNegocio.findAllTipoTransaccion();
		return losTipoTransaccion;
	}

	public void setLosTipoTransaccion(List<TipoTransaccion> losTipoTransaccion) {
		this.losTipoTransaccion = losTipoTransaccion;
	}

	public InputText getTxtNombreTipoTransaccion() {
		return txtNombreTipoTransaccion;
	}

	public void setTxtNombreTipoTransaccion(InputText txtNombreTipoTransaccion) {
		this.txtNombreTipoTransaccion = txtNombreTipoTransaccion;
	}

	public SelectOneMenu getSomActivoTipoTransaccion() {
		return somActivoTipoTransaccion;
	}

	public void setSomActivoTipoTransaccion(SelectOneMenu somActivoTipoTransaccion) {
		this.somActivoTipoTransaccion = somActivoTipoTransaccion;
	}

	public CommandButton getBtnCrearTipoTransaccion() {
		return btnCrearTipoTransaccion;
	}

	public void setBtnCrearTipoTransaccion(CommandButton btnCrearTipoTransaccion) {
		this.btnCrearTipoTransaccion = btnCrearTipoTransaccion;
	}

	public CommandButton getBtnModificarTipoTransaccion() {
		return btnModificarTipoTransaccion;
	}

	public void setBtnModificarTipoTransaccion(CommandButton btnModificarTipoTransaccion) {
		this.btnModificarTipoTransaccion = btnModificarTipoTransaccion;
	}

	public CommandButton getBtnLimpiarTipoTransaccion() {
		return btnLimpiarTipoTransaccion;
	}

	public void setBtnLimpiarTipoTransaccion(CommandButton btnLimpiarTipoTransaccion) {
		this.btnLimpiarTipoTransaccion = btnLimpiarTipoTransaccion;
	}

}
