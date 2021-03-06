package Grafico;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import javax.swing.JPanel;

/**
 * Creado por hadexexplade el 01 de febrero del 2016
 */
public class PanelArbol<E> extends JPanel
{
    private int radio = 20;
    private int espacioVertical = 60;
    private ArbolGeneral<E> arbolGeneral;
    private HashMap<Elemento<E>,Point> coordenadas;
    private ArrayList<String> nodos;
    private ArrayList<Color> colores;

    public PanelArbol(ArbolGeneral<E> arbolGeneral, ArrayList<String> nodos){
        this.arbolGeneral = arbolGeneral;
        this.coordenadas = new HashMap<Elemento<E>, Point>();
        this.nodos = nodos;
        this.colores = generarColores(nodos.size());
        setBackground(Color.white);
    }

    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        if(!arbolGeneral.estaVacia())
        {
            dibujar(g,arbolGeneral.getRaiz(),(getWidth()/2),100,(getWidth()/6)+20);
        }
    }

    private void dibujar(Graphics g, Elemento<E> raiz, int x, int y, int espacioH)
    {
        g.setColor(color(raiz.getElemento()+""));
        g.fillOval(x-radio,y-radio,2*radio,2*radio);
        Font font = new Font("Futura Md BT",0,14);
        g.setFont(font); 
        g.setColor(Color.BLACK);
        g.drawString(rotulo(raiz.getElemento()+""), x - 4, y + 4);
        ArrayList<Elemento<E>> hijos = arbolGeneral.obtenerHijos(raiz);
        coordenadas.put(raiz,new Point(x,y));
        for(Elemento<E> hijo:hijos)
        {
            Point punto = coordenadas.get(arbolGeneral.obtenerPadre(hijo));
            dibujarLinea(g,x-espacioH,y+espacioVertical,punto.x,punto.y);
            dibujar(g,hijo,x-espacioH,y+espacioVertical,espacioH/hijos.size());
            x+=espacioH;
        }
    }

    private void dibujarLinea(Graphics g, int x1, int y1, int x2, int y2)
    {
        double d = Math.sqrt(espacioVertical*espacioVertical+(x2-x1)*(x2-x1));
        int xx1=(int)(x1-radio*(x1-x2)/d);
        int yy1=(int)(y1-radio*(y1-y2)/d);
        int xx2=(int)(x2+radio*(x1-x2)/d);
        int yy2=(int)(y2+radio*(y1-y2)/d);

        //new Color(30,144,255)
        g.setColor(Color.BLACK);
        g.drawLine(xx1,yy1,xx2,yy2);

    }
    
    private Color color(String rotulo){
        for(int i = 0; i<nodos.size(); i++){
            if(rotulo.equals(nodos.get(i))){
                return colores.get(i);
            }
        }
        return Color.BLACK;
    }
    
    public String rotulo(String rotulo){
        for(int i = 0; i<nodos.size(); i++){
            if(rotulo.equals(nodos.get(i)))
                return (i+1)+"";
        }
        return "#";
    }
    
    public ArrayList generarColores(int n){
        ArrayList<Color> colores = new ArrayList();
        Random rand = new Random();
        for(int i=0; i<n; i++){
            int R = (int)(Math.random()*256);
            int G = (int)(Math.random()*256);
            int B = (int)(Math.random()*256);
            Color color = new Color(R, G, B);             
            float r = (float)(rand.nextFloat() / 2f + 0.5);
            float g = (float)(rand.nextFloat() / 2f + 0.5);
            float b = (float)(rand.nextFloat() / 2f + 0.5);
            Color randomColor = new Color(r, g, b);
            if(i%2==0) colores.add(color);
            else colores.add(randomColor);
        }
        return colores;
        
    }

}
