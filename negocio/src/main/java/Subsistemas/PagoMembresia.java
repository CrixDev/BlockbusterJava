/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Subsistemas;

import DTOs.MetodoPagoDTO;
import ISubsistemas.IMetodoPago;
import exception.NegocioException;
import java.math.BigDecimal;
import java.util.Date;

/**
 *
 * @author Usuario
 */
public class PagoMembresia implements IMetodoPago {

    @Override
    public MetodoPagoDTO pagarMembresia(MetodoPagoDTO pagarMembresia) throws NegocioException {
        validarNombreTitular(pagarMembresia);
        validarDireccion(pagarMembresia);
        validarNumeroTarjeta(pagarMembresia);
        validarFechaExpiracion(pagarMembresia);
        validarCVV(pagarMembresia);
        validarMonto(pagarMembresia);
        return pagarMembresia;
    }

    private void validarNombreTitular(MetodoPagoDTO pagarMembresia) throws NegocioException {
        String nombre = pagarMembresia.getNombreTitular();
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new NegocioException("El nombre del titular no puede estar vacío.");
        }
        if (!nombre.matches("^[a-zA-ZáéíóúÁÉÍÓÚñÑ\\s]{2,50}$")) {
            throw new NegocioException("El nombre del titular no es válido.");
        }
    }

    private void validarApellidoTitular(MetodoPagoDTO pagarMembresia) throws NegocioException {
        String apellido = pagarMembresia.getApellidoTitular();
        if (apellido == null || apellido.trim().isEmpty()) {
            throw new NegocioException("El apellido del titular no puede estar vacío.");
        }
        if (!apellido.matches("^[a-zA-ZáéíóúÁÉÍÓÚñÑ\\s]{2,50}$")) {
            throw new NegocioException("El apellido del titular no es válido.");
        }
    }

    // Algoritmo de Luhn
    private boolean esTarjetaValida(String numeroTarjeta) {
       //Este metodo verifica que la tarjeta sea de 16 digitos
        int suma = 0;
        boolean alternar = false;
          
        for (int i = numeroTarjeta.length() - 1; i >= 0; i--) {
            int n = Integer.parseInt(numeroTarjeta.substring(i, i + 1));
            if (alternar) {
                n *= 2;
                if (n > 9) {
                    n = (n % 10) + 1;       
                }
            }
            suma += n;
            alternar = !alternar;
        }

        return (suma % 10 == 0);
    }

    private void validarNumeroTarjeta(MetodoPagoDTO pagarMembresia) throws NegocioException {
        String numeroTarjeta = pagarMembresia.getNumeroTarjeta();

        if (numeroTarjeta == null || numeroTarjeta.trim().isEmpty()) {
            throw new NegocioException("El número de tarjeta no puede estar vacío.");
        }

        if (!numeroTarjeta.matches("^\\d{16}$")) {
            throw new NegocioException("El número de tarjeta debe contener exactamente 16 dígitos numéricos.");
        }

        // Validación adicional opcional: usando el algoritmo de Luhn para verificar si el número es válido
        if (!esTarjetaValida(numeroTarjeta)) {
            throw new NegocioException("El número de tarjeta no es válido.");
        }
    }

    private void validarDireccion(MetodoPagoDTO pagarMembresia) throws NegocioException {
        if (pagarMembresia.getDireccionFacturacion() == null || pagarMembresia.getDireccionFacturacion().trim().isEmpty()) {
            throw new NegocioException("La dirección de facturación no puede estar vacía.");
        }
    }

    private void validarTarjeta(MetodoPagoDTO pagarMembresia) throws NegocioException {
        if (pagarMembresia.getNumeroTarjeta() == null || !pagarMembresia.getNumeroTarjeta().matches("\\d{16}")) {
            throw new NegocioException("El número de tarjeta debe tener 16 dígitos numéricos.");
        }
    }

    private void validarCVV(MetodoPagoDTO pagarMembresia) throws NegocioException {
        if (pagarMembresia.getCvv() == null || !pagarMembresia.getCvv().matches("\\d{3}")) {
            throw new NegocioException("El CVV debe tener exactamente 3 dígitos.");
        }
    }

    private void validarFechaExpiracion(MetodoPagoDTO pagarMembresia) throws NegocioException {
        Date hoy = new Date();
        if (pagarMembresia.getFechaExpiracion() == null || pagarMembresia.getFechaExpiracion().before(hoy)) {
            throw new NegocioException("La tarjeta está vencida.");
        }
    }

    private void validarMetodoPago(MetodoPagoDTO pagarMembresia) throws NegocioException {
        String metodo = pagarMembresia.getMetodoPago();
        if (metodo == null || (!metodo.equalsIgnoreCase("Oxxo") && !metodo.equalsIgnoreCase("PayPal"))) {
            throw new NegocioException("El método de pago debe ser Oxxo o PayPal.");
        }
    }

    private void validarMonto(MetodoPagoDTO pagarMembresia) throws NegocioException {
        BigDecimal monto = pagarMembresia.getMonto();
        if (monto == null || monto.compareTo(BigDecimal.ZERO) <= 0) {
            throw new NegocioException("El monto del pago debe ser mayor a cero.");
        }
    }
}
