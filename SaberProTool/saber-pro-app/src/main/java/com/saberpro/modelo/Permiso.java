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
@Table(name = "permiso", schema = "public")
public class Permiso implements java.io.Serializable {
    //@NotNull
    private Long idPermiso;
    @NotNull(message="grupoOpciones no valido")
    private GrupoOpcion grupoOpcion;
    @NotNull(message="tipousuario no valido")
    private TipoUsuario tipoUsuario;
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

    public Permiso() {
    }

    public Permiso(Long idPermiso, String activo, Date fechaCreacion,
        Date fechaModificacion, GrupoOpcion grupoOpcion,
        TipoUsuario tipoUsuario, Long usuCreador, Long usuModificador) {
        this.idPermiso = idPermiso;
        this.grupoOpcion = grupoOpcion;
        this.tipoUsuario = tipoUsuario;
        this.activo = activo;
        this.fechaCreacion = fechaCreacion;
        this.fechaModificacion = fechaModificacion;
        this.usuCreador = usuCreador;
        this.usuModificador = usuModificador;
    }

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id_permiso", unique = true, nullable = false)
    public Long getIdPermiso() {
        return this.idPermiso;
    }

    public void setIdPermiso(Long idPermiso) {
        this.idPermiso = idPermiso;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_grupo_opcion")
    public GrupoOpcion getGrupoOpcion() {
        return this.grupoOpcion;
    }

    public void setGrupoOpcion(GrupoOpcion grupoOpcion) {
        this.grupoOpcion = grupoOpcion;
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

	@Override
	public String toString() {
		return "Permiso [idPermiso=" + idPermiso + ", activo=" + activo + ", fechaCreacion=" + fechaCreacion
				+ ", fechaModificacion=" + fechaModificacion + ", usuCreador=" + usuCreador + ", usuModificador="
				+ usuModificador + "]";
	}
    
    
}
