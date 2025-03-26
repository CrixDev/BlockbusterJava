/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.infraestructura;

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

    private void cargarTarjetasRegistradas() {
        Date fecha1 = new Date(2025 - 1900, 11, 1);
        tarjetasRegistradas.add(new Tarjeta("Juan Pérez", "1234567812345678", fecha1, "123"));

        Date fecha2 = new Date(2026 - 1900, 4, 1);
        tarjetasRegistradas.add(new Tarjeta("Ana López", "8765432187654321", fecha2, "456"));
    }

    @Override
    public PagoRegistradoDTO procesarPago(NuevoPagoDTO dto, MembresiaDTO membresia) {
        Date fechaExpiracion = new Date(dto.getAnioCaducidad() - 1900, dto.getMesCaducidad(), 1);

        Tarjeta tarjetaEntrada = new Tarjeta(
                dto.getNombreTitular(),
                dto.getNumero(),
                fechaExpiracion,
                dto.getCvv()
        );

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
