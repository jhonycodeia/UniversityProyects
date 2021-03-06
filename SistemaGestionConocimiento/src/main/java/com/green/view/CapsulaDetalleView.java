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
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;
import org.primefaces.model.UploadedFile;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
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
public class CapsulaDetalleView implements Serializable {
	private static final long serialVersionUID = 1L;
	private static final Logger log = LoggerFactory.getLogger(CapsulaDetalleView.class);

	private boolean validad = true;
	private boolean hija = false;

	// locales
	private Usuario usuario;
	private Capsula capsula;
	private Usuario usuarioCreador;

	// modelo
	private String txtComentario;

	// Datos de biding
	private String machete;
	private String titulo;
	private String creadorName;
	private String fechaPost;
	private String descripcion;
	private String contenido;
	private String disparador;
	private String situacion;
	private String resolucion;

	private List<Capsula> hijas;
	private List<FilesDocumento> files;
	private List<ComentarioComponent> comentarios;

	@ManagedProperty(value = "#{businessDelegator}")
	private BusinessDelegator businessDelegatorView;

	public CapsulaDetalleView() {
		super();
	}

	public void cargarDatos() {
		try {

			FacesContext facesContext = FacesContext.getCurrentInstance();
			Map params = facesContext.getExternalContext().getRequestParameterMap();
			Long id = new Long((String) params.get("id"));

			if (id != null) {
				log.info("se recupero el para ver detalle id " + id);

				capsula = businessDelegatorView.getCapsula(id);
				usuarioCreador = businessDelegatorView.getUsuario(capsula.getUsuario().getIdUsuario());
				usuario = (Usuario) FacesUtils.getfromSession("usuario");
				
				Object[] variablesNotificaciones = { "usuario.idUsuario", true, usuario.getIdUsuario(), "=",
									   "capsula.idCapsula", true, capsula.getIdCapsula(), "=",
									   "activo", true, Constantes.ESTADO_PENDIENTE, "="};
				
				List<Notificacion> listNotificaciones = businessDelegatorView.findByCriteriaInNotificacion(variablesNotificaciones, null, null);
				
				for (Notificacion notificacion : listNotificaciones) {
					notificacion.setActivo(Constantes.ESTADO_ACTIVO);
					notificacion.setUsuModificador(usuario.getIdUsuario());
					notificacion.setFechaModificacion(new Date());
					
					businessDelegatorView.updateNotificacion(notificacion);
				}

				if (!capsula.getActivo().equals(Constantes.ESTADO_ACTIVO)) {
					FacesContext.getCurrentInstance().getExternalContext().redirect("../dashboard.xhtml");
				}

				titulo = capsula.getTitulo();
				creadorName = usuarioCreador.getNombre() + " " + usuarioCreador.getApellido() + " ("
						+ usuarioCreador.getCorreo() + ")";
				if (capsula.getFechaModificacion() != null) {
					fechaPost = Constantes.FORMATO_FECHA_SIMPLE.format(capsula.getFechaModificacion());
				} else {
					fechaPost = Constantes.FORMATO_FECHA_SIMPLE.format(capsula.getFechaCreacion());
				}
				
				if(capsula.getDescripcion()!=null) {
					descripcion = "Descripcion:\n" + capsula.getDescripcion();
				}
				if(!capsula.getValor().equals("capsula guia")) {
					contenido = "Contenido:\n" + capsula.getValor();
				}
				if(capsula.getSituacion()!=null) {
					situacion = "Situacion:\n" + capsula.getSituacion();
				}
				if(capsula.getResolucion()!=null) {
					resolucion = "Resolucion:\n" + capsula.getResolucion();
				}
				if(capsula.getDisparador()!=null) {
					disparador = "Disparador:\n" + capsula.getDisparador();
				}
				
				files = new ArrayList<FilesDocumento>();
				comentarios = null;

				Object[] variables = { "capsula.idCapsula", true, id, "=" };
				List<Documento> listDocumento = businessDelegatorView.findByCriteriaInDocumento(variables, null, null);
				for (Documento documento : listDocumento) {
					files.add(new FilesDocumento(documento.getIdDocumento(), documento.getNombre()));
				}

				if (capsula.getTipoCapsula().getIdTipoCapsula() == Constantes.CAPSULA_TYPE_GUIA) {
					hija = true;
				}

				Object[] variablesHijas = { "parent", true, id, "=" };
				hijas = businessDelegatorView.findByCriteriaInCapsula(variablesHijas, null, null);

				PrimeFaces.current().ajax().update("form:panel_datos");

			}

		} catch (Exception e) {
			log.debug("Error " + e.getMessage(), e);
		}
	}

	public void habilitarEditar(long id) {
		int index = existeElemento(id);
		for (ComentarioComponent comentarioComponent : comentarios) {
			if (comentarioComponent.getId() != id) {
				comentarioComponent.setPertenece(false);
			}
		}
		comentarios.get(index).setEditar(true);
	}

	public void actualizarComentario(long id) {
		try {
			int index = existeElemento(id);

			ComentarioComponent comentarioComponent = comentarios.get(index);
			Comentario comentario = businessDelegatorView.getComentario(id);

			comentario.setValor(comentarioComponent.getTextoNuevo());
			comentario.setFechaModificacion(new Date());
			comentario.setUsuModificador(usuario.getIdUsuario());

			businessDelegatorView.updateComentario(comentario);

			FacesUtils.addInfoMessage("Se actualizo correctamente");
			comentarios = null;

		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}

	}

