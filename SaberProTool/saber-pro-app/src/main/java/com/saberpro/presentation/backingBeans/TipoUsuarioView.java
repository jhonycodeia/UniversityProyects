package com.saberpro.presentation.backingBeans;

import org.primefaces.component.commandbutton.CommandButton;
import org.primefaces.component.inputtext.InputText;
import org.primefaces.component.inputtextarea.InputTextarea;
import org.primefaces.component.selectonemenu.SelectOneMenu;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.saberpro.modelo.TipoUsuario;
import com.saberpro.modelo.Usuario;
import com.saberpro.modelo.dto.TipoUsuarioDTO;
import com.saberpro.presentation.businessDelegate.IBusinessDelegatorView;
import com.saberpro.utilities.Constantes;
import com.saberpro.utilities.FacesUtils;

import java.io.Serializable;

import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

/**
 * @author Zathura Code Generator http://zathuracode.org/ www.zathuracode.org
 *
 */
@ManagedBean
@ViewScoped
public class TipoUsuarioView implements Serializable {
	private static final long serialVersionUID = 1L;
	private static final Logger log = LoggerFactory.getLogger(TipoUsuarioView.class);

	// Variable encargada de indicar si se va crear un tipo de usuario o actualizar
	// para habilitar los botones
	private boolean crear = true;

	// Variable que se realiza un binding con tipoUsuario.xhtml para guardar el la
	// descripcion tipo de usuario
	private InputTextarea txtDescripcion;

	// Variable que se realiza un binding con tipoUsuario.xhtml para guardar el la
	// nombre del tipo de usuario
	private InputText txtNombre;

	// Variable que se realiza un binding con tipoUsuario.xhtml para boton de las
	// acciones de guardar
	private CommandButton btnSave;

	// Variable que se realiza un binding con tipoUsuario.xhtml para boton de las
	// acciones de actualizar
	private CommandButton btnModify;

	// Variable que se realiza un binding con tipoUsuario.xhtml para boton de las
	// acciones de limpiar
	private CommandButton btnClear;

	// Variable que se realiza un binding con tipoUsuario.xhtml para guarda de los
	// estados de activo del tipo de usuario
	private SelectOneMenu somActivo;

	// Variable que se realiza un value con tipoUsuario.xhtml mostrar los datos del
	// datatable
	private List<TipoUsuario> data;

	// Instancia de tipo de usuario con la que se opera
	private TipoUsuario entity;

	//Delegado de negocio encargado de llamar a toda la logica
	@ManagedProperty(value = "#{BusinessDelegatorView}")
	private IBusinessDelegatorView businessDelegatorView;

	public TipoUsuarioView() {
		super();
	}
	
    /**
    *
    * Metodo encargado de actualizar el formulario para actualizar un tipo usuario
    *
    * @param nombre String nombre del tipo de usuario    
    */ 
	public void editar_action(String nombre) {
		//Modifica el campo de nombre del tipo de usuaro
		txtNombre.setValue(nombre);
		//Consulta y llena el formulario con los datos de ese tipo de usuario
		listener_txtId();
	}
	
   /**
    *
    * Metodo encargado consultar si existe un tipo de usuario y llenar el formulario
    */ 
	public void listener_txtId() {
		try {
			//Toma el nombre del tipo de usuario del input
			String nombre = txtNombre.getValue().toString().trim();
			//Consulta en base de datos si existe ese tipo de usuario
			entity = businessDelegatorView.findByNombreTipoUsuario(nombre);

		} catch (Exception e) {
			//Si no existe la instancia se redefine a null
			entity = null;
		}
		//En caso que no exista ese tipo de usuario
		if (entity == null) {
			//habilita la accion de crear en la vista
			crear = true;
			//reinicia los valores de los campos
			txtDescripcion.resetValue();
			somActivo.resetValue();
			//desabilita los botones
			btnSave.setDisabled(false);
			btnModify.setDisabled(true);

		} else {
			//En caso que exista el tipo de usuario
			//habilita la accion de actualizar
			crear = false;
			//setea los campos con los datos que correcponde
			txtNombre.setValue(entity.getNombre());
			txtDescripcion.setValue(entity.getDescripcion());
			somActivo.setValue(entity.getActivo());
			//desabilita los botonws
			btnSave.setDisabled(true);
			btnModify.setDisabled(false);
		}
		//valida los campos cumple con los requisitos
		action_validar();
	}
	
	/**
    *
    * Metodo encargado de actualizar el formulario para actualizar un tipo usuario
    *
    * @param input commandBurron boton el cual se va verificar para activarlo si cumple las validaciones    
    */ 
	public void verificar(CommandButton input) {
		try {
			//Validacion de nombre vacio
			if (FacesUtils.checkString(txtNombre).isEmpty())
				input.setDisabled(true);
			//Validacion de activo este selecionado
			if (FacesUtils.checkString(somActivo) == null)
				input.setDisabled(true);

		} catch (Exception e) {
			log.error("Error validando el boton "+e.getMessage(),e);
		}

	}
	
