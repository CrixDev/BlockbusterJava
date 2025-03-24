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

    @Override
    public NewUsuarioDTO guardarUsuario(NewUsuarioDTO nuevoUsuario) throws NegocioException {
        usuariosRegistrados.add(nuevoUsuario);
        imprimirUsuarios(usuariosRegistrados);
        return nuevoUsuario;
    }

    public void imprimirUsuarios(List<NewUsuarioDTO> usuariosRegistrados) {
        if (usuariosRegistrados.isEmpty()) {
            System.out.println("📭 No hay usuarios registrados.");
            return;
        }
        System.out.println("Lista de usuarios registrados:");
        for (NewUsuarioDTO usuario : usuariosRegistrados) {
            System.out.println("----------------------------------");
            System.out.println("Nombre: " + usuario.getNombre());
            System.out.println("Apellido: " + usuario.getApellido());
            System.out.println("Teléfono: " + usuario.getNumTelefono());
            System.out.println("Correo: " + usuario.getCorreoElectronico());
            System.out.println("País: " + usuario.getPais());
            System.out.println("Fecha de nacimiento: " + usuario.getFechaNacimiento());
        }
    }

    public List<NewUsuarioDTO> getUsuariosRegistrados() throws NegocioException{
        try{
            return usuariosRegistrados;
        }catch(Exception e){
            throw new NegocioException("No se pudiero substraer la lista de usuarios");
        }
        
    }

    @Override
    public NewUsuarioDTO validarUsuario(String correo, String contraseña) throws NegocioException {      
        for(NewUsuarioDTO usuario : usuariosRegistrados){
            if (usuario.getCorreoElectronico().equals(correo)) {
               if (usuario.getContrasenia().equals(contraseña)) {
                return usuario;
            }else{
                throw new NegocioException("La contraseña es incorrecta");
              }      
           }        
        }
       throw new NegocioException("No se encontro el correo");
    }
}
