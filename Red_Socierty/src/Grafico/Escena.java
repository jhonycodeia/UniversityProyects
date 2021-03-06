package Grafico;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Creado por hadexexplade el 01 de febrero del 2016
 */
public class Escena extends JPanel
{
    private ArbolGeneral<String> arbolGeneral;
    private PanelArbol<String> vista;
    
    public Escena(ArrayList<String> red, ArrayList<String> nodos)
    {
        this.arbolGeneral = new ArbolGeneral<String>();
                
        String etiquetas = "Etiquetas:  ";
        for(int j = 0; j<nodos.size(); j++){
            etiquetas += ((j+1)+". "+nodos.get(j))+"  ";
        }
        
        Elemento<String> elemento = arbolGeneral.insertarRaiz(red.get(0));
        String elem = red.get(0);
        red.remove(0);
        crearArbol(elem, elemento, red, new ArrayList());
        
        this.vista = new PanelArbol<String>(arbolGeneral,nodos);
        this.setLayout(new BorderLayout());
        
        JPanel jPanel = new JPanel();
        Font font = new Font("Futura Md BT",0,14);
        JLabel etiInfo = new JLabel(etiquetas);
        etiInfo.setFont(font);
        etiInfo.setForeground(Color.BLACK);
        jPanel.add(etiInfo);
        add(vista,BorderLayout.CENTER);
        add(jPanel,BorderLayout.SOUTH);

    }
    
    public ArrayList crearArbol(String padre, Elemento<String> nodo_padre, ArrayList<String> red, ArrayList hijos_visitados){
        
        for(int i = 0; i<red.size(); i++){           
            String temp = red.get(i).split("-")[1];
            if(padre.equals(temp)){
                String hijo = red.get(i).split("-")[0];
                Elemento<String> elemento = new Elemento<String>() {
                    @Override
                    public String getElemento() {
                        return "";
                    }
                };
                if(!nodo_padre.getElemento().equals(hijo))
                    elemento = arbolGeneral.insertarHijo(nodo_padre,hijo);
                if(!hijos_visitados.contains(padre)){
                    hijos_visitados.add(hijo);
                    crearArbol(hijo, elemento, red, hijos_visitados);
                }
            }
        }
        return hijos_visitados;
        
    }
    
}


//        ArrayList<String> red = new ArrayList();
//        red.add("cris");
//        red.add("jhonny-cris");
//        red.add("camilo-jhonny");
//        red.add("jhonny-jhonny");
//                
//        red.add("segovia-cris");
//        red.add("segovia-camilo");
//        red.add("cris-camilo");
//        red.add("jhonny-camilo");
//        
//        red.add("cris-jhonny");
//        red.add("camilo-cris");
//        red.add("york-segovia");
//        red.add("camilo-york");
        
//        ArrayList<String> nodos = new ArrayList();
//        nodos.add("cris");
//        nodos.add("camilo");
//        nodos.add("jhonny");
//        nodos.add("segovia");
//        nodos.add("york");