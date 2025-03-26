/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTOs;

import java.math.BigDecimal;
import java.util.Date;

/**
 *
 * @author Usuario
 */
public class MetodoPagoDTO {

    private String nombreTitular;
    private String apellidoTitular;
    private String direccionFacturacion;
    private String numeroTarjeta;
    private String cvv;
    private Date fechaCaducidad;
    private String metodoPago;     // Oxxo o PayPal
    private String plan;     // Premium o Pro        

    public MetodoPagoDTO() {
    }

    public MetodoPagoDTO(String nombreTitular, String apellidoTitular, String direccionFacturacion, String numeroTarjeta, String cvv, Date fechaCaducidad, String metodoPago, String plan) {
        this.nombreTitular = nombreTitular;
        this.apellidoTitular = apellidoTitular;
        this.direccionFacturacion = direccionFacturacion;
        this.numeroTarjeta = numeroTarjeta;
        this.cvv = cvv;
        this.fechaCaducidad = fechaCaducidad;
        this.metodoPago = metodoPago;
        this.plan = plan;
  
    }

    public String getNombreTitular() {
        return nombreTitular;
    }

    public void setNombreTitular(String nombreTitular) {
        this.nombreTitular = nombreTitular;
    }

    public String getApellidoTitular() {
        return apellidoTitular;
    }

    public void setApellidoTitular(String apellidoTitular) {
        this.apellidoTitular = apellidoTitular;
    }

    public String getDireccionFacturacion() {
        return direccionFacturacion;
    }

    public void setDireccionFacturacion(String direccionFacturacion) {
        this.direccionFacturacion = direccionFacturacion;
    }

    public String getNumeroTarjeta() {
        return numeroTarjeta;
    }

    public void setNumeroTarjeta(String numeroTarjeta) {
        this.numeroTarjeta = numeroTarjeta;
    }

    public String getCvv() {
        return cvv;
    }

    public void setCvv(String cvv) {
        this.cvv = cvv;
    }

    public Date getFechaCaducidad() {
        return fechaCaducidad;
    }

    public void setFechaCaducidad(Date fechaCaducidad) {
        this.fechaCaducidad = fechaCaducidad;
    }

    public String getMetodoPago() {
        return metodoPago;
    }

    public void setMetodoPago(String metodoPago) {
        this.metodoPago = metodoPago;
    }

    public String getPlan() {
        return plan;
    }

    public void setPlan(String plan) {
        this.plan = plan;
    }

    @Override
    public String toString() {
        return "MetodoPagoDTO{" + "nombreTitular=" + nombreTitular + ", apellidoTitular=" + apellidoTitular + ", direccionFacturacion=" + direccionFacturacion + ", numeroTarjeta=" + numeroTarjeta + ", cvv=" + cvv + ", fechaCaducidad=" + fechaCaducidad + ", metodoPago=" + metodoPago + ", plan=" + plan + '}';
    }
    
}
