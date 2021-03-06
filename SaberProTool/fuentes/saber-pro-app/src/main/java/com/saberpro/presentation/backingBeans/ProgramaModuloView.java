package com.saberpro.presentation.backingBeans;

import com.saberpro.exceptions.*;

import com.saberpro.modelo.*;
import com.saberpro.modelo.dto.ProgramaModuloDTO;

import com.saberpro.presentation.businessDelegate.*;

import com.saberpro.utilities.*;

import org.primefaces.component.calendar.*;
import org.primefaces.component.commandbutton.CommandButton;
import org.primefaces.component.inputtext.InputText;

import org.primefaces.event.RowEditEvent;
import org.primefaces.model.DualListModel;
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
 * @author Zathura Code Generator http://zathuracode.org/
 * www.zathuracode.org
 *
 */
@ManagedBean
@ViewScoped
public class ProgramaModuloView implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final Logger log = LoggerFactory.getLogger(ProgramaModuloView.class);
    
    private DualListModel<Modulo> modulos; 
    
    private String facultad;
    private String programa;
    
    private CommandButton btnSave;
    
    private List<ProgramaModuloDTO> data;
    
    private ProgramaModuloDTO selectedProgramaModulo;
    
    private ProgramaModulo entity;
    
    
    private boolean showDialog;
    
    @ManagedProperty(value = "#{BusinessDelegatorView}")
    private IBusinessDelegatorView businessDelegatorView;

    public ProgramaModuloView() {
        super();
    }

    public String action_create() {
		try {
			Usuario usuario = (Usuario) FacesUtils.getfromSession("usuario");

			if(usuario!=null) {
				
				Object[] variable = {"usuario.idUsuario",true,usuario.getIdUsuario(),"=","activo",true,Constantes.ESTADO_ACTIVO,"="};		
				
				ProgramaUsuario programaUsuario = businessDelegatorView.findByCriteriaInProgramaUsuario(variable,null,null).get(0);	
				
				Object[] variable2 = {"programa.idPrograma",true,programaUsuario.getPrograma().getIdPrograma(),"=","activo",true,Constantes.ESTADO_ACTIVO,"="};
				
				List<Modulo> modulosTarget = modulos.getTarget();
				
				List<ProgramaModulo> listPrograma = businessDelegatorView.findByCriteriaInProgramaModulo(variable2,null,null);
				for (ProgramaModulo programaModulo : listPrograma) {
					businessDelegatorView.deleteProgramaModulo(programaModulo);
				}
				for (Modulo modulo : modulosTarget) {
					ProgramaModulo programaModulo = new ProgramaModulo();
					programaModulo.setActivo(Constantes.ESTADO_ACTIVO);
					programaModulo.setFechaCreacion(new Date());
					programaModulo.setModulo(modulo);
					programaModulo.setPrograma(businessDelegatorView.getPrograma(programaUsuario.getPrograma().getIdPrograma()));
					programaModulo.setUsuCreador(usuario.getIdUsuario());
					
					businessDelegatorView.saveProgramaModulo(programaModulo);
				}
				
				FacesUtils.addInfoMessage("Se actualizó correctamente");
			}

		} catch (Exception e) {			
			FacesUtils.addErrorMessage(e.getMessage());
			log.error("Erro de creación de usuario en "+e.getMessage(),e);
		}

		return "";

	}

    public List<ProgramaModuloDTO> getData() {
        try {
            if (data == null) {
                data = businessDelegatorView.getDataProgramaModulo();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return data;
    }

    public void setData(List<ProgramaModuloDTO> programaModuloDTO) {
        this.data = programaModuloDTO;
    }

    public ProgramaModuloDTO getSelectedProgramaModulo() {
        return selectedProgramaModulo;
    }

    public void setSelectedProgramaModulo(ProgramaModuloDTO programaModulo) {
        this.selectedProgramaModulo = programaModulo;
    }

    public CommandButton getBtnSave() {
        return btnSave;
    }

    public void setBtnSave(CommandButton btnSave) {
        this.btnSave = btnSave;
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



	public DualListModel<Modulo> getModulos() {
		if(modulos==null) {
			try {
				Usuario usuario = (Usuario) FacesUtils.getfromSession("usuario");
				
				Object[] variable = {"tipoModulo.idTipoModulo",true,Constantes.MODULO_TYPE_ESPECIFICO,"=","activo",true,Constantes.ESTADO_ACTIVO,"="};
				Object[] variable2 = {"usuario.idUsuario",true,usuario.getIdUsuario(),"=","activo",true,Constantes.ESTADO_ACTIVO,"="};
				
				ProgramaUsuario programaUsuario = businessDelegatorView.findByCriteriaInProgramaUsuario(variable2,null,null).get(0);			
				
				
				List<Modulo> modulosSource = businessDelegatorView.findByCriteriaInModulo(variable,null,null);
		        List<Modulo> modulosTarget = businessDelegatorView.findByProgramaModulo(programaUsuario.getPrograma().getIdPrograma());
		      
		        
		        for(int j=0;j<modulosTarget.size();j++) {
		        	for(int i=0;i<modulosSource.size();i++) {
		        		if(modulosSource.get(i).getIdModulo().equals(modulosTarget.get(j).getIdModulo())) {
		        			modulosSource.remove(i);
		        		}
		        	}
		        }
		        
		        modulos = new DualListModel<Modulo>(modulosSource,modulosTarget);
				
			} catch (Exception e) {
				log.error("Error en: "+e.getMessage(),e);
			}
		}
		return modulos;
	}



	public void setModulos(DualListModel<Modulo> modulos) {
		this.modulos = modulos;
	}



	public String getFacultad() {
		if(facultad==null) {
			try {
				Usuario usuario = (Usuario) FacesUtils.getfromSession("usuario");							
				Object[] variable = {"usuario.idUsuario",true,usuario.getIdUsuario(),"=","activo",true,Constantes.ESTADO_ACTIVO,"="};				
				ProgramaUsuario programaUsuario = businessDelegatorView.findByCriteriaInProgramaUsuario(variable,null,null).get(0);	
				Programa programa = businessDelegatorView.getPrograma(programaUsuario.getPrograma().getIdPrograma());
				facultad = businessDelegatorView.getFacultad(programa.getFacultad().getIdFacultad()).getNombre();
			} catch (Exception e) {
				log.error("Error de "+e.getMessage(),e);
			}
		}
		return facultad;
	}



	public void setFacultad(String facultad) {
		this.facultad = facultad;
	}



	public String getPrograma() {
		if(programa==null) {
			try {
				Usuario usuario = (Usuario) FacesUtils.getfromSession("usuario");							
				Object[] variable = {"usuario.idUsuario",true,usuario.getIdUsuario(),"=","activo",true,Constantes.ESTADO_ACTIVO,"="};				
				ProgramaUsuario programaUsuario = businessDelegatorView.findByCriteriaInProgramaUsuario(variable,null,null).get(0);	
				
				programa = businessDelegatorView.getPrograma(programaUsuario.getPrograma().getIdPrograma()).getNombre();
			} catch (Exception e) {
				log.error("Error de "+e.getMessage(),e);
			}
		}
		return programa;
	}



	public void setPrograma(String programa) {
		this.programa = programa;
	}
}
