package Grafico;

import java.util.ArrayList;

/**
 * Creado por hadexexplade el 01 de febrero del 2016
 */
public class ArbolGeneral<E>
{
    private NodoGeneral<E> raiz;
    private int cantidad;

    public ArbolGeneral()
    {
        this.cantidad=0;
    }

    public Elemento<E> getRaiz()
    {
        return raiz;
    }

    public int getCantidad()
    {
        return cantidad;
    }

    private NodoGeneral<E> crearNodo(E e,NodoGeneral<E> padre)
    {
        return new NodoGeneral<E>(e,padre);
    }

    private NodoGeneral<E> validar(Elemento<E> elemento)
    {
        if(!(elemento instanceof NodoGeneral))
        {
            return null;
        }
        NodoGeneral<E> nodoGeneral = (NodoGeneral<E>)elemento;
        return nodoGeneral.getPadre()==nodoGeneral?null:nodoGeneral;
    }

    public boolean esRaiz(Elemento<E> elemento)
    {
        return elemento==getRaiz();
    }

    public boolean estaVacia()
    {
        return getCantidad()==0;
    }

    public Elemento<E>obtenerPadre(Elemento<E> elemento)
    {
        return validar(elemento).getPadre();
    }

    public int cantidadHijos(Elemento<E> elemento)
    {
        NodoGeneral<E> nodoGeneral=validar(elemento);
        return nodoGeneral.cantHijos();
    }

    public int cantidadNiveles(Elemento<E> elemento)
    {
        if(esRaiz(elemento))
        {
            return 0;
        }
        else {
            return 1+cantidadNiveles(obtenerPadre(elemento));
        }

    }


    public int alto(Elemento<E> elemento)
    {
        int alto=0;
        for (Elemento<E> hijo:obtenerHijos(elemento))
        {
            alto=Math.max(alto,1+alto(hijo));
        }
        return alto;
    }

    public ArrayList<Elemento<E>> obtenerHijos(Elemento<E> elemento)
    {
        NodoGeneral<E> nodoGeneral=validar(elemento);
        return nodoGeneral.hijos();
    }

    public Elemento<E> obtenerElemento(E elemento)
    {
        NodoGeneral<Elemento<E>> nodoGeneral=new NodoGeneral<Elemento<E>>();
        buscar(elemento,getRaiz(),nodoGeneral);
        return nodoGeneral.getElemento();
    }

    private void buscar(E elemento, Elemento<E> raiz, NodoGeneral<Elemento<E>> nodoGeneral)
    {
        if(elemento.equals(raiz.getElemento()))
        {
            nodoGeneral.setElemento(raiz);
        }

        for(Elemento<E> x:obtenerHijos(raiz))
        {
            buscar(elemento,x,nodoGeneral);
        }
    }

    public Elemento<E> insertarRaiz(E info)
    {
        if(!estaVacia())
        {
            return null;
        }
        raiz=crearNodo(info,null);
        cantidad=1;
        return raiz;
    }

    public Elemento<E> insertarHijo(Elemento<E> elemento,E info)
    {
        NodoGeneral<E> nodoGeneral=validar(elemento);

        if(nodoGeneral==null)
        {
            return null;
        }

        NodoGeneral<E> hijo=crearNodo(info, nodoGeneral);
        nodoGeneral.insertarHijo(hijo);
        cantidad++;
        return hijo;
    }

    public Iterable<Elemento<E>> recorridoPreOrden()
    {
        ArrayList<Elemento<E>> pos=new ArrayList<Elemento<E>>();
        if(!estaVacia())
        {
            recorridoPreOrden(getRaiz(),pos);
        }
        return pos;
    }

    private void recorridoPreOrden(Elemento<E> raiz, ArrayList<Elemento<E>> pos)
    {
        pos.add(raiz);
        for(Elemento<E> hijo:obtenerHijos(raiz))
        {
            recorridoPreOrden(hijo,pos);
        }
    }


    public Iterable<Elemento<E>> recorridoInOrden()
    {
        ArrayList<Elemento<E>> pos=new ArrayList<Elemento<E>>();
        if(!estaVacia())
        {
            recorridoInOrden(getRaiz(), pos);
        }
        return pos;
    }

    private void recorridoInOrden(Elemento<E> raiz, ArrayList<Elemento<E>> pos)
    {
        if(cantidadHijos(raiz)==0)
        {
            pos.add(raiz);
        }
        else
        {
            recorridoInOrden(obtenerHijos(raiz).get(0),pos);
            pos.add(raiz);
            for(int i=1;i<cantidadHijos(raiz);i++)
            {
                recorridoInOrden(obtenerHijos(raiz).get(i),pos);
            }

        }

    }


    public Iterable<Elemento<E>> recorridoPosOrden()
    {
        ArrayList<Elemento<E>> pos=new ArrayList<Elemento<E>>();
        if(!estaVacia())
        {
            recorridoPosOrden(getRaiz(), pos);
        }
        return pos;
    }

    private void recorridoPosOrden(Elemento<E> raiz, ArrayList<Elemento<E>> pos)
    {
        for(Elemento<E>hijo:obtenerHijos(raiz))
        {
            recorridoPosOrden(hijo,pos);
        }

        pos.add(raiz);
    }


}
