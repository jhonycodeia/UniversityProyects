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
public class ArbolBinario {
    Nodo raiz;
    public ArbolBinario(){
        raiz = null;
    }   
    
    public boolean esVacio(){
        return raiz==null;
    }
    
    public void insertar(Object dato, Object id){
        Nodo nuevo = new Nodo(dato, id);
        if(esVacio())
            raiz = nuevo;
        else{
            Nodo aux = raiz;
            while(aux!=null){
                if(aux.getDato().toString().trim().toLowerCase().compareToIgnoreCase(dato.toString().trim().toLowerCase())>0){
                    if(aux.getDerecha()==null){
                        aux.setDerecha(nuevo);
                        aux = null;
                    }else
                        aux = aux.getDerecha();
                }else if(aux.getDato().toString().trim().toLowerCase().compareToIgnoreCase(dato.toString().trim().toLowerCase())<0){
                    if(aux.getIzquierda()==null){
                        aux.setIzquierda(nuevo);
                        aux = null;
                    }else
                        aux = aux.getIzquierda();
                }else{
                    aux.agregarId(id);
                    aux = null;
                }
            }       
        }
    }
    
    private Nodo buscarNodo(Nodo nodo, Object elem) {
        if (nodo.getDato().equals(elem)) {
            return nodo;
        } else {
            if(nodo.getDato().toString().compareTo(elem.toString())<0){
                if (nodo.getIzquierda() != null) {                 
                    Nodo aux = buscarNodo(nodo.getIzquierda(), elem);
                    if (aux != null) 
                       return aux;
                    
                }
            }else
                if (nodo.getDerecha() != null) {                    
                    Nodo aux = buscarNodo(nodo.getDerecha(), elem);
                    if (aux != null) 
                       return aux;
                    
            }
            return null;
        }
    }
        
    public ArrayList buscar(Object elem){
        ArrayList resultado = new ArrayList();
        if(!esVacio()){
            Nodo nodo = buscarNodo(raiz, elem);
            if(nodo!=null)
                resultado = nodo.getId();
        }return resultado;
    }
    
     public ArrayList buscar2(Object elem){
        ArrayList resultado = new ArrayList();
        if(!esVacio()){
            Nodo nodo = buscar2(raiz, elem);
            if(nodo!=null)
                resultado = nodo.getId();
        }
        return resultado;
    }
    
    public Nodo buscar2(Nodo nodo, Object elem){
        if(nodo!=null){
            if(!nodo.getDato().toString().trim().toLowerCase().equals(elem.toString().trim().toLowerCase())){
                if(nodo.getDato().toString().trim().toLowerCase().compareTo(elem.toString().trim().toLowerCase())<0)
                    return buscar2(nodo.getIzquierda(),elem);
                else return buscar2(nodo.getDerecha(),elem);
            } else return nodo;
        }
        return nodo;
    }
    
    public void mostrarPreOrden(){
        mostrarPreOrden(raiz);
    }
    
    public void mostrarPreOrden(Nodo nodo){
        if(nodo!=null){
            System.out.print(nodo.getDato() +" ");
            System.out.println(nodo.getId());
            mostrarPreOrden(nodo.getIzquierda());
            mostrarPreOrden(nodo.getDerecha());
        }  
    }
    
}
