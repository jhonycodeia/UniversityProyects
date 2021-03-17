package com.co.indra.model;

import java.util.Date;

import javax.persistence.*;

import javax.validation.constraints.*;


/**
* @author Zathura Code Generator http://zathuracode.org/
* www.zathuracode.org
*
*/
@Entity
@Table(name = "registro_calculo", schema = "public")
public class RegistroCalculo implements java.io.Serializable {
   
    private Integer idResultado;
    @NotNull
    private Usuarios usuarios;
    @NotNull
    private Date fechaEjecucion;
    @NotNull
    private Integer resultado;

    public RegistroCalculo() {
    }

    public RegistroCalculo(Integer idResultado, Date fechaEjecucion,
        Integer resultado, Usuarios usuarios) {
        this.idResultado = idResultado;
        this.usuarios = usuarios;
        this.fechaEjecucion = fechaEjecucion;
        this.resultado = resultado;
    }

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id_resultado", unique = true, nullable = false)
    public Integer getIdResultado() {
        return this.idResultado;
    }

    public void setIdResultado(Integer idResultado) {
        this.idResultado = idResultado;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_usuario")
    public Usuarios getUsuarios() {
        return this.usuarios;
    }

    public void setUsuarios(Usuarios usuarios) {
        this.usuarios = usuarios;
    }

    @Column(name = "fecha_ejecucion", nullable = false)
    public Date getFechaEjecucion() {
        return this.fechaEjecucion;
    }

    public void setFechaEjecucion(Date fechaEjecucion) {
        this.fechaEjecucion = fechaEjecucion;
    }

    @Column(name = "resultado", nullable = false)
    public Integer getResultado() {
        return this.resultado;
    }

    public void setResultado(Integer resultado) {
        this.resultado = resultado;
    }
}
