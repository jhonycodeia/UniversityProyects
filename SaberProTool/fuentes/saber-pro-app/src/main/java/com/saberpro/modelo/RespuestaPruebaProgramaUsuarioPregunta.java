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
@Table(name = "respuesta_prueba_programa_usuario_pregunta", schema = "public")
public class RespuestaPruebaProgramaUsuarioPregunta implements java.io.Serializable {
    //@NotNull
    private Long idRespuestaPruebaProgramaUsuarioPregunta;
    @NotNull(message="pruebaprogramausuariopregunta no valido")
    private PruebaProgramaUsuarioPregunta pruebaProgramaUsuarioPregunta;
    //@NotNull(message="respuesta no valido")
    private Respuesta respuesta;
    @NotNull(message="activo no valido")
    @NotEmpty
    @Size(max = 1)
    private String activo;
    @NotNull(message="fechacreacion no valido")
    private Date fechaCreacion;
    private Date fechaModificacion;
    @NotNull(message="porcentajeasignado no valido")
    private Long porcentajeAsignado;
    @NotNull(message="usucreador no valido")
    private Long usuCreador;
    private Long usuModificador;

    public RespuestaPruebaProgramaUsuarioPregunta() {
    }

    public RespuestaPruebaProgramaUsuarioPregunta(
        Long idRespuestaPruebaProgramaUsuarioPregunta, String activo,
        Date fechaCreacion, Date fechaModificacion, Long porcentajeAsignado,
        PruebaProgramaUsuarioPregunta pruebaProgramaUsuarioPregunta,
        Respuesta respuesta, Long usuCreador, Long usuModificador) {
        this.idRespuestaPruebaProgramaUsuarioPregunta = idRespuestaPruebaProgramaUsuarioPregunta;
        this.pruebaProgramaUsuarioPregunta = pruebaProgramaUsuarioPregunta;
        this.respuesta = respuesta;
        this.activo = activo;
        this.fechaCreacion = fechaCreacion;
        this.fechaModificacion = fechaModificacion;
        this.porcentajeAsignado = porcentajeAsignado;
        this.usuCreador = usuCreador;
        this.usuModificador = usuModificador;
    }

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id_respuesta_prueba_programa_usuario_pregunta", unique = true, nullable = false)
    public Long getIdRespuestaPruebaProgramaUsuarioPregunta() {
        return this.idRespuestaPruebaProgramaUsuarioPregunta;
    }

    public void setIdRespuestaPruebaProgramaUsuarioPregunta(
        Long idRespuestaPruebaProgramaUsuarioPregunta) {
        this.idRespuestaPruebaProgramaUsuarioPregunta = idRespuestaPruebaProgramaUsuarioPregunta;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_prueba_programa_usuario_pregunta")
    public PruebaProgramaUsuarioPregunta getPruebaProgramaUsuarioPregunta() {
        return this.pruebaProgramaUsuarioPregunta;
    }

    public void setPruebaProgramaUsuarioPregunta(
        PruebaProgramaUsuarioPregunta pruebaProgramaUsuarioPregunta) {
        this.pruebaProgramaUsuarioPregunta = pruebaProgramaUsuarioPregunta;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_respuesta")
    public Respuesta getRespuesta() {
        return this.respuesta;
    }

    public void setRespuesta(Respuesta respuesta) {
        this.respuesta = respuesta;
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

    @Column(name = "porcentaje_asignado", nullable = false)
    public Long getPorcentajeAsignado() {
        return this.porcentajeAsignado;
    }

    public void setPorcentajeAsignado(Long porcentajeAsignado) {
        this.porcentajeAsignado = porcentajeAsignado;
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
		return "RespuestaPruebaProgramaUsuarioPregunta [idRespuestaPruebaProgramaUsuarioPregunta="
				+ idRespuestaPruebaProgramaUsuarioPregunta + ", activo=" + activo + ", fechaCreacion=" + fechaCreacion
				+ ", fechaModificacion=" + fechaModificacion + ", porcentajeAsignado=" + porcentajeAsignado
				+ ", usuCreador=" + usuCreador + ", usuModificador=" + usuModificador + "]";
	}
    
    
}
