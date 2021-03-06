/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package redsocial;

import utilidades.Experiencia;
import utilidades.User;
import utilidades.Docente;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.geom.RoundRectangle2D;
import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.*;

/**
 *
 * @author PC
 */
public class NuevaExperiencia extends JFrame implements ActionListener,MouseListener,MouseMotionListener {
    JLabel etiSalir,etiMinimizar,etiMaximizar,title;
    JPanel panelBarra;
    Container contenedor;
    
    ArrayList<File> archivos;
    ArrayList<URL> link;
    
    // Variables declaration - do not modify  
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JList<String> listaArchivos;
    private javax.swing.JList<String> listaLink;
    private javax.swing.JTextField txtCurso;
    private javax.swing.JTextArea txtDescripcion;
    private javax.swing.JTextField txtEtiqueta1;
    private javax.swing.JTextField txtEtiqueta2;
    private javax.swing.JTextField txtEtiqueta3;
    private javax.swing.JTextField txtPrograma;
    private javax.swing.JTextField txtFacultad;
    private javax.swing.JTextArea txtTexto;
    private javax.swing.JTextField txtTitulo;
    private JList<Experiencia> jList1;
    private DefaultListModel modeloarchivos,modeloLinks;
    private JFileChooser selecionarArchivo;
    Docente doc;
    
    int x,y;
    
