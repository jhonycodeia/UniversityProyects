/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package escalera;

import java.util.Stack;


public class Escalera {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Stack<Trampa> list = new Stack<>();
        
        list.add(new Trampa(true, 24,16));
        list.add(new Trampa(true, 22,20));
        list.add(new Trampa(true, 19, 8));
        list.add(new Trampa(true, 14, 4));
        list.add(new Trampa(true, 10,12));
        list.add(new Trampa(true,  9,18));
        list.add(new Trampa(true,  6,17));
        list.add(new Trampa(true,  3,11));
        
        Matrix matrix = new  Matrix(list);
        
        game(0,(int) (Math.random() * 6) + 1, matrix);
        
    }
    
    public static String game(int num,int dado,Matrix matrix){
        if(num>=25){
            return "";
        }
        else{
            System.out.println("Dado arrojado "+dado);
            
            num = num + dado;
            
            System.out.println("Jugador avanza "+num);
            
            num = matrix.validar(num);
            
            return game(num,(int) (Math.random() * 6) + 1, matrix);
        }
    }
    
}
