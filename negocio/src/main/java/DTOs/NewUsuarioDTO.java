/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTOs;

import java.util.Date;

/**
 *
 * @author jrasc
 */
public class NewUsuarioDTO {
    
    private String nombre;
    private String apellido;
    private String numTelefono;
    private String contrasenia;
    private String pais;
    private Date fechaNacimiento;
    private String direccion;
    private String correoElectronico;
    private String confirmarContrasenia;

    public NewUsuarioDTO() {
    }

    public NewUsuarioDTO(String nombre, String apellido, String numTelefono, String contrasenia, String pais, Date fechaNacimiento, String direccion, String correoElectronico, String confirmarContrasenia) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.numTelefono = numTelefono;
        this.contrasenia = contrasenia;
        this.pais = pais;
        this.fechaNacimiento = fechaNacimiento;
        this.direccion = direccion;
        this.correoElectronico = correoElectronico;
        this.confirmarContrasenia = confirmarContrasenia;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public String getConfirmarContrasenia() {
        return confirmarContrasenia;
    }

    public void setConfirmarContrasenia(String confirmarContrasenia) {
        this.confirmarContrasenia = confirmarContrasenia;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNumTelefono() {
        return numTelefono;
    }

    public void setNumTelefono(String numTelefono) {
        this.numTelefono = numTelefono;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    @Override
    public String toString() {
        return "NewUsuarioDTO{" + "nombre=" + nombre + ", apellido=" + apellido + ", numTelefono=" + numTelefono + ", contrasenia=" + contrasenia + ", pais=" + pais + ", fechaNacimiento=" + fechaNacimiento + ", direccion=" + direccion + '}';
    }

}
