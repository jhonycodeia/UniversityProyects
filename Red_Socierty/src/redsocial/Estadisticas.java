/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package redsocial;

import com.mxrck.autocompleter.TextAutoCompleter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.geom.RoundRectangle2D;
import java.util.ArrayList;
import javax.swing.*;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import utilidades.Docente;
import utilidades.Experiencia;
import utilidades.User;

/**
 *
 * @author PC
 */
public class Estadisticas extends JFrame implements ActionListener,MouseListener,MouseMotionListener{
    JLabel etiSalir,etiMinimizar,etiMaximizar,title;
    JPanel panelBarra;
    Container contenedor;
    
     // Variables declaration - do not modify                     
    private javax.swing.JTextField buscarDocentes;
    private javax.swing.JLabel etiqueta;
    private javax.swing.JCheckBox graficahorizontal;
    private javax.swing.JCheckBox graficar3D;
    private javax.swing.JButton jButton1;
    private javax.swing.JPanel jPanelGrafica;
    private javax.swing.JPanel jPaneldiagrama;
    private javax.swing.JPanel jPanelmegusta;
    private javax.swing.JRadioButton megusta;
    private javax.swing.JRadioButton usuario;
    private javax.swing.JRadioButton comentarios;
    private javax.swing.JComboBox<String> opciones;
    private javax.swing.JRadioButton seguidores;
    
    ButtonGroup radioGroup;
    RedSocial red_social;
    RedSocialGUI redSocialGui;
    int x,y;
        
