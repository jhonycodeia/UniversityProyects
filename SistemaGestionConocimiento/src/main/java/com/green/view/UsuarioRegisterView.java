package com.green.view;

import com.green.dto.UsuarioDTO;

import com.green.exception.*;

import com.green.modelo.*;

import com.green.utility.*;

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
 * @author Zathura Code Generator http://zathuracode.org/
 * www.zathuracode.org
 *
 */
@ManagedBean
@ViewScoped
public class UsuarioRegisterView implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final Logger log = LoggerFactory.getLogger(UsuarioRegisterView.class);
    
    private InputText txtNombre;  
    private InputText txtApellido;
    private InputText txtCorreo; 
    
    private CommandButton btnSave;
    
    
    @ManagedProperty(value = "#{businessDelegator}")
    private BusinessDelegator businessDelegatorView;

    public UsuarioRegisterView() {
        super();
    }
    
    public void register() {
    	try {
    		Usuario usuario = new Usuario();
    		
    		usuario.setNombre(FacesUtils.checkString(txtNombre));
    		usuario.setApellido(FacesUtils.checkString(txtApellido));
    		usuario.setCorreo(FacesUtils.checkString(txtCorreo));
    		
    		businessDelegatorView.saveUsuario(usuario);  		
    		
			FacesUtils.addInfoMessage("Se creo el usuario exitosamente revisa el correo registrado");
		} catch (Exception e) {
			log.debug("Error :"+e.getMessage(),e);
			FacesUtils.addErrorMessage(e.getMessage());			
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


	public InputText getTxtNombre() {
		return txtNombre;
	}


	public void setTxtNombre(InputText txtNombre) {
		this.txtNombre = txtNombre;
	}


	public InputText getTxtApellido() {
		return txtApellido;
	}


	public void setTxtApellido(InputText txtApellido) {
		this.txtApellido = txtApellido;
	}


	public InputText getTxtCorreo() {
		return txtCorreo;
	}


	public void setTxtCorreo(InputText txtCorreo) {
		this.txtCorreo = txtCorreo;
	}


	public CommandButton getBtnSave() {
		return btnSave;
	}


	public void setBtnSave(CommandButton btnSave) {
		this.btnSave = btnSave;
	}

    
}
