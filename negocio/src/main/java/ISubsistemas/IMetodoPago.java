/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package ISubsistemas;

import DTOs.MetodoPagoDTO;
import exception.NegocioException;

/**
 *
 * @author Usuario
 */
public interface IMetodoPago {

    public MetodoPagoDTO pagarMembresia(MetodoPagoDTO pagarMembresia) throws NegocioException;
    
}
