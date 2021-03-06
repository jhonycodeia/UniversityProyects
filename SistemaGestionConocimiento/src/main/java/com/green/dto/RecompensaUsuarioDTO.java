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
public class RecompensaUsuarioDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final Logger log = LoggerFactory.getLogger(RecompensaUsuarioDTO.class);
    private String activo;
    private Date fechaCreacion;
    private Date fechaModificacion;
    private Long idRecompensaUsuario;
    private Long usuCreador;
    private Long usuModificador;
    private Long idRecompensa_Recompensa;
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

    public Long getIdRecompensaUsuario() {
        return idRecompensaUsuario;
    }

    public void setIdRecompensaUsuario(Long idRecompensaUsuario) {
        this.idRecompensaUsuario = idRecompensaUsuario;
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

    public Long getIdRecompensa_Recompensa() {
        return idRecompensa_Recompensa;
    }

    public void setIdRecompensa_Recompensa(Long idRecompensa_Recompensa) {
        this.idRecompensa_Recompensa = idRecompensa_Recompensa;
    }

    public Long getIdUsuario_Usuario() {
        return idUsuario_Usuario;
    }

    public void setIdUsuario_Usuario(Long idUsuario_Usuario) {
        this.idUsuario_Usuario = idUsuario_Usuario;
    }
}
