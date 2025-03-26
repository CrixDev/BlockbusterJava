/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package ISubsistemas;

import DTOs.GeneroDTO;
import exception.NegocioException;
import java.util.List;

/**
 *
 * @author jrasc
 */
public interface IGeneroSeleccionado {
    
    public List<GeneroDTO> getGenerosSeleccionados(List<GeneroDTO> generos) throws NegocioException;
    
}
