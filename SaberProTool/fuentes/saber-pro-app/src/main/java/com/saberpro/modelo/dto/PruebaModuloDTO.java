package com.saberpro.modelo.dto;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Serializable;

import java.sql.*;

import java.util.Date;


/**
* @author Zathura Code Generator http://zathuracode.org/
* www.zathuracode.org
*
*/
public class PruebaModuloDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final Logger log = LoggerFactory.getLogger(PruebaModuloDTO.class);
    private String activo;
    private Date fechaCreacion;
    private Date fechaModificacion;
    private Long idPruebaModulo;
    private Long numeroPreguntas;
    private Long usuCreador;
    private Long usuModificador;
    private Long idModulo_Modulo;
    private Long idPrueba_Prueba;

    public String getActivo() {
        return activo;
    }

    public void setActivo(String activo) {
        this.activo = activo;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Date getFechaModificacion() {
        return fechaModificacion;
    }

    public void setFechaModificacion(Date fechaModificacion) {
        this.fechaModificacion = fechaModificacion;
    }

    public Long getIdPruebaModulo() {
        return idPruebaModulo;
    }

    public void setIdPruebaModulo(Long idPruebaModulo) {
        this.idPruebaModulo = idPruebaModulo;
    }

    public Long getNumeroPreguntas() {
        return numeroPreguntas;
    }

    public void setNumeroPreguntas(Long numeroPreguntas) {
        this.numeroPreguntas = numeroPreguntas;
    }

    public Long getUsuCreador() {
        return usuCreador;
    }

    public void setUsuCreador(Long usuCreador) {
        this.usuCreador = usuCreador;
    }

    public Long getUsuModificador() {
        return usuModificador;
    }

    public void setUsuModificador(Long usuModificador) {
        this.usuModificador = usuModificador;
    }

    public Long getIdModulo_Modulo() {
        return idModulo_Modulo;
    }

    public void setIdModulo_Modulo(Long idModulo_Modulo) {
        this.idModulo_Modulo = idModulo_Modulo;
    }

    public Long getIdPrueba_Prueba() {
        return idPrueba_Prueba;
    }

    public void setIdPrueba_Prueba(Long idPrueba_Prueba) {
        this.idPrueba_Prueba = idPrueba_Prueba;
    }
}
