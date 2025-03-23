/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package InterfacesBO;

import DTOs.NewUsuarioDTO;
import exception.NegocioException;
import java.util.List;

/**
 *
 * @author jrasc
 */
public interface IUsuarioBO {
    
    public NewUsuarioDTO guardarUsuario(NewUsuarioDTO nuevoUsuario) throws NegocioException;
    public List<NewUsuarioDTO> getUsuariosRegistrados() throws NegocioException;
    
}
