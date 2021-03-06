package com.green.view;

import com.green.modelo.*;
import com.green.utility.*;

import org.primefaces.PrimeFaces;
import org.primefaces.component.chips.Chips;
import org.primefaces.component.commandbutton.CommandButton;
import org.primefaces.component.inputtext.InputText;
import org.primefaces.component.inputtextarea.InputTextarea;
import org.primefaces.component.selectonemenu.SelectOneMenu;
import org.primefaces.context.RequestContext;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;

/**
 * @author Zathura Code Generator http://zathuracode.org/ www.zathuracode.org
 *
 */
@ManagedBean
@ViewScoped
public class ValidarCapsulaView implements Serializable {
	private static final long serialVersionUID = 1L;
	private static final Logger log = LoggerFactory.getLogger(ValidarCapsulaView.class);

	private Capsula capsula;
	private Usuario usuario;

	private List<PreguntaComponent> preguntas;
	
	private String contenido;
	private String machete;

	@ManagedProperty(value = "#{businessDelegator}")
	private BusinessDelegator businessDelegatorView;

	public ValidarCapsulaView() {
		super();
	}
	
	public void revisar() {
		try {
			for (PreguntaComponent preguntaComponent : preguntas) {
				if(preguntaComponent.getRespuesta()==null || preguntaComponent.getRespuesta().isEmpty()) {
					throw new Exception("Debe contestar todas las preguntas");
				}
			}
			boolean pasa = true;
			for (PreguntaComponent preguntaComponent : preguntas) {
				if(preguntaComponent.getRespuesta().equals("NO")) {
					pasa = false;
				}
			}
			
			businessDelegatorView.validarCapsula(capsula, usuario, pasa);
			FacesContext.getCurrentInstance().getExternalContext().redirect("misValidarCapsula.xhtml");
			
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}
	}
	

	public void cargarDatos() {
		try {

			FacesContext facesContext = FacesContext.getCurrentInstance();
			Map params = facesContext.getExternalContext().getRequestParameterMap();
			Long id = new Long((String) params.get("id"));

			if (id != null) {
				log.info("se recupero el id " + id);

				capsula = businessDelegatorView.getCapsula(id);
				usuario = (Usuario) FacesUtils.getfromSession("usuario");
				
				if (usuario.getIdUsuario() == capsula.getUsuario().getIdUsuario()
						|| !capsula.getActivo().equals(Constantes.ESTADO_PENDIENTE)) {					
					FacesUtils.addErrorMessage("No se pudo cargar su capsula correctamente");
					FacesContext.getCurrentInstance().getExternalContext().redirect("../dashboard.xhtml");
				}
				
				contenido = "";
				
				if(!capsula.getValor().equals("capsula guia")) {
					contenido = contenido +"Contenido:\n" + capsula.getValor();
				}
				if(capsula.getSituacion()!=null) {
					contenido = contenido + "\nSituacion:\n" + capsula.getSituacion();
				}
				if(capsula.getResolucion()!=null) {
					contenido = contenido +"\nResolucion:\n" + capsula.getResolucion();
				}
				if(capsula.getDisparador()!=null) {
					contenido = contenido + "\nDisparador:\n" + capsula.getDisparador();
				}

				/*if (usuario.getIdUsuario() != capsula.getUsuario().getIdUsuario()) {
					FacesContext.getCurrentInstance().getExternalContext().redirect("../dashboard.xhtml");
				}
				if (capsula.getTipoCapsula().getIdTipoCapsula() != Constantes.CAPSULA_TYPE_ESTANDAR) {
					FacesContext.getCurrentInstance().getExternalContext().redirect("../dashboard.xhtml");
				}*/		
				
				cargarPreguntas();

				PrimeFaces.current().ajax().update("form:panel_datos");

			}

		} catch (Exception e) {
			log.debug("Error " + e.getMessage(), e);
		}
	}
	
	public void cargarPreguntas() {
		if(capsula.getTipoCapsula().getIdTipoCapsula()==Constantes.CAPSULA_TYPE_ESTANDAR) {
			cargarEstandar();
		}else if(capsula.getTipoCapsula().getIdTipoCapsula()==Constantes.CAPSULA_TYPE_TOOL){
			cargarTool();
		}else if(capsula.getTipoCapsula().getIdTipoCapsula()==Constantes.CAPSULA_TYPE_GUIA) {
			cargarGuia();
		}
	}
	
