package Interfaz;

import Fuentes.Conexion;
import Fuentes.Hijo;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author GRUPO 4
 */
public class JFInHijo extends javax.swing.JInternalFrame {

    DefaultTableModel model;//Modifica un objeto del tipo jtable
    Conexion cc;
    Connection cn;
    private int auxiliarBoton;

    public JFInHijo() {
        initComponents();
        this.JBGuardarCambios.setEnabled(false);
        this.JBCancelarCambios.setEnabled(false);

        this.JTFCodHijo.setEnabled(false);
        this.JTFCodCT.setEnabled(false);
        this.JTFNumCedTutor.setEnabled(false);
        this.JTFNombApe.setEnabled(false);
        this.JDCFechaNac.setEnabled(false);
        this.JBSearchCT.setEnabled(false);
        this.JBSearchTutor.setEnabled(false);

        cc = new Conexion();
        cn = cc.getConexion();
        cargar("");
    }

    //Se extrae lo que tenemos en la base de datos de la tabla HIJO
    public void cargar(String valor) {
        //Titulos de cada Cl y Fl
        String[] titulos = {"CÓDIGO HIJO", "CÓDIGO CENTRO", "NÚM. CÉDULA TUTOR", "NOMBRE HIJO", "FECHA DE NACIMIENTO"};
        String[] registros = new String[5];

        String querry = "SELECT * FROM vista_hijos where HIJO_CODIGO LIKE '%" + valor + "%' "
                + "ORDER BY HIJO_CODIGO ASC";
        model = new DefaultTableModel(null, titulos);// Le damos el formato

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(querry);

            while (rs.next()) {
                //Se da la informacion a cada columna que se extrae de rs
                registros[0] = rs.getString("HIJO_CODIGO");
                registros[1] = rs.getString("CT_CODIGO");
                registros[2] = rs.getString("EMP_CEDULA");
                registros[3] = rs.getString("HIJO_NOMBRE");
                registros[4] = rs.getString("HIJO_FECHANAC");

                model.addRow(registros);//Se ingresa la informacion al model
            }
            JTableHijo.setModel(model);//Seteamos la tabla con los datos 
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }

