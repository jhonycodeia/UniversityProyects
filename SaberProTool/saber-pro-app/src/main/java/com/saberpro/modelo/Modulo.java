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
@Table(name = "modulo", schema = "public")
public class Modulo implements java.io.Serializable {
    //@NotNull
    private Long idModulo;
    @NotNull(message="Tipo Modulo no valido")
    private TipoModulo tipoModulo;
    @NotNull(message="activo no valido")
    @NotEmpty
    @Size(max = 1)
    private String activo;
    @NotNull(message="cantidad preguntas no valido")
    private Long cantidadPreguntas;
    private String descripcion;
    @NotNull(message="fecha creacion no valido")
    private Date fechaCreacion;
    private Date fechaModificacion;
    @NotNull(message="nombre no valido")
    @NotEmpty
    @Size(min=3,max = 300)
    private String nombre;
    @NotNull(message="prioridad no valido")
    private Long prioridad;
    @NotNull(message="usucreador no valido")
    private Long usuCreador;
    private Long usuModificador;
    private Set<Pregunta> preguntas = new HashSet<Pregunta>(0);
    private Set<ProgramaModulo> programaModulos = new HashSet<ProgramaModulo>(0);
    private Set<PruebaModulo> pruebaModulos = new HashSet<PruebaModulo>(0);
    private Set<ResultadoReal> resultadoReals = new HashSet<ResultadoReal>(0);

    public Modulo() {
    }

    public Modulo(Long idModulo, String activo, Long cantidadPreguntas,
        String descripcion, Date fechaCreacion, Date fechaModificacion,
        String nombre, Set<Pregunta> preguntas, Long prioridad,
        Set<ProgramaModulo> programaModulos, Set<PruebaModulo> pruebaModulos,
        Set<ResultadoReal> resultadoReals, TipoModulo tipoModulo,
        Long usuCreador, Long usuModificador) {
        this.idModulo = idModulo;
        this.tipoModulo = tipoModulo;
        this.activo = activo;
        this.cantidadPreguntas = cantidadPreguntas;
        this.descripcion = descripcion;
        this.fechaCreacion = fechaCreacion;
        this.fechaModificacion = fechaModificacion;
        this.nombre = nombre;
        this.prioridad = prioridad;
        this.usuCreador = usuCreador;
        this.usuModificador = usuModificador;
        this.preguntas = preguntas;
        this.programaModulos = programaModulos;
        this.pruebaModulos = pruebaModulos;
        this.resultadoReals = resultadoReals;
    }

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id_modulo", unique = true, nullable = false)
    public Long getIdModulo() {
        return this.idModulo;
    }

    public void setIdModulo(Long idModulo) {
        this.idModulo = idModulo;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_tipo_modulo")
    public TipoModulo getTipoModulo() {
        return this.tipoModulo;
    }

    public void setTipoModulo(TipoModulo tipoModulo) {
        this.tipoModulo = tipoModulo;
    }

    @Column(name = "activo", nullable = false)
    public String getActivo() {
        return this.activo;
    }

    public void setActivo(String activo) {
        this.activo = activo;
    }

    @Column(name = "cantidad_preguntas", nullable = false)
    public Long getCantidadPreguntas() {
        return this.cantidadPreguntas;
    }

    public void setCantidadPreguntas(Long cantidadPreguntas) {
        this.cantidadPreguntas = cantidadPreguntas;
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

    @Column(name = "prioridad", nullable = false)
    public Long getPrioridad() {
        return this.prioridad;
    }

    public void setPrioridad(Long prioridad) {
        this.prioridad = prioridad;
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

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "modulo")
    public Set<Pregunta> getPreguntas() {
        return this.preguntas;
    }

    public void setPreguntas(Set<Pregunta> preguntas) {
        this.preguntas = preguntas;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "modulo")
    public Set<ProgramaModulo> getProgramaModulos() {
        return this.programaModulos;
    }

    public void setProgramaModulos(Set<ProgramaModulo> programaModulos) {
        this.programaModulos = programaModulos;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "modulo")
    public Set<PruebaModulo> getPruebaModulos() {
        return this.pruebaModulos;
    }

    public void setPruebaModulos(Set<PruebaModulo> pruebaModulos) {
        this.pruebaModulos = pruebaModulos;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "modulo")
    public Set<ResultadoReal> getResultadoReals() {
        return this.resultadoReals;
    }

    public void setResultadoReals(Set<ResultadoReal> resultadoReals) {
        this.resultadoReals = resultadoReals;
    }

	@Override
	public String toString() {
		return "Modulo [idModulo=" + idModulo + ", activo=" + activo + ", cantidadPreguntas=" + cantidadPreguntas
				+ ", descripcion=" + descripcion + ", fechaCreacion=" + fechaCreacion + ", fechaModificacion="
				+ fechaModificacion + ", nombre=" + nombre + ", prioridad=" + prioridad + ", usuCreador=" + usuCreador
				+ ", usuModificador=" + usuModificador + "]";
	}
    
    
}
