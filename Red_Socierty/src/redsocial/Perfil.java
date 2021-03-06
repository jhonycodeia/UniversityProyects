package redsocial;

import Estructuras.Grafo;
import Grafico.ArbolGrafico;
import Grafico.Crearhtml;
import utilidades.Experiencia;
import utilidades.User;
import utilidades.Docente;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.RoundRectangle2D;
import java.util.ArrayList;
import javax.swing.*;

public class Perfil extends JFrame implements ActionListener, MouseListener, MouseMotionListener {

    JLabel etiSalir, etiMinimizar, etiMaximizar, title;
    JPanel panelBarra, panelGeneral;
    Container contenedor;

    JPanel jPanel1, jPanelSup, jPanelGeneral;
    JButton jButton1, jButton2, jButtonFollow, jButtonGrafo, jButtonArbol;
    JLabel jLabel1, jLabel2, jLabel3, jLabel4, jLabel5, jLabel6, jLabel7, jLabel8;
    JScrollPane jScrollPane1;
    JList<Experiencia> jList1;
    JSeparator jSeparator1;
    JTextField campoDocente;

    User user;
    User guest;
    Grafo graph;
    JButton btnAddExp, btnVerExp, btnSearch;
    RedSocialGUI redSocialGui;
    ExperienciaGUI experienciaGui;
    int x, y;

