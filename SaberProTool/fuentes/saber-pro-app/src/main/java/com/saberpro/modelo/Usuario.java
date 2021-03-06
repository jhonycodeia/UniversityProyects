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
@Table(name = "usuario", schema = "public")
public class Usuario implements java.io.Serializable {
    //@NotNull
    private Long idUsuario;
    @NotNull(message="tipousuario no valido")
    private TipoUsuario tipoUsuario;
    @NotNull(message="activo no valido")
    @NotEmpty
    @Size(max = 1)
    private String activo;
    @NotNull(message="apellido no valido")
    @NotEmpty
    @Size(min=3,max = 300)
    private String apellido;
    @NotNull(message="celular no valido")
    @Range(min=10)
    private Long celular;
    @NotNull(message="codigo no valido")
    @Range(min=7)
    private Long codigo;
    @NotNull(message="correo no valido")
    @NotEmpty
    @Email
    @Size(min=7,max = 1200)
    private String correo;
    @NotNull(message="fechacreacion no valido")
    private Date fechaCreacion;
    private Date fechaModificacion;
    @NotNull(message="genero no valido")
    @NotEmpty
    @Size(max = 1)
    private String genero;
    @NotNull(message="identificacion no valido")
    @Range(min=7)
    private Long identificacion;
    @NotNull(message="nombre no valido")
    @NotEmpty
    @Size(min=3,max=300)
    private String nombre;
    @NotNull(message="password no valido")
    @NotEmpty
    @Size(min=8,max = 1200)
    private String password;
    @NotNull(message="usucreador no valido")
    private Long usuCreador;
    private Long usuModificador;
    private Set<Matricula> matriculas = new HashSet<Matricula>(0);
    private Set<ProgramaUsuario> programaUsuarios = new HashSet<ProgramaUsuario>(0);

    public Usuario() {
    }

    public Usuario(Long idUsuario, String activo, String apellido,
        Long celular, Long codigo, String correo, Date fechaCreacion,
        Date fechaModificacion, String genero, Long identificacion,
        Set<Matricula> matriculas, String nombre, String password,
        Set<ProgramaUsuario> programaUsuarios, TipoUsuario tipoUsuario,
        Long usuCreador, Long usuModificador) {
        this.idUsuario = idUsuario;
        this.tipoUsuario = tipoUsuario;
        this.activo = activo;
        this.apellido = apellido;
        this.celular = celular;
        this.codigo = codigo;
        this.correo = correo;
        this.fechaCreacion = fechaCreacion;
        this.fechaModificacion = fechaModificacion;
        this.genero = genero;
        this.identificacion = identificacion;
        this.nombre = nombre;
        this.password = password;
        this.usuCreador = usuCreador;
        this.usuModificador = usuModificador;
        this.matriculas = matriculas;
        this.programaUsuarios = programaUsuarios;
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

    @Column(name = "celular",unique = true, nullable = false)
    public Long getCelular() {
        return this.celular;
    }

    public void setCelular(Long celular) {
        this.celular = celular;
    }

    @Column(name = "codigo",unique = true, nullable = false)
    public Long getCodigo() {
        return this.codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    @Column(name = "correo",unique = true, nullable = false)
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

    @Column(name = "genero", nullable = false)
    public String getGenero() {
        return this.genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    @Column(name = "identificacion",unique = true, nullable = false)
    public Long getIdentificacion() {
        return this.identificacion;
    }

    public void setIdentificacion(Long identificacion) {
        this.identificacion = identificacion;
    }

    @Column(name = "nombre", nullable = false)
    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Column(name = "password", nullable = false)
    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
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
    public Set<Matricula> getMatriculas() {
        return this.matriculas;
    }

    public void setMatriculas(Set<Matricula> matriculas) {
        this.matriculas = matriculas;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "usuario")
    public Set<ProgramaUsuario> getProgramaUsuarios() {
        return this.programaUsuarios;
    }

    public void setProgramaUsuarios(Set<ProgramaUsuario> programaUsuarios) {
        this.programaUsuarios = programaUsuarios;
    }

	@Override
	public String toString() {
		return "Usuario [idUsuario=" + idUsuario + ", activo=" + activo + ", apellido=" + apellido + ", celular="
				+ celular + ", codigo=" + codigo + ", correo=" + correo + ", fechaCreacion=" + fechaCreacion
				+ ", fechaModificacion=" + fechaModificacion + ", genero=" + genero + ", identificacion="
				+ identificacion + ", nombre=" + nombre + ", password=" + password + ", usuCreador=" + usuCreador
				+ ", usuModificador=" + usuModificador + "]";
	}
    
    
}
