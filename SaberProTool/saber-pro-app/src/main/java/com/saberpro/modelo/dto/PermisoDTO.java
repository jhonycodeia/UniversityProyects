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
public class PermisoDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final Logger log = LoggerFactory.getLogger(PermisoDTO.class);
    private String activo;
    private Date fechaCreacion;
    private Date fechaModificacion;
    private Long idPermiso;
    private Long usuCreador;
    private Long usuModificador;
    private Long idGrupoOpcion_GrupoOpcion;
    private Long idTipoUsuario_TipoUsuario;

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

    public Long getIdPermiso() {
        return idPermiso;
    }

    public void setIdPermiso(Long idPermiso) {
        this.idPermiso = idPermiso;
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

    public Long getIdGrupoOpcion_GrupoOpcion() {
        return idGrupoOpcion_GrupoOpcion;
    }

    public void setIdGrupoOpcion_GrupoOpcion(Long idGrupoOpcion_GrupoOpcion) {
        this.idGrupoOpcion_GrupoOpcion = idGrupoOpcion_GrupoOpcion;
    }

    public Long getIdTipoUsuario_TipoUsuario() {
        return idTipoUsuario_TipoUsuario;
    }

    public void setIdTipoUsuario_TipoUsuario(Long idTipoUsuario_TipoUsuario) {
        this.idTipoUsuario_TipoUsuario = idTipoUsuario_TipoUsuario;
    }
}
