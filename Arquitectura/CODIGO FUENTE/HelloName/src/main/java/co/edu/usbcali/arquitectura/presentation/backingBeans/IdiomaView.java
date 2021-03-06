package co.edu.usbcali.arquitectura.presentation.backingBeans;

import co.edu.usbcali.arquitectura.exceptions.*;
import co.edu.usbcali.arquitectura.modelo.*;
import co.edu.usbcali.arquitectura.modelo.dto.IdiomaDTO;
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
public class IdiomaView implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final Logger log = LoggerFactory.getLogger(IdiomaView.class);
    private InputText txtNombreIdioma;
    private InputText txtIdIdioma;
    private CommandButton btnSave;
    private CommandButton btnModify;
    private CommandButton btnDelete;
    private CommandButton btnClear;
    private List<IdiomaDTO> data;
    private IdiomaDTO selectedIdioma;
    private Idioma entity;
    private boolean showDialog;
    @ManagedProperty(value = "#{BusinessDelegatorView}")
    private IBusinessDelegatorView businessDelegatorView;

    public IdiomaView() {
        super();
    }

    public String action_new() {
        action_clear();
        selectedIdioma = null;
        setShowDialog(true);

        return "";
    }

    public String action_clear() {
        entity = null;
        selectedIdioma = null;

        if (txtNombreIdioma != null) {
            txtNombreIdioma.setValue(null);
            txtNombreIdioma.setDisabled(true);
        }

        if (txtIdIdioma != null) {
            txtIdIdioma.setValue(null);
            txtIdIdioma.setDisabled(false);
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
            Integer idIdioma = FacesUtils.checkInteger(txtIdIdioma);
            entity = (idIdioma != null)
                ? businessDelegatorView.getIdioma(idIdioma) : null;
        } catch (Exception e) {
            entity = null;
        }

        if (entity == null) {
            txtNombreIdioma.setDisabled(false);
            txtIdIdioma.setDisabled(false);
            btnSave.setDisabled(false);
        } else {
            txtNombreIdioma.setValue(entity.getNombreIdioma());
            txtNombreIdioma.setDisabled(false);
            txtIdIdioma.setValue(entity.getIdIdioma());
            txtIdIdioma.setDisabled(true);
            btnSave.setDisabled(false);

            if (btnDelete != null) {
                btnDelete.setDisabled(false);
            }
        }
    }

    public String action_edit(ActionEvent evt) {
        selectedIdioma = (IdiomaDTO) (evt.getComponent().getAttributes()
                                         .get("selectedIdioma"));
        txtNombreIdioma.setValue(selectedIdioma.getNombreIdioma());
        txtNombreIdioma.setDisabled(false);
        txtIdIdioma.setValue(selectedIdioma.getIdIdioma());
        txtIdIdioma.setDisabled(true);
        btnSave.setDisabled(false);
        setShowDialog(true);

        return "";
    }

    public String action_save() {
        try {
            if ((selectedIdioma == null) && (entity == null)) {
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
            entity = new Idioma();

            Integer idIdioma = FacesUtils.checkInteger(txtIdIdioma);

            entity.setIdIdioma(idIdioma);
            entity.setNombreIdioma(FacesUtils.checkString(txtNombreIdioma));
            businessDelegatorView.saveIdioma(entity);
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
                Integer idIdioma = new Integer(selectedIdioma.getIdIdioma());
                entity = businessDelegatorView.getIdioma(idIdioma);
            }

            entity.setNombreIdioma(FacesUtils.checkString(txtNombreIdioma));
            businessDelegatorView.updateIdioma(entity);
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
        } catch (Exception e) {
            data = null;
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_delete_datatable(ActionEvent evt) {
        try {
            selectedIdioma = (IdiomaDTO) (evt.getComponent().getAttributes()
                                             .get("selectedIdioma"));

            Integer idIdioma = new Integer(selectedIdioma.getIdIdioma());
            entity = businessDelegatorView.getIdioma(idIdioma);
            action_delete();
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_delete_master() {
        try {
            Integer idIdioma = FacesUtils.checkInteger(txtIdIdioma);
            entity = businessDelegatorView.getIdioma(idIdioma);
            action_delete();
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public void action_delete() throws Exception {
        try {
            businessDelegatorView.deleteIdioma(entity);
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

    public String action_modifyWitDTO(Integer idIdioma, String nombreIdioma)
        throws Exception {
        try {
            entity.setNombreIdioma(FacesUtils.checkString(nombreIdioma));
            businessDelegatorView.updateIdioma(entity);
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
        } catch (Exception e) {
            //renderManager.getOnDemandRenderer("IdiomaView").requestRender();
            FacesUtils.addErrorMessage(e.getMessage());
            throw e;
        }

        return "";
    }

    public InputText getTxtNombreIdioma() {
        return txtNombreIdioma;
    }

    public void setTxtNombreIdioma(InputText txtNombreIdioma) {
        this.txtNombreIdioma = txtNombreIdioma;
    }

    public InputText getTxtIdIdioma() {
        return txtIdIdioma;
    }

    public void setTxtIdIdioma(InputText txtIdIdioma) {
        this.txtIdIdioma = txtIdIdioma;
    }

    public List<IdiomaDTO> getData() {
        try {
            if (data == null) {
                data = businessDelegatorView.getDataIdioma();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return data;
    }

    public void setData(List<IdiomaDTO> idiomaDTO) {
        this.data = idiomaDTO;
    }

    public IdiomaDTO getSelectedIdioma() {
        return selectedIdioma;
    }

    public void setSelectedIdioma(IdiomaDTO idioma) {
        this.selectedIdioma = idioma;
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
