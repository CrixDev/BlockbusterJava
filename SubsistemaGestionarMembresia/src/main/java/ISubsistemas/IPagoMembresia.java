/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package ISubsistemas;

import DTOs.MembresiaDTO;
import DTOs.MetodoPagoDTO;
import exception.NegocioException;

/**
 *
 * @author Usuario
 */
public interface IPagoMembresia {
    
     public MetodoPagoDTO validarFormatoPago(MetodoPagoDTO metodoPago)throws NegocioException;
     public MetodoPagoDTO guardarPago(MetodoPagoDTO metodoPago) throws NegocioException;
}
