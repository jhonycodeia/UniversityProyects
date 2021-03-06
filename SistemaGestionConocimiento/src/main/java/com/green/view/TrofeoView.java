package com.green.view;

import com.green.dto.TrofeoDTO;

import com.green.exception.*;

import com.green.modelo.*;

import com.green.utility.*;

import org.primefaces.component.calendar.*;
import org.primefaces.component.commandbutton.CommandButton;
import org.primefaces.component.inputtext.InputText;

import org.primefaces.event.RowEditEvent;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.InputStream;
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
 * @author Zathura Code Generator http://zathuracode.org/ www.zathuracode.org
 *
 */
@ManagedBean
@ViewScoped
public class TrofeoView implements Serializable {
	private static final long serialVersionUID = 1L;
	private static final Logger log = LoggerFactory.getLogger(TrofeoView.class);

	private List<Trofeo> listTrofeos;

	private Usuario usuario;

	@ManagedProperty(value = "#{businessDelegator}")
	private BusinessDelegator businessDelegatorView;

	public TrofeoView() {
		super();
	}
	
	public String faltaTrofeo(long idTrofeo) {
		try {
			Trofeo trofeo = businessDelegatorView.getTrofeo(idTrofeo);
			if(tieneTrofeo(idTrofeo)) {
				return "Ya tienes esta llave en tu perfil";
			}
			else {
				return "Te faltan un total de "+(trofeo.getRequisito()-getUsuario().getPuntos())+" para tenerla";
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			return "";
		}
	}

	public boolean tieneTrofeo(long idTrofeo) throws Exception {
		try {
			Object[] variables = { "usuario.idUsuario", true, getUsuario().getIdUsuario(), "=", "trofeo.idTrofeo", true,
					idTrofeo, "=" };
			return businessDelegatorView.findByCriteriaInUsuarioTrofeo(variables, null, null).size() != 0;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

	}

	public StreamedContent getTrofeo(long idTrofeo) {
		try {

			InputStream inputStream = businessDelegatorView.generarTrofeo(idTrofeo);
			StreamedContent archivo = new DefaultStreamedContent(inputStream, "image/png");
			return archivo;

		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
			e.printStackTrace();
			return null;
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

	public List<Trofeo> getListTrofeos() {
		try {
			if (listTrofeos == null) {
				listTrofeos = businessDelegatorView.getTrofeo();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listTrofeos;
	}

	public void setListTrofeos(List<Trofeo> listTrofeos) {
		this.listTrofeos = listTrofeos;
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

}