    public Estadisticas(RedSocial red, RedSocialGUI redSocialGui){
        red_social  = red;
        this.redSocialGui = redSocialGui;
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
        title = new JLabel("Estadísticas");
        title.setFont(new Font("Comic Sans MS",0,13));
        title.setForeground(Color.WHITE);
        panelBarra.add(Box.createHorizontalStrut(250));
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
        item();
        
        
        
        setUndecorated(true);
        setSize(690,350);
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);
        Shape forma = new RoundRectangle2D.Double(0,0,this.getBounds().width,this.getBounds().height,27,27);
        setShape(forma);
    }
    
    public void crearVentana(){
        jPaneldiagrama = new javax.swing.JPanel();
        jPanelmegusta = new javax.swing.JPanel();
        opciones = new javax.swing.JComboBox<>();
        buscarDocentes = new javax.swing.JTextField();
        etiqueta = new javax.swing.JLabel();
        jPanelGrafica = new javax.swing.JPanel();
        megusta = new javax.swing.JRadioButton();
        seguidores = new javax.swing.JRadioButton();
        usuario = new javax.swing.JRadioButton();
        comentarios = new javax.swing.JRadioButton();
        jButton1 = new javax.swing.JButton();
        graficar3D = new javax.swing.JCheckBox();
        graficahorizontal = new javax.swing.JCheckBox();
        radioGroup = new ButtonGroup();
        
        jPaneldiagrama.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        javax.swing.GroupLayout jPaneldiagramaLayout = new javax.swing.GroupLayout(jPaneldiagrama);
        jPaneldiagrama.setLayout(jPaneldiagramaLayout);
        jPaneldiagramaLayout.setHorizontalGroup(
            jPaneldiagramaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 398, Short.MAX_VALUE)
        );
        jPaneldiagramaLayout.setVerticalGroup(
            jPaneldiagramaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanelmegusta.setBorder(javax.swing.BorderFactory.createTitledBorder("Me Gusta"));

        opciones.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "General", "Docentes" }));
        opciones.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                opcionesItemStateChanged(evt);
            }
        });

        etiqueta.setText("Usuario:");

        javax.swing.GroupLayout jPanelmegustaLayout = new javax.swing.GroupLayout(jPanelmegusta);
        jPanelmegusta.setLayout(jPanelmegustaLayout);
        jPanelmegustaLayout.setHorizontalGroup(
            jPanelmegustaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelmegustaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelmegustaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(opciones, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanelmegustaLayout.createSequentialGroup()
                        .addComponent(etiqueta)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(buscarDocentes, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanelmegustaLayout.setVerticalGroup(
            jPanelmegustaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelmegustaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(opciones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanelmegustaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(etiqueta)
                    .addComponent(buscarDocentes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanelGrafica.setBorder(javax.swing.BorderFactory.createTitledBorder("Graficar"));

        megusta.setText("Me gusta");
        seguidores.setText("Seguidores");
        

        usuario.setText("Usuario participativo");
        
        comentarios.setText("Comentarios");
        
        radioGroup.add(megusta);
        radioGroup.add(seguidores);
        radioGroup.add(comentarios); 
        radioGroup.add(usuario);
        
        jButton1.setText("Graficar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        graficar3D.setText("3D");

        graficahorizontal.setText("Horizontal");

        javax.swing.GroupLayout jPanelGraficaLayout = new javax.swing.GroupLayout(jPanelGrafica);
        jPanelGrafica.setLayout(jPanelGraficaLayout);
        jPanelGraficaLayout.setHorizontalGroup(
            jPanelGraficaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelGraficaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelGraficaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(megusta)
                    .addComponent(seguidores)
                    .addComponent(comentarios)
                    .addComponent(usuario)
                    .addGroup(jPanelGraficaLayout.createSequentialGroup()
                        .addComponent(graficar3D)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(graficahorizontal)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanelGraficaLayout.setVerticalGroup(
            jPanelGraficaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelGraficaLayout.createSequentialGroup()
                .addComponent(seguidores)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(megusta)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(comentarios)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(usuario)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelGraficaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(graficar3D)
                    .addComponent(graficahorizontal))
                .addGap(0, 8, Short.MAX_VALUE))
            .addGroup(jPanelGraficaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        
        JPanel jPanel1 = new Panel("/redsocial/Images/fondo.jpg");
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanelmegusta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanelGrafica, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPaneldiagrama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPaneldiagrama, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanelGrafica, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanelmegusta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        seguidores.setSelected(true);
        seguidores.addActionListener(this);
        megusta.addActionListener(this);
        comentarios.addActionListener(this);
        usuario.addActionListener(this);
        //new Color(42,73,107)
        jPaneldiagrama.setBackground(new Color(255,255,255));
        jPanelGrafica.setOpaque(false);
        jPanelmegusta.setOpaque(false);
        //jPanel1
        jPanel1.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
        contenedor.add(jPanel1,BorderLayout.CENTER);
        dispose();

    }
    
     public void item()
    {
        TextAutoCompleter auto = new TextAutoCompleter(buscarDocentes);
        
        for(User a:RedSocial.docentes)
        {
            auto.addItem(a.getUsuario());
        }
    }
                     
                                         
    private void opcionesItemStateChanged(java.awt.event.ItemEvent evt) {                                          
        switch(opciones.getSelectedIndex())
        {
            case 0:
                buscarDocentes.setEnabled(false);
                buscarDocentes.setText("");
                break;
            case 1:
                buscarDocentes.setEnabled(true);
                break;
        }
    }   
    public ArrayList<Docente> datosSeguir()
    {
        ArrayList<Docente> lista = new ArrayList<>();
        ArrayList<Docente> num = new ArrayList<>();
        
        for(int i=0;i<5;i++)
        {
            Docente extra = red_social.getMayorSeguidor(num);
                    
            if(!lista.contains(extra) && extra != null)
            {
                lista.add(extra);
            }
        }
                    
                return lista;
       }
    public ArrayList<Experiencia> datosComentarios()
    {
        ArrayList<Experiencia> lista = new ArrayList<>();
        ArrayList<Experiencia> num = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            Experiencia extra = red_social.getMayorComentarios(num);

            if (!lista.contains(extra) && extra != null) {
                lista.add(extra);
            }
        }

        return lista;

    }
      
    public ArrayList<User> datosRepresenta()
    {
        ArrayList<User> lista = new ArrayList<>();
        ArrayList<User> num = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            User extra = red_social.getMayorInfluencia(num);

            if (!lista.contains(extra) && extra != null) {
                lista.add(extra);
            }
        }

        return lista;

    }
    
    
    public ArrayList<Experiencia> datosMegusta(boolean general)
    {
        ArrayList<Experiencia> lista = new ArrayList<>();
        ArrayList<Experiencia> num = new ArrayList<>();
        
        
        if(general)
        {
            
            
                for(int i=0;i<5;i++)
                {
                    Experiencia extra = red_social.getMayorGeneral(num);
                    
                    if(!lista.contains(extra) && extra != null)
                    {
                        lista.add(extra);
                    }
                }
                    
                return lista;
            
            
        }
        else
        {
            String user = buscarDocentes.getText();
            Docente aux = red_social.getDocente(user);
            if(red_social.existe(user))
            {
                for(int i=0;i<5;i++)
                {
                    Experiencia extra = red_social.getMayor(aux, num);
                    
                    if(!lista.contains(extra) && extra != null)
                    {
                        lista.add(extra);
                    }
                }
                    
                return lista;
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Ese usuario no existe");
                
            }
        }
        return null;
    }
    
    
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {        
        
        boolean general = false;
        String titulo = "";
        String y ="";
        jPaneldiagrama.removeAll();
        if (opciones.getSelectedIndex() == 0) {
            general = true;
        }
        
        ChartPanel panel;
        JFreeChart chart = null;
        ArrayList<Experiencia> megustaLista = datosMegusta(general);
        ArrayList<Docente> docentesLista = datosSeguir();
        ArrayList<Experiencia> comentarLista = datosComentarios();
        ArrayList<User> representaLista = datosRepresenta();
        
        DefaultCategoryDataset data = new DefaultCategoryDataset();
        if (seguidores.isSelected()) {
            titulo = "Grafico de usuario con mas seguidores";
            y = "numero de seguidores";
            if (docentesLista != null) {
                for (Docente b : docentesLista) {
                    data.addValue(b.getSeguidores().size(), b.getUsuario(), "");
                }
            }
        } else if (megusta.isSelected()) //System.out.println("aca");
        {
            titulo = "Grafico de experiencia con mas megusta";
            y = "numero de me gustas";
            if (megustaLista != null) {
                for (Experiencia a : megustaLista) {
                    data.addValue(a.getNumMegusta(), a.getTitulo(), "");

                }
            }
        }
        else if (comentarios.isSelected()) //System.out.println("aca");
        {
            titulo = "Grafico de experiencia con mas comentarios";
            y = "numero de comentarios";
            if (comentarLista != null) {
                for (Experiencia a : comentarLista) {
                    data.addValue(a.getComentarios().size(), a.getTitulo(), "");

                }
            }
        }
        else if (usuario.isSelected()) //System.out.println("aca");
        {
            titulo = "Grafico de usuario mas participativos";
            y = "numero participaciones";
            if (representaLista != null) {
                for (User a : representaLista) {
                    data.addValue(a.getRepresenta(), a.getUsuario(), "");

                }
            }
        }
        
        if (graficar3D.isSelected() && graficahorizontal.isSelected()) {
            chart = ChartFactory.createBarChart3D(
                    titulo,
                    "",
                    y,
                    data,
                    PlotOrientation.HORIZONTAL,
                    true,
                    true,
                    true);
        } else if (graficar3D.isSelected() && !graficahorizontal.isSelected()) {
            chart = ChartFactory.createBarChart3D(
                    titulo,
                    "",
                    y,
                    data,
                    PlotOrientation.VERTICAL,
                    true,
                    true,
                    true);
        } else if (!graficar3D.isSelected() && graficahorizontal.isSelected()) {
            chart = ChartFactory.createBarChart(
                    titulo,
                    "",
                    y,
                    data,
                    PlotOrientation.HORIZONTAL,
                    true,
                    true,
                    true);
        } else {
            chart = ChartFactory.createBarChart(
                    titulo,
                    "",
                    y,
                    data,
                    PlotOrientation.VERTICAL,
                    true,
                    true,
                    true);
        }
        
        CategoryPlot plot = (CategoryPlot) chart.getPlot();
        plot.setDomainCrosshairVisible(true);
        
        panel = new ChartPanel(chart);
        panel.setBounds(5, 10, 390, 230);
        
        jPaneldiagrama.add(panel);
        jPaneldiagrama.repaint();
        
    }                                  

    public void seleciono(JRadioButton ex)
    {
        if(ex==megusta)
        {
            opciones.setEnabled(true);
            buscarDocentes.setEnabled(true);
            etiqueta.setEnabled(true);
        }
        else
        {
            
            opciones.setEnabled(false);
            buscarDocentes.setEnabled(false);
            etiqueta.setEnabled(false);
            
        }
    }
    
    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getSource()==etiSalir){
            redSocialGui.setVisible(true);
            this.dispose();
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
    public void actionPerformed(ActionEvent e) {
        try 
        {
           JRadioButton radio= (JRadioButton) e.getSource();
            seleciono(radio);
        } 
        catch (Exception error){}
    
    }
    @Override
    public void mouseMoved(MouseEvent e) {}

   
}
