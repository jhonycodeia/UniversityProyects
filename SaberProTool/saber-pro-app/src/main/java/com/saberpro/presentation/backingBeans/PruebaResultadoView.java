package com.saberpro.presentation.backingBeans;

import com.saberpro.exceptions.*;

import com.saberpro.modelo.*;
import com.saberpro.modelo.dto.PruebaDTO;
import com.saberpro.modelo.dto.PruebaProgramaUsuarioDTO;
import com.saberpro.modelo.dto.ResultadosModuloDTO;
import com.saberpro.presentation.businessDelegate.*;

import com.saberpro.utilities.*;

import org.primefaces.component.calendar.*;
import org.primefaces.component.commandbutton.CommandButton;
import org.primefaces.component.inputtext.InputText;
import org.primefaces.component.selectonemenu.SelectOneMenu;
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
import java.util.Map;
import java.util.Set;
import java.util.TimeZone;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.model.SelectItem;


/**
 * @author Zathura Code Generator http://zathuracode.org/
 * www.zathuracode.org
 *
 */
@ManagedBean
@ViewScoped
public class PruebaResultadoView implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final Logger log = LoggerFactory.getLogger(PruebaResultadoView.class); 
    
    private Long id;
    
    private List<ResultadosModuloDTO> data;      
    
    private boolean showDialog;
    
    @ManagedProperty(value = "#{BusinessDelegatorView}")
    private IBusinessDelegatorView businessDelegatorView;

    public PruebaResultadoView() {
        super();
    }  
    @PostConstruct
	public void comprobar() {
		try {
			FacesContext facesContext = FacesContext.getCurrentInstance();
			Map params = facesContext.getExternalContext().getRequestParameterMap();
			id = new Long((String) params.get("id"));
			if (id == null) {
				FacesContext.getCurrentInstance().getExternalContext().redirect("prueba.xhtml");
			}				
			else {
				Usuario usuario = (Usuario) FacesUtils.getfromSession("usuario");
        		if(usuario!=null) {
        			
        			PruebaProgramaUsuario pruebaProgramaUsuario = businessDelegatorView.getPruebaProgramaUsuario(id);    				
    				
    				if(pruebaProgramaUsuario.getEstadoPrueba().getIdEstadoPrueba()!=Constantes.PRUEBA_ESTADO_FINALIZADA) {
    					FacesContext.getCurrentInstance().getExternalContext().redirect("prueba.xhtml");
    				}
    				
        			Object[] variable = {"usuario.idUsuario",true,usuario.getIdUsuario(),"=","activo",true,Constantes.ESTADO_ACTIVO,"="};   		
        			ProgramaUsuario programaUsuario = businessDelegatorView.findByCriteriaInProgramaUsuario(variable,null,null).get(0);        			
        			data = businessDelegatorView.findResultado(programaUsuario.getIdProgramaUsuario(),id);
        		}
							
				
			}
		} catch (Exception e) {
			try {
				FacesContext.getCurrentInstance().getExternalContext().redirect("prueba.xhtml");
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
	}
    
    /* Getter and Setter*/
    public List<ResultadosModuloDTO> getData() {       
    	return data;
    }

    public void setData(List<ResultadosModuloDTO> pruebaDTO) {
        this.data = pruebaDTO;
    }

   

    public TimeZone getTimeZone() {
        return java.util.TimeZone.getDefault();
    }

    public IBusinessDelegatorView getBusinessDelegatorView() {
        return businessDelegatorView;
    }

    public void setBusinessDelegatorView(
        IBusinessDelegatorView businessDelegatorView) {
        this.businessDelegatorView = businessDelegatorView;
    }

    public boolean isShowDialog() {
        return showDialog;
    }

    public void setShowDialog(boolean showDialog) {
        this.showDialog = showDialog;
    }

}
