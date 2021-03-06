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
@Table(name = "puntos", schema = "public")
public class Puntos implements java.io.Serializable {
    //@NotNull
    private Long idPuntos;
    @NotNull
    private TipoPuntos tipoPuntos;
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
    private Long puntos;
    @NotNull
    private Long usuCreador;
    private Long usuModificador;

    public Puntos() {
    }

    public Puntos(Long idPuntos, String activo, Date fechaCreacion,
        Date fechaModificacion, Long puntos, TipoPuntos tipoPuntos,
        Long usuCreador, Long usuModificador, Usuario usuario) {
        this.idPuntos = idPuntos;
        this.tipoPuntos = tipoPuntos;
        this.usuario = usuario;
        this.activo = activo;
        this.fechaCreacion = fechaCreacion;
        this.fechaModificacion = fechaModificacion;
        this.puntos = puntos;
        this.usuCreador = usuCreador;
        this.usuModificador = usuModificador;
    }

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id_puntos", unique = true, nullable = false)
    public Long getIdPuntos() {
        return this.idPuntos;
    }

    public void setIdPuntos(Long idPuntos) {
        this.idPuntos = idPuntos;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_tipo_puntos")
    public TipoPuntos getTipoPuntos() {
        return this.tipoPuntos;
    }

    public void setTipoPuntos(TipoPuntos tipoPuntos) {
        this.tipoPuntos = tipoPuntos;
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

    @Column(name = "puntos", nullable = false)
    public Long getPuntos() {
        return this.puntos;
    }

    public void setPuntos(Long puntos) {
        this.puntos = puntos;
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
