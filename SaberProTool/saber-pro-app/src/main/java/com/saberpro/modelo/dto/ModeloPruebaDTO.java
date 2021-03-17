package com.saberpro.modelo.dto;

import java.util.Date;
import java.util.List;

public class ModeloPruebaDTO {

	private Long idPrueba;
	private String nombreTipoPrueba;
	private String nombrePrograma;
	private Date fechaInicial;
	private Date fechaFinal;
	private Long tiempo;
	private List<ModuloPreguntaDTO> moduloPreguntasDTO;
	private Integer cantidadTotalDePreguntas = 0;
	private Integer cantidadTotalDePreguntasContestadas = 0;
	private Integer porcentajeAvance;
	
	public Long getIdPrueba() {
		return idPrueba;
	}
	public void setIdPrueba(Long idPrueba) {
		this.idPrueba = idPrueba;
	}
	public String getNombreTipoPrueba() {
		return nombreTipoPrueba;
	}
	public void setNombreTipoPrueba(String nombreTipoPrueba) {
		this.nombreTipoPrueba = nombreTipoPrueba;
	}
	public String getNombrePrograma() {
		return nombrePrograma;
	}
	public void setNombrePrograma(String nombrePrograma) {
		this.nombrePrograma = nombrePrograma;
	}
	public Date getFechaInicial() {
		return fechaInicial;
	}
	public void setFechaInicial(Date fechaInicial) {
		this.fechaInicial = fechaInicial;
	}
	public Date getFechaFinal() {
		return fechaFinal;
	}
	public void setFechaFinal(Date fechaFinal) {
		this.fechaFinal = fechaFinal;
	}
	public Long getTiempo() {
		return tiempo;
	}
	public void setTiempo(Long tiempo) {
		this.tiempo = tiempo;
	}
	public List<ModuloPreguntaDTO> getModuloPreguntasDTO() {
		return moduloPreguntasDTO;
	}
	public void setModuloPreguntasDTO(List<ModuloPreguntaDTO> moduloPreguntasDTO) {
		this.moduloPreguntasDTO = moduloPreguntasDTO;
	}
	public Integer getCantidadTotalDePreguntas() {
		return cantidadTotalDePreguntas;
	}
	public void setCantidadTotalDePreguntas(Integer cantidadTotalDePreguntas) {
		this.cantidadTotalDePreguntas = cantidadTotalDePreguntas;
	}
	public Integer getCantidadTotalDePreguntasContestadas() {
		return cantidadTotalDePreguntasContestadas;
	}
	public void setCantidadTotalDePreguntasContestadas(Integer cantidadTotalDePreguntasContestadas) {
		this.cantidadTotalDePreguntasContestadas = cantidadTotalDePreguntasContestadas;
	}
	public Integer getPorcentajeAvance() {
		return porcentajeAvance;
	}
	public void setPorcentajeAvance(Integer porcentajeAvance) {
		this.porcentajeAvance = porcentajeAvance;
	}
	
}
