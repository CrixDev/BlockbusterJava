package DTOs;

import javax.swing.ImageIcon;

/**
 *
 * @author payde
 */
public class GeneroDTO {

    private String nombre;
    private boolean seleccionado;
    private ImageIcon imagen;

    public GeneroDTO(String nombre, ImageIcon imagen) {
        this.nombre = nombre;
        this.imagen = imagen;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public ImageIcon getImagen() {
        return imagen;
    }
    
      public void setImagen(ImageIcon imagen) {
        this.imagen = imagen;
    }


    public boolean isSeleccionado() {
        return seleccionado;
    }

    public void setSeleccionado(boolean seleccionado) {
        this.seleccionado = seleccionado;
    }

    @Override
    public String toString() {
        return "GeneroDTO{" + "nombre=" + nombre + ", seleccionado=" + seleccionado + '}';
    }
}
