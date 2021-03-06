package co.edu.usbcali.banco.dto;

import java.math.BigDecimal;



public class UsuarioDTO {

	private String usuUsuario;	
	private long tiusId;
	private String clave;
	private BigDecimal identificacion;
	private String nombre;
	private char activo;
	public UsuarioDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public UsuarioDTO(String usuUsuario, long tiusId, String clave, BigDecimal identificacion, String nombre,
			char activo) {
		super();
		this.usuUsuario = usuUsuario;
		this.tiusId = tiusId;
		this.clave = clave;
		this.identificacion = identificacion;
		this.nombre = nombre;
		this.activo = activo;
	}
	public String getUsuUsuario() {
		return usuUsuario;
	}
	public void setUsuUsuario(String usuUsuario) {
		this.usuUsuario = usuUsuario;
	}
	public long getTiusId() {
		return tiusId;
	}
	public void setTiusId(long tiusId) {
		this.tiusId = tiusId;
	}
	public String getClave() {
		return clave;
	}
	public void setClave(String clave) {
		this.clave = clave;
	}
	public BigDecimal getIdentificacion() {
		return identificacion;
	}
	public void setIdentificacion(BigDecimal identificacion) {
		this.identificacion = identificacion;
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
