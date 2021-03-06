/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package redsocial;

/**
 *
 * @author PC
 */
import Estructuras.Grafo;
import utilidades.Experiencia;
import utilidades.User;
import static java.awt.Frame.ICONIFIED;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.RoundRectangle2D;
import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

public class ExperienciaGUI extends JFrame implements ActionListener,MouseListener,MouseMotionListener{
    JLabel etiSalir,etiMinimizar,etiMaximizar,title;
    JPanel panelBarra,panelCentral,panelGeneral,panelInferior,panelSuperior,panelCent1,panelCent2;
    Container contenedor;
    //ventana
    JScrollPane scrollComments;
    JLabel etiTitulo;
    Experiencia exp;
    Grafo graph;
    User user;
    JButton btnAgregarComm,btnCompartir,btnLike;
    JPanel panelComments;
    
    // Variables declaration - do not modify  
    private javax.swing.JButton jButtonLike;
    private javax.swing.JButton jButtonShare;
    private javax.swing.JButton jButtonCom;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabelEtiquetas;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabelCurso;
    private javax.swing.JLabel jLabelFacultad;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    JList jList1,jList2;
    JScrollPane jScrollPane,jScrollPane3,jScrollPane4;
    JLabel jLabel5,jLabel7,jLabel11;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTextArea jTextAreaDes;
    private javax.swing.JTextArea jTextAreaTexto;    
    private javax.swing.JButton jButtonVerPerfil;
       
    private javax.swing.JLabel jLabelTitulo;
    private javax.swing.JPanel jPanelGeneral;
    private javax.swing.JPanel jPanelSup;
    private javax.swing.JPanel jPanelInf;
    private DefaultListModel modeloarchivos,modeloLinks;
    int x,y;
    
    public void datosFile()
    {
        ArrayList<File> aux = exp.getProductosAsociados();
        String datos[] = new String[aux.size()];
        for(int i=0;i<datos.length;i++)
        {
            modeloarchivos.addElement(RedSocial.nombre(aux.get(i).getPath()));
        }
        
    }
    
    public void datosLink()
    {
        ArrayList<URL> aux = exp.getEnlaces();
        String datos[] = new String[aux.size()];
        for(int i=0;i<datos.length;i++)
        {
            modeloLinks.addElement(aux.get(i).getAuthority()+aux.get(i).getFile());
        }
        
    }
    
    public ExperienciaGUI(Experiencia exp,User user, Grafo graph){
        
        this.exp = exp;
        if(user != null) this.user = user;
        else this.user = new User("","","","","");
        this.graph = graph;
        contenedor = getContentPane();
        panelBarra = new JPanel();
        etiSalir = new JLabel();
        etiMinimizar = new JLabel();
        etiMaximizar = new JLabel();//estetica, no hace nada.
        
        modeloLinks = new DefaultListModel<>();
        modeloarchivos = new DefaultListModel<>();
        datosFile();
        datosLink();
        
        contenedor.setLayout(new BorderLayout());                
        panelBarra.setLayout(new FlowLayout(FlowLayout.LEFT));
        
        panelBarra.add(etiSalir);
        panelBarra.add(etiMaximizar);
        panelBarra.add(etiMinimizar);
        title = new JLabel("Experiencia");
        title.setFont(new Font("Comic Sans MS",0,13));
        title.setForeground(Color.WHITE);
        panelBarra.add(Box.createHorizontalStrut(190));
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
        
        crearVentana();
 
        panelBarra.addMouseListener(this);
        panelBarra.addMouseMotionListener(this);
        panelBarra.setBackground(Color.BLACK);

         try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Exception ex) {
            Logger.getLogger(UserGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        SwingUtilities.updateComponentTreeUI(this);
        setUndecorated(true);
        setSize(600,500);
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);
        Shape forma = new RoundRectangle2D.Double(0,0,this.getBounds().width,this.getBounds().height,27,27);
        setShape(forma);
    }
    
