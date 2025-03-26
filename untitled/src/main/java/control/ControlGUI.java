/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import DTOs.GeneroDTO;
import DTOs.MembresiaDTO;
import DTOs.MetodoPagoDTO;
import DTOs.NewUsuarioDTO;
import DTOs.NuevoPagoDTO;
import ISubsistemas.IElegirMembresia;
import ISubsistemas.IGeneroSeleccionado;
import ISubsistemas.IPagoMembresia;
import ISubsistemas.IRegistrarUsuario;
import Interfaces.IGestorPagos;
import Subsistemas.ElegirMembresia;
import Subsistemas.GeneroSeleccionado;
import Subsistemas.PagoMembresia;
import Subsistemas.RegistrarUsuario;
import com.mycompany.infraestructura.GestorPagos;
import DTOs.PagoRegistradoDTO;
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
    private static IElegirMembresia gestorMembresia = new ElegirMembresia();
    private static IPagoMembresia pagarMembresia = new PagoMembresia();
    private static IGestorPagos gestionarPagos = new GestorPagos();
    private MembresiaDTO membresiaSeleccionada;
    private NewUsuarioDTO usuarioSeleccionado;
    private List<GeneroDTO> generosSeleccionados;
    private PagoRegistradoDTO metodoPagoSeleccionado;

    private ControlGUI() {
    }

    public static ControlGUI getInstancia() {
        if (instancia == null) {
            instancia = new ControlGUI();
        }
        return instancia;
    }

    public NewUsuarioDTO intentarRegistrarUsuario(NewUsuarioDTO nuevoUsuario) {
        try {
            this.usuarioSeleccionado = usuarioNuevo.validarRegistroUsuario(nuevoUsuario);;
            mostrarSeleccionGeneros();
            return usuarioSeleccionado;

        } catch (NegocioException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Información", JOptionPane.INFORMATION_MESSAGE);
            return null;
        }
    }

    public List<GeneroDTO> seleccionarGeneroPreferido(List<GeneroDTO> generos) {
        try {
            this.generosSeleccionados = generoPreferido.getGenerosSeleccionados(generos);
            mostrarMembresia();
            return generosSeleccionados;
        } catch (NegocioException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Información", JOptionPane.INFORMATION_MESSAGE);
            return null;
        }
    }

    public MembresiaDTO seleccionarMembresia(MembresiaDTO membresia) {
        try {
            this.membresiaSeleccionada = gestorMembresia.validarEleccionMembresia(membresia);
            mostrarMetodoPago();
            return membresiaSeleccionada;
        } catch (NegocioException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Información", JOptionPane.INFORMATION_MESSAGE);
            return null;
        }
    }

    public PagoRegistradoDTO procesarPago(MetodoPagoDTO pagoDTO, MembresiaDTO membresia) {

        try {
            pagarMembresia.validarFormatoPago(pagoDTO);

            NuevoPagoDTO nuevoPago = new NuevoPagoDTO(
                    pagoDTO.getNombreTitular(),
                    pagoDTO.getNumeroTarjeta(),
                    pagoDTO.getMesCaducidad(),
                    pagoDTO.getAnioCaducidad(),
                    pagoDTO.getCvv());

            PagoRegistradoDTO resultado = gestionarPagos.procesarPago(nuevoPago, membresia);

            if (resultado.isEsValida()) {
                pagarMembresia.guardarPago(pagoDTO);
                JOptionPane.showMessageDialog(null, "Pago realizado con éxito. Monto: $" + resultado.getMonto());
                mostrarLogin();
                return resultado;
            } else {
                JOptionPane.showMessageDialog(null, "La tarjeta no está registrada o no es válida.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (NegocioException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Información", JOptionPane.INFORMATION_MESSAGE);
        }
        return null;
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

    public NewUsuarioDTO getNuevoUsuario() {
        return usuarioSeleccionado;
    }

    public List<GeneroDTO> getGenerosSeleccionados() {
        return generosSeleccionados;
    }

    public MembresiaDTO getMembresiaSeleccionada() {
        return membresiaSeleccionada;
    }

    public PagoRegistradoDTO getProcesarPago() {
        return metodoPagoSeleccionado;
    }


}
