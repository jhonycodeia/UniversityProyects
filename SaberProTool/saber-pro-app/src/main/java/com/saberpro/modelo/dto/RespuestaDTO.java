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
public class RespuestaDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final Logger log = LoggerFactory.getLogger(RespuestaDTO.class);
    private String activo;
    private String descripcionRespuesta;
    private Date fechaCreacion;
    private Date fechaModificacion;
    private Long idRespuesta;
    private Integer porcentajeAcierto;
    private String rutaImagen;
    private Long usuCreador;
    private Long usuModificador;
    private Long idPregunta_Pregunta;

    public String getActivo() {
        return activo;
    }

    public void setActivo(String activo) {
        this.activo = activo;
    }

    public String getDescripcionRespuesta() {
        return descripcionRespuesta;
    }

    public void setDescripcionRespuesta(String descripcionRespuesta) {
        this.descripcionRespuesta = descripcionRespuesta;
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

    public Long getIdRespuesta() {
        return idRespuesta;
    }

    public void setIdRespuesta(Long idRespuesta) {
        this.idRespuesta = idRespuesta;
    }

    public Integer getPorcentajeAcierto() {
        return porcentajeAcierto;
    }

    public void setPorcentajeAcierto(Integer porcentajeAcierto) {
        this.porcentajeAcierto = porcentajeAcierto;
    }

    public String getRutaImagen() {
        return rutaImagen;
    }

    public void setRutaImagen(String rutaImagen) {
        this.rutaImagen = rutaImagen;
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

    public Long getIdPregunta_Pregunta() {
        return idPregunta_Pregunta;
    }

    public void setIdPregunta_Pregunta(Long idPregunta_Pregunta) {
        this.idPregunta_Pregunta = idPregunta_Pregunta;
    }
}