    public void crearVentana(){
        
        jPanel1 = new JPanel();
        jPanelGeneral = new Panel("/redsocial/Images/fondo.jpg");
        jPanelSup = new JPanel();
        jPanelInf = new JPanel();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextAreaDes = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextAreaTexto = new javax.swing.JTextArea();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabelCurso = new javax.swing.JLabel();
        jLabelFacultad = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabelEtiquetas = new javax.swing.JLabel();
        jLabelTitulo = new javax.swing.JLabel();
        jButtonLike = new javax.swing.JButton();
        jButtonShare = new javax.swing.JButton();
        jButtonVerPerfil = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();
        scrollComments = new JScrollPane();
        panelComments = new JPanel();
        jList1 = new javax.swing.JList<>();
        jList1.setModel(modeloLinks);
        jScrollPane3 = new javax.swing.JScrollPane();
        jList2 = new javax.swing.JList<>();
        jList2.setModel(modeloarchivos);
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
                
        Font font = new Font("Futura Bk BT",0,13);
        Font font2 = new Font("Futura Bk BT",1,14);
        
        jPanelGeneral.setLayout(new BorderLayout());
        
        jLabelTitulo.setText(exp.getTitulo());
        jLabelTitulo.setFont(new Font("Futura Bk BT",1,32));
        jPanelSup.add(jLabelTitulo);
        
        jLabel1.setText("Información de la Experiencia");
        jLabel1.setFont(font2);

        jLabel2.setText("Descripción:");
        jLabel2.setFont(font2);

        jTextAreaDes.setColumns(20);
        jTextAreaDes.setRows(5);
        jTextAreaDes.append(exp.getDescripcion());
        jTextAreaDes.setEditable(false);
        jScrollPane1.setViewportView(jTextAreaDes);
        jScrollPane1.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane1.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);

        jTextAreaTexto.setColumns(20);
        jTextAreaTexto.setRows(5);
        jTextAreaTexto.setLineWrap(true);
        jTextAreaTexto.append(exp.getTexto());
        jTextAreaTexto.setEditable(false);
        jScrollPane4.setViewportView(jTextAreaTexto);

        jLabel11.setText("Acerca de la Experiencia:");
        jLabel11.setFont(font2);
        
        jLabel5.setText("Curso:");
        jLabel5.setFont(font2);
        
        jLabelCurso.setText(exp.getCurso());
        jLabelCurso.setFont(font);

        jLabel9.setText("Facultad:");
        jLabel9.setFont(font2);
        
        jLabelFacultad.setText(exp.getFacultad());
        jLabelFacultad.setFont(font);
        
        jLabel3.setText("Links:");
        jLabel3.setFont(font2);
        
        jLabel7.setText("Etiquetas:");
        jLabel7.setFont(font2);
        
        ArrayList<String> etiquetas = exp.getEtiquetas();
        String temp = "";
        for(int i = 0; i<etiquetas.size(); i++){
            temp += etiquetas.get(i);
            if(i<etiquetas.size()-1) temp += " ";
        }
        
        jLabelEtiquetas.setText(temp);
        jLabelEtiquetas.setFont(font);
        
        try{
            ImageIcon img = new ImageIcon(getClass().getResource("/redsocial/Images/like_fb.png"));
            ImageIcon like = new ImageIcon(img.getImage().getScaledInstance(20,20,Image.SCALE_SMOOTH));
            jButtonLike.setIcon(like);
            ImageIcon img2 = new ImageIcon(getClass().getResource("/redsocial/Images/share_white.png"));
            ImageIcon share = new ImageIcon(img2.getImage().getScaledInstance(20,20,Image.SCALE_SMOOTH));
            jButtonShare.setIcon(share);
            
        } catch(Exception e){
            System.err.println("Error al abrir la imagen "+e);
        }  
        
        if(user.getUsuario().isEmpty()){
            jButtonLike.setEnabled(false);
            jButtonShare.setEnabled(false);
        }
        
        jButtonLike.setText("Me gusta");
        jButtonLike.setFont(font);
        jButtonLike.setBackground(Color.BLACK);
        jButtonLike.setForeground(Color.WHITE);
        
        if(exp.getLikes().contains(user.getUsuario())) jButtonLike.setBackground(new Color(30,144,255));
        else jButtonLike.setBackground(Color.BLACK);
          
        jButtonShare.setText("Compartir");
        jButtonShare.setFont(font);
        jButtonShare.setBackground(Color.BLACK);
        jButtonShare.setForeground(Color.WHITE);
        
        if(exp.getShares().contains(user.getUsuario())) jButtonShare.setBackground(new Color(30,144,255));
        else jButtonShare.setBackground(Color.BLACK);
        
