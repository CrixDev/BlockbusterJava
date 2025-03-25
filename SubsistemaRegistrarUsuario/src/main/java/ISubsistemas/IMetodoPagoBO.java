/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package InterfacesBO;

import DTOs.MetodoPagoDTO;
import exception.NegocioException;

/**
 *
 * @author Usuario
 */
public interface IMetodoPagoBO {
    
    public MetodoPagoDTO procesarPago(MetodoPagoDTO pagarMembresia) throws NegocioException;
    
}
