package Interfaz;

import Fuentes.Conexion;
import Fuentes.Empleado;
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
public class JFInEmpleado extends javax.swing.JInternalFrame {

    DefaultTableModel model;//Modifica un objeto del tipo jtable
    Conexion cc;
    Connection cn;
    private int auxiliarBoton;
    private int sucursal;

    public JFInEmpleado(int aux) {
        initComponents();
        this.JBGuardarCambios.setEnabled(false);
        this.JBCancelarCambios.setEnabled(false);

        this.JTFNomApeEmp.setEnabled(false);
        this.JTFNomCT.setEnabled(false);
        this.JTFNomDep.setEnabled(false);
        this.JTFNumCedEmp.setEnabled(false);
        this.JTFNumHijos.setEnabled(false);
        this.JTFTelef.setEnabled(false);
        this.JBSearchDep.setEnabled(false);
        this.JTFSalario.setEnabled(false);
        this.JDCFechaContra.setEnabled(false);
        this.JBSearchCT.setEnabled(false);
        cc = new Conexion();
        cn = cc.getConexion(aux);
        this.sucursal = aux;
        cargar("");
    }

    //Se extrae lo que tenemos en la base de datos de la tabla EMPLEADO
    public void cargar(String valor) {
        //Titulos de cada Cl y Fl
        String[] titulos = {"NÚM. CÉDULA", "CÓDIGO CENTRO", "CÓDIGO DEPARTAMENTO", "NOMBRE EMPLEADO", "NÚM. HIJOS", "TELÉFONO"};
        String[] registros = new String[6];

        String querry = "SELECT * FROM empleado where EMP_CEDULA LIKE '%" + valor + "%'";
        model = new DefaultTableModel(null, titulos);// Le damos el formato

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(querry);

            while (rs.next()) {
                //Se da la informacion a cada columna que se extrae de rs
                registros[0] = rs.getString("EMP_CEDULA");
                registros[1] = rs.getString("CT_CODIGO");
                registros[2] = rs.getString("DEP_CODIGO");
                registros[3] = rs.getString("EMP_NOMBRE");
                registros[4] = rs.getString("EMP_NUMHIJOS");
                registros[5] = rs.getString("EMP_TELEFONO");
                model.addRow(registros);//Se ingresa la informacion al model
            }
            JTableEmpleado.setModel(model);//Seteamos la tabla con los datos 
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

        this.JTFNomApeEmp.setEnabled(false);
        this.JTFNomCT.setEnabled(false);
        this.JTFNomDep.setEnabled(false);
        this.JTFNumCedEmp.setEnabled(false);
        this.JTFNumHijos.setEnabled(false);
        this.JTFTelef.setEnabled(false);
        this.JBSearchDep.setEnabled(false);
        this.JTFSalario.setEnabled(false);
        this.JDCFechaContra.setEnabled(false);
        this.JBSearchCT.setEnabled(false);

        this.JTFCedulaBuscador.setText("");
        this.JTFNomApeEmp.setText("");
        this.JTFNomCT.setText("");
        this.JTFNomDep.setText("");
        this.JTFNumCedEmp.setText("");
        this.JTFNumHijos.setText("");
        this.JTFTelef.setText("");
        this.JTFSalario.setText("");
        this.JDCFechaContra.setCalendar(null);
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
        JTFCedulaBuscador = new javax.swing.JTextField();
        JPanelPrincipal = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        JTFNomApeEmp = new javax.swing.JTextField();
        JTFNumHijos = new javax.swing.JTextField();
        JTFNumCedEmp = new javax.swing.JTextField();
        JTFTelef = new javax.swing.JTextField();
        JTFNomCT = new javax.swing.JTextField();
        JBSearchDep = new javax.swing.JButton();
        JTFNomDep = new javax.swing.JTextField();
        JBSearchCT = new javax.swing.JButton();
        JTFSalario = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        JDCFechaContra = new com.toedter.calendar.JDateChooser();
        jScrollPane2 = new javax.swing.JScrollPane();
        JTableEmpleado = new javax.swing.JTable();

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
        setTitle("EMPLEADOS");
        setMinimumSize(new java.awt.Dimension(116, 33));
        setPreferredSize(new java.awt.Dimension(995, 625));

        jSplitPane2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jSplitPane2.setDividerLocation(220);

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Empleados"));

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
        jLabel9.setText("Cédula del Empleado:");

        JTFCedulaBuscador.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        JTFCedulaBuscador.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                JTFCedulaBuscadorKeyReleased(evt);
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
                .addComponent(JTFCedulaBuscador, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(JTFCedulaBuscador, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                .addContainerGap(114, Short.MAX_VALUE))
        );

        jSplitPane2.setLeftComponent(jPanel2);

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos Empleado"));

        jLabel1.setText("NÚMERO DE CÉDULA:");

        jLabel2.setText("CENTRO DE TRABAJO:");

        jLabel3.setText("DEPARTAMENTO:");

        jLabel4.setText("NOMBRE Y APELLIDO:");

        jLabel5.setText("NÚMERO DE HIJOS:");

        jLabel6.setText("TELÉFONO:");

        JTFNomApeEmp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JTFNomApeEmpActionPerformed(evt);
            }
        });

        JTFNumHijos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JTFNumHijosActionPerformed(evt);
            }
        });

        JTFNumCedEmp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JTFNumCedEmpActionPerformed(evt);
            }
        });

        JTFTelef.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JTFTelefActionPerformed(evt);
            }
        });

        JBSearchDep.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/iconfinder_Searchicons-search-people2_825453.png"))); // NOI18N
        JBSearchDep.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBSearchDepActionPerformed(evt);
            }
        });

        JBSearchCT.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/iconfinder_Searchicons-search-people2_825453.png"))); // NOI18N
        JBSearchCT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBSearchCTActionPerformed(evt);
            }
        });

        JTFSalario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JTFSalarioActionPerformed(evt);
            }
        });

        jLabel7.setText("SALARIO:");

        jLabel8.setText("FECHA DE CONTRATO:");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(JTFNumCedEmp)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(JTFSalario, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 193, Short.MAX_VALUE)
                                .addComponent(JTFTelef, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(JTFNumHijos, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(JTFNomApeEmp, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(JTFNomCT, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(JTFNomDep, javax.swing.GroupLayout.Alignment.LEADING))
                            .addGap(18, 18, 18)
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(JBSearchCT, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(JBSearchDep, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addComponent(JDCFechaContra, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(252, 252, 252))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(JTFNumCedEmp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(JBSearchCT, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(JTFNomCT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))))
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(JTFNomDep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(JBSearchDep, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JTFNomApeEmp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JTFNumHijos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JTFTelef, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JTFSalario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(JDCFechaContra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jScrollPane2.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        jScrollPane2.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        JTableEmpleado.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane2.setViewportView(JTableEmpleado);

        javax.swing.GroupLayout JPanelPrincipalLayout = new javax.swing.GroupLayout(JPanelPrincipal);
        JPanelPrincipal.setLayout(JPanelPrincipalLayout);
        JPanelPrincipalLayout.setHorizontalGroup(
            JPanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JPanelPrincipalLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(JPanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );
        JPanelPrincipalLayout.setVerticalGroup(
            JPanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JPanelPrincipalLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 210, Short.MAX_VALUE)
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

        this.JTFNomApeEmp.setEnabled(true);
        JTFNomCT.setEnabled(true);
        this.JTFNomCT.setEditable(false);
        JTFNomDep.setEnabled(true);
        this.JTFNomDep.setEditable(false);
        this.JTFNumCedEmp.setEnabled(true);
        this.JTFNumHijos.setEnabled(true);
        this.JTFTelef.setEnabled(true);
        this.JBSearchDep.setEnabled(true);
        this.JTFSalario.setEnabled(true);
        this.JDCFechaContra.setEnabled(true);
        this.JBSearchCT.setEnabled(true);

        this.JTFNumCedEmp.requestFocus();
    }//GEN-LAST:event_JBNuevoRegActionPerformed

    private void JTFNomApeEmpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JTFNomApeEmpActionPerformed
        this.JTFNomApeEmp.transferFocus();
    }//GEN-LAST:event_JTFNomApeEmpActionPerformed

    private void JTFNumHijosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JTFNumHijosActionPerformed
        this.JTFNumHijos.transferFocus();
    }//GEN-LAST:event_JTFNumHijosActionPerformed

    private void JBGuardarCambiosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBGuardarCambiosActionPerformed
        //Opcion Guardar Empleado
        if (auxiliarBoton == 1) {
            int numCed = Integer.parseInt(this.JTFNumCedEmp.getText());
            int centroTrabajo = this.sucursal;
            int depCodigo = Integer.parseInt(this.JTFNomDep.getText());
            String nombreEmp = this.JTFNomApeEmp.getText();
            int numHijos = Integer.parseInt(this.JTFNumHijos.getText());
            int telefono = Integer.parseInt(this.JTFTelef.getText());
            float salario = Float.parseFloat(this.JTFSalario.getText());
            Date date = JDCFechaContra.getDate();//Se crea un objeto del tipo date y se extrae del jCalendar
            SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");//Se le da un formato de la base de datos
            String fechaContrato = formato.format(date);//Se guarda como String y se le da el formato de arriba 

            Empleado empleado = new Empleado(numCed, depCodigo, depCodigo, nombreEmp, numHijos, telefono, salario, fechaContrato);
            //Cuando el usuario verifica que SI desea guardar al Empleado
            if (empleado.guardarEmpleado(cn)) {
                this.opcionAgain();
                cargar("");
                //Cuando el usuario verifica que NO desea guardar al Empleado   
            } else {
                this.opcionAgain();
                cargar("");
            }
        } else {//AuxBoton = 2 es decir modificar empleado
            //Opcion de modificar Empleado
            int numCed = Integer.parseInt(this.JTFNumCedEmp.getText());
            int centroTrabajo = Integer.parseInt(this.JTFNomCT.getText());
            int depCodigo = Integer.parseInt(this.JTFNomDep.getText());
            String nombreEmp = this.JTFNomApeEmp.getText();
            int numHijos = Integer.parseInt(this.JTFNumHijos.getText());
            int telefono = Integer.parseInt(this.JTFTelef.getText());
            float salario = Float.parseFloat(this.JTFSalario.getText());
            Date date = JDCFechaContra.getDate();//Se crea un objeto del tipo date y se extrae del jCalendar
            SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");//Se le da un formato de la base de datos
            String fechaContrato = formato.format(date);//Se guarda como String y se le da el formato de arriba 
            
            Empleado empleado = new Empleado(numCed, depCodigo, depCodigo, nombreEmp, numHijos, telefono, salario, fechaContrato);
            //Cuando el usuario verifica que SI desea guardar al Empleado
            if (empleado.modificarEmpleado(numCed, cn)) {
                this.JTFNomCT.setEditable(true);
                this.JTFNomDep.setEditable(true);
                this.JTFNumCedEmp.setEditable(true);
                this.opcionAgain();
                cargar("");
                //Cuando el usuario verifica que NO desea guardar al Empleado   
            } else {
                this.opcionAgain();
                cargar("");
            }
        }
    }//GEN-LAST:event_JBGuardarCambiosActionPerformed

    private void JBCancelarCambiosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBCancelarCambiosActionPerformed
        opcionAgain();
    }//GEN-LAST:event_JBCancelarCambiosActionPerformed

    private void JBBorrarRegActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBBorrarRegActionPerformed
        int fila = JTableEmpleado.getSelectedRow();
        if (fila >= 0) {
            //Activando cajas de texto y botones
            int valor = Integer.parseInt(JTableEmpleado.getValueAt(fila, 0).toString());

            this.JBNuevoReg.setEnabled(false);
            this.JBModificarReg.setEnabled(false);
            this.JBBorrarReg.setEnabled(false);

            this.JBGuardarCambios.setEnabled(false);
            this.JBCancelarCambios.setEnabled(false);
            this.JTFCedulaBuscador.setEnabled(true);
            this.JTFNomApeEmp.setEnabled(false);
            this.JTFNomCT.setEnabled(false);
            this.JTFNomDep.setEnabled(false);
            this.JTFNumCedEmp.setEnabled(false);
            this.JTFNumHijos.setEnabled(false);
            this.JTFTelef.setEnabled(false);
            this.JBSearchDep.setEnabled(true);
            this.JTFSalario.setEnabled(false);
            this.JDCFechaContra.setEnabled(false);
            this.JBSearchCT.setEnabled(false);

            //Pasando datos de la tabla a cada caja de texto
            this.JTFNumCedEmp.setText(JTableEmpleado.getValueAt(fila, 0).toString());
            this.JTFNomCT.setText(JTableEmpleado.getValueAt(fila, 1).toString());
            this.JTFNomDep.setText(JTableEmpleado.getValueAt(fila, 2).toString());
            this.JTFNomApeEmp.setText(JTableEmpleado.getValueAt(fila, 3).toString());
            this.JTFNumHijos.setText(JTableEmpleado.getValueAt(fila, 4).toString());
            this.JTFTelef.setText(JTableEmpleado.getValueAt(fila, 5).toString());
            this.JTFSalario.setText(JTableEmpleado.getValueAt(fila, 6).toString());
            SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
            try {
                Date fecha = formato.parse(JTableEmpleado.getValueAt(fila, 7).toString());
                this.JDCFechaContra.setDate(fecha);
            } catch (ParseException e) {
                // Error, la cadena de texto no se puede convertir en fecha.
                System.out.println(e);
            }
            
            this.JTFCedulaBuscador.setText("");

            if (Empleado.eliminarEmpleado(valor, cn)) {
                cargar("");
                this.JTFCedulaBuscador.setText("");
                this.opcionAgain();
            } else {
                this.opcionAgain();
                this.JTFCedulaBuscador.setText("");
                cargar("");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Por favor seleccione un REGISTRO.", "Mensaje", JOptionPane.DEFAULT_OPTION);
        }
    }//GEN-LAST:event_JBBorrarRegActionPerformed

    private void JTFCedulaBuscadorKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JTFCedulaBuscadorKeyReleased
        cargar(this.JTFCedulaBuscador.getText());
    }//GEN-LAST:event_JTFCedulaBuscadorKeyReleased

    private void JBModificarRegActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBModificarRegActionPerformed
        auxiliarBoton = 2;
        int fila = JTableEmpleado.getSelectedRow();
        if (fila >= 0) {
            //Activando cajas de texto y botones
            this.JBNuevoReg.setEnabled(false);
            this.JBModificarReg.setEnabled(false);
            this.JBBorrarReg.setEnabled(false);

            this.JBGuardarCambios.setEnabled(true);
            this.JBCancelarCambios.setEnabled(true);
            this.JTFCedulaBuscador.setEnabled(true);
            this.JTFNomApeEmp.setEnabled(true);
            this.JTFNomCT.setEditable(false);
            this.JTFNomDep.setEditable(false);
            this.JTFNumCedEmp.setEditable(false);
            this.JBSearchCT.setEnabled(true);
            this.JTFNumHijos.setEnabled(true);
            this.JTFTelef.setEnabled(true);
            this.JBSearchDep.setEnabled(true);
            this.JTFSalario.setEnabled(true);
            this.JDCFechaContra.setEnabled(true);
            

            //Pasando datos de la tabla a cada caja de texto
            this.JTFNumCedEmp.setText(JTableEmpleado.getValueAt(fila, 0).toString());
            this.JTFNomCT.setText(JTableEmpleado.getValueAt(fila, 1).toString());
            this.JTFNomDep.setText(JTableEmpleado.getValueAt(fila, 2).toString());
            this.JTFNomApeEmp.setText(JTableEmpleado.getValueAt(fila, 3).toString());
            this.JTFNumHijos.setText(JTableEmpleado.getValueAt(fila, 4).toString());
            this.JTFTelef.setText(JTableEmpleado.getValueAt(fila, 5).toString());
            this.JTFSalario.setText(JTableEmpleado.getValueAt(fila, 6).toString());
            SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
            try {
                Date fecha = formato.parse(JTableEmpleado.getValueAt(fila, 7).toString());
                this.JDCFechaContra.setDate(fecha);
            } catch (ParseException e) {
                // Error, la cadena de texto no se puede convertir en fecha.
                System.out.println(e);
            }

            this.JTFCedulaBuscador.setText("");
        } else {
            JOptionPane.showMessageDialog(null, "Por favor seleccione un REGISTRO.", "Mensaje", JOptionPane.DEFAULT_OPTION);
        }
    }//GEN-LAST:event_JBModificarRegActionPerformed

    private void JTFNumCedEmpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JTFNumCedEmpActionPerformed
        if (Empleado.verificarNumCedula(this.JTFNumCedEmp.getText())) {
            this.JTFNumCedEmp.transferFocus();
        } else {
            this.JTFNumCedEmp.setText("");
            this.JTFNumCedEmp.requestFocus();
        }
    }//GEN-LAST:event_JTFNumCedEmpActionPerformed

    private void JBSearchDepActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBSearchDepActionPerformed
        JFListaDep jdDep = new JFListaDep();
        jdDep.setAux(this.sucursal);
        jdDep.setVisible(true);
    }//GEN-LAST:event_JBSearchDepActionPerformed

    private void JTFTelefActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JTFTelefActionPerformed
        this.JTFTelef.transferFocus();
    }//GEN-LAST:event_JTFTelefActionPerformed

    private void JTFSalarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JTFSalarioActionPerformed
        this.JTFSalario.transferFocus();
    }//GEN-LAST:event_JTFSalarioActionPerformed

    private void JBSearchCTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBSearchCTActionPerformed
        JFListaCT jdCT = new JFListaCT();
        jdCT.setAux(this.sucursal);
        jdCT.setVisible(true);
    }//GEN-LAST:event_JBSearchCTActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton JBBorrarReg;
    private javax.swing.JButton JBCancelarCambios;
    private javax.swing.JButton JBGuardarCambios;
    private javax.swing.JButton JBModificarReg;
    private javax.swing.JButton JBNuevoReg;
    private javax.swing.JButton JBSearchCT;
    private javax.swing.JButton JBSearchDep;
    private com.toedter.calendar.JDateChooser JDCFechaContra;
    private javax.swing.JPanel JPanelPrincipal;
    private javax.swing.JTextField JTFCedulaBuscador;
    private javax.swing.JTextField JTFNomApeEmp;
    public static javax.swing.JTextField JTFNomCT;
    public static javax.swing.JTextField JTFNomDep;
    private javax.swing.JTextField JTFNumCedEmp;
    private javax.swing.JTextField JTFNumHijos;
    private javax.swing.JTextField JTFSalario;
    private javax.swing.JTextField JTFTelef;
    public static javax.swing.JTable JTableEmpleado;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
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
