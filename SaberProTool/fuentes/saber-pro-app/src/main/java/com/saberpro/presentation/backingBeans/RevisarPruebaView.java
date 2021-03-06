package com.saberpro.presentation.backingBeans;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TimeZone;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;

import org.primefaces.event.SelectEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.saberpro.modelo.Prueba;
import com.saberpro.modelo.PruebaProgramaUsuario;
import com.saberpro.modelo.PruebaProgramaUsuarioPregunta;
import com.saberpro.modelo.RespuestaPruebaProgramaUsuarioPregunta;
import com.saberpro.modelo.Usuario;
import com.saberpro.modelo.dto.ModeloPruebaDTO;
import com.saberpro.modelo.dto.ModuloPreguntaDTO;
import com.saberpro.modelo.dto.RespuestaDTO;
import com.saberpro.presentation.businessDelegate.IBusinessDelegatorView;
import com.saberpro.utilities.ComponentPrueba;
import com.saberpro.utilities.Constantes;
import com.saberpro.utilities.FacesUtils;


/**
 * @author Zathura Code Generator http://zathuracode.org/ www.zathuracode.org
 *
 */
@ManagedBean
@ViewScoped
public class RevisarPruebaView implements Serializable {
	private static final long serialVersionUID = 1L;
	private static final Logger log = LoggerFactory.getLogger(RevisarPruebaView.class);

	@ManagedProperty(value = "#{BusinessDelegatorView}")
	private IBusinessDelegatorView businessDelegatorView;

	private Long pruebaProgramaUsuarioId = null;
	private PruebaProgramaUsuario pruebaProgramaUsuario;	
	private ModeloPruebaDTO modeloPruebaDTO = null;
	private Long idModuloSeleccionado;
	private Integer porcentajeAvance = 0;	

	private List<SelectItem> modulos = new ArrayList<>();

	private ModuloPreguntaDTO preguntaActual = null;

	public RevisarPruebaView() {
		super();
	}

	@PostConstruct
	public void tomarPruebaViewPC() {
		try {

			// Se toma la prueba programa usurio del parametro
			FacesContext facesContext = FacesContext.getCurrentInstance();
			Map params = facesContext.getExternalContext().getRequestParameterMap();
			pruebaProgramaUsuarioId = new Long((String) params.get("id"));
			if (pruebaProgramaUsuarioId == null) {
				FacesContext.getCurrentInstance().getExternalContext().redirect("prueba.xhtml");
			} else {
				pruebaProgramaUsuario = businessDelegatorView.getPruebaProgramaUsuario(pruebaProgramaUsuarioId);
			}

			if (pruebaProgramaUsuario == null) {
				throw new Exception("No se pudo encontrar la prueba del usuario " + pruebaProgramaUsuarioId);
			}

			// Si la prueba ya finalizó, lo redirecciona
			if (pruebaProgramaUsuario.getEstadoPrueba().getIdEstadoPrueba().equals(Constantes.PRUEBA_ESTADO_INICIADO)) {
				FacesContext.getCurrentInstance().getExternalContext().redirect("prueba.xhtml");
			}

			// Se consultan las respuestas de las preguntas
			modeloPruebaDTO = businessDelegatorView.consultarPruebaProgramaUsuario(pruebaProgramaUsuarioId);
			if (modeloPruebaDTO == null) {
				throw new Exception("No se pudo consultar las respuestas de la prueba");
			}

			List<ModuloPreguntaDTO> preguntas = modeloPruebaDTO.getModuloPreguntasDTO();
			Map<Long, String> modulos = new LinkedHashMap<>();
			for (ModuloPreguntaDTO moduloPreguntaDTO : preguntas) {

				if (modulos.get(moduloPreguntaDTO.getIdModulo()) == null) {
					modulos.put(moduloPreguntaDTO.getIdModulo(), moduloPreguntaDTO.getNombreModulo());
				}

			}

			Set<Long> idsModulos = modulos.keySet();
			for (Long idModulo : idsModulos) {
				this.modulos.add(new SelectItem(idModulo, modulos.get(idModulo)));
			}

			preguntaActual = modeloPruebaDTO.getModuloPreguntasDTO().get(0);

		} catch (Exception e) {
			log.error("Error cargando", e);
			FacesUtils.addErrorMessage(e.getMessage());
		}
	}
	
