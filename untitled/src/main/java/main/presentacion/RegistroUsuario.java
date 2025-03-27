/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package main.presentacion;

import DTOs.NewUsuarioDTO;
import control.ControlGUI;
import exception.NegocioException;
import java.util.Date;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

/**
 *
 * @author jrasc
 */
public class RegistroUsuario extends javax.swing.JFrame {

    /**
     * Creates new form registrarUsuario
     */
    public RegistroUsuario() {
        initComponents();
        agregarCampoTexto(nombre, "Nombre");
        agregarCampoTexto(apellido, "Apellido");
        agregarCampoTexto(telefono, "Numero telefonico");
        agregarCampoTexto(pais, "Pais");
        agregarCampoTexto(correo, "Correo electronico");
        agregarCampoTexto(contrasenia, "Contraseña");
        agregarCampoTexto(confirmarContrasenia, "Confirmar contraseña");
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
        jPanel2 = new javax.swing.JPanel();
        nombre = new javax.swing.JTextField();
        apellido = new javax.swing.JTextField();
        telefono = new javax.swing.JTextField();
        pais = new javax.swing.JTextField();
        correo = new javax.swing.JTextField();
        contrasenia = new javax.swing.JTextField();
        confirmarContrasenia = new javax.swing.JTextField();
        fechaN = new com.toedter.calendar.JDateChooser();
        jButton1 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        nombre.setBackground(new java.awt.Color(22, 35, 65));
        nombre.setForeground(new java.awt.Color(255, 255, 255));
        nombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nombreActionPerformed(evt);
            }
        });
        jPanel2.add(nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 100, 350, 30));

        apellido.setBackground(new java.awt.Color(22, 35, 65));
        apellido.setForeground(new java.awt.Color(255, 255, 255));
        apellido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                apellidoActionPerformed(evt);
            }
        });
        jPanel2.add(apellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 140, 350, 30));

        telefono.setBackground(new java.awt.Color(22, 35, 65));
        telefono.setForeground(new java.awt.Color(255, 255, 255));
        telefono.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                telefonoActionPerformed(evt);
            }
        });
        jPanel2.add(telefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 220, 350, 30));

        pais.setBackground(new java.awt.Color(22, 35, 65));
        pais.setForeground(new java.awt.Color(255, 255, 255));
        pais.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                paisActionPerformed(evt);
            }
        });
        jPanel2.add(pais, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 260, 350, 30));

        correo.setBackground(new java.awt.Color(22, 35, 65));
        correo.setForeground(new java.awt.Color(255, 255, 255));
        correo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                correoActionPerformed(evt);
            }
        });
        jPanel2.add(correo, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 300, 350, 30));

        contrasenia.setBackground(new java.awt.Color(22, 35, 65));
        contrasenia.setForeground(new java.awt.Color(255, 255, 255));
        contrasenia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                contraseniaActionPerformed(evt);
            }
        });
        jPanel2.add(contrasenia, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 340, 350, 30));

        confirmarContrasenia.setBackground(new java.awt.Color(22, 35, 65));
        confirmarContrasenia.setForeground(new java.awt.Color(255, 255, 255));
        confirmarContrasenia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confirmarContraseniaActionPerformed(evt);
            }
        });
        jPanel2.add(confirmarContrasenia, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 380, 350, 30));

        fechaN.setBackground(new java.awt.Color(22, 35, 65));
        fechaN.setForeground(new java.awt.Color(255, 255, 255));
        fechaN.setDateFormatString("dd-MM-yyyy");
        jPanel2.add(fechaN, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 180, 350, 30));

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/boton (1).png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 420, 350, 50));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/image-removebg-preview (1).png"))); // NOI18N
        jLabel4.setText("jLabel4");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 0, 350, 90));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/fondo (1).png"))); // NOI18N
        jLabel1.setText("jLabel1");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 0, 460, 490));

        jLabel2.setText("jLabel2");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 40, 350, 70));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 50, 450, 490));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Sin título (2) (1).jpg"))); // NOI18N
        jLabel3.setText("jLabel3");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 840, 590));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void nombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nombreActionPerformed

    private void apellidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_apellidoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_apellidoActionPerformed

    private void telefonoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_telefonoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_telefonoActionPerformed

    private void paisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_paisActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_paisActionPerformed

    private void correoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_correoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_correoActionPerformed

    private void contraseniaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_contraseniaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_contraseniaActionPerformed

    private void confirmarContraseniaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confirmarContraseniaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_confirmarContraseniaActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String nombreUsuario = limpiarTexto(nombre, "Nombre");
        String apellidoUsuario = limpiarTexto(apellido, "Apellido");
        String numeroTelefonico = limpiarTexto(telefono, "Numero telefonico");
        String contra = limpiarTexto(contrasenia, "Contraseña");
        String paisUsuario = limpiarTexto(pais, "Pais");
        Date fechaNacimiento = fechaN.getDate();
        String correoElectronico = limpiarTexto(correo, "Correo electronico");
        String confirmarContrasenia2 = limpiarTexto(confirmarContrasenia, "Confirmar contrasenia");
        NewUsuarioDTO nuevoUsuario = new NewUsuarioDTO(nombreUsuario, apellidoUsuario, numeroTelefonico, contra, paisUsuario, fechaNacimiento, correoElectronico, confirmarContrasenia2);
        ControlGUI.getInstancia().intentarRegistrarUsuario(nuevoUsuario);
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(RegistroUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RegistroUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RegistroUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RegistroUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RegistroUsuario().setVisible(true);
            }
        });
    }

    private void agregarCampoTexto(JTextField field, String campoTexto) {
        field.setText(campoTexto);

        field.addFocusListener(new java.awt.event.FocusAdapter() {
            @Override
            public void focusGained(java.awt.event.FocusEvent evt) {
                if (field.getText().equals(campoTexto)) {
                    field.setText("");
                }
            }

            @Override
            public void focusLost(java.awt.event.FocusEvent evt) {
                if (field.getText().isEmpty()) {
                    field.setText(campoTexto);
                }
            }
        });
    }

    private String limpiarTexto(JTextField field, String campoTexto) {
        String text = field.getText().trim();
        return text.equals(campoTexto) ? null : text;
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField apellido;
    private javax.swing.JTextField confirmarContrasenia;
    private javax.swing.JTextField contrasenia;
    private javax.swing.JTextField correo;
    private com.toedter.calendar.JDateChooser fechaN;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField nombre;
    private javax.swing.JTextField pais;
    private javax.swing.JTextField telefono;
    // End of variables declaration//GEN-END:variables
}
