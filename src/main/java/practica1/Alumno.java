package practica1;

public class Alumno {
    // Atributos de Alumno.
    private String nombre;
    private String apellido;

    // Constructor de la clase con sus atributos.
    public Alumno(String nombre, String apellido) {
        this.setNombre(nombre);
        this.setApellido(apellido);
    }

    // Getter y Setters de cada atributo.
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
}
