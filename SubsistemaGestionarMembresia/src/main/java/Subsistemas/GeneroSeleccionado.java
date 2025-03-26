/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Subsistemas;

import DTOs.GeneroDTO;
import ISubsistemas.IGeneroSeleccionado;
import exception.NegocioException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jrasc
 */
public class GeneroSeleccionado implements IGeneroSeleccionado {

    private List<GeneroDTO> generos;

    public GeneroSeleccionado() {
    }

    public GeneroSeleccionado(List<GeneroDTO> generos) {
        this.generos = generos;
    }

    @Override
    public List<GeneroDTO> getGenerosSeleccionados(List<GeneroDTO> generos) throws NegocioException {
        List<GeneroDTO> seleccionados = new ArrayList<>();
        for (GeneroDTO genero : generos) {
            if (genero.isSeleccionado()) {
                seleccionados.add(genero);
            }
        }
        if (seleccionados.isEmpty()) {
            throw new NegocioException("Debe seleccionar al menos un genero");
        }
        return seleccionados;
    }

}
