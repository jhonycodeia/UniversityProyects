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
public class MatriculaDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final Logger log = LoggerFactory.getLogger(MatriculaDTO.class);
    private String activo;
    private Date fechaCreacion;
    private Date fechaModificacion;
    private Long idMatricula;
    private Long usuCreador;
    private Long usuModificador;
    private Long idPruebaReal_PruebaReal;
    private Long idUsuario_Usuario;

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

    public Long getIdMatricula() {
        return idMatricula;
    }

    public void setIdMatricula(Long idMatricula) {
        this.idMatricula = idMatricula;
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

    public Long getIdPruebaReal_PruebaReal() {
        return idPruebaReal_PruebaReal;
    }

    public void setIdPruebaReal_PruebaReal(Long idPruebaReal_PruebaReal) {
        this.idPruebaReal_PruebaReal = idPruebaReal_PruebaReal;
    }

    public Long getIdUsuario_Usuario() {
        return idUsuario_Usuario;
    }

    public void setIdUsuario_Usuario(Long idUsuario_Usuario) {
        this.idUsuario_Usuario = idUsuario_Usuario;
    }
}
