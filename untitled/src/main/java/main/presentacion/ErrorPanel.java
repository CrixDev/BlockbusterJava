/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package main.presentacion;

import Error.ErrorComponente;
/**
 *
 * @author Usuario
 */
public class ErrorPanel extends javax.swing.JPanel {

    private ErrorComponente error;

    /**
     * Creates new form ErrorComponente
     */
    public ErrorPanel(ErrorComponente error) {
        this.error = error;
        initComponents();
        setupPanel();
    }

    private void setupPanel() {

        LabelNombreError.setText(error.getTitulo());
        LabelDescripcionError.setText(error.getDescripcion());

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
        roundedPanel2 = new utils.RoundedPanel();
        jLabel1 = new javax.swing.JLabel();
        LabelNombreError = new javax.swing.JLabel();
        LabelDescripcionError = new javax.swing.JLabel();

        jPanel1.setBackground(new java.awt.Color(26, 43, 76));

        roundedPanel2.setBackground(new java.awt.Color(234, 205, 54));
        roundedPanel2.setRoundBottomLeft(30);
        roundedPanel2.setRoundBottomRight(30);
        roundedPanel2.setRoundTopLeft(30);
        roundedPanel2.setRoundTopRight(30);
        roundedPanel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                roundedPanel2MouseClicked(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(26, 43, 76));
        jLabel1.setText("Okey");

        javax.swing.GroupLayout roundedPanel2Layout = new javax.swing.GroupLayout(roundedPanel2);
        roundedPanel2.setLayout(roundedPanel2Layout);
        roundedPanel2Layout.setHorizontalGroup(
            roundedPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, roundedPanel2Layout.createSequentialGroup()
                .addContainerGap(43, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(40, 40, 40))
        );
        roundedPanel2Layout.setVerticalGroup(
            roundedPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundedPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        LabelNombreError.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 48)); // NOI18N
        LabelNombreError.setForeground(new java.awt.Color(255, 255, 255));
        LabelNombreError.setText("Error de formulario");

        LabelDescripcionError.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 24)); // NOI18N
        LabelDescripcionError.setForeground(new java.awt.Color(255, 255, 255));
        LabelDescripcionError.setText("Datos faltantes");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(LabelNombreError))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(158, 158, 158)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(LabelDescripcionError)
                            .addComponent(roundedPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(36, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(LabelNombreError)
                .addGap(18, 18, 18)
                .addComponent(LabelDescripcionError)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 54, Short.MAX_VALUE)
                .addComponent(roundedPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void roundedPanel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_roundedPanel2MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_roundedPanel2MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel LabelDescripcionError;
    private javax.swing.JLabel LabelNombreError;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private utils.RoundedPanel roundedPanel2;
    // End of variables declaration//GEN-END:variables
}
