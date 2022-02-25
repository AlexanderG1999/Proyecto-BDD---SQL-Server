package Interfaz;

import Fuentes.Conexion;
import Fuentes.Departamento;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author GRUPO 4
 */
public class JFInDepartamento extends javax.swing.JInternalFrame {

    DefaultTableModel model;//Modifica un objeto del tipo jtable
    Conexion cc;
    Connection cn;
    private int auxiliarBoton;
    private int sucursal;

    public JFInDepartamento(int aux) {
        initComponents();
        this.JBGuardarCambios.setEnabled(false);
        this.JBCancelarCambios.setEnabled(false);

        this.JTFCodCT.setEnabled(false);
        this.JTFCodDep.setEnabled(false);
        this.JTFNomDep.setEnabled(false);
        this.JTFPresupAnual.setEnabled(false);
        cc = new Conexion();
        cn = cc.getConexion(aux);
        this.sucursal = aux;
        cargar("");
    }

    //Se extrae lo que tenemos en la base de datos de la tabla DEPARTAMENTO
    public void cargar(String valor) {
        //Titulos de cada Cl y Fl
        String[] titulos = {"CÓDIGO DEPARTAMENTO", "CÓDIGO CENTRO", "NOMBRE DEPARTAMENTO", "PRESUPUESTO ANUAL"};
        String[] registros = new String[4];

        String querry = "SELECT * FROM departamento where DEP_CODIGO LIKE '%" + valor + "%'";
        model = new DefaultTableModel(null, titulos);// Le damos el formato

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(querry);

            while (rs.next()) {
                //Se da la informacion a cada columna que se extrae de rs
                registros[0] = rs.getString("DEP_CODIGO");
                registros[1] = rs.getString("CT_CODIGO");
                registros[2] = rs.getString("DEP_NOMBRE");
                registros[3] = rs.getString("DEP_PRESUPANUAL");

                model.addRow(registros);//Se ingresa la informacion al model
            }
            JTableDep.setModel(model);//Seteamos la tabla con los datos 
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

        this.JTFCodCT.setEnabled(false);
        this.JTFCodDep.setEnabled(false);
        this.JTFNomDep.setEnabled(false);
        this.JTFPresupAnual.setEnabled(false);

        this.JTFCodBuscador.setText("");
        this.JTFPresupAnual.setText("");
        this.JTFNomDep.setText("");
        this.JTFCodDep.setText("");
        this.JTFCodCT.setText("");
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
        JTFPresupAnual = new javax.swing.JTextField();
        JTFCodDep = new javax.swing.JTextField();
        JTFNomDep = new javax.swing.JTextField();
        JTFCodCT = new javax.swing.JTextField();
        JBSearchCodCT = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        JTableDep = new javax.swing.JTable();

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
        setTitle("DEPARTAMENTO");
        setMinimumSize(new java.awt.Dimension(116, 33));
        setPreferredSize(new java.awt.Dimension(995, 625));

        jSplitPane2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jSplitPane2.setDividerLocation(235);
        jSplitPane2.setToolTipText("");

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Departamento"));

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
                    .addComponent(JBModificarReg, javax.swing.GroupLayout.DEFAULT_SIZE, 190, Short.MAX_VALUE)
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
        jLabel9.setText("Código Departamento:");

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
                .addGap(64, 64, 64)
                .addComponent(JTFCodBuscador, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                .addComponent(JTFCodBuscador, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(155, Short.MAX_VALUE))
        );

        jSplitPane2.setLeftComponent(jPanel2);

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos Departamento"));

        jLabel1.setText("CÓDIGO DEPARTAMENTO:");

        jLabel2.setText("CÓDIGO CENTRO DE TRABAJO:");

        jLabel3.setText("NOMBRE DEPARTAMENTO:");

        jLabel4.setText("PRESUPUESTO ANUAL:");

        JTFPresupAnual.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JTFPresupAnualActionPerformed(evt);
            }
        });

        JBSearchCodCT.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/iconfinder_Searchicons-search-people2_825453.png"))); // NOI18N
        JBSearchCodCT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBSearchCodCTActionPerformed(evt);
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
                    .addComponent(jLabel4)
                    .addComponent(jLabel2))
                .addGap(51, 51, 51)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(JTFNomDep)
                    .addComponent(JTFCodDep)
                    .addComponent(JTFPresupAnual, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(JTFCodCT, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(JBSearchCodCT, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(261, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(JTFCodDep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(JTFCodCT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)))
                    .addComponent(JBSearchCodCT, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JTFNomDep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JTFPresupAnual, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addContainerGap(31, Short.MAX_VALUE))
        );

        jScrollPane2.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        jScrollPane2.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        JTableDep.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane2.setViewportView(JTableDep);

        javax.swing.GroupLayout JPanelPrincipalLayout = new javax.swing.GroupLayout(JPanelPrincipal);
        JPanelPrincipal.setLayout(JPanelPrincipalLayout);
        JPanelPrincipalLayout.setHorizontalGroup(
            JPanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JPanelPrincipalLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(JPanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 702, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        JPanelPrincipalLayout.setVerticalGroup(
            JPanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JPanelPrincipalLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 308, Short.MAX_VALUE)
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

        this.JTFCodCT.setEnabled(true);
        this.JTFNomDep.setEnabled(true);
        this.JTFCodDep.setEnabled(true);
        this.JTFPresupAnual.setEnabled(true);
        this.JBSearchCodCT.setEnabled(true);

    }//GEN-LAST:event_JBNuevoRegActionPerformed

    private void JTFPresupAnualActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JTFPresupAnualActionPerformed

    }//GEN-LAST:event_JTFPresupAnualActionPerformed

    private void JBGuardarCambiosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBGuardarCambiosActionPerformed
        int DEP_Codigo = Integer.parseInt(this.JTFCodDep.getText());
        int CT_Codigo = Integer.parseInt(this.JTFCodCT.getText());
        String DEP_nombre = this.JTFNomDep.getText();
        float DEP_PresupAnual = Float.parseFloat(this.JTFPresupAnual.getText());

        Departamento dt = new Departamento(DEP_Codigo, CT_Codigo, DEP_nombre, DEP_PresupAnual);
        //Opcion Guardar Empleado
        if (auxiliarBoton == 1) {
            //Cuando el usuario verifica que SI desea guardar al Empleado
            if (dt.guardarDepartamento(cn)) {
                this.opcionAgain();
                cargar("");
                //Cuando el usuario verifica que NO desea guardar al Empleado   
            } else {
                this.opcionAgain();
                cargar("");
            }
        } else {//AuxBoton = 2 es decir modificar empleado
            //Cuando el usuario verifica que SI desea guardar al Empleado
            if (dt.modificarDepartamento(CT_Codigo, cn)) {
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
        int fila = JTableDep.getSelectedRow();
        if (fila >= 0) {
            int valor = Integer.parseInt(JTableDep.getValueAt(fila, 0).toString());
            //Activando cajas de texto y botones
            this.JBNuevoReg.setEnabled(false);
            this.JBModificarReg.setEnabled(false);
            this.JBBorrarReg.setEnabled(false);

            this.JBGuardarCambios.setEnabled(false);
            this.JBCancelarCambios.setEnabled(false);

            this.JTFCodCT.setEnabled(false);
            this.JTFCodDep.setEnabled(false);
            this.JTFNomDep.setEnabled(false);
            this.JTFPresupAnual.setEnabled(false);

            //Pasando datos de la tabla a cada caja de texto
            this.JTFCodDep.setText(JTableDep.getValueAt(fila, 0).toString());
            this.JTFCodCT.setText(JTableDep.getValueAt(fila, 1).toString());
            this.JTFNomDep.setText(JTableDep.getValueAt(fila, 2).toString());
            this.JTFPresupAnual.setText(JTableDep.getValueAt(fila, 3).toString());

            if (Departamento.eliminarDepartamento(valor, cn)) {
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
        int fila = JTableDep.getSelectedRow();
        if (fila >= 0) {
            //Activando cajas de texto y botones
            this.JBNuevoReg.setEnabled(false);
            this.JBModificarReg.setEnabled(false);
            this.JBBorrarReg.setEnabled(false);

            this.JBGuardarCambios.setEnabled(false);
            this.JBCancelarCambios.setEnabled(false);

            this.JTFCodCT.setEnabled(false);
            this.JTFCodDep.setEnabled(false);
            this.JTFNomDep.setEnabled(true);
            this.JTFPresupAnual.setEnabled(true);

            //Pasando datos de la tabla a cada caja de texto
             this.JTFCodDep.setText(JTableDep.getValueAt(fila, 0).toString());
            this.JTFCodCT.setText(JTableDep.getValueAt(fila, 1).toString());
            this.JTFNomDep.setText(JTableDep.getValueAt(fila, 2).toString());
            this.JTFPresupAnual.setText(JTableDep.getValueAt(fila, 3).toString());

            this.JTFCodBuscador.setText("");
        } else {
            JOptionPane.showMessageDialog(null, "Por favor seleccione un REGISTRO.", "Mensaje", JOptionPane.DEFAULT_OPTION);
        }
    }//GEN-LAST:event_JBModificarRegActionPerformed

    private void JBSearchCodCTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBSearchCodCTActionPerformed
        JFListaDep lista = new JFListaDep();
        lista.setAux(this.sucursal);
        lista.setVisible(true);
    }//GEN-LAST:event_JBSearchCodCTActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton JBBorrarReg;
    private javax.swing.JButton JBCancelarCambios;
    private javax.swing.JButton JBGuardarCambios;
    private javax.swing.JButton JBModificarReg;
    private javax.swing.JButton JBNuevoReg;
    private javax.swing.JButton JBSearchCodCT;
    private javax.swing.JPanel JPanelPrincipal;
    private javax.swing.JTextField JTFCodBuscador;
    public static javax.swing.JTextField JTFCodCT;
    private javax.swing.JTextField JTFCodDep;
    private javax.swing.JTextField JTFNomDep;
    private javax.swing.JTextField JTFPresupAnual;
    public static javax.swing.JTable JTableDep;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
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
