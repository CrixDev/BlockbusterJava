/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import DTOs.NewUsuarioDTO;
import ISubsistemas.IRegistrarUsuario;
import Subsistemas.RegistrarUsuario;
import exception.NegocioException;
import javax.swing.JOptionPane;
import main.presentacion.Login;
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
                mostrarMetodoPago();
            }
        } catch (NegocioException e) {
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

}
