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
import utilidades.User;
import utilidades.Docente;
import static java.awt.Frame.ICONIFIED;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.RoundRectangle2D;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.border.Border;

public class UserGUI extends JFrame implements ActionListener,MouseListener,MouseMotionListener{
    JLabel etiSalir,etiMinimizar,etiMaximizar,title;
    JPanel panelBarra,panelCentral,panelGeneral,panelInferior,panelSuperior,panelCent1,panelCent2;
    JButton btnRegistrar;
    Container contenedor;
    //ventana User
    JTextField campoUsuario,campoNombre,campoApellido,campoContraseña,campoCorreo;
    JLabel etiUsuario,etiNombre,etiApellido,etiContraseña,etiCorreo,etiTitulo,etiInfo;
    //ventana Docente
    JTextField campoFacultad,campoCursos,campoProgramas;
    JLabel etiFacultad,etiCursos,etiProgramas;
    RedSocial red_social;
    int tipo;
    RedSocialGUI redSocialGui;
    int x,y;
    
    public UserGUI(RedSocial red, int tipo, RedSocialGUI redSocialGui){
        red_social = red;
        this.tipo = tipo;
        this.redSocialGui = redSocialGui;
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
        title = new JLabel("Registro");
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

        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Exception ex) {
            Logger.getLogger(UserGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        if(tipo == 1) crearRegistro();
        else crearRegistroDocente();
        SwingUtilities.updateComponentTreeUI(this);
        setUndecorated(true);
        if(tipo == 1) setSize(390,330);
        else setSize(390,470);
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);
        Shape forma = new RoundRectangle2D.Double(0,0,this.getBounds().width,this.getBounds().height,27,27);
        setShape(forma);
    }
    
    public void crearRegistro(){
        panelGeneral = new Panel("/redsocial/Images/fondo.jpg");
        panelSuperior = new JPanel(new GridLayout(2,1));
        panelCentral = new JPanel(new BorderLayout());
        panelInferior = new JPanel();
        panelCent1 = new JPanel();
        panelCent2 = new JPanel();
        etiTitulo = new JLabel("Registro");
        etiInfo = new JLabel("Llene cada uno de los siguientes campos y oprima registrar.", JLabel.CENTER);
        etiUsuario = new JLabel("Usuario:");
        etiNombre = new JLabel("Nombre:");
        etiApellido = new JLabel("Apellido:");
        etiContraseña = new JLabel("Contraseña:");
        etiCorreo = new JLabel("Correo:");
        campoUsuario = new JTextField(15);
        campoNombre = new JTextField(15);
        campoApellido = new JTextField(15);
        campoContraseña = new JTextField(15);
        campoCorreo = new JTextField(15);
        btnRegistrar = new JButton("Registrar");
        
        panelGeneral.setLayout(new BorderLayout());
        panelCent1.setLayout(new BoxLayout(panelCent1,BoxLayout.Y_AXIS));
        panelCent2.setLayout(new FlowLayout());
        panelCentral.setBorder(BorderFactory.createEmptyBorder(0,60,0,4));
        panelSuperior.setBorder(BorderFactory.createEmptyBorder(8,4,0,4));
        
        Border empty = BorderFactory.createEmptyBorder(7,4,5,0);
        etiUsuario.setBorder(empty);
        etiNombre.setBorder(empty);
        etiApellido.setBorder(empty);
        etiContraseña.setBorder(empty);
        etiCorreo.setBorder(empty);
            
        Font etiFont = new Font("Comic Sans MS",Font.PLAIN,14);
        etiInfo.setFont(new Font("Comic Sans MS",Font.PLAIN,13));
        etiUsuario.setFont(etiFont);
        etiNombre.setFont(etiFont);
        etiApellido.setFont(etiFont);
        etiContraseña.setFont(etiFont);
        etiCorreo.setFont(etiFont);
                
        btnRegistrar.setFont(new Font("Comic Sans MS",Font.PLAIN,14));
        btnRegistrar.setForeground(Color.WHITE);
        btnRegistrar.setBackground(Color.BLACK);
        
        etiTitulo.setFont(new Font("Lucida Handwriting",0,30));
        etiTitulo.setHorizontalAlignment(JLabel.CENTER);
        panelSuperior.add(etiTitulo);
        panelSuperior.add(etiInfo);
        panelCent1.add(etiUsuario);
        panelCent2.add(campoUsuario);
        panelCent1.add(etiNombre);
        panelCent2.add(campoNombre);
        panelCent1.add(etiApellido);
        panelCent2.add(campoApellido);
        panelCent1.add(etiContraseña);
        panelCent2.add(campoContraseña);
        panelCent1.add(etiCorreo);
        panelCent2.add(campoCorreo);
        panelCentral.add(panelCent1,BorderLayout.WEST);
        panelCentral.add(panelCent2,BorderLayout.CENTER);
        panelInferior.add(btnRegistrar);
                
        panelGeneral.add(panelSuperior,BorderLayout.NORTH);
        panelGeneral.add(panelCentral,BorderLayout.CENTER);
        
        
        panelGeneral.setBackground(Color.darkGray);
        panelCent1.setOpaque(false);
        panelCent2.setOpaque(false);
        panelCentral.setOpaque(false);
        panelSuperior.setOpaque(false);
        panelInferior.setOpaque(false);
        
        if(tipo == 1){
            panelGeneral.add(panelInferior,BorderLayout.SOUTH);
            contenedor.add(panelGeneral,BorderLayout.CENTER);
            btnRegistrar.addActionListener(this);
        }
    }
        
