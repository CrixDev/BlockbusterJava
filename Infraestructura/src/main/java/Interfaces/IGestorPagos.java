/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Interfaces;

import DTOs.MembresiaDTO;
import DTOs.NuevoPagoDTO;
import com.mycompany.infraestructura.PagoRegistradoDTO;

/**
 *
 * @author jrasc
 */
public interface IGestorPagos {

    public PagoRegistradoDTO procesarPago(NuevoPagoDTO dto, MembresiaDTO membresia);
}
