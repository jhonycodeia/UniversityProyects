package com.saberpro.modelo.dto;

import java.util.Date;

public class ResultadosModuloDTO {
	private String nombreModulo;
	private long incorrecta;
	private long correcta;
	private long numero;
	private double resultado;
	
	
	
	public ResultadosModuloDTO() {
		super();
		// TODO Auto-generated constructor stub
	}



	public ResultadosModuloDTO(String nombreModulo, long incorrecta, long correcta, long numero,double resultado) {
		super();
		this.nombreModulo = nombreModulo;
		this.incorrecta = incorrecta;
		this.correcta = correcta;
		this.numero = numero;
		this.resultado = resultado;
	}



	public String getNombreModulo() {
		return nombreModulo;
	}



	public void setNombreModulo(String nombreModulo) {
		this.nombreModulo = nombreModulo;
	}



	public long getIncorrecta() {
		return incorrecta;
	}



	public void setIncorrecta(long incorrecta) {
		this.incorrecta = incorrecta;
	}



	public long getCorrecta() {
		return correcta;
	}



	public void setCorrecta(long correcta) {
		this.correcta = correcta;
	}



	public long getNumero() {
		return numero;
	}



	public void setNumero(long numero) {
		this.numero = numero;
	}



	public double getResultado() {
		return resultado;
	}



	public void setResultado(double resultado) {
		this.resultado = resultado;
	}



	@Override
	public String toString() {
		return "ResultadosModuloDTO [nombreModulo=" + nombreModulo + ", incorrecta=" + incorrecta + ", correcta="
				+ correcta + ", numero=" + numero + ", resultado=" + resultado + "]";
	}
	
	
	
	
	
}
