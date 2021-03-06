package com.green.view;

import com.green.dto.CapsulaDTO;

import com.green.exception.*;

import com.green.modelo.*;

import com.green.utility.*;

import org.primefaces.component.calendar.*;
import org.primefaces.component.commandbutton.CommandButton;
import org.primefaces.component.inputtext.InputText;

import org.primefaces.event.RowEditEvent;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.Serializable;

import java.sql.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.TimeZone;

import javax.annotation.PostConstruct;
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
public class CapsulaView implements Serializable {
	private static final long serialVersionUID = 1L;
	private static final Logger log = LoggerFactory.getLogger(CapsulaView.class);

	private Usuario usuario;

	private List<Capsula> listCapsulas;
	private List<Capsula> listCapsulasActivas;
	private List<Capsula> listCapsulasValidar;

	@ManagedProperty(value = "#{businessDelegator}")
	private BusinessDelegator businessDelegatorView;

	public CapsulaView() {
		super();
	}

	@PostConstruct
	public void cargar() {
		usuario = (Usuario) FacesUtils.getfromSession("usuario");
	}
	
	public void enviarValidar(long id) {
		try {
			Capsula capsula = businessDelegatorView.getCapsula(id);
			
			capsula.setActivo(Constantes.ESTADO_PENDIENTE);
			capsula.setFechaModificacion(new Date());
			capsula.setUsuModificador(usuario.getIdUsuario());
			
			businessDelegatorView.updateCapsula(capsula);
			
			FacesUtils.addInfoMessage("Se envio correctamente a revisar");
			listCapsulas = null;
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}
	}
	
	public String estado(String activo) {
		if(activo.equals("S")) {
			return "Aprobada";
		}
		else if(activo.equals("P")) {
			return "Revisando";
		}
		else {
			return "";
		}
	}

	public void verCapsula(long id) {
		try {
						
			FacesContext.getCurrentInstance().getExternalContext().redirect("capsulaDetalle.xhtml?id=" + id);
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}
	}
	
	public void validarCapsula(long id) {
		try {
			FacesContext.getCurrentInstance().getExternalContext().redirect("validarCapsula.xhtml?id=" + id);
		} catch (IOException e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}
	}

	public void editarCapsula(long id) {
		try {
			Capsula capsula = businessDelegatorView.getCapsula(id);		

			
			if(capsula.getActivo().equals(Constantes.ESTADO_PENDIENTE)) {
				throw new Exception("No puede actualizar su capsula esta siendo revisada por un director de area");
			}
			
			if(capsula.getTipoCapsula().getIdTipoCapsula()==Constantes.CAPSULA_TYPE_ESTANDAR) {
				FacesContext.getCurrentInstance().getExternalContext().redirect("capsulaEstandar.xhtml?id=" + id);
			}
			else if(capsula.getTipoCapsula().getIdTipoCapsula()==Constantes.CAPSULA_TYPE_TOOL) {
				FacesContext.getCurrentInstance().getExternalContext().redirect("capsulaTool.xhtml?id=" + id);
			}
			else if(capsula.getTipoCapsula().getIdTipoCapsula()==Constantes.CAPSULA_TYPE_GUIA) {
				FacesContext.getCurrentInstance().getExternalContext().redirect("capsulaGuia.xhtml?id=" + id);
			}
			
			
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

	public void setBusinessDelegatorView(BusinessDelegator businessDelegatorView) {
		this.businessDelegatorView = businessDelegatorView;
	}

	public List<Capsula> getListCapsulas() {
		try {
			if (listCapsulas == null) {
				listCapsulas = new ArrayList<Capsula>();
				Object[] variables = { "usuario.idUsuario", true, usuario.getIdUsuario(), "=" };
				listCapsulas = businessDelegatorView.findByCriteriaInCapsula(variables, null, null);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return listCapsulas;
	}

	public void setListCapsulas(List<Capsula> listCapsulas) {
		this.listCapsulas = listCapsulas;
	}

	public List<Capsula> getListCapsulasValidar() {
		try {
			if (listCapsulasValidar == null) {
				listCapsulasValidar = new ArrayList<Capsula>();
				Object[] variables = { "activo", true,Constantes.ESTADO_PENDIENTE, "="};				
				for (Capsula capsula : businessDelegatorView.findByCriteriaInCapsula(variables, null, null)) {
					if(capsula.getUsuario().getIdUsuario()!=usuario.getIdUsuario()) {
						listCapsulasValidar.add(capsula);
					}
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return listCapsulasValidar;
	}

	public void setListCapsulasValidar(List<Capsula> listCapsulasValidar) {
		this.listCapsulasValidar = listCapsulasValidar;
	}

	public List<Capsula> getListCapsulasActivas() {
		try {
			if (listCapsulasActivas == null) {
				listCapsulasActivas = new ArrayList<Capsula>();				
				for (Capsula capsula : businessDelegatorView.getCapsula()) {
					if(capsula.getActivo().equals(Constantes.ESTADO_ACTIVO)) {
						listCapsulasActivas.add(capsula);
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listCapsulasActivas;
	}

	public void setListCapsulasActivas(List<Capsula> listCapsulasActivas) {
		this.listCapsulasActivas = listCapsulasActivas;
	}

}
