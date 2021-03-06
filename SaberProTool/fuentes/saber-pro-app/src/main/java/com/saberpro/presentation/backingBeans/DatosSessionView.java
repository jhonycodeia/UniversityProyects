package com.saberpro.presentation.backingBeans;

import com.saberpro.exceptions.*;

import com.saberpro.modelo.*;
import com.saberpro.modelo.dto.EstadoPruebaDTO;

import com.saberpro.presentation.businessDelegate.*;

import com.saberpro.utilities.*;

import org.hibernate.annotations.Check;
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
public class DatosSessionView implements Serializable {
	private static final long serialVersionUID = 1L;
	private static final Logger log = LoggerFactory.getLogger(DatosSessionView.class);

	private  Usuario usuario;
	private  ProgramaUsuario programaUsuario;
	private  TipoUsuario tipoUsuario;
	private  Programa programa;
	private  Facultad facultad;
	

	public DatosSessionView() {
		super();
	}


	public Usuario getUsuario() {
		usuario = VariablesSession.usuario;
		return usuario;
	}


	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}


	public ProgramaUsuario getProgramaUsuario() {
		programaUsuario = VariablesSession.programaUsuario;
		return programaUsuario;
	}


	public void setProgramaUsuario(ProgramaUsuario programaUsuario) {
		this.programaUsuario = programaUsuario;
	}


	public TipoUsuario getTipoUsuario() {
		tipoUsuario = VariablesSession.tipoUsuario;
		return tipoUsuario;
	}


	public void setTipoUsuario(TipoUsuario tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}


	public Programa getPrograma() {
		programa = VariablesSession.programa;
		return programa;
	}


	public void setPrograma(Programa programa) {
		this.programa = programa;
	}


	public Facultad getFacultad() {
		facultad = VariablesSession.facultad;
		return facultad;
	}


	public void setFacultad(Facultad facultad) {
		this.facultad = facultad;
	}


	

	
	
}
