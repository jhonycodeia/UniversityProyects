package com.saberpro.modelo.dto;

import java.util.List;

import com.saberpro.modelo.RespuestaPruebaProgramaUsuarioPregunta;

public class ModuloPreguntaDTO {

	private Long idModulo;
	private String nombreModulo;
	private Long prioridadModulo;
	private PreguntaDTO preguntaDTO;
	private List<RespuestaDTO> respuestasDTO;
	private RespuestaDTO respuestaSeleccionada;
	
	public Long getIdModulo() {
		return idModulo;
	}
	public void setIdModulo(Long idModulo) {
		this.idModulo = idModulo;
	}
	public String getNombreModulo() {
		return nombreModulo;
	}
	public void setNombreModulo(String nombreModulo) {
		this.nombreModulo = nombreModulo;
	}
	public PreguntaDTO getPreguntaDTO() {
		return preguntaDTO;
	}
	public void setPreguntaDTO(PreguntaDTO preguntaDTO) {
		this.preguntaDTO = preguntaDTO;
	}
	public Long getPrioridadModulo() {
		return prioridadModulo;
	}
	public void setPrioridadModulo(Long prioridadModulo) {
		this.prioridadModulo = prioridadModulo;
	}
	public List<RespuestaDTO> getRespuestasDTO() {
		return respuestasDTO;
	}
	public void setRespuestasDTO(List<RespuestaDTO> respuestasDTO) {
		this.respuestasDTO = respuestasDTO;
	}
	public RespuestaDTO getRespuestaSeleccionada() {
		return respuestaSeleccionada;
	}
	public void setRespuestaSeleccionada(RespuestaDTO respuestaSeleccionada) {
		this.respuestaSeleccionada = respuestaSeleccionada;
	}
	
}
