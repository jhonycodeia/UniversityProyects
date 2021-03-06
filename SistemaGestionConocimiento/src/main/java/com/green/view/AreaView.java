package com.green.view;

import com.green.dto.AreaDTO;
import com.green.dto.TipoUsuarioDTO;
import com.green.exception.*;

import com.green.modelo.*;

import com.green.utility.*;

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
 * @author Zathura Code Generator http://zathuracode.org/
 * www.zathuracode.org
 *
 */
@ManagedBean
@ViewScoped
public class AreaView implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final Logger log = LoggerFactory.getLogger(AreaView.class);
    
    private boolean crear = true;

   	private InputTextarea txtDescripcion;
   	private InputText txtNombre;

   	private CommandButton btnSave;
   	private CommandButton btnModify;

   	private SelectOneMenu somActivo;

   	private List<AreaDTO> data;

   	private Area entity;
   	
    @ManagedProperty(value = "#{businessDelegator}")
    private BusinessDelegator businessDelegatorView;

    public AreaView() {
        super();
    }

    public void listener_txtId() {
		try {
			// Se obtiene el contenido del txtNombre
			String nombre = txtNombre.getValue().toString().trim().toUpperCase();

			// se consulta la categoria por nombre
			Object[] variable = { "nombre", true, nombre, "=" };
			entity = (Area) businessDelegatorView.findByCriteriaInArea(variable, null, null).get(0);

		} catch (Exception e) {
			//log.debug(e.getMessage(), e);
			entity = null;
		}

		// Si no hay ninguna categoria por ese nombre se habilitan y deshabilitan los
		// campos de abajo
		if (entity == null) {
			crear = true;
			txtDescripcion.resetValue();
			somActivo.resetValue();
			btnSave.setDisabled(false);
			btnModify.setDisabled(true);
			// si se encuentra una categoria con ese nombre, se setean los valores de la
			// facultad en los campos de la vista
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
	
	//Metodo para crear una categoria
	public String action_create() {
		try {
			//Usuario usuario = (Usuario) FacesUtils.getfromSession("usuario");
			
			//validar usuario en seccion
			if (true) {
				
				//Se instancia una nueva categoria
				entity = new Area();
				
				//Se hidrata la instancia de facultad con los datos de abajo
				entity.setDescripcion(FacesUtils.checkString(txtDescripcion));
				entity.setNombre(FacesUtils.checkString(txtNombre).toUpperCase());
				entity.setActivo(FacesUtils.checkString(somActivo));
				entity.setFechaCreacion(new Date());
				entity.setUsuCreador(0L);
				
				//se guarda la nueva categoria
				businessDelegatorView.saveArea(entity);

				data = null;				
				
				FacesUtils.addInfoMessage("Se guardó exitosamente la Area");
				//se limpian los datos
				action_clear();

			}

		} catch (Exception e) {
			entity = null;
			log.debug(e.getMessage(), e);
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}
	
	//método para modificar una categoria
		public String action_modify() {

			try {
				
				//Usuario usuario = (Usuario) FacesUtils.getfromSession("usuario");
				String nombre = FacesUtils.checkString(txtNombre);

				if (true) {
					//se consulta la facultad por nombre
					Object[] variable = { "nombre", true, nombre, "=" };
					entity = (Area) businessDelegatorView.findByCriteriaInArea(variable, null, null).get(0);
					//se modifican los datos de la facultad consultada anteriormente
					entity.setDescripcion(FacesUtils.checkString(txtDescripcion));
					entity.setNombre(FacesUtils.checkString(txtNombre).toUpperCase());
					entity.setActivo(FacesUtils.checkString(somActivo));
					entity.setFechaModificacion(new Date());
					entity.setUsuModificador(0L);

					//se actualizan los datos 
					businessDelegatorView.updateArea(entity);

					data = null;

					FacesUtils.addInfoMessage("Se actualizó exitosamente la Area");
					action_clear();

				}

			} catch (Exception e) {
				entity = null;
				FacesUtils.addErrorMessage(e.getMessage());
			}

			return "";
		}
	
	public void editar_action(String nombre) {

		txtNombre.setValue(nombre);
		listener_txtId();
	}
	
	public String action_clear() {

		entity = null;		

		btnSave.setDisabled(true);
		btnModify.setDisabled(true);
		txtDescripcion.resetValue();
		txtNombre.resetValue();
		somActivo.resetValue();

		return "";
	}

	public void action_validar() {

		if (crear) {
			btnSave.setDisabled(false);
			verificar(btnSave);
		} else {
			btnModify.setDisabled(false);
			verificar(btnModify);
		}

	}

	private void verificar(CommandButton input) {
		try {
			if (FacesUtils.checkString(txtNombre).isEmpty())
				input.setDisabled(true);
			if (FacesUtils.checkString(somActivo) == null)
				input.setDisabled(true);

		} catch (Exception e) {
			log.debug(e.getMessage(),e);
		}
	}

    public TimeZone getTimeZone() {
        return java.util.TimeZone.getDefault();
    }

    public BusinessDelegator getBusinessDelegatorView() {
        return businessDelegatorView;
    }

    public void setBusinessDelegatorView(
        BusinessDelegator businessDelegatorView) {
        this.businessDelegatorView = businessDelegatorView;
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



	public SelectOneMenu getSomActivo() {
		return somActivo;
	}



	public void setSomActivo(SelectOneMenu somActivo) {
		this.somActivo = somActivo;
	}



	public List<AreaDTO> getData() {
		try {
			if (data == null) {
				data = businessDelegatorView.getDataArea();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return data;
	}



	public void setData(List<AreaDTO> data) {
		this.data = data;
	}

    
}
