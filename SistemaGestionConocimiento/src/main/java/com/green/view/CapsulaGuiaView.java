package com.green.view;

import com.green.modelo.*;
import com.green.utility.*;

import org.primefaces.PrimeFaces;
import org.primefaces.component.chips.Chips;
import org.primefaces.component.commandbutton.CommandButton;
import org.primefaces.component.inputtext.InputText;
import org.primefaces.component.inputtextarea.InputTextarea;
import org.primefaces.component.selectonemenu.SelectOneMenu;
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
public class CapsulaGuiaView implements Serializable {
	private static final long serialVersionUID = 1L;
	private static final Logger log = LoggerFactory.getLogger(CapsulaGuiaView.class);

	private boolean crear = true;

	private Documento documento;
	private Capsula capsula;

	private String machete;

	private InputText txtTitulo;

	private InputTextarea txtDescripcion;

	private List<String> items;

	private String disparador;
	private String situacion;
	private String resolucion;

	private List<FilesDocumento> files;

	private SelectOneMenu somCapsula;

	private List<SelectItem> lasCapsulasSelectItem;

	private CommandButton btnSave;

	@ManagedProperty(value = "#{businessDelegator}")
	private BusinessDelegator businessDelegatorView;

	public CapsulaGuiaView() {
		super();
	}

	public void cargarDatos() {
		try {

			FacesContext facesContext = FacesContext.getCurrentInstance();
			Map params = facesContext.getExternalContext().getRequestParameterMap();
			Long id = new Long((String) params.get("id"));

			if (id != null) {
				log.info("se recupero el id " + id);

				capsula = businessDelegatorView.getCapsula(id);

				Usuario usuario = (Usuario) FacesUtils.getfromSession("usuario");

				if (usuario.getIdUsuario() != capsula.getUsuario().getIdUsuario()
						|| capsula.getActivo().equals(Constantes.ESTADO_PENDIENTE)
						|| capsula.getTipoCapsula().getIdTipoCapsula() != Constantes.CAPSULA_TYPE_GUIA) {
					FacesUtils.addErrorMessage("No se pudo cargar su capsula correctamente");
					FacesContext.getCurrentInstance().getExternalContext().redirect("../dashboard.xhtml");
				}

				txtTitulo.setValue(capsula.getTitulo());
				txtDescripcion.setValue(capsula.getDescripcion());
				somCapsula.setValue(capsula.getParent());

				disparador = capsula.getDisparador();
				situacion = capsula.getSituacion();
				resolucion = capsula.getResolucion();

				crear = false;
				items = new ArrayList<String>();
				files = new ArrayList<FilesDocumento>();

				Object[] variables = { "capsula.idCapsula", true, id, "=" };
				List<CapsulaPalabrasClave> listPalabras = businessDelegatorView
						.findByCriteriaInCapsulaPalabrasClave(variables, null, null);

				for (CapsulaPalabrasClave capsulaPalabrasClave : listPalabras) {
					items.add(capsulaPalabrasClave.getNombre());
				}

				List<Documento> listDocumento = businessDelegatorView.findByCriteriaInDocumento(variables, null, null);
				for (Documento documento : listDocumento) {
					files.add(new FilesDocumento(documento.getIdDocumento(), documento.getNombre()));
				}

				PrimeFaces.current().ajax().update("form:panel_datos");

			}

		} catch (Exception e) {
			log.debug("Error " + e.getMessage(), e);
		}
	}

	public void limpiar() {
		txtTitulo.resetValue();
		txtDescripcion.resetValue();
		somCapsula.resetValue();

		items = new ArrayList<String>();
		files = new ArrayList<FilesDocumento>();
		situacion = "";
		disparador = "";
		resolucion = "";
	}

	public void procesar() {
		try {
			Usuario usuario = (Usuario) FacesUtils.getfromSession("usuario");

			if (usuario != null) {
				log.info("creando capsula");
				if (crear) {

					if (FacesUtils.checkString(txtTitulo) == null || FacesUtils.checkString(txtTitulo).isEmpty()) {
						throw new Exception("Escriba un titulo");
					}
					if (FacesUtils.checkLong(somCapsula) == 0) {
						throw new Exception("Debe selecionar una capsula Tool");
					}
					if (disparador == null || disparador.isEmpty()) {
						throw new Exception("Escriba un disparador");
					}
					if (situacion == null || situacion.isEmpty()) {
						throw new Exception("Escriba un situacion");
					}
					if (resolucion == null || resolucion.isEmpty()) {
						throw new Exception("Escriba un resolucion ");
					}
					if(items==null || items.size()==0) {
						throw new Exception("Debe escribir al menos una palabra clave");
					}

					capsula = new Capsula();

					capsula.setTitulo(FacesUtils.checkString(txtTitulo));
					capsula.setDescripcion(FacesUtils.checkString(txtDescripcion));
					capsula.setDisparador(disparador);
					capsula.setResolucion(resolucion);
					capsula.setSituacion(situacion);
					capsula.setValor("capsula guia");
					capsula.setParent(FacesUtils.checkLong(somCapsula));
					capsula.setUsuario(usuario);
					capsula.setUsuCreador(usuario.getIdUsuario());
					capsula.setFechaCreacion(new Date());
					capsula.setActivo(Constantes.ESTADO_PENDIENTE);
					capsula.setTipoCapsula(businessDelegatorView.getTipoCapsula(Constantes.CAPSULA_TYPE_GUIA));

					businessDelegatorView.saveCapsula(capsula, files, items);

					FacesUtils.addInfoMessage("Se creo la capsula correctamente");
					limpiar();
				}
			}
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}
	}

