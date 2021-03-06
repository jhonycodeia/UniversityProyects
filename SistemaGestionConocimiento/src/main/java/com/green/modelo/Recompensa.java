package com.green.modelo;

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
@Table(name = "recompensa", schema = "public")
public class Recompensa implements java.io.Serializable {
    //@NotNull
    private Long idRecompensa;
    @NotNull
    @NotEmpty
    @Size(max = 1)
    private String activo;
    private String descripcion;
    @NotNull
    private Date fechaCreacion;
    private Date fechaModificacion;
    @NotNull
    @NotEmpty
    @Size(max = 300)
    private String nombre;
    @NotNull
    private Long requisito;
    @NotNull
    private Long usuCreador;
    private Long usuModificador;
    @NotNull
    @NotEmpty
    @Size(max = 10485760)
    private String valor;
    private Set<RecompensaUsuario> recompensaUsuarios = new HashSet<RecompensaUsuario>(0);

    public Recompensa() {
    }

    public Recompensa(Long idRecompensa, String activo, String descripcion,
        Date fechaCreacion, Date fechaModificacion, String nombre,
        Set<RecompensaUsuario> recompensaUsuarios, Long requisito,
        Long usuCreador, Long usuModificador, String valor) {
        this.idRecompensa = idRecompensa;
        this.activo = activo;
        this.descripcion = descripcion;
        this.fechaCreacion = fechaCreacion;
        this.fechaModificacion = fechaModificacion;
        this.nombre = nombre;
        this.requisito = requisito;
        this.usuCreador = usuCreador;
        this.usuModificador = usuModificador;
        this.valor = valor;
        this.recompensaUsuarios = recompensaUsuarios;
    }

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id_recompensa", unique = true, nullable = false)
    public Long getIdRecompensa() {
        return this.idRecompensa;
    }

    public void setIdRecompensa(Long idRecompensa) {
        this.idRecompensa = idRecompensa;
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

    @Column(name = "nombre", nullable = false)
    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Column(name = "requisito", nullable = false)
    public Long getRequisito() {
        return this.requisito;
    }

    public void setRequisito(Long requisito) {
        this.requisito = requisito;
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

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "recompensa")
    public Set<RecompensaUsuario> getRecompensaUsuarios() {
        return this.recompensaUsuarios;
    }

    public void setRecompensaUsuarios(Set<RecompensaUsuario> recompensaUsuarios) {
        this.recompensaUsuarios = recompensaUsuarios;
    }
}
