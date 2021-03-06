package com.green.view;

import com.green.dto.UsuarioDTO;

import com.green.exception.*;

import com.green.modelo.*;

import com.green.utility.*;

import org.aspectj.bridge.context.PinpointingMessageHandler;
import org.primefaces.component.calendar.*;
import org.primefaces.component.commandbutton.CommandButton;
import org.primefaces.component.inputtext.InputText;

import org.primefaces.event.RowEditEvent;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;
import org.primefaces.model.chart.PieChartModel;
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
public class HomeView implements Serializable {
	private static final long serialVersionUID = 1L;
	private static final Logger log = LoggerFactory.getLogger(HomeView.class);

	private Usuario usuario;

	private boolean tieneComentarios;
	private boolean tieneCapsulas;
	private boolean permisosLider;
	private boolean permisosAdmin;

	private String name;
	private String puntos;
	private String comentarios;
	private String capsula;
	private String fecha;
	private String numCapsulas;
	private String numComentarios;
	private String numRecompensas;
	private String numValidado;
	
	private PieChartModel pieModel;
	

	private List<Notificacion> listCapsulas;
	private List<Notificacion> listComentarios;
	private List<Recompensa> listRecompensas;
	private List<Trofeo> listTrofeos;

	@ManagedProperty(value = "#{businessDelegator}")
	private BusinessDelegator businessDelegatorView;

	public HomeView() {
		super();
	}
	
	private void createPieModel() {
		try {
			pieModel = new PieChartModel();
			
			Object[] variables = { "usuario.idUsuario", true, getUsuario().getIdUsuario(), "="};
			List<Puntos> listPuntos = businessDelegatorView.findByCriteriaInPuntos(variables, null, null);
			
			for (Puntos puntos : listPuntos) {
				TipoPuntos tipoPuntos = businessDelegatorView.getTipoPuntos(puntos.getTipoPuntos().getIdTipoPuntos());
				if(tipoPuntos.getIdTipoPuntos()==Constantes.PUNTOS_TYPE_TOTAL || tipoPuntos.getIdTipoPuntos()==Constantes.PUNTOS_TYPE_VER_CONTENIDO) {
					log.debug("no aplica categoria");
				}
				else {
					pieModel.set(tipoPuntos.getNombre(),puntos.getPuntos());
				}
				
			}	

			pieModel.setTitle("Puntos");
			pieModel.setLegendPosition("w");
			pieModel.setExtender("skinPie");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public StreamedContent getTrofeo(long idTrofeo) {
		try {

			InputStream inputStream = businessDelegatorView.generarTrofeo(idTrofeo);
			StreamedContent archivo = new DefaultStreamedContent(inputStream,"image/png");
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
			comentarios = "0";
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
			capsula = "0";
		} else {
			capsula = "" + listCapsulas.size();
		}
		return capsula;
	}

	public void setCapsula(String capsula) {
		this.capsula = capsula;
	}

	public String getPuntos() {
		puntos = "" + getUsuario().getPuntos();
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
		return permisosLider;
	}

	public void setPermisosLider(boolean permisosLider) {
		this.permisosLider = permisosLider;
	}

	public boolean isPermisosAdmin() {
		return permisosAdmin;
	}

	public void setPermisosAdmin(boolean permisosAdmin) {
		this.permisosAdmin = permisosAdmin;
	}

	public List<Recompensa> getListRecompensas() {
		try {
			if (listRecompensas == null) {
				listRecompensas = businessDelegatorView.getRecompensa();
			}
		} catch (Exception e) {

		}
		return listRecompensas;
	}

	public void setListRecompensas(List<Recompensa> listRecompensas) {
		this.listRecompensas = listRecompensas;
	}

	public List<Trofeo> getListTrofeos() {
		try {
			if (listTrofeos == null) {
				listTrofeos = new ArrayList<Trofeo>();
				Object[] variables = { "usuario.idUsuario", true, getUsuario().getIdUsuario(), "="};
				for (UsuarioTrofeo usuarioTrofeo : businessDelegatorView.findByCriteriaInUsuarioTrofeo(variables, null, null)) {
					listTrofeos.add(businessDelegatorView.getTrofeo(usuarioTrofeo.getTrofeo().getIdTrofeo()));			
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listTrofeos;
	}

	public void setListTrofeos(List<Trofeo> listTrofeos) {
		this.listTrofeos = listTrofeos;
	}

	public String getFecha() {
		fecha = Constantes.FORMATO_FECHA_SIMPLE.format(new Date());
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public String getNumCapsulas() {
		try {
			Object[] variables = { "usuario.idUsuario", true, getUsuario().getIdUsuario(), "=" };
			numCapsulas = ""+businessDelegatorView.findByCriteriaInCapsula(variables, null, null).size();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return numCapsulas;
	}

	public void setNumCapsulas(String numCapsulas) {
		this.numCapsulas = numCapsulas;
	}

	public String getNumComentarios() {
		try {
			Object[] variables = { "usuario.idUsuario", true, getUsuario().getIdUsuario(), "=" };
			numComentarios = ""+businessDelegatorView.findByCriteriaInComentario(variables, null, null).size();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return numComentarios;
	}

	public void setNumComentarios(String numComentarios) {
		this.numComentarios = numComentarios;
	}

	public String getNumRecompensas() {
		try {
			Object[] variables = { "usuario.idUsuario", true, getUsuario().getIdUsuario(), "=" };
			numRecompensas=""+businessDelegatorView.findByCriteriaInRecompensaUsuario(variables, null, null).size();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return numRecompensas;
	}

	public void setNumRecompensas(String numRecompensas) {
		this.numRecompensas = numRecompensas;
	}

	public String getNumValidado() {
		try {
			Object[] variables = { "usuario.idUsuario", true, getUsuario().getIdUsuario(), "=",
								   "activo", true, Constantes.ESTADO_ACTIVO, "="};
			int validad = businessDelegatorView.findByCriteriaInCapsula(variables, null, null).size();
			int total = Integer.parseInt(getNumCapsulas());
			
			numValidado = ""+((validad/total)*100)+"%";			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return numValidado;
	}

	public void setNumValidado(String numValidado) {
		this.numValidado = numValidado;
	}

	public PieChartModel getPieModel() {
		if(pieModel==null) {
			createPieModel();
		}
		return pieModel;
	}

	public void setPieModel(PieChartModel pieModel) {
		this.pieModel = pieModel;
	}

}