    public Perfil(User user, User guest, Grafo graph, RedSocialGUI redSocialGui) {

        this.redSocialGui = redSocialGui;
        this.user = user;
        this.guest = guest;
        this.graph = graph;
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
        title = new JLabel("Perfil");
        title.setFont(new Font("Comic Sans MS", 0, 13));
        title.setForeground(Color.WHITE);
        panelBarra.add(Box.createHorizontalStrut(90));
        panelBarra.add(title);

        ImageIcon salir = new ImageIcon(new ImageIcon(getClass().getResource("/redsocial/Images/btn_rojo.png")).getImage().getScaledInstance(13, 13, Image.SCALE_SMOOTH));
        etiSalir.setIcon(salir);
        ImageIcon minimizar = new ImageIcon(new ImageIcon(getClass().getResource("/redsocial/Images/btn_verde.png")).getImage().getScaledInstance(13, 13, Image.SCALE_SMOOTH));
        etiMinimizar.setIcon(minimizar);
        ImageIcon maximizar = new ImageIcon(new ImageIcon(getClass().getResource("/redsocial/Images/btn_amarillo.png")).getImage().getScaledInstance(13, 13, Image.SCALE_SMOOTH));
        etiMinimizar.setIcon(minimizar);
        etiMaximizar.setIcon(maximizar);

        etiSalir.addMouseListener(this);
        etiMinimizar.addMouseListener(this);
        contenedor.add(panelBarra, BorderLayout.NORTH);

        panelBarra.addMouseListener(this);
        panelBarra.addMouseMotionListener(this);
        panelBarra.setBackground(Color.BLACK);

        setUndecorated(true);
        setSize(340, 500);

        if (user.equals(guest)) {
            if (user instanceof Docente) {
                crearVentanaDocente();
            } else if (user instanceof User) {
                crearVentanaUsuario(0);
            }
        } else {
            crearVentanaUsuario(1);
        }

        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);
        Shape forma = new RoundRectangle2D.Double(0, 0, this.getBounds().width, this.getBounds().height, 27, 27);
        setShape(forma);
    }

    public Perfil(User user, User guest, Grafo graph, ExperienciaGUI experienciaGui) {

        this.experienciaGui = experienciaGui;
        redSocialGui = null;
        this.user = user;
        this.guest = guest;
        this.graph = graph;
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
        title = new JLabel("Perfil");
        title.setFont(new Font("Comic Sans MS", 0, 13));
        title.setForeground(Color.WHITE);
        panelBarra.add(Box.createHorizontalStrut(90));
        panelBarra.add(title);

        ImageIcon salir = new ImageIcon(new ImageIcon(getClass().getResource("/redsocial/Images/btn_rojo.png")).getImage().getScaledInstance(13, 13, Image.SCALE_SMOOTH));
        etiSalir.setIcon(salir);
        ImageIcon minimizar = new ImageIcon(new ImageIcon(getClass().getResource("/redsocial/Images/btn_verde.png")).getImage().getScaledInstance(13, 13, Image.SCALE_SMOOTH));
        etiMinimizar.setIcon(minimizar);
        ImageIcon maximizar = new ImageIcon(new ImageIcon(getClass().getResource("/redsocial/Images/btn_amarillo.png")).getImage().getScaledInstance(13, 13, Image.SCALE_SMOOTH));
        etiMinimizar.setIcon(minimizar);
        etiMaximizar.setIcon(maximizar);

        etiSalir.addMouseListener(this);
        etiMinimizar.addMouseListener(this);
        contenedor.add(panelBarra, BorderLayout.NORTH);

        panelBarra.addMouseListener(this);
        panelBarra.addMouseMotionListener(this);
        panelBarra.setBackground(Color.BLACK);

        setUndecorated(true);
        setSize(340, 500);

        if (user.equals(guest)) {
            if (user instanceof Docente) {
                crearVentanaDocente();
            } else if (user instanceof User) {
                crearVentanaUsuario(0);
            }
        } else {
            crearVentanaUsuario(1);
        }

        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);
        Shape forma = new RoundRectangle2D.Double(0, 0, this.getBounds().width, this.getBounds().height, 27, 27);
        setShape(forma);
    }

    public void inits() {
        jPanel1 = new JPanel();
        jPanelSup = new JPanel();
        jPanelGeneral = new Panel("/redsocial/Images/fondo.jpg");
        jLabel2 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        jLabel7 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButtonFollow = new javax.swing.JButton();
        jButtonGrafo = new javax.swing.JButton();
        jButtonArbol = new javax.swing.JButton();

        ImageIcon img = new ImageIcon();
        try {
            img = new ImageIcon(getClass().getResource("/redsocial/Images/photo.png"));
        } catch (Exception e) {
            System.err.println("Error al abrir la imagen, Error:" + e);
        }
        ImageIcon photo = new ImageIcon(img.getImage().getScaledInstance(75, 75, Image.SCALE_SMOOTH));
        jLabel1 = new JLabel(user.getNombre() + " " + user.getApellido(), photo, JLabel.CENTER);
        jLabel1.setHorizontalTextPosition(JLabel.CENTER);
        jLabel1.setVerticalTextPosition(JLabel.BOTTOM);
        jLabel1.setFont(new Font("Lucida Handwriting", 0, 13));

        jLabel2.setText("Información del Usuario");
        jLabel2.setFont(new Font("Futura Bk BT", Font.BOLD, 14));

        jLabel3.setText("Nombre:");
        jLabel3.setFont(new Font("Futura Bk BT", Font.BOLD, 14));

        jLabel4.setText("Correo:");
        jLabel4.setFont(new Font("Futura Bk BT", Font.BOLD, 14));

        jLabel5.setText(user.getUsuario());
        jLabel5.setFont(new Font("Futura Bk BT", Font.PLAIN, 14));

        jLabel6.setText(user.getCorreo());
        jLabel6.setFont(new Font("Futura Bk BT", Font.PLAIN, 14));

        jButton1.setBackground(Color.BLACK);
        jButton1.setForeground(Color.WHITE);

    }

    public void crearVentanaDocente() {
        inits();
        this.setSize(350, 540);

        jList1.setModel(new javax.swing.AbstractListModel<Experiencia>() {
            ArrayList<Experiencia> exp = ((Docente) user).getExperiencias();
            Experiencia[] experiencias = exp.toArray(new Experiencia[exp.size()]);

            public int getSize() {
                return experiencias.length;
            }

            public Experiencia getElementAt(int i) {
                return experiencias[i];
            }
        });
        jScrollPane1.setViewportView(jList1);

        jLabel7.setText("Experiencias:");
        jLabel7.setFont(new Font("Futura Bk BT", Font.BOLD, 14));

        jLabel8 = new JLabel("Docente destino:");
        jLabel8.setFont(new Font("Futura Bk BT", Font.PLAIN, 14));

        campoDocente = new JTextField(10);

        jButton1.setText("Agregar experiencia");

        jButton2.setText("Ver experiencia");

        jButton2.setBackground(Color.BLACK);
        jButton2.setForeground(Color.WHITE);

        jButtonFollow.setText("seguir");
        jButtonFollow.setBackground(Color.BLACK);
        jButtonFollow.setForeground(Color.WHITE);

        jButtonGrafo.setText("grafo");
        jButtonGrafo.setBackground(Color.BLACK);
        jButtonGrafo.setForeground(Color.WHITE);

        jButtonArbol.setText("arbol");
        jButtonArbol.setBackground(Color.BLACK);
        jButtonArbol.setForeground(Color.WHITE);

        btnSearch = new JButton();
        btnSearch.setText("buscar");
        btnSearch.setBackground(Color.BLACK);
        btnSearch.setForeground(Color.WHITE);

        if (user instanceof Docente) {
            if (((Docente) user).getSeguidores().contains(guest.getUsuario())) {
                jButtonFollow.setBackground(new Color(30, 144, 255));
            }
        }

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(30, 30, 30)
                                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(77, 77, 77)
                                        .addComponent(jLabel5))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(50, 50, 50)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jLabel4)
                                                .addComponent(jLabel3)
                                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jLabel7)
                                                .addGroup(jPanel1Layout.createSequentialGroup()
                                                        .addGap(20, 20, 20)
                                                        .addComponent(jLabel6))))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(47, 47, 47)
                                        .addComponent(jButton1)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jButton2))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(100, 100, 100)
                                        .addComponent(jLabel2)))
                        .addContainerGap(30, Short.MAX_VALUE))
        );

        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4)
                        .addGap(4, 4, 4)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jButton1)
                                .addComponent(jButton2))
                        .addContainerGap(32, Short.MAX_VALUE))
        );

        jPanelSup.setLayout(new BorderLayout(3, 3));
        JPanel jPanelInferior = new JPanel(new GridLayout(2, 1));
        JPanel jPanelBotons = new JPanel();
        JPanel jPanelRed = new JPanel();

        jPanelBotons.setOpaque(false);
        jPanelBotons.add(jButtonArbol);
        jPanelBotons.add(jButtonFollow);
        jPanelBotons.add(jButtonGrafo);

        jPanelRed.setOpaque(false);
        jPanelRed.add(jLabel8);
        jPanelRed.add(campoDocente);
        jPanelRed.add(btnSearch);
        jPanelInferior.add(jPanelBotons);

        jPanelInferior.setOpaque(false);
        jPanelInferior.add(jPanelRed);

        jButton1.addActionListener(this);
        jButton2.addActionListener(this);
        jButtonFollow.addActionListener(this);
        jButtonGrafo.addActionListener(this);
        jButtonArbol.addActionListener(this);
        btnSearch.addActionListener(this);
        jPanelSup.setOpaque(false);
        jPanel1.setOpaque(false);
        jPanelSup.add(jLabel1, BorderLayout.CENTER);
        jPanelSup.add(jPanelInferior, BorderLayout.SOUTH);
        jPanelGeneral.add(jPanelSup, BorderLayout.NORTH);
        jPanelGeneral.add(jPanel1, BorderLayout.CENTER);
        contenedor.add(jPanelGeneral, BorderLayout.CENTER);
        dispose();

    }

    public void crearVentanaUsuario(int option) {
        inits();

        jList1.setModel(new javax.swing.AbstractListModel<Experiencia>() {
            ArrayList<Experiencia> exp = user.getCompartidas();
            Experiencia[] experiencias = exp.toArray(new Experiencia[exp.size()]);

            public int getSize() {
                return experiencias.length;
            }

            public Experiencia getElementAt(int i) {
                return experiencias[i];
            }
        });
        jScrollPane1.setViewportView(jList1);

        jLabel7.setText("Experiencias Compartidas:");
        jLabel7.setFont(new Font("Futura Bk BT", Font.BOLD, 14));

        jLabel8 = new JLabel("Docente destino:");
        jLabel8.setFont(new Font("Futura Bk BT", Font.PLAIN, 14));

        campoDocente = new JTextField(10);

        btnSearch = new JButton();
        btnSearch.setText("buscar");
        btnSearch.setBackground(Color.BLACK);
        btnSearch.setForeground(Color.WHITE);

        jButton2.setText("Ver experiencia");
        jButton2.setBackground(Color.BLACK);
        jButton2.setForeground(Color.WHITE);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(29, 29, 29)
                                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(77, 77, 77)
                                        .addComponent(jLabel5))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(57, 57, 57)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jLabel4)
                                                .addComponent(jLabel3)
                                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jLabel7)
                                                .addGroup(jPanel1Layout.createSequentialGroup()
                                                        .addGap(20, 20, 20)
                                                        .addComponent(jLabel6))))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(95, 95, 95)
                                        .addComponent(jLabel2))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(120, 120, 120)
                                        .addComponent(jButton2)))
                        .addContainerGap(30, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4)
                        .addGap(4, 4, 4)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2)
                        .addContainerGap(32, Short.MAX_VALUE))
        );

        jButton1.addActionListener(this);
        jButton2.addActionListener(this);
        jPanelSup.setOpaque(false);
        jPanel1.setOpaque(false);

        if (option == 1) {
            jButtonFollow.setText("seguir");
            jButtonFollow.setBackground(Color.BLACK);
            jButtonFollow.setForeground(Color.WHITE);
            jButtonFollow.addActionListener(this);

            jButtonGrafo.setText("grafo");
            jButtonGrafo.setBackground(Color.BLACK);
            jButtonGrafo.setForeground(Color.WHITE);
            jButtonGrafo.addActionListener(this);

            jButtonArbol.setText("arbol");
            jButtonArbol.setBackground(Color.BLACK);
            jButtonArbol.setForeground(Color.WHITE);
            jButtonArbol.addActionListener(this);

            if (guest.getUsuario().equals("")) {
                jButtonFollow.setEnabled(false);
            } else if (user instanceof Docente) {
                if (((Docente) user).getSeguidores().contains(guest.getUsuario())) {
                    jButtonFollow.setBackground(new Color(30, 144, 255));
                }
            }

            jPanelSup.setLayout(new BorderLayout(3, 3));
            JPanel jPanelBotons = new JPanel();
            jPanelBotons.setOpaque(false);
            jPanelBotons.add(jButtonArbol);
            jPanelBotons.add(jButtonFollow);
            jPanelBotons.add(jButtonGrafo);

            jPanelSup.add(jLabel1, BorderLayout.CENTER);
            jPanelSup.add(jPanelBotons, BorderLayout.SOUTH);

        } else {
            jPanelSup.setLayout(new BorderLayout(3, 3));
            JPanel jPanelRed = new JPanel();
            jPanelRed.setOpaque(false);
            jPanelRed.add(jLabel8);
            jPanelRed.add(campoDocente);
            jPanelRed.add(btnSearch);
            jPanelSup.add(jLabel1, BorderLayout.CENTER);
            jPanelSup.add(jPanelRed, BorderLayout.SOUTH);
            jPanelSup.setBorder(BorderFactory.createEmptyBorder(2, 0, 0, 0));
            btnSearch.addActionListener(this);
        }

        jPanelGeneral.add(jPanelSup, BorderLayout.NORTH);
        jPanelGeneral.add(jPanel1, BorderLayout.CENTER);
        contenedor.add(jPanelGeneral, BorderLayout.CENTER);
        dispose();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == jButton2) {
            try {
                Experiencia experiencia = (Experiencia) jList1.getSelectedValue();
                new ExperienciaGUI(experiencia, user, graph);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Escoja un experiencia antes de poder visualizar su informacion");
            }

        } else if (e.getSource() == jButton1) {
            new NuevaExperiencia(user, jList1);

        } else if (e.getSource() == jButtonFollow) {
            guest.Seguir(user.getUsuario());
            if (((Docente)user).Seguirdoc(guest.getUsuario())) {
                JOptionPane.showMessageDialog(null, "¡Ahora sigues a " + user.getUsuario() + "!");
                jButtonFollow.setBackground(new Color(30, 144, 255));
            } else {
                
                JOptionPane.showMessageDialog(null, "¡Ya no sigues a " + user.getUsuario() + "!");
                jButtonFollow.setBackground(Color.BLACK);
            }

        } else if (e.getSource() == jButtonArbol) {
            Object[] obj = graph.buscarRed(user.getUsuario());
            ArrayList<String> red = (ArrayList) obj[1];
            System.out.println(red);
            ArrayList<String> nodos = (ArrayList) obj[0];
            if (!red.isEmpty()) {
                ArbolGrafico arbol = new ArbolGrafico(red, nodos);
            } else {
                JOptionPane.showMessageDialog(null, "No hay conexiones para este usuario.");
            }

        } else if (e.getSource() == jButtonGrafo) {
            ArrayList<String> nodos = graph.buscarRelaciones();
            String rel = "";
            for (int i = 0; i < nodos.size(); i++) {
                rel += nodos.get(i);
            }
            Crearhtml crearHtml = new Crearhtml();
            if (!rel.isEmpty()) {
                crearHtml.crear(rel);
            } else {
                JOptionPane.showMessageDialog(null, "No hay relaciones entre usuarios");
            }
            //JOptionPane.showMessageDialog(null, nodos);
        } else if (e.getSource() == btnSearch) {
            String teacher = campoDocente.getText();
            try {
                if (!teacher.isEmpty()) {
                    //ArrayList camino = graph.camino(user.getUsuario(), teacher, new ArrayList());
                    ArrayList camino;
                    try {
                        camino = graph.buscarCamino(user.getUsuario(), teacher);
                    } catch (Exception ex) {
                        camino = new ArrayList();
                    }
                    if (!camino.isEmpty()) {
                        if (camino.get(camino.size() - 1).equals(teacher)) {
                            JOptionPane.showMessageDialog(null, "Camino: " + camino);
                        } else {
                            JOptionPane.showMessageDialog(null, "No hay camino posible");
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "No hay camino posible");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Docente destino vacio");
                }
            } catch (Exception ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null, "Camino imposible de encontrar.");
            }
        }

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == etiSalir) {
            if (redSocialGui != null) {
                redSocialGui.setVisible(true);
            } else {
                experienciaGui.setVisible(true);
            }
            this.dispose();
        } else if (e.getSource() == etiMinimizar) {
            this.setExtendedState(ICONIFIED);//minimiza la ventana
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        if (e.getSource() == etiSalir) {
            ImageIcon iconSalir = new ImageIcon(getClass().getResource("/redsocial/Images/btn_rojo_press.png"));
            ImageIcon salir = new ImageIcon(iconSalir.getImage().getScaledInstance(13, 13, Image.SCALE_SMOOTH));
            etiSalir.setIcon(salir);
        } else if (e.getSource() == etiMinimizar) {
            ImageIcon iconMinimizar = new ImageIcon(getClass().getResource("/redsocial/Images/btn_verde_press.png"));
            ImageIcon minimizar = new ImageIcon(iconMinimizar.getImage().getScaledInstance(13, 13, Image.SCALE_SMOOTH));
            etiMinimizar.setIcon(minimizar);
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        if (e.getSource() == etiSalir) {
            ImageIcon salir = new ImageIcon(new ImageIcon(getClass().getResource("/redsocial/Images/btn_rojo.png")).getImage().getScaledInstance(13, 13, Image.SCALE_SMOOTH));
            etiSalir.setIcon(salir);
        } else if (e.getSource() == etiMinimizar) {
            ImageIcon minimizar = new ImageIcon(new ImageIcon(getClass().getResource("/redsocial/Images/btn_verde.png")).getImage().getScaledInstance(13, 13, Image.SCALE_SMOOTH));
            etiMinimizar.setIcon(minimizar);
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        x = e.getX();
        y = e.getY();
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        Point p = MouseInfo.getPointerInfo().getLocation();
        this.setLocation(p.x - x, p.y - y);
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseMoved(MouseEvent e) {
    }

}
