package Grafico;

import java.util.ArrayList;

/**
 * Creado por hadexexplade el 01 de febrero del 2016
 */
public class NodoGeneral<E> implements Elemento<E>
{
    private E elemento;
    private NodoGeneral<E> padre;
    private ArrayList<NodoGeneral<E>> hijos;

    public NodoGeneral()
    {

    }
    public NodoGeneral(E elemento,NodoGeneral<E>padre)
    {
        this.elemento=elemento;
        this.padre=padre;
        this.hijos=new ArrayList<NodoGeneral<E>>();
    }

    public E getElemento()
    {
        return elemento;
    }

    public void setElemento(E elemento)
    {
        this.elemento = elemento;
    }

    public NodoGeneral<E> getPadre()
    {
        return padre;
    }

    public void setPadre(NodoGeneral<E> padre)
    {
        this.padre = padre;
    }

    protected NodoGeneral<E> getHijo(int posicion)
    {
        return hijos.get(posicion);
    }

    protected void setHijos(int posicion,E elemento)
    {
        hijos.get(posicion).setElemento(elemento);
    }

    public void insertarHijo(NodoGeneral<E> elemento)
    {
        hijos.add(elemento);

    }

    public int cantHijos()
    {
      return hijos.size();
    }

    public ArrayList<Elemento<E>> hijos()
    {
        return new ArrayList<Elemento<E>>(hijos);
    }

    public String toString()
    {
        return getElemento().toString();
    }



}
