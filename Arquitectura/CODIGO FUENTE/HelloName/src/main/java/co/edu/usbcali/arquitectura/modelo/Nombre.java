package co.edu.usbcali.arquitectura.modelo;

import org.hibernate.validator.constraints.*;

import java.util.Date;

import javax.persistence.*;

import javax.validation.constraints.*;


/**
* @author Zathura Code Generator http://zathuracode.org
* www.zathuracode.org
*
*/
@Entity
@Table(name = "nombre", schema = "public")
public class Nombre implements java.io.Serializable {
    @NotNull
    private Integer idNombre;
    @NotNull
    private Idioma idioma;
    @NotNull
    @NotEmpty
    @Size(max = 255)
    private String nombre;

    public Nombre() {
    }

    public Nombre(Integer idNombre, Idioma idioma, String nombre) {
        this.idNombre = idNombre;
        this.idioma = idioma;
        this.nombre = nombre;
    }

    @Id
    @Column(name = "id_nombre", unique = true, nullable = false)
    public Integer getIdNombre() {
        return this.idNombre;
    }

    public void setIdNombre(Integer idNombre) {
        this.idNombre = idNombre;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_idioma")
    public Idioma getIdioma() {
        return this.idioma;
    }

    public void setIdioma(Idioma idioma) {
        this.idioma = idioma;
    }

    @Column(name = "nombre", nullable = false)
    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