    public NuevaExperiencia(User user,JList jList1){
        this.doc = (Docente)user;
        this.jList1 = jList1;
        
        selecionarArchivo = new JFileChooser();
        archivos = new ArrayList<>();
        link = new ArrayList<>();
        modeloLinks = new DefaultListModel<>();
        modeloarchivos = new DefaultListModel<>();
        
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
        title = new JLabel("Crear Experiencia");
        title.setFont(new Font("Comic Sans MS",0,13));
        title.setForeground(Color.WHITE);
        panelBarra.add(Box.createHorizontalStrut(90));
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
        setSize(430,620);
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);
        Shape forma = new RoundRectangle2D.Double(0,0,this.getBounds().width,this.getBounds().height,27,27);
        setShape(forma);
    }
    
    public void crearVentana(){
      
        jPanel1 = new Panel("/redsocial/Images/fondo.jpg");
        jLabel1 = new javax.swing.JLabel();
        txtTitulo = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtEtiqueta1 = new javax.swing.JTextField();
        txtEtiqueta3 = new javax.swing.JTextField();
        txtEtiqueta2 = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtTexto = new javax.swing.JTextArea();
        jButton1 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtCurso = new javax.swing.JTextField();
        txtPrograma = new javax.swing.JTextField();
        txtFacultad = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        listaArchivos = new javax.swing.JList<>();
        listaArchivos.setModel(modeloarchivos);
        jScrollPane6 = new javax.swing.JScrollPane();
        txtDescripcion = new javax.swing.JTextArea();
        jScrollPane7 = new javax.swing.JScrollPane();
        listaLink = new javax.swing.JList<>();
        listaLink.setModel(modeloLinks);
        jButton3 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
              
        Font font = new Font("Futura Bk BT",1,13);
        
        jLabel1.setText("Título:");
        jLabel1.setForeground(Color.BLACK);
        jLabel1.setFont(font);

        jLabel2.setText("Descripción:");
        jLabel2.setForeground(Color.BLACK);
        jLabel2.setFont(font);

        jLabel3.setText("Etiquetas:");
        jLabel3.setForeground(Color.BLACK);
        jLabel3.setFont(font);

        txtTexto.setColumns(20);
        txtTexto.setRows(5);
        txtTexto.setLineWrap(true);
        
        /*txtTexto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTextoKeyTyped(evt);
            }
        });*/
        
        jScrollPane3.setViewportView(txtTexto);
              
        jButton1.setText("Publicar");
        jButton1.setBackground(Color.BLACK);
        jButton1.setForeground(Color.WHITE);
        jButton1.setFont(font);

        jLabel5.setText("Curso:");
        jLabel5.setForeground(Color.BLACK);
        jLabel5.setFont(font);

        jLabel6.setText("Programa:");
        jLabel6.setForeground(Color.BLACK);
        jLabel6.setFont(font);
        
        jLabel7.setText("Facultad:");
        jLabel7.setForeground(Color.BLACK);
        jLabel7.setFont(font);

        jButton2.setText("Adjuntar");
        jButton2.setBackground(Color.BLACK);
        jButton2.setForeground(Color.WHITE);
        jButton2.setFont(font);

        jScrollPane4.setViewportView(listaArchivos);

        txtDescripcion.setColumns(20);
        txtDescripcion.setRows(5);
        txtDescripcion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtDescripcionKeyTyped(evt);
            }
        });
        jScrollPane6.setViewportView(txtDescripcion);
        jScrollPane6.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);

        jScrollPane7.setViewportView(listaLink);

        jButton3.setText("Links");
        jButton3.setBackground(Color.BLACK);
        jButton3.setForeground(Color.WHITE);
        jButton3.setFont(font);

        jLabel4.setFont(new java.awt.Font("Futura Bk BT", 0, 25));
        jLabel4.setForeground(Color.BLACK);
        jLabel4.setText("CREAR EXPERIENCIA");
        
        javax.swing.GroupLayout layoutjPanel1 = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(layoutjPanel1);
        layoutjPanel1.setHorizontalGroup(
            layoutjPanel1.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layoutjPanel1.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addGap(80, 80, 80))
            .addGroup(layoutjPanel1.createSequentialGroup()
                .addContainerGap()
                .addGroup(layoutjPanel1.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3)
                    .addGroup(layoutjPanel1.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(58, 58, 58)
                        .addComponent(txtTitulo))
                    .addGroup(layoutjPanel1.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane6))
                    .addGroup(layoutjPanel1.createSequentialGroup()
                        .addGroup(layoutjPanel1.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layoutjPanel1.createSequentialGroup()
                                .addComponent(jLabel3)/////////
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 60, Short.MAX_VALUE)
                                .addComponent(txtEtiqueta1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtEtiqueta2, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtEtiqueta3, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layoutjPanel1.createSequentialGroup()
                                .addGroup(layoutjPanel1.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layoutjPanel1.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                    .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                            .addGroup(layoutjPanel1.createSequentialGroup()
                                .addGroup(layoutjPanel1.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel7))
                                .addGap(23, 23, 23)
                                .addGroup(layoutjPanel1.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtCurso, javax.swing.GroupLayout.DEFAULT_SIZE, 168, Short.MAX_VALUE)
                                    .addComponent(txtPrograma)
                                    .addComponent(txtFacultad))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layoutjPanel1.setVerticalGroup(
            layoutjPanel1.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layoutjPanel1.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layoutjPanel1.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layoutjPanel1.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layoutjPanel1.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layoutjPanel1.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layoutjPanel1.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtEtiqueta1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtEtiqueta2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtEtiqueta3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layoutjPanel1.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layoutjPanel1.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layoutjPanel1.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layoutjPanel1.createSequentialGroup()
                        .addGroup(layoutjPanel1.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(txtCurso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layoutjPanel1.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(txtPrograma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layoutjPanel1.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtFacultad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7)))
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(22, Short.MAX_VALUE))
        );
        
        jButton1.addActionListener(this);
        jButton2.addActionListener(this);
        jButton3.addActionListener(this);
        listaArchivos.addMouseListener(this);
        listaLink.addMouseListener(this);
        jPanel1.setBorder(BorderFactory.createEmptyBorder(0,8,0,6));
        contenedor.add(jPanel1,BorderLayout.CENTER);
        dispose();
    } 
    
    String linea="";   
    private void txtDescripcionKeyTyped(java.awt.event.KeyEvent evt) {                                        
        linea += evt.getKeyChar();
        if(linea.length()>35){
            txtDescripcion.append("\n");
            linea = "";
            linea+=evt.getKeyChar();
        }
        
    }                                       
    String lineaArea = "";
    private void txtTextoKeyTyped(java.awt.event.KeyEvent evt) {                                  
        lineaArea += evt.getKeyChar();
        if(lineaArea.length()>45){
            txtTexto.append("\n");
            lineaArea = "";
            lineaArea+=evt.getKeyChar();
        }
    }                                 
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == jButton1){
          String titulo = txtTitulo.getText();
          String descripcion = txtDescripcion.getText();
          String curso = txtCurso.getText();
          String programa = txtPrograma.getText();
          String facultad = txtFacultad.getText();
          String texto = txtTexto.getText();
          String[] etiquetas1 = {txtEtiqueta1.getText(),txtEtiqueta2.getText(),txtEtiqueta3.getText()};
          
          if(!etiquetas1[0].isEmpty()){
            if(!titulo.isEmpty()||!descripcion.isEmpty()
              ||!curso.isEmpty()||!programa.isEmpty()||!facultad.isEmpty()||!texto.isEmpty()){

                ArrayList<String> etiquetas = new ArrayList<>();
                for(String s : etiquetas1){
                    if(!s.isEmpty()) etiquetas.add(s);
                }
                Experiencia newExp = new Experiencia(titulo,descripcion,curso,programa,
                facultad,texto,doc,etiquetas,
                archivos,link);
                doc.AddExperiencia(newExp);
                RedSocial.crearArboles();
                JOptionPane.showMessageDialog(null,"Experiencia agregada con Éxito!");
                
                jList1.setModel(new javax.swing.AbstractListModel<Experiencia>() {
                    ArrayList<Experiencia> exp = doc.getExperiencias();
                    Experiencia[] experiencias = exp.toArray(new Experiencia[exp.size()]);
                    public int getSize() { return experiencias.length; }
                    public Experiencia getElementAt(int i) { return experiencias[i]; }
                });
                jList1.repaint();
                
                txtTitulo.setText("");
                txtDescripcion.setText("");
                txtCurso.setText("");
                txtPrograma.setText("");
                txtFacultad.setText("");
                txtTexto.setText("");
                txtEtiqueta1.setText("");
                txtEtiqueta2.setText("");
                txtEtiqueta3.setText("");

            }else JOptionPane.showMessageDialog(null,"Complete toda la información requerida.");
          }else JOptionPane.showMessageDialog(null,"Ingrese al menos una etiqueta.");
        }
    
        else if(e.getSource()==jButton2)
        {
            int opciones = selecionarArchivo.showSaveDialog(null);
            if(opciones==selecionarArchivo.APPROVE_OPTION)
            {
                try
                {
                 System.out.println("entro");
                 archivos.add(selecionarArchivo.getSelectedFile());
                 String ruta = selecionarArchivo.getSelectedFile().toString();
                 modeloarchivos.addElement(RedSocial.nombre(ruta));   
                }
                catch(Exception a)
                {
                    a.printStackTrace();
                }
               
            }
            
        }
        else if(e.getSource()==jButton3)
        {
           
            try 
            {
                String nuevolink = JOptionPane.showInputDialog(null,"Escriba el link con su respectivo http//");
                if(nuevolink !=null)
                {
                    URL pagina = new URL(nuevolink);
                    link.add(pagina);
                    modeloLinks.addElement(nuevolink);
                }
                
            } catch (Exception ex) 
            {
            }
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
        
        else if(e.getSource()==listaArchivos)
        {
            try 
            {
                int index = listaArchivos.getSelectedIndex();
                archivos.remove(index);
                modeloarchivos.remove(index);
            } 
            catch (Exception ex) 
            {
            }
        }
        else if(e.getSource()==listaLink)
        {
            try
            {
                System.out.println("aqui");
                int index = listaLink.getSelectedIndex();
                if(index != -1)
                {
                    link.remove(index);
                    modeloLinks.remove(index);
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