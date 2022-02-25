package Interfaz;

import Fuentes.CentroDeTrabajo;
import Fuentes.Conexion;
import java.awt.event.KeyEvent;
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
public class JFInCT extends javax.swing.JInternalFrame {

    DefaultTableModel model;//Modifica un objeto del tipo jtable
    Conexion cc;
    Connection cn;
    private int auxiliarBoton;
    private int sucursal;

    public JFInCT(int aux) {
        initComponents();
        this.JBGuardarCambios.setEnabled(false);
        this.JBCancelarCambios.setEnabled(false);

        this.JTFCodCentro.setEnabled(false);
        this.JTFDireccion.setEnabled(false);
        this.JTFNomCT.setEnabled(false);
        this.JTFNumCedulaJefe.setEnabled(false);
        this.JTFNumPob.setEnabled(false);
        this.JBSearchJefe.setEnabled(false);
        cc = new Conexion();
        cn = cc.getConexion(aux);
        this.sucursal = aux;
        cargar("");
    }

    //Se extrae lo que tenemos en la base de datos de la tabla CENTRO_DE_TRABAJO
    public void cargar(String valor) {
        //Titulos de cada Cl y Fl
        String[] titulos = {"CÓDIGO CENTRO", "NÚM. JEFE CÉDULA", "NOMBRE CENTRO", "NÚM. POBLACIÓN", "DIRECCIÓN"};
        String[] registros = new String[5];

        String querry = "SELECT * FROM CENTRO_DE_TRABAJO where CT_CODIGO LIKE '%" + valor + "%'";
        model = new DefaultTableModel(null, titulos);// Le damos el formato

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(querry);

            while (rs.next()) {
                //Se da la informacion a cada columna que se extrae de rs
                registros[0] = rs.getString("CT_CODIGO");
                registros[1] = rs.getString("JEFE_CEDULA");
                registros[2] = rs.getString("CT_NOMBRE");
                registros[3] = rs.getString("CT_POBLACION");
                registros[4] = rs.getString("CT_DIRECCION");

                model.addRow(registros);//Se ingresa la informacion al model
            }
            JTableCT.setModel(model);//Seteamos la tabla con los datos 
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

        this.JTFCodCentro.setEnabled(false);
        this.JTFDireccion.setEnabled(false);
        this.JTFNomCT.setEnabled(false);
        this.JTFNumCedulaJefe.setEnabled(false);
        this.JTFNumPob.setEnabled(false);
        this.JBSearchJefe.setEnabled(false);

        this.JTFCodBuscador.setText("");
        this.JTFCodCentro.setText("");
        this.JTFDireccion.setText("");
        this.JTFNomCT.setText("");
        this.JTFNumCedulaJefe.setText("");
        this.JTFNumPob.setText("");

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
        JTFNomCT = new javax.swing.JTextField();
        JTFNumPob = new javax.swing.JTextField();
        JTFCodCentro = new javax.swing.JTextField();
        JTFNumCedulaJefe = new javax.swing.JTextField();
        JBSearchJefe = new javax.swing.JButton();
        JTFDireccion = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        JTableCT = new javax.swing.JTable();

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
        setTitle("CENTRO DE TRABAJO");
        setMinimumSize(new java.awt.Dimension(116, 33));
        setPreferredSize(new java.awt.Dimension(995, 625));

        jSplitPane2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jSplitPane2.setDividerLocation(220);

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Centro de Trabajo"));

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
                    .addComponent(JBNuevoReg, javax.swing.GroupLayout.DEFAULT_SIZE, 175, Short.MAX_VALUE)
                    .addComponent(JBModificarReg, javax.swing.GroupLayout.DEFAULT_SIZE, 175, Short.MAX_VALUE)
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
        jLabel9.setText("Código Centro de Trabajo:");

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

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos Centro de Trabajo"));

        jLabel1.setText("CÓDIGO CENTRO:");

        jLabel2.setText("NUM. CÉDULA JEFE:");

        jLabel3.setText("NOMBRE DEL CENTRO:");

        jLabel4.setText("NUM. POBLACIÓN:");

        jLabel5.setText("DIRECCIÓN:");

        JTFNomCT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JTFNomCTActionPerformed(evt);
            }
        });

        JTFNumPob.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JTFNumPobActionPerformed(evt);
            }
        });

        JBSearchJefe.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/iconfinder_Searchicons-search-people2_825453.png"))); // NOI18N
        JBSearchJefe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBSearchJefeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addGap(51, 51, 51)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(JTFCodCentro)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(JTFNumCedulaJefe, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(JTFNomCT, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                        .addComponent(JBSearchJefe, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(JTFDireccion)
                    .addComponent(JTFNumPob))
                .addContainerGap(275, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(JTFCodCentro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(JTFNumCedulaJefe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(JBSearchJefe, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(33, 33, 33)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(JTFNomCT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(25, 25, 25)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JTFNumPob, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JTFDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(0, 14, Short.MAX_VALUE))
        );

        jScrollPane2.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        jScrollPane2.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        JTableCT.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane2.setViewportView(JTableCT);

        javax.swing.GroupLayout JPanelPrincipalLayout = new javax.swing.GroupLayout(JPanelPrincipal);
        JPanelPrincipal.setLayout(JPanelPrincipalLayout);
        JPanelPrincipalLayout.setHorizontalGroup(
            JPanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JPanelPrincipalLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(JPanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 717, Short.MAX_VALUE))
                .addContainerGap())
        );
        JPanelPrincipalLayout.setVerticalGroup(
            JPanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JPanelPrincipalLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 270, Short.MAX_VALUE)
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

        this.JTFCodCentro.setEnabled(true);
        JTFNumCedulaJefe.setEnabled(true);
        JTFNumCedulaJefe.setEditable(false);
        this.JTFNomCT.setEnabled(true);
        this.JTFNumPob.setEnabled(true);
        this.JTFDireccion.setEnabled(true);
        this.JBSearchJefe.setEnabled(true);

    }//GEN-LAST:event_JBNuevoRegActionPerformed

    private void JTFNumPobActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JTFNumPobActionPerformed
        this.JTFNumPob.transferFocus();
    }//GEN-LAST:event_JTFNumPobActionPerformed

    private void JBGuardarCambiosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBGuardarCambiosActionPerformed
        int CT_Codigo = Integer.parseInt(this.JTFCodCentro.getText());
        int jefCedula = Integer.parseInt(JTFNumCedulaJefe.getText());
        String nombre = this.JTFNomCT.getText();
        int numPoblacion = Integer.parseInt(this.JTFNumPob.getText());
        String direccion = this.JTFDireccion.getText();

        CentroDeTrabajo ct = new CentroDeTrabajo(CT_Codigo, jefCedula, nombre, numPoblacion, direccion);

        //Opcion Guardar Empleado
        if (auxiliarBoton == 1) {
            //Cuando el usuario verifica que SI desea guardar al Empleado
            if (ct.guardarCT(cn)) {
                this.opcionAgain();
                cargar("");
                //Cuando el usuario verifica que NO desea guardar al Empleado   
            } else {
                this.opcionAgain();
                cargar("");
            }
        } else {//AuxBoton = 2 es decir modificar empleado
            //Cuando el usuario verifica que SI desea guardar al Empleado
            if (ct.modificarCT(CT_Codigo, cn)) {
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
        auxiliarBoton = 2;
        int fila = JTableCT.getSelectedRow();
        if (fila >= 0) {
            int valor = Integer.parseInt(JTableCT.getValueAt(fila, 0).toString());
            //Activando cajas de texto y botones
            this.JBNuevoReg.setEnabled(false);
            this.JBModificarReg.setEnabled(false);
            this.JBBorrarReg.setEnabled(false);

            this.JBGuardarCambios.setEnabled(false);
            this.JBCancelarCambios.setEnabled(false);
            this.JTFNumPob.setEnabled(false);
            this.JTFDireccion.setEnabled(false);

            //Pasando datos de la tabla a cada caja de texto
            this.JTFCodCentro.setText(JTableCT.getValueAt(fila, 0).toString());
            JTFNumCedulaJefe.setText(JTableCT.getValueAt(fila, 1).toString());
            this.JTFNomCT.setText(JTableCT.getValueAt(fila, 2).toString());
            this.JTFNumPob.setText(JTableCT.getValueAt(fila, 3).toString());
            this.JTFDireccion.setText(JTableCT.getValueAt(fila, 4).toString());

            if (CentroDeTrabajo.eliminarCT(valor, cn)) {
                cargar("");
                this.JTFCodBuscador.setText("");
                this.opcionAgain();
            } else {
                this.opcionAgain();
                this.JTFCodBuscador.setText("");
                cargar("");
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
        int fila = JTableCT.getSelectedRow();
        if (fila >= 0) {
            //Activando cajas de texto y botones
            this.JBNuevoReg.setEnabled(false);
            this.JBModificarReg.setEnabled(false);
            this.JBBorrarReg.setEnabled(false);

            this.JBGuardarCambios.setEnabled(true);
            this.JBCancelarCambios.setEnabled(true);
            this.JTFNomCT.setEnabled(true);
            this.JTFNumPob.setEnabled(true);
            this.JTFDireccion.setEnabled(true);
            this.JBSearchJefe.setEnabled(true);

            //Pasando datos de la tabla a cada caja de texto
            this.JTFCodCentro.setText(JTableCT.getValueAt(fila, 0).toString());
            JTFNumCedulaJefe.setText(JTableCT.getValueAt(fila, 1).toString());
            this.JTFNomCT.setText(JTableCT.getValueAt(fila, 2).toString());
            this.JTFNumPob.setText(JTableCT.getValueAt(fila, 3).toString());
            this.JTFDireccion.setText(JTableCT.getValueAt(fila, 4).toString());

            this.JTFCodBuscador.setText("");
        } else {
            JOptionPane.showMessageDialog(null, "Por favor seleccione un REGISTRO.", "Mensaje", JOptionPane.DEFAULT_OPTION);
        }
    }//GEN-LAST:event_JBModificarRegActionPerformed

    private void JBSearchJefeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBSearchJefeActionPerformed
        JFListaEmpleados lista = new JFListaEmpleados();
        lista.setAux(this.sucursal);
        lista.setVisible(true);
    }//GEN-LAST:event_JBSearchJefeActionPerformed

    private void JTFNomCTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JTFNomCTActionPerformed
        this.JTFNomCT.transferFocus();
    }//GEN-LAST:event_JTFNomCTActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton JBBorrarReg;
    private javax.swing.JButton JBCancelarCambios;
    private javax.swing.JButton JBGuardarCambios;
    private javax.swing.JButton JBModificarReg;
    private javax.swing.JButton JBNuevoReg;
    private javax.swing.JButton JBSearchJefe;
    private javax.swing.JPanel JPanelPrincipal;
    private javax.swing.JTextField JTFCodBuscador;
    private javax.swing.JTextField JTFCodCentro;
    private javax.swing.JTextField JTFDireccion;
    private javax.swing.JTextField JTFNomCT;
    public static javax.swing.JTextField JTFNumCedulaJefe;
    private javax.swing.JTextField JTFNumPob;
    public static javax.swing.JTable JTableCT;
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