        jButtonVerPerfil.setText("Ver perfil");
        jButtonVerPerfil.setFont(font);
        jButtonVerPerfil.setBackground(Color.BLACK);
        jButtonVerPerfil.setForeground(Color.WHITE);
        
        
        jScrollPane2.setViewportView(jList1);

        jLabel4.setText("Archivos:");
        jLabel4.setFont(font2);

       
        jScrollPane3.setViewportView(jList2);

        jButtonCom = new JButton("Ver comentarios");
        jButtonCom.setBackground(Color.BLACK);
        jButtonCom.setForeground(Color.WHITE);
        jButtonCom.setFont(font);
        
       javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 540, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 522, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(10, 10, 10)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(60, 60, 60)
                                        .addComponent(jButtonLike)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jButtonShare))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 30, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel11)
                                        .addGap(80, 80, 80))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jLabel5)
                                                    .addComponent(jLabel7))
                                                .addGap(24, 24, 24))
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jLabel9)
                                                .addGap(24, 24, 24)))
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabelFacultad)
                                            .addComponent(jLabelEtiquetas)
                                            .addComponent(jLabelCurso))
                                        .addGap(90, 90, 90))))))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(204, 204, 204)
                .addComponent(jButtonCom)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButtonVerPerfil)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(190, 190, 190))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel5)
                            .addComponent(jLabelCurso))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabelEtiquetas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel9)
                                    .addComponent(jLabelFacultad))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel4)
                        .addGap(10, 10, 10)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(125, 125, 125)
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButtonLike)
                            .addComponent(jButtonShare))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonCom)
                    .addComponent(jButtonVerPerfil))
                .addGap(21, 21, 21))
        );
              
        jButtonLike.addActionListener(this);
        jButtonShare.addActionListener(this);
        jButtonCom.addActionListener(this);
        jButtonVerPerfil.addActionListener(this);
        jList1.addMouseListener(this);
        jList2.addMouseListener(this);
        jPanelInf.add(jButtonCom);

        jPanel1.setOpaque(false);
        jPanelSup.setOpaque(false);
        jPanelInf.setOpaque(false);
        jPanel1.setBorder(BorderFactory.createEmptyBorder(0,0,0,10));
        jPanelGeneral.add(jPanelSup,BorderLayout.NORTH);
        jPanelGeneral.add(jPanel1,BorderLayout.CENTER);
        contenedor.add(jPanelGeneral,BorderLayout.CENTER);
        dispose();
    }
            
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == jButtonCom){
            new ComentariosGUI(exp,user);
        } else if(e.getSource() == jButtonLike){
            if(exp.ActionLike(user)){
                user.addMeGusta(exp);
                JOptionPane.showMessageDialog(null,"Me gusta");
                jButtonLike.setBackground(new Color(30,144,255));
            } else{
                user.removeMeGusta(exp);
                JOptionPane.showMessageDialog(null,"Ya no me gusta");
                jButtonLike.setBackground(Color.BLACK);
            }
        } else if(e.getSource() == jButtonShare){
            if(exp.ActionShare(user.getUsuario())){
                
                ArrayList<Experiencia> experiencies = user.getCompartidas();
                experiencies.add(exp);
                user.setCompartidas(experiencies);
               
                JOptionPane.showMessageDialog(null,"Compartiste esta experiencia!");
                jButtonShare.setBackground(new Color(30,144,255));
            } else{
                ArrayList<Experiencia> experiencies = user.getCompartidas();
                experiencies.remove(exp);
                user.setCompartidas(experiencies);
                
                JOptionPane.showMessageDialog(null,"Ya no compartes esta experiencia.");
                jButtonShare.setBackground(Color.BLACK);
            }
        } else if(e.getSource() == jButtonVerPerfil){
            this.setVisible(false);
            new Perfil(exp.getDocente(), user, graph,this);
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
        else if(e.getSource()==jList1)
        {
            try
            {
                int index = jList1.getSelectedIndex();
                System.out.println(index);
                if(index != -1)
                {
                    RedSocial.openURL(exp.getEnlaces().get(index));
                }
            }catch(Exception ex)
            {
                ex.printStackTrace();
            }
        }
        else if(e.getSource()==jList2)
        {
            try
            {
                int index = jList2.getSelectedIndex();
                if(index != -1)
                {
                    RedSocial.copiar(exp.getProductosAsociados().get(index));
                }
            }catch(Exception ex)
            {
                ex.printStackTrace();
            }
            
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
