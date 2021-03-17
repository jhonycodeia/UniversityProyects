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

/**
 * @author Zathura Code Generator http://zathuracode.org/ www.zathuracode.org
 *
 */
@ManagedBean
@ViewScoped
public class ProgramaInformeEstudianteView implements Serializable {
	private static final long serialVersionUID = 1L;
	private static final Logger log = LoggerFactory.getLogger(ProgramaInformeEstudianteView.class);

	private InputText txtCodigo;

	private CommandButton btnSave;

	private List<PruebaProgramaUsuario> data;
	private List<Usuario> losUsuarios;

	@ManagedProperty(value = "#{BusinessDelegatorView}")
	private IBusinessDelegatorView businessDelegatorView;

	public ProgramaInformeEstudianteView() {
		super();
	}

	public void consultarPrueba() {

		try {
			if(txtCodigo==null)
				throw new Exception("Escriba un codigo");
			String codigo = FacesUtils.checkString(txtCodigo);
			if (codigo==null || codigo.isEmpty())
				throw new Exception("Escriba un codigo");
			Usuario usuario = businessDelegatorView.findByCodigoUsuario(Long.parseLong(codigo));
			Object[] variables = { "usuario.idUsuario", true, usuario.getIdUsuario(), "=" };
			ProgramaUsuario programaUsuario = businessDelegatorView
					.findByCriteriaInProgramaUsuario(variables, null, null).get(0);
			Object[] variables2 = { "programaUsuario.idProgramaUsuario", true, programaUsuario.getIdProgramaUsuario(),
					"=" };
			data = businessDelegatorView.findByCriteriaInPruebaProgramaUsuario(variables2, null, null);
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
			e.printStackTrace();
		}

	}
	
	public StreamedContent getReportePDF(long idPruebaProgramaUsuario) {
		try {

			// TODO: Ojo quemado el 35

			PruebaProgramaUsuario pruebaProgramaUsuario = businessDelegatorView.getPruebaProgramaUsuario(idPruebaProgramaUsuario);
			
			if (pruebaProgramaUsuario== null) {
				throw new Exception("No existe la prueba " + idPruebaProgramaUsuario);
			}

			ByteArrayInputStream bais = businessDelegatorView.generarInformeIndividual(idPruebaProgramaUsuario);
			StreamedContent archivo = new DefaultStreamedContent(bais, "application/pdf",
					"prueba-" + idPruebaProgramaUsuario + ".pdf");

			return archivo;

		} catch (Exception e) {
			FacesUtils.addErrorMessage("NO se pudo generar el reporte por falta de informacion");
			e.printStackTrace();
			return null;
		}
	}

	public List<PruebaProgramaUsuario> getData() {
		try {
			if (data == null) {

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return data;
	}

	public void setData(List<PruebaProgramaUsuario> prueba) {
		this.data = prueba;
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

	public List<Usuario> getLosUsuarios() {
		if (losUsuarios == null) {
			try {
				losUsuarios = businessDelegatorView.findByTipoUsuarioProgramaUsuario(
						VariablesSession.programa.getIdPrograma(), Constantes.USER_TYPE_ESTUDIANTE);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return losUsuarios;
	}

	public void setLosUsuarios(List<Usuario> losUsuarios) {
		this.losUsuarios = losUsuarios;
	}

	public InputText getTxtCodigo() {
		return txtCodigo;
	}

	public void setTxtCodigo(InputText txtCodigo) {
		this.txtCodigo = txtCodigo;
	}

}