	/**
    *
    * Metodo encargado de activar el boton de accion dependiendo la accion a realizar y si cumple los requisitos
    */ 
	public void action_validar() {
		//Se activa el boton crear
		if (crear) {
			btnSave.setDisabled(false);
			verificar(btnSave);
		} 
		//Se activa el boton actualizar
		else {
			btnModify.setDisabled(false);
			verificar(btnModify);
		}

	}
	/**
    *
    * Metodo encargado de limpiar la pantalla
    */ 
	public String action_clear() {

		entity = null;

		btnSave.setDisabled(true);
		btnModify.setDisabled(true);
		txtDescripcion.resetValue();
		txtNombre.resetValue();
		somActivo.resetValue();

		return "";
	}
	
	/**
    *
    * Metodo encargado de crear un tipo de usuarip
    */ 
	public String action_create() {
		try {
			//Se toma el usuario en session
			Usuario usuario = (Usuario) FacesUtils.getfromSession("usuario");
			//Se verifica que este definido
			if (usuario != null) {
				//Se instancia el tipo de usuario
				entity = new TipoUsuario();
				//Se le setean los campos
				entity.setDescripcion(FacesUtils.checkString(txtDescripcion));
				entity.setNombre(FacesUtils.checkString(txtNombre).toUpperCase());
				entity.setActivo(FacesUtils.checkString(somActivo));
				entity.setFechaCreacion(new Date());
				entity.setUsuCreador(usuario.getIdUsuario());
				//Se crear el tipo de usuario
				businessDelegatorView.saveTipoUsuario(entity);
				//Se setean la lista de tipo de usuario del datatable
				data = null;
				//Se limpia la vista y se indica mensaje exito 
				FacesUtils.addInfoMessage("Se guardó exitosamente el tipo de usuario");
				action_clear();

			}

		} catch (Exception e) {
			entity = null;
			FacesUtils.addErrorMessage(e.getMessage());
			log.error("Error creando el tipo de usuario "+e.getMessage(),e);
		}

		return "";
	}

	/**
    *
    * Metodo encargado de actualizar un tipo de usuario
    */ 
	public String action_modify() {

		try {
			//Se toma el usuario en session y se el nombre del tipo de usuario
			Usuario usuario = (Usuario) FacesUtils.getfromSession("usuario");
			String nombre = FacesUtils.checkString(txtNombre);
			//Se verifica que el usuario exista
			if (usuario != null) {
				//Se consulta ese tipo de usuario
				entity = businessDelegatorView.findByNombreTipoUsuario(nombre);
				//se setean los campos
				entity.setDescripcion(FacesUtils.checkString(txtDescripcion));
				entity.setNombre(FacesUtils.checkString(txtNombre).toUpperCase());
				entity.setActivo(FacesUtils.checkString(somActivo));
				entity.setFechaModificacion(new Date());
				entity.setUsuModificador(usuario.getIdUsuario());
				//se actualiza
				businessDelegatorView.updateTipoUsuario(entity);
				//Se setean la lista de tipo de usuario del datatable
				data = null;
				//Se limpia la vista y se indica mensaje exito 
				FacesUtils.addInfoMessage("Se actualizó exitosamente el tipo de usuario");
				action_clear();

			}

		} catch (Exception e) {
			entity = null;
			FacesUtils.addErrorMessage(e.getMessage());
			log.error("Error actualizando el tipo de usuario "+e.getMessage(),e);
		}

		return "";
	}

	// Getter and Setter
	public InputTextarea getTxtDescripcion() {
		return txtDescripcion;
	}

	public void setTxtDescripcion(InputTextarea txtDescripcion) {
		this.txtDescripcion = txtDescripcion;
	}

	public InputText getTxtNombre() {
		return txtNombre;
	}

	public void setTxtNombre(InputText txtNombre) {
		this.txtNombre = txtNombre;
	}

	public List<TipoUsuario> getData() {
		try {
			if (data == null) {
				Object[] variable = {"activo",true,Constantes.ESTADO_ASIGNADO,"<>"};
				data = businessDelegatorView.findByCriteriaInTipoUsuario(variable, null,null);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return data;
	}

	public void setData(List<TipoUsuario> tipoUsuario) {
		this.data = tipoUsuario;
	}

	public CommandButton getBtnSave() {
		return btnSave;
	}

	public void setBtnSave(CommandButton btnSave) {
		this.btnSave = btnSave;
	}

	public CommandButton getBtnModify() {
		return btnModify;
	}

	public void setBtnModify(CommandButton btnModify) {
		this.btnModify = btnModify;
	}

	public CommandButton getBtnClear() {
		return btnClear;
	}

	public void setBtnClear(CommandButton btnClear) {
		this.btnClear = btnClear;
	}

	public IBusinessDelegatorView getBusinessDelegatorView() {
		return businessDelegatorView;
	}

	public void setBusinessDelegatorView(IBusinessDelegatorView businessDelegatorView) {
		this.businessDelegatorView = businessDelegatorView;
	}

	public SelectOneMenu getSomActivo() {
		return somActivo;
	}

	public void setSomActivo(SelectOneMenu somActivo) {
		this.somActivo = somActivo;
	}
}
