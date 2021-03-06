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
public class ProgramaModuloDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final Logger log = LoggerFactory.getLogger(ProgramaModuloDTO.class);
    private String activo;
    private Date fechaCreacion;
    private Date fechaModificacion;
    private Long idProgramaModulo;
    private Long usuCreador;
    private Long usuModificador;
    private Long idModulo_Modulo;
    private Long idPrograma_Programa;

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

    public Long getIdProgramaModulo() {
        return idProgramaModulo;
    }

    public void setIdProgramaModulo(Long idProgramaModulo) {
        this.idProgramaModulo = idProgramaModulo;
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

    public Long getIdPrograma_Programa() {
        return idPrograma_Programa;
    }

    public void setIdPrograma_Programa(Long idPrograma_Programa) {
        this.idPrograma_Programa = idPrograma_Programa;
    }
}
