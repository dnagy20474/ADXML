package exercicis.exercici7;

public class Alumne {

    // Atributs
    String nombre;
    int edad;

    // Constructor.
    public Alumne(String nombre, int edad) {
        this.setNombre(nombre);
        this.setEdad(edad);
    }

    // Getter i Setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    @Override
    public String toString() {
        return "Alumne{" +
                "nombre=" + nombre +
                ", edad=" + edad +
                '}';
    }
}
