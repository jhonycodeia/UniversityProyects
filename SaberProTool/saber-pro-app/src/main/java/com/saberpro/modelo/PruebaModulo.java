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
@Table(name = "prueba_modulo", schema = "public")
public class PruebaModulo implements java.io.Serializable {
    //@NotNull
    private Long idPruebaModulo;
    @NotNull(message="modulo no valido")
    private Modulo modulo;
    @NotNull(message="prueba no valido")
    private Prueba prueba;
    @NotNull(message="activo no valido")
    @NotEmpty
    @Size(max = 1)
    private String activo;
    @NotNull(message="fechacreacion no valido")
    private Date fechaCreacion;
    private Date fechaModificacion;
    @NotNull(message="numeropreguntas no valido")
    private Long numeroPreguntas;
    @NotNull(message="usucreador no valido")
    private Long usuCreador;
    private Long usuModificador;

    public PruebaModulo() {
    }

    public PruebaModulo(Long idPruebaModulo, String activo, Date fechaCreacion,
        Date fechaModificacion, Modulo modulo, Long numeroPreguntas,
        Prueba prueba, Long usuCreador, Long usuModificador) {
        this.idPruebaModulo = idPruebaModulo;
        this.modulo = modulo;
        this.prueba = prueba;
        this.activo = activo;
        this.fechaCreacion = fechaCreacion;
        this.fechaModificacion = fechaModificacion;
        this.numeroPreguntas = numeroPreguntas;
        this.usuCreador = usuCreador;
        this.usuModificador = usuModificador;
    }

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id_prueba_modulo", unique = true, nullable = false)
    public Long getIdPruebaModulo() {
        return this.idPruebaModulo;
    }

    public void setIdPruebaModulo(Long idPruebaModulo) {
        this.idPruebaModulo = idPruebaModulo;
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
    @JoinColumn(name = "id_prueba")
    public Prueba getPrueba() {
        return this.prueba;
    }

    public void setPrueba(Prueba prueba) {
        this.prueba = prueba;
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

    @Column(name = "numero_preguntas", nullable = false)
    public Long getNumeroPreguntas() {
        return this.numeroPreguntas;
    }

    public void setNumeroPreguntas(Long numeroPreguntas) {
        this.numeroPreguntas = numeroPreguntas;
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
		return "PruebaModulo [idPruebaModulo=" + idPruebaModulo + ", activo=" + activo + ", fechaCreacion="
				+ fechaCreacion + ", fechaModificacion=" + fechaModificacion + ", numeroPreguntas=" + numeroPreguntas
				+ ", usuCreador=" + usuCreador + ", usuModificador=" + usuModificador + "]";
	}
    
    
}
