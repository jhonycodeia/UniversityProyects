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
public class PruebaDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final Logger log = LoggerFactory.getLogger(PruebaDTO.class);
    private String activo;
    private Date fechaCreacion;
    private Date fechaFinal;
    private Date fechaInicial;
    private Date fechaModificacion;
    private Long idPrueba;
    private Long tiempo;
    private Long usuCreador;
    private Long usuModificador;
    private Long idTipoPrueba_TipoPrueba;

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

    public Date getFechaFinal() {
        return fechaFinal;
    }

    public void setFechaFinal(Date fechaFinal) {
        this.fechaFinal = fechaFinal;
    }

    public Date getFechaInicial() {
        return fechaInicial;
    }

    public void setFechaInicial(Date fechaInicial) {
        this.fechaInicial = fechaInicial;
    }

    public Date getFechaModificacion() {
        return fechaModificacion;
    }

    public void setFechaModificacion(Date fechaModificacion) {
        this.fechaModificacion = fechaModificacion;
    }

    public Long getIdPrueba() {
        return idPrueba;
    }

    public void setIdPrueba(Long idPrueba) {
        this.idPrueba = idPrueba;
    }

    public Long getTiempo() {
        return tiempo;
    }

    public void setTiempo(Long tiempo) {
        this.tiempo = tiempo;
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

    public Long getIdTipoPrueba_TipoPrueba() {
        return idTipoPrueba_TipoPrueba;
    }

    public void setIdTipoPrueba_TipoPrueba(Long idTipoPrueba_TipoPrueba) {
        this.idTipoPrueba_TipoPrueba = idTipoPrueba_TipoPrueba;
    }
}
