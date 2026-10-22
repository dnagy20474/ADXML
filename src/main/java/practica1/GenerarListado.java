package practica1;

import java.util.*;

public class GenerarListado {

    /* Ponemos de atributo un random para que me ponga él,
        el orden de los alumnos. */
    Random r = new  Random();

    // Atributo de Array para todos los nombres.
    String[] nombres = {
            "Juan", "María", "Carlos", "Lucía", "Pedro",
            "Ana", "Miguel", "Laura", "David", "Sofía"
    };

    // Atributo de Array para todos los apellidos.
    String[] apellidos = {
            "García", "Martínez", "López", "Sánchez", "Pérez",
            "Gómez", "Fernández", "Rodríguez", "Navarro", "Torres"
    };

    // Atributo de Array para todas las províncias.
    String[] provincias = {
            "Madrid", "Barcelona", "Valencia", "Sevilla",
            "Málaga", "Palma", "Bilbao", "Alicante"
    };

    // Método para generar los datos para el csv.
    public void generarDatos() {

        // Declaramos el Scanner para pedir al usuario cuantos alumnos quiere.
        Scanner teclado = new Scanner(System.in);

        int numAlumnos = 0; // Variable para saber el número de alumnos.

        // Pedimos al usuario cuantos alumnos quiere.
        System.out.print("Introduce el número de alumnos que tenga el .csv: ");
        numAlumnos = teclado.nextInt(); // Guardamos lo introducido.

        String[] datos = new String[100]; // Array para guardar los datos generados para el .csv.

        while (datos.length < numAlumnos) {

        }
    }
}
