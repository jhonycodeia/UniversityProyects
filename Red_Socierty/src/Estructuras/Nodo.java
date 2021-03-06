/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Estructuras;

import java.util.ArrayList;

/**
 *
 * @author Lina
 */
public class Nodo {
    private Object dato;
    private ArrayList id = new ArrayList();
    private Nodo Derecha;
    private Nodo Izquierda;

    public Nodo(Object dato, Object id){
        this.dato = dato;
        this.id.add(id);
        Derecha = null;
        Izquierda = null;
    }
    public void agregarId(Object id){
        this.id.add(id);
    }
    
    /**
     * @return the dato
     */
    public Object getDato() {
        return dato;
    }

    /**
     * @param dato the dato to set
     */
    public void setDato(Object dato) {
        this.dato = dato;
    }

    /**
     * @return the id
     */
    public ArrayList<Integer> getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(ArrayList<Integer> id) {
        this.id = id;
    }

    /**
     * @return the Derecha
     */
    public Nodo getDerecha() {
        return Derecha;
    }

    /**
     * @param Derecha the Derecha to set
     */
    public void setDerecha(Nodo Derecha) {
        this.Derecha = Derecha;
    }

    /**
     * @return the Izquierda
     */
    public Nodo getIzquierda() {
        return Izquierda;
    }

    /**
     * @param Izquierda the Izquierda to set
     */
    public void setIzquierda(Nodo Izquierda) {
        this.Izquierda = Izquierda;
    }
}
