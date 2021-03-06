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
@Table(name = "comentario", schema = "public")
public class Comentario implements java.io.Serializable {
    //@NotNull
    private Long idComentario;
    @NotNull
    private Capsula capsula;
    @NotNull
    private Usuario usuario;
    @NotNull
    @NotEmpty
    @Size(max = 1)
    private String activo;
    @NotNull
    private Long calificacion;
    @NotNull
    private Date fechaCreacion;
    private Date fechaModificacion;
    @NotNull
    private Long usuCreador;
    private Long usuModificador;
    @NotNull
    @NotEmpty
    @Size(max = 10485760)
    private String valor;

    public Comentario() {
    }

    public Comentario(Long idComentario, String activo, Long calificacion,
        Capsula capsula, Date fechaCreacion, Date fechaModificacion,
        Long usuCreador, Long usuModificador, Usuario usuario, String valor) {
        this.idComentario = idComentario;
        this.capsula = capsula;
        this.usuario = usuario;
        this.activo = activo;
        this.calificacion = calificacion;
        this.fechaCreacion = fechaCreacion;
        this.fechaModificacion = fechaModificacion;
        this.usuCreador = usuCreador;
        this.usuModificador = usuModificador;
        this.valor = valor;
    }

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id_comentario", unique = true, nullable = false)
    public Long getIdComentario() {
        return this.idComentario;
    }

    public void setIdComentario(Long idComentario) {
        this.idComentario = idComentario;
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
    @JoinColumn(name = "id_usuario")
    public Usuario getUsuario() {
        return this.usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @Column(name = "activo", nullable = false)
    public String getActivo() {
        return this.activo;
    }

    public void setActivo(String activo) {
        this.activo = activo;
    }

    @Column(name = "calificacion", nullable = false)
    public Long getCalificacion() {
        return this.calificacion;
    }

    public void setCalificacion(Long calificacion) {
        this.calificacion = calificacion;
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

    @Column(name = "valor", nullable = false)
    public String getValor() {
        return this.valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }
}
