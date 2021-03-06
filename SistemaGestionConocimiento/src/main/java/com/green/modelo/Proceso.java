package com.green.modelo;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

import javax.validation.constraints.*;


/**
* @author Zathura Code Generator http://zathuracode.org/
* www.zathuracode.org
*
*/
@Entity
@Table(name = "proceso", schema = "public")
public class Proceso implements java.io.Serializable {
    //@NotNull
    private Long idProceso;
    @NotNull
    @NotEmpty
    @Size(max = 1)
    private String activo;
    private String descripcion;
    @NotNull
    private Date fechaCreacion;
    private Date fechaModificacion;
    @NotNull
    @NotEmpty
    @Size(max = 300)
    private String nombre;
    @NotNull
    private Long usuCreador;
    private Long usuModificador;
    private Set<Capsula> capsulas = new HashSet<Capsula>(0);
    private Set<Subproceso> subprocesos = new HashSet<Subproceso>(0);

    public Proceso() {
    }

    public Proceso(Long idProceso, String activo, Set<Capsula> capsulas,
        String descripcion, Date fechaCreacion, Date fechaModificacion,
        String nombre, Set<Subproceso> subprocesos, Long usuCreador,
        Long usuModificador) {
        this.idProceso = idProceso;
        this.activo = activo;
        this.descripcion = descripcion;
        this.fechaCreacion = fechaCreacion;
        this.fechaModificacion = fechaModificacion;
        this.nombre = nombre;
        this.usuCreador = usuCreador;
        this.usuModificador = usuModificador;
        this.capsulas = capsulas;
        this.subprocesos = subprocesos;
    }

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id_proceso", unique = true, nullable = false)
    public Long getIdProceso() {
        return this.idProceso;
    }

    public void setIdProceso(Long idProceso) {
        this.idProceso = idProceso;
    }

    @Column(name = "activo", nullable = false)
    public String getActivo() {
        return this.activo;
    }

    public void setActivo(String activo) {
        this.activo = activo;
    }

    @Column(name = "descripcion")
    public String getDescripcion() {
        return this.descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Column(name = "fecha_creacion", nullable = false)
    public Date getFechaCreacion() {
        return this.fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    @Column(name = "fecha_modificacion")
    public Date getFechaModificacion() {
        return this.fechaModificacion;
    }

    public void setFechaModificacion(Date fechaModificacion) {
        this.fechaModificacion = fechaModificacion;
    }

    @Column(name = "nombre", nullable = false)
    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Column(name = "usu_creador", nullable = false)
    public Long getUsuCreador() {
        return this.usuCreador;
    }

    public void setUsuCreador(Long usuCreador) {
        this.usuCreador = usuCreador;
    }

    @Column(name = "usu_modificador")
    public Long getUsuModificador() {
        return this.usuModificador;
    }

    public void setUsuModificador(Long usuModificador) {
        this.usuModificador = usuModificador;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "proceso")
    public Set<Capsula> getCapsulas() {
        return this.capsulas;
    }

    public void setCapsulas(Set<Capsula> capsulas) {
        this.capsulas = capsulas;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "proceso")
    public Set<Subproceso> getSubprocesos() {
        return this.subprocesos;
    }

    public void setSubprocesos(Set<Subproceso> subprocesos) {
        this.subprocesos = subprocesos;
    }
}
