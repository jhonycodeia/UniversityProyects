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
@Table(name = "programa_usuario", schema = "public")
public class ProgramaUsuario implements java.io.Serializable {
    //@NotNull
    private Long idProgramaUsuario;
    @NotNull(message="programa no valido")
    private Programa programa;
    @NotNull(message="usuario no valido")
    private Usuario usuario;
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
    private Set<PruebaProgramaUsuario> pruebaProgramaUsuarios = new HashSet<PruebaProgramaUsuario>(0);

    public ProgramaUsuario() {
    }

    public ProgramaUsuario(Long idProgramaUsuario, String activo,
        Date fechaCreacion, Date fechaModificacion, Programa programa,
        Set<PruebaProgramaUsuario> pruebaProgramaUsuarios, Long usuCreador,
        Long usuModificador, Usuario usuario) {
        this.idProgramaUsuario = idProgramaUsuario;
        this.programa = programa;
        this.usuario = usuario;
        this.activo = activo;
        this.fechaCreacion = fechaCreacion;
        this.fechaModificacion = fechaModificacion;
        this.usuCreador = usuCreador;
        this.usuModificador = usuModificador;
        this.pruebaProgramaUsuarios = pruebaProgramaUsuarios;
    }

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id_programa_usuario", unique = true, nullable = false)
    public Long getIdProgramaUsuario() {
        return this.idProgramaUsuario;
    }

    public void setIdProgramaUsuario(Long idProgramaUsuario) {
        this.idProgramaUsuario = idProgramaUsuario;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_programa")
    public Programa getPrograma() {
        return this.programa;
    }

    public void setPrograma(Programa programa) {
        this.programa = programa;
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

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "programaUsuario")
    public Set<PruebaProgramaUsuario> getPruebaProgramaUsuarios() {
        return this.pruebaProgramaUsuarios;
    }

    public void setPruebaProgramaUsuarios(
        Set<PruebaProgramaUsuario> pruebaProgramaUsuarios) {
        this.pruebaProgramaUsuarios = pruebaProgramaUsuarios;
    }

	@Override
	public String toString() {
		return "ProgramaUsuario [idProgramaUsuario=" + idProgramaUsuario + ", activo=" + activo + ", fechaCreacion="
				+ fechaCreacion + ", fechaModificacion=" + fechaModificacion + ", usuCreador=" + usuCreador
				+ ", usuModificador=" + usuModificador + ", pruebaProgramaUsuarios=" + pruebaProgramaUsuarios + "]";
	}
    
    
}
