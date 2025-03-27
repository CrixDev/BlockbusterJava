package DTOs;



/**
 *
 * @author payde
 */
public class GeneroDTO {

    private String nombre;
    private boolean seleccionado;
    private String imagen;
    

    public GeneroDTO(String nombre, String imagen) {
        this.nombre = nombre;
        this.imagen = imagen;
     
        this.seleccionado =false;
    }
    public String getNombre() {
        return nombre;
    }
    
      public String getImagen() {
        return imagen;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public void setImagen(String imagen) {
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
