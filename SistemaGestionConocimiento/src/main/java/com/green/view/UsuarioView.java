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
public class UsuarioView implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final Logger log = LoggerFactory.getLogger(UsuarioView.class);
    
    private Usuario usuario;
    
    private String nombre;
    private String apellido;
    private String correo;
    
    private String pass;
    private String passRepeat;
    
    @ManagedProperty(value = "#{businessDelegator}")
    private BusinessDelegator businessDelegatorView;

    public UsuarioView() {
        super();
    }
    
    public void cambiarClave() {
    	try {
    		if(pass.equals(passRepeat)) {
    			usuario.setClave(pass);
    			usuario.setActivo(Constantes.ESTADO_PENDIENTE);
    			usuario.setFechaModificacion(new Date());
    			usuario.setUsuModificador(usuario.getIdUsuario());
    			
    			businessDelegatorView.updateUsuario(usuario);
    			
    			FacesUtils.addInfoMessage("Se actualizo su informacion correctamente");
    			
    			pass = "";
    			passRepeat ="";
    		}
    		else {
    			throw new Exception("las contraseñas no coincienden");
    		}
			
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}
    }
    
    public void guardar() {
    	try {
			usuario.setNombre(nombre);
			usuario.setApellido(apellido);
			usuario.setCorreo(correo);
			usuario.setFechaModificacion(new Date());
			usuario.setUsuModificador(usuario.getIdUsuario());
			
			businessDelegatorView.updateUsuario(usuario);
			
			FacesUtils.addInfoMessage("Se actualizo su informacion correctamente");
		} catch (Exception e) {
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


	public Usuario getUsuario() {
		try {
			usuario = (Usuario) FacesUtils.getfromSession("usuario");
		} catch (Exception e) {
			// TODO: handle exception
		}
		return usuario;
	}


	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}


	public String getNombre() {
		if(nombre==null) {
			nombre=getUsuario().getNombre();
		}
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getApellido() {
		if(apellido==null) {
			apellido=getUsuario().getApellido();
		}
		return apellido;
	}


	public void setApellido(String apellido) {
		this.apellido = apellido;
	}


	public String getCorreo() {
		if(correo==null) {
			correo = getUsuario().getCorreo();
		}
		return correo;
	}


	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getPassRepeat() {
		return passRepeat;
	}

	public void setPassRepeat(String passRepeat) {
		this.passRepeat = passRepeat;
	}

    
}
