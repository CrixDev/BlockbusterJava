/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package main.presentacion;

import DTOs.MembresiaDTO;
import javax.swing.JOptionPane;

/**
 *
 * @author devor
 */
public class Membresias extends javax.swing.JFrame {
    private MembresiaDTO membresiaSeleccionada;
    /**
     * Creates new form Membresias
     */
    public Membresias() {
        initComponents();
         inicializarPanelesMembresias();
    }

    
    private void inicializarPanelesMembresias() {
        // Crear 3 membresías de ejemplo
        MembresiaDTO membresia1 = new MembresiaDTO("Básica", "Acceso a equipos básicos", 29.99);
        MembresiaDTO membresia2 = new MembresiaDTO("Premium", "Acceso a todos los equipos + clases grupales", 59.99);
        MembresiaDTO membresia3 = new MembresiaDTO("VIP", String.format( "Acceso ilimitado \n entrenador personal"), 99.99);

        // Crear los paneles con las membresías
        PanelMembresia panel1 = new PanelMembresia(membresia1);
        PanelMembresia panel2 = new PanelMembresia(membresia2);
        PanelMembresia panel3 = new PanelMembresia(membresia3);
        
            panel1.setMembresiaSeleccionadaListener(membresia -> {
            this.membresiaSeleccionada = membresia;
             mostrarSeleccion(membresia);
        });
        
        panel2.setMembresiaSeleccionadaListener(membresia -> {
            this.membresiaSeleccionada = membresia;
          mostrarSeleccion(membresia);
        });
        
        panel3.setMembresiaSeleccionadaListener(membresia -> {
            this.membresiaSeleccionada = membresia;
          mostrarSeleccion(membresia);
        });

        // Configurar el layout y añadir los paneles
        panelContenedor.setLayout(new java.awt.GridLayout(1, 3, 10, 10));
        panelContenedor1.setLayout(new java.awt.GridLayout(1, 3, 10, 10)); 
        panelContenedor2.setLayout(new java.awt.GridLayout(1, 3, 10, 10));
        
        panelContenedor.add(panel1);
        panelContenedor1.add(panel2);
        panelContenedor2.add(panel3);
    }

    public MembresiaDTO getMembresiaSeleccionada() {
        return membresiaSeleccionada;
    }
     private void mostrarSeleccion(MembresiaDTO membresia) {
          JOptionPane.showMessageDialog(this, "Has seleccionado: " + membresia.getNombre());
        
     }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelContenedor = new javax.swing.JPanel();
        panelContenedor1 = new javax.swing.JPanel();
        panelContenedor2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(204, 204, 255));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelContenedor.setPreferredSize(new java.awt.Dimension(270, 500));

        javax.swing.GroupLayout panelContenedorLayout = new javax.swing.GroupLayout(panelContenedor);
        panelContenedor.setLayout(panelContenedorLayout);
        panelContenedorLayout.setHorizontalGroup(
            panelContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 270, Short.MAX_VALUE)
        );
        panelContenedorLayout.setVerticalGroup(
            panelContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 500, Short.MAX_VALUE)
        );

        getContentPane().add(panelContenedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 110, 270, -1));

        panelContenedor1.setPreferredSize(new java.awt.Dimension(270, 500));

        javax.swing.GroupLayout panelContenedor1Layout = new javax.swing.GroupLayout(panelContenedor1);
        panelContenedor1.setLayout(panelContenedor1Layout);
        panelContenedor1Layout.setHorizontalGroup(
            panelContenedor1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 270, Short.MAX_VALUE)
        );
        panelContenedor1Layout.setVerticalGroup(
            panelContenedor1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 500, Short.MAX_VALUE)
        );

        getContentPane().add(panelContenedor1, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 110, -1, -1));

        panelContenedor2.setPreferredSize(new java.awt.Dimension(270, 500));

        javax.swing.GroupLayout panelContenedor2Layout = new javax.swing.GroupLayout(panelContenedor2);
        panelContenedor2.setLayout(panelContenedor2Layout);
        panelContenedor2Layout.setHorizontalGroup(
            panelContenedor2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 270, Short.MAX_VALUE)
        );
        panelContenedor2Layout.setVerticalGroup(
            panelContenedor2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 500, Short.MAX_VALUE)
        );

        getContentPane().add(panelContenedor2, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 110, 270, -1));

        jPanel1.setBackground(new java.awt.Color(26, 43, 76));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(234, 205, 55));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Membresias");
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(331, 331, 331)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 406, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(343, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel1)
                .addContainerGap(631, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1080, 700));

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(Membresias.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Membresias.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Membresias.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Membresias.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Membresias().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel panelContenedor;
    private javax.swing.JPanel panelContenedor1;
    private javax.swing.JPanel panelContenedor2;
    // End of variables declaration//GEN-END:variables
}
