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
@Table(name = "resultado_real", schema = "public")
public class ResultadoReal implements java.io.Serializable {
    //@NotNull
    private Long idResultadoReal;
    @NotNull(message="matricula no valido")
    private Matricula matricula;
    @NotNull(message="modulo no valido")
    private Modulo modulo;
    @NotNull(message="activo no valido")
    @NotEmpty
    @Size(max = 1)
    private String activo;
    @NotNull(message="fechacreacion no valido")
    private Date fechaCreacion;
    private Date fechaModificacion;
    private Long percentilGrupo;
    private Long percentilNacional;
    @NotNull(message="usucreador no valido")
    private Long usuCreador;
    private Long usuModificador;

    public ResultadoReal() {
    }

    public ResultadoReal(Long idResultadoReal, String activo,
        Date fechaCreacion, Date fechaModificacion, Matricula matricula,
        Modulo modulo, Long percentilGrupo, Long percentilNacional,
        Long usuCreador, Long usuModificador) {
        this.idResultadoReal = idResultadoReal;
        this.matricula = matricula;
        this.modulo = modulo;
        this.activo = activo;
        this.fechaCreacion = fechaCreacion;
        this.fechaModificacion = fechaModificacion;
        this.percentilGrupo = percentilGrupo;
        this.percentilNacional = percentilNacional;
        this.usuCreador = usuCreador;
        this.usuModificador = usuModificador;
    }

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id_resultado_real", unique = true, nullable = false)
    public Long getIdResultadoReal() {
        return this.idResultadoReal;
    }

    public void setIdResultadoReal(Long idResultadoReal) {
        this.idResultadoReal = idResultadoReal;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_matricula")
    public Matricula getMatricula() {
        return this.matricula;
    }

    public void setMatricula(Matricula matricula) {
        this.matricula = matricula;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_modulo")
    public Modulo getModulo() {
        return this.modulo;
    }

    public void setModulo(Modulo modulo) {
        this.modulo = modulo;
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

    @Column(name = "percentil_grupo")
    public Long getPercentilGrupo() {
        return this.percentilGrupo;
    }

    public void setPercentilGrupo(Long percentilGrupo) {
        this.percentilGrupo = percentilGrupo;
    }

    @Column(name = "percentil_nacional")
    public Long getPercentilNacional() {
        return this.percentilNacional;
    }

    public void setPercentilNacional(Long percentilNacional) {
        this.percentilNacional = percentilNacional;
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
		return "ResultadoReal [idResultadoReal=" + idResultadoReal + ", activo=" + activo + ", fechaCreacion="
				+ fechaCreacion + ", fechaModificacion=" + fechaModificacion + ", percentilGrupo=" + percentilGrupo
				+ ", percentilNacional=" + percentilNacional + ", usuCreador=" + usuCreador + ", usuModificador="
				+ usuModificador + "]";
	}
    
    
}
