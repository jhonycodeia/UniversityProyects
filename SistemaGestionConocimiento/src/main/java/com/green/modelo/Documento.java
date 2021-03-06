package com.green.modelo;

import java.util.Date;

import javax.persistence.*;

import javax.validation.constraints.*;


/**
* @author Zathura Code Generator http://zathuracode.org/
* www.zathuracode.org
*
*/
@Entity
@Table(name = "documento", schema = "public")
public class Documento implements java.io.Serializable {
    //@NotNull
    private Long idDocumento;
    @NotNull
    private Capsula capsula;
    @NotNull
    private TipoDocumento tipoDocumento;
    @NotNull
    @NotEmpty
    @Size(max = 1)
    private String activo;
    private String descripcion;
    @NotNull
    private Date fechaCreacion;
    private Date fechaModificacion;
    @NotNull
    @NotEmpty
    @Size(max = 300)
    private String nombre;
    @NotNull
    @NotEmpty
    @Size(max = 10485760)
    private String ruta;
    @NotNull
    private Long usuCreador;
    private Long usuModificador;
    private String valor;

    public Documento() {
    }

    public Documento(Long idDocumento, String activo, Capsula capsula,
        String descripcion, Date fechaCreacion, Date fechaModificacion,
        String nombre, String ruta, TipoDocumento tipoDocumento,
        Long usuCreador, Long usuModificador, String valor) {
        this.idDocumento = idDocumento;
        this.capsula = capsula;
        this.tipoDocumento = tipoDocumento;
        this.activo = activo;
        this.descripcion = descripcion;
        this.fechaCreacion = fechaCreacion;
        this.fechaModificacion = fechaModificacion;
        this.nombre = nombre;
        this.ruta = ruta;
        this.usuCreador = usuCreador;
        this.usuModificador = usuModificador;
        this.valor = valor;
    }

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id_documento", unique = true, nullable = false)
    public Long getIdDocumento() {
        return this.idDocumento;
    }

    public void setIdDocumento(Long idDocumento) {
        this.idDocumento = idDocumento;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_capsula")
    public Capsula getCapsula() {
        return this.capsula;
    }

    public void setCapsula(Capsula capsula) {
        this.capsula = capsula;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_tipo_documento")
    public TipoDocumento getTipoDocumento() {
        return this.tipoDocumento;
    }

    public void setTipoDocumento(TipoDocumento tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    @Column(name = "activo", nullable = false)
    public String getActivo() {
        return this.activo;
    }

    public void setActivo(String activo) {
        this.activo = activo;
    }

    @Column(name = "descripcion")
    public String getDescripcion() {
        return this.descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
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

    @Column(name = "nombre", nullable = false)
    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Column(name = "ruta", nullable = false)
    public String getRuta() {
        return this.ruta;
    }

    public void setRuta(String ruta) {
        this.ruta = ruta;
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

    @Column(name = "valor")
    public String getValor() {
        return this.valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }
}
