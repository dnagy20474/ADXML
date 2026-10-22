package practica1;

import java.io.*;

public class GestionFichero {

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
            String linea; // Variable para guardar lo leido del fichero.

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
