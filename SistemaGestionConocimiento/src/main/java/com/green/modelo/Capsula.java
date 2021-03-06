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
@Table(name = "capsula", schema = "public")
public class Capsula implements java.io.Serializable {
    //@NotNull
    private Long idCapsula;
    //@NotNull
    private Categoria categoria;
    //@NotNull
    private Proceso proceso;
    //@NotNull
    private Subproceso subproceso;
    @NotNull
    private TipoCapsula tipoCapsula;
    @NotNull
    private Usuario usuario;
    @NotNull
    @NotEmpty
    @Size(max = 1)
    private String activo;
    private String descripcion;
    private String disparador;
    @NotNull
    private Date fechaCreacion;
    private Date fechaModificacion;
    private Long parent;
    private String resolucion;
    private String situacion;
    @NotNull
    @NotEmpty
    @Size(max = 300)
    private String titulo;
    @NotNull
    private Long usuCreador;
    private Long usuModificador;
    @NotNull
    @NotEmpty
    @Size(max = 10485760)
    private String valor;
    private Set<Calificacion> calificacions = new HashSet<Calificacion>(0);
    private Set<CapsulaPalabrasClave> capsulaPalabrasClaves = new HashSet<CapsulaPalabrasClave>(0);
    private Set<Comentario> comentarios = new HashSet<Comentario>(0);
    private Set<Documento> documentos = new HashSet<Documento>(0);
    private Set<Notificacion> notificacions = new HashSet<Notificacion>(0);

    public Capsula() {
    }

    public Capsula(Long idCapsula, String activo,
        Set<Calificacion> calificacions,
        Set<CapsulaPalabrasClave> capsulaPalabrasClaves, Categoria categoria,
        Set<Comentario> comentarios, String descripcion, String disparador,
        Set<Documento> documentos, Date fechaCreacion, Date fechaModificacion,
        Set<Notificacion> notificacions, Long parent, Proceso proceso,
        String resolucion, String situacion, Subproceso subproceso,
        TipoCapsula tipoCapsula, String titulo, Long usuCreador,
        Long usuModificador, Usuario usuario, String valor) {
        this.idCapsula = idCapsula;
        this.categoria = categoria;
        this.proceso = proceso;
        this.subproceso = subproceso;
        this.tipoCapsula = tipoCapsula;
        this.usuario = usuario;
        this.activo = activo;
        this.descripcion = descripcion;
        this.disparador = disparador;
        this.fechaCreacion = fechaCreacion;
        this.fechaModificacion = fechaModificacion;
        this.parent = parent;
        this.resolucion = resolucion;
        this.situacion = situacion;
        this.titulo = titulo;
        this.usuCreador = usuCreador;
        this.usuModificador = usuModificador;
        this.valor = valor;
        this.calificacions = calificacions;
        this.capsulaPalabrasClaves = capsulaPalabrasClaves;
        this.comentarios = comentarios;
        this.documentos = documentos;
        this.notificacions = notificacions;
    }

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id_capsula", unique = true, nullable = false)
    public Long getIdCapsula() {
        return this.idCapsula;
    }

    public void setIdCapsula(Long idCapsula) {
        this.idCapsula = idCapsula;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_categoria")
    public Categoria getCategoria() {
        return this.categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_proceso")
    public Proceso getProceso() {
        return this.proceso;
    }

    public void setProceso(Proceso proceso) {
        this.proceso = proceso;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_subproceso")
    public Subproceso getSubproceso() {
        return this.subproceso;
    }

    public void setSubproceso(Subproceso subproceso) {
        this.subproceso = subproceso;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_tipo_capsula")
    public TipoCapsula getTipoCapsula() {
        return this.tipoCapsula;
    }

    public void setTipoCapsula(TipoCapsula tipoCapsula) {
        this.tipoCapsula = tipoCapsula;
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

    @Column(name = "descripcion")
    public String getDescripcion() {
        return this.descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Column(name = "disparador")
    public String getDisparador() {
        return this.disparador;
    }

    public void setDisparador(String disparador) {
        this.disparador = disparador;
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

    @Column(name = "parent")
    public Long getParent() {
        return this.parent;
    }

    public void setParent(Long parent) {
        this.parent = parent;
    }

    @Column(name = "resolucion")
    public String getResolucion() {
        return this.resolucion;
    }

    public void setResolucion(String resolucion) {
        this.resolucion = resolucion;
    }

    @Column(name = "situacion")
    public String getSituacion() {
        return this.situacion;
    }

    public void setSituacion(String situacion) {
        this.situacion = situacion;
    }

    @Column(name = "titulo", nullable = false)
    public String getTitulo() {
        return this.titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
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

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "capsula")
    public Set<Calificacion> getCalificacions() {
        return this.calificacions;
    }

    public void setCalificacions(Set<Calificacion> calificacions) {
        this.calificacions = calificacions;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "capsula")
    public Set<CapsulaPalabrasClave> getCapsulaPalabrasClaves() {
        return this.capsulaPalabrasClaves;
    }

    public void setCapsulaPalabrasClaves(
        Set<CapsulaPalabrasClave> capsulaPalabrasClaves) {
        this.capsulaPalabrasClaves = capsulaPalabrasClaves;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "capsula")
    public Set<Comentario> getComentarios() {
        return this.comentarios;
    }

    public void setComentarios(Set<Comentario> comentarios) {
        this.comentarios = comentarios;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "capsula")
    public Set<Documento> getDocumentos() {
        return this.documentos;
    }

    public void setDocumentos(Set<Documento> documentos) {
        this.documentos = documentos;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "capsula")
    public Set<Notificacion> getNotificacions() {
        return this.notificacions;
    }

    public void setNotificacions(Set<Notificacion> notificacions) {
        this.notificacions = notificacions;
    }
}
