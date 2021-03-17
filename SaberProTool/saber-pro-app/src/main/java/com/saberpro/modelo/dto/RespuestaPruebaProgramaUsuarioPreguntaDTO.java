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
public class RespuestaPruebaProgramaUsuarioPreguntaDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final Logger log = LoggerFactory.getLogger(RespuestaPruebaProgramaUsuarioPreguntaDTO.class);
    private String activo;
    private Date fechaCreacion;
    private Date fechaModificacion;
    private Long idRespuestaPruebaProgramaUsuarioPregunta;
    private Long porcentajeAsignado;
    private Long usuCreador;
    private Long usuModificador;
    private Long idPruebaProgramaUsuarioPregunta_PruebaProgramaUsuarioPregunta;
    private Long idRespuesta_Respuesta;

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

    public Long getIdRespuestaPruebaProgramaUsuarioPregunta() {
        return idRespuestaPruebaProgramaUsuarioPregunta;
    }

    public void setIdRespuestaPruebaProgramaUsuarioPregunta(
        Long idRespuestaPruebaProgramaUsuarioPregunta) {
        this.idRespuestaPruebaProgramaUsuarioPregunta = idRespuestaPruebaProgramaUsuarioPregunta;
    }

    public Long getPorcentajeAsignado() {
        return porcentajeAsignado;
    }

    public void setPorcentajeAsignado(Long porcentajeAsignado) {
        this.porcentajeAsignado = porcentajeAsignado;
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

    public Long getIdPruebaProgramaUsuarioPregunta_PruebaProgramaUsuarioPregunta() {
        return idPruebaProgramaUsuarioPregunta_PruebaProgramaUsuarioPregunta;
    }

    public void setIdPruebaProgramaUsuarioPregunta_PruebaProgramaUsuarioPregunta(
        Long idPruebaProgramaUsuarioPregunta_PruebaProgramaUsuarioPregunta) {
        this.idPruebaProgramaUsuarioPregunta_PruebaProgramaUsuarioPregunta = idPruebaProgramaUsuarioPregunta_PruebaProgramaUsuarioPregunta;
    }

    public Long getIdRespuesta_Respuesta() {
        return idRespuesta_Respuesta;
    }

    public void setIdRespuesta_Respuesta(Long idRespuesta_Respuesta) {
        this.idRespuesta_Respuesta = idRespuesta_Respuesta;
    }
}
