/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package ISubsistemas;

import DTOs.NewUsuarioDTO;
import exception.NegocioException;

/**
 *
 * @author jrasc
 */
public interface IRegistrarUsuario {
    
    public NewUsuarioDTO validarRegistroUsuario(NewUsuarioDTO nuevoUsuario)throws NegocioException;
    public NewUsuarioDTO guardarUsuario(NewUsuarioDTO nuevoUsuario) throws NegocioException;
    
    public NewUsuarioDTO validarUsuario(String correo, String contraseña) throws NegocioException;
}
