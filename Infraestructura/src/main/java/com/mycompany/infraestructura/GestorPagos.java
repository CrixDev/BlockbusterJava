/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.infraestructura;

import DTOs.MembresiaDTO;
import DTOs.NuevoPagoDTO;

/**
 *
 * @author jrasc
 */
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class GestorPagos {

    private List<Tarjeta> tarjetasRegistradas;

    public GestorPagos() {
        tarjetasRegistradas = new ArrayList<>();
        cargarTarjetasRegistradas();
    }

    private void cargarTarjetasRegistradas() {
    }

    public PagoRegistradoDTO procesarPago(NuevoPagoDTO dto, MembresiaDTO membresia) {
        Tarjeta tarjetaEntrada = new Tarjeta(dto.getNombreTitular(), dto.getNumero(), dto.getFechaExpiracion(), dto.getCvv());

        if (!tarjetaEntrada.esValida()) {
            return new PagoRegistradoDTO(false, 0, null);
        }

        if (tarjetasRegistradas.contains(tarjetaEntrada)) {
            double monto = membresia.getMonto();
            return new PagoRegistradoDTO(true, monto, new Date());
        } else {
            return new PagoRegistradoDTO(false, 0, null);
        }
    }

}
