/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package main.presentacion;

import DTOs.GeneroDTO;
import java.awt.Dimension;
import javax.swing.ImageIcon;

/**
 *
 * @author devor
 */

public class PanelGenero extends javax.swing.JPanel {

    private GeneroDTO genero;
    
    public PanelGenero(GeneroDTO genero) {
        this.genero = genero;
        initComponents();
        setupPanel();
        }
       private void setupPanel() {
     
        LabelNombre.setText(genero.getNombre());
  
        CheckBoxSeleccionar.setSelected(genero.isSeleccionado());
        
        
        CheckBoxSeleccionar.addActionListener(e -> {
            genero.setSeleccionado(CheckBoxSeleccionar.isSelected());
        });
        

        setPreferredSize(new Dimension(300, 200));
    }

        
        
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        LabelNombre = new javax.swing.JLabel();
        CheckBoxSeleccionar = new javax.swing.JCheckBox();
        LabelImagen = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 102, 0));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        LabelNombre.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        LabelNombre.setText("Nombre Categoria");
        LabelNombre.setToolTipText("");
        LabelNombre.setVerifyInputWhenFocusTarget(false);
        LabelNombre.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        add(LabelNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 90, 210, -1));

        CheckBoxSeleccionar.setText("Seleccionar");
        CheckBoxSeleccionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CheckBoxSeleccionarActionPerformed(evt);
            }
        });
        add(CheckBoxSeleccionar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 128, 77));
        add(LabelImagen, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 220, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void CheckBoxSeleccionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CheckBoxSeleccionarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CheckBoxSeleccionarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox CheckBoxSeleccionar;
    private javax.swing.JLabel LabelImagen;
    private javax.swing.JLabel LabelNombre;
    // End of variables declaration//GEN-END:variables
}
