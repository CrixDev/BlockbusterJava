/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package main.presentacion;

import DTOs.GeneroDTO;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author devor
 */

public class PanelGenero extends javax.swing.JPanel {

    private GeneroDTO genero;
    private String rutaImagen;
    
    public PanelGenero(GeneroDTO genero) {
       
          initComponents();
          this.genero = genero;
        this.rutaImagen = genero.getImagen();
       
      
         setupPanel();
        
        }
       private void setupPanel() {
     
        LabelNombre.setText(genero.getNombre());
  
        CheckBoxSeleccionar.setSelected(genero.isSeleccionado());
        
        
        CheckBoxSeleccionar.addActionListener(e -> {
            genero.setSeleccionado(CheckBoxSeleccionar.isSelected());
        });
        
        setImagen(rutaImagen);
        
        
         this.add(LblImagen, BorderLayout.CENTER);
        setPreferredSize(new Dimension(300, 200));
    }

         public void setImagen(String rutaImagen) {
         if (rutaImagen != null && !rutaImagen.isEmpty()) {
        // Cargando la imagen desde el directorio de recursos
        URL imageURL = getClass().getResource(rutaImagen);
        
        if (imageURL != null) {
            ImageIcon icon = new ImageIcon(imageURL);
            LblImagen.setIcon(icon);
        } else {
            // Si no se encuentra la imagen, usa una imagen predeterminada
            ImageIcon icon = new ImageIcon(getClass().getResource("/imagenes/derechaicon.png"));
            LblImagen.setIcon(icon);
        }
    } else {
        // Si la ruta de la imagen es null o vacía, muestra una imagen predeterminada
        ImageIcon icon = new ImageIcon(getClass().getResource("/imagenes/oxxo.png"));
        LblImagen.setIcon(icon);
    }
    }
        
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        LabelImagen = new javax.swing.JLabel();
        LabelNombre = new javax.swing.JLabel();
        LblImagen = new javax.swing.JLabel();
        CheckBoxSeleccionar = new javax.swing.JCheckBox();

        setBackground(new java.awt.Color(22, 35, 65));

        LabelNombre.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        LabelNombre.setForeground(new java.awt.Color(234, 205, 55));
        LabelNombre.setText("Nombre Categoria");
        LabelNombre.setToolTipText("");
        LabelNombre.setVerifyInputWhenFocusTarget(false);
        LabelNombre.setVerticalTextPosition(javax.swing.SwingConstants.TOP);

        LblImagen.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        CheckBoxSeleccionar.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        CheckBoxSeleccionar.setForeground(new java.awt.Color(234, 205, 55));
        CheckBoxSeleccionar.setText("Seleccionar");
        CheckBoxSeleccionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CheckBoxSeleccionarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addComponent(LabelImagen)
                .addGap(5, 5, 5)
                .addComponent(LabelNombre)
                .addGap(5, 5, 5)
                .addComponent(CheckBoxSeleccionar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(LblImagen)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(LabelImagen))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(LabelNombre))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(CheckBoxSeleccionar)))
                .addContainerGap(263, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(LblImagen)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void CheckBoxSeleccionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CheckBoxSeleccionarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CheckBoxSeleccionarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox CheckBoxSeleccionar;
    private javax.swing.JLabel LabelImagen;
    private javax.swing.JLabel LabelNombre;
    private javax.swing.JLabel LblImagen;
    // End of variables declaration//GEN-END:variables
}
