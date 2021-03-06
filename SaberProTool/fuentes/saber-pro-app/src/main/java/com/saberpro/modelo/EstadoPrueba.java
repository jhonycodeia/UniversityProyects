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
@Table(name = "estado_prueba", schema = "public")
public class EstadoPrueba implements java.io.Serializable {
    //@NotNull
    private Long idEstadoPrueba;
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
    @NotNull(message="usucreador no valido")
    private Long usuCreador;
    private Long usuModificador;
    private Set<PruebaProgramaUsuario> pruebaProgramaUsuarios = new HashSet<PruebaProgramaUsuario>(0);

    public EstadoPrueba() {
    }

    public EstadoPrueba(Long idEstadoPrueba, String activo, String descripcion,
        Date fechaCreacion, Date fechaModificacion, String nombre,
        Set<PruebaProgramaUsuario> pruebaProgramaUsuarios, Long usuCreador,
        Long usuModificador) {
        this.idEstadoPrueba = idEstadoPrueba;
        this.activo = activo;
        this.descripcion = descripcion;
        this.fechaCreacion = fechaCreacion;
        this.fechaModificacion = fechaModificacion;
        this.nombre = nombre;
        this.usuCreador = usuCreador;
        this.usuModificador = usuModificador;
        this.pruebaProgramaUsuarios = pruebaProgramaUsuarios;
    }

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id_estado_prueba", unique = true, nullable = false)
    public Long getIdEstadoPrueba() {
        return this.idEstadoPrueba;
    }

    public void setIdEstadoPrueba(Long idEstadoPrueba) {
        this.idEstadoPrueba = idEstadoPrueba;
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

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "estadoPrueba")
    public Set<PruebaProgramaUsuario> getPruebaProgramaUsuarios() {
        return this.pruebaProgramaUsuarios;
    }

    public void setPruebaProgramaUsuarios(
        Set<PruebaProgramaUsuario> pruebaProgramaUsuarios) {
        this.pruebaProgramaUsuarios = pruebaProgramaUsuarios;
    }

	@Override
	public String toString() {
		return "EstadoPrueba [idEstadoPrueba=" + idEstadoPrueba + ", activo=" + activo + ", descripcion=" + descripcion
				+ ", fechaCreacion=" + fechaCreacion + ", fechaModificacion=" + fechaModificacion + ", nombre=" + nombre
				+ ", usuCreador=" + usuCreador + ", usuModificador=" + usuModificador + "]";
	}
    
    
}
