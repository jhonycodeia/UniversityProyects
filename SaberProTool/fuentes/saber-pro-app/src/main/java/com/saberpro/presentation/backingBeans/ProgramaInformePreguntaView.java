package com.saberpro.presentation.backingBeans;

import com.saberpro.exceptions.*;

import com.saberpro.modelo.*;
import com.saberpro.modelo.dto.ProgramaModuloDTO;
import com.saberpro.modelo.dto.ResultadosPreguntaDTO;
import com.saberpro.presentation.businessDelegate.*;

import com.saberpro.utilities.*;

import org.primefaces.component.calendar.*;
import org.primefaces.component.commandbutton.CommandButton;
import org.primefaces.component.inputtext.InputText;
import org.primefaces.component.selectonemenu.SelectOneMenu;
import org.primefaces.event.RowEditEvent;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.DualListModel;
import org.primefaces.model.StreamedContent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.Serializable;

import java.sql.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import java.util.ArrayList;
import java.util.Collections;
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
public class ProgramaInformePreguntaView implements Serializable {
	private static final long serialVersionUID = 1L;
	private static final Logger log = LoggerFactory.getLogger(ProgramaInformePreguntaView.class);

	private SelectOneMenu somModulo;

	private List<SelectItem> lasModuloSelectItem;
	
	private List<ResultadosPreguntaDTO> data;

	private CommandButton btnConsultar;

	@ManagedProperty(value = "#{BusinessDelegatorView}")
	private IBusinessDelegatorView businessDelegatorView;

	public ProgramaInformePreguntaView() {
		super();
	}
	
	public void verPregunta(long idPregunta) {
		try {
			FacesContext.getCurrentInstance().getExternalContext()
			.redirect("../Pregunta/pregunta.xhtml?id="
					+ idPregunta);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void limpiar() {
		data = null;
	}

	public List<SelectItem> getLasModuloSelectItem() {

		if (lasModuloSelectItem == null) {
			Object[] variable = { "tipoModulo", true, Constantes.MODULO_TYPE_GENERICO, "=", "activo", true,
					Constantes.ESTADO_ACTIVO, "=" };
			lasModuloSelectItem = new ArrayList<>();
			try {
				log.info("El tipo de usuario es " + VariablesSession.tipoUsuario.getIdTipoUsuario());
				List<Modulo> list = businessDelegatorView.findByCriteriaInModulo(variable, null, null);
				list.addAll(businessDelegatorView.findByProgramaModulo(VariablesSession.programa.getIdPrograma()));

				for (Modulo modulo : list) {
					lasModuloSelectItem.add(new SelectItem(modulo.getIdModulo(), modulo.getNombre()));
				}

			} catch (Exception e) {

				log.debug("Error" + e.getMessage());
			}
		}

		return lasModuloSelectItem;
	}

	public void setLasModuloSelectItem(List<SelectItem> lasModuloSelectItem) {
		this.lasModuloSelectItem = lasModuloSelectItem;
	}

	public IBusinessDelegatorView getBusinessDelegatorView() {
		return businessDelegatorView;
	}

	public void setBusinessDelegatorView(IBusinessDelegatorView businessDelegatorView) {
		this.businessDelegatorView = businessDelegatorView;
	}

	public SelectOneMenu getSomModulo() {
		return somModulo;
	}

	public void setSomModulo(SelectOneMenu somModulo) {
		this.somModulo = somModulo;
	}

	public CommandButton getBtnConsultar() {
		return btnConsultar;
	}

	public void setBtnConsultar(CommandButton btnConsultar) {
		this.btnConsultar = btnConsultar;
	}

	public List<ResultadosPreguntaDTO> getData() {
		if(data==null && FacesUtils.checkLong(somModulo)!=null) {
			try {
				data = businessDelegatorView.findByTopPregunta(FacesUtils.checkLong(somModulo));
				
			} catch (Exception e) {
				log.error("error de "+e.getMessage(),e);
			}
		}
		return data;
	}

	public void setData(List<ResultadosPreguntaDTO> data) {
		this.data = data;
	}

}
