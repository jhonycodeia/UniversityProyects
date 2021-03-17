package com.co.indra.model;

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
@Table(name = "usuarios", schema = "public")
public class Usuarios implements java.io.Serializable {
    @NotNull
    private Integer idUsuario;
    @NotNull
    @NotEmpty
    @Size(max = 100)
    private String name;
    private Set<RegistroCalculo> registroCalculos = new HashSet<RegistroCalculo>(0);

    public Usuarios() {
    }

    public Usuarios(Integer idUsuario, String name,
        Set<RegistroCalculo> registroCalculos) {
        this.idUsuario = idUsuario;
        this.name = name;
        this.registroCalculos = registroCalculos;
    }

    @Id
    @Column(name = "id_usuario", unique = true, nullable = false)
    public Integer getIdUsuario() {
        return this.idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    @Column(name = "name", nullable = false)
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "usuarios")
    public Set<RegistroCalculo> getRegistroCalculos() {
        return this.registroCalculos;
    }

    public void setRegistroCalculos(Set<RegistroCalculo> registroCalculos) {
        this.registroCalculos = registroCalculos;
    }
}
