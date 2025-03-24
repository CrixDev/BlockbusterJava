/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTOs;

/**
 *
 * @author payde
 */
public class MembresiaDTO {
    private String nombreMembresia;
    private float precioMembrecia;
    private String descripcionMembresia;
    private Integer tiempoAcceso;

    public MembresiaDTO(String nombreMembresia, float precioMembrecia, String descripcionMembresia, Integer tiempoAcceso) {
        this.nombreMembresia = nombreMembresia;
        this.precioMembrecia = precioMembrecia;
        this.descripcionMembresia = descripcionMembresia;
        this.tiempoAcceso = tiempoAcceso;
    }

    public String getNombreMembresia() {
        return nombreMembresia;
    }

    public void setNombreMembresia(String nombreMembresia) {
        this.nombreMembresia = nombreMembresia;
    }

    public float getPrecioMembrecia() {
        return precioMembrecia;
    }

    public void setPrecioMembrecia(float precioMembrecia) {
        this.precioMembrecia = precioMembrecia;
    }

    public String getDescripcionMembresia() {
        return descripcionMembresia;
    }

    public void setDescripcionMembresia(String descripcionMembresia) {
        this.descripcionMembresia = descripcionMembresia;
    }

    public Integer getTiempoAcceso() {
        return tiempoAcceso;
    }

    public void setTiempoAcceso(Integer tiempoAcceso) {
        this.tiempoAcceso = tiempoAcceso;
    }

    @Override
    public String toString() {
        return "MembresiaDTO{" + "nombreMembresia=" + nombreMembresia + ", precioMembrecia=" + precioMembrecia + ", descripcionMembresia=" + descripcionMembresia + ", tiempoAcceso=" + tiempoAcceso + '}';
    }
    
    
}
