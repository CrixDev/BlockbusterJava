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
public class MembresiaServicio {
    private ValidadorMembresia validador = new ValidadorMembresia();
    
    public void procesarMembresia(String tipoMembresia) {
        try {
            MembresiaDTO membresia = new MembresiaDTO(tipoMembresia);
            validador.validarTipoMembresia(membresia);
            System.out.println("Membresía asignada correctamente: " + tipoMembresia);
        } catch (NegocioException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}

