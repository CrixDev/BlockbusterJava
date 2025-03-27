/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Subsistemas;

import DTOs.NewUsuarioDTO;
import ISubsistemas.IRegistrarUsuario;
import exception.NegocioException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 *
 * @author jrasc
 */
public class RegistrarUsuario implements IRegistrarUsuario {

    private List<NewUsuarioDTO> usuariosRegistrados = new ArrayList<>();

    //Realiza la validación completa del registro de un nuevo usuario. Llama a cada método de validación individual para verificar los campos.
    @Override
    public NewUsuarioDTO validarRegistroUsuario(NewUsuarioDTO nuevoUsuario) throws NegocioException {
        List<NewUsuarioDTO> usuarios = usuariosRegistrados;
        validarFormatoNombre(nuevoUsuario);
        validarFormatoApellido(nuevoUsuario);
        validarFormatoNumeroTelefonico(nuevoUsuario);
        validarPaisExistente(nuevoUsuario);
        validarFormatoCorreo(nuevoUsuario);
        validarformatoContrasenia(nuevoUsuario);
        validarUsuario(nuevoUsuario, usuariosRegistrados);
        validarFormatoFecha(nuevoUsuario);
        return nuevoUsuario;
    }

    //Valida que el nombre del usuario sea válido.
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

    //Valida que el apellido del usuario sea válido.
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
        if (!nuevoUsuario.getApellido().matches("[a-zA-ZáéíóúÁÉÍÓÚñÑ\\s\\-]+")) {
            throw new NegocioException("El nombre tiene caracteres no validos");
        }
        if (nuevoUsuario.getApellido().contains("@")) {
            throw new NegocioException("Tu nombre de usuario no puede contener tu apellido");
        }
        return nuevoUsuario;
    }

    //Valida que el número telefónico tenga el formato correcto (10 dígitos).
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
        return nuevoUsuario;
    }

    // Verifica que el país del usuario esté dentro de una lista de países válidos.
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

    //Valida que la fecha de nacimiento no sea futura y que el usuario tenga al menos 18 años.   
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

    // Valida que el correo electrónico tenga un formato correcto.
    public NewUsuarioDTO validarFormatoCorreo(NewUsuarioDTO nuevoUsuario) throws NegocioException {
        if (nuevoUsuario.getCorreoElectronico() == null) {
            throw new NegocioException("El correo no puede estar vacio");
        }
        if (!nuevoUsuario.getCorreoElectronico().matches("^[\\w.-]+@[\\w.-]+\\.[a-zA-Z]{2,}$")) {
            throw new NegocioException("El formato del correo no es valido");
        }
        return nuevoUsuario;
    }

    //Valida que la contraseña cumpla con los requisitos de seguridad. Verifica longitud, caracteres especiales, números, mayúsculas y minúsculas.
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

    // Verifica si el correo electrónico o número telefónico ya existen en la lista de usuarios registrados.
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

    /*
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

    public List<NewUsuarioDTO> getUsuariosRegistrados() throws NegocioException {
        try {
            return usuariosRegistrados;
        } catch (Exception e) {
            throw new NegocioException("No se pudiero substraer la lista de usuarios");
        }

    }*/
}
