/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BO;

import DTOs.NewUsuarioDTO;
import ISubsistemas.IRegistrarUsuario;
import InterfacesBO.IUsuarioBO;
import exception.NegocioException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jrasc
 */
public class UsuarioBO implements IUsuarioBO {

    private List<NewUsuarioDTO> usuariosRegistrados = new ArrayList<>();
    private IRegistrarUsuario validarUsuario;
    
    @Override
    public NewUsuarioDTO guardarUsuario(NewUsuarioDTO nuevoUsuario) throws NegocioException {
        validarUsuario.registrarUsuario(nuevoUsuario);
        usuariosRegistrados.add(nuevoUsuario);
        return nuevoUsuario;
    }
    
}
