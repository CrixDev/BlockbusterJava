/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Subsistemas;

import BO.UsuarioBO;
import DTOs.NewUsuarioDTO;
import ISubsistemas.IRegistrarUsuario;
import InterfacesBO.IUsuarioBO;
import exception.NegocioException;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author jrasc
 */
public class RegistrarUsuario implements IRegistrarUsuario {

    private IUsuarioBO registrar = new UsuarioBO();

    @Override
    public NewUsuarioDTO registrarUsuario(NewUsuarioDTO nuevoUsuario) throws NegocioException {
        try {
            List<NewUsuarioDTO> usuarios = registrar.getUsuariosRegistrados();
            validarFormatoNombre(nuevoUsuario);
            validarFormatoApellido(nuevoUsuario);
            validarFormatoNumeroTelefonico(nuevoUsuario);
            validarPaisExistente(nuevoUsuario);
            validarFormatoCorreo(nuevoUsuario);
            validarformatoContrasenia(nuevoUsuario);
            validarUsuario(nuevoUsuario, usuarios);
            registrar.guardarUsuario(nuevoUsuario);
        } catch (NegocioException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error de validación", JOptionPane.ERROR_MESSAGE);
        }
        return nuevoUsuario;
    }

    public NewUsuarioDTO validarFormatoNombre(NewUsuarioDTO nuevoUsuario) throws NegocioException {
        if (nuevoUsuario.getNombre() == null) {
            throw new NegocioException("El nombre no puede estar vacio");
        }
        if (nuevoUsuario.getNombre().length() < 2 || nuevoUsuario.getNombre().length() > 50) {
            throw new NegocioException("El nombre es demasiado largo");
        }
        if (nuevoUsuario.getNombre().matches(".*\\d.*")) {
            throw new NegocioException("El nombre no debe contener números.");
        }
        if (!nuevoUsuario.getNombre().matches("[a-zA-ZáéíóúÁÉÍÓÚñÑ\\s\\-]+")) {
            throw new NegocioException("El nombre tiene caracteres no validos");
        }
        if (nuevoUsuario.getNombre().contains("@")) {
            throw new NegocioException("Tu nombre de usuario no puede contener un correo electronico");
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
        if (nuevoUsuario.getApellido().contains("@")) {
            throw new NegocioException("Tu nombre de usuario no puede contener tu apellido");
        }
        return nuevoUsuario;
    }

    public NewUsuarioDTO validarFormatoNumeroTelefonico(NewUsuarioDTO nuevoUsuario) throws NegocioException {
        // String[] areaCodeValid = {"+52"};

        if (nuevoUsuario.getNumTelefono() == null) {
            throw new NegocioException("El numero telefonico no puede estar vacio");
        }
        if (nuevoUsuario.getNumTelefono().length() != 10) {
            throw new NegocioException("Le faltan digitos a tu numero telefonico");
        }
        /* queda pendientee
        boolean ladaValida = Arrays.stream(areaCodeValid)
                .anyMatch(nuevoUsuario.getNumTelefono()::startsWith);
        if (!ladaValida) {
            throw new NegocioException("El código de área no es válido.");
        }
         */
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

    public NewUsuarioDTO validarFormatoFecha(NewUsuarioDTO nuevoUsuario) throws NegocioException {
        Date fechaNacimiento = nuevoUsuario.getFechaNacimiento();
        if (fechaNacimiento == null) {
            throw new NegocioException("La fecha de nacimiento no puede estar vacia");
        }

        Date hoy = new Date();
        if (fechaNacimiento.after(hoy)) {
            throw new NegocioException("La fecha de nacimiento no puede estar en el futuro");
        }

        Calendar nacimiento = Calendar.getInstance();
        nacimiento.setTime(fechaNacimiento);
        Calendar actual = Calendar.getInstance();

        int edad = actual.get(Calendar.YEAR) - nacimiento.get(Calendar.YEAR);
        if (actual.get(Calendar.MONTH) < nacimiento.get(Calendar.MONTH)
                || (actual.get(Calendar.MONTH) == nacimiento.get(Calendar.MONTH)
                && actual.get(Calendar.DAY_OF_MONTH) < nacimiento.get(Calendar.DAY_OF_MONTH))) {
            edad--;
        }

        if (edad < 18) {
            throw new NegocioException("El usuario debe tener al menos 18 años.");
        }

        return nuevoUsuario;
    }

    public NewUsuarioDTO validarFormatoCorreo(NewUsuarioDTO nuevoUsuario) throws NegocioException {
        if (nuevoUsuario.getCorreoElectronico() == null) {
            throw new NegocioException("El correo no puede estar vacio");
        }
        if (!nuevoUsuario.getCorreoElectronico().matches("^[\\w.-]+@[\\w.-]+\\.[a-zA-Z]{2,}$")) {
            throw new NegocioException("El formato del correo no es valido");
        }
        return nuevoUsuario;
    }

    public NewUsuarioDTO validarformatoContrasenia(NewUsuarioDTO nuevoUsuario) throws NegocioException {
        if (nuevoUsuario.getContrasenia() == null) {
            throw new NegocioException("La contrasenia no puede estar vacia");
        }
        if (nuevoUsuario.getContrasenia().length() < 8 || nuevoUsuario.getContrasenia().length() > 15) {
            throw new NegocioException("La contrasenia deber tener entre 8 y 15 caracteres");
        }
        if (!nuevoUsuario.getContrasenia().matches(".*[A-Z].*")) {
            throw new NegocioException("La contraseña debe contener al menos una letra mayúscula.");
        }

        if (!nuevoUsuario.getContrasenia().matches(".*[a-z].*")) {
            throw new NegocioException("La contraseña debe contener al menos una letra minúscula.");
        }

        if (!nuevoUsuario.getContrasenia().matches(".*\\d.*")) {
            throw new NegocioException("La contraseña debe contener al menos un número.");
        }

        if (!nuevoUsuario.getContrasenia().matches(".*[!@#$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>\\/?].*")) {
            throw new NegocioException("La contraseña debe contener al menos un carácter especial.");
        }

        if (nuevoUsuario.getContrasenia().contains(" ")) {
            throw new NegocioException("La contraseña no debe contener espacios.");
        }
        if (nuevoUsuario.getConfirmarContrasenia() == null) {
            throw new NegocioException("Asegurate de poner la misma contrasenia");
        }
        return nuevoUsuario;
    }

    public NewUsuarioDTO validarUsuario(NewUsuarioDTO nuevoUsuario, List<NewUsuarioDTO> usuariosRegistrados) throws NegocioException {
        for (NewUsuarioDTO usuario : usuariosRegistrados) {
            if (usuario.getCorreoElectronico().equalsIgnoreCase(nuevoUsuario.getCorreoElectronico())) {
                throw new NegocioException("Este correo ya está registrado");
            }
        }

        for (NewUsuarioDTO usuario : usuariosRegistrados) {
            if (usuario.getNumTelefono().equalsIgnoreCase(nuevoUsuario.getNumTelefono())) {
                throw new NegocioException("Este número de teléfono ya está registrado");
            }
        }

        return nuevoUsuario;
    }

}
