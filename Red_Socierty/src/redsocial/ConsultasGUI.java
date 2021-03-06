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
import utilidades.Experiencia;
import static java.awt.Frame.ICONIFIED;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.RoundRectangle2D;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

public class ConsultasGUI extends JFrame implements ActionListener,MouseListener,MouseMotionListener{
    JLabel etiSalir,etiMinimizar,etiMaximizar,title;
    JPanel panelBarra;
    Container contenedor;
    //ventana
    RedSocial red_social;
    RedSocialGUI redSocialGui;
    // Variables declaration             
    private javax.swing.JButton jButtonSearch;
    private javax.swing.JButton jButtonVer;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JList<Experiencia> jList1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField2;
    
    int x,y;
    
    public ConsultasGUI(RedSocial red,RedSocialGUI redSocialGui){
        this.redSocialGui = redSocialGui;
        red_social = red;
        contenedor = getContentPane();
        panelBarra = new JPanel();
        etiSalir = new JLabel();
        etiMinimizar = new JLabel();
        etiMaximizar = new JLabel();//estetica, no hace nada.
        
        contenedor.setLayout(new BorderLayout());                
        panelBarra.setLayout(new FlowLayout(FlowLayout.LEFT));
        
        panelBarra.add(etiSalir);
        panelBarra.add(etiMaximizar);
        panelBarra.add(etiMinimizar);
        title = new JLabel("Consultas");
        title.setFont(new Font("Comic Sans MS",0,13));
        title.setForeground(Color.WHITE);
        panelBarra.add(Box.createHorizontalStrut(160));
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
        
        crearRegistro();
 
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
        setSize(540,460);
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);
        Shape forma = new RoundRectangle2D.Double(0,0,this.getBounds().width,this.getBounds().height,27,27);
        setShape(forma);
    }
    
    public void crearRegistro(){
        
        jPanel1 = new Panel("/redsocial/Images/fondo.jpg");
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox<>();
        jButtonSearch = new javax.swing.JButton();
        jButtonVer = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();

        jLabel3.setText("Consultas");
        //Exotc350 Bd BT
        jLabel3.setFont(new Font("Lucida Handwriting",0,35));

        jLabel4.setText("Palabra Clave:");
        jLabel4.setFont(new Font("Futura Bk BT",Font.PLAIN,13));

        jLabel5.setText("Buscar por:");
        jLabel5.setFont(new Font("Futura Bk BT",Font.PLAIN,13));
        
        try{
            ImageIcon img = new ImageIcon(getClass().getResource("/redsocial/Images/ic_buscar.png"));
            ImageIcon iconSearch = new ImageIcon(img.getImage().getScaledInstance(20,20,Image.SCALE_SMOOTH));
            jButtonSearch.setIcon(iconSearch);
            
        } catch(Exception e){
            System.err.println("Error al abrir la imagen "+e);
        }  
        
        jButtonSearch.setBackground(Color.BLACK);
        jButtonSearch.setForeground(Color.WHITE);
        
        jButtonVer.setText("Ver experiencia");
        jButtonVer.setBackground(Color.BLACK);
        jButtonVer.setForeground(Color.WHITE);
                        
        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]
            { "Título","Programa","Docente","Fecha","Facultad","Curso","Etiqueta" }));

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);
        JViewport jView = new JViewport();
        JLabel jLabelScroll = new JLabel("Información Detallada",JLabel.CENTER);
        jLabelScroll.setFont(new Font("Futura Bk BT",1,13));
        jView.setView(jLabelScroll);
        jScrollPane1.setColumnHeader(jView);
        
        jScrollPane2.setViewportView(jList1);
        JViewport jView2 = new JViewport();
        JLabel jLabelScroll2 = new JLabel("Resultados de Búsqueda",JLabel.CENTER);
        jLabelScroll2.setFont(new Font("Futura Bk BT",1,13));
        jView2.setView(jLabelScroll2);
        jScrollPane2.setColumnHeader(jView2);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(8, 8, 8)
                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(19, 19, 19))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(170, 170, 170)
                .addComponent(jLabel3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(205, 205, 205)
                .addComponent(jButtonVer)
                .addGap(0, 0, Short.MAX_VALUE))               
                
        );
        
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonSearch))
                .addGap(15, 15, 15)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jButtonVer)
                .addGap(10, 10, 10))
                
        );
        
        jList1.addMouseListener(this);
        jButtonSearch.addActionListener(this);
        jButtonVer.addActionListener(this);
        jPanel1.setBorder(BorderFactory.createEmptyBorder(0,5,0,0));
        contenedor.add(jPanel1,BorderLayout.CENTER);
        dispose();
        
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
       if(e.getSource() == jButtonVer){
           try{
                Experiencia experiencia = jList1.getSelectedValue();
                ExperienciaGUI egui = new ExperienciaGUI(experiencia,red_social.getUserActive(),red_social.getAllFollowers());
                           
            }catch(Exception ex){
                JOptionPane.showMessageDialog(this,"Escoja un experiencia antes de poder visualizar su información");
            }
           
       } else if(e.getSource() == jButtonSearch){
            Object dato = jTextField2.getText();
            if(!((String)dato).equals("")){
                
                int option = jComboBox2.getSelectedIndex();
                
                jList1.setModel(new javax.swing.AbstractListModel<Experiencia>() {
                    ArrayList<Experiencia> exp = red_social.buscar(option,dato);
                    Experiencia[] experiencias = exp.toArray(new Experiencia[exp.size()]);
                    public int getSize() { return experiencias.length; }
                    public Experiencia getElementAt(int i) { return experiencias[i]; }
                
                });
                
                try{
                    jList1.setSelectedIndex(0);
                    Experiencia experiencia = jList1.getSelectedValue();
                    jTextArea1.setText(experiencia.getInfoExperiencia());
                }catch(Exception ex){}
                
           }else JOptionPane.showMessageDialog(null,"El campo palabra clave esta vacio.");
            
       }
        
    }
    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getSource()==etiSalir){
            redSocialGui.setVisible(true);
            this.dispose();
        } else if(e.getSource()==etiMinimizar){
            this.setExtendedState(ICONIFIED);//minimiza la ventana
        } else if(e.getSource() == jList1){
            try{
                Experiencia experiencia = jList1.getSelectedValue();
                jTextArea1.setText(experiencia.getInfoExperiencia());
                           
            }catch(Exception ex){
                JOptionPane.showMessageDialog(this,"Escoja un experiencia antes de poder visualizar su información");
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
    
    /*
    public static void main(String[] args) {
        RedSocial red = new RedSocial();
        ConsultasGUI u = new ConsultasGUI(red);
    }
   */
}
