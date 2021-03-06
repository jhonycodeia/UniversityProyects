package com.green.modelo;

import java.util.Date;

import javax.persistence.*;

import javax.validation.constraints.*;


/**
* @author Zathura Code Generator http://zathuracode.org/
* www.zathuracode.org
*
*/
@Entity
@Table(name = "capsula_palabras_clave", schema = "public")
public class CapsulaPalabrasClave implements java.io.Serializable {
    //@NotNull
    private Long idCapsulaPalabraClave;
    @NotNull
    private Capsula capsula;
    @NotNull
    private PalabrasClave palabrasClave;
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

    public CapsulaPalabrasClave() {
    }

    public CapsulaPalabrasClave(Long idCapsulaPalabraClave, String activo,
        Capsula capsula, String descripcion, Date fechaCreacion,
        Date fechaModificacion, String nombre, PalabrasClave palabrasClave,
        Long usuCreador, Long usuModificador) {
        this.idCapsulaPalabraClave = idCapsulaPalabraClave;
        this.capsula = capsula;
        this.palabrasClave = palabrasClave;
        this.activo = activo;
        this.descripcion = descripcion;
        this.fechaCreacion = fechaCreacion;
        this.fechaModificacion = fechaModificacion;
        this.nombre = nombre;
        this.usuCreador = usuCreador;
        this.usuModificador = usuModificador;
    }

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id_capsula_palabra_clave", unique = true, nullable = false)
    public Long getIdCapsulaPalabraClave() {
        return this.idCapsulaPalabraClave;
    }

    public void setIdCapsulaPalabraClave(Long idCapsulaPalabraClave) {
        this.idCapsulaPalabraClave = idCapsulaPalabraClave;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_capsula")
    public Capsula getCapsula() {
        return this.capsula;
    }

    public void setCapsula(Capsula capsula) {
        this.capsula = capsula;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_palabra_clave")
    public PalabrasClave getPalabrasClave() {
        return this.palabrasClave;
    }

    public void setPalabrasClave(PalabrasClave palabrasClave) {
        this.palabrasClave = palabrasClave;
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
}
