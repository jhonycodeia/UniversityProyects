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
public class PruebaProgramaUsuarioDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final Logger log = LoggerFactory.getLogger(PruebaProgramaUsuarioDTO.class);
    private String activo;
    private Date fechaCreacion;
    private Date fechaModificacion;
    private Long idPruebaProgramaUsuario;
    private Long usuCreador;
    private Long usuModificador;
    private Long idEstadoPrueba_EstadoPrueba;
    private Long idProgramaUsuario_ProgramaUsuario;
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

    public Long getIdPruebaProgramaUsuario() {
        return idPruebaProgramaUsuario;
    }

    public void setIdPruebaProgramaUsuario(Long idPruebaProgramaUsuario) {
        this.idPruebaProgramaUsuario = idPruebaProgramaUsuario;
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

    public Long getIdEstadoPrueba_EstadoPrueba() {
        return idEstadoPrueba_EstadoPrueba;
    }

    public void setIdEstadoPrueba_EstadoPrueba(Long idEstadoPrueba_EstadoPrueba) {
        this.idEstadoPrueba_EstadoPrueba = idEstadoPrueba_EstadoPrueba;
    }

    public Long getIdProgramaUsuario_ProgramaUsuario() {
        return idProgramaUsuario_ProgramaUsuario;
    }

    public void setIdProgramaUsuario_ProgramaUsuario(
        Long idProgramaUsuario_ProgramaUsuario) {
        this.idProgramaUsuario_ProgramaUsuario = idProgramaUsuario_ProgramaUsuario;
    }

    public Long getIdPrueba_Prueba() {
        return idPrueba_Prueba;
    }

    public void setIdPrueba_Prueba(Long idPrueba_Prueba) {
        this.idPrueba_Prueba = idPrueba_Prueba;
    }
}
