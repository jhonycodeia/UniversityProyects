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
@Table(name = "saludo", schema = "public")
public class Saludo implements java.io.Serializable {
    @NotNull
    private Integer idSaludo;
    @NotNull
    private Idioma idioma;
    @NotNull
    @NotEmpty
    @Size(max = 255)
    private String saludo;

    public Saludo() {
    }

    public Saludo(Integer idSaludo, Idioma idioma, String saludo) {
        this.idSaludo = idSaludo;
        this.idioma = idioma;
        this.saludo = saludo;
    }

    @Id
    @Column(name = "id_saludo", unique = true, nullable = false)
    public Integer getIdSaludo() {
        return this.idSaludo;
    }

    public void setIdSaludo(Integer idSaludo) {
        this.idSaludo = idSaludo;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_idioma")
    public Idioma getIdioma() {
        return this.idioma;
    }

    public void setIdioma(Idioma idioma) {
        this.idioma = idioma;
    }

    @Column(name = "saludo", nullable = false)
    public String getSaludo() {
        return this.saludo;
    }

    public void setSaludo(String saludo) {
        this.saludo = saludo;
    }
}
