package redsocial;

import java.awt.*;
import static java.awt.Frame.ICONIFIED;
import java.awt.event.ActionEvent;
import java.awt.event.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.geom.RoundRectangle2D;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

public final class RedSocialGUI extends JFrame implements ActionListener,MouseListener,MouseMotionListener{
    Container contenedor;
    JPanel panel,panelBarra;
    JLabel etiTitulo,etiSalir,etiMaximizar,etiMinimizar,title;
    JButton btnBuscar,btnRegistrar,btnExperiencias,btnSignIn,btnStats;
    RedSocial red_social;
    int x,y;
    
    public RedSocialGUI(RedSocial red){  
        red_social  = red;
        contenedor = getContentPane();
        title = new JLabel("Principal");
        panelBarra = new JPanel();
        etiSalir = new JLabel();
        etiMinimizar = new JLabel();
        etiMaximizar = new JLabel();//estetica, no hace nada.
        contenedor.setLayout(new BorderLayout());
        panelBarra.setLayout(new FlowLayout(FlowLayout.LEFT));
        panelBarra.setBackground(Color.BLACK);

        title.setFont(new Font("Comic Sans MS",0,13));
        title.setForeground(Color.WHITE);
        
        ImageIcon salir = new ImageIcon(new ImageIcon(getClass().getResource("/redsocial/Images/btn_rojo.png")).getImage().getScaledInstance(13,13,Image.SCALE_SMOOTH));
        etiSalir.setIcon(salir);
        ImageIcon minimizar = new ImageIcon(new ImageIcon(getClass().getResource("/redsocial/Images/btn_verde.png")).getImage().getScaledInstance(13,13,Image.SCALE_SMOOTH));
        etiMinimizar.setIcon(minimizar);
        ImageIcon maximizar = new ImageIcon(new ImageIcon(getClass().getResource("/redsocial/Images/btn_amarillo.png")).getImage().getScaledInstance(13,13,Image.SCALE_SMOOTH));
        etiMinimizar.setIcon(minimizar);        
        etiMaximizar.setIcon(maximizar);
                               
        panelBarra.add(etiSalir);
        panelBarra.add(etiMaximizar);
        panelBarra.add(etiMinimizar);
        panelBarra.add(Box.createHorizontalStrut(100));
        panelBarra.add(title);

        contenedor.add(panelBarra,BorderLayout.NORTH);
        
        etiSalir.addMouseListener(this);
        etiMinimizar.addMouseListener(this);
        panelBarra.addMouseListener(this);
        panelBarra.addMouseMotionListener(this);
        
        crearVentana();
        
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Exception ex) {
            Logger.getLogger(RedSocialGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        SwingUtilities.updateComponentTreeUI(this);
        setUndecorated(true);
        setSize(400,500);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
        Shape forma = new RoundRectangle2D.Double(0,0,this.getBounds().width,this.getBounds().height,27,27);
        setShape(forma);
    }
    
    public void crearVentana(){
        JPanel panelDerecho,panelCentral,panelInferior;
        panel = new Panel("/redsocial/Images/fondo.jpg");
        panelDerecho = new JPanel(new GridLayout(2,1));
        panelCentral = new JPanel(new GridLayout(1,2,4,4));
        panelInferior = new JPanel(new GridLayout(1,2,4,4));
        etiTitulo = new JLabel("Fortunate Society",JLabel.CENTER);
        btnBuscar = new JButton("Consultar");
        btnRegistrar = new JButton("Registrarse");
        btnSignIn = new JButton("Iniciar sesión");
        btnExperiencias = new JButton("Ver experiencias");
        btnStats = new JButton("Estadísticas");
        
        panel.setLayout(new BorderLayout());
        etiTitulo.setFont(new Font("Lucida Handwriting",Font.PLAIN,35));
        
        ImageIcon buscar = new ImageIcon(new ImageIcon(getClass().getResource("/redsocial/Images/ic_search2.png")).getImage().getScaledInstance(100,100,Image.SCALE_SMOOTH));
        ImageIcon register = new ImageIcon(new ImageIcon(getClass().getResource("/redsocial/Images/ic_register.png")).getImage().getScaledInstance(100,100,Image.SCALE_SMOOTH));
        ImageIcon exp = new ImageIcon(new ImageIcon(getClass().getResource("/redsocial/Images/ic_exp.png")).getImage().getScaledInstance(100,100,Image.SCALE_SMOOTH));
        ImageIcon sing = new ImageIcon(new ImageIcon(getClass().getResource("/redsocial/Images/ic_sign.png")).getImage().getScaledInstance(100,100,Image.SCALE_SMOOTH));
        ImageIcon statistics = new ImageIcon(new ImageIcon(getClass().getResource("/redsocial/Images/ic_est.png")).getImage().getScaledInstance(100,100,Image.SCALE_SMOOTH));
        
        btnBuscar.setIcon(buscar);
        btnRegistrar.setIcon(register);
        btnExperiencias.setIcon(exp);
        btnSignIn.setIcon(sing);
        btnStats.setIcon(statistics);
              
        btnBuscar.setBackground(Color.WHITE);
        btnRegistrar.setBackground(new Color(169,169,169));
        btnExperiencias.setBackground(new Color(255,127,80));
        btnSignIn.setBackground(new Color(135,206,235));
        btnStats.setBackground(new Color(30,144,255));
        
        JButton[] botones = {btnBuscar,btnRegistrar,btnExperiencias,btnSignIn,btnStats};
        for(JButton boton : botones){
            boton.setHorizontalTextPosition(JButton.CENTER);
            boton.setVerticalTextPosition(JButton.BOTTOM);
            boton.setFont(new Font("Bradley Hand ITC",0,15));
            boton.setIconTextGap(0);
        }
        
        panel.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
        panel.add(etiTitulo,BorderLayout.NORTH);

        panelDerecho.add(btnRegistrar);
        panelDerecho.add(btnSignIn);
        
        panelInferior.add(btnStats);
        panelInferior.add(btnExperiencias);
                
        btnBuscar.addActionListener(this);
        btnRegistrar.addActionListener(this);
        btnExperiencias.addActionListener(this);
        btnStats.addActionListener(this);
        btnSignIn.addActionListener(this);
        
        panelCentral.add(btnBuscar);
        panelCentral.add(panelDerecho);
        panel.add(panelCentral,BorderLayout.CENTER);
        panel.add(panelInferior,BorderLayout.SOUTH);
        
        panelDerecho.setOpaque(false);
        panelCentral.setOpaque(false);
        panelInferior.setOpaque(false);
        
        contenedor.add(panel,BorderLayout.CENTER);
    }
        
    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == btnBuscar){
            this.setVisible(false);
            new ConsultasGUI(red_social,this);
        }if(e.getSource() == btnRegistrar){
            this.setVisible(false);
            if(RedSocial.conectado){
                new Perfil(RedSocial.user,RedSocial.user,red_social.getAllFollowers(),this);
            }else{
                String[] options = {"Docente","Usuario"};
                int tipo_user = JOptionPane.showOptionDialog(this,"Tipo de usuario:","Escojer tipo de Usuario",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE,null,options,null);
                if(tipo_user>-1)
                {//cuando cierra la ventana retorna -1 si no selecciona nada
                    new UserGUI(red_social,tipo_user,this);    
                }
            }
        }if(e.getSource() == btnExperiencias){
            this.setVisible(false);
            new ExperienciasGUI(red_social,this);
        }if(e.getSource() == btnStats){
            this.setVisible(false);
            new Estadisticas(red_social,this);

        }if(e.getSource()==btnSignIn)
        {
            if(RedSocial.conectado)
            {
                RedSocial.conectado = false;
                RedSocial.user = null;
                
                ImageIcon register = new ImageIcon(new ImageIcon(getClass().getResource("/redsocial/Images/ic_register.png")).getImage().getScaledInstance(100,100,Image.SCALE_SMOOTH));
                btnRegistrar.setIcon(register);
                ImageIcon sign = new ImageIcon(new ImageIcon(getClass().getResource("/redsocial/Images/ic_sign.png")).getImage().getScaledInstance(100,100,Image.SCALE_SMOOTH));
                btnSignIn.setIcon(sign);
                btnRegistrar.setText("Registrarse");
                btnSignIn.setText("Iniciar sesión");
            }
            else
            {
                this.setVisible(false);
                new IniciarSesion(red_social,btnRegistrar,btnSignIn,this);
            }
           
        }
    }
    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getSource()==etiSalir){
            red_social.guardar();
            this.dispose(); //Libera los recursos utilizados por el Frame
            System.exit(0); //Bye Bye
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
    
    public static void main(String[] args) {
        RedSocial red = new RedSocial();
        RedSocialGUI r = new RedSocialGUI(red);
    }
    
}
