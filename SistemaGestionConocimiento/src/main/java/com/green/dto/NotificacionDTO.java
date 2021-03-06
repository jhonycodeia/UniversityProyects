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
public class NotificacionDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final Logger log = LoggerFactory.getLogger(NotificacionDTO.class);
    private String activo;
    private String descripcion;
    private Date fechaCreacion;
    private Date fechaModificacion;
    private Long idNotificacion;
    private String nombre;
    private Long usuCreador;
    private Long usuModificador;
    private String valor;
    private Long idCapsula_Capsula;
    private Long idTipoNotificacion_TipoNotificacion;
    private Long idUsuario_Usuario;

    public String getActivo() {
        return activo;
    }

    public void setActivo(String activo) {
        this.activo = activo;
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

    public Long getIdNotificacion() {
        return idNotificacion;
    }

    public void setIdNotificacion(Long idNotificacion) {
        this.idNotificacion = idNotificacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public Long getIdCapsula_Capsula() {
        return idCapsula_Capsula;
    }

    public void setIdCapsula_Capsula(Long idCapsula_Capsula) {
        this.idCapsula_Capsula = idCapsula_Capsula;
    }

    public Long getIdTipoNotificacion_TipoNotificacion() {
        return idTipoNotificacion_TipoNotificacion;
    }

    public void setIdTipoNotificacion_TipoNotificacion(
        Long idTipoNotificacion_TipoNotificacion) {
        this.idTipoNotificacion_TipoNotificacion = idTipoNotificacion_TipoNotificacion;
    }

    public Long getIdUsuario_Usuario() {
        return idUsuario_Usuario;
    }

    public void setIdUsuario_Usuario(Long idUsuario_Usuario) {
        this.idUsuario_Usuario = idUsuario_Usuario;
    }
}
