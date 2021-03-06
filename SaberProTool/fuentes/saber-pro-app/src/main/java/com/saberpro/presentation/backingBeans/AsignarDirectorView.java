package com.saberpro.presentation.backingBeans;

import com.saberpro.exceptions.*;

import com.saberpro.modelo.*;
import com.saberpro.modelo.dto.EstadoPruebaDTO;

import com.saberpro.presentation.businessDelegate.*;

import com.saberpro.utilities.*;

import org.hibernate.annotations.Check;
import org.primefaces.component.calendar.*;
import org.primefaces.component.commandbutton.CommandButton;
import org.primefaces.component.inputtext.InputText;
import org.primefaces.component.inputtextarea.InputTextarea;
import org.primefaces.component.selectonemenu.SelectOneMenu;
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
import javax.faces.model.SelectItem;

/**
 * @author Zathura Code Generator http://zathuracode.org/ www.zathuracode.org
 *
 */
@ManagedBean
@ViewScoped
public class AsignarDirectorView implements Serializable {
	private static final long serialVersionUID = 1L;
	private static final Logger log = LoggerFactory.getLogger(AsignarDirectorView.class);

	private InputText txtCodigo;

	private CommandButton btnAsignar;	

	private SelectOneMenu somPrograma;
	
	private List<SelectItem> lasProgramasoSelectItem;
	
	private String facultad;	

	private boolean showDialog;
	
	private List<Usuario> data;

	@ManagedProperty(value = "#{BusinessDelegatorView}")
	private IBusinessDelegatorView businessDelegatorView;

	public AsignarDirectorView() {
		super();
	}	
	
	public void asignar() {
		try {
			Usuario usuario = (Usuario) FacesUtils.getfromSession("usuario");
			if(usuario!=null && FacesUtils.checkString(somPrograma)!=null) {
				long codigo = Long.parseLong(txtCodigo.getValue().toString());
				//Usuario
				Object[] variable = {"codigo",true,codigo,"="};
				List<Usuario> listUser = businessDelegatorView.findByCriteriaInUsuario(variable,null,null);
				List<Usuario> listDirector = businessDelegatorView.findByTipoUsuarioProgramaUsuario(FacesUtils.checkInteger(somPrograma),Constantes.USER_TYPE_DIRECTOR);
				if(listUser.size()!=0) {
					Usuario director = listUser.get(0);
					if(listDirector.size()!=0) {
						Usuario despedido = listDirector.get(0);
						despedido.setTipoUsuario(businessDelegatorView.getTipoUsuario(Constantes.USER_TYPE_DOCENTE));
						despedido.setFechaModificacion(new Date());
						despedido.setUsuModificador(usuario.getIdUsuario());
						
						businessDelegatorView.updateUsuario(despedido);
					}
					director.setTipoUsuario(businessDelegatorView.getTipoUsuario(Constantes.USER_TYPE_DIRECTOR));
					director.setFechaModificacion(new Date());
					director.setUsuModificador(usuario.getIdUsuario());
					
					businessDelegatorView.updateUsuario(director);
					
					data = null;
					
					FacesUtils.addInfoMessage("Se asignó el director correctamente");
				}
				
			}
			else {
				FacesUtils.addErrorMessage("Verifique los datos");
			}
			
		} catch (Exception e) {
			FacesUtils.addErrorMessage("Verifique los datos");
			log.error(e.getMessage(),e);
		}
	}
	
	public void limpiar() {
		data = null;	
	}

	public TimeZone getTimeZone() {
		return java.util.TimeZone.getDefault();
	}

	public IBusinessDelegatorView getBusinessDelegatorView() {
		return businessDelegatorView;
	}

	public void setBusinessDelegatorView(IBusinessDelegatorView businessDelegatorView) {
		this.businessDelegatorView = businessDelegatorView;
	}

	public boolean isShowDialog() {
		return showDialog;
	}

	public void setShowDialog(boolean showDialog) {
		this.showDialog = showDialog;
	}

	public InputText getTxtCodigo() {
		return txtCodigo;
	}

	public void setTxtCodigo(InputText txtCodigo) {
		this.txtCodigo = txtCodigo;
	}

	public CommandButton getBtnAsignar() {
		return btnAsignar;
	}

	public void setBtnAsignar(CommandButton btnAsignar) {
		this.btnAsignar = btnAsignar;
	}

	public SelectOneMenu getSomPrograma() {
		return somPrograma;
	}

	public void setSomPrograma(SelectOneMenu somPrograma) {
		this.somPrograma = somPrograma;
	}

	public List<SelectItem> getLasProgramasoSelectItem() {
		if(lasProgramasoSelectItem==null) {
			try {
				Usuario usuario = (Usuario) FacesUtils.getfromSession("usuario");	
				Object[] variable = {"usuario.idUsuario",true,usuario.getIdUsuario(),"="};				
				List<ProgramaUsuario> listUsuario = businessDelegatorView.findByCriteriaInProgramaUsuario(variable,null,null);
				lasProgramasoSelectItem = new ArrayList<>();
				for (ProgramaUsuario programaUsuario : listUsuario) {
					Programa programa = businessDelegatorView.getPrograma(programaUsuario.getPrograma().getIdPrograma());
					lasProgramasoSelectItem.add(new SelectItem(programa.getIdPrograma(),programa.getNombre()));
				}
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		return lasProgramasoSelectItem;
	}

	public void setLasProgramasoSelectItem(List<SelectItem> lasProgramasoSelectItem) {
		this.lasProgramasoSelectItem = lasProgramasoSelectItem;
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

	public List<Usuario> getData() {
		if(data==null) {
			try {
				if(FacesUtils.checkInteger(somPrograma)!=null) {
					data = businessDelegatorView.findByTipoUsuarioProgramaUsuario(FacesUtils.checkInteger(somPrograma),Constantes.USER_TYPE_DOCENTE);
				}
			} catch (Exception e) {
				log.error(e.getMessage(),e);
			}
			
		}
		return data;
	}

	public void setData(List<Usuario> data) {
		this.data = data;
	}
	
}
