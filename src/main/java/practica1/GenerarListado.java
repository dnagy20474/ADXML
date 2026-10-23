package practica1;

import java.util.*;

public class GenerarListado {

    // Un atributo de Random para generar datos y orden.
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

        // Array para guardar los datos generados para él .csv.
        String[] datos = new String[numAlumnos];

        // Creamos un contador para el bucle.
        int contador = 0;

        while (contador <  numAlumnos) {
            // Generamos los datos.
            int id = contador + 1;

            // Variable para guardar un nombre aleatorio del array (nombres).
            String nombre = nombres[r.nextInt(nombres.length)];

            // Variable para guardar un primer apellido aleatorio del array (apellidos).
            String apellido1 = apellidos[r.nextInt(apellidos.length)];
            // Variable para guardar un segundo apellido aleatorio del array (apellidos).
            String apellido2 = apellidos[r.nextInt(apellidos.length)];

            // Variable para generar edades aleatorias para cada alumno.
            int edad = r.nextInt(10) + 16; // Se generan entre la edad de 16 a 25 años.

            // Variable para generar el teléfono Mobil.
            /*
            *   El 6 hace que enpiece por 6, 10000000 = hace que hayan 9 digitos,
            *   como es en España y el 90000000 = hace que sea del 0 al 89.999.999 .
            *
            */
            String telefono = "6" + (10000000 + r.nextInt(90000000));

            // Variable para generar el email.
            /*
             *   Estructura del gmail tradicional, primero el nombre, el apellido
             *   y el @gmail.com
             *
             */
            String email = nombre.toLowerCase()
                    + apellido1.toLowerCase()
                    + "@gmail.com";

            // Variable para la dirección del alumno.
            // (r.nextInt(100) + 1 = Genera el número de calle.
            String direccion = "Calle " + (r.nextInt(100) + 1);

            // Variable para generar el codigo postal (cp).
            /*
             *      String.format("%05d", r.nextInt(53000));
             *      Este método le da un formato de 5 digitos decimales
             *      y si no hay digitos ponga 0 por defecto.
             *      el r.nextInt(100000) empieza del 00000 al 99999
             *
             */
            String cp = String.format("%05d", r.nextInt(100000));

            // Variable para generar provincias.
            String provincia = provincias[r.nextInt(provincias.length)];

            // Ponemos una variable con el país por defecto España.
            String pais = "España";

            // Montamos la línea completa del alumno con el sigiente formato.
            datos[contador] = id + ";" +
                    nombre + ";" +
                    apellido1 + " " + apellido2 + ";" +
                    edad + ";" +
                    telefono + ";" +
                    email + ";" +
                    direccion + ";" +
                    cp + ";" +
                    provincia + ";" +
                    pais;

            contador++; // Acumulamos el contador.
        }

        // Mostramos todos los datos por pantalla con este bucle.
        for (int i = 0; i < datos.length; i++) {
            System.out.println(datos[i]);
        }
    }
}
