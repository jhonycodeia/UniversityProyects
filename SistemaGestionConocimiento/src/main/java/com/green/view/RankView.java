package com.green.view;

import com.green.dto.RankDTO;
import com.green.dto.TrofeoDTO;

import com.green.exception.*;

import com.green.modelo.*;

import com.green.utility.*;

import org.primefaces.component.calendar.*;
import org.primefaces.component.commandbutton.CommandButton;
import org.primefaces.component.inputtext.InputText;
import org.primefaces.component.selectonemenu.SelectOneMenu;
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
import javax.faces.model.SelectItem;

/**
 * @author Zathura Code Generator http://zathuracode.org/ www.zathuracode.org
 *
 */
@ManagedBean
@ViewScoped
public class RankView implements Serializable {
	private static final long serialVersionUID = 1L;
	private static final Logger log = LoggerFactory.getLogger(RankView.class);

	private List<RankDTO> listComentarios;
	private List<RankDTO> listCapsulas;
	private List<RankDTO> listPuntos;
	
	private List<SelectItem> lasPuntosSelectItem;
	
	private SelectOneMenu somPuntos;
	
	private Usuario usuario;

	@ManagedProperty(value = "#{businessDelegator}")
	private BusinessDelegator businessDelegatorView;

	public RankView() {
		super();
	}
	
	public void cambiar() {
		listPuntos = null;
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


	public List<RankDTO> getListComentarios() {
		try {
			if(listComentarios==null) {
				listComentarios=businessDelegatorView.rankComentarios();
				int i = 1;
				for (RankDTO rankDTO : listComentarios) {
					rankDTO.setId(i);
					i++;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listComentarios;
	}


	public void setListComentarios(List<RankDTO> listComentarios) {
		this.listComentarios = listComentarios;
	}


	public List<RankDTO> getListCapsulas() {
		try {
			if(listCapsulas==null) {
				listCapsulas=businessDelegatorView.rankCapsulas();
				int i = 1;
				for (RankDTO rankDTO : listCapsulas) {
					rankDTO.setId(i);
					i++;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listCapsulas;
	}


	public void setListCapsulas(List<RankDTO> listCapsulas) {
		this.listCapsulas = listCapsulas;
	}


	public List<RankDTO> getListPuntos() {
		try {
			if(listPuntos==null) {
				listPuntos=businessDelegatorView.rankPuntos(FacesUtils.checkLong(somPuntos));
				int i = 1;
				for (RankDTO rankDTO : listPuntos) {
					rankDTO.setId(i);
					i++;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listPuntos;
	}


	public void setListPuntos(List<RankDTO> listPuntos) {
		this.listPuntos = listPuntos;
	}


	public List<SelectItem> getLasPuntosSelectItem() {
		if(lasPuntosSelectItem==null) {
			lasPuntosSelectItem = new ArrayList<>();
			try {
				for (TipoPuntos tipoPuntos:businessDelegatorView.getTipoPuntos()) {
					lasPuntosSelectItem.add(new SelectItem(tipoPuntos.getIdTipoPuntos(),tipoPuntos.getNombre()));
				}
			} catch (Exception e) {
				log.debug(e.getMessage());
			}
		}
		return lasPuntosSelectItem;
	}


	public void setLasPuntosSelectItem(List<SelectItem> lasPuntosSelectItem) {
		this.lasPuntosSelectItem = lasPuntosSelectItem;
	}


	public SelectOneMenu getSomPuntos() {
		return somPuntos;
	}


	public void setSomPuntos(SelectOneMenu somPuntos) {
		this.somPuntos = somPuntos;
	}

}