	public void verResultados() {
		try {
			FacesContext.getCurrentInstance().getExternalContext().redirect("pruebaResultado.xhtml?id="+pruebaProgramaUsuarioId);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void action_siguientePregunta(ActionEvent event) {
		try {
			if (preguntaActual == null) {
				preguntaActual = modeloPruebaDTO.getModuloPreguntasDTO().get(0);
				idModuloSeleccionado = preguntaActual.getIdModulo();
				return;
			} else {
				List<ModuloPreguntaDTO> preguntasDePrueba = modeloPruebaDTO.getModuloPreguntasDTO();

				for (int i = 0; i < preguntasDePrueba.size(); i++) {
					if (preguntaActual == preguntasDePrueba.get(i)) {
						// Se llegó a la ultima pregunta, la siguiente pregunta será la primera
						if ((i + 1) >= preguntasDePrueba.size()) {
							preguntaActual = modeloPruebaDTO.getModuloPreguntasDTO().get(0);
							idModuloSeleccionado = preguntaActual.getIdModulo();
							return;
						} else {
							preguntaActual = modeloPruebaDTO.getModuloPreguntasDTO().get(i + 1);
							idModuloSeleccionado = preguntaActual.getIdModulo();
							break;
						}
					}
				}
			}
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}
	}

	public void action_anteriorPregunta(ActionEvent event) {
		try {
			if (preguntaActual == null) {
				preguntaActual = modeloPruebaDTO.getModuloPreguntasDTO().get(0);
				idModuloSeleccionado = preguntaActual.getIdModulo();
				return;
			} else {
				List<ModuloPreguntaDTO> preguntasDePrueba = modeloPruebaDTO.getModuloPreguntasDTO();

				for (int i = 0; i < preguntasDePrueba.size(); i++) {
					if (preguntaActual == preguntasDePrueba.get(i)) {
						// Se llegó a la primera pregunta, la siguiente pregunta será la última
						if (i == 0) {
							preguntaActual = preguntasDePrueba.get(preguntasDePrueba.size() - 1);
							idModuloSeleccionado = preguntaActual.getIdModulo();
							return;
						} else {
							preguntaActual = modeloPruebaDTO.getModuloPreguntasDTO().get(i - 1);
							idModuloSeleccionado = preguntaActual.getIdModulo();
							break;
						}
					}
				}
			}
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}
	}	

	public void cambioModulo(ValueChangeEvent vce) {
		try {

			Long idModulo = (Long) vce.getNewValue();

			// Se va a la primera pregunta del modulo seleccionado
			List<ModuloPreguntaDTO> preguntas = modeloPruebaDTO.getModuloPreguntasDTO();

			for (ModuloPreguntaDTO moduloPreguntaDTO : preguntas) {
				if (moduloPreguntaDTO.getIdModulo().equals(idModulo)) {
					this.preguntaActual = moduloPreguntaDTO;
					break;
				}
			}

		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}
	}


	public IBusinessDelegatorView getBusinessDelegatorView() {
		return businessDelegatorView;
	}

	public void setBusinessDelegatorView(IBusinessDelegatorView businessDelegatorView) {
		this.businessDelegatorView = businessDelegatorView;
	}

	public Long getPruebaProgramaUsuarioId() {
		return pruebaProgramaUsuarioId;
	}

	public void setPruebaProgramaUsuarioId(Long pruebaProgramaUsuarioId) {
		this.pruebaProgramaUsuarioId = pruebaProgramaUsuarioId;
	}

	public PruebaProgramaUsuario getPruebaProgramaUsuario() {
		return pruebaProgramaUsuario;
	}

	public void setPruebaProgramaUsuario(PruebaProgramaUsuario pruebaProgramaUsuario) {
		this.pruebaProgramaUsuario = pruebaProgramaUsuario;
	}

	public ModeloPruebaDTO getModeloPruebaDTO() {
		return modeloPruebaDTO;
	}

	public void setModeloPruebaDTO(ModeloPruebaDTO modeloPruebaDTO) {
		this.modeloPruebaDTO = modeloPruebaDTO;
	}

	public List<SelectItem> getModulos() {
		return modulos;
	}

	public void setModulos(List<SelectItem> modulos) {
		this.modulos = modulos;
	}

	public Long getIdModuloSeleccionado() {
		return idModuloSeleccionado;
	}

	public void setIdModuloSeleccionado(Long idModuloSeleccionado) {
		this.idModuloSeleccionado = idModuloSeleccionado;
	}

	public ModuloPreguntaDTO getPreguntaActual() {
		return preguntaActual;
	}

	public void setPreguntaActual(ModuloPreguntaDTO preguntaActual) {
		this.preguntaActual = preguntaActual;
	}

	public Integer getPorcentajeAvance() {
		return porcentajeAvance;
	}

	public void setPorcentajeAvance(Integer porcentajeAvance) {
		this.porcentajeAvance = porcentajeAvance;
	}

}
