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
public class CapsulaPalabrasClaveDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final Logger log = LoggerFactory.getLogger(CapsulaPalabrasClaveDTO.class);
    private String activo;
    private String descripcion;
    private Date fechaCreacion;
    private Date fechaModificacion;
    private Long idCapsulaPalabraClave;
    private String nombre;
    private Long usuCreador;
    private Long usuModificador;
    private Long idCapsula_Capsula;
    private Long idPalabraClave_PalabrasClave;

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

    public Long getIdCapsulaPalabraClave() {
        return idCapsulaPalabraClave;
    }

    public void setIdCapsulaPalabraClave(Long idCapsulaPalabraClave) {
        this.idCapsulaPalabraClave = idCapsulaPalabraClave;
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

    public Long getIdCapsula_Capsula() {
        return idCapsula_Capsula;
    }

    public void setIdCapsula_Capsula(Long idCapsula_Capsula) {
        this.idCapsula_Capsula = idCapsula_Capsula;
    }

    public Long getIdPalabraClave_PalabrasClave() {
        return idPalabraClave_PalabrasClave;
    }

    public void setIdPalabraClave_PalabrasClave(
        Long idPalabraClave_PalabrasClave) {
        this.idPalabraClave_PalabrasClave = idPalabraClave_PalabrasClave;
    }
}
