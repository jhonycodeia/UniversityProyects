package com.saberpro.modelo;

import org.hibernate.validator.constraints.*;

import java.util.Date;

import javax.persistence.*;

import javax.validation.constraints.*;


/**
* @author Zathura Code Generator http://zathuracode.org/
* www.zathuracode.org
*
*/
@Entity
@Table(name = "opcion", schema = "public")
public class Opcion implements java.io.Serializable {
    //@NotNull
    private Long idOpcion;
    @NotNull(message="grupoopcion no valido")
    private GrupoOpcion grupoOpcion;
    @NotNull(message="activo no valido")
    @NotEmpty
    @Size(max = 1)
    private String activo;
    private String descripcion;
    @NotNull(message="fechacreacion no valido")
    private Date fechaCreacion;
    private Date fechaModificacion;
    @NotNull(message="nombre no valido")
    @NotEmpty
    @Size(max = 300)
    private String nombre;
    private String ruta;
    @NotNull(message="usucreador no valido")
    private Long usuCreador;
    private Long usuModificador;

    public Opcion() {
    }

    public Opcion(Long idOpcion, String activo, String descripcion,
        Date fechaCreacion, Date fechaModificacion, GrupoOpcion grupoOpcion,
        String nombre, String ruta, Long usuCreador, Long usuModificador) {
        this.idOpcion = idOpcion;
        this.grupoOpcion = grupoOpcion;
        this.activo = activo;
        this.descripcion = descripcion;
        this.fechaCreacion = fechaCreacion;
        this.fechaModificacion = fechaModificacion;
        this.nombre = nombre;
        this.ruta = ruta;
        this.usuCreador = usuCreador;
        this.usuModificador = usuModificador;
    }

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id_opcion", unique = true, nullable = false)
    public Long getIdOpcion() {
        return this.idOpcion;
    }

    public void setIdOpcion(Long idOpcion) {
        this.idOpcion = idOpcion;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_grupo_opcion")
    public GrupoOpcion getGrupoOpcion() {
        return this.grupoOpcion;
    }

    public void setGrupoOpcion(GrupoOpcion grupoOpcion) {
        this.grupoOpcion = grupoOpcion;
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

    @Column(name = "nombre",unique = true, nullable = false)
    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Column(name = "ruta")
    public String getRuta() {
        return this.ruta;
    }

    public void setRuta(String ruta) {
        this.ruta = ruta;
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

	@Override
	public String toString() {
		return "Opcion [idOpcion=" + idOpcion + ", activo=" + activo + ", descripcion=" + descripcion
				+ ", fechaCreacion=" + fechaCreacion + ", fechaModificacion=" + fechaModificacion + ", nombre=" + nombre
				+ ", ruta=" + ruta + ", usuCreador=" + usuCreador + ", usuModificador=" + usuModificador + "]";
	}
    
    
}
