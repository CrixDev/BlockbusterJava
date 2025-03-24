/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package seleccionGenero;

/**
 *
 * @author devor
 */
import java.awt.BorderLayout;
import java.awt.Font;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

public class seleccionador extends JFrame {
    private List<Genero> generos;
    private int indiceActual = 0;
    private JLabel labelGenero;

    public seleccionador() {
        setTitle("Selecciona tus géneros favoritos");
        setSize(500, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        generos = new ArrayList<>();
        generos.add(new Genero("Drama"));
        generos.add(new Genero("Acción"));
        generos.add(new Genero("Terror"));
        generos.add(new Genero("Comedia"));

        labelGenero = new JLabel(generos.get(indiceActual).getNombre(), SwingConstants.CENTER);
        labelGenero.setFont(new Font("Arial", Font.BOLD, 24));
        add(labelGenero, BorderLayout.CENTER);

        JPanel panelBotones = new JPanel();
        JButton btnAnterior = new JButton("<");
        JButton btnSiguiente = new JButton(">");
        JButton btnSeleccionar = new JButton("Seleccionar");
        
        btnAnterior.addActionListener(e -> cambiarGenero(-1));
        btnSiguiente.addActionListener(e -> cambiarGenero(1));
        btnSeleccionar.addActionListener(e -> seleccionarGenero());
        
        panelBotones.add(btnAnterior);
        panelBotones.add(btnSeleccionar);
        panelBotones.add(btnSiguiente);
        add(panelBotones, BorderLayout.SOUTH);
    }

    private void cambiarGenero(int direccion) {
        indiceActual = (indiceActual + direccion + generos.size()) % generos.size();
        labelGenero.setText(generos.get(indiceActual).getNombre());
    }

    private void seleccionarGenero() {
        Genero genero = generos.get(indiceActual);
        genero.setSeleccionado(!genero.isSeleccionado());
        String mensaje = genero.getNombre() + (genero.isSeleccionado() ? " seleccionado" : " deseleccionado");
        JOptionPane.showMessageDialog(this, mensaje);
    }

}
