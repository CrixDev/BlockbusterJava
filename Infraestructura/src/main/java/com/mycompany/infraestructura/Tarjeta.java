/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.infraestructura;

import java.util.Date;
import java.util.Objects;

/**
 *
 * @author jrasc
 */
public class Tarjeta {

    private String nombreTitular;
    private String numero;
    private Date fechaExpiracion;
    private String cvv;

    public Tarjeta(String nombreTitular, String numero, Date fechaExpiracion, String cvv) {
        this.nombreTitular = nombreTitular;
        this.numero = numero;
        this.fechaExpiracion = fechaExpiracion;
        this.cvv = cvv;
    }

    public String getNombreTitular() {
        return nombreTitular;
    }

    public void setNombreTitular(String nombreTitular) {
        this.nombreTitular = nombreTitular;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public Date getFechaExpiracion() {
        return fechaExpiracion;
    }

    public void setFechaExpiracion(Date fechaExpiracion) {
        this.fechaExpiracion = fechaExpiracion;
    }

    public String getCvv() {
        return cvv;
    }

    public void setCvv(String cvv) {
        this.cvv = cvv;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Tarjeta)) {
            return false;
        }
        Tarjeta tarjeta = (Tarjeta) o;
        return numero.equals(tarjeta.numero)
                && nombreTitular.equals(tarjeta.nombreTitular);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numero, nombreTitular);
    }

    public boolean esValida() {
        return numero != null && numero.length() == 16
                && cvv != null && cvv.length() == 3
                && fechaExpiracion != null && fechaExpiracion.after(new Date());
    }
}
