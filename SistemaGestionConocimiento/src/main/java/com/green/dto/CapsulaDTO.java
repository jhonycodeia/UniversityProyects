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
public class CapsulaDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final Logger log = LoggerFactory.getLogger(CapsulaDTO.class);
    private String activo;
    private String descripcion;
    private String disparador;
    private Date fechaCreacion;
    private Date fechaModificacion;
    private Long idCapsula;
    private Long parent;
    private String resolucion;
    private String situacion;
    private String titulo;
    private Long usuCreador;
    private Long usuModificador;
    private String valor;
    private Long idCategoria_Categoria;
    private Long idProceso_Proceso;
    private Long idSubproceso_Subproceso;
    private Long idTipoCapsula_TipoCapsula;
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

    public String getDisparador() {
        return disparador;
    }

    public void setDisparador(String disparador) {
        this.disparador = disparador;
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

    public Long getIdCapsula() {
        return idCapsula;
    }

    public void setIdCapsula(Long idCapsula) {
        this.idCapsula = idCapsula;
    }

    public Long getParent() {
        return parent;
    }

    public void setParent(Long parent) {
        this.parent = parent;
    }

    public String getResolucion() {
        return resolucion;
    }

    public void setResolucion(String resolucion) {
        this.resolucion = resolucion;
    }

    public String getSituacion() {
        return situacion;
    }

    public void setSituacion(String situacion) {
        this.situacion = situacion;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
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

    public Long getIdCategoria_Categoria() {
        return idCategoria_Categoria;
    }

    public void setIdCategoria_Categoria(Long idCategoria_Categoria) {
        this.idCategoria_Categoria = idCategoria_Categoria;
    }

    public Long getIdProceso_Proceso() {
        return idProceso_Proceso;
    }

    public void setIdProceso_Proceso(Long idProceso_Proceso) {
        this.idProceso_Proceso = idProceso_Proceso;
    }

    public Long getIdSubproceso_Subproceso() {
        return idSubproceso_Subproceso;
    }

    public void setIdSubproceso_Subproceso(Long idSubproceso_Subproceso) {
        this.idSubproceso_Subproceso = idSubproceso_Subproceso;
    }

    public Long getIdTipoCapsula_TipoCapsula() {
        return idTipoCapsula_TipoCapsula;
    }

    public void setIdTipoCapsula_TipoCapsula(Long idTipoCapsula_TipoCapsula) {
        this.idTipoCapsula_TipoCapsula = idTipoCapsula_TipoCapsula;
    }

    public Long getIdUsuario_Usuario() {
        return idUsuario_Usuario;
    }

    public void setIdUsuario_Usuario(Long idUsuario_Usuario) {
        this.idUsuario_Usuario = idUsuario_Usuario;
    }
}
