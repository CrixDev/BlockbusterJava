/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package ISubsistemas;

import DTOs.UsuarioDTO;
import exception.NegocioException;

/**
 *
 * @author jrasc
 */
public interface IGuardarUsuario {
    
    public void persistirUsuario(UsuarioDTO usuario) throws NegocioException;
    
    
}
