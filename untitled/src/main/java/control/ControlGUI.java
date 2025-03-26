/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import DTOs.GeneroDTO;
import DTOs.MembresiaDTO;
import DTOs.MetodoPagoDTO;
import DTOs.NewUsuarioDTO;
import ISubsistemas.IElegirMembresia;
import ISubsistemas.IGeneroSeleccionado;
import ISubsistemas.IPagoMembresia;
import ISubsistemas.IRegistrarUsuario;
import Subsistemas.ElegirMembresia;
import Subsistemas.GeneroSeleccionado;
import Subsistemas.PagoMembresia;
import Subsistemas.RegistrarUsuario;
import exception.NegocioException;
import java.util.List;
import javax.swing.JOptionPane;
import main.presentacion.Login;
import main.presentacion.Membresias;
import main.presentacion.MetodoPago;
import main.presentacion.SeleccionGeneros;
import main.presentacion.RegistroUsuario;

/**
 *
 * @author jrasc
 */
public class ControlGUI {

    private static ControlGUI instancia;
    private static IRegistrarUsuario usuarioNuevo = new RegistrarUsuario();
    private static IGeneroSeleccionado generoPreferido = new GeneroSeleccionado();
    private static IElegirMembresia membresiaSeleccionada = new ElegirMembresia();
    private static IPagoMembresia pagarMembresia = new PagoMembresia();

    private ControlGUI() {
    }

    public static ControlGUI getInstancia() {
        if (instancia == null) {
            instancia = new ControlGUI();
        }
        return instancia;
    }

    public void intentarRegistrarUsuario(NewUsuarioDTO nuevoUsuario) {
        try {
            if (usuarioNuevo.validarRegistroUsuario(nuevoUsuario) == nuevoUsuario) {
                usuarioNuevo.guardarUsuario(nuevoUsuario);
                mostrarSeleccionGeneros();
            }
        } catch (NegocioException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Información", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public void seleccionarGeneroPreferido(List<GeneroDTO> generos) {
        try {
            generoPreferido.getGenerosSeleccionados(generos);
            mostrarMembresia();
        } catch (NegocioException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Información", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public void seleccionarMembresia(MembresiaDTO membresia) {
        try {
            membresiaSeleccionada.validarEleccionMembresia(membresia);
            mostrarMetodoPago();
        } catch (NegocioException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Información", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public void procesarPago(MetodoPagoDTO pagoDTO) {
        try {
            if (pagarMembresia.validarFormatoPago(pagoDTO) == pagoDTO) {
                pagarMembresia.guardarPago(pagoDTO);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Información", JOptionPane.INFORMATION_MESSAGE);
        }

    }

    public void mostrarLogin() {
        Login login = new Login();
        login.setVisible(true);
        login.setLocationRelativeTo(null);
    }

    public void mostrarRegistroUsuario() {
        RegistroUsuario registro = new RegistroUsuario();
        registro.setVisible(true);
        registro.setLocationRelativeTo(null);
    }

    public void mostrarMetodoPago() {
        MetodoPago metodoPago = new MetodoPago();
        metodoPago.setVisible(true);
        metodoPago.setLocationRelativeTo(null);
    }

    public void mostrarSeleccionGeneros() {
        SeleccionGeneros seleccion = new SeleccionGeneros();
        seleccion.setVisible(true);
        seleccion.setLocationRelativeTo(null);
    }

    public void mostrarMembresia() {
        Membresias membresia = new Membresias();
        membresia.setVisible(true);
        membresia.setLocationRelativeTo(null);
    }

    public void cerrarVentana(javax.swing.JFrame ventanaActual) {
        if (ventanaActual != null) {
            ventanaActual.dispose();
        }
    }
}
