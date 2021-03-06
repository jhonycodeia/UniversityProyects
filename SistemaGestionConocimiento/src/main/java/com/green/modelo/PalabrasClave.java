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
@Table(name = "palabras_clave", schema = "public")
public class PalabrasClave implements java.io.Serializable {
    //@NotNull
    private Long idPalabraClave;
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
    private Set<CapsulaPalabrasClave> capsulaPalabrasClaves = new HashSet<CapsulaPalabrasClave>(0);

    public PalabrasClave() {
    }

    public PalabrasClave(Long idPalabraClave, String activo,
        Set<CapsulaPalabrasClave> capsulaPalabrasClaves, String descripcion,
        Date fechaCreacion, Date fechaModificacion, String nombre,
        Long usuCreador, Long usuModificador) {
        this.idPalabraClave = idPalabraClave;
        this.activo = activo;
        this.descripcion = descripcion;
        this.fechaCreacion = fechaCreacion;
        this.fechaModificacion = fechaModificacion;
        this.nombre = nombre;
        this.usuCreador = usuCreador;
        this.usuModificador = usuModificador;
        this.capsulaPalabrasClaves = capsulaPalabrasClaves;
    }

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id_palabra_clave", unique = true, nullable = false)
    public Long getIdPalabraClave() {
        return this.idPalabraClave;
    }

    public void setIdPalabraClave(Long idPalabraClave) {
        this.idPalabraClave = idPalabraClave;
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

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "palabrasClave")
    public Set<CapsulaPalabrasClave> getCapsulaPalabrasClaves() {
        return this.capsulaPalabrasClaves;
    }

    public void setCapsulaPalabrasClaves(
        Set<CapsulaPalabrasClave> capsulaPalabrasClaves) {
        this.capsulaPalabrasClaves = capsulaPalabrasClaves;
    }
}
