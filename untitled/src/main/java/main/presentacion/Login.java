/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package main.presentacion;
/*
<<<<<<< HEAD

=======
>>>>>>> 7ce21f1b7963e60a1fd64b438f435bf0366c47bd
import DTOs.CredencialesUsuarioDTO;
import DTOs.NewUsuarioDTO;

import javax.swing.JOptionPane;
import main.presentacion.registrarUsuario;
/**
 *
 * @author devor
 */
public class Login extends javax.swing.JFrame {

    /**
     * Creates new form Login a
     */
    public Login() {
        initComponents();
        limpiarCampos();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        JLabelBlockBuster = new javax.swing.JLabel();
        jLabelWelcomeBackTo = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabelUsuario = new javax.swing.JLabel();
        jTextFieldIngresarUsuario = new javax.swing.JTextField();
        jPanel6 = new javax.swing.JPanel();
        jLabelContraseña = new javax.swing.JLabel();
        jPasswordFieldIngresarContraseña = new javax.swing.JPasswordField();
        jPanel4 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(26, 43, 76));
        jPanel1.setPreferredSize(new java.awt.Dimension(400, 0));

        jPanel3.setBackground(new java.awt.Color(26, 43, 76));

        JLabelBlockBuster.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        JLabelBlockBuster.setForeground(new java.awt.Color(252, 193, 57));
        JLabelBlockBuster.setText("Blockbuster!");

        jLabelWelcomeBackTo.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        jLabelWelcomeBackTo.setForeground(new java.awt.Color(252, 193, 57));
        jLabelWelcomeBackTo.setText("Welcome back To");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(JLabelBlockBuster)
                        .addGap(140, 140, 140))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabelWelcomeBackTo)
                        .addGap(122, 122, 122))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabelWelcomeBackTo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JLabelBlockBuster)
                .addContainerGap(39, Short.MAX_VALUE))
        );

        jPanel5.setBackground(new java.awt.Color(22, 35, 65));
        jPanel5.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabelUsuario.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jLabelUsuario.setForeground(new java.awt.Color(252, 193, 57));
        jLabelUsuario.setText("Usuario");

        jTextFieldIngresarUsuario.setBackground(new java.awt.Color(22, 35, 65));
        jTextFieldIngresarUsuario.setForeground(new java.awt.Color(255, 255, 255));
        jTextFieldIngresarUsuario.setText("Usuario");
        jTextFieldIngresarUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldIngresarUsuarioActionPerformed(evt);
            }
        });

        jPanel6.setBackground(new java.awt.Color(22, 35, 65));

        jLabelContraseña.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jLabelContraseña.setForeground(new java.awt.Color(252, 193, 57));
        jLabelContraseña.setText("Contraseña");

        jPasswordFieldIngresarContraseña.setBackground(new java.awt.Color(22, 35, 65));
        jPasswordFieldIngresarContraseña.setForeground(new java.awt.Color(255, 255, 255));
        jPasswordFieldIngresarContraseña.setText("jPasswordField1");
        jPasswordFieldIngresarContraseña.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jPasswordFieldIngresarContraseñaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabelContraseña)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jPasswordFieldIngresarContraseña))
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabelContraseña)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPasswordFieldIngresarContraseña, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(33, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelUsuario)
                    .addComponent(jTextFieldIngresarUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 325, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabelUsuario)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldIngresarUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        jPanel4.setBackground(new java.awt.Color(26, 43, 76));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        jButton2.setBackground(new java.awt.Color(35, 72, 153));
        jButton2.setForeground(new java.awt.Color(252, 193, 57));
        jButton2.setText("Entrar");
        jButton2.setBorderPainted(false);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton1.setBackground(new java.awt.Color(26, 43, 76));
        jButton1.setForeground(new java.awt.Color(252, 193, 57));
        jButton1.setText("¿No tienes cuenta?");
        jButton1.setBorderPainted(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(343, 343, 343)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(117, 117, 117))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        getContentPane().add(jPanel1, java.awt.BorderLayout.WEST);

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/imagen.png"))); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 598, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 1, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 517, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel2, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        registrarUsuario ventanaRegistrar = new registrarUsuario();
        
        ventanaRegistrar.setVisible(true);
        ventanaRegistrar.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTextFieldIngresarUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldIngresarUsuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldIngresarUsuarioActionPerformed

    private void jPasswordFieldIngresarContraseñaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jPasswordFieldIngresarContraseñaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jPasswordFieldIngresarContraseñaActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
   /**
 *
        String correo = jTextFieldIngresarUsuario.getText().trim();
        String contraseña = new String(jPasswordFieldIngresarContraseña.getPassword()).trim();
        
        if (correo.isEmpty() || contraseña.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Debes ingresar correo y contraseña", "Advertencia", JOptionPane.WARNING_MESSAGE);
            return;
       }
        
     
 * 
 */
    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    private void limpiarCampos() {
        jTextFieldIngresarUsuario.setText("");
        jPasswordFieldIngresarContraseña.setText("");
        jTextFieldIngresarUsuario.requestFocus();
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel JLabelBlockBuster;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabelContraseña;
    private javax.swing.JLabel jLabelUsuario;
    private javax.swing.JLabel jLabelWelcomeBackTo;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPasswordField jPasswordFieldIngresarContraseña;
    private javax.swing.JTextField jTextFieldIngresarUsuario;
    // End of variables declaration//GEN-END:variables
}

