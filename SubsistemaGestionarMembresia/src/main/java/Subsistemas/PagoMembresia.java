/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Subsistemas;

import DTOs.MembresiaDTO;
import DTOs.MetodoPagoDTO;
import DTOs.NewUsuarioDTO;
import exception.NegocioException;
import java.util.Calendar;
import java.util.Date;
import ISubsistemas.IPagoMembresia;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Usuario
 */
public class PagoMembresia implements IPagoMembresia {

    private final List<MetodoPagoDTO> pagosRegistrados = new ArrayList<>();

    @Override
    public MetodoPagoDTO validarEleccionMembresia(MetodoPagoDTO MetodoPago) throws NegocioException {

        validarFormatoNombre(MetodoPago);
        validarFormatoApellido(MetodoPago);
        validarCVV(MetodoPago);
        validarDireccion(MetodoPago);
        validarFechaCaducidad(MetodoPago);
        validarTarjeta(MetodoPago);
        guardarPago(MetodoPago);
        return MetodoPago;

    }

    public MetodoPagoDTO validarFormatoNombre(MetodoPagoDTO metodoPago) throws NegocioException {
        if (metodoPago.getNombreTitular() == null) {
            throw new NegocioException("El nombre no puede estar vacio");
        }
        if (metodoPago.getNombreTitular().length() < 2 || metodoPago.getNombreTitular().length() > 50) {
            throw new NegocioException("El nombre es demasiado largo");
        }
        if (metodoPago.getNombreTitular().matches(".*\\d.*")) {
            throw new NegocioException("El nombre no debe contener números.");
        }
        if (!metodoPago.getNombreTitular().matches("[a-zA-ZáéíóúÁÉÍÓÚñÑ\\s\\-]+")) {
            throw new NegocioException("El nombre tiene caracteres no validos");
        }
        if (metodoPago.getNombreTitular().contains("@")) {
            throw new NegocioException("Tu nombre de usuario no puede contener un correo electronico");
        }
        return metodoPago;
    }

    public MetodoPagoDTO validarFormatoApellido(MetodoPagoDTO metodoPago) throws NegocioException {
        if (metodoPago.getApellidoTitular() == null) {
            throw new NegocioException("El apellido no puede estar vacio");
        }
        if (metodoPago.getApellidoTitular().length() < 2 || metodoPago.getApellidoTitular().length() > 50) {
            throw new NegocioException("El apellido es demasiado largo");
        }
        if (metodoPago.getApellidoTitular().matches(".*\\d.*")) {
            throw new NegocioException("El apellido no puede contener numeros");
        }
        if (!metodoPago.getApellidoTitular().matches("[a-zA-ZáéíóúÁÉÍÓÚñÑ\\s\\-]+")) {
            throw new NegocioException("El nombre tiene caracteres no validos");
        }
        if (metodoPago.getApellidoTitular().contains("@")) {
            throw new NegocioException("Tu nombre de usuario no puede contener tu apellido");
        }
        return metodoPago;
    }

    public MetodoPagoDTO validarFechaCaducidad(MetodoPagoDTO metodoPago) throws NegocioException {
        Date fecha = metodoPago.getFechaCaducidad(); // tipo java.util.Date

        if (fecha == null) {
            throw new NegocioException("La fecha de caducidad no puede estar vacía.");
        }

        Calendar fechaCaducidad = Calendar.getInstance();
        fechaCaducidad.setTime(fecha);

        Calendar hoy = Calendar.getInstance();

        // Comparar por año y mes (ignorar día)
        int mesTarjeta = fechaCaducidad.get(Calendar.MONTH);
        int anioTarjeta = fechaCaducidad.get(Calendar.YEAR);

        int mesActual = hoy.get(Calendar.MONTH);
        int anioActual = hoy.get(Calendar.YEAR);

        if (anioTarjeta < anioActual || (anioTarjeta == anioActual && mesTarjeta < mesActual)) {
            throw new NegocioException("La tarjeta ya ha vencido.");
        }

        return metodoPago;
    }

    public MetodoPagoDTO validarTarjeta(MetodoPagoDTO metodoPago) throws NegocioException {
        String numeroTarjeta = metodoPago.getNumeroTarjeta();

        if (numeroTarjeta == null || numeroTarjeta.trim().isEmpty()) {
            throw new NegocioException("El número de tarjeta no puede estar vacío.");
        }

        // Validar formato: xxxx-xxxx-xxxx-xxxx (16 dígitos con guiones)
        if (!numeroTarjeta.matches("^\\d{4}-\\d{4}-\\d{4}-\\d{4}$")) {
            throw new NegocioException("El número de tarjeta debe tener el formato xxxx-xxxx-xxxx-xxxx.");
        }

        return metodoPago;
    }

    public MetodoPagoDTO validarDireccion(MetodoPagoDTO metodoPago) throws NegocioException {
        String direccion = metodoPago.getDireccionFacturacion();

        if (direccion == null || direccion.trim().isEmpty()) {
            throw new NegocioException("La dirección no puede estar vacía.");
        }

        if (direccion.length() < 5 || direccion.length() > 100) {
            throw new NegocioException("La dirección debe tener entre 5 y 100 caracteres.");
        }

        // Permitir letras, números, espacios y algunos símbolos comunes
        if (!direccion.matches("^[a-zA-Z0-9áéíóúÁÉÍÓÚñÑ #,.-]+$")) {
            throw new NegocioException("La dirección contiene caracteres no válidos.");
        }

        return metodoPago;
    }

    public MetodoPagoDTO validarCVV(MetodoPagoDTO metodoPago) throws NegocioException {
        String cvv = metodoPago.getCvv();

        if (cvv == null || cvv.trim().isEmpty()) {
            throw new NegocioException("El CVV no puede estar vacío.");
        }

        if (!cvv.matches("^\\d{3}$")) {
            throw new NegocioException("El CVV debe contener exactamente 3 dígitos numéricos.");
        }

        return metodoPago;
    }

    public MetodoPagoDTO guardarPago(MetodoPagoDTO metodoPago) throws NegocioException {
        validarEleccionMembresia(metodoPago);

        pagosRegistrados.add(metodoPago);
        return metodoPago;
    }

}
