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
import DTOs.UsuarioDTO;
import ISubsistemas.IGuardarUsuario;
import Subsistemas.GuardarUsuario;
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
    private static IGuardarUsuario guardarUsuario = new GuardarUsuario();
    private MembresiaDTO membresiaSeleccionada;
    private NewUsuarioDTO usuarioSeleccionado;
    private List<GeneroDTO> generosSeleccionados;
    private PagoRegistradoDTO metodoPagoSeleccionado;
    private RegistroUsuario frmRegistroUsuario;
    private Login frmLoginUsuario;
    private MetodoPago frmMetodoPago;
    private SeleccionGeneros frmSeleccionGeneros;
    private Membresias frmMembresia;

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
            this.usuarioSeleccionado = usuarioNuevo.validarRegistroUsuario(nuevoUsuario);
            mostrarSeleccionGeneros();
            cerrarVentana(frmLoginUsuario);
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
            cerrarVentana(frmSeleccionGeneros);
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
            cerrarVentana(frmMembresia);
            return membresiaSeleccionada;
        } catch (NegocioException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Información", JOptionPane.INFORMATION_MESSAGE);
            return null;
        }
    }

    public PagoRegistradoDTO procesarPago(MetodoPagoDTO pagoDTO, MembresiaDTO membresia) {

        try {
            pagarMembresia.validarFormatoPago(pagoDTO);

            NuevoPagoDTO nuevoPago = new NuevoPagoDTO(pagoDTO.getNombreTitular(),
                     pagoDTO.getApellidoTitular(),
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

    public void guardarUsuario() {
        try {
            NewUsuarioDTO datosUsuario = getNuevoUsuario();
            List<GeneroDTO> generos = getGenerosSeleccionados();
            MembresiaDTO membresia = getMembresiaSeleccionada();
            PagoRegistradoDTO pagoRegistrado = getProcesarPago();
            UsuarioDTO usuarioGuardar = new UsuarioDTO(datosUsuario, membresia, generos, pagoRegistrado);
            guardarUsuario.persistirUsuario(usuarioGuardar);
        } catch (NegocioException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Información", JOptionPane.INFORMATION_MESSAGE);
        }

    }

    public void mostrarLogin() {
        if (this.frmLoginUsuario == null) {
            this.frmLoginUsuario = new Login();
            frmLoginUsuario.setLocationRelativeTo(null);
        }
        frmLoginUsuario.setVisible(true);

    }

    public void mostrarRegistroUsuario() {
        if (this.frmRegistroUsuario == null) {
            this.frmRegistroUsuario = new RegistroUsuario();
            frmRegistroUsuario.setLocationRelativeTo(null);
        }
        frmRegistroUsuario.setVisible(true);
    }

    public void mostrarMetodoPago() {
        if (this.frmMetodoPago == null) {
            this.frmMetodoPago = new MetodoPago();
            frmMetodoPago.setLocationRelativeTo(null);
        }
        frmMetodoPago.setVisible(true);  // Mostrar la ventana
    }

    public void mostrarSeleccionGeneros() {
        if (this.frmSeleccionGeneros == null) {
            this.frmSeleccionGeneros = new SeleccionGeneros();
            frmSeleccionGeneros.setLocationRelativeTo(null);
        }
        frmSeleccionGeneros.setVisible(true);
    }

    public void mostrarMembresia() {
        if (this.frmMembresia == null) {
            this.frmMembresia = new Membresias();
            this.frmMembresia.setLocationRelativeTo(null);
        }
        this.frmMembresia.setVisible(true);
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
