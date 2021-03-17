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
public class PreguntaDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final Logger log = LoggerFactory.getLogger(PreguntaDTO.class);
    private String activo;
    private String descripcionPregunta;
    private Date fechaCreacion;
    private Date fechaModificacion;
    private Long idPregunta;
    private String retroalimentacion;
    private Long usuCreador;
    private Long usuModificador;
    private Long idModulo_Modulo;
    private Long idTipoPregunta_TipoPregunta;

    public String getActivo() {
        return activo;
    }

    public void setActivo(String activo) {
        this.activo = activo;
    }

    public String getDescripcionPregunta() {
        return descripcionPregunta;
    }

    public void setDescripcionPregunta(String descripcionPregunta) {
        this.descripcionPregunta = descripcionPregunta;
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

    public Long getIdPregunta() {
        return idPregunta;
    }

    public void setIdPregunta(Long idPregunta) {
        this.idPregunta = idPregunta;
    }

    public String getRetroalimentacion() {
        return retroalimentacion;
    }

    public void setRetroalimentacion(String retroalimentacion) {
        this.retroalimentacion = retroalimentacion;
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

    public Long getIdTipoPregunta_TipoPregunta() {
        return idTipoPregunta_TipoPregunta;
    }

    public void setIdTipoPregunta_TipoPregunta(Long idTipoPregunta_TipoPregunta) {
        this.idTipoPregunta_TipoPregunta = idTipoPregunta_TipoPregunta;
    }
}
