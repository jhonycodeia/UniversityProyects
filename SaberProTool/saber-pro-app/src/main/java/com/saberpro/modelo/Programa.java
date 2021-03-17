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
@Table(name = "programa", schema = "public")
public class Programa implements java.io.Serializable {
    //@NotNull
    private Long idPrograma;
    @NotNull(message="facultad no valido")
    private Facultad facultad;
    @NotNull(message="activo no valido")
    @NotEmpty
    @Size(max = 1)
    private String activo;
    private String descripcion;
    @NotNull(message="fecha creacion no valido")
    private Date fechaCreacion;
    private Date fechaModificacion;
    @NotNull(message="nombre no valido")
    @NotEmpty
    @Size(min=3,max = 300)
    private String nombre;
    @NotNull(message="usucreador no valido")
    private Long usuCreador;
    private Long usuModificador;
    private Set<ProgramaModulo> programaModulos = new HashSet<ProgramaModulo>(0);
    private Set<ProgramaUsuario> programaUsuarios = new HashSet<ProgramaUsuario>(0);

    public Programa() {
    }

    public Programa(Long idPrograma, String activo, String descripcion,
        Facultad facultad, Date fechaCreacion, Date fechaModificacion,
        String nombre, Set<ProgramaModulo> programaModulos,
        Set<ProgramaUsuario> programaUsuarios, Long usuCreador,
        Long usuModificador) {
        this.idPrograma = idPrograma;
        this.facultad = facultad;
        this.activo = activo;
        this.descripcion = descripcion;
        this.fechaCreacion = fechaCreacion;
        this.fechaModificacion = fechaModificacion;
        this.nombre = nombre;
        this.usuCreador = usuCreador;
        this.usuModificador = usuModificador;
        this.programaModulos = programaModulos;
        this.programaUsuarios = programaUsuarios;
    }

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id_programa", unique = true, nullable = false)
    public Long getIdPrograma() {
        return this.idPrograma;
    }

    public void setIdPrograma(Long idPrograma) {
        this.idPrograma = idPrograma;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_facultad")
    public Facultad getFacultad() {
        return this.facultad;
    }

    public void setFacultad(Facultad facultad) {
        this.facultad = facultad;
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

    @Column(name = "nombre",unique = true,nullable = false)
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

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "programa")
    public Set<ProgramaModulo> getProgramaModulos() {
        return this.programaModulos;
    }

    public void setProgramaModulos(Set<ProgramaModulo> programaModulos) {
        this.programaModulos = programaModulos;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "programa")
    public Set<ProgramaUsuario> getProgramaUsuarios() {
        return this.programaUsuarios;
    }

    public void setProgramaUsuarios(Set<ProgramaUsuario> programaUsuarios) {
        this.programaUsuarios = programaUsuarios;
    }

	@Override
	public String toString() {
		return "Programa [idPrograma=" + idPrograma + ", activo=" + activo + ", descripcion=" + descripcion
				+ ", fechaCreacion=" + fechaCreacion + ", fechaModificacion=" + fechaModificacion + ", nombre=" + nombre
				+ ", usuCreador=" + usuCreador + ", usuModificador=" + usuModificador + "]";
	}
    
    
}
