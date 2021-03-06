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
@Table(name = "programa_modulo", schema = "public")
public class ProgramaModulo implements java.io.Serializable {
    //@NotNull
    private Long idProgramaModulo;
    @NotNull(message="modulo no valido")
    private Modulo modulo;
    @NotNull(message="programa no valido")
    private Programa programa;
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

    public ProgramaModulo() {
    }

    public ProgramaModulo(Long idProgramaModulo, String activo,
        Date fechaCreacion, Date fechaModificacion, Modulo modulo,
        Programa programa, Long usuCreador, Long usuModificador) {
        this.idProgramaModulo = idProgramaModulo;
        this.modulo = modulo;
        this.programa = programa;
        this.activo = activo;
        this.fechaCreacion = fechaCreacion;
        this.fechaModificacion = fechaModificacion;
        this.usuCreador = usuCreador;
        this.usuModificador = usuModificador;
    }

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id_programa_modulo", unique = true, nullable = false)
    public Long getIdProgramaModulo() {
        return this.idProgramaModulo;
    }

    public void setIdProgramaModulo(Long idProgramaModulo) {
        this.idProgramaModulo = idProgramaModulo;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_modulo")
    public Modulo getModulo() {
        return this.modulo;
    }

    public void setModulo(Modulo modulo) {
        this.modulo = modulo;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_programa")
    public Programa getPrograma() {
        return this.programa;
    }

    public void setPrograma(Programa programa) {
        this.programa = programa;
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
		return "ProgramaModulo [idProgramaModulo=" + idProgramaModulo + ", activo=" + activo + ", fechaCreacion="
				+ fechaCreacion + ", fechaModificacion=" + fechaModificacion + ", usuCreador=" + usuCreador
				+ ", usuModificador=" + usuModificador + "]";
	}
    
    
}
