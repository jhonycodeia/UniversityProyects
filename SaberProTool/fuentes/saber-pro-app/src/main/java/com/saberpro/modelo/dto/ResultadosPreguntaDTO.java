package com.saberpro.modelo.dto;

import java.util.Date;

public class ResultadosPreguntaDTO {
	private long id;
	private String contenido;	
	private long resultado;
	
	public ResultadosPreguntaDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ResultadosPreguntaDTO(long id, String contenido, long resultado) {
		super();
		this.id = id;
		this.contenido = contenido;
		this.resultado = resultado;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getContenido() {
		return contenido;
	}

	public void setContenido(String contenido) {
		this.contenido = contenido;
	}

	public long getResultado() {
		return resultado;
	}

	public void setResultado(long resultado) {
		this.resultado = resultado;
	}

	@Override
	public String toString() {
		return "ResultadosPreguntaDTO [id=" + id + ", contenido=" + contenido + ", resultado=" + resultado + "]";
	}
	
	
	
	
	
	
	
}
