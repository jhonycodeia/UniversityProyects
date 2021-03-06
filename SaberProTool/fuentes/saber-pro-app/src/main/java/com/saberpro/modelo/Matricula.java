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
@Table(name = "matricula", schema = "public")
public class Matricula implements java.io.Serializable {
    //@NotNull
    private Long idMatricula;
    @NotNull(message="pruebareal no valido")
    private PruebaReal pruebaReal;
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
    private Set<ResultadoReal> resultadoReals = new HashSet<ResultadoReal>(0);

    public Matricula() {
    }

    public Matricula(Long idMatricula, String activo, Date fechaCreacion,
        Date fechaModificacion, PruebaReal pruebaReal,
        Set<ResultadoReal> resultadoReals, Long usuCreador,
        Long usuModificador, Usuario usuario) {
        this.idMatricula = idMatricula;
        this.pruebaReal = pruebaReal;
        this.usuario = usuario;
        this.activo = activo;
        this.fechaCreacion = fechaCreacion;
        this.fechaModificacion = fechaModificacion;
        this.usuCreador = usuCreador;
        this.usuModificador = usuModificador;
        this.resultadoReals = resultadoReals;
    }

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id_matricula", unique = true, nullable = false)
    public Long getIdMatricula() {
        return this.idMatricula;
    }

    public void setIdMatricula(Long idMatricula) {
        this.idMatricula = idMatricula;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_prueba_real")
    public PruebaReal getPruebaReal() {
        return this.pruebaReal;
    }

    public void setPruebaReal(PruebaReal pruebaReal) {
        this.pruebaReal = pruebaReal;
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

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "matricula")
    public Set<ResultadoReal> getResultadoReals() {
        return this.resultadoReals;
    }

    public void setResultadoReals(Set<ResultadoReal> resultadoReals) {
        this.resultadoReals = resultadoReals;
    }

	@Override
	public String toString() {
		return "Matricula [idMatricula=" + idMatricula + ", activo=" + activo + ", fechaCreacion=" + fechaCreacion
				+ ", fechaModificacion=" + fechaModificacion + ", usuCreador=" + usuCreador + ", usuModificador="
				+ usuModificador + "]";
	}
    
    
}
