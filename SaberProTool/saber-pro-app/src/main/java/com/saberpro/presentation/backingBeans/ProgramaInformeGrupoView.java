package com.saberpro.presentation.backingBeans;

import com.saberpro.exceptions.*;

import com.saberpro.modelo.*;
import com.saberpro.modelo.dto.ProgramaModuloDTO;

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
public class ProgramaInformeGrupoView implements Serializable {
	private static final long serialVersionUID = 1L;
	private static final Logger log = LoggerFactory.getLogger(ProgramaInformeGrupoView.class);

	private DualListModel<Usuario> usuarios;
	
	private SelectOneMenu somTipoModulo;
	private SelectOneMenu somModulo;
	 
	private String periodo;
	
	private List<SelectItem> lasModuloSelectItem;	
	private List<SelectItem> lasTipoPruebaSelectItem;

	private CommandButton btnSave;

	@ManagedProperty(value = "#{BusinessDelegatorView}")
	private IBusinessDelegatorView businessDelegatorView;

	public ProgramaInformeGrupoView() {
		super();
	}
	
	

	public StreamedContent getReportePDF() {
		try {	
			if(FacesUtils.checkString(somModulo)==null || FacesUtils.checkString(somTipoModulo)==null || periodo==null)
				throw new Exception("Verifique los datos");
			if(usuarios.getTarget().size()==0)
				throw new Exception("Debe seleccionar al menos 1 estudiante para generar el reporte");
			
			long idTipoPrueba = FacesUtils.checkLong(somTipoModulo);
			long idModulo = FacesUtils.checkLong(somModulo);
			
			List<String> correos = new ArrayList<>();
			
			for (Usuario usuario : usuarios.getTarget()) {
				correos.add(usuario.getCorreo());
			}
			
			ByteArrayInputStream bais = businessDelegatorView.generarInformeGrupo(idTipoPrueba,VariablesSession.programa.getIdPrograma(), idModulo, periodo, correos);
			StreamedContent archivo = new DefaultStreamedContent(bais, "application/pdf",
					"informe-grupal.pdf");

			return archivo;

		} catch (Exception e) {
			FacesUtils.addErrorMessage("No se pudo generar el reporte por falta de informacion intente con otra combinacion");
			e.printStackTrace();
			return null;
		}
	}

	public DualListModel<Usuario> getUsuarios() {
		if (usuarios == null) {
			try {
				List<Usuario> usuario = businessDelegatorView.findByTipoUsuarioProgramaUsuario(
						VariablesSession.programa.getIdPrograma(), Constantes.USER_TYPE_ESTUDIANTE);

				List<Usuario> usuarioSource = new ArrayList<>();
				List<Usuario> usuarioTarget = new ArrayList<>();

				for (Usuario estudiante : usuario) {
					Object[] variableUsuario = { "usuario.idUsuario", true, estudiante.getIdUsuario(), "=", "activo",
							true, Constantes.ESTADO_ACTIVO, "=" };

					ProgramaUsuario programaUsuario = businessDelegatorView
							.findByCriteriaInProgramaUsuario(variableUsuario, null, null).get(0);

					Object[] variablePrueba = { "programaUsuario.idProgramaUsuario", true,
							programaUsuario.getIdProgramaUsuario(), "=" };
					
					List<PruebaProgramaUsuario> listPrueba = businessDelegatorView.findByCriteriaInPruebaProgramaUsuario(variablePrueba, null, null);
					
					if(listPrueba.size()!=0)
						usuarioSource.add(estudiante);
				}

				usuarios = new DualListModel<Usuario>(usuarioSource, usuarioTarget);

			} catch (Exception e) {
				log.error("error de " + e.getMessage(), e);
			}
		}
		return usuarios;
	}
	
public List<SelectItem> getLasModuloSelectItem() {
		
		if(lasModuloSelectItem==null) {				
				Object[] variable = {"tipoModulo",true,Constantes.MODULO_TYPE_GENERICO,"=","activo",true,Constantes.ESTADO_ACTIVO,"="};
				lasModuloSelectItem = new ArrayList<>();				
				try {
					log.info("El tipo de usuario es "+VariablesSession.tipoUsuario.getIdTipoUsuario());
					List<Modulo> list = businessDelegatorView.findByCriteriaInModulo(variable,null,null);
					list.addAll(businessDelegatorView.findByProgramaModulo(VariablesSession.programa.getIdPrograma()));			
					
					for (Modulo modulo : list) {
						lasModuloSelectItem.add(new SelectItem(modulo.getIdModulo(),modulo.getNombre()));
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

	public void setUsuarios(DualListModel<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	public CommandButton getBtnSave() {
		return btnSave;
	}

	public void setBtnSave(CommandButton btnSave) {
		this.btnSave = btnSave;
	}

	public IBusinessDelegatorView getBusinessDelegatorView() {
		return businessDelegatorView;
	}

	public void setBusinessDelegatorView(IBusinessDelegatorView businessDelegatorView) {
		this.businessDelegatorView = businessDelegatorView;
	}

	public List<SelectItem> getLasTipoPruebaSelectItem() {
		if(lasTipoPruebaSelectItem==null) {
			try {
				lasTipoPruebaSelectItem = new ArrayList<>();
				List<TipoPrueba> list = businessDelegatorView.getTipoPrueba(Constantes.ESTADO_ACTIVO);
				
				for (TipoPrueba tipoPrueba : list) {
					lasTipoPruebaSelectItem.add(new SelectItem(tipoPrueba.getIdTipoPrueba(),tipoPrueba.getNombre()));
				}
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		return lasTipoPruebaSelectItem;
	}

	public void setLasTipoPruebaSelectItem(List<SelectItem> lasTipoPruebaSelectItem) {
		this.lasTipoPruebaSelectItem = lasTipoPruebaSelectItem;
	}

	public SelectOneMenu getSomTipoModulo() {
		return somTipoModulo;
	}

	public void setSomTipoModulo(SelectOneMenu somTipoModulo) {
		this.somTipoModulo = somTipoModulo;
	}

	public SelectOneMenu getSomModulo() {
		return somModulo;
	}

	public void setSomModulo(SelectOneMenu somModulo) {
		this.somModulo = somModulo;
	}

	public String getPeriodo() {
		return periodo;
	}

	public void setPeriodo(String periodo) {
		this.periodo = periodo;
	}

}
