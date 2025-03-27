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

    /**
     * (( Intenta registrar un nuevo usuario utilizando los datos
     * proporcionados. Si el registro es exitoso, avanza a la selección de
     * géneros. Muestra mensajes informativos si ocurre una excepción de
     * negocio. ))
     *
     * @param nuevoUsuario Datos del nuevo usuario a registrar.
     * @return NewUsuarioDTO con los datos registrados o null si hay error.
     */
    public NewUsuarioDTO intentarRegistrarUsuario(NewUsuarioDTO nuevoUsuario) {
        try {
            this.usuarioSeleccionado = usuarioNuevo.validarRegistroUsuario(nuevoUsuario);
            mostrarSeleccionGeneros();
            cerrarVentana(frmRegistroUsuario);
            return usuarioSeleccionado;
        } catch (NegocioException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Información", JOptionPane.INFORMATION_MESSAGE);
            return null;
        }
    }

    /**
     * (( Permite seleccionar los géneros preferidos del usuario. Si se
     * seleccionan correctamente, se muestra la pantalla de membresía. ))
     *
     * @param generos Lista de géneros seleccionados por el usuario.
     * @return Lista de GeneroDTO seleccionados o null si hay error.
     */
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

    /**
     * (( Permite seleccionar una membresía y valida que sea una opción válida.
     * Si es correcta, se muestra la pantalla de método de pago. ))
     *
     * @param membresia Membresía seleccionada por el usuario.
     * @return MembresiaDTO validada o null si hay error.
     */
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

    /**
     * (( Procesa el pago del usuario validando el método de pago ingresado. Si
     * el pago es exitoso, lo guarda y muestra el login. ))
     *
     * @param pagoDTO Datos del método de pago.
     * @param membresia Membresía a pagar.
     * @return PagoRegistradoDTO si el pago es exitoso o null si falla.
     */
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
                metodoPagoSeleccionado = resultado;
                JOptionPane.showMessageDialog(null, "Pago realizado con éxito. Monto: $" + resultado.getMonto());
                cerrarVentana(frmMetodoPago);
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

    /**
     * (( Construye un UsuarioDTO final con todos los datos recolectados y lo
     * guarda en el sistema. Limpia las pantallas y variables de sesión. ))
     */
    public void guardarUsuario() {
        try {
            NewUsuarioDTO datosUsuario = getNuevoUsuario();
            List<GeneroDTO> generos = getGenerosSeleccionados();
            MembresiaDTO membresia = getMembresiaSeleccionada();
            PagoRegistradoDTO pagoRegistrado = getProcesarPago();
            UsuarioDTO usuarioGuardar = new UsuarioDTO(datosUsuario, membresia, generos, pagoRegistrado);
            guardarUsuario.persistirUsuario(usuarioGuardar);
            membresiaSeleccionada = null;
            usuarioSeleccionado = null;
            generosSeleccionados = null;
            metodoPagoSeleccionado = null;
            frmMembresia.limpiarSeleccion();
            frmRegistroUsuario.limpiarCampos();
            frmMetodoPago.limpiarCampos();
            frmSeleccionGeneros.limpiarCampos();

        } catch (NegocioException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Información", JOptionPane.INFORMATION_MESSAGE);
        }

    }

    /**
     * (( Muestra la ventana de login de usuario. Si no existe, la instancia. ))
     */
    public void mostrarLogin() {
        if (this.frmLoginUsuario == null) {
            this.frmLoginUsuario = new Login();
            frmLoginUsuario.setLocationRelativeTo(null);
        }
        frmLoginUsuario.setVisible(true);

    }

    /**
     * (( Muestra la ventana de registro de usuario. Cierra la de login si está
     * activa. ))
     */
    public void mostrarRegistroUsuario() {
        cerrarVentana(frmLoginUsuario);
        if (this.frmRegistroUsuario == null) {
            this.frmRegistroUsuario = new RegistroUsuario();
            frmRegistroUsuario.setLocationRelativeTo(null);
        }
        frmRegistroUsuario.limpiarCampos();
        frmRegistroUsuario.setVisible(true);
    }

    /**
     * (( Muestra la ventana de método de pago. Si no existe, la instancia. ))
     */
    public void mostrarMetodoPago() {
        if (this.frmMetodoPago == null) {
            this.frmMetodoPago = new MetodoPago();
            frmMetodoPago.setLocationRelativeTo(null);
        }
        frmMetodoPago.limpiarCampos();
        frmMetodoPago.setVisible(true);
    }

    /**
     * (( Muestra la ventana de selección de géneros. Si no existe, la
     * instancia. ))
     */
    public void mostrarSeleccionGeneros() {
        if (this.frmSeleccionGeneros == null) {
            this.frmSeleccionGeneros = new SeleccionGeneros();
            frmSeleccionGeneros.setLocationRelativeTo(null);
        }
        frmSeleccionGeneros.limpiarCampos();
        frmSeleccionGeneros.setVisible(true);
    }

    /**
     * (( Muestra la ventana de membresía. Si no existe, la instancia. ))
     */
    public void mostrarMembresia() {
        if (this.frmMembresia == null) {
            this.frmMembresia = new Membresias();
            this.frmMembresia.setLocationRelativeTo(null);
        }
        frmMembresia.limpiarSeleccion();
        this.frmMembresia.setVisible(true);
    }

    /**
     * (( Cierra la ventana pasada como parámetro si no es null. ))
     *
     * @param ventanaActual Ventana que se desea cerrar.
     */
    public void cerrarVentana(javax.swing.JFrame ventanaActual) {
        if (ventanaActual != null) {
            ventanaActual.dispose();
        }
    }

    /**
     * (( Obtiene los datos del usuario nuevo ya validados. ))
     *
     * @return NewUsuarioDTO con los datos del usuario.
     */
    public NewUsuarioDTO getNuevoUsuario() {
        return usuarioSeleccionado;
    }
    /**
     * (( Retorna la lista de géneros seleccionados por el usuario. ))
     *
     * @return Lista de GeneroDTO.
     */
    public List<GeneroDTO> getGenerosSeleccionados() {
        return generosSeleccionados;
    }
    /**
     * (( Obtiene la membresía seleccionada por el usuario. ))
     *
     * @return MembresiaDTO.
     */
    public MembresiaDTO getMembresiaSeleccionada() {
        return membresiaSeleccionada;
    }
    /**
     * (( Obtiene el resultado del pago procesado. ))
     *
     * @return PagoRegistradoDTO si el pago fue válido, o null.
     */
    public PagoRegistradoDTO getProcesarPago() {
        return metodoPagoSeleccionado;
    }

}
