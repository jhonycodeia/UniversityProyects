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
@Table(name = "prueba_programa_usuario_pregunta", schema = "public")
public class PruebaProgramaUsuarioPregunta implements java.io.Serializable {
    //@NotNull
    private Long idPruebaProgramaUsuarioPregunta;
    @NotNull(message="pregunta no valido")
    private Pregunta pregunta;
    //@NotNull(message="pruebaprogramausuario no valido")
    private PruebaProgramaUsuario pruebaProgramaUsuario;
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
    private Set<RespuestaPruebaProgramaUsuarioPregunta> respuestaPruebaProgramaUsuarioPreguntas =
        new HashSet<RespuestaPruebaProgramaUsuarioPregunta>(0);

    public PruebaProgramaUsuarioPregunta() {
    }

    public PruebaProgramaUsuarioPregunta(Long idPruebaProgramaUsuarioPregunta,
        String activo, Date fechaCreacion, Date fechaModificacion,
        Pregunta pregunta, PruebaProgramaUsuario pruebaProgramaUsuario,
        Set<RespuestaPruebaProgramaUsuarioPregunta> respuestaPruebaProgramaUsuarioPreguntas,
        Long usuCreador, Long usuModificador) {
        this.idPruebaProgramaUsuarioPregunta = idPruebaProgramaUsuarioPregunta;
        this.pregunta = pregunta;
        this.pruebaProgramaUsuario = pruebaProgramaUsuario;
        this.activo = activo;
        this.fechaCreacion = fechaCreacion;
        this.fechaModificacion = fechaModificacion;
        this.usuCreador = usuCreador;
        this.usuModificador = usuModificador;
        this.respuestaPruebaProgramaUsuarioPreguntas = respuestaPruebaProgramaUsuarioPreguntas;
    }

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id_prueba_programa_usuario_pregunta", unique = true, nullable = false)
    public Long getIdPruebaProgramaUsuarioPregunta() {
        return this.idPruebaProgramaUsuarioPregunta;
    }

    public void setIdPruebaProgramaUsuarioPregunta(
        Long idPruebaProgramaUsuarioPregunta) {
        this.idPruebaProgramaUsuarioPregunta = idPruebaProgramaUsuarioPregunta;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_pregunta")
    public Pregunta getPregunta() {
        return this.pregunta;
    }

    public void setPregunta(Pregunta pregunta) {
        this.pregunta = pregunta;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_prueba_programa_usuario")
    public PruebaProgramaUsuario getPruebaProgramaUsuario() {
        return this.pruebaProgramaUsuario;
    }

    public void setPruebaProgramaUsuario(
        PruebaProgramaUsuario pruebaProgramaUsuario) {
        this.pruebaProgramaUsuario = pruebaProgramaUsuario;
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

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "pruebaProgramaUsuarioPregunta")
    public Set<RespuestaPruebaProgramaUsuarioPregunta> getRespuestaPruebaProgramaUsuarioPreguntas() {
        return this.respuestaPruebaProgramaUsuarioPreguntas;
    }

    public void setRespuestaPruebaProgramaUsuarioPreguntas(
        Set<RespuestaPruebaProgramaUsuarioPregunta> respuestaPruebaProgramaUsuarioPreguntas) {
        this.respuestaPruebaProgramaUsuarioPreguntas = respuestaPruebaProgramaUsuarioPreguntas;
    }

	@Override
	public String toString() {
		return "PruebaProgramaUsuarioPregunta [idPruebaProgramaUsuarioPregunta=" + idPruebaProgramaUsuarioPregunta
				+ ", activo=" + activo + ", fechaCreacion=" + fechaCreacion + ", fechaModificacion=" + fechaModificacion
				+ ", usuCreador=" + usuCreador + ", usuModificador=" + usuModificador
				+ ", respuestaPruebaProgramaUsuarioPreguntas=" + respuestaPruebaProgramaUsuarioPreguntas + "]";
	}
    
    
}
