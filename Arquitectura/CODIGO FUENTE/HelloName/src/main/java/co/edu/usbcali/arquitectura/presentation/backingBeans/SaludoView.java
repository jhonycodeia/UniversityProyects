package co.edu.usbcali.arquitectura.presentation.backingBeans;

import co.edu.usbcali.arquitectura.exceptions.*;
import co.edu.usbcali.arquitectura.modelo.*;
import co.edu.usbcali.arquitectura.modelo.dto.SaludoDTO;
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
public class SaludoView implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final Logger log = LoggerFactory.getLogger(SaludoView.class);
    private InputText txtSaludo;
    private InputText txtIdIdioma_Idioma;
    private InputText txtIdSaludo;
    private CommandButton btnSave;
    private CommandButton btnModify;
    private CommandButton btnDelete;
    private CommandButton btnClear;
    private List<SaludoDTO> data;
    private SaludoDTO selectedSaludo;
    private Saludo entity;
    private boolean showDialog;
    @ManagedProperty(value = "#{BusinessDelegatorView}")
    private IBusinessDelegatorView businessDelegatorView;

    public SaludoView() {
        super();
    }

    public String action_new() {
        action_clear();
        selectedSaludo = null;
        setShowDialog(true);

        return "";
    }

    public String action_clear() {
        entity = null;
        selectedSaludo = null;

        if (txtSaludo != null) {
            txtSaludo.setValue(null);
            txtSaludo.setDisabled(true);
        }

        if (txtIdIdioma_Idioma != null) {
            txtIdIdioma_Idioma.setValue(null);
            txtIdIdioma_Idioma.setDisabled(true);
        }

        if (txtIdSaludo != null) {
            txtIdSaludo.setValue(null);
            txtIdSaludo.setDisabled(false);
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
            Integer idSaludo = FacesUtils.checkInteger(txtIdSaludo);
            entity = (idSaludo != null)
                ? businessDelegatorView.getSaludo(idSaludo) : null;
        } catch (Exception e) {
            entity = null;
        }

        if (entity == null) {
            txtSaludo.setDisabled(false);
            txtIdIdioma_Idioma.setDisabled(false);
            txtIdSaludo.setDisabled(false);
            btnSave.setDisabled(false);
        } else {
            txtSaludo.setValue(entity.getSaludo());
            txtSaludo.setDisabled(false);
            txtIdIdioma_Idioma.setValue(entity.getIdioma().getIdIdioma());
            txtIdIdioma_Idioma.setDisabled(false);
            txtIdSaludo.setValue(entity.getIdSaludo());
            txtIdSaludo.setDisabled(true);
            btnSave.setDisabled(false);

            if (btnDelete != null) {
                btnDelete.setDisabled(false);
            }
        }
    }

    public String action_edit(ActionEvent evt) {
        selectedSaludo = (SaludoDTO) (evt.getComponent().getAttributes()
                                         .get("selectedSaludo"));
        txtSaludo.setValue(selectedSaludo.getSaludo());
        txtSaludo.setDisabled(false);
        txtIdIdioma_Idioma.setValue(selectedSaludo.getIdIdioma_Idioma());
        txtIdIdioma_Idioma.setDisabled(false);
        txtIdSaludo.setValue(selectedSaludo.getIdSaludo());
        txtIdSaludo.setDisabled(true);
        btnSave.setDisabled(false);
        setShowDialog(true);

        return "";
    }

    public String action_save() {
        try {
            if ((selectedSaludo == null) && (entity == null)) {
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
            entity = new Saludo();

            Integer idSaludo = FacesUtils.checkInteger(txtIdSaludo);

            entity.setIdSaludo(idSaludo);
            entity.setSaludo(FacesUtils.checkString(txtSaludo));
            entity.setIdioma((FacesUtils.checkInteger(txtIdIdioma_Idioma) != null)
                ? businessDelegatorView.getIdioma(FacesUtils.checkInteger(
                        txtIdIdioma_Idioma)) : null);
            businessDelegatorView.saveSaludo(entity);
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
                Integer idSaludo = new Integer(selectedSaludo.getIdSaludo());
                entity = businessDelegatorView.getSaludo(idSaludo);
            }

            entity.setSaludo(FacesUtils.checkString(txtSaludo));
            entity.setIdioma((FacesUtils.checkInteger(txtIdIdioma_Idioma) != null)
                ? businessDelegatorView.getIdioma(FacesUtils.checkInteger(
                        txtIdIdioma_Idioma)) : null);
            businessDelegatorView.updateSaludo(entity);
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
        } catch (Exception e) {
            data = null;
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_delete_datatable(ActionEvent evt) {
        try {
            selectedSaludo = (SaludoDTO) (evt.getComponent().getAttributes()
                                             .get("selectedSaludo"));

            Integer idSaludo = new Integer(selectedSaludo.getIdSaludo());
            entity = businessDelegatorView.getSaludo(idSaludo);
            action_delete();
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_delete_master() {
        try {
            Integer idSaludo = FacesUtils.checkInteger(txtIdSaludo);
            entity = businessDelegatorView.getSaludo(idSaludo);
            action_delete();
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public void action_delete() throws Exception {
        try {
            businessDelegatorView.deleteSaludo(entity);
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

    public String action_modifyWitDTO(Integer idSaludo, String saludo,
        Integer idIdioma_Idioma) throws Exception {
        try {
            entity.setSaludo(FacesUtils.checkString(saludo));
            businessDelegatorView.updateSaludo(entity);
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
        } catch (Exception e) {
            //renderManager.getOnDemandRenderer("SaludoView").requestRender();
            FacesUtils.addErrorMessage(e.getMessage());
            throw e;
        }

        return "";
    }

    public InputText getTxtSaludo() {
        return txtSaludo;
    }

    public void setTxtSaludo(InputText txtSaludo) {
        this.txtSaludo = txtSaludo;
    }

    public InputText getTxtIdIdioma_Idioma() {
        return txtIdIdioma_Idioma;
    }

    public void setTxtIdIdioma_Idioma(InputText txtIdIdioma_Idioma) {
        this.txtIdIdioma_Idioma = txtIdIdioma_Idioma;
    }

    public InputText getTxtIdSaludo() {
        return txtIdSaludo;
    }

    public void setTxtIdSaludo(InputText txtIdSaludo) {
        this.txtIdSaludo = txtIdSaludo;
    }

    public List<SaludoDTO> getData() {
        try {
            if (data == null) {
                data = businessDelegatorView.getDataSaludo();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return data;
    }

    public void setData(List<SaludoDTO> saludoDTO) {
        this.data = saludoDTO;
    }

    public SaludoDTO getSelectedSaludo() {
        return selectedSaludo;
    }

    public void setSelectedSaludo(SaludoDTO saludo) {
        this.selectedSaludo = saludo;
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
