/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTOs;

import java.util.List;

/**
 *
 * @author jrasc
 */
public class UsuarioDTO {
    
    private NewUsuarioDTO informacionUsuario;
    private MembresiaDTO membresiaDelUsuario;
    private List<GeneroDTO> generosSeleccionados;
    private PagoRegistradoDTO pagoRegistrado;

    public UsuarioDTO(NewUsuarioDTO informacionUsuario, MembresiaDTO membresiaDelUsuario, List<GeneroDTO> generosSeleccionados, PagoRegistradoDTO pagoRegistrado) {
        this.informacionUsuario = informacionUsuario;
        this.membresiaDelUsuario = membresiaDelUsuario;
        this.generosSeleccionados = generosSeleccionados;
        this.pagoRegistrado = pagoRegistrado;
    }

    public NewUsuarioDTO getInformacionUsuario() {
        return informacionUsuario;
    }

    public void setInformacionUsuario(NewUsuarioDTO informacionUsuario) {
        this.informacionUsuario = informacionUsuario;
    }

    public MembresiaDTO getMembresiaDelUsuario() {
        return membresiaDelUsuario;
    }

    public void setMembresiaDelUsuario(MembresiaDTO membresiaDelUsuario) {
        this.membresiaDelUsuario = membresiaDelUsuario;
    }

    public List<GeneroDTO> getGenerosSeleccionados() {
        return generosSeleccionados;
    }

    public void setGenerosSeleccionados(List<GeneroDTO> generosSeleccionados) {
        this.generosSeleccionados = generosSeleccionados;
    }

    public PagoRegistradoDTO getPagoRegistrado() {
        return pagoRegistrado;
    }

    public void setPagoRegistrado(PagoRegistradoDTO pagoRegistrado) {
        this.pagoRegistrado = pagoRegistrado;
    }

    @Override
    public String toString() {
        return "UsuarioDTO{" + "informacionUsuario=" + informacionUsuario + ", membresiaDelUsuario=" + membresiaDelUsuario + ", generosSeleccionados=" + generosSeleccionados + ", pagoRegistrado=" + pagoRegistrado + '}';
    }
}
