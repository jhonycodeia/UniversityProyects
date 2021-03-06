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
@Table(name = "prueba_programa_usuario", schema = "public")
public class PruebaProgramaUsuario implements java.io.Serializable {
    //@NotNull
    private Long idPruebaProgramaUsuario;
    @NotNull(message="estadoprueba no valido")
    private EstadoPrueba estadoPrueba;
    //@NotNull(message="programausuario no valido")
    private ProgramaUsuario programaUsuario;
    @NotNull(message="prueba no valido")
    private Prueba prueba;
    @NotNull(message="activo no valido")
    @NotEmpty
    @Size(max = 1)
    private String activo;
    @NotNull(message="fechacreacion no valido")
    private Date fechaCreacion;
    private Date fechaModificacion;
    @NotNull(message="usucreador no valido")
    private Long usuCreador;
    private Long usuModificador;
    private Set<PruebaProgramaUsuarioPregunta> pruebaProgramaUsuarioPreguntas = new HashSet<PruebaProgramaUsuarioPregunta>(0);

    public PruebaProgramaUsuario() {
    }

    public PruebaProgramaUsuario(Long idPruebaProgramaUsuario, String activo,
        EstadoPrueba estadoPrueba, Date fechaCreacion, Date fechaModificacion,
        ProgramaUsuario programaUsuario, Prueba prueba,
        Set<PruebaProgramaUsuarioPregunta> pruebaProgramaUsuarioPreguntas,
        Long usuCreador, Long usuModificador) {
        this.idPruebaProgramaUsuario = idPruebaProgramaUsuario;
        this.estadoPrueba = estadoPrueba;
        this.programaUsuario = programaUsuario;
        this.prueba = prueba;
        this.activo = activo;
        this.fechaCreacion = fechaCreacion;
        this.fechaModificacion = fechaModificacion;
        this.usuCreador = usuCreador;
        this.usuModificador = usuModificador;
        this.pruebaProgramaUsuarioPreguntas = pruebaProgramaUsuarioPreguntas;
    }

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id_prueba_programa_usuario", unique = true, nullable = false)
    public Long getIdPruebaProgramaUsuario() {
        return this.idPruebaProgramaUsuario;
    }

    public void setIdPruebaProgramaUsuario(Long idPruebaProgramaUsuario) {
        this.idPruebaProgramaUsuario = idPruebaProgramaUsuario;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_estado_prueba")
    public EstadoPrueba getEstadoPrueba() {
        return this.estadoPrueba;
    }

    public void setEstadoPrueba(EstadoPrueba estadoPrueba) {
        this.estadoPrueba = estadoPrueba;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_programa_usuario")
    public ProgramaUsuario getProgramaUsuario() {
        return this.programaUsuario;
    }

    public void setProgramaUsuario(ProgramaUsuario programaUsuario) {
        this.programaUsuario = programaUsuario;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_prueba")
    public Prueba getPrueba() {
        return this.prueba;
    }

    public void setPrueba(Prueba prueba) {
        this.prueba = prueba;
    }

    @Column(name = "activo", nullable = false)
    public String getActivo() {
        return this.activo;
    }

    public void setActivo(String activo) {
        this.activo = activo;
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

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "pruebaProgramaUsuario")
    public Set<PruebaProgramaUsuarioPregunta> getPruebaProgramaUsuarioPreguntas() {
        return this.pruebaProgramaUsuarioPreguntas;
    }

    public void setPruebaProgramaUsuarioPreguntas(
        Set<PruebaProgramaUsuarioPregunta> pruebaProgramaUsuarioPreguntas) {
        this.pruebaProgramaUsuarioPreguntas = pruebaProgramaUsuarioPreguntas;
    }

	@Override
	public String toString() {
		return "PruebaProgramaUsuario [idPruebaProgramaUsuario=" + idPruebaProgramaUsuario + ", activo=" + activo
				+ ", fechaCreacion=" + fechaCreacion + ", fechaModificacion=" + fechaModificacion + ", usuCreador="
				+ usuCreador + ", usuModificador=" + usuModificador + ", pruebaProgramaUsuarioPreguntas="
				+ pruebaProgramaUsuarioPreguntas + "]";
	}
    
    
}