	public void actualizar() {

		try {
			Usuario usuario = (Usuario) FacesUtils.getfromSession("usuario");

			if (usuario != null) {
				log.info("actualizando capsula");
				if (!crear) {

					if (FacesUtils.checkString(txtTitulo) == null || FacesUtils.checkString(txtTitulo).isEmpty()) {
						throw new Exception("Escriba un titulo");
					}
					if (FacesUtils.checkLong(somCapsula) == 0) {
						throw new Exception("Debe selecionar una capsula Tool");
					}
					if (disparador == null || disparador.isEmpty()) {
						throw new Exception("Escriba un disparador");
					}
					if (situacion == null || situacion.isEmpty()) {
						throw new Exception("Escriba un situacion");
					}
					if (resolucion == null || resolucion.isEmpty()) {
						throw new Exception("Escriba un resolucion ");
					}
					if(items==null || items.size()==0) {
						throw new Exception("Debe escribir al menos una palabra clave");
					}

					capsula.setTitulo(FacesUtils.checkString(txtTitulo));
					capsula.setDescripcion(FacesUtils.checkString(txtDescripcion));
					capsula.setDisparador(disparador);
					capsula.setResolucion(resolucion);
					capsula.setSituacion(situacion);
					capsula.setParent(FacesUtils.checkLong(somCapsula));
					capsula.setUsuario(usuario);
					capsula.setUsuModificador(usuario.getIdUsuario());
					capsula.setFechaModificacion(new Date());

					businessDelegatorView.updateCapsula(capsula, files, items);

					FacesUtils.addInfoMessage("Se actualizo la capsula correctamente");

					// FacesContext.getCurrentInstance().getExternalContext().redirect("misCapsulas.xhtml");
				}
			}
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}

	}

	public void handleUpload(FileUploadEvent event) {
		try {
			if (existeElemento(event.getFile().getFileName()) == -1) {
				files.add(new FilesDocumento(event.getFile().getFileName(), event.getFile().getInputstream(),
						event.getFile().getContentType()));
			} else {
				FacesUtils.addErrorMessage("el archivo " + event.getFile().getFileName() + " ya esta guardado");
			}

		} catch (IOException e) {
			log.debug(e.getMessage(), e);
		}

	}

	private int existeElemento(String name) {
		for (int i = 0; i < files.size(); i++) {
			if (files.get(i).getName().equals(name)) {
				return i;

			}
		}
		return -1;
	}

	public void borrarDocumento(String name) {
		try {
			if (!crear) {
				documento = businessDelegatorView.getDocumento(files.get(existeElemento(name)).getId());
				if (documento == null) {
					documento = new Documento();
					documento.setNombre(name);
				}
			} else {
				documento = new Documento();
				documento.setNombre(name);
			}

		} catch (Exception e) {
			log.debug("error en metodo borrarDocumento ", e);
		}

	}

	public void borrarDocumento() {
		try {
			files.remove(existeElemento(documento.getNombre()));

			if (documento.getIdDocumento() != null) {
				businessDelegatorView.deleteDocumento(documento);
			}

			documento = null;

			FacesUtils.addInfoMessage("Se borro el documento correctamente");
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
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

	public InputTextarea getTxtDescripcion() {
		return txtDescripcion;
	}

	public void setTxtDescripcion(InputTextarea txtDescripcion) {
		this.txtDescripcion = txtDescripcion;
	}

	public CommandButton getBtnSave() {
		return btnSave;
	}

	public void setBtnSave(CommandButton btnSave) {
		this.btnSave = btnSave;
	}

	public List<SelectItem> getLasCapsulasSelectItem() {
		if (lasCapsulasSelectItem == null) {
			lasCapsulasSelectItem = new ArrayList<>();
			try {
				Object[] variable = { "tipoCapsula.idTipoCapsula", true, Constantes.CAPSULA_TYPE_TOOL, "=" };
				for (Capsula capsula : businessDelegatorView.findByCriteriaInCapsula(variable, null, null)) {
					if(capsula.getActivo().equals(Constantes.ESTADO_ACTIVO)) {
						lasCapsulasSelectItem.add(new SelectItem(capsula.getIdCapsula(), capsula.getTitulo()));
					}
					
				}
				Object[] variable2 = { "tipoCapsula.idTipoCapsula", true, Constantes.CAPSULA_TYPE_DIVULGACION, "=" };
				for (Capsula capsula : businessDelegatorView.findByCriteriaInCapsula(variable2, null, null)) {
					if(capsula.getActivo().equals(Constantes.ESTADO_ACTIVO)) {
						lasCapsulasSelectItem.add(new SelectItem(capsula.getIdCapsula(), capsula.getTitulo()));
					}					
				}
			} catch (Exception e) {
				log.debug(e.getMessage(), e);
			}
		}
		return lasCapsulasSelectItem;
	}

	public void setLasCapsulasSelectItem(List<SelectItem> lasCapsulasSelectItem) {
		this.lasCapsulasSelectItem = lasCapsulasSelectItem;
	}

	public SelectOneMenu getSomCapsula() {
		return somCapsula;
	}

	public void setSomCapsula(SelectOneMenu somCapsula) {
		this.somCapsula = somCapsula;
	}

	public InputText getTxtTitulo() {
		return txtTitulo;
	}

	public void setTxtTitulo(InputText txtTitulo) {
		this.txtTitulo = txtTitulo;
	}

	public List<String> getItems() {
		return items;
	}

	public void setItems(List<String> items) {
		this.items = items;
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

	public String getMachete() {
		cargarDatos();
		return machete;
	}

	public void setMachete(String machete) {
		this.machete = machete;
	}

	public boolean isCrear() {
		return crear;
	}

	public void setCrear(boolean crear) {
		this.crear = crear;
	}

}
