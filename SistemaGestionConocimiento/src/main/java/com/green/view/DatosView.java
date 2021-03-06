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
 * @author Zathura Code Generator http://zathuracode.org/ www.zathuracode.org
 *
 */
@ManagedBean
@ViewScoped
public class DatosView implements Serializable {
	private static final long serialVersionUID = 1L;
	private static final Logger log = LoggerFactory.getLogger(DatosView.class);

	private Usuario usuario;
	private TipoUsuario tipoUsuario;
	
	private boolean tieneComentarios;
	private boolean tieneCapsulas;
	private boolean permisosLider;
	private boolean permisosAdmin;

	private String name;
	private String puntos;
	private String comentarios;
	private String capsula;

	private List<Notificacion> listCapsulas;
	private List<Notificacion> listComentarios;

	@ManagedProperty(value = "#{businessDelegator}")
	private BusinessDelegator businessDelegatorView;

	public DatosView() {
		super();
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

	public List<Notificacion> getListCapsulas() {
		try {
			if (listCapsulas == null) {
				listCapsulas = new ArrayList<Notificacion>();
				Object[] variables = { "usuario.idUsuario", true, usuario.getIdUsuario(), "=" };
				for (Notificacion notificacion : businessDelegatorView.findByCriteriaInNotificacion(variables, null,
						null)) {
					Notificacion aux = businessDelegatorView.getNotificacion(notificacion.getIdNotificacion());
					if (aux.getTipoNotificacion().getIdTipoNotificacion() == Constantes.NOTIFICACION_TYPE_SOCIAL
							&& aux.getActivo().equals(Constantes.ESTADO_PENDIENTE) && listCapsulas.size() < 10) {
						listCapsulas.add(notificacion);
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listCapsulas;
	}

	public void setListCapsulas(List<Notificacion> listCapsulas) {
		this.listCapsulas = listCapsulas;
	}

	public List<Notificacion> getListComentarios() {
		try {
			if (listComentarios == null) {
				listComentarios = new ArrayList<Notificacion>();
				Object[] variables = { "usuario.idUsuario", true, usuario.getIdUsuario(), "=" };
				for (Notificacion notificacion : businessDelegatorView.findByCriteriaInNotificacion(variables, null,
						null)) {
					Notificacion aux = businessDelegatorView.getNotificacion(notificacion.getIdNotificacion());
					if (aux.getTipoNotificacion().getIdTipoNotificacion() == Constantes.NOTIFICACION_TYPE_PERSONAL
							&& aux.getActivo().equals(Constantes.ESTADO_PENDIENTE) && listComentarios.size() < 10) {
						listComentarios.add(notificacion);
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listComentarios;
	}

	public void setListComentarios(List<Notificacion> listComentarios) {
		this.listComentarios = listComentarios;
	}

	public String getName() {
		name = getUsuario().getNombre() + " " + getUsuario().getApellido();
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getComentarios() {
		if (getListComentarios() == null || getListComentarios().size() == 0) {
			comentarios = "";
		} else {
			return comentarios = "" + getListComentarios().size();
		}
		return comentarios;
	}

	public void setComentarios(String comentarios) {
		this.comentarios = comentarios;
	}

	public String getCapsula() {
		if (getListCapsulas() == null || getListCapsulas().size() == 0) {
			capsula = "";
		} else {
			capsula = "" + listCapsulas.size();
		}
		return capsula;
	}

	public void setCapsula(String capsula) {
		this.capsula = capsula;
	}

	public String getPuntos() {
		puntos = ""+getUsuario().getPuntos();
		return puntos;
	}

	public void setPuntos(String puntos) {
		this.puntos = puntos;
	}

	public boolean isTieneComentarios() {
		tieneComentarios = !getComentarios().equals("");
		return tieneComentarios;
	}

	public void setTieneComentarios(boolean tieneComentarios) {
		this.tieneComentarios = tieneComentarios;
	}

	public boolean isTieneCapsulas() {
		tieneCapsulas = !getCapsula().equals("");
		return tieneCapsulas;
	}

	public void setTieneCapsulas(boolean tieneCapsulas) {
		this.tieneCapsulas = tieneCapsulas;
	}

	public boolean isPermisosLider() {
		if(getTipoUsuario().getIdTipoUsuario()==Constantes.USER_TYPE_LIDER) {
			permisosLider = true;
		}
		else {
			permisosLider = false;
		}
		return permisosLider;
	}

	public void setPermisosLider(boolean permisosLider) {
		this.permisosLider = permisosLider;
	}

	public boolean isPermisosAdmin() {
		if(getTipoUsuario().getIdTipoUsuario()==Constantes.USER_TYPE_ADMIN) {
			permisosAdmin = true;
		}
		else {
			permisosAdmin = false;
		}
		return permisosAdmin;
	}

	public void setPermisosAdmin(boolean permisosAdmin) {
		this.permisosAdmin = permisosAdmin;
	}

	public TipoUsuario getTipoUsuario() {
		tipoUsuario = (TipoUsuario) FacesUtils.getfromSession("tipoUsuario");		
		return tipoUsuario;
	}

	public void setTipoUsuario(TipoUsuario tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}

}
