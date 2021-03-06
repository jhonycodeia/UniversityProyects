/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Estructuras;

/**
 *
 * @author PC
 */

import java.util.ArrayList;

public class Grafo {
    private ArrayList<ArrayList> relaciones;
    private ArrayList<String> pares_ordenados;
    private ArrayList<String> nodos;
    private ArrayList<String> red;
    
    public Grafo(){
        relaciones = new ArrayList();
        pares_ordenados = new ArrayList();
        nodos = new ArrayList();
        red = new ArrayList();
    }
        
    public boolean addLista(ArrayList r,String nodo){
        if(!relaciones.contains(r)){
            relaciones.add(r);
            nodos.add(nodo);
            return true;
        }else return false;
    }
        
    public ArrayList nodosAdyacentes(int position){
        if(position>=0 && position<relaciones.size())
            return relaciones.get(position);
        else return new ArrayList();
    }
        
    public int cantNodosAdyacentes(int position){
        if(position>=0 && position<relaciones.size())
            return relaciones.get(position).size();
        else return new ArrayList().size();
    }
       
    /**
     * Retorna todos los seguidores, sin repeticiones. El último de la lista
     * representa el usuario que posee tal lista de seguidores.
     * @param nodo
     * @param visitados
     * @return 
     */
    
    public ArrayList buscar(String nodo, ArrayList visitados){
        visitados.add(nodo);
        boolean encontro = false;
        for(int i = 0; i<relaciones.size() && !encontro; i++){
            ArrayList r = relaciones.get(i);
            if(nodo.equals(nodos.get(i))){
                encontro = true;
                for(int j = 0; j<r.size(); j++){                  
                    if(!visitados.contains(r.get(j))){
                        buscar(r.get(j).toString(),visitados);
                    }
                }
            }
        }
        return visitados;
        
    }   
        
    public ArrayList camino(String origen, String destino, ArrayList visitados){
        boolean encontro = false;
        for(int i = 0; i<relaciones.size() && !encontro; i++){
            ArrayList r = relaciones.get(i);
            if(origen.equals(nodos.get(i))){
                encontro = true;
                int find = 0;
                for(int j = 0; j<r.size() && !visitados.contains(destino); j++){    
                    if(!visitados.contains(r.get(j))){
                        if(!visitados.contains(origen))
                            visitados.add(origen);
                        if(!r.get(j).equals(destino)){
                            camino(r.get(j).toString(),destino,visitados);
                        } else{
                            visitados.add(destino);
                        }                           
                    }else{
                        find++;
                    }
                    if(find == r.size()-1){
                        String aux = (String) visitados.get(0);
                        visitados.removeAll(visitados);
                        visitados.add(aux);
                    }
                }
            }
        }
        return visitados;
        
    }
    
    public ArrayList<ArrayList> reestructurarGrafo(){
        ArrayList<ArrayList> rel_siguiendo = new ArrayList();
        ArrayList red = buscarRelaciones();
        for(int i = 0; i<red.size(); i++){
            String aux = red.get(i).toString();
            String relacion = aux.substring(1,aux.length()-1);
            String[] partes_relacion = relacion.split(",");
            ArrayList nuevaRelacion = new ArrayList();
            nuevaRelacion.add(partes_relacion[1]);
            for(int j = i+1; j<red.size(); j++){
                if(red.get(j).toString().contains(partes_relacion[0]+",")){
                    String temp = red.get(j).toString().split(",")[1];
                    String item = temp.substring(0,temp.length()-1);
                    nuevaRelacion.add(item);
                    red.remove(j);
                }
            }
            nuevaRelacion.add(partes_relacion[0]);
            rel_siguiendo.add(nuevaRelacion);
        }
        return rel_siguiendo;
    }
    
    public ArrayList caminoSeguidos(String origen, String destino, ArrayList visitados,
            ArrayList<ArrayList> relaciones){
        boolean encontro = false;
        for(int i = 0; i<relaciones.size() && !encontro; i++){
            ArrayList r = relaciones.get(i);
            if(origen.equals(r.get(r.size()-1)) && !visitados.contains(r.get(r.size()-1))){
                encontro = true;
                if(r.contains(destino)){
                    visitados.add(origen);
                    visitados.add(destino);
                }
                int find = 0;
                for(int j = 0; j<r.size()-1 && !visitados.contains(destino); j++){    
                    if(!visitados.contains(r.get(j))){
                        if(!visitados.contains(origen)){
                            visitados.add(origen);
                        }
                        if(!r.get(j).equals(destino)){
                            caminoSeguidos(r.get(j).toString(),destino,
                                    visitados,relaciones);
                        } else visitados.add(destino);
                    }else find++;
                    if(find == r.size()-2 && !visitados.get(visitados.size()-1).equals(destino)){
                        String a = (String) visitados.get(0);
                        visitados.removeAll(visitados);
                        visitados.add(a);
                    }
                }
            }
        }
        return visitados;
        
    }
   
    public ArrayList buscarCamino(String origen, String destino){
        ArrayList<ArrayList> red_grafos = reestructurarGrafo();
        ArrayList<String> camino = caminoSeguidos(origen,destino,new ArrayList(),red_grafos);
        return camino;
    }
    
    public ArrayList getAllNodos(){
        return buscar(getNodos().get(0), new ArrayList());
    }
   
    /**
     * Retorna toda la red de seguidores, con repetición, más clara.
     * @param nodo
     * @return 
     */
    
    public Object[] buscarRed(String nodo){
        red = new ArrayList();
        Object[] obj = new Object[2];
        obj[0] = buscarRed(nodo, new ArrayList());
        obj[1] = red;
        return obj;
    }
    
    public ArrayList buscarRed(String nodo, ArrayList visitados){
        visitados.add(nodo);
        boolean encontro = false;
        for(int i = 0; i<relaciones.size() && !encontro; i++){
            ArrayList r = relaciones.get(i);
            if(nodo.equals(nodos.get(i))){
                encontro = true;
                if(red.isEmpty()) red.add(nodo);
                for(int j = 0; j<r.size(); j++){
                    red.add(r.get(j).toString()+"-"+nodo);
                    pares_ordenados.add("("+r.get(j).toString()+","+nodo+")");
                    if(!visitados.contains(r.get(j))){     
                        buscarRed(r.get(j).toString(),visitados);
                    }
                }
            }
        }
        return visitados;
        
    }
        
    public ArrayList buscarRelaciones(){
        ArrayList<String> rel = new ArrayList();
        for(int i = 0; i<nodos.size(); i++){
            ArrayList r = relaciones.get(i);
            for(int idx = 0; idx<r.size(); idx++){
                rel.add("("+r.get(idx).toString()+","+nodos.get(i)+")");
            }
        }
        return rel;
    }
               
    public ArrayList getRed(){
        return red;
    }
    
    public ArrayList<ArrayList> getRelaciones() {
        return relaciones;
    }

    public ArrayList<String> getNodos() {
        return nodos;
    }
     
}