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
public class ResultadoRealDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final Logger log = LoggerFactory.getLogger(ResultadoRealDTO.class);
    private String activo;
    private Date fechaCreacion;
    private Date fechaModificacion;
    private Long idResultadoReal;
    private Long percentilGrupo;
    private Long percentilNacional;
    private Long usuCreador;
    private Long usuModificador;
    private Long idMatricula_Matricula;
    private Long idModulo_Modulo;

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

    public Long getIdResultadoReal() {
        return idResultadoReal;
    }

    public void setIdResultadoReal(Long idResultadoReal) {
        this.idResultadoReal = idResultadoReal;
    }

    public Long getPercentilGrupo() {
        return percentilGrupo;
    }

    public void setPercentilGrupo(Long percentilGrupo) {
        this.percentilGrupo = percentilGrupo;
    }

    public Long getPercentilNacional() {
        return percentilNacional;
    }

    public void setPercentilNacional(Long percentilNacional) {
        this.percentilNacional = percentilNacional;
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

    public Long getIdMatricula_Matricula() {
        return idMatricula_Matricula;
    }

    public void setIdMatricula_Matricula(Long idMatricula_Matricula) {
        this.idMatricula_Matricula = idMatricula_Matricula;
    }

    public Long getIdModulo_Modulo() {
        return idModulo_Modulo;
    }

    public void setIdModulo_Modulo(Long idModulo_Modulo) {
        this.idModulo_Modulo = idModulo_Modulo;
    }
}
