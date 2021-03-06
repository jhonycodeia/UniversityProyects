package com.saberpro.utilities;

import java.util.List;
import javax.faces.model.SelectItem;



public class ComponentPrueba {

	private long idPregunta;
	private long idRespuesta;
	private long respuestaSelecionada;
	private String numeroPregunta;
	private String contenidoPregunta;
	
	private List<SelectItem> listRespuestas;
	
	
	
	public ComponentPrueba() {
		super();
		// TODO Auto-generated constructor stub
	}	

	public long getIdPregunta() {
		return idPregunta;
	}

	public void setIdPregunta(long idPregunta) {
		this.idPregunta = idPregunta;
	}

	public String getNumeroPregunta() {
		return numeroPregunta;
	}

	public void setNumeroPregunta(String numeroPregunta) {
		this.numeroPregunta = numeroPregunta;
	}

	public String getContenidoPregunta() {
		return contenidoPregunta;
	}

	public void setContenidoPregunta(String contenidoPregunta) {
		this.contenidoPregunta = contenidoPregunta;
	}

	public List<SelectItem> getListRespuestas() {
		return listRespuestas;
	}

	public void setListRespuestas(List<SelectItem> listRespuestas) {
		this.listRespuestas = listRespuestas;
	}

	public long  getRespuestaSelecionada() {
		return respuestaSelecionada;
	}

	public void setRespuestaSelecionada(long  respuestaSelecionada) {
		this.respuestaSelecionada = respuestaSelecionada;
	}

	public long getIdRespuesta() {
		return idRespuesta;
	}

	public void setIdRespuesta(long idRespuesta) {
		this.idRespuesta = idRespuesta;
	}
	
	
	
}
