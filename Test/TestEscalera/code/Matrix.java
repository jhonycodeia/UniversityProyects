/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package escalera;


import java.util.Stack;

/**
 *
 * @author veevart
 */
public class Matrix {
    
    private Trampa[][] matrix = new Trampa[5][5];
    

    public Matrix(Stack<Trampa> list) {
        
        
        Trampa aux = list.pop();
        
        for (int i = 1; i <=25; i++) {
            
            if(aux.getUbicacion()==i){
                set(i, aux);
                if(!list.isEmpty()){
                    aux = list.pop();
                }
             }
            else{
                set(i,new Trampa());
            }
        }
    }
    
    public int validar(int num){
        if(num>=25){
            System.out.println("Fin");            
        }
        else{
           Trampa trampa = get(num);
       
            if(trampa.isTiene()){
                if(num<trampa.getDestino()){
                    System.out.println("Jugador sube al cuadro "+trampa.getDestino());
                }
                else{
                    System.out.println("Jugador baja al cuadro "+trampa.getDestino());
                }
            return trampa.getDestino();
            } 
        }        
        return num;
    }
    
    public Trampa get(int num){
        return matrix[getFila(num)][getColumna(num)];
    }
    
    public void set(int num,Trampa trampa){
       matrix[getFila(num)][getColumna(num)] = trampa; 
    }
    
    private int getColumna(int num){
        int columna = (num-1)%5;
        if(getFila(num)%2!=0){
            columna = 4-columna;
        }
        return columna;
    }
    
    private int getFila(int num){
        return 4-((num-1)/5);
    }
    
    
        
}
