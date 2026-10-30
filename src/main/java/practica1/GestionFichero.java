package practica1;

import java.io.*;
import java.util.*;

public class GestionFichero {

    public void menu() {

        // Declaramos el Scanner.
        Scanner teclado = new Scanner(System.in);

        // Variable para la opción del menú.
        int opcion = 0;

        do { // Bucle para que se repita hasta que seleccione 0.
            try { // Control de Error para que no pete el programa y diga que le pasa.
                // Mostramos al usuario el menú.
                System.out.println("----------------");
                System.out.println("      Menú      ");
                System.out.println("----------------" + "\n");

                System.out.println("1. Cargar los datos del CSV.");
                System.out.println("2. Añadir alumno.");
                System.out.println("3. Buscar alumno a partir de su id.");
                System.out.println("4. Eliminar alumno a partir de su id.");
                System.out.println("5. Modificar un alumno a partir de su id.");
                System.out.println("6. Contar alumnos.");
                System.out.println("7. Generar un nuevo archivo alumnos-[fecha-hora].csv");
                System.out.println("0. Salir." + "\n");

                // Condición para que no de error cuando introduzcas otro carrácter.
                if (teclado.hasNextInt()) {
                    // Pedimos al usuario una selección del menú.
                    System.out.println("Selecciona una opción del menú: ");
                    opcion = teclado.nextInt(); // Guardamos lo introducido en la variable de opcion.
                } else {
                    System.out.println("Tiene que ser un número entero, del 0 al 7!");
                }

                // Hacemos un Switch para comprobar la selección.
                switch (opcion) {
                    // Llamamos el método para comprobar el fichero.
                    case 1 -> comprobarFichero("alumnos.csv");
                    case 2 -> anyadirAlumno(); // Llamamos el método para añadir el alumno.
                    case 3 -> buscarAlumno(); // Llamamos el método para buscar el alumno.
                }

            } catch (Exception e) {
                System.out.println("ERROR: " + e);
            }
        } while (opcion != 0);
    }

    // Método para añadir alumnos a esta clase.
    public void anyadirAlumno() {
        // Declaramos un Scanner para usar inputs.
        Scanner teclado = new Scanner(System.in);

        // Creamos un ArrayList de Alumnos.
        ArrayList<Alumno> alumnos = new ArrayList<>();

        // Creamos la variable de nuevoAlumno de la clase Alumno para poder añadirlo al ArrayList
        Alumno nuevoAlumno = new Alumno("", "");

        try {
            System.out.println("Introduce el nombre del alumno: ");
            nuevoAlumno.setNombre(teclado.next());

            System.out.println("Introduce el apellido del alumno: ");
            nuevoAlumno.setApellido(teclado.next());

            System.out.println("Introduce el id del alumno: ");
        } catch (Exception e) {
            System.out.println("ERROR: " + e);
        }
    }

    // Método para buscar alumno por su id.
    public void buscarAlumno() {

    }

    // Método para generarFicheros, en el caso de que no esté.
    public void generarFichero(String nombreFichero) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(nombreFichero))) {
            // Llamamos al método donde hemos leído el fichero .csv
            comprobarFichero(nombreFichero);

        } catch (IOException e) {
            System.out.printf("ERROR al generar el fichero: %s%n ", e);
        }

        System.out.println("Se creó el fichero correctamente!"); // Mensaje de éxito.
    }

    // Método para leer el fichero y comprobar si existe.
    public void comprobarFichero(String nombreFichero) {
        try (BufferedReader br = new BufferedReader(new FileReader(nombreFichero))) {
            String linea; // Variable para guardar lo leído del fichero.

            // Bucle while para recorrer el fichero.
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(","); // Guardamos en un array cada dato del csv si la coma.
            }
        } catch (IOException e) {
            System.out.printf("ERROR de lectura: %s%n." +
                    "Seguramente necesites crear el fichero.", e);
        }

        System.out.println("Se han leído los datos!");// Mensaje de éxito.
    }
}
