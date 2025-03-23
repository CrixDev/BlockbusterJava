/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Subsistemas;

import DTOs.NewUsuarioDTO;
import ISubsistemas.IRegistrarUsuario;
import exception.NegocioException;
import java.util.Arrays;

/**
 *
 * @author jrasc
 */
public class RegistrarUsuario implements IRegistrarUsuario {

    @Override
    public NewUsuarioDTO registrarUsuario(NewUsuarioDTO nuevoUsuario) throws NegocioException {
        validarFormatoNombre(nuevoUsuario);
        validarFormatoApellido(nuevoUsuario);
        return nuevoUsuario;
    }

    public NewUsuarioDTO validarFormatoNombre(NewUsuarioDTO nuevoUsuario) throws NegocioException {
        if (nuevoUsuario.getNombre() == null) {
            throw new NegocioException("El nombre no puede venir vacio");
        }
        if (nuevoUsuario.getNombre().length() < 2 || nuevoUsuario.getNombre().length() > 50) {
            throw new NegocioException("El nombre es demasiado largo");
        }
        if (nuevoUsuario.getNombre().matches(".*\\d.*")) {
            throw new NegocioException("El nombre no debe contener números.");
        }
        if (nuevoUsuario.getNombre().matches("[a-zA-ZáéíóúÁÉÍÓÚñÑ\\\\s-]+")) {
            throw new NegocioException("El nombre tiene caracteres no validos");
        }
        if (nuevoUsuario.getNombre().contains("@")) {
            throw new NegocioException("Tu nombre de usuario no puede contener tu nombre");
        }
        return nuevoUsuario;
    }

    public NewUsuarioDTO validarFormatoApellido(NewUsuarioDTO nuevoUsuario) throws NegocioException {
        if (nuevoUsuario.getApellido() == null) {
            throw new NegocioException("El apellido no puede estar vacio");
        }
        if (nuevoUsuario.getApellido().length() < 2 || nuevoUsuario.getApellido().length() > 50) {
            throw new NegocioException("El apellido es demasiado largo");
        }
        if (nuevoUsuario.getApellido().matches(".*\\d.*")) {
            throw new NegocioException("El apellido no puede contener numeros");
        }
        if (nuevoUsuario.getApellido().matches("[a-zA-ZáéíóúÁÉÍÓÚñÑ\\\\s-]")) {
            throw new NegocioException("El nombre tiene caracteres no validos");
        }
        if (nuevoUsuario.getNombre().contains("@")) {
            throw new NegocioException("Tu nombre de usuario no puede contener tu apellido");
        }
        return nuevoUsuario;
    }

    public NewUsuarioDTO validarFormatoNumeroTelefonico(NewUsuarioDTO nuevoUsuario) throws NegocioException {
        String[] areaCodeValid = {"+52"};

        if (nuevoUsuario.getNumTelefono() == null) {
            throw new NegocioException("El numero telefonico no puede estar vacio");
        }
        if (nuevoUsuario.getNumTelefono().length() != 10) {
            throw new NegocioException("Le faltan digitos a tu numero telefonico");
        }
        boolean ladaValida = Arrays.stream(areaCodeValid)
                .anyMatch(nuevoUsuario.getNumTelefono()::startsWith);
        if (!ladaValida) {
            throw new NegocioException("El código de área no es válido.");
        }
        if (nuevoUsuario.getNumTelefono().matches("\\d{10}")) {
        }
        return nuevoUsuario;
    }

    public NewUsuarioDTO validarPaisExistente(NewUsuarioDTO nuevoUsuario) throws NegocioException {
        String[] validCountries = {"Mexico"};

        boolean isValid = false;
        for (String pais : validCountries) {
            if (nuevoUsuario.getPais().equalsIgnoreCase(pais)) {
                isValid = true;
                break;
            }
        }
        if (!isValid) {
            throw new NegocioException("Country is not valid.");
        }
        return nuevoUsuario;
    }
    
    public NewUsuarioDTO validarFormatoCorreo(NewUsuarioDTO nuevoUsuario) throws NegocioException{
        
    }
}
