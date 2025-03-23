/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BO;

import DTOs.NewUsuarioDTO;
import InterfacesBO.IUsuarioBO;
import exception.NegocioException;

/**
 *
 * @author jrasc
 */
public class UsuarioBO implements IUsuarioBO {

    @Override
    public NewUsuarioDTO registrarUsuario(NewUsuarioDTO nuevoUsuario) throws NegocioException {
        return nuevoUsuario;
    }
    
}
