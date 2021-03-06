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
@Table(name = "usuario", schema = "public")
public class Usuario implements java.io.Serializable {
    //@NotNull
    private Long idUsuario;
    @NotNull(message="area invalido")
    private Area area;
    @NotNull(message="tipo usuario invalido")
    private TipoUsuario tipoUsuario;
    @NotNull(message="activo invalido")
    @NotEmpty
    @Size(max = 1)
    private String activo;
    @NotNull(message="apellido invalido")
    @NotEmpty
    @Size(max = 100)
    private String apellido;
    @NotNull(message="clave invalido")
    @NotEmpty
    @Size(max = 10485760)
    private String clave;
    @NotNull(message="correo invalido")
    @Email(message="correo no valido")
    @NotEmpty
    @Size(max = 300)
    private String correo;
    @NotNull(message="fechaCreacion invalido")
    private Date fechaCreacion;
    private Date fechaModificacion;
    private Date fechaNacimiento;
    private String genero;
    @NotNull(message="nombre invalido")
    @NotEmpty
    @Size(max = 100)
    private String nombre;
    private Long puntos;
    @NotNull(message="usuCreador invalido")
    private Long usuCreador;
    private Long usuModificador;
    private Set<Calificacion> calificacions = new HashSet<Calificacion>(0);
    private Set<Capsula> capsulas = new HashSet<Capsula>(0);
    private Set<Comentario> comentarios = new HashSet<Comentario>(0);
    private Set<Notificacion> notificacions = new HashSet<Notificacion>(0);
    private Set<Puntos> puntoses = new HashSet<Puntos>(0);
    private Set<RecompensaUsuario> recompensaUsuarios = new HashSet<RecompensaUsuario>(0);
    private Set<UsuarioTrofeo> usuarioTrofeos = new HashSet<UsuarioTrofeo>(0);

    public Usuario() {
    }

    public Usuario(Long idUsuario, String activo, String apellido, Area area,
        Set<Calificacion> calificacions, Set<Capsula> capsulas, String clave,
        Set<Comentario> comentarios, String correo, Date fechaCreacion,
        Date fechaModificacion, Date fechaNacimiento, String genero,
        String nombre, Set<Notificacion> notificacions, Long puntos,
        Set<Puntos> puntoses, Set<RecompensaUsuario> recompensaUsuarios,
        TipoUsuario tipoUsuario, Long usuCreador, Long usuModificador,
        Set<UsuarioTrofeo> usuarioTrofeos) {
        this.idUsuario = idUsuario;
        this.area = area;
        this.tipoUsuario = tipoUsuario;
        this.activo = activo;
        this.apellido = apellido;
        this.clave = clave;
        this.correo = correo;
        this.fechaCreacion = fechaCreacion;
        this.fechaModificacion = fechaModificacion;
        this.fechaNacimiento = fechaNacimiento;
        this.genero = genero;
        this.nombre = nombre;
        this.puntos = puntos;
        this.usuCreador = usuCreador;
        this.usuModificador = usuModificador;
        this.calificacions = calificacions;
        this.capsulas = capsulas;
        this.comentarios = comentarios;
        this.notificacions = notificacions;
        this.puntoses = puntoses;
        this.recompensaUsuarios = recompensaUsuarios;
        this.usuarioTrofeos = usuarioTrofeos;
    }

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id_usuario", unique = true, nullable = false)
    public Long getIdUsuario() {
        return this.idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_area")
    public Area getArea() {
        return this.area;
    }

    public void setArea(Area area) {
        this.area = area;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_tipo_usuario")
    public TipoUsuario getTipoUsuario() {
        return this.tipoUsuario;
    }

    public void setTipoUsuario(TipoUsuario tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    @Column(name = "activo", nullable = false)
    public String getActivo() {
        return this.activo;
    }

    public void setActivo(String activo) {
        this.activo = activo;
    }

    @Column(name = "apellido", nullable = false)
    public String getApellido() {
        return this.apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    @Column(name = "clave", nullable = false)
    public String getClave() {
        return this.clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    @Column(name = "correo", nullable = false)
    public String getCorreo() {
        return this.correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
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

    @Column(name = "fecha_nacimiento")
    public Date getFechaNacimiento() {
        return this.fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    @Column(name = "genero")
    public String getGenero() {
        return this.genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    @Column(name = "nombre", nullable = false)
    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Column(name = "puntos")
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

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "usuario")
    public Set<Calificacion> getCalificacions() {
        return this.calificacions;
    }

    public void setCalificacions(Set<Calificacion> calificacions) {
        this.calificacions = calificacions;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "usuario")
    public Set<Capsula> getCapsulas() {
        return this.capsulas;
    }

    public void setCapsulas(Set<Capsula> capsulas) {
        this.capsulas = capsulas;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "usuario")
    public Set<Comentario> getComentarios() {
        return this.comentarios;
    }

    public void setComentarios(Set<Comentario> comentarios) {
        this.comentarios = comentarios;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "usuario")
    public Set<Notificacion> getNotificacions() {
        return this.notificacions;
    }

    public void setNotificacions(Set<Notificacion> notificacions) {
        this.notificacions = notificacions;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "usuario")
    public Set<Puntos> getPuntoses() {
        return this.puntoses;
    }

    public void setPuntoses(Set<Puntos> puntoses) {
        this.puntoses = puntoses;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "usuario")
    public Set<RecompensaUsuario> getRecompensaUsuarios() {
        return this.recompensaUsuarios;
    }

    public void setRecompensaUsuarios(Set<RecompensaUsuario> recompensaUsuarios) {
        this.recompensaUsuarios = recompensaUsuarios;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "usuario")
    public Set<UsuarioTrofeo> getUsuarioTrofeos() {
        return this.usuarioTrofeos;
    }

    public void setUsuarioTrofeos(Set<UsuarioTrofeo> usuarioTrofeos) {
        this.usuarioTrofeos = usuarioTrofeos;
    }
}
