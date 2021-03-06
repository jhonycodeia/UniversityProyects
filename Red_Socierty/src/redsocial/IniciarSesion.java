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
import static java.awt.Frame.ICONIFIED;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.RoundRectangle2D;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.border.Border;

public class IniciarSesion extends JFrame implements ActionListener,MouseListener,MouseMotionListener{
    JLabel etiSalir,etiMinimizar,etiMaximizar,title;
    JPanel panelBarra,panelCentral,panelGeneral,panelInferior,panelSuperior,panelCent1,panelCent2;
    JButton btnSignIn,btnRegistrar,btnIniciar;
    Container contenedor;
    //ventana
    JTextField campoUsuario;
    JPasswordField campoContraseña;
    JLabel etiUsuario,etiContraseña,etiTitulo,etiInfo;
    RedSocial red_social;
    RedSocialGUI redSocialGui;
    int x,y;
    
    public IniciarSesion(RedSocial red, JButton registrar, JButton iniciar,RedSocialGUI redSocialGui){
        this.redSocialGui = redSocialGui;
        red_social = red;
        btnRegistrar = registrar;
        btnIniciar = iniciar;
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
        title = new JLabel("Iniciar Sesión");
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
        setSize(390,240);
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
        etiTitulo = new JLabel("Iniciar Sesión");
        etiInfo = new JLabel("Ingrese su usuario y contraseña para iniciar sesión.", JLabel.CENTER);
        etiUsuario = new JLabel("Usuario:");
        etiContraseña = new JLabel("Contraseña:");
        campoUsuario = new JTextField(10);
        campoContraseña = new JPasswordField(10);
        btnSignIn = new JButton("Sign In");
        
        panelGeneral.setLayout(new BorderLayout());
        panelCent1.setLayout(new BoxLayout(panelCent1,BoxLayout.Y_AXIS));
        panelCent2.setLayout(new FlowLayout());
        panelCentral.setBorder(BorderFactory.createEmptyBorder(0,70,0,4));
        panelSuperior.setBorder(BorderFactory.createEmptyBorder(8,4,0,4));
        
        Border empty = BorderFactory.createEmptyBorder(6,4,5,4);
        etiUsuario.setBorder(empty);
        etiContraseña.setBorder(empty);
            
        Font etiFont = new Font("Comic Sans MS",Font.PLAIN,14);
        etiInfo.setFont(new Font("Comic Sans MS",Font.PLAIN,13));
        etiUsuario.setFont(etiFont);
        etiContraseña.setFont(etiFont);
                        
        btnSignIn.setFont(new Font("Comic Sans MS",Font.PLAIN,14));
        btnSignIn.setForeground(Color.WHITE);
        btnSignIn.setBackground(Color.BLACK);
        
        etiTitulo.setFont(new Font("Futura Bk BT",0,32));
        etiTitulo.setHorizontalAlignment(JLabel.CENTER);
        panelSuperior.add(etiTitulo);
        panelSuperior.add(etiInfo);
        panelCent1.add(etiUsuario);
        panelCent2.add(campoUsuario);
        panelCent1.add(etiContraseña);
        panelCent2.add(campoContraseña);
        panelCentral.add(panelCent1,BorderLayout.WEST);
        panelCentral.add(panelCent2,BorderLayout.CENTER);
        panelInferior.add(btnSignIn);
                
        panelGeneral.add(panelSuperior,BorderLayout.NORTH);
        panelGeneral.add(panelCentral,BorderLayout.CENTER);
        panelGeneral.add(panelInferior,BorderLayout.SOUTH);
        
        panelGeneral.setBackground(Color.darkGray);
        panelCent1.setOpaque(false);
        panelCent2.setOpaque(false);
        panelCentral.setOpaque(false);
        panelSuperior.setOpaque(false);
        panelInferior.setOpaque(false);
        
        contenedor.add(panelGeneral,BorderLayout.CENTER);
        btnSignIn.addActionListener(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==btnSignIn){
            String usuario = campoUsuario.getText();
            char[] aux = campoContraseña.getPassword();
            String contrasena = "";
            for(char c : aux){
                contrasena += c;
            }
            if(contrasena.equals("")||usuario.equals("")){
                JOptionPane.showMessageDialog(null,"No se han ingresado toda la informacion requerida. Intente de nuevo");
            } else{
                User user = red_social.iniciarSesion(usuario, contrasena);
                if(user != null){
                    
                    JOptionPane.showMessageDialog(null,"Inicio de sesión con Éxito!");
                    RedSocial.conectado = true;
                    RedSocial.user = user;
                    
                    ImageIcon register = new ImageIcon(new ImageIcon(getClass().getResource("/redsocial/Images/ic_account.png")).getImage().getScaledInstance(100,100,Image.SCALE_SMOOTH));
                    btnRegistrar.setIcon(register);
                    ImageIcon sign = new ImageIcon(new ImageIcon(getClass().getResource("/redsocial/Images/logout.png")).getImage().getScaledInstance(100,100,Image.SCALE_SMOOTH));
                    btnIniciar.setIcon(sign);
                    btnRegistrar.setText("Perfil");
                    btnIniciar.setText("Cerrar sesión");
                    
                    new Perfil(user,user,red_social.getAllFollowers(),redSocialGui);
                    this.dispose();
                }else JOptionPane.showMessageDialog(null,"Datos inválidos!");
                campoUsuario.setText("");
                campoContraseña.setText("");

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

}
