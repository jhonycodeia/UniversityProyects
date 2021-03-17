package com.co.indra.view;

import com.co.indra.dto.RegistroCalculoDTO;
import com.co.indra.exception.*;
import com.co.indra.exception.ZMessManager.NullEntityExcepcion;
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
public class ConsultarView implements Serializable {
	private static final long serialVersionUID = 1L;
	private static final Logger log = LoggerFactory.getLogger(ConsultarView.class);

	private List<RegistroCalculoDTO> data;

	private String user;
	private int minimo;
	private int maximo;

	@ManagedProperty(value = "#{businessDelegator}")
	private BusinessDelegator businessDelegatorView;

	public ConsultarView() {
		super();
	}
	
	public void limpiar() {
		minimo=0;
		maximo=0;
		user="";
		data = null;
	}
	
	public void consultar() {
		try {
			if(minimo>maximo && maximo!=0) {
				throw new ZMessManager("El valor minimo no puede ser mayor al maximo");
			}
			
			
			data = null;
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}
		
	}

	public void borrar(Integer id) {
		try {
			RegistroCalculo registro = businessDelegatorView.getRegistroCalculo(id);

			if (registro != null) {
				businessDelegatorView.deleteRegistroCalculo(registro);
			}

			FacesUtils.addInfoMessage("Se borro exitosamente");

			data = null;
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}
	}

	public List<RegistroCalculoDTO> getData() {
		try {
			if (data == null) {
				data = businessDelegatorView.getDataRegistroCalculo();
				if(!user.trim().isEmpty()) {
					data.removeIf(n -> (!n.getName().toLowerCase().contains(user)));
				}
				if(minimo!=0) {
					data.removeIf(n -> (n.getResultado().intValue()<minimo));
				}
				
				if(maximo!=0) {
					data.removeIf(n -> (n.getResultado().intValue()>maximo));
				}
				
			}
		} catch (Exception e) {
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

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public int getMinimo() {
		return minimo;
	}

	public void setMinimo(int minimo) {
		this.minimo = minimo;
	}

	public int getMaximo() {
		return maximo;
	}

	public void setMaximo(int maximo) {
		this.maximo = maximo;
	}

}
