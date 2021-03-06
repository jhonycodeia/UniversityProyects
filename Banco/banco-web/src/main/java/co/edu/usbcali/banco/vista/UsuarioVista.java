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

import co.edu.usbcali.banco.modelo.TipoUsuario;
import co.edu.usbcali.banco.modelo.Usuario;

@ManagedBean
@ViewScoped
public class UsuarioVista {
	
	@ManagedProperty("#{delegadoDeNegocio}")
	private IDelegadoDeNegocio delegadoDeNegocio;
	
	private List<Usuario> losUsuarios;
	
	private InputText txtId;
	private InputText txtClave;
	private InputText txtIdentificacion;
	private InputText txtNombre;
	
	private SelectOneMenu somTipoUsuario;
	private SelectOneMenu somActivo;
	
	private CommandButton btnCrear;
	private CommandButton btnModificar;
	private CommandButton btnBorrar;
	private CommandButton btnLimpiar;
	
	private List<SelectItem> losTipoUsuarioSelectItem;
	
public  void limpiarAction(){
		
		btnCrear.setDisabled(true);
		btnModificar.setDisabled(true);
		btnBorrar.setDisabled(true);
		
		txtId.resetValue();
		txtIdentificacion.resetValue();
		txtClave.resetValue();
		txtNombre.resetValue();		
		
		somActivo.resetValue();
		somTipoUsuario.resetValue();		
		
	}

public  void crearAction(){
	
	try {
		
		Usuario usuario = new Usuario();
		
		usuario.setUsuUsuario(txtId.getValue().toString().trim());
		usuario.setNombre(txtNombre.getValue().toString().trim());
		usuario.setActivo(somActivo.getValue().toString().charAt(0));
		usuario.setIdentificacion(new BigDecimal(txtIdentificacion.getValue().toString().trim()));
		usuario.setClave(txtClave.getValue().toString());		
		
		TipoUsuario tipoUsuario = delegadoDeNegocio.findTipoUsuario(
									  new Long(somTipoUsuario.getValue().toString()));
		
		usuario.setTipoUsuario(tipoUsuario);
		
		delegadoDeNegocio.createUsuario(usuario);
		
		FacesContext.getCurrentInstance().addMessage("",
				new FacesMessage(FacesMessage.SEVERITY_INFO,
											  "El Usuario se creo exitosamente",
											  ""));
		limpiarAction();
		
	} catch (Exception e) {
		FacesContext.getCurrentInstance().addMessage("",
				new FacesMessage(FacesMessage.SEVERITY_ERROR,
											  e.getMessage(),
											  ""));
	}	
	
}

public  void updateAction(){
	
	try {
		
		Usuario usuario = new Usuario();
		
		usuario.setUsuUsuario(txtId.getValue().toString().trim());
		usuario.setNombre(txtNombre.getValue().toString().trim());
		usuario.setActivo(somActivo.getValue().toString().charAt(0));
		usuario.setIdentificacion(new BigDecimal(txtIdentificacion.getValue().toString().trim()));
		usuario.setClave(txtClave.getValue().toString());
		
		TipoUsuario tipoUsuario = delegadoDeNegocio.findTipoUsuario(new Long(somTipoUsuario.getValue().toString()));
				
		usuario.setTipoUsuario(tipoUsuario);
		
		delegadoDeNegocio.updateUsuario(usuario);
		
		FacesContext.getCurrentInstance().addMessage("",
				new FacesMessage(FacesMessage.SEVERITY_INFO,
											  "El Usuario se actualizo exitosamente",
											  ""));
		
		
	} catch (Exception e) {
		FacesContext.getCurrentInstance().addMessage("",
				new FacesMessage(FacesMessage.SEVERITY_ERROR,
											  e.getMessage(),
											  ""));
	}	
	
}

public  void deleteAction(){
	
	try {		
		
		delegadoDeNegocio.deleteUsuario(txtId.getValue().toString().trim());
		
		FacesContext.getCurrentInstance().addMessage("",
				new FacesMessage(FacesMessage.SEVERITY_INFO,
											  "El usuario se borro exitosamente",
											  ""));
		limpiarAction();
		
	} catch (Exception e) {
		FacesContext.getCurrentInstance().addMessage("",
				new FacesMessage(FacesMessage.SEVERITY_ERROR,
											  e.getMessage(),
											  ""));
	}	
	
}
	
	public void txtIdListener(){
		try {		
			
			Usuario usuario = delegadoDeNegocio.findUsuario(txtId.getValue().toString().trim());
			
			if(usuario==null){
				btnCrear.setDisabled(false);
				btnModificar.setDisabled(true);
				btnBorrar.setDisabled(true);
				
				txtClave.resetValue();
				txtIdentificacion.resetValue();
				txtNombre.resetValue();				
				
				somActivo.resetValue();
				somTipoUsuario.resetValue();
				
			}else{
				btnCrear.setDisabled(true);
				btnModificar.setDisabled(false);
				btnBorrar.setDisabled(false);
				
				txtClave.setValue(usuario.getClave());
				txtIdentificacion.setValue(usuario.getIdentificacion());
				txtNombre.setValue(usuario.getNombre());				
				
				somActivo.setValue(usuario.getActivo());;
				somTipoUsuario.setValue(usuario.getTipoUsuario().getTiusId());;
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public List<SelectItem> getLosTipoUsuarioSelectItem() {
		if(losTipoUsuarioSelectItem==null){
			losTipoUsuarioSelectItem=new ArrayList<>();
			List<TipoUsuario> losTipoUsuario = delegadoDeNegocio.findAllTipoUsuario();
			for (TipoUsuario tipoUsuario : losTipoUsuario) {
				losTipoUsuarioSelectItem.add(new SelectItem(""+tipoUsuario.getTiusId(), tipoUsuario.getNombre()));
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

	public CommandButton getBtnBorrar() {
		return btnBorrar;
	}

	public void setBtnBorrar(CommandButton btnBorrar) {
		this.btnBorrar = btnBorrar;
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

	public InputText getTxtClave() {
		return txtClave;
	}

	public void setTxtClave(InputText txtClave) {
		this.txtClave = txtClave;
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
		if(losUsuarios == null) {
			losUsuarios = delegadoDeNegocio.findAllUsuario();
		}
		return losUsuarios;
	}

	public void setLosUsuarios(List<Usuario> losUsuarios) {
		this.losUsuarios = losUsuarios;
	}
	

	


}
