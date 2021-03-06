package co.edu.usbcali.banco.controller;

public class ResultadoRest {

	private Integer codigo;
	private String mensaje;
	public ResultadoRest() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ResultadoRest(Integer codigo, String mensaje) {
		super();
		this.codigo = codigo;
		this.mensaje = mensaje;
	}
	public Integer getCodigo() {
		return codigo;
	}
	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}
	public String getMensaje() {
		return mensaje;
	}
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	
	
}
