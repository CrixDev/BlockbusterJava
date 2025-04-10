/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package main.presentacion;

import DTOs.GeneroDTO;
import control.ControlGUI;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author devor a
 */
public class SeleccionGeneros extends javax.swing.JFrame {

    private List<GeneroDTO> generos;
    private int indiceActual = 0;
    private JPanel panelContenedorPrincipal;

    String[] rutas = {
        "/imagenes/drama.png",
        "/imagenes/comedia.png",
        "/imagenes/accion.png",};

    /**
     * Creates new form SeleccionGeneros
     */
    public SeleccionGeneros() {
        initComponents();
        inicializarGeneros();
        configurarInterfaz();
        mostrarGenero(0); // Mostrar el primer género al iniciar
    }

    private void inicializarGeneros() {
        generos = new ArrayList<>();

        generos.add(new GeneroDTO("Drama", rutas[0]));
        generos.add(new GeneroDTO("accion", rutas[2]));
        generos.add(new GeneroDTO("Comedia", rutas[1]));
    }

    private void configurarInterfaz() {

        panelContenedorPrincipal = new JPanel();
        panelContenedorPrincipal.setLayout(new CardLayout()); // Usamos CardLayout para navegar
        panelContenedorPrincipal.setBackground(new Color(26, 43, 76));

        // Añade el panel al frame (ajusta según tu diseño)
        getContentPane().add(panelContenedorPrincipal, BorderLayout.CENTER);

        // Carga todos los paneles de género
        cargarPanelesGeneros();

        // Configura botones de navegación
        configurarBotonesNavegacion();
    }

    private void cargarPanelesGeneros() {
        for (GeneroDTO genero : generos) {
            PanelGenero panel = new PanelGenero(genero);
            panelContenedorPrincipal.add(panel, genero.getNombre());
        }
    }

    private void mostrarGenero(int indice) {
        CardLayout cl = (CardLayout) (panelContenedorPrincipal.getLayout());
        cl.show(panelContenedorPrincipal, generos.get(indice).getNombre());
        indiceActual = indice;
        actualizarEstadoBotones();
    }

    private void configurarBotonesNavegacion() {
        // Asume que tienes jBtnAnterior y jBtnSiguiente en tu diseño
        jBtnAnterior.addActionListener(e -> {
            if (indiceActual > 0) {
                mostrarGenero(indiceActual - 1);
            }
        });

        jBtnSiguiente.addActionListener(e -> {
            if (indiceActual < generos.size() - 1) {
                mostrarGenero(indiceActual + 1);
            }
        });

        actualizarEstadoBotones();
    }

    private void actualizarEstadoBotones() {
        jBtnAnterior.setEnabled(indiceActual > 0);
        jBtnSiguiente.setEnabled(indiceActual < generos.size() - 1);
    }

    public void limpiarCampos() {
        for (GeneroDTO genero : generos) {
            genero.setSeleccionado(false);
        }
        mostrarGenero(0);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jRadioButtonMenuItem1 = new javax.swing.JRadioButtonMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        panelGeneroActual = new javax.swing.JPanel();
        jPanelContenedor = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jBtnAnterior = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jBtnSiguiente = new javax.swing.JButton();
        btnSiguienteVentana = new javax.swing.JButton();
        jPanelGeneroContainer = new javax.swing.JPanel();
        LblTitulo = new javax.swing.JLabel();

        jRadioButtonMenuItem1.setSelected(true);
        jRadioButtonMenuItem1.setText("jRadioButtonMenuItem1");

        jMenuItem1.setText("jMenuItem1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout panelGeneroActualLayout = new javax.swing.GroupLayout(panelGeneroActual);
        panelGeneroActual.setLayout(panelGeneroActualLayout);
        panelGeneroActualLayout.setHorizontalGroup(
            panelGeneroActualLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 667, Short.MAX_VALUE)
        );
        panelGeneroActualLayout.setVerticalGroup(
            panelGeneroActualLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 381, Short.MAX_VALUE)
        );

        getContentPane().add(panelGeneroActual, java.awt.BorderLayout.CENTER);

