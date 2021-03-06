package redsocial;

import utilidades.Experiencia;
import java.awt.*;
import static java.awt.Frame.ICONIFIED;
import java.awt.event.*;
import java.awt.geom.RoundRectangle2D;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class RecomendacionesGUI extends JFrame implements MouseListener,MouseMotionListener,ActionListener{
    JLabel etiSalir,etiMinimizar,etiMaximizar,title;
    JPanel panelBarra,panelCentral;
    Container contenedor;
    
    JTextArea infoExperiencia;
    JTable tablaExps;
    DefaultTableModel modelTable,modelDrinks;
    JScrollPane panelTablaExp;
    JButton btnVerExp;
    ExperienciasGUI experienciasGui;
    RedSocial red;
    
    int x,y;
    
    public RecomendacionesGUI(RedSocial red, ExperienciasGUI experienciasGui){
        this.red = red;
        this.experienciasGui = experienciasGui;
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
        title = new JLabel("Recomendaciones");
        title.setFont(new Font("Comic Sans MS",0,13));
        title.setForeground(Color.WHITE);
        panelBarra.add(Box.createHorizontalStrut(88));
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
        setSize(380,490);
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);
        Shape forma = new RoundRectangle2D.Double(0,0,this.getBounds().width,this.getBounds().height,27,27);
        setShape(forma);
        
    }
        
    public void crearVentana(){
        JPanel panelGeneral, panelInferior;
        JScrollPane panelInfo,panelTabla;
        JLabel etiExperiencias,etiInfo,etiUso;
        panelGeneral = new Panel("/redsocial/Images/fondo.jpg");
        panelInferior = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        panelCentral = new JPanel(new GridLayout(2,1,4,4));
        panelGeneral.setLayout(new BorderLayout());
        infoExperiencia = new JTextArea();
        btnVerExp = new JButton("Ver");
        btnVerExp.setBackground(Color.BLACK);
        btnVerExp.setForeground(Color.WHITE);
        btnVerExp.setFont(new Font("Comic Sans MS",Font.PLAIN,14));
        
        panelInferior.setBorder(BorderFactory.createEmptyBorder(0,0,0,10));
        
        String[][] dataExp = null;
        ArrayList<Experiencia> experiencias = red.recomendaciones();
        ArrayList<String[]> infoTabla = new ArrayList<>();
        for(int i = 0; i<experiencias.size(); i++){
            infoTabla.add(experiencias.get(i).getInfoTabla());
        }
        if(!infoTabla.isEmpty()) dataExp = infoTabla.toArray(new String[infoTabla.size()][infoTabla.get(0).length]);
        
        String[] columnNames = {"Título","Docente","Fecha"};
        
        modelTable = new DefaultTableModel(dataExp,columnNames){
            @Override
            public boolean isCellEditable(int row, int column){
                return false;
        }};
        tablaExps = new JTable(modelTable);
        tablaExps.setBackground(Color.BLACK);
        tablaExps.setForeground(Color.WHITE);
        tablaExps.setFont(new Font("Futura Bk BT",Font.PLAIN,14));
        
        panelInfo = new JScrollPane(infoExperiencia);
        panelTabla = new JScrollPane(tablaExps);

        etiExperiencias = new JLabel("Experiencias",JLabel.CENTER);
        etiInfo = new JLabel("Información de la Experiencia",JLabel.CENTER);
        etiUso = new JLabel("Seleccione una fila de la tabla para ver la información completa",JLabel.CENTER);
        etiExperiencias.setFont(new Font("Segoe Print",Font.BOLD,12));
        etiInfo.setFont(new Font("Segoe Print",Font.BOLD,12));
                
        panelTabla.setColumnHeaderView(etiExperiencias);
        panelInfo.setColumnHeaderView(etiInfo);
        etiUso.setBorder(BorderFactory.createEmptyBorder(6,0,0,0));
        etiUso.setFont(new Font("Comic Sans MS",Font.PLAIN,12));
        etiUso.setForeground(Color.BLACK);
        
        infoExperiencia.setEditable(false);
        panelCentral.add(panelTabla);
        panelCentral.add(panelInfo);
        panelInferior.add(btnVerExp);
        panelInferior.setOpaque(false);
        panelGeneral.add(etiUso,BorderLayout.NORTH);
        panelGeneral.add(panelCentral,BorderLayout.CENTER);
        panelGeneral.add(panelInferior,BorderLayout.SOUTH);
        panelCentral.setBorder(BorderFactory.createEmptyBorder(10,15,0,15));
        panelCentral.setOpaque(false);
        contenedor.add(panelGeneral,BorderLayout.CENTER); 
        
        btnVerExp.addActionListener(this);
        tablaExps.addMouseListener(this);
    }   
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == btnVerExp){           
            try{
                int row = tablaExps.getSelectedRow();
                if(row>-1){
                    String titulo = (String)tablaExps.getValueAt(row, 0);
                    String doc = (String)tablaExps.getValueAt(row, 1);
                    Experiencia experiencia = (Experiencia)red.getExperiencia(titulo, doc);
                    new ExperienciaGUI(experiencia,red.getUserActive(),red.getAllFollowers());
                    
                } else JOptionPane.showMessageDialog(this,"Escoja un experiencia antes de poder visualizar su información");          
            }catch(Exception ex){
                JOptionPane.showMessageDialog(this,"Escoja un experiencia antes de poder visualizar su información");
                ex.printStackTrace();
            }           
            
        } 
        
    }
    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getSource()==etiSalir){
            experienciasGui.setVisible(true);
            this.dispose();
        } else if(e.getSource()==etiMinimizar){
            this.setExtendedState(ICONIFIED);//minimiza la ventana
        } else if(e.getSource()==tablaExps){
            try{
                int row = tablaExps.getSelectedRow();
                if(row>-1){
                    String titulo = (String)tablaExps.getValueAt(row, 0);
                    String doc = (String)tablaExps.getValueAt(row, 1);
                    Experiencia experiencia = (Experiencia)red.getExperiencia(titulo, doc);
                    infoExperiencia.setText(experiencia.getInfoExperiencia());
                }            
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
    
}
