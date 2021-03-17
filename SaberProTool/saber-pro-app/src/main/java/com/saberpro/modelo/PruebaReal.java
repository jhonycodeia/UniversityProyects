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
@Table(name = "prueba_real", schema = "public")
public class PruebaReal implements java.io.Serializable {
    //@NotNull
    private Long idPruebaReal;
    @NotNull(message="activo no valido")
    @NotEmpty
    @Size(max = 1)
    private String activo;
    @NotNull(message="fecha no valido")
    private Date fecha;
    @NotNull(message="fecha creacion no valido")
    private Date fechaCreacion;
    private Date fechaModificacion;
    @NotNull(message="usucreador no valido")
    private Long usuCreador;
    private Long usuModificador;
    private Set<Matricula> matriculas = new HashSet<Matricula>(0);

    public PruebaReal() {
    }

    public PruebaReal(Long idPruebaReal, String activo, Date fecha,
        Date fechaCreacion, Date fechaModificacion, Set<Matricula> matriculas,
        Long usuCreador, Long usuModificador) {
        this.idPruebaReal = idPruebaReal;
        this.activo = activo;
        this.fecha = fecha;
        this.fechaCreacion = fechaCreacion;
        this.fechaModificacion = fechaModificacion;
        this.usuCreador = usuCreador;
        this.usuModificador = usuModificador;
        this.matriculas = matriculas;
    }

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id_prueba_real", unique = true, nullable = false)
    public Long getIdPruebaReal() {
        return this.idPruebaReal;
    }

    public void setIdPruebaReal(Long idPruebaReal) {
        this.idPruebaReal = idPruebaReal;
    }

    @Column(name = "activo", nullable = false)
    public String getActivo() {
        return this.activo;
    }

    public void setActivo(String activo) {
        this.activo = activo;
    }

    @Column(name = "fecha", nullable = false)
    public Date getFecha() {
        return this.fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
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

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "pruebaReal")
    public Set<Matricula> getMatriculas() {
        return this.matriculas;
    }

    public void setMatriculas(Set<Matricula> matriculas) {
        this.matriculas = matriculas;
    }

	@Override
	public String toString() {
		return "PruebaReal [idPruebaReal=" + idPruebaReal + ", activo=" + activo + ", fecha=" + fecha
				+ ", fechaCreacion=" + fechaCreacion + ", fechaModificacion=" + fechaModificacion + ", usuCreador="
				+ usuCreador + ", usuModificador=" + usuModificador + "]";
	}
    
    
}
