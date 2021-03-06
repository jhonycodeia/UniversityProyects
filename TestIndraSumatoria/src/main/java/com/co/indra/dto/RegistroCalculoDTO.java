package com.co.indra.dto;

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
public class RegistroCalculoDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final Logger log = LoggerFactory.getLogger(RegistroCalculoDTO.class);
    private Date fechaEjecucion;
    private Integer idResultado;
    private Integer resultado;
    private Integer idUsuario_Usuarios;
    private String name;

    public Date getFechaEjecucion() {
        return fechaEjecucion;
    }

    public void setFechaEjecucion(Date fechaEjecucion) {
        this.fechaEjecucion = fechaEjecucion;
    }

    public Integer getIdResultado() {
        return idResultado;
    }

    public void setIdResultado(Integer idResultado) {
        this.idResultado = idResultado;
    }

    public Integer getResultado() {
        return resultado;
    }

    public void setResultado(Integer resultado) {
        this.resultado = resultado;
    }

    public Integer getIdUsuario_Usuarios() {
        return idUsuario_Usuarios;
    }

    public void setIdUsuario_Usuarios(Integer idUsuario_Usuarios) {
        this.idUsuario_Usuarios = idUsuario_Usuarios;
    }

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
