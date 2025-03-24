
package DTOs;

/**
 *
 * @author payde
 */
public class CredencialesUsuarioDTO {
    private String correo;
    private String contraseña;

    public CredencialesUsuarioDTO(String correo, String contraseña) {
        this.correo = correo;
        this.contraseña = contraseña;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    @Override
    public String toString() {
        return "CredencialesDTO{" + "correo=" + correo + ", contrase\u00f1a=" + contraseña + '}';
    }
    
    
}
