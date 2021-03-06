package com.green.utility;

public class ComentarioComponent {

	private long id;	
	private String usuario;
	private String fecha;
	private String textoOriginal;
	private String textoNuevo;
	private boolean editar;
	private boolean pertenece;
	private long calificacion;

	public ComentarioComponent() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}	

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public String getTextoOriginal() {
		return textoOriginal;
	}

	public void setTextoOriginal(String textoOriginal) {
		this.textoOriginal = textoOriginal;
	}

	public String getTextoNuevo() {
		return textoNuevo;
	}

	public void setTextoNuevo(String textoNuevo) {
		this.textoNuevo = textoNuevo;
	}

	public boolean isEditar() {
		return editar;
	}

	public void setEditar(boolean editar) {
		this.editar = editar;
	}

	public long getCalificacion() {
		return calificacion;
	}

	public void setCalificacion(long calificacion) {
		this.calificacion = calificacion;
	}

	public boolean isPertenece() {
		return pertenece;
	}

	public void setPertenece(boolean pertenece) {
		this.pertenece = pertenece;
	}
	
	

}
