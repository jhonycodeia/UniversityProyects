package com.green.view;

import com.green.dto.RecompensaDTO;
import com.green.dto.TipoPuntosDTO;
import com.green.exception.*;

import com.green.modelo.*;

import com.green.utility.*;

import org.primefaces.component.calendar.*;
import org.primefaces.component.commandbutton.CommandButton;
import org.primefaces.component.inputtext.InputText;
import org.primefaces.component.inputtextarea.InputTextarea;
import org.primefaces.component.selectonemenu.SelectOneMenu;
import org.primefaces.context.RequestContext;
import org.primefaces.event.RowEditEvent;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;
import org.primefaces.model.UploadedFile;
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
public class RecompensaView implements Serializable {
	private static final long serialVersionUID = 1L;
	private static final Logger log = LoggerFactory.getLogger(RecompensaView.class);

	private List<Recompensa> listRecompensas;

	private Usuario usuario;
	private Recompensa recompensa;
	private Puntos puntosGanados;
	
	private String puntos;	
	private String nombreRecompensa;
	
	private List<Recompensa> listMisRecompensas;

	@ManagedProperty(value = "#{businessDelegator}")
	private BusinessDelegator businessDelegatorView;

	public RecompensaView() {
		super();
	}
	
	public void reclamarRecompensa() {
		try {
			businessDelegatorView.reclamarRecompensa(recompensa, usuario);
			FacesUtils.addInfoMessage("Se reclamo la recompensa correctamente");
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}
	}
	
	public void openModal(long idRecompensa) {
		try {
			recompensa = businessDelegatorView.getRecompensa(idRecompensa);
			
			Object[] variables = { "usuario.idUsuario", true, getUsuario().getIdUsuario(), "=", 
									"tipoPuntos.idTipoPuntos", true,Constantes.PUNTOS_TYPE_GANADO, "=" };
			puntosGanados = businessDelegatorView.findByCriteriaInPuntos(variables, null, null).get(0);
			
			if(puntosGanados.getPuntos()>recompensa.getRequisito()) {
				nombreRecompensa = "Estas seguro de reclamar la recompensa de "+recompensa.getNombre()+" tiene un costo de "+recompensa.getRequisito()+" puntos";
				RequestContext.getCurrentInstance().execute("PF('dlg1').show();");

			}
			else {
				int faltante = (int)(recompensa.getRequisito()-puntosGanados.getPuntos());
				this.puntos = String.valueOf(faltante);
				RequestContext.getCurrentInstance().execute("PF('dlg2').show();");

			}
			
			
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
			e.printStackTrace();
		}
	}

	public StreamedContent getRecompensa(long idRecompensa) {
		try {

			InputStream inputStream = businessDelegatorView.generarRecompensa(idRecompensa);
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

	public List<Recompensa> getListRecompensas() {
		try {
			if(listRecompensas==null) {
				listRecompensas = businessDelegatorView.getRecompensa();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listRecompensas;
	}

	public void setListRecompensas(List<Recompensa> listRecompensas) {
		this.listRecompensas = listRecompensas;
	}


	public String getPuntos() {
		try {
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return puntos;
	}


	public void setPuntos(String puntos) {
		this.puntos = puntos;
	}

	public String getNombreRecompensa() {
		return nombreRecompensa;
	}

	public void setNombreRecompensa(String nombreRecompensa) {
		this.nombreRecompensa = nombreRecompensa;
	}

	public List<Recompensa> getListMisRecompensas() {
		try {
			if(listMisRecompensas==null) {
				listMisRecompensas = new ArrayList<Recompensa>();
				Object[] variables = { "usuario.idUsuario", true, getUsuario().getIdUsuario(), "="};
				for(RecompensaUsuario recompensaUsuario:businessDelegatorView.findByCriteriaInRecompensaUsuario(variables, null, null)) {
					listMisRecompensas.add(businessDelegatorView.getRecompensa(recompensaUsuario.getRecompensa().getIdRecompensa()));
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return listMisRecompensas;
	}

	public void setListMisRecompensas(List<Recompensa> listMisRecompensas) {
		this.listMisRecompensas = listMisRecompensas;
	}

}
