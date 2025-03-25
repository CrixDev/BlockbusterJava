/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTOs;

/**
 *
 * @author jrasc
 */
public class MembresiaDTO {
    
    private String nombre;
    private String descripcion;
    private double monto;

    public MembresiaDTO() {
    }

    public MembresiaDTO(String nombre, String descripcion, double monto) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.monto = monto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    @Override
    public String toString() {
        return "MembresiaDTO{" + "nombre=" + nombre + ", descripcion=" + descripcion + ", monto=" + monto + '}';
    }
    
}
