package co.edu.usbcali.arquitectura.modelo.dto;


import java.io.Serializable;



/**
* @author Zathura Code Generator http://zathuracode.org
* www.zathuracode.org
*
*/
public class SaludoNombreDTO implements Serializable {
	

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String nombre;
    private String saludo;
    
    
    
	public SaludoNombreDTO(String nombre, String saludo) {
		super();
		this.nombre = nombre;
		this.saludo = saludo;
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getSaludo() {
		return saludo;
	}
	public void setSaludo(String saludo) {
		this.saludo = saludo;
	}

}
