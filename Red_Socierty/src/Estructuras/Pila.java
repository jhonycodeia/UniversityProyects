/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Estructuras;


/**
 *
 * @author Lina
 */
public class Pila {
    NodoPila ultimo;
    
    public Pila(){
        ultimo = null;
    }
    
    public void agregar(Object dato, int valor){
        NodoPila nuevo = new NodoPila(dato,valor);
        if(esVacia())
            ultimo = nuevo;
        else{
            NodoPila aux = ultimo;
            if(aux.getValor()<valor){
                nuevo.setAnterior(aux);
                ultimo = nuevo;
                return;
            }
            while(aux.getAnterior()!=null){
                if(aux.getAnterior().getValor()<valor){
                    nuevo.setAnterior(aux.getAnterior());
                    aux.setAnterior(nuevo);
                    return;
                }
                aux = aux.getAnterior();
            }
            aux.setAnterior(nuevo);
        }
    }
    
    public void subirNivel(Object dato){
        NodoPila aux = buscar(dato);
        if(aux!=null){
            aux.setValor(aux.getValor()+1);
        }
    }
    
    public boolean contiene(Object dato){
        return buscar(dato)!=null;
    }
    
    private NodoPila buscar(Object dato){
        if(!esVacia()){
            NodoPila aux = ultimo;
            while(aux.getAnterior()!=null){
                if(aux.getDato()==dato)
                    return aux;
            }
            if(aux.getDato()==dato)
                    return aux;
        }
        return null;
    }

    public Object sacar(){
        if(esVacia())
            return null;
        NodoPila aux = ultimo;        
        ultimo = ultimo.getAnterior();
        return aux.getDato();
    }
    
    
    public int tamano(){
        int cont=0;
        if(!esVacia()){
            NodoPila aux = ultimo;
            cont++;
            while(aux.getAnterior()!=null){
                aux = aux.getAnterior();
                cont++;
            }
        }
        return cont;
    }
    
    public boolean esVacia(){
        return ultimo==null;
    }
}
