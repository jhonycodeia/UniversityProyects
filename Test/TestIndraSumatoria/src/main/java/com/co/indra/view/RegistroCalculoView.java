package com.co.indra.view;

import com.co.indra.dto.CalculoDTO;
import com.co.indra.dto.RegistroCalculoDTO;
import com.co.indra.exception.*;
import com.co.indra.model.*;
import com.co.indra.utility.*;

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
public class RegistroCalculoView implements Serializable {
	private static final long serialVersionUID = 1L;
	private static final Logger log = LoggerFactory.getLogger(RegistroCalculoView.class);

	
	
	private List<RegistroCalculoDTO> data;
	private CalculoDTO entity;

	@ManagedProperty(value = "#{businessDelegator}")
	private BusinessDelegator businessDelegatorView;

	public void calcular() {
		try {
			entity.setResultado(businessDelegatorView.saveRegistroCalculo(entity).getResultado());
			
			FacesUtils.addInfoMessage("Se guardo el calculo exitosamente");
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}
	}
	
	public RegistroCalculoView() {
		super();
	}

	public List<RegistroCalculoDTO> getData() {
		try {
			if (data == null) {
				data = businessDelegatorView.getDataRegistroCalculo();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return data;
	}

	public void setData(List<RegistroCalculoDTO> registroCalculoDTO) {
		this.data = registroCalculoDTO;
	}

	public BusinessDelegator getBusinessDelegatorView() {
		return businessDelegatorView;
	}

	public void setBusinessDelegatorView(BusinessDelegator businessDelegatorView) {
		this.businessDelegatorView = businessDelegatorView;
	}

	public CalculoDTO getEntity() {
		if(entity==null)
			entity = new CalculoDTO();
		return entity;
	}

	public void setEntity(CalculoDTO entity) {
		this.entity = entity;
	}

	

}
