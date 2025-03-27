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
public class NuevoPagoDTO {
    
    private String nombreTitular;
    private String apelllidoTitular;
    private String numero;
    private int mesCaducidad;
    private int anioCaducidad;
    private String cvv;

    public NuevoPagoDTO() {
    }

    public NuevoPagoDTO(String nombreTitular, String apelllidoTitular, String numero, int mesCaducidad, int anioCaducidad, String cvv) {
        this.nombreTitular = nombreTitular;
        this.apelllidoTitular = apelllidoTitular;
        this.numero = numero;
        this.mesCaducidad = mesCaducidad;
        this.anioCaducidad = anioCaducidad;
        this.cvv = cvv;
    }

    public String getApelllidoTitular() {
        return apelllidoTitular;
    }

    public void setApelllidoTitular(String apelllidoTitular) {
        this.apelllidoTitular = apelllidoTitular;
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

    public int getMesCaducidad() {
        return mesCaducidad;
    }

    public void setMesCaducidad(int mesCaducidad) {
        this.mesCaducidad = mesCaducidad;
    }

    public int getAnioCaducidad() {
        return anioCaducidad;
    }

    public void setAnioCaducidad(int anioCaducidad) {
        this.anioCaducidad = anioCaducidad;
    }


    public String getCvv() {
        return cvv;
    }

    public void setCvv(String cvv) {
        this.cvv = cvv;
    }

    @Override
    public String toString() {
        return "NuevoPagoDTO{" + "nombreTitular=" + nombreTitular + ", apelllidoTitular=" + apelllidoTitular + ", numero=" + numero + ", mesCaducidad=" + mesCaducidad + ", anioCaducidad=" + anioCaducidad + ", cvv=" + cvv + '}';
    }

}