	public void cargarEstandar() {
		preguntas = new ArrayList<PreguntaComponent>();
		
		preguntas.add(new PreguntaComponent("¿La idea generada es valida para ser aplicada en la empresa?",""));
		preguntas.add(new PreguntaComponent("¿La idea generada se enfoca en algun proceso especifico de la empresa?",""));
		preguntas.add(new PreguntaComponent("La idea generada se enfoca en Pruebas funcionales",""));
		preguntas.add(new PreguntaComponent("La idea generada se enfoca en Automatizacion",""));
		preguntas.add(new PreguntaComponent("La idea generada se enfoca en Pruebas no funcionales",""));
		preguntas.add(new PreguntaComponent("La idea generada se enfoca en Area de tecnologia y desarrollo",""));
		preguntas.add(new PreguntaComponent("¿La idea generada se basa en alguna idea de conocimiento previamente registrada?",""));
		preguntas.add(new PreguntaComponent("¿La idea generada se basa en algun prototipo de conocimiento previamente registrado?",""));
		preguntas.add(new PreguntaComponent("¿La idea generada se basa en alguna guia de conocimiento previamente registrada?",""));		
	}
	
	public void cargarTool() {			
		preguntas = new ArrayList<PreguntaComponent>();
		
		preguntas.add(new PreguntaComponent("¿El prototipo de conocimiento generado es applicable dentro de la organzacion?",""));
		preguntas.add(new PreguntaComponent("¿El prototipo de conocimiento fue generado con base en algun otro prototipo?",""));
		preguntas.add(new PreguntaComponent("La idea generada se enfoca en Pruebas funcionales",""));
		preguntas.add(new PreguntaComponent("La idea generada se enfoca en Automatizacion",""));
		preguntas.add(new PreguntaComponent("La idea generada se enfoca en Pruebas no funcionales",""));
		preguntas.add(new PreguntaComponent("La idea generada se enfoca en Area de tecnologia y desarrollo",""));
		preguntas.add(new PreguntaComponent("¿El prototipo de conocimiento generado se basa en alguna idea de conocimiento previamente registrada?",""));
		preguntas.add(new PreguntaComponent("¿El prototipo de conocimiento generado se basa en algun prototipo de conocimiento previamente registrado?",""));
		preguntas.add(new PreguntaComponent("¿El prototipo de conocimiento generado se basa en alguna guia de conocimiento previamente registrada?",""));
		preguntas.add(new PreguntaComponent("¿El prototipo de conocimiento generado puede seguir madurando?",""));
		preguntas.add(new PreguntaComponent("¿El prototipo de conocimiento tiene ideas, prototipos, guias o artefactos de conocimiento asociados?",""));
		preguntas.add(new PreguntaComponent("¿El prototipo de conocimiento generado es innovador?",""));
	}
	
	public void cargarGuia() {
		preguntas = new ArrayList<PreguntaComponent>();
		
		preguntas.add(new PreguntaComponent("¿La guia de conocimiento generado es applicable dentro de la organzacion?",""));
		preguntas.add(new PreguntaComponent("¿La guia de conocimiento fue generado con base en algun otro prototipo?",""));
		preguntas.add(new PreguntaComponent("La idea generada se enfoca en Pruebas funcionales",""));
		preguntas.add(new PreguntaComponent("La idea generada se enfoca en Automatizacion",""));
		preguntas.add(new PreguntaComponent("La idea generada se enfoca en Pruebas no funcionales",""));
		preguntas.add(new PreguntaComponent("La idea generada se enfoca en Area de tecnologia y desarrollo",""));
		preguntas.add(new PreguntaComponent("¿La guia de conocimiento generado se basa en alguna idea de conocimiento previamente registrada?",""));
		preguntas.add(new PreguntaComponent("¿La guia de conocimiento generado se basa en algun prototipo de conocimiento previamente registrado?",""));
		preguntas.add(new PreguntaComponent("¿La guia de conocimiento generado se basa en alguna guia de conocimiento previamente registrada?",""));
		preguntas.add(new PreguntaComponent("¿La guia de conocimiento generado puede seguir madurando?",""));
		preguntas.add(new PreguntaComponent("¿La guia de conocimiento tiene ideas, prototipos, guias o artefactos de conocimiento asociados?",""));
		preguntas.add(new PreguntaComponent("¿La guia de conocimiento generada es innovador?",""));
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

	public String getMachete() {
		cargarDatos();
		return machete;
	}

	public void setMachete(String machete) {
		this.machete = machete;
	}

	public String getContenido() {
		return contenido;
	}

	public void setContenido(String contenido) {
		this.contenido = contenido;
	}

	public List<PreguntaComponent> getPreguntas() {
		return preguntas;
	}

	public void setPreguntas(List<PreguntaComponent> preguntas) {
		this.preguntas = preguntas;
	}

}
