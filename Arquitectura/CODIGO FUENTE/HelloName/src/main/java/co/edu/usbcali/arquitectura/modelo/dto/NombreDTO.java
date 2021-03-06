package co.edu.usbcali.arquitectura.modelo.dto;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Serializable;

import java.sql.*;

import java.util.Date;


/**
* @author Zathura Code Generator http://zathuracode.org
* www.zathuracode.org
*
*/
public class NombreDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final Logger log = LoggerFactory.getLogger(NombreDTO.class);
    private Integer idNombre;
    private String nombre;
    private Integer idIdioma_Idioma;

    public Integer getIdNombre() {
        return idNombre;
    }

    public void setIdNombre(Integer idNombre) {
        this.idNombre = idNombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getIdIdioma_Idioma() {
        return idIdioma_Idioma;
    }

    public void setIdIdioma_Idioma(Integer idIdioma_Idioma) {
        this.idIdioma_Idioma = idIdioma_Idioma;
    }
}
