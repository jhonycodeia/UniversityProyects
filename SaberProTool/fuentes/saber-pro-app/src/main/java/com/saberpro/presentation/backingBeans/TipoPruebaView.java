package com.saberpro.presentation.backingBeans;

import org.primefaces.component.commandbutton.CommandButton;
import org.primefaces.component.inputtext.InputText;
import org.primefaces.component.inputtextarea.InputTextarea;
import org.primefaces.component.selectonemenu.SelectOneMenu;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.saberpro.modelo.TipoPrueba;
import com.saberpro.modelo.Usuario;
import com.saberpro.modelo.dto.TipoPruebaDTO;
import com.saberpro.presentation.businessDelegate.IBusinessDelegatorView;
import com.saberpro.utilities.FacesUtils;

import java.io.Serializable;

import java.util.Date;
import java.util.List;
import java.util.TimeZone;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

/**
 * @author Zathura Code Generator http://zathuracode.org/ www.zathuracode.org
 *
 */
@ManagedBean
@ViewScoped
public class TipoPruebaView implements Serializable {
	private static final long serialVersionUID = 1L;
	private static final Logger log = LoggerFactory.getLogger(TipoPruebaView.class);

	private boolean crear = true;

	private InputTextarea txtDescripcion;
	private InputText txtNombre;

	private CommandButton btnSave;
	private CommandButton btnModify;
	private CommandButton btnClear;

	private SelectOneMenu somActivo;

	private List<TipoPruebaDTO> data;

	private TipoPrueba entity;

	private boolean showDialog;

	@ManagedProperty(value = "#{BusinessDelegatorView}")
	private IBusinessDelegatorView businessDelegatorView;

	public TipoPruebaView() {
		super();
	}

	public void editar_action(String nombre) {

		txtNombre.setValue(nombre);
		listener_txtId();
	}

	public void listener_txtId() {
		try {
			String nombre = txtNombre.getValue().toString().trim();
			//Se consulta si hay un tipo de prueba con ese nombre
			entity = businessDelegatorView.findByNombreTipoPrueba(nombre);

		} catch (Exception e) {
			entity = null;
		}
		//Si no hay un tipo de prueba con ese nombre, se desbloquea la función de crear uno nuevo
		if (entity == null) {

			crear = true;

			txtDescripcion.resetValue();
			somActivo.resetValue();

			btnSave.setDisabled(false);
			btnModify.setDisabled(true);
		//De lo contrario se setean los datos del tipo de prueba encontrado con ese nombre
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

		if (crear) {
			btnSave.setDisabled(false);
			verificar(btnSave);
		} else {
			btnModify.setDisabled(false);
			verificar(btnModify);
		}

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
	//método para crear un tipo de prueba
	public String action_create() {
		try {
			Usuario usuario = (Usuario) FacesUtils.getfromSession("usuario");

			if (usuario != null) {
				//se instancia un nuevo tipo de prueba
				entity = new TipoPrueba();
				
				//se hidrata el nuevo objeto tipoprueba
				entity.setDescripcion(FacesUtils.checkString(txtDescripcion));
				entity.setNombre(FacesUtils.checkString(txtNombre).toUpperCase());
				entity.setActivo(FacesUtils.checkString(somActivo));
				entity.setFechaCreacion(new Date());
				entity.setUsuCreador(usuario.getIdUsuario());
				//se guarda el nuevo objeto con sus datos
				businessDelegatorView.saveTipoPrueba(entity);

				data = null;

				FacesUtils.addInfoMessage("Se guardó exitosamente el tipo de prueba");
				action_clear();

			}

		} catch (Exception e) {
			entity = null;
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}
	//método para modificar un tipo de prueba
	public String action_modify() {

		try {
			Usuario usuario = (Usuario) FacesUtils.getfromSession("usuario");
			String nombre = FacesUtils.checkString(txtNombre);

			if (usuario != null) {
				//Se consulta el tipo de prueba por nombre
				entity = businessDelegatorView.findByNombreTipoPrueba(nombre);
				//Se modifican los datos del objeto tipo prueba
				entity.setDescripcion(FacesUtils.checkString(txtDescripcion));
				entity.setNombre(FacesUtils.checkString(txtNombre).toUpperCase());
				entity.setActivo(FacesUtils.checkString(somActivo));
				entity.setFechaModificacion(new Date());
				entity.setUsuModificador(usuario.getIdUsuario());
				//Se actualizan los datos del tipo de prueba
				businessDelegatorView.updateTipoPrueba(entity);

				data = null;

				FacesUtils.addInfoMessage("Se actualizó exitosamente el tipo de prueba");
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

	public List<TipoPruebaDTO> getData() {
		try {
			if (data == null) {
				data = businessDelegatorView.getDataTipoPrueba();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return data;
	}

	public void setData(List<TipoPruebaDTO> tipoPruebaDTO) {
		this.data = tipoPruebaDTO;
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