    public void opcionAgain() {
        this.JBNuevoReg.setEnabled(true);
        this.JBModificarReg.setEnabled(true);
        this.JBBorrarReg.setEnabled(true);

        this.JBGuardarCambios.setEnabled(false);
        this.JBCancelarCambios.setEnabled(false);

        this.JTFCodHijo.setEnabled(false);
        this.JTFCodCT.setEnabled(false);
        this.JTFNumCedTutor.setEnabled(false);
        this.JTFNombApe.setEnabled(false);
        this.JDCFechaNac.setEnabled(false);
        this.JBSearchCT.setEnabled(false);
        this.JBSearchTutor.setEnabled(false);

        this.JTFCodHijo.setText("");
        this.JTFCodCT.setText("");
        this.JTFNumCedTutor.setText("");
        this.JTFNombApe.setText("");
        this.JDCFechaNac.setCalendar(null);
        this.JBSearchCT.setText("");
        this.JBSearchTutor.setText("");

        cargar("");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jSplitPane2 = new javax.swing.JSplitPane();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        JBNuevoReg = new javax.swing.JButton();
        JBModificarReg = new javax.swing.JButton();
        JBBorrarReg = new javax.swing.JButton();
        JBGuardarCambios = new javax.swing.JButton();
        JBCancelarCambios = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        JTFCodBuscador = new javax.swing.JTextField();
        JPanelPrincipal = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        JTFCodHijo = new javax.swing.JTextField();
        JBSearchTutor = new javax.swing.JButton();
        JTFCodCT = new javax.swing.JTextField();
        JBSearchCT = new javax.swing.JButton();
        JTFNumCedTutor = new javax.swing.JTextField();
        JTFNombApe = new javax.swing.JTextField();
        JDCFechaNac = new com.toedter.calendar.JDateChooser();
        jScrollPane2 = new javax.swing.JScrollPane();
        JTableHijo = new javax.swing.JTable();

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("HIJO");
        setMinimumSize(new java.awt.Dimension(116, 33));
        setPreferredSize(new java.awt.Dimension(995, 625));

        jSplitPane2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jSplitPane2.setDividerLocation(220);

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Hijos"));

        JBNuevoReg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/iconfinder_Applications_and_Programming_database_data_base_add_6569385.png"))); // NOI18N
        JBNuevoReg.setText("Nuevo Registro");
        JBNuevoReg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBNuevoRegActionPerformed(evt);
            }
        });

        JBModificarReg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/iconfinder_Applications_and_Programming_database_data_base_config_cog_options_6569362.png"))); // NOI18N
        JBModificarReg.setText("Modificar Registro");
        JBModificarReg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBModificarRegActionPerformed(evt);
            }
        });

        JBBorrarReg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/iconfinder_Applications_and_Programming_database_data_base_delete_6569389.png"))); // NOI18N
        JBBorrarReg.setText("Borrar Registro");
        JBBorrarReg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBBorrarRegActionPerformed(evt);
            }
        });

        JBGuardarCambios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/iconfinder_ic_save_48px_352084.png"))); // NOI18N
        JBGuardarCambios.setText("Guardar Cambios");
        JBGuardarCambios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBGuardarCambiosActionPerformed(evt);
            }
        });

        JBCancelarCambios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/iconfinder_cancel_326554.png"))); // NOI18N
        JBCancelarCambios.setText("Cancelar Cambios");
        JBCancelarCambios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBCancelarCambiosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(JBNuevoReg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(JBModificarReg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(JBBorrarReg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(JBGuardarCambios, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(JBCancelarCambios, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(JBNuevoReg)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(JBModificarReg)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(JBBorrarReg)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(JBGuardarCambios)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(JBCancelarCambios)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder("Filtro"));

        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("Código del Hijo:");

        JTFCodBuscador.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        JTFCodBuscador.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                JTFCodBuscadorKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addComponent(JTFCodBuscador, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(JTFCodBuscador, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(102, Short.MAX_VALUE))
        );

        jSplitPane2.setLeftComponent(jPanel2);

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos Hijos"));

        jLabel1.setText("CÓDIGO HIJO:");

        jLabel2.setText("CÓDIGO CENTRO DE TRABAJO:");

        jLabel3.setText("NÚM. CÉDULA TUTOR:");

        jLabel4.setText("NOMBRE Y APELLIDO:");

        jLabel5.setText("FECHA DE NACIMIENTO:");

        JTFCodHijo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JTFCodHijoActionPerformed(evt);
            }
        });

        JBSearchTutor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/iconfinder_Searchicons-search-people2_825453.png"))); // NOI18N
        JBSearchTutor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBSearchTutorActionPerformed(evt);
            }
        });

        JBSearchCT.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/iconfinder_Searchicons-search-people2_825453.png"))); // NOI18N
        JBSearchCT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBSearchCTActionPerformed(evt);
            }
        });

        JTFNombApe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JTFNombApeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addGap(51, 51, 51)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(JTFNombApe, javax.swing.GroupLayout.DEFAULT_SIZE, 194, Short.MAX_VALUE)
                    .addComponent(JTFNumCedTutor, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(JTFCodHijo)
                    .addComponent(JTFCodCT)
                    .addComponent(JDCFechaNac, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(JBSearchTutor, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JBSearchCT, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(JTFCodHijo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(JBSearchCT, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(JBSearchTutor, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(JTFCodCT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGap(35, 35, 35)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(JTFNumCedTutor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(32, 32, 32)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(JTFNombApe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(JDCFechaNac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(18, Short.MAX_VALUE))
        );

        jScrollPane2.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        jScrollPane2.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        JTableHijo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane2.setViewportView(JTableHijo);

        javax.swing.GroupLayout JPanelPrincipalLayout = new javax.swing.GroupLayout(JPanelPrincipal);
        JPanelPrincipal.setLayout(JPanelPrincipalLayout);
        JPanelPrincipalLayout.setHorizontalGroup(
            JPanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JPanelPrincipalLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(JPanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 717, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        JPanelPrincipalLayout.setVerticalGroup(
            JPanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JPanelPrincipalLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 271, Short.MAX_VALUE)
                .addContainerGap())
        );

        jSplitPane2.setRightComponent(JPanelPrincipal);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jSplitPane2)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jSplitPane2)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void JBNuevoRegActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBNuevoRegActionPerformed
        this.auxiliarBoton = 1;

        this.JBNuevoReg.setEnabled(false);
        this.JBModificarReg.setEnabled(false);
        this.JBBorrarReg.setEnabled(false);

        this.JBGuardarCambios.setEnabled(true);
        this.JBCancelarCambios.setEnabled(true);

        JTFCodHijo.setEnabled(true);
        this.JTFNombApe.setEnabled(true);
        this.JDCFechaNac.setEnabled(true);
        this.JBSearchTutor.setEnabled(true);
        this.JBSearchCT.setEnabled(true);

        this.JTFCodHijo.requestFocus();
    }//GEN-LAST:event_JBNuevoRegActionPerformed

    private void JBGuardarCambiosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBGuardarCambiosActionPerformed
        int codigoHijo = Integer.parseInt(this.JTFCodHijo.getText());
        int centroTrabajo = Integer.parseInt(JTFCodCT.getText());
        int numCITutor = Integer.parseInt(JTFNumCedTutor.getText());
        String nombreHijo = this.JTFNombApe.getText();
        Date date = JDCFechaNac.getDate();//Se crea un objeto del tipo date y se extrae del jCalendar
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");//Se le da un formato de la base de datos
        String fechaNac = formato.format(date);//Se guarda como String y se le da el formato de arriba

        Hijo hijo = new Hijo(codigoHijo, centroTrabajo, numCITutor, nombreHijo, fechaNac);

        //Opcion Guardar hijo
        if (auxiliarBoton == 1) {
            //Cuando el usuario verifica que SI desea guardar al hijo
            if (hijo.guardarHijo(cn)) {
                this.opcionAgain();
                //Cuando el usuario verifica que NO desea guardar al hijo   
            } else {
                this.opcionAgain();
            }
        } else {//AuxBoton = 2 es decir modificar hijo
            //Cuando el usuario verifica que SI desea guardar al hijo
            if (hijo.modificarHijo(codigoHijo, cn)) {
                this.opcionAgain();
                //Cuando el usuario verifica que NO desea guardar al hijo   
            } else {
                this.opcionAgain();
            }
        }
    }//GEN-LAST:event_JBGuardarCambiosActionPerformed

    private void JBCancelarCambiosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBCancelarCambiosActionPerformed
        opcionAgain();
    }//GEN-LAST:event_JBCancelarCambiosActionPerformed

    private void JBBorrarRegActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBBorrarRegActionPerformed
        int fila = JTableHijo.getSelectedRow();
        if (fila >= 0) {
            //Activando cajas de texto y botones
            int valor = Integer.parseInt(JTableHijo.getValueAt(fila, 0).toString());

            this.JBNuevoReg.setEnabled(false);
            this.JBModificarReg.setEnabled(false);
            this.JBBorrarReg.setEnabled(false);

            this.JBGuardarCambios.setEnabled(false);
            this.JBCancelarCambios.setEnabled(false);

            this.JTFCodHijo.setEnabled(false);
            JFInHijo.JTFCodCT.setEnabled(false);
            JFInHijo.JTFNumCedTutor.setEnabled(false);
            this.JTFNombApe.setEnabled(false);
            this.JDCFechaNac.setEnabled(false);
            this.JBSearchCT.setEnabled(false);
            this.JBSearchTutor.setEnabled(false);

            //Pasando datos de la tabla a cada caja de texto
            this.JTFCodHijo.setText(JTableHijo.getValueAt(fila, 0).toString());
            JFInHijo.JTFCodCT.setText(JTableHijo.getValueAt(fila, 1).toString());
            JFInHijo.JTFNumCedTutor.setText(JTableHijo.getValueAt(fila, 2).toString());
            this.JTFNombApe.setText(JTableHijo.getValueAt(fila, 3).toString());
            SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
            try {
                Date fecha = formato.parse(JTableHijo.getValueAt(fila, 4).toString());
                this.JDCFechaNac.setDate(fecha);
            } catch (ParseException e) {
                // Error, la cadena de texto no se puede convertir en fecha.
                System.out.println(e);
            }

            this.JTFCodBuscador.setText("");

            if (Hijo.eliminarHijo(valor, cn)) {
                this.opcionAgain();
            } else {
                this.opcionAgain();
            }
        } else {
            JOptionPane.showMessageDialog(null, "Por favor seleccione un REGISTRO.", "Mensaje", JOptionPane.DEFAULT_OPTION);
        }
    }//GEN-LAST:event_JBBorrarRegActionPerformed

    private void JTFCodBuscadorKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JTFCodBuscadorKeyReleased
        cargar(this.JTFCodBuscador.getText());
    }//GEN-LAST:event_JTFCodBuscadorKeyReleased

    private void JBModificarRegActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBModificarRegActionPerformed
        auxiliarBoton = 2;
        int fila = JTableHijo.getSelectedRow();
        if (fila >= 0) {
            //Activando cajas de texto y botones
            this.JBNuevoReg.setEnabled(false);
            this.JBModificarReg.setEnabled(false);
            this.JBBorrarReg.setEnabled(false);

            this.JBGuardarCambios.setEnabled(true);
            this.JBCancelarCambios.setEnabled(true);

            this.JTFCodBuscador.setEnabled(true);
            this.JTFCodHijo.setEnabled(false);
            JFInHijo.JTFCodCT.setEnabled(false);
            JFInHijo.JTFNumCedTutor.setEnabled(false);
            this.JTFNombApe.setEnabled(true);
            this.JDCFechaNac.setEnabled(true);
            this.JBSearchCT.setEnabled(false);
            this.JBSearchTutor.setEnabled(true);

            //Pasando datos de la tabla a cada caja de texto
            this.JTFCodHijo.setText(JTableHijo.getValueAt(fila, 0).toString());
            this.JTFCodCT.setText(JTableHijo.getValueAt(fila, 1).toString());
            this.JTFNumCedTutor.setText(JTableHijo.getValueAt(fila, 2).toString());
            this.JTFNombApe.setText(JTableHijo.getValueAt(fila, 3).toString());
            SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
            try {
                Date fecha = formato.parse(JTableHijo.getValueAt(fila, 4).toString());
                this.JDCFechaNac.setDate(fecha);
            } catch (ParseException e) {
                // Error, la cadena de texto no se puede convertir en fecha.
                System.out.println(e);
            }

        } else {
            JOptionPane.showMessageDialog(null, "Por favor seleccione un REGISTRO.", "Mensaje", JOptionPane.DEFAULT_OPTION);
        }
    }//GEN-LAST:event_JBModificarRegActionPerformed

    private void JTFNombApeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JTFNombApeActionPerformed
        this.JTFNombApe.transferFocus();
    }//GEN-LAST:event_JTFNombApeActionPerformed

    private void JTFCodHijoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JTFCodHijoActionPerformed
        this.JTFCodHijo.transferFocus();
    }//GEN-LAST:event_JTFCodHijoActionPerformed

    private void JBSearchTutorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBSearchTutorActionPerformed
        JFListaEmpleados jdEmp = new JFListaEmpleados();
        jdEmp.setAux("Hijo");
        jdEmp.setVisible(true);
    }//GEN-LAST:event_JBSearchTutorActionPerformed

    private void JBSearchCTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBSearchCTActionPerformed
        JFListaCT jdCT = new JFListaCT();
        jdCT.setAux("Hijo");
        jdCT.setVisible(true);
    }//GEN-LAST:event_JBSearchCTActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton JBBorrarReg;
    private javax.swing.JButton JBCancelarCambios;
    private javax.swing.JButton JBGuardarCambios;
    private javax.swing.JButton JBModificarReg;
    private javax.swing.JButton JBNuevoReg;
    private javax.swing.JButton JBSearchCT;
    private javax.swing.JButton JBSearchTutor;
    private com.toedter.calendar.JDateChooser JDCFechaNac;
    private javax.swing.JPanel JPanelPrincipal;
    private javax.swing.JTextField JTFCodBuscador;
    public static javax.swing.JTextField JTFCodCT;
    private javax.swing.JTextField JTFCodHijo;
    private javax.swing.JTextField JTFNombApe;
    public static javax.swing.JTextField JTFNumCedTutor;
    public static javax.swing.JTable JTableHijo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSplitPane jSplitPane2;
    // End of variables declaration//GEN-END:variables
}
