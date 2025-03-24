
package DTOs;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author payde
 */
public class GeneroDTO {
    private String nombre;
    private List<GeneroDTO> generos = new ArrayList<>();

    public GeneroDTO(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<GeneroDTO> getGeneros() {
        return generos;
    }

    public void setGeneros(List<GeneroDTO> generos) {
        this.generos = generos;
    }

    @Override
    public String toString() {
        return "GeneroDTO{" + "nombre=" + nombre + ", generos=" + generos + '}';
    }

}
