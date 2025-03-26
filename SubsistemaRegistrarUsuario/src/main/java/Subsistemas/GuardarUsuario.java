/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Subsistemas;

import DTOs.UsuarioDTO;
import ISubsistemas.IGuardarUsuario;
import exception.NegocioException;
import java.util.List;

/**
 *
 * @author jrasc
 */
public class GuardarUsuario implements IGuardarUsuario {

    private List<UsuarioDTO> usuariosRegistrados;

    @Override
    public void persistirUsuario(UsuarioDTO usuario) throws NegocioException {
        usuariosRegistrados.add(usuario);
    }

    public List<UsuarioDTO> obtenerUsuarios() {
        return usuariosRegistrados;
    }
}
