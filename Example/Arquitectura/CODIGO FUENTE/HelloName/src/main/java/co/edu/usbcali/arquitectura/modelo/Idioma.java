package co.edu.usbcali.arquitectura.modelo;

import org.hibernate.validator.constraints.*;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

import javax.validation.constraints.*;


/**
* @author Zathura Code Generator http://zathuracode.org
* www.zathuracode.org
*
*/
@Entity
@Table(name = "idioma", schema = "public")
public class Idioma implements java.io.Serializable {
    @NotNull
    private Integer idIdioma;
    @NotNull
    @NotEmpty
    @Size(max = 255)
    private String nombreIdioma;
    private Set<Nombre> nombres = new HashSet<Nombre>(0);
    private Set<Saludo> saludos = new HashSet<Saludo>(0);

    public Idioma() {
    }

    public Idioma(Integer idIdioma, String nombreIdioma, Set<Nombre> nombres,
        Set<Saludo> saludos) {
        this.idIdioma = idIdioma;
        this.nombreIdioma = nombreIdioma;
        this.nombres = nombres;
        this.saludos = saludos;
    }

    @Id
    @Column(name = "id_idioma", unique = true, nullable = false)
    public Integer getIdIdioma() {
        return this.idIdioma;
    }

    public void setIdIdioma(Integer idIdioma) {
        this.idIdioma = idIdioma;
    }

    @Column(name = "nombre_idioma", nullable = false)
    public String getNombreIdioma() {
        return this.nombreIdioma;
    }

    public void setNombreIdioma(String nombreIdioma) {
        this.nombreIdioma = nombreIdioma;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "idioma")
    public Set<Nombre> getNombres() {
        return this.nombres;
    }

    public void setNombres(Set<Nombre> nombres) {
        this.nombres = nombres;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "idioma")
    public Set<Saludo> getSaludos() {
        return this.saludos;
    }

    public void setSaludos(Set<Saludo> saludos) {
        this.saludos = saludos;
    }
}
