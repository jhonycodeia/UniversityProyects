package Grafico;

import java.awt.Color;
import java.util.ArrayList;
import javax.swing.JPanel;
import javax.swing.border.AbstractBorder;

public class ArbolGrafico
{
    ArrayList<String> red;
    ArrayList<String> nodos;
    
    public ArbolGrafico(ArrayList<String> red, ArrayList<String> nodos){
        this.red = red;
        this.nodos = nodos;
        generarArbol();
    }
    
     public void generarArbol(){
        
        AbstractBorder brdr = new TextBubbleBorder(Color.WHITE,2,16,16);
        
        JPanel jPanel = new Escena(red,nodos);
        jPanel.setBorder(brdr);
        jPanel.setBackground(Color.WHITE);
        
        ArbolGUI a = new ArbolGUI(jPanel);        

    }
    
//    public static void main(String[] args)
//    {
//        AbstractBorder brdr = new TextBubbleBorder(Color.WHITE,2,16,16);
//        
//        JPanel jPanel = new Escena(red,nodos);
//        jPanel.setBorder(brdr);
//        jPanel.setBackground(Color.WHITE);
//        ArbolGUI a = new ArbolGUI(jPanel);        
//
//    }
}
