package com.green.dto;

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
public class UsuarioTrofeoDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final Logger log = LoggerFactory.getLogger(UsuarioTrofeoDTO.class);
    private String activo;
    private Date fechaCreacion;
    private Date fechaModificacion;
    private Long idUsuarioTrofeo;
    private Long usuCreador;
    private Long usuModificador;
    private Long idTrofeo_Trofeo;
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

    public Long getIdUsuarioTrofeo() {
        return idUsuarioTrofeo;
    }

    public void setIdUsuarioTrofeo(Long idUsuarioTrofeo) {
        this.idUsuarioTrofeo = idUsuarioTrofeo;
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

    public Long getIdTrofeo_Trofeo() {
        return idTrofeo_Trofeo;
    }

    public void setIdTrofeo_Trofeo(Long idTrofeo_Trofeo) {
        this.idTrofeo_Trofeo = idTrofeo_Trofeo;
    }

    public Long getIdUsuario_Usuario() {
        return idUsuario_Usuario;
    }

    public void setIdUsuario_Usuario(Long idUsuario_Usuario) {
        this.idUsuario_Usuario = idUsuario_Usuario;
    }
}
