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

    //Persiste un nuevo usuario en la lista de usuarios registrados.

    @Override
    public void persistirUsuario(UsuarioDTO usuario) throws NegocioException {
        usuariosRegistrados.add(usuario);
    }

    //Obtiene la lista de todos los usuarios registrados.
    public List<UsuarioDTO> obtenerUsuarios() {
        return usuariosRegistrados;
    }
    
    // Imprime en consola todos los usuarios registrados. Útil para depuración y visualización temporal.
    public void imprimirUsuarios(){
        for (UsuarioDTO usuario : usuariosRegistrados) {
            System.out.println(usuario);
        }
    }
}
