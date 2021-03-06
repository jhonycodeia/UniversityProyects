/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package redsocial;

import utilidades.Experiencia;
import utilidades.Comentario;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.geom.RoundRectangle2D;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.*;
import utilidades.*;

/**
 *
 * @author PC
 */
public class ComentariosGUI extends JFrame implements ActionListener,MouseListener,MouseMotionListener{
    JLabel etiSalir,etiMinimizar,etiMaximizar,title;
    JPanel panelBarra;
    Container contenedor;
    
   // Variables declaration - do not modify                     
    private javax.swing.JButton jButtonCom;
    private javax.swing.JButton jButtonEdi;
    private javax.swing.JButton jButtonBor;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JPanel jPanelComments;
    
    Experiencia exp;
    User user;
    
    int x,y;
    
    public ComentariosGUI(Experiencia exp,User user){
        this.exp = exp;
        this.user = user;
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
        title = new JLabel("Comentarios");
        title.setFont(new Font("Comic Sans MS",0,13));
        title.setForeground(Color.WHITE);
        panelBarra.add(Box.createHorizontalStrut(100));
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
        setSize(440,330);
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);
        Shape forma = new RoundRectangle2D.Double(0,0,this.getBounds().width,this.getBounds().height,27,27);
        setShape(forma);
    }
    
    public void crearVentana(){
        
        jPanel1 = new JPanel();
        jPanelComments = new JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jButtonCom = new javax.swing.JButton();
        jButtonEdi = new javax.swing.JButton();
        jButtonBor = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        
        jPanelComments.setBackground(new Color(42,73,107));
        jPanel1.setBackground(new Color(42,73,107));
        jPanelComments.setLayout(new BoxLayout(jPanelComments,BoxLayout.PAGE_AXIS));
        jScrollPane3.setViewportView(jPanelComments);
        jScrollPane3.setBorder(BorderFactory.createEmptyBorder(4,8,4,8));
        
        Font font = new Font("Futura Bk BT",0,13);
        
        jLabel1.setText("Agregar Comentario:");
        jLabel1.setFont(new Font("Futura Bk BT",0,15));
        jLabel1.setForeground(Color.WHITE);
        
        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane2.setViewportView(jTextArea1);
        jScrollPane2.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
        
        jButtonCom.setText("Comentar");
        jButtonCom.setBackground(Color.BLACK);
        jButtonCom.setForeground(Color.WHITE);
        jButtonCom.setFont(font);
        
        try{
            ImageIcon img = new ImageIcon(getClass().getResource("/redsocial/Images/ic_edit.png"));
            ImageIcon edit = new ImageIcon(img.getImage().getScaledInstance(20,20,Image.SCALE_SMOOTH));
            jButtonEdi.setIcon(edit);
            ImageIcon img2 = new ImageIcon(getClass().getResource("/redsocial/Images/ic_delete.png"));
            ImageIcon delete = new ImageIcon(img2.getImage().getScaledInstance(20,20,Image.SCALE_SMOOTH));
            jButtonBor.setIcon(delete);
            
        } catch(Exception e){
            System.err.println("Error al abrir la imagen "+e);
        }  
        
        if(user.getNombre().isEmpty()){
            jButtonEdi.setEnabled(false);
            jButtonBor.setEnabled(false);
            jButtonCom.setEnabled(false);
        }
        
        jButtonEdi.setText("Editar");
        jButtonEdi.setBackground(Color.BLACK);
        jButtonEdi.setForeground(Color.WHITE);
        jButtonEdi.setFont(font);

        jButtonBor.setText("Borrar");
        jButtonBor.setBackground(Color.BLACK);
        jButtonBor.setForeground(Color.WHITE);
        jButtonBor.setFont(font);
        
        ArrayList<Comentario> comentarios = exp.getComentarios();
        for(int i = 0; i<comentarios.size(); i++){
            Comentario c = comentarios.get(i);
            DateFormat formato2 = DateFormat.getDateInstance();
            String date = formato2.format(c.getFecha());
            jPanelComments.add(addComment(c.getTexto(),c.getUsuario(),date));    
        }
        
        
        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonCom, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonEdi)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonBor)))
                .addContainerGap())
            .addComponent(jScrollPane3)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 189, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButtonEdi)
                        .addComponent(jButtonBor)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonCom, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );  
        
        jButtonBor.addActionListener(this);
        jButtonCom.addActionListener(this);
        jScrollPane3.setOpaque(false);
        jPanel1.setBorder(BorderFactory.createEmptyBorder(7,7,7,7));
        contenedor.add(jPanel1,BorderLayout.CENTER);
        dispose();

    }
      
    public JPanel addComment(String comm,User user,String date){
        JPanel panel,panelSup;
        JScrollPane scroll;
        JTextArea comment;    
        JLabel etiUser,etiFecha;
        panel = new JPanel(new BorderLayout());
        panelSup = new JPanel();
        etiUser = new JLabel("Comment by: "+user.getUsuario());
        etiFecha = new JLabel("Fecha: "+date);
        etiUser.setForeground(Color.WHITE);
        etiFecha.setForeground(Color.WHITE);
        etiUser.setFont(new Font("Futura Bk BT",0,15));
        etiFecha.setFont(new Font("Futura Bk BT",0,15));
        panelSup.add(etiUser);
        panelSup.add(etiFecha);
        comment = new JTextArea(comm,4,10);
        if(this.user.getUsuario().equals(user.getUsuario())) comment.setEditable(true);
        else comment.setEditable(false);
        scroll = new JScrollPane(comment);
        comment.setBorder(BorderFactory.createEmptyBorder(2,4,2,4));   
        panel.add(panelSup,BorderLayout.NORTH);
        panel.add(scroll,BorderLayout.CENTER);
        panel.setBorder(BorderFactory.createEmptyBorder(10,4,10,4));
        panel.setOpaque(false);
        panelSup.setOpaque(false);
        this.user.addComentario();
        return panel;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == jButtonCom){
            String comment = jTextArea1.getText();
            if(!comment.isEmpty()){
                Date fechaActual = new Date();
                DateFormat formato2 = DateFormat.getDateInstance();
                String date = formato2.format(fechaActual);
                jPanelComments.add(addComment(comment,user,date));
               // jPanelComments.setPreferredSize(new Dimension(200,jPanelComments.getPreferredSize().height));
                jScrollPane3.setViewportView(jPanelComments);
                Comentario comentario = new Comentario(user,comment);
                exp.AddComentario(comentario);
            }else JOptionPane.showMessageDialog(null,"Comentarios sin texto no son válidos.");
            
        } else if(e.getSource() == jButtonBor){
            if(exp.BorrarComentario(user)){
                jPanelComments.removeAll();    
                ArrayList<Comentario> comentarios = exp.getComentarios();
                for(int i = 0; i<comentarios.size(); i++){
                    Comentario c = comentarios.get(i);
                    DateFormat formato2 = DateFormat.getDateInstance();
                    String date = formato2.format(c.getFecha());
                    jPanelComments.add(addComment(c.getTexto(),c.getUsuario(),date));         
                }
                jScrollPane3.setViewportView(jPanelComments);
                JOptionPane.showMessageDialog(null,"Comentario borrado con éxito");
            }else JOptionPane.showMessageDialog(null,"Acción imposible de realizar");
        }
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
    public void mouseMoved(MouseEvent e) {}
  
}
