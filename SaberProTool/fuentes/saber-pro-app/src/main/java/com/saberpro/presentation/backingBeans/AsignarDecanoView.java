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
public class AsignarDecanoView implements Serializable {
	private static final long serialVersionUID = 1L;
	private static final Logger log = LoggerFactory.getLogger(AsignarDecanoView.class);

	private InputText txtCodigo;

	private CommandButton btnAsignar;	

	private SelectOneMenu somFacultad;
	
	private List<SelectItem> lasFacultadSelectItem;

	private boolean showDialog;
	
	private List<Usuario> data;

	@ManagedProperty(value = "#{BusinessDelegatorView}")
	private IBusinessDelegatorView businessDelegatorView;

	public AsignarDecanoView() {
		super();
	}	
	
	public void asignar() {
		//Try para capturar y manejar excepciones
		try {
			//se instancia un nuevo usuario con el usuaro loggeado en la sesión
			Usuario usuario = (Usuario) FacesUtils.getfromSession("usuario");
			//Se verifica que el usuario exista y el combo de facultad no esté vacío
			if(usuario!=null && FacesUtils.checkString(somFacultad)!=null) {
				
				long codigo = Long.parseLong(txtCodigo.getValue().toString());
				//Usuario
				//Instancia de los parámetros de busqueda para el método findByCriteria, en este caso, el código del usuario
				Object[] variable = {"codigo",true,codigo,"="};
				//Lista de usuarios del sistema
				List<Usuario> listUser = businessDelegatorView.findByCriteriaInUsuario(variable,null,null);
				//Lista de usuarios tipo Decano del sistema
				List<Usuario> listDecano = businessDelegatorView.findByTipoUsuarioFacultadUsuario(FacesUtils.checkInteger(somFacultad),Constantes.USER_TYPE_DECANO);
				if(listUser.size()==0) {
					throw new Exception("Ese codigo no es valido");				
				}
				if(listDecano.size()==0)
					businessDelegatorView.asignarDecano(listUser.get(0),null,usuario.getIdUsuario(),FacesUtils.checkInteger(somFacultad));
				else
					businessDelegatorView.asignarDecano(listUser.get(0),listDecano.get(0),usuario.getIdUsuario(),FacesUtils.checkInteger(somFacultad));
					
				data = null;
					
				FacesUtils.addInfoMessage("Se asignó el decano exitosamente");
				
				
			}
			else {
				FacesUtils.addErrorMessage("Verifique los datos");
			}
			
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
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

	public SelectOneMenu getSomFacultad() {
		return somFacultad;
	}

	public void setSomFacultad(SelectOneMenu somFacultad) {
		this.somFacultad = somFacultad;
	}

	public List<SelectItem> getLasFacultadSelectItem() {
		if(lasFacultadSelectItem==null) {
			try {
				
				Object[] variable = {"activo",true,Constantes.ESTADO_ACTIVO,"="};				
				List<Facultad> listFacultad = businessDelegatorView.findByCriteriaInFacultad(variable,null,null);
				lasFacultadSelectItem = new ArrayList<>();
				for (Facultad facultad : listFacultad) {
					lasFacultadSelectItem.add(new SelectItem(facultad.getIdFacultad(),facultad.getNombre()));
				}
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		return lasFacultadSelectItem;
	}

	public void setLasFacultadSelectItem(List<SelectItem> lasFacultadSelectItem) {
		this.lasFacultadSelectItem = lasFacultadSelectItem;
	}

	public List<Usuario> getData() {
		if(data==null) {
			try {
				if(FacesUtils.checkInteger(somFacultad)!=null) {
					data = businessDelegatorView.findByTipoUsuarioFacultadUsuario(FacesUtils.checkInteger(somFacultad),Constantes.USER_TYPE_DOCENTE);
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
