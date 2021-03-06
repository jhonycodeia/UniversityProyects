package co.edu.usbcali.banco.dto;

import javax.validation.constraints.NotNull;

public class TipoUsuarioDTO {

	private long tiusId;	
	private String nombre;
	private char activo;
	
	
	
	public TipoUsuarioDTO() {
		super();
		// TODO Auto-generated constructor stub
	}



	public TipoUsuarioDTO(long tiusId, String nombre, char activo) {
		super();
		this.tiusId = tiusId;
		this.nombre = nombre;
		this.activo = activo;
	}



	public long getTiusId() {
		return tiusId;
	}



	public void setTiusId(long tiusId) {
		this.tiusId = tiusId;
	}



	public String getNombre() {
		return nombre;
	}



	public void setNombre(String nombre) {
		this.nombre = nombre;
	}



	public char getActivo() {
		return activo;
	}



	public void setActivo(char activo) {
		this.activo = activo;
	}
	
	
	
}
