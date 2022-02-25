package Interfaz;

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
        setTitle("NOMBRE EMPRESA");

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

        JBEmpleado.setText("Empleado");
        JBEmpleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBEmpleadoActionPerformed(evt);
            }
        });

        JBCT.setText("Centro de Trabajo");
        JBCT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBCTActionPerformed(evt);
            }
        });

        JBDep.setText("Departamento");
        JBDep.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBDepActionPerformed(evt);
            }
        });

        JBArea.setText("Área");
        JBArea.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBAreaActionPerformed(evt);
            }
        });

        JBHijos.setText("Hijos");
        JBHijos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBHijosActionPerformed(evt);
            }
        });

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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(JBSalir, javax.swing.GroupLayout.DEFAULT_SIZE, 195, Short.MAX_VALUE)
                    .addComponent(JBEmpleado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(JBCT, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(JBDep, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(JBArea, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(JBHijos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(JBExp, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                        .addComponent(JBEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(JBHijos, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(JBCT, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(JBDep, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(JBArea, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(JBExp, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(JBSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 257, Short.MAX_VALUE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void JBSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBSalirActionPerformed
        System.exit(0);
    }//GEN-LAST:event_JBSalirActionPerformed

    private void JBEmpleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBEmpleadoActionPerformed
        jfEmpleado = new JFInEmpleado(1);
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
        jfCT = new JFInCT(1);
        this.JEscritorio.removeAll();
        this.JEscritorio.repaint();
        JEscritorio.add(jfCT);
        jfCT.show();
    }//GEN-LAST:event_JBCTActionPerformed

    private void JBDepActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBDepActionPerformed
        jfDep = new JFInDepartamento(3);
        this.JEscritorio.removeAll();
        this.JEscritorio.repaint();
        JEscritorio.add(jfDep);
        jfDep.show();
    }//GEN-LAST:event_JBDepActionPerformed

    private void JBAreaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBAreaActionPerformed
        jfArea = new JFInArea(1);
        this.JEscritorio.removeAll();
        this.JEscritorio.repaint();
        JEscritorio.add(jfArea);
        jfArea.show();
    }//GEN-LAST:event_JBAreaActionPerformed

    private void JBExpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBExpActionPerformed
        //jfExp = new JFInExperiencia(1);
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
