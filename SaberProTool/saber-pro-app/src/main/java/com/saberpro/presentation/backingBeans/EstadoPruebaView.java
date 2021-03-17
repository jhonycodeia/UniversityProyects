package com.saberpro.presentation.backingBeans;

import com.saberpro.exceptions.*;

import com.saberpro.modelo.*;
import com.saberpro.modelo.dto.EstadoPruebaDTO;

import com.saberpro.presentation.businessDelegate.*;

import com.saberpro.utilities.*;

import org.primefaces.component.calendar.*;
import org.primefaces.component.commandbutton.CommandButton;
import org.primefaces.component.inputtext.InputText;
import org.primefaces.component.inputtextarea.InputTextarea;
import org.primefaces.component.selectonemenu.SelectOneMenu;
import org.primefaces.event.RowEditEvent;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Serializable;

import java.sql.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.TimeZone;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

/**
 * @author Zathura Code Generator http://zathuracode.org/ www.zathuracode.org
 *
 */
@ManagedBean
@ViewScoped
public class EstadoPruebaView implements Serializable {
	private static final long serialVersionUID = 1L;
	private static final Logger log = LoggerFactory.getLogger(EstadoPruebaView.class);

	private boolean crear = true;

	private InputTextarea txtDescripcion;
	private InputText txtNombre;

	private CommandButton btnSave;
	private CommandButton btnModify;
	private CommandButton btnClear;

	private SelectOneMenu somActivo;

	private List<EstadoPruebaDTO> data;

	private EstadoPruebaDTO selectedEstadoPrueba;

	private EstadoPrueba entity;

	private boolean showDialog;

	@ManagedProperty(value = "#{BusinessDelegatorView}")
	private IBusinessDelegatorView businessDelegatorView;

	public EstadoPruebaView() {
		super();
	}

	public void editar_action(String nombre) {

		txtNombre.setValue(nombre);
		listener_txtId();
	}

	public void listener_txtId() {
		try {
			String nombre = txtNombre.getValue().toString().trim();

			entity = businessDelegatorView.findByNombreEstadoPrueba(nombre);

		} catch (Exception e) {
			entity = null;
		}

		if (entity == null) {

			crear = true;

			txtDescripcion.resetValue();
			somActivo.resetValue();

			btnSave.setDisabled(false);
			btnModify.setDisabled(true);

		} else {

			crear = false;

			txtNombre.setValue(entity.getNombre());
			txtDescripcion.setValue(entity.getDescripcion());
			somActivo.setValue(entity.getActivo());

			btnSave.setDisabled(true);
			btnModify.setDisabled(false);
		}
		action_validar();
	}

	public void verificar(CommandButton input) {
		try {
			if (FacesUtils.checkString(txtNombre).isEmpty())
				input.setDisabled(true);
			if (FacesUtils.checkString(somActivo) == null)
				input.setDisabled(true);

		} catch (Exception e) {
			log.debug(e.getMessage());
		}

	}
	
	public void action_validar() {
    	
    	if(crear) {
    		btnSave.setDisabled(false);
        	verificar(btnSave); 
    	}
    	else {
    		btnModify.setDisabled(false);
    		verificar(btnModify); 
    	}
    	   	
    }
	
	//Limpiar pantalla
	public String action_clear() {

		entity = null;
		selectedEstadoPrueba = null;

		btnSave.setDisabled(true);
		btnModify.setDisabled(true);
		txtDescripcion.resetValue();
		txtNombre.resetValue();
		somActivo.resetValue();

		return "";
	}
	
	//Creacón de estados de la prueba
	public String action_create() {
		try {
			//Se valida la sesión del usuario
			Usuario usuario = (Usuario) FacesUtils.getfromSession("usuario");

			if (usuario != null) {
				
				//instancia de un nuevo estado
				entity = new EstadoPrueba();
				
				//Se hidrata el objeto estado
				entity.setDescripcion(FacesUtils.checkString(txtDescripcion));
				entity.setNombre(FacesUtils.checkString(txtNombre).toUpperCase());
				entity.setActivo(FacesUtils.checkString(somActivo));
				entity.setFechaCreacion(new Date());
				entity.setUsuCreador(usuario.getIdUsuario());
				
				//Se crea el nuevo estado
				businessDelegatorView.saveEstadoPrueba(entity);

				data = null;

				FacesUtils.addInfoMessage("Se guardó exitosamente el estado de la prueba");
				action_clear();

			}

		} catch (Exception e) {
			entity = null;
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	//método para modificar un estado creado
	public String action_modify() {

		try {
			Usuario usuario = (Usuario) FacesUtils.getfromSession("usuario");
			String nombre = FacesUtils.checkString(txtNombre);
			
			//Se valida que haya un usuario logeado
			if (usuario != null) {
				
				//Se consulta el estado a modificar
				entity = businessDelegatorView.findByNombreEstadoPrueba(nombre);
				
				//Se actualizan los datos del estado
				entity.setDescripcion(FacesUtils.checkString(txtDescripcion));
				entity.setNombre(FacesUtils.checkString(txtNombre).toUpperCase());
				entity.setActivo(FacesUtils.checkString(somActivo));
				entity.setFechaModificacion(new Date());
				entity.setUsuModificador(usuario.getIdUsuario());

				//se actualiza el estado
				businessDelegatorView.updateEstadoPrueba(entity);

				data = null;

				FacesUtils.addInfoMessage("Se actualizó exitosamente el estado de la prueba");
				action_clear();

			}

		} catch (Exception e) {
			entity = null;
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

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

	public List<EstadoPruebaDTO> getData() {
		try {
			if (data == null) {
				data = businessDelegatorView.getDataEstadoPrueba();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return data;
	}

	public void setData(List<EstadoPruebaDTO> estadoPruebaDTO) {
		this.data = estadoPruebaDTO;
	}

	public EstadoPruebaDTO getSelectedEstadoPrueba() {
		return selectedEstadoPrueba;
	}

	public void setSelectedEstadoPrueba(EstadoPruebaDTO estadoPrueba) {
		this.selectedEstadoPrueba = estadoPrueba;
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

	public TimeZone getTimeZone() {
		return java.util.TimeZone.getDefault();
	}

	public IBusinessDelegatorView getBusinessDelegatorView() {
		return businessDelegatorView;
	}

	public void setBusinessDelegatorView(IBusinessDelegatorView businessDelegatorView) {
		this.businessDelegatorView = businessDelegatorView;
	}

	public boolean isShowDialog() {
		return showDialog;
	}

	public void setShowDialog(boolean showDialog) {
		this.showDialog = showDialog;
	}

	public SelectOneMenu getSomActivo() {
		return somActivo;
	}

	public void setSomActivo(SelectOneMenu somActivo) {
		this.somActivo = somActivo;
	}
}
