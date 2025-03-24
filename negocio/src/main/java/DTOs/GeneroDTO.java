package DTOs;

/**
 *
 * @author payde
 */
public class GeneroDTO {

    private String nombre;
    private boolean seleccionado;

    public GeneroDTO(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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
