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
@Table(name = "respuesta", schema = "public")
public class Respuesta implements java.io.Serializable {
    //@NotNull
    private Long idRespuesta;
    @NotNull(message="pregunta no valido")
    private Pregunta pregunta;
    @NotNull(message="activo no valido")
    @NotEmpty
    @Size(max = 1)
    private String activo;
    private String descripcionRespuesta;
    @NotNull(message="fechacreacion no valido")
    private Date fechaCreacion;
    private Date fechaModificacion;
    @NotNull(message="porcentajeacierto no valido")
    private Integer porcentajeAcierto;
    private String rutaImagen;
    @NotNull(message="usucreador no valido")
    private Long usuCreador;
    private Long usuModificador;
    private Set<RespuestaPruebaProgramaUsuarioPregunta> respuestaPruebaProgramaUsuarioPreguntas =
        new HashSet<RespuestaPruebaProgramaUsuarioPregunta>(0);

    public Respuesta() {
    }

    public Respuesta(Long idRespuesta, String activo,
        String descripcionRespuesta, Date fechaCreacion,
        Date fechaModificacion, Integer porcentajeAcierto, Pregunta pregunta,
        Set<RespuestaPruebaProgramaUsuarioPregunta> respuestaPruebaProgramaUsuarioPreguntas,
        String rutaImagen, Long usuCreador, Long usuModificador) {
        this.idRespuesta = idRespuesta;
        this.pregunta = pregunta;
        this.activo = activo;
        this.descripcionRespuesta = descripcionRespuesta;
        this.fechaCreacion = fechaCreacion;
        this.fechaModificacion = fechaModificacion;
        this.porcentajeAcierto = porcentajeAcierto;
        this.rutaImagen = rutaImagen;
        this.usuCreador = usuCreador;
        this.usuModificador = usuModificador;
        this.respuestaPruebaProgramaUsuarioPreguntas = respuestaPruebaProgramaUsuarioPreguntas;
    }

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id_respuesta", unique = true, nullable = false)
    public Long getIdRespuesta() {
        return this.idRespuesta;
    }

    public void setIdRespuesta(Long idRespuesta) {
        this.idRespuesta = idRespuesta;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_pregunta")
    public Pregunta getPregunta() {
        return this.pregunta;
    }

    public void setPregunta(Pregunta pregunta) {
        this.pregunta = pregunta;
    }

    @Column(name = "activo", nullable = false)
    public String getActivo() {
        return this.activo;
    }

    public void setActivo(String activo) {
        this.activo = activo;
    }

    @Column(name = "descripcion_respuesta")
    public String getDescripcionRespuesta() {
        return this.descripcionRespuesta;
    }

    public void setDescripcionRespuesta(String descripcionRespuesta) {
        this.descripcionRespuesta = descripcionRespuesta;
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

    @Column(name = "porcentaje_acierto", nullable = false)
    public Integer getPorcentajeAcierto() {
        return this.porcentajeAcierto;
    }

    public void setPorcentajeAcierto(Integer porcentajeAcierto) {
        this.porcentajeAcierto = porcentajeAcierto;
    }

    @Column(name = "ruta_imagen")
    public String getRutaImagen() {
        return this.rutaImagen;
    }

    public void setRutaImagen(String rutaImagen) {
        this.rutaImagen = rutaImagen;
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

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "respuesta")
    public Set<RespuestaPruebaProgramaUsuarioPregunta> getRespuestaPruebaProgramaUsuarioPreguntas() {
        return this.respuestaPruebaProgramaUsuarioPreguntas;
    }

    public void setRespuestaPruebaProgramaUsuarioPreguntas(
        Set<RespuestaPruebaProgramaUsuarioPregunta> respuestaPruebaProgramaUsuarioPreguntas) {
        this.respuestaPruebaProgramaUsuarioPreguntas = respuestaPruebaProgramaUsuarioPreguntas;
    }

	@Override
	public String toString() {
		return "Respuesta [idRespuesta=" + idRespuesta + ", activo=" + activo + ", descripcionRespuesta="
				+ descripcionRespuesta + ", fechaCreacion=" + fechaCreacion + ", fechaModificacion=" + fechaModificacion
				+ ", porcentajeAcierto=" + porcentajeAcierto + ", rutaImagen=" + rutaImagen + ", usuCreador="
				+ usuCreador + ", usuModificador=" + usuModificador + "]";
	}
    
    
}