    public void crearRegistroDocente(){
        crearRegistro();
        JPanel jPanelCentral = new JPanel(new BorderLayout());
        JPanel jPanel1 = new JPanel();
        JPanel jPanel2 = new JPanel();
        JLabel etiInfoDoc = new JLabel("Ingrese los cursos y programas separados por comas.",JLabel.CENTER);
                
        campoFacultad = new JTextField(15);
        campoCursos = new JTextField(15);
        campoProgramas = new JTextField(15);
        etiFacultad = new JLabel("Facultad:");
        etiCursos = new JLabel("Cursos:");
        etiProgramas = new JLabel("Programas:");
                
        Font etiFont = new Font("Comic Sans MS",Font.PLAIN,14);
        etiInfoDoc.setBorder(BorderFactory.createEmptyBorder(7,0,6,0));
        etiInfoDoc.setFont(etiFont);
        etiFacultad.setFont(etiFont);
        etiProgramas.setFont(etiFont);
        etiCursos.setFont(etiFont);
        
        Border empty = BorderFactory.createEmptyBorder(7,4,6,0);
        etiFacultad.setBorder(empty);
        etiCursos.setBorder(empty);
        etiProgramas.setBorder(empty);
        
        jPanel1.setLayout(new BoxLayout(jPanel1,BoxLayout.Y_AXIS));
        jPanel2.setLayout(new FlowLayout());
        
        jPanel1.add(etiFacultad);
        jPanel2.add(campoFacultad);
        jPanel1.add(etiCursos);
        jPanel2.add(campoCursos);
        jPanel1.add(etiProgramas);
        jPanel2.add(campoProgramas);
        
        jPanel1.setOpaque(false);
        jPanel2.setOpaque(false);
        jPanelCentral.setOpaque(false);
        jPanel1.setBorder(BorderFactory.createEmptyBorder(0,60,0,4));
        jPanelCentral.add(etiInfoDoc,BorderLayout.NORTH);        
        jPanelCentral.add(jPanel1,BorderLayout.WEST);
        jPanelCentral.add(jPanel2,BorderLayout.CENTER);
        jPanelCentral.add(panelInferior,BorderLayout.SOUTH);
        
        panelGeneral.add(jPanelCentral,BorderLayout.SOUTH);
        contenedor.add(panelGeneral,BorderLayout.CENTER);
        btnRegistrar.addActionListener(this);
        
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==btnRegistrar){
            String usuario = campoUsuario.getText();
            String nombre = campoNombre.getText();
            String apellido = campoApellido.getText();
            String contrasena = campoContraseña.getText();
            String correo = campoCorreo.getText();
            if(nombre.equals("")||apellido.equals("")||contrasena.equals("")||correo.equals("")||usuario.equals("")){
                JOptionPane.showMessageDialog(null,"No se han ingresado toda la informacion requerida. Intente de nuevo");
            } else{
                if(tipo == 1){
                    User user = new User(usuario,nombre,apellido,contrasena,correo);
                    if(red_social.agregarUsuario(user)){
                        try{
                            red_social.guardar();
                        }catch(Exception ex){
                            ex.printStackTrace();
                        }
                        JOptionPane.showMessageDialog(null,"Usuario agregado con Éxito!");

                    }else JOptionPane.showMessageDialog(null,"El usuario no pudo ser agregado, intente de nuevo.");
                }else if(tipo == 0){
                    String facultad = campoFacultad.getText();
                    String cursos = campoCursos.getText();
                    String programas = campoProgramas.getText();
                    String[] cursos1 = cursos.split(",");
                    String[] programas1 = programas.split(",");
                    ArrayList<String> programas2 = new ArrayList<>();
                    ArrayList<String> cursos2 = new ArrayList<>();
                    cursos2.addAll(Arrays.asList(cursos1));
                    programas2.addAll(Arrays.asList(programas1));
                    Docente d = new Docente(usuario,nombre,apellido,contrasena,correo,
                            facultad,cursos2,programas2);
                    if(red_social.agregarDocente(d)){
                        try{
                            red_social.guardar();
                        }catch(Exception ex){
                            ex.printStackTrace();
                        }
                        JOptionPane.showMessageDialog(null,"Usuario agregado con Éxito!");
                        campoFacultad.setText("");
                        campoCursos.setText("");
                        campoProgramas.setText("");

                    }else JOptionPane.showMessageDialog(null,"El usuario no pudo ser agregado, intente de nuevo.");
                }
                campoUsuario.setText("");
                campoNombre.setText("");
                campoApellido.setText("");
                campoContraseña.setText("");
                campoCorreo.setText("");
            }
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
    public void mouseMoved(MouseEvent e) {}
    
//    public static void main(String[] args) {
//        RedSocial red = new RedSocial();
//        UserGUI u = new UserGUI(red);
//    }
    
}
