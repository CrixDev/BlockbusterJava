/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.infraestructura;

import java.util.Date;

/**
 *
 * @author jrasc
 */
public class PagoRegistradoDTO {

    private boolean esValida;
    private double monto;
    private Date fechaPago;

    public PagoRegistradoDTO() {
    }

    public PagoRegistradoDTO(boolean esValida, double monto, Date fechaPago) {
        this.esValida = esValida;
        this.monto = monto;
        this.fechaPago = fechaPago;
    }

    public boolean isEsValida() {
        return esValida;
    }

    public void setEsValida(boolean esValida) {
        this.esValida = esValida;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public Date getFechaPago() {
        return fechaPago;
    }

    public void setFechaPago(Date fechaPago) {
        this.fechaPago = fechaPago;
    }

    @Override
    public String toString() {
        return "PagoRegistradoDTO{" + "esValida=" + esValida + ", monto=" + monto + ", fechaPago=" + fechaPago + '}';
    }

}
