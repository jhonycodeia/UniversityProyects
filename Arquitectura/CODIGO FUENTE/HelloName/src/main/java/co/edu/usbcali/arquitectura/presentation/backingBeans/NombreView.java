package co.edu.usbcali.arquitectura.presentation.backingBeans;

import co.edu.usbcali.arquitectura.exceptions.*;
import co.edu.usbcali.arquitectura.modelo.*;
import co.edu.usbcali.arquitectura.modelo.dto.NombreDTO;
import co.edu.usbcali.arquitectura.presentation.businessDelegate.*;
import co.edu.usbcali.arquitectura.utilities.*;

import org.primefaces.component.calendar.*;
import org.primefaces.component.commandbutton.CommandButton;
import org.primefaces.component.inputtext.InputText;

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
 * @author Zathura Code Generator http://zathuracode.org
 * www.zathuracode.org
 *
 */
@ManagedBean
@ViewScoped
public class NombreView implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final Logger log = LoggerFactory.getLogger(NombreView.class);
    private InputText txtNombre;
    private InputText txtIdIdioma_Idioma;
    private InputText txtIdNombre;
    private CommandButton btnSave;
    private CommandButton btnModify;
    private CommandButton btnDelete;
    private CommandButton btnClear;
    private List<NombreDTO> data;
    private NombreDTO selectedNombre;
    private Nombre entity;
    private boolean showDialog;
    @ManagedProperty(value = "#{BusinessDelegatorView}")
    private IBusinessDelegatorView businessDelegatorView;

    public NombreView() {
        super();
    }

    public String action_new() {
        action_clear();
        selectedNombre = null;
        setShowDialog(true);

        return "";
    }

    public String action_clear() {
        entity = null;
        selectedNombre = null;

        if (txtNombre != null) {
            txtNombre.setValue(null);
            txtNombre.setDisabled(true);
        }

        if (txtIdIdioma_Idioma != null) {
            txtIdIdioma_Idioma.setValue(null);
            txtIdIdioma_Idioma.setDisabled(true);
        }

        if (txtIdNombre != null) {
            txtIdNombre.setValue(null);
            txtIdNombre.setDisabled(false);
        }

        if (btnSave != null) {
            btnSave.setDisabled(true);
        }

        if (btnDelete != null) {
            btnDelete.setDisabled(true);
        }

        return "";
    }

    public void listener_txtId() {
        try {
            Integer idNombre = FacesUtils.checkInteger(txtIdNombre);
            entity = (idNombre != null)
                ? businessDelegatorView.getNombre(idNombre) : null;
        } catch (Exception e) {
            entity = null;
        }

        if (entity == null) {
            txtNombre.setDisabled(false);
            txtIdIdioma_Idioma.setDisabled(false);
            txtIdNombre.setDisabled(false);
            btnSave.setDisabled(false);
        } else {
            txtNombre.setValue(entity.getNombre());
            txtNombre.setDisabled(false);
            txtIdIdioma_Idioma.setValue(entity.getIdioma().getIdIdioma());
            txtIdIdioma_Idioma.setDisabled(false);
            txtIdNombre.setValue(entity.getIdNombre());
            txtIdNombre.setDisabled(true);
            btnSave.setDisabled(false);

            if (btnDelete != null) {
                btnDelete.setDisabled(false);
            }
        }
    }

    public String action_edit(ActionEvent evt) {
        selectedNombre = (NombreDTO) (evt.getComponent().getAttributes()
                                         .get("selectedNombre"));
        txtNombre.setValue(selectedNombre.getNombre());
        txtNombre.setDisabled(false);
        txtIdIdioma_Idioma.setValue(selectedNombre.getIdIdioma_Idioma());
        txtIdIdioma_Idioma.setDisabled(false);
        txtIdNombre.setValue(selectedNombre.getIdNombre());
        txtIdNombre.setDisabled(true);
        btnSave.setDisabled(false);
        setShowDialog(true);

        return "";
    }

    public String action_save() {
        try {
            if ((selectedNombre == null) && (entity == null)) {
                action_create();
            } else {
                action_modify();
            }

            data = null;
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_create() {
        try {
            entity = new Nombre();

            Integer idNombre = FacesUtils.checkInteger(txtIdNombre);

            entity.setIdNombre(idNombre);
            entity.setNombre(FacesUtils.checkString(txtNombre));
            entity.setIdioma((FacesUtils.checkInteger(txtIdIdioma_Idioma) != null)
                ? businessDelegatorView.getIdioma(FacesUtils.checkInteger(
                        txtIdIdioma_Idioma)) : null);
            businessDelegatorView.saveNombre(entity);
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYSAVED);
            action_clear();
        } catch (Exception e) {
            entity = null;
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_modify() {
        try {
            if (entity == null) {
                Integer idNombre = new Integer(selectedNombre.getIdNombre());
                entity = businessDelegatorView.getNombre(idNombre);
            }

            entity.setNombre(FacesUtils.checkString(txtNombre));
            entity.setIdioma((FacesUtils.checkInteger(txtIdIdioma_Idioma) != null)
                ? businessDelegatorView.getIdioma(FacesUtils.checkInteger(
                        txtIdIdioma_Idioma)) : null);
            businessDelegatorView.updateNombre(entity);
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
        } catch (Exception e) {
            data = null;
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_delete_datatable(ActionEvent evt) {
        try {
            selectedNombre = (NombreDTO) (evt.getComponent().getAttributes()
                                             .get("selectedNombre"));

            Integer idNombre = new Integer(selectedNombre.getIdNombre());
            entity = businessDelegatorView.getNombre(idNombre);
            action_delete();
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_delete_master() {
        try {
            Integer idNombre = FacesUtils.checkInteger(txtIdNombre);
            entity = businessDelegatorView.getNombre(idNombre);
            action_delete();
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public void action_delete() throws Exception {
        try {
            businessDelegatorView.deleteNombre(entity);
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYDELETED);
            action_clear();
            data = null;
        } catch (Exception e) {
            throw e;
        }
    }

    public String action_closeDialog() {
        setShowDialog(false);
        action_clear();

        return "";
    }

    public String action_modifyWitDTO(Integer idNombre, String nombre,
        Integer idIdioma_Idioma) throws Exception {
        try {
            entity.setNombre(FacesUtils.checkString(nombre));
            businessDelegatorView.updateNombre(entity);
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
        } catch (Exception e) {
            //renderManager.getOnDemandRenderer("NombreView").requestRender();
            FacesUtils.addErrorMessage(e.getMessage());
            throw e;
        }

        return "";
    }

    public InputText getTxtNombre() {
        return txtNombre;
    }

    public void setTxtNombre(InputText txtNombre) {
        this.txtNombre = txtNombre;
    }

    public InputText getTxtIdIdioma_Idioma() {
        return txtIdIdioma_Idioma;
    }

    public void setTxtIdIdioma_Idioma(InputText txtIdIdioma_Idioma) {
        this.txtIdIdioma_Idioma = txtIdIdioma_Idioma;
    }

    public InputText getTxtIdNombre() {
        return txtIdNombre;
    }

    public void setTxtIdNombre(InputText txtIdNombre) {
        this.txtIdNombre = txtIdNombre;
    }

    public List<NombreDTO> getData() {
        try {
            if (data == null) {
                data = businessDelegatorView.getDataNombre();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return data;
    }

    public void setData(List<NombreDTO> nombreDTO) {
        this.data = nombreDTO;
    }

    public NombreDTO getSelectedNombre() {
        return selectedNombre;
    }

    public void setSelectedNombre(NombreDTO nombre) {
        this.selectedNombre = nombre;
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

    public CommandButton getBtnDelete() {
        return btnDelete;
    }

    public void setBtnDelete(CommandButton btnDelete) {
        this.btnDelete = btnDelete;
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

    public void setBusinessDelegatorView(
        IBusinessDelegatorView businessDelegatorView) {
        this.businessDelegatorView = businessDelegatorView;
    }

    public boolean isShowDialog() {
        return showDialog;
    }

    public void setShowDialog(boolean showDialog) {
        this.showDialog = showDialog;
    }
}
