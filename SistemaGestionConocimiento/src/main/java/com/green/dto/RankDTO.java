package com.green.dto;

public class RankDTO {
	
	private int id;
	private String nombre;
	private int valor;
	
	public RankDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public RankDTO( String nombre,long valor) {
		super();
		
		this.nombre = nombre;
		this.valor = (int)valor;
	}

	public RankDTO(int id, String nombre, int valor) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.valor = valor;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getValor() {
		return valor;
	}

	public void setValor(int valor) {
		this.valor = valor;
	}

	
	
}
