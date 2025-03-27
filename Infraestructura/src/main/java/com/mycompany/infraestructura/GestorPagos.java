/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.infraestructura;

import DTOs.PagoRegistradoDTO;
import DTOs.MembresiaDTO;
import DTOs.NuevoPagoDTO;
import Interfaces.IGestorPagos;

/**
 *
 * @author jrasc
 */
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class GestorPagos implements IGestorPagos {

    private List<Tarjeta> tarjetasRegistradas;

    public GestorPagos() {
        tarjetasRegistradas = new ArrayList<>();
        cargarTarjetasRegistradas();
    }

    /**
     * (( Método privado que carga manualmente una tarjeta válida en el sistema
     * con fecha de expiración en diciembre de 2025 y un saldo de 200. ))
     */
    private void cargarTarjetasRegistradas() {
        Date fecha1 = new Date(2025 - 1900, 12, 1); // Diciembre 2025
        tarjetasRegistradas.add(new Tarjeta("Jose", "Garduno", "1234567891234567", fecha1, "123", 200));

    }

    /**
     * (( Procesa un pago recibido desde un DTO con los datos de la tarjeta.
     * Verifica si la tarjeta es válida, está registrada y tiene saldo
     * suficiente. Si todo es correcto, realiza el cargo y retorna un pago
     * exitoso. En caso contrario, retorna un DTO indicando fallo en el pago. ))
     *
     * @param dto DTO con los datos del nuevo pago.
     * @param membresia DTO con información de la membresía y el monto a cobrar.
     * @return PagoRegistradoDTO con resultado del intento de pago.
     */
    @Override
    public PagoRegistradoDTO procesarPago(NuevoPagoDTO dto, MembresiaDTO membresia) {
        Date fechaExpiracion = new Date(dto.getAnioCaducidad() - 1900, dto.getMesCaducidad(), 1);

        Tarjeta tarjetaEntrada = new Tarjeta(dto.getNombreTitular(),
                dto.getApelllidoTitular(),
                dto.getNumero(),
                fechaExpiracion,
                dto.getCvv(),
                0);

        if (!tarjetaEntrada.esValida()) {
            return new PagoRegistradoDTO(false, 0, null);
        }

        Tarjeta tarjetaRegistrada = null;
        for (Tarjeta tarjeta : tarjetasRegistradas) {
            if (tarjeta.equals(tarjetaEntrada)) {
                tarjetaRegistrada = tarjeta;
                break;
            }
        }

        if (tarjetasRegistradas.contains(tarjetaEntrada)) {
            double monto = membresia.getMonto();
            if (tarjetaRegistrada.saldoSuficiente(monto)) {
                tarjetaRegistrada.realizarCargo(monto);
                return new PagoRegistradoDTO(true, monto, new Date());
            }else{
                return new PagoRegistradoDTO(false, 0, null);      
            }
        } else {
            return new PagoRegistradoDTO(false, 0, null);
        }
    }
}
