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
public class SaludoDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final Logger log = LoggerFactory.getLogger(SaludoDTO.class);
    private Integer idSaludo;
    private String saludo;
    private Integer idIdioma_Idioma;

    public Integer getIdSaludo() {
        return idSaludo;
    }

    public void setIdSaludo(Integer idSaludo) {
        this.idSaludo = idSaludo;
    }

    public String getSaludo() {
        return saludo;
    }

    public void setSaludo(String saludo) {
        this.saludo = saludo;
    }

    public Integer getIdIdioma_Idioma() {
        return idIdioma_Idioma;
    }

    public void setIdIdioma_Idioma(Integer idIdioma_Idioma) {
        this.idIdioma_Idioma = idIdioma_Idioma;
    }
}
