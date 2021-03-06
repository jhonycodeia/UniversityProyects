/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilidades;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author salas
 */
public class Comentario implements Serializable{
    private User usuario;
    private Date fecha;
    private String texto;

    public Comentario(User usuario, String texto){
        fecha = new Date();
        this.usuario = usuario;
        this.texto = texto;
    }
    
    public void EditarComentario(String texto){
        this.texto = texto;
        fecha = new Date();
    }
    
    /**
     * @return the usuario
     */
    public User getUsuario() {
        return usuario;
    }

    /**
     * @param usuario the usuario to set
     */
    public void setUsuario(User usuario) {
        this.usuario = usuario;
    }

    /**
     * @return the fecha
     */
    public Date getFecha() {
        return fecha;
    }

    /**
     * @param fecha the fecha to set
     */
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    /**
     * @return the texto
     */
    public String getTexto() {
        return texto;
    }

    /**
     * @param texto the texto to set
     */
    public void setTexto(String texto) {
        this.texto = texto;
    }
}
