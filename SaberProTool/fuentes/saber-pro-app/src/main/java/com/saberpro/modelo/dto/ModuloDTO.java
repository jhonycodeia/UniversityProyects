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
public class ModuloDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final Logger log = LoggerFactory.getLogger(ModuloDTO.class);
    private String activo;
    private Long cantidadPreguntas;
    private String descripcion;
    private Date fechaCreacion;
    private Date fechaModificacion;
    private Long idModulo;
    private String nombre;
    private Long prioridad;
    private Long usuCreador;
    private Long usuModificador;
    private Long idTipoModulo_TipoModulo;

    public String getActivo() {
        return activo;
    }

    public void setActivo(String activo) {
        this.activo = activo;
    }

    public Long getCantidadPreguntas() {
        return cantidadPreguntas;
    }

    public void setCantidadPreguntas(Long cantidadPreguntas) {
        this.cantidadPreguntas = cantidadPreguntas;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
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

    public Long getIdModulo() {
        return idModulo;
    }

    public void setIdModulo(Long idModulo) {
        this.idModulo = idModulo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Long getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(Long prioridad) {
        this.prioridad = prioridad;
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

    public Long getIdTipoModulo_TipoModulo() {
        return idTipoModulo_TipoModulo;
    }

    public void setIdTipoModulo_TipoModulo(Long idTipoModulo_TipoModulo) {
        this.idTipoModulo_TipoModulo = idTipoModulo_TipoModulo;
    }
}