        javax.swing.GroupLayout jPanelContenedorLayout = new javax.swing.GroupLayout(jPanelContenedor);
        jPanelContenedor.setLayout(jPanelContenedorLayout);
        jPanelContenedorLayout.setHorizontalGroup(
            jPanelContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanelContenedorLayout.setVerticalGroup(
            jPanelContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        getContentPane().add(jPanelContenedor, java.awt.BorderLayout.NORTH);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 833, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel1, java.awt.BorderLayout.PAGE_END);

        jPanel3.setBackground(new java.awt.Color(22, 35, 65));

        jBtnAnterior.setBackground(new java.awt.Color(22, 35, 65));
        jBtnAnterior.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/izquierdaicon.png"))); // NOI18N
        jBtnAnterior.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnAnteriorActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jBtnAnterior)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(149, 149, 149)
                .addComponent(jBtnAnterior, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(140, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel3, java.awt.BorderLayout.WEST);

        jPanel2.setBackground(new java.awt.Color(22, 35, 65));

        jBtnSiguiente.setBackground(new java.awt.Color(22, 35, 65));
        jBtnSiguiente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/derechaicon.png"))); // NOI18N
        jBtnSiguiente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnSiguienteActionPerformed(evt);
            }
        });

        btnSiguienteVentana.setBackground(new java.awt.Color(234, 205, 55));
        btnSiguienteVentana.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnSiguienteVentana.setForeground(new java.awt.Color(22, 35, 65));
        btnSiguienteVentana.setText("Siguiente");
        btnSiguienteVentana.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSiguienteVentanaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnSiguienteVentana))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(jBtnSiguiente)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(139, 139, 139)
                .addComponent(jBtnSiguiente, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 83, Short.MAX_VALUE)
                .addComponent(btnSiguienteVentana)
                .addGap(36, 36, 36))
        );

        getContentPane().add(jPanel2, java.awt.BorderLayout.EAST);

        jPanelGeneroContainer.setBackground(new java.awt.Color(22, 35, 65));

        LblTitulo.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        LblTitulo.setForeground(new java.awt.Color(234, 205, 55));
        LblTitulo.setText("Selecciona tu género favorito");

        javax.swing.GroupLayout jPanelGeneroContainerLayout = new javax.swing.GroupLayout(jPanelGeneroContainer);
        jPanelGeneroContainer.setLayout(jPanelGeneroContainerLayout);
        jPanelGeneroContainerLayout.setHorizontalGroup(
            jPanelGeneroContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelGeneroContainerLayout.createSequentialGroup()
                .addGap(124, 124, 124)
                .addComponent(LblTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 562, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(147, Short.MAX_VALUE))
        );
        jPanelGeneroContainerLayout.setVerticalGroup(
            jPanelGeneroContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelGeneroContainerLayout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(LblTitulo)
                .addContainerGap(33, Short.MAX_VALUE))
        );

        getContentPane().add(jPanelGeneroContainer, java.awt.BorderLayout.NORTH);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBtnSiguienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnSiguienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jBtnSiguienteActionPerformed

    private void jBtnAnteriorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnAnteriorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jBtnAnteriorActionPerformed

    private void btnSiguienteVentanaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSiguienteVentanaActionPerformed
        List<GeneroDTO> seleccionados = getGenerosSeleccionados();
        ControlGUI.getInstancia().seleccionarGeneroPreferido(seleccionados);
    }//GEN-LAST:event_btnSiguienteVentanaActionPerformed

    /**
     * @param args the command line arguments
     */
    public List<GeneroDTO> getGenerosSeleccionados() {
        List<GeneroDTO> seleccionados = new ArrayList<>();
        for (GeneroDTO genero : generos) {
            if (genero.isSeleccionado()) {
                seleccionados.add(genero);
            }
        }
        return seleccionados;
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel LblTitulo;
    private javax.swing.JButton btnSiguienteVentana;
    private javax.swing.JButton jBtnAnterior;
    private javax.swing.JButton jBtnSiguiente;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanelContenedor;
    private javax.swing.JPanel jPanelGeneroContainer;
    private javax.swing.JRadioButtonMenuItem jRadioButtonMenuItem1;
    private javax.swing.JPanel panelGeneroActual;
    // End of variables declaration//GEN-END:variables
}
