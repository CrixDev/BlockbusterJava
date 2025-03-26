package Subsistemas;

import DTOs.MembresiaDTO;
import ISubsistemas.IElegirMembresia;
import exception.NegocioException;


/* 
    devor
*/


public class ElegirMembresia implements IElegirMembresia {

    @Override
    public MembresiaDTO validarEleccionMembresia(MembresiaDTO elegirMembresia) throws NegocioException {
        if (elegirMembresia == null) {
            throw new NegocioException("No se ha seleccionado ninguna membresía");
        }
        
        return elegirMembresia;
    }
}