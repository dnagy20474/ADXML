package ud1.practica1;

public class Alumno {
    // Atributos de Alumno.
    private String nombre;
    private String apellido;
    private int idAlumno;

    // Constructor de la clase con sus atributos.
    public Alumno(String nombre, String apellido, int idAlumno) {
        this.setNombre(nombre);
        this.setApellido(apellido);
        this.setIdAlumno(idAlumno);
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

    public int getIdAlumno() {
        return idAlumno;
    }

    public void setIdAlumno(int idAlumno) {
        this.idAlumno = idAlumno;
    }
}
