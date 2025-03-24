package seleccionGenero;

public class Genero {
    private String nombre;
    private boolean seleccionado;

    public Genero(String nombre) {
        this.nombre = nombre;
        this.seleccionado = false;
    }

    public String getNombre() {
        return nombre;
    }

    public boolean isSeleccionado() {
        return seleccionado;
    }

    public void setSeleccionado(boolean seleccionado) {
        this.seleccionado = seleccionado;
    }
} 