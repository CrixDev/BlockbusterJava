/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package seleccionGenero;

/**
 *
 * @author devora
 */
import DTOs.GeneroDTO;
import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import java.util.ArrayList;
import java.util.List;

public class Seleccionador extends JFrame {

    private List<GeneroDTO> generos;
    private int indiceActual = 0;
    private JLabel labelGenero;

    public Seleccionador() {
        setTitle("Selecciona tus géneros favoritos");
        setSize(500, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        inicializarGeneros(); // make sure this is before accessing the list

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

    private void inicializarGeneros() {
        generos = new ArrayList<>();
        generos.add(new GeneroDTO("Drama"));
        generos.add(new GeneroDTO("Terror"));
        generos.add(new GeneroDTO("Comedia"));
    }

    private void cambiarGenero(int direccion) {
        indiceActual = (indiceActual + direccion + generos.size()) % generos.size();
        labelGenero.setText(generos.get(indiceActual).getNombre());
    }

    private void seleccionarGenero() {
        GeneroDTO genero = generos.get(indiceActual);
        genero.setSeleccionado(!genero.isSeleccionado());
        String mensaje = genero.getNombre() + (genero.isSeleccionado() ? " seleccionado" : " deseleccionado");
        JOptionPane.showMessageDialog(this, mensaje);
    }

    public List<GeneroDTO> getGenerosSeleccionados() {
        List<GeneroDTO> seleccionados = new ArrayList<>();
        for (GeneroDTO genero : generos) {
            if (genero.isSeleccionado()) {
                seleccionados.add(genero);
            }
        }
        return seleccionados;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Seleccionador().setVisible(true));
    }
}