	private int existeElemento(long id) {
		for (int i = 0; i < comentarios.size(); i++) {
			if (comentarios.get(i).getId() == id) {
				return i;
			}
		}
		return -1;
	}

	public void guardarComentario() {
		try {

			Usuario usuario = (Usuario) FacesUtils.getfromSession("usuario");

			if (txtComentario == null || txtComentario.isEmpty()) {
				throw new Exception("Escriba un comentario no puede dejar el campo vacio");
			}
			if (usuario == null) {
				throw new Exception("El usuario no esta logeado");
			}

			Comentario comentario = new Comentario();
			comentario.setValor(txtComentario);
			comentario.setCalificacion(0L);
			comentario.setFechaCreacion(new Date());
			comentario.setUsuCreador(usuario.getIdUsuario());
			comentario.setUsuario(usuario);
			comentario.setCapsula(capsula);
			comentario.setActivo(Constantes.ESTADO_ACTIVO);

			businessDelegatorView.saveComentario(comentario);

			txtComentario = "";
			FacesUtils.addInfoMessage("Se guardo el comentario correctamente");
			comentarios = null;

		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}
	}

	public StreamedContent getFiles(long idDocumento) {
		try {

			Documento documento = businessDelegatorView.getDocumento(idDocumento);
			InputStream inputStream = businessDelegatorView.generarFiles(idDocumento);
			StreamedContent archivo = new DefaultStreamedContent(inputStream, documento.getDescripcion(),
					documento.getNombre());

			return archivo;

		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
			return null;
		}
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

	public String getContenido() {
		return contenido;
	}

	public void setContenido(String contenido) {
		this.contenido = contenido;
	}

	public List<FilesDocumento> getFiles() {
		if (files == null) {
			files = new ArrayList<>();
		}
		return files;
	}

	public void setFiles(List<FilesDocumento> files) {
		this.files = files;
	}

	public String getMachete() {
		cargarDatos();
		return machete;
	}

	public void setMachete(String machete) {
		this.machete = machete;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getCreadorName() {
		return creadorName;
	}

	public void setCreadorName(String creadorName) {
		this.creadorName = creadorName;
	}

	public String getFechaPost() {
		return fechaPost;
	}

	public void setFechaPost(String fechaPost) {
		this.fechaPost = fechaPost;
	}

	public List<ComentarioComponent> getComentarios() {
		try {
			if (comentarios == null) {
				comentarios = new ArrayList<ComentarioComponent>();

				Object[] variables = { "capsula.idCapsula", true, capsula.getIdCapsula(), "=" };
				List<Comentario> listComentarios = businessDelegatorView.findByCriteriaInComentario(variables, null,
						null);
				for (Comentario comentario : listComentarios) {
					ComentarioComponent comentarioComponent = new ComentarioComponent();

					comentarioComponent.setId(comentario.getIdComentario());
					comentarioComponent.setTextoOriginal(comentario.getValor());
					comentarioComponent.setTextoNuevo(comentario.getValor());
					comentarioComponent.setCalificacion(comentario.getCalificacion());
					comentarioComponent.setEditar(false);

					if (comentario.getUsuario().getIdUsuario() == usuario.getIdUsuario()) {
						comentarioComponent.setPertenece(true);
					} else {
						comentarioComponent.setPertenece(false);
					}

					if (comentario.getFechaModificacion() != null) {
						comentarioComponent
								.setFecha(Constantes.FORMATO_FECHA_SIMPLE.format(comentario.getFechaModificacion()));
					} else {
						comentarioComponent
								.setFecha(Constantes.FORMATO_FECHA_SIMPLE.format(comentario.getFechaCreacion()));
					}

					Usuario usuarioComentario = businessDelegatorView
							.getUsuario(comentario.getUsuario().getIdUsuario());

					comentarioComponent
							.setUsuario(usuarioComentario.getNombre() + " " + usuarioComentario.getApellido());

					comentarios.add(comentarioComponent);
				}
			}

		} catch (Exception e) {
			// TODO: handle exception
		}
		return comentarios;
	}

	public void setComentarios(List<ComentarioComponent> comentarios) {
		this.comentarios = comentarios;
	}

	public String getTxtComentario() {
		return txtComentario;
	}

	public void setTxtComentario(String txtComentario) {
		this.txtComentario = txtComentario;
	}

	public List<Capsula> getHijas() {
		return hijas;
	}

	public void setHijas(List<Capsula> hijas) {
		this.hijas = hijas;
	}

	public boolean isHija() {
		return hija;
	}

	public void setHija(boolean hija) {
		this.hija = hija;
	}

	public String getDisparador() {
		return disparador;
	}

	public void setDisparador(String disparador) {
		this.disparador = disparador;
	}

	public String getSituacion() {
		return situacion;
	}

	public void setSituacion(String situacion) {
		this.situacion = situacion;
	}

	public String getResolucion() {
		return resolucion;
	}

	public void setResolucion(String resolucion) {
		this.resolucion = resolucion;
	}

}
