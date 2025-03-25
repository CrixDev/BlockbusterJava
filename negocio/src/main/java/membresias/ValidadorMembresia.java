/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package membresias;

import exception.NegocioException;

/**
 *
 * @author YURLY
 */
public class ValidadorMembresia {
    public void validarTipoMembresia(MembresiaDTO membresia) throws NegocioException {
        if (membresia.getTipoMembresia() == null || membresia.getTipoMembresia().trim().isEmpty()) {
            throw new NegocioException("Debe seleccionar un tipo de membresía válido.");
        }
        
        String tipo = membresia.getTipoMembresia().toLowerCase();
        if (!tipo.equals("basica") && !tipo.equals("pro") && !tipo.equals("premium")) {
            throw new NegocioException("El tipo de membresía debe ser: Básica, Pro o Premium.");
        }
    }
}
