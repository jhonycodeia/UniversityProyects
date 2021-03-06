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
@Table(name = "usuario_trofeo", schema = "public")
public class UsuarioTrofeo implements java.io.Serializable {
    //@NotNull
    private Long idUsuarioTrofeo;
    @NotNull
    private Trofeo trofeo;
    @NotNull
    private Usuario usuario;
    @NotNull
    @NotEmpty
    @Size(max = 1)
    private String activo;
    @NotNull
    private Date fechaCreacion;
    private Date fechaModificacion;
    @NotNull
    private Long usuCreador;
    private Long usuModificador;

    public UsuarioTrofeo() {
    }

    public UsuarioTrofeo(Long idUsuarioTrofeo, String activo,
        Date fechaCreacion, Date fechaModificacion, Trofeo trofeo,
        Long usuCreador, Long usuModificador, Usuario usuario) {
        this.idUsuarioTrofeo = idUsuarioTrofeo;
        this.trofeo = trofeo;
        this.usuario = usuario;
        this.activo = activo;
        this.fechaCreacion = fechaCreacion;
        this.fechaModificacion = fechaModificacion;
        this.usuCreador = usuCreador;
        this.usuModificador = usuModificador;
    }

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id_usuario_trofeo", unique = true, nullable = false)
    public Long getIdUsuarioTrofeo() {
        return this.idUsuarioTrofeo;
    }

    public void setIdUsuarioTrofeo(Long idUsuarioTrofeo) {
        this.idUsuarioTrofeo = idUsuarioTrofeo;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_trofeo")
    public Trofeo getTrofeo() {
        return this.trofeo;
    }

    public void setTrofeo(Trofeo trofeo) {
        this.trofeo = trofeo;
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
}
