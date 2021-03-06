package co.edu.usbcali.banco.dto;

import java.math.BigDecimal;

import co.edu.usbcali.banco.modelo.TipoDocumento;

public class ClienteDTO {

	private BigDecimal clieId;
	private long tdocId;
	private String nombre;
	private String direccion;
	private String telefono;
	private String email;
	private char activo;

	public ClienteDTO() {
		super();
	}

	public ClienteDTO(BigDecimal clieId, long tdocId, String nombre, String direccion, String telefono, String email,
			char activo) {
		super();
		this.clieId = clieId;
		this.setTdocId(tdocId);
		this.nombre = nombre;
		this.direccion = direccion;
		this.telefono = telefono;
		this.email = email;
		this.activo = activo;
	}

	public BigDecimal getClieId() {
		return clieId;
	}

	public void setClieId(BigDecimal clieId) {
		this.clieId = clieId;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public char getActivo() {
		return activo;
	}

	public void setActivo(char activo) {
		this.activo = activo;
	}

	public long getTdocId() {
		return tdocId;
	}

	public void setTdocId(long tdocId) {
		this.tdocId = tdocId;
	}

}
