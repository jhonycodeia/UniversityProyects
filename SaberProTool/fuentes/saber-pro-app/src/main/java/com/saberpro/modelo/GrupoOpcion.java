package com.saberpro.modelo;

import org.hibernate.validator.constraints.*;

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
@Table(name = "grupo_opcion", schema = "public")
public class GrupoOpcion implements java.io.Serializable {
    //@NotNull
    private Long idGrupoOpcion;
    @NotNull(message="activo no valido")
    @NotEmpty
    @Size(max = 1)
    private String activo;
    private String descripcion;
    @NotNull(message="fechacreacion no valido")
    private Date fechaCreacion;
    private Date fechaModificacion;
    private String icon;
    @NotNull(message="nombre no valido")
    @NotEmpty
    @Size(max = 300)
    private String nombre;
    @NotNull(message="usucreador no valido")
    private Long usuCreador;
    private Long usuModificador;
    private Set<Opcion> opcions = new HashSet<Opcion>(0);
    private Set<Permiso> permisos = new HashSet<Permiso>(0);

    public GrupoOpcion() {
    }

    public GrupoOpcion(Long idGrupoOpcion, String activo, String descripcion,
        Date fechaCreacion, Date fechaModificacion, String icon, String nombre,
        Set<Opcion> opcions, Set<Permiso> permisos, Long usuCreador,
        Long usuModificador) {
        this.idGrupoOpcion = idGrupoOpcion;
        this.activo = activo;
        this.descripcion = descripcion;
        this.fechaCreacion = fechaCreacion;
        this.fechaModificacion = fechaModificacion;
        this.icon = icon;
        this.nombre = nombre;
        this.usuCreador = usuCreador;
        this.usuModificador = usuModificador;
        this.opcions = opcions;
        this.permisos = permisos;
    }

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id_grupo_opcion", unique = true, nullable = false)
    public Long getIdGrupoOpcion() {
        return this.idGrupoOpcion;
    }

    public void setIdGrupoOpcion(Long idGrupoOpcion) {
        this.idGrupoOpcion = idGrupoOpcion;
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

    @Column(name = "icon")
    public String getIcon() {
        return this.icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
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

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "grupoOpcion")
    public Set<Opcion> getOpcions() {
        return this.opcions;
    }

    public void setOpcions(Set<Opcion> opcions) {
        this.opcions = opcions;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "grupoOpcion")
    public Set<Permiso> getPermisos() {
        return this.permisos;
    }

    public void setPermisos(Set<Permiso> permisos) {
        this.permisos = permisos;
    }

	@Override
	public String toString() {
		return "GrupoOpcion [idGrupoOpcion=" + idGrupoOpcion + ", activo=" + activo + ", descripcion=" + descripcion
				+ ", fechaCreacion=" + fechaCreacion + ", fechaModificacion=" + fechaModificacion + ", icon=" + icon
				+ ", nombre=" + nombre + ", usuCreador=" + usuCreador + ", usuModificador=" + usuModificador + "]";
	}
    
    
}
