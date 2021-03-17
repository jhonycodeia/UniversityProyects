package com.saberpro.presentation.backingBeans;

import com.saberpro.exceptions.*;

import com.saberpro.modelo.*;
import com.saberpro.modelo.dto.FacultadDTO;
import com.saberpro.modelo.dto.ProgramaDTO;

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
import javax.faces.model.SelectItem;

/**
 * @author Zathura Code Generator http://zathuracode.org/ www.zathuracode.org
 *
 */
@ManagedBean
@ViewScoped
public class ProgramaView implements Serializable {
	private static final long serialVersionUID = 1L;
	private static final Logger log = LoggerFactory.getLogger(ProgramaView.class);

	private boolean crear = true;
	
	private InputTextarea txtDescripcion;
	private InputText txtNombre;

	private CommandButton btnSave;
	private CommandButton btnModify;
	private CommandButton btnClear;

	private SelectOneMenu somActivo;
	private SelectOneMenu somFacultad;

	private List<SelectItem> lasFacultadSelectItem;

	private List<ProgramaDTO> data;

	private ProgramaDTO selectedPrograma;

	private Programa entity;

	private boolean showDialog;

	@ManagedProperty(value = "#{BusinessDelegatorView}")
	private IBusinessDelegatorView businessDelegatorView;

	public ProgramaView() {
		super();
	}

	public String getFacultad(long id) {
		try {
			Facultad facultad = businessDelegatorView.getFacultad(id);

			return facultad.getNombre();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			return null;
		}
	}
	
	public void editar_action(String nombre) {   	
    	
    	txtNombre.setValue(nombre);
    	listener_txtId();
    }

	public void listener_txtId() {
		try {
			String nombreFacultad = txtNombre.getValue().toString().trim();

			entity = businessDelegatorView.findByNombrePrograma(nombreFacultad);

		} catch (Exception e) {
			entity = null;
		}

		if (entity == null) {
			
			crear = true;
			
			txtDescripcion.resetValue();
			somActivo.resetValue();
			somFacultad.resetValue();

			btnSave.setDisabled(false);
			btnModify.setDisabled(true);

		} else {
			
			crear = false;

			txtNombre.setValue(entity.getNombre());
			txtDescripcion.setValue(entity.getDescripcion());
			somActivo.setValue(entity.getActivo());
			somFacultad.setValue(entity.getFacultad().getIdFacultad());
			txtDescripcion.setDisabled(false);
			btnSave.setDisabled(true);
			btnModify.setDisabled(false);
		}
		action_validar();
	}
	
	public void verificar(CommandButton input) {
    	try {
    		if(FacesUtils.checkString(txtNombre).isEmpty()) 
        		input.setDisabled(true);    	
        	if(FacesUtils.checkString(somActivo)==null)
        		input.setDisabled(true);
        	if(FacesUtils.checkString(somFacultad)==null)
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

	public String action_clear() {
		entity = null;
		selectedPrograma = null;

		btnSave.setDisabled(true);
		btnModify.setDisabled(true);

		txtDescripcion.resetValue();
		txtNombre.resetValue();
		somActivo.resetValue();
		somFacultad.resetValue();

		return "";
	}

	public String action_create() {
		try {
			Usuario usuario = (Usuario) FacesUtils.getfromSession("usuario");

			if (usuario != null) {				
				
				entity = new Programa();

				entity.setDescripcion(FacesUtils.checkString(txtDescripcion));
				entity.setNombre(FacesUtils.checkString(txtNombre).toUpperCase());
				entity.setActivo(FacesUtils.checkString(somActivo));
				entity.setFechaCreacion(new Date());
				entity.setUsuCreador(usuario.getIdUsuario());
				entity.setFacultad(businessDelegatorView.getFacultad(Long.parseLong(FacesUtils.checkString(somFacultad))));
				
				businessDelegatorView.savePrograma(entity);	
				
				data = null;

				FacesUtils.addInfoMessage("Se guardó exitosamente  el programa académico");
				action_clear();

			}

		} catch (Exception e) {
			entity = null;
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";

	}

	public String action_modify() {
		try {
			Usuario usuario = (Usuario) FacesUtils.getfromSession("usuario");
			String nombrePrograma = FacesUtils.checkString(txtNombre);

			if (usuario != null) {				
				
				entity = businessDelegatorView.findByNombrePrograma(nombrePrograma);

				entity.setDescripcion(FacesUtils.checkString(txtDescripcion));
				entity.setNombre(FacesUtils.checkString(txtNombre).toUpperCase());
				entity.setActivo(FacesUtils.checkString(somActivo));
				entity.setFechaModificacion(new Date());
				entity.setUsuModificador(usuario.getIdUsuario());
				entity.setFacultad(businessDelegatorView.getFacultad(Long.parseLong(FacesUtils.checkString(somFacultad))));
				
				businessDelegatorView.updatePrograma(entity);			

				data = null;

				FacesUtils.addInfoMessage("Se actualizó exitosamente el programa académico");
				action_clear();

			}

		} catch (Exception e) {
			entity = null;
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public void action_delete() throws Exception {
		try {
			businessDelegatorView.deletePrograma(entity);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYDELETED);
			action_clear();
			data = null;
		} catch (Exception e) {
			throw e;
		}
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

	public List<ProgramaDTO> getData() {
		try {
			if (data == null) {
				data = businessDelegatorView.getDataPrograma();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return data;
	}

	public void setData(List<ProgramaDTO> programaDTO) {
		this.data = programaDTO;
	}

	public ProgramaDTO getSelectedPrograma() {
		return selectedPrograma;
	}

	public void setSelectedPrograma(ProgramaDTO programa) {
		this.selectedPrograma = programa;
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

	public SelectOneMenu getSomFacultad() {
		return somFacultad;
	}

	public void setSomFacultad(SelectOneMenu somFacultad) {
		this.somFacultad = somFacultad;
	}

	public List<SelectItem> getLasFacultadSelectItem() {
		if (lasFacultadSelectItem == null) {
			lasFacultadSelectItem = new ArrayList<>();
			try {
				List<FacultadDTO> lasFacultad = businessDelegatorView.getDataFacultad();
				for (FacultadDTO facultadDTO : lasFacultad) {
					lasFacultadSelectItem.add(new SelectItem(facultadDTO.getIdFacultad(), facultadDTO.getNombre()));
				}
			} catch (Exception e) {
				log.debug("Error" + e.getMessage());
			}
		}
		return lasFacultadSelectItem;
	}

	public void setLasFacultadSelectItem(List<SelectItem> lasFacultadSelectItem) {
		this.lasFacultadSelectItem = lasFacultadSelectItem;
	}
}
