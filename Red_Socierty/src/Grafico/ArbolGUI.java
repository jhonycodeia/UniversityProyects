/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Grafico;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.geom.RoundRectangle2D;
import javax.swing.*;

/**
 *
 * @author PC
 */

public class ArbolGUI extends JFrame implements ActionListener,MouseListener,MouseMotionListener{
    JLabel etiSalir,etiMinimizar,etiMaximizar,title;
    JPanel panelBarra,panelGeneral,jPanelScene;
    Container contenedor;
    
    int x,y;
    
    public ArbolGUI(JPanel scene){
        jPanelScene = scene;
        contenedor = getContentPane();
        panelBarra = new JPanel();
        contenedor.setLayout(new BorderLayout());
        etiSalir = new JLabel();
        etiMinimizar = new JLabel();
        etiMaximizar = new JLabel();//estetica, no hace nada.
                
        panelBarra.setLayout(new FlowLayout(FlowLayout.LEFT));
        panelBarra.add(etiSalir);
        panelBarra.add(etiMaximizar);
        panelBarra.add(etiMinimizar);
        title = new JLabel("Red de Seguidores");
        title.setFont(new Font("Comic Sans MS",0,13));
        title.setForeground(Color.WHITE);
        panelBarra.add(Box.createHorizontalStrut(270));
        panelBarra.add(title);
                
        ImageIcon salir = new ImageIcon(new ImageIcon(getClass().getResource("/redsocial/Images/btn_rojo.png")).getImage().getScaledInstance(13,13,Image.SCALE_SMOOTH));
        etiSalir.setIcon(salir);
        ImageIcon minimizar = new ImageIcon(new ImageIcon(getClass().getResource("/redsocial/Images/btn_verde.png")).getImage().getScaledInstance(13,13,Image.SCALE_SMOOTH));
        etiMinimizar.setIcon(minimizar);
        ImageIcon maximizar = new ImageIcon(new ImageIcon(getClass().getResource("/redsocial/Images/btn_amarillo.png")).getImage().getScaledInstance(13,13,Image.SCALE_SMOOTH));
        etiMinimizar.setIcon(minimizar);        
        etiMaximizar.setIcon(maximizar);
        
        etiSalir.addMouseListener(this);
        etiMinimizar.addMouseListener(this);
        contenedor.add(panelBarra,BorderLayout.NORTH);
 
        panelBarra.addMouseListener(this);
        panelBarra.addMouseMotionListener(this);
        panelBarra.setBackground(Color.BLACK);
        
        crearVentana();
        
        setUndecorated(true);
        setSize(800,600);
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);
        Shape forma = new RoundRectangle2D.Double(0,0,this.getBounds().width,this.getBounds().height,27,27);
        setShape(forma);
    }
    
    public void crearVentana(){
       //"/redsocial/Images/fondo.jpg"
       panelGeneral = new JPanel();
       panelGeneral.setLayout(new BorderLayout(10,10));
       panelGeneral.setBackground(new Color(42,73,107));
       JPanel panelSup = new JPanel(new BorderLayout());
             
       JLabel etiTitulo = new JLabel("RED DE SEGUIDORES",JLabel.CENTER);
       JLabel etiInfo = new JLabel("En el siguiente diagrama se visualiza la red de seguidores"
               + " de la aplicación.",JLabel.CENTER);
       etiTitulo.setForeground(Color.WHITE);
       etiInfo.setForeground(Color.WHITE);
       Font font = new Font("Futura Bk BT",1,30);
       etiTitulo.setFont(font);
       
       panelGeneral.setBorder(BorderFactory.createEmptyBorder(15, 40, 40, 40));
       
       panelSup.add(etiTitulo,BorderLayout.CENTER);
       panelSup.add(etiInfo,BorderLayout.SOUTH);   
       panelSup.setOpaque(false);
       
       panelGeneral.add(panelSup,BorderLayout.NORTH);
       panelGeneral.add(jPanelScene,BorderLayout.CENTER);
              
       contenedor.add(panelGeneral,BorderLayout.CENTER);
    }
    
    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getSource()==etiSalir){
            this.dispose(); //Libera los recursos utilizados por el Frame
            setVisible(false); //Solamente deja de visualizar la ventana en la pantalla
        } else if(e.getSource()==etiMinimizar){
            this.setExtendedState(ICONIFIED);//minimiza la ventana
        }
    }
    @Override
    public void mouseEntered(MouseEvent e){
        if(e.getSource()==etiSalir){
            ImageIcon iconSalir = new ImageIcon(getClass().getResource("/redsocial/Images/btn_rojo_press.png"));
            ImageIcon salir = new ImageIcon(iconSalir.getImage().getScaledInstance(13,13,Image.SCALE_SMOOTH));
            etiSalir.setIcon(salir);
        } else if(e.getSource()==etiMinimizar){
            ImageIcon iconMinimizar = new ImageIcon(getClass().getResource("/redsocial/Images/btn_verde_press.png"));
            ImageIcon minimizar = new ImageIcon(iconMinimizar.getImage().getScaledInstance(13,13,Image.SCALE_SMOOTH));
            etiMinimizar.setIcon(minimizar);    
        }
    }
    @Override
    public void mouseExited(MouseEvent e){
        if(e.getSource()==etiSalir){
            ImageIcon salir = new ImageIcon(new ImageIcon(getClass().getResource("/redsocial/Images/btn_rojo.png")).getImage().getScaledInstance(13,13,Image.SCALE_SMOOTH));
            etiSalir.setIcon(salir);
        } else if(e.getSource()==etiMinimizar){
            ImageIcon minimizar = new ImageIcon(new ImageIcon(getClass().getResource("/redsocial/Images/btn_verde.png")).getImage().getScaledInstance(13,13,Image.SCALE_SMOOTH));
            etiMinimizar.setIcon(minimizar);    
        }
    }
    @Override
    public void mousePressed(MouseEvent e){
        x = e.getX();
        y = e.getY();
    }
    @Override
    public void mouseDragged(MouseEvent e) {
        Point p = MouseInfo.getPointerInfo().getLocation();
        this.setLocation(p.x-x,p.y-y);
    } 
    
    @Override
    public void mouseReleased(MouseEvent e) {}
    @Override
    public void actionPerformed(ActionEvent e) {}
    @Override
    public void mouseMoved(MouseEvent e) {}

}
