package com.green.view;

import com.green.dto.CategoriaDTO;
import com.green.modelo.*;
import com.green.utility.*;

import org.primefaces.component.commandbutton.CommandButton;
import org.primefaces.component.inputtext.InputText;
import org.primefaces.component.inputtextarea.InputTextarea;
import org.primefaces.component.selectonemenu.SelectOneMenu;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

/**
 * @author Zathura Code Generator http://zathuracode.org/ www.zathuracode.org
 *
 */
@ManagedBean
@ViewScoped
public class CategoriaView implements Serializable {
	private static final long serialVersionUID = 1L;
	private static final Logger log = LoggerFactory.getLogger(CategoriaView.class);

	private boolean crear = true;

	private InputTextarea txtDescripcion;
	private InputText txtNombre;

	private CommandButton btnSave;
	private CommandButton btnModify;

	private SelectOneMenu somActivo;

	private List<CategoriaDTO> data;

	private Categoria entity;

	@ManagedProperty(value = "#{businessDelegator}")
	private BusinessDelegator businessDelegatorView;

	public CategoriaView() {
		super();
	}

	public void listener_txtId() {
		try {
			// Se obtiene el contenido del txtNombre
			String nombreCategoria = txtNombre.getValue().toString().trim().toUpperCase();

			// se consulta la categoria por nombre
			Object[] variable = { "nombre", true, nombreCategoria, "=" };
			entity = (Categoria) businessDelegatorView.findByCriteriaInCategoria(variable, null, null).get(0);

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
				entity = new Categoria();
				
				//Se hidrata la instancia de facultad con los datos de abajo
				entity.setDescripcion(FacesUtils.checkString(txtDescripcion));
				entity.setNombre(FacesUtils.checkString(txtNombre).toUpperCase());
				entity.setActivo(FacesUtils.checkString(somActivo));
				entity.setFechaCreacion(new Date());
				entity.setUsuCreador(0L);
				
				//se guarda la nueva categoria
				businessDelegatorView.saveCategoria(entity);

				data = null;				
				
				FacesUtils.addInfoMessage("Se guardó exitosamente la categoria");
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
				String nombreCategoria = FacesUtils.checkString(txtNombre);

				if (true) {
					//se consulta la facultad por nombre
					Object[] variable = { "nombre", true, nombreCategoria, "=" };
					entity = (Categoria) businessDelegatorView.findByCriteriaInCategoria(variable, null, null).get(0);
					//se modifican los datos de la facultad consultada anteriormente
					entity.setDescripcion(FacesUtils.checkString(txtDescripcion));
					entity.setNombre(FacesUtils.checkString(txtNombre).toUpperCase());
					entity.setActivo(FacesUtils.checkString(somActivo));
					entity.setFechaModificacion(new Date());
					entity.setUsuModificador(0L);

					//se actualizan los datos 
					businessDelegatorView.updateCategoria(entity);

					data = null;

					FacesUtils.addInfoMessage("Se actualizó exitosamente la categoria");
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
			log.debug(e.getMessage(), e);
		}

	}

	public TimeZone getTimeZone() {
		return java.util.TimeZone.getDefault();
	}

	public BusinessDelegator getBusinessDelegatorView() {
		return businessDelegatorView;
	}

	public void setBusinessDelegatorView(BusinessDelegator businessDelegatorView) {
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

	public List<CategoriaDTO> getData() {
		try {
			if (data == null) {
				data = businessDelegatorView.getDataCategoria();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return data;
	}

	public void setData(List<CategoriaDTO> data) {
		this.data = data;
	}

}
