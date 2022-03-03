package Interfaz;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;

/**
 *
 * @author GRUPO 4
 */
public class JFMenuPrincipal extends javax.swing.JFrame {
    
    JFInEmpleado jfEmpleado;
    JFInArea jfArea;
    JFInCT jfCT;
    JFInDepartamento jfDep;
    JFInExperiencia jfExp;
    JFInHijo jfHijo;
    
    public JFMenuPrincipal() {
        initComponents();
        setIconImage(new ImageIcon(getClass().getResource("/Imagenes/epn.png")).getImage());
        this.setExtendedState(MAXIMIZED_BOTH);
        
        if (!getHostname()) { //Se verifica el usuario que ingresa
            this.JBCT.setEnabled(false);
            this.JBArea.setEnabled(false);
        }
    }

    /*Funcion para verificar si el usuario que ingresa es ALEXANDER para activar las tablas
    CENTRO_DE_TRABAJO y AREA dado que ALEXANDER es el distribuidor de esa replicacion unidireccional*/
    public boolean getHostname() {
        String hostname = "";
        String cmd = "hostname"; //Conocer en que PC se esta ejecutando

        try {
            Process p;
            p = Runtime.getRuntime().exec(cmd);
            BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()));

            //Resultado comando Hostname
            hostname = br.readLine();
            
            p.waitFor();
            p.destroy();
            
        } catch (InterruptedException ex) {
            Logger.getLogger(JFMenuPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(JFMenuPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        if (hostname.equalsIgnoreCase("ALEXANDER")) {
            return true;
        } else {
            return false;
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        JBSalir = new javax.swing.JButton();
        JEscritorio = new javax.swing.JDesktopPane();
        JBEmpleado = new javax.swing.JButton();
        JBCT = new javax.swing.JButton();
        JBDep = new javax.swing.JButton();
        JBArea = new javax.swing.JButton();
        JBHijos = new javax.swing.JButton();
        JBExp = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("CENTRO DE DESARROLLO A.M.A");

        JBSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/exit.png"))); // NOI18N
        JBSalir.setText("Salir");
        JBSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBSalirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout JEscritorioLayout = new javax.swing.GroupLayout(JEscritorio);
        JEscritorio.setLayout(JEscritorioLayout);
        JEscritorioLayout.setHorizontalGroup(
            JEscritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 876, Short.MAX_VALUE)
        );
        JEscritorioLayout.setVerticalGroup(
            JEscritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        JBEmpleado.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/employees.png"))); // NOI18N
        JBEmpleado.setText("Empleado");
        JBEmpleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBEmpleadoActionPerformed(evt);
            }
        });

        JBCT.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/business-center.png"))); // NOI18N
        JBCT.setText("Centro de Trabajo");
        JBCT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBCTActionPerformed(evt);
            }
        });

        JBDep.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/department.png"))); // NOI18N
        JBDep.setText("Departamento");
        JBDep.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBDepActionPerformed(evt);
            }
        });

        JBArea.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/remote-access.png"))); // NOI18N
        JBArea.setText("Área");
        JBArea.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBAreaActionPerformed(evt);
            }
        });

        JBHijos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/father-and-son.png"))); // NOI18N
        JBHijos.setText("Hijos");
        JBHijos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBHijosActionPerformed(evt);
            }
        });

        JBExp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/expert.png"))); // NOI18N
        JBExp.setText("Experiencia");
        JBExp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBExpActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(JBEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JBSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JBArea, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JBDep, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JBCT, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JBHijos, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JBExp, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(JEscritorio)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(JEscritorio)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(JBEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(JBHijos, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(JBCT, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(JBDep, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(JBArea, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(JBExp, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(JBSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 68, Short.MAX_VALUE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void JBSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBSalirActionPerformed
        System.exit(0);
    }//GEN-LAST:event_JBSalirActionPerformed

    private void JBEmpleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBEmpleadoActionPerformed
        jfEmpleado = new JFInEmpleado();
        this.JEscritorio.removeAll();
        this.JEscritorio.repaint();
        JEscritorio.add(jfEmpleado);
        jfEmpleado.show();
    }//GEN-LAST:event_JBEmpleadoActionPerformed

    private void JBHijosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBHijosActionPerformed
        jfHijo = new JFInHijo();
        this.JEscritorio.removeAll();
        this.JEscritorio.repaint();
        JEscritorio.add(jfHijo);
        jfHijo.show();
    }//GEN-LAST:event_JBHijosActionPerformed

    private void JBCTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBCTActionPerformed
        jfCT = new JFInCT();
        this.JEscritorio.removeAll();
        this.JEscritorio.repaint();
        JEscritorio.add(jfCT);
        jfCT.show();
    }//GEN-LAST:event_JBCTActionPerformed

    private void JBDepActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBDepActionPerformed
        jfDep = new JFInDepartamento();
        this.JEscritorio.removeAll();
        this.JEscritorio.repaint();
        JEscritorio.add(jfDep);
        jfDep.show();
    }//GEN-LAST:event_JBDepActionPerformed

    private void JBAreaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBAreaActionPerformed
        jfArea = new JFInArea();
        this.JEscritorio.removeAll();
        this.JEscritorio.repaint();
        JEscritorio.add(jfArea);
        jfArea.show();
    }//GEN-LAST:event_JBAreaActionPerformed

    private void JBExpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBExpActionPerformed
        jfExp = new JFInExperiencia(1);
        this.JEscritorio.removeAll();
        this.JEscritorio.repaint();
        JEscritorio.add(jfExp);
        jfExp.show();
    }//GEN-LAST:event_JBExpActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(JFMenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFMenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFMenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFMenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JFMenuPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton JBArea;
    private javax.swing.JButton JBCT;
    private javax.swing.JButton JBDep;
    private javax.swing.JButton JBEmpleado;
    private javax.swing.JButton JBExp;
    private javax.swing.JButton JBHijos;
    private javax.swing.JButton JBSalir;
    private javax.swing.JDesktopPane JEscritorio;
    // End of variables declaration//GEN-END:variables
}
