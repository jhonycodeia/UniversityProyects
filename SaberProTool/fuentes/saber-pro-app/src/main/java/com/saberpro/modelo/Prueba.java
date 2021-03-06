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
@Table(name = "prueba", schema = "public")
public class Prueba implements java.io.Serializable {
    //@NotNull
    private Long idPrueba;
    @NotNull(message="tipoPrueba no valido")
    private TipoPrueba tipoPrueba;
    @NotNull(message="activo no valido")
    @NotEmpty
    @Size(max = 1)
    private String activo;
    @NotNull(message="fechacreacion no valido")    
    private Date fechaCreacion; 
    private Date fechaFinal; 
    private Date fechaInicial;
    private Date fechaModificacion;
    private Long tiempo;
    @NotNull(message="usucreador no valido")
    private Long usuCreador;
    private Long usuModificador;
    private Set<PruebaModulo> pruebaModulos = new HashSet<PruebaModulo>(0);
    private Set<PruebaProgramaUsuario> pruebaProgramaUsuarios = new HashSet<PruebaProgramaUsuario>(0);

    public Prueba() {
    }

    public Prueba(Long idPrueba, String activo, Date fechaCreacion,
        Date fechaFinal, Date fechaInicial, Date fechaModificacion,
        Set<PruebaModulo> pruebaModulos,
        Set<PruebaProgramaUsuario> pruebaProgramaUsuarios, Long tiempo,
        TipoPrueba tipoPrueba, Long usuCreador, Long usuModificador) {
        this.idPrueba = idPrueba;
        this.tipoPrueba = tipoPrueba;
        this.activo = activo;
        this.fechaCreacion = fechaCreacion;
        this.fechaFinal = fechaFinal;
        this.fechaInicial = fechaInicial;
        this.fechaModificacion = fechaModificacion;
        this.tiempo = tiempo;
        this.usuCreador = usuCreador;
        this.usuModificador = usuModificador;
        this.pruebaModulos = pruebaModulos;
        this.pruebaProgramaUsuarios = pruebaProgramaUsuarios;
    }

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id_prueba", unique = true, nullable = false)
    public Long getIdPrueba() {
        return this.idPrueba;
    }

    public void setIdPrueba(Long idPrueba) {
        this.idPrueba = idPrueba;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_tipo_prueba")
    public TipoPrueba getTipoPrueba() {
        return this.tipoPrueba;
    }

    public void setTipoPrueba(TipoPrueba tipoPrueba) {
        this.tipoPrueba = tipoPrueba;
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

    @Column(name = "fecha_final")
    public Date getFechaFinal() {
        return this.fechaFinal;
    }

    public void setFechaFinal(Date fechaFinal) {
        this.fechaFinal = fechaFinal;
    }

    @Column(name = "fecha_inicial")
    public Date getFechaInicial() {
        return this.fechaInicial;
    }

    public void setFechaInicial(Date fechaInicial) {
        this.fechaInicial = fechaInicial;
    }

    @Column(name = "fecha_modificacion")
    public Date getFechaModificacion() {
        return this.fechaModificacion;
    }

    public void setFechaModificacion(Date fechaModificacion) {
        this.fechaModificacion = fechaModificacion;
    }

    @Column(name = "tiempo")
    public Long getTiempo() {
        return this.tiempo;
    }

    public void setTiempo(Long tiempo) {
        this.tiempo = tiempo;
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

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "prueba")
    public Set<PruebaModulo> getPruebaModulos() {
        return this.pruebaModulos;
    }

    public void setPruebaModulos(Set<PruebaModulo> pruebaModulos) {
        this.pruebaModulos = pruebaModulos;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "prueba")
    public Set<PruebaProgramaUsuario> getPruebaProgramaUsuarios() {
        return this.pruebaProgramaUsuarios;
    }

    public void setPruebaProgramaUsuarios(
        Set<PruebaProgramaUsuario> pruebaProgramaUsuarios) {
        this.pruebaProgramaUsuarios = pruebaProgramaUsuarios;
    }

	@Override
	public String toString() {
		return "Prueba [idPrueba=" + idPrueba + ", activo=" + activo + ", fechaCreacion=" + fechaCreacion
				+ ", fechaFinal=" + fechaFinal + ", fechaInicial=" + fechaInicial + ", fechaModificacion="
				+ fechaModificacion + ", tiempo=" + tiempo + ", usuCreador=" + usuCreador + ", usuModificador="
				+ usuModificador + "]";
	}
    
    
}
