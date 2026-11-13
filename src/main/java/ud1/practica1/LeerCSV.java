
package ud1.practica1;

import java.io.*;
import java.util.*;

public class LeerCSV {

    // Declaramos un Scanner para usar inputs.
    Scanner teclado = new Scanner(System.in);

    // Creamos un ArrayList de Alumnos.
    ArrayList<Alumno> alumnos = new ArrayList<>();

    // Variable para guardar el ID del alumno con el método leerEntero().
    int idAlumno;

    // Variable booleana para saber si ha encontrado el ID.
    boolean encontrado;

    // Método auxiliar para leer números enteros correctamente.
    public int leerEntero(String mensaje) {

        while (true) {
            System.out.print(mensaje);

            // Comprobamos si lo introducido es un entero.
            if (teclado.hasNextInt()) {

                int numero = teclado.nextInt();

                // Consumimos el salto de línea pendiente.
                teclado.nextLine();

                return numero;

            } else {
                // Eliminamos el contenido incorrecto.
                teclado.nextLine();

                System.out.println("ERROR: Tiene que introducir un número entero.");
            }
        }
    }

    // Método para mostrar el menú.
    public void menu() {

        int opcion;

        do {
            System.out.println("\n----------------");
            System.out.println("      Menú      ");
            System.out.println("----------------\n");

            System.out.println("1. Cargar los datos del CSV.");
            System.out.println("2. Añadir alumno.");
            System.out.println("3. Buscar alumno a partir de su id.");
            System.out.println("4. Eliminar alumno a partir de su id.");
            System.out.println("5. Modificar un alumno a partir de su id.");
            System.out.println("6. Contar alumnos.");
            System.out.println("7. Generar un nuevo archivo alumnos-[fecha-hora].csv");
            System.out.println("0. Salir.\n");

            // Pedimos una opción al usuario.
            opcion = leerEntero("Selecciona una opción del menú: ");

            // Comprobamos que la opción esté entre 0 y 7.
            if (opcion < 0 || opcion > 7) {
                System.out.println("ERROR: Introduce un número del 0 al 7.");

            } else {
                // Ejecutamos la opción seleccionada.
                switch (opcion) {
                    case 1 -> cargarFichero("alumnos.csv");
                    case 2 -> anyadirAlumno();
                    case 3 -> buscarAlumno();
                    case 4 -> eliminarAlumno();
                    case 5 -> System.out.println("Método pendiente de implementar.");
                    case 6 -> System.out.println("Número de alumnos: " + alumnos.size());
                    case 7 -> System.out.println("Método pendiente de implementar.");
                    case 0 -> System.out.println("¡Hasta pronto!");

                }
            }

        } while (opcion != 0);
    }

    // Método para añadir alumnos a esta clase.
    public void anyadirAlumno() {

        // Creamos el objeto Alumno.
        Alumno nuevoAlumno = new Alumno("", "", 0);

        // Pedimos los datos.
        System.out.print("Introduce el nombre del alumno: ");
        String nombre = teclado.nextLine().trim();

        // Comprobamos que el nombre no esté vacío.
        while (nombre.isEmpty()) {
            System.out.println("ERROR: El nombre no puede estar vacío.");
            System.out.print("Introduce el nombre del alumno: ");
            nombre = teclado.nextLine().trim();
        }

        System.out.print("Introduce el apellido del alumno: ");
        String apellido = teclado.nextLine().trim();

        // Comprobamos que el apellido no esté vacío.
        while (apellido.isEmpty()) {
            System.out.println("ERROR: El apellido no puede estar vacío.");
            System.out.print("Introduce el apellido del alumno: ");
            apellido = teclado.nextLine().trim();
        }

        // Pedimos el ID utilizando nuestro método auxiliar.
        int idAlumno = leerEntero("Introduce el id del alumno: ");

        // Comprobamos que el ID sea positivo.
        while (idAlumno <= 0) {
            System.out.println("ERROR: El ID debe ser mayor que 0.");
            idAlumno = leerEntero("Introduce el id del alumno: ");
        }

        // Comprobamos que no exista otro alumno con el mismo ID.
        for (Alumno alumno : alumnos) {
            if (alumno.getIdAlumno() == idAlumno) {

                System.out.println("ERROR: Ya existe un alumno con ese ID.");
                return;
            }
        }

        // Guardamos los datos en el objeto.
        nuevoAlumno.setNombre(nombre);
        nuevoAlumno.setApellido(apellido);
        nuevoAlumno.setIdAlumno(idAlumno);

        // Añadimos el objeto al ArrayList.
        alumnos.add(nuevoAlumno);

        System.out.println("\n¡El alumno ha sido añadido correctamente!");
    }

    // Método para buscar alumno por su ID.
    public void buscarAlumno() {

        // Llamamos al método para comprobar el ID.
        comprobarID();

        // Inicializamos la variable.
        encontrado = false;

        // Buscamos el ID en el ArrayList.
        for (Alumno alumno : alumnos) {
            if (alumno.getIdAlumno() == idAlumno) {

                System.out.println(alumno);

                encontrado = true;
                break;
            }
        }

        // Comprobamos que se haya encontrado el ID.
        if (!encontrado) {
            System.out.println("No se ha encontrado ningún alumno con ese ID.");
        }
    }

    // Método para leer el fichero y cargar los alumnos.
    public void cargarFichero(String nombreFichero) {
        try (BufferedReader br = new BufferedReader(new FileReader(nombreFichero))) {

            String linea; // Variable auxiliar para leer las líneas del texto.

            // Limpiamos el ArrayList para evitar duplicados.
            alumnos.clear();

            while ((linea = br.readLine()) != null) {
                // Separamos los datos utilizando el punto y coma.
                String[] datos = linea.split(";");

                // Comprobamos que la línea tenga los 10 campos.
                if (datos.length != 10) {
                    System.out.println("ERROR: Una línea del CSV no tiene 10 campos.");
                    continue;
                }

                try {
                    // Convertimos el ID a entero.
                    int id = Integer.parseInt(datos[0].trim());

                    // Creamos el objeto Alumno.
                    Alumno nuevoAlumno = new Alumno(
                            datos[1],
                            datos[2],
                            id
                    );

                    // Añadimos el alumno al ArrayList.
                    alumnos.add(nuevoAlumno);

                } catch (NumberFormatException e) {
                    System.out.println("ERROR: El ID de un alumno no es válido.");
                }
            }

            System.out.println("\n¡Se han leído los datos correctamente!");
            System.out.printf("Número de alumnos cargados: %d%n%n", alumnos.size());

        } catch (FileNotFoundException e) {
            System.out.println("ERROR: No se encuentra el fichero " + nombreFichero);

        } catch (IOException e) {
            System.out.println("ERROR de lectura: " + e.getMessage());
        }
    }

    // Método para eliminar alumno a partir de su ID.
    public void eliminarAlumno() {

        // Llamamos al método para comprobar el ID.
        comprobarID();

        // Inicializamos la variable.
        encontrado = false;

        // Buscamos el ID en el ArrayList.
        for (Alumno alumno : alumnos) {
            if (alumno.getIdAlumno() == idAlumno) {

                alumnos.remove(alumno);

                encontrado = true;
                break;
            }
        }

        // Comprobamos que se haya encontrado el ID.
        if (!encontrado) {
            System.out.println("No se ha encontrado ningún alumno con ese ID.");
        }
    }

    // Método para comprobar el estado del ID.
    public void comprobarID() {

        // Comprobamos que el ID no esté vacío.
        while (teclado.hasNextInt() || teclado == null) {
            System.out.println("ERROR: El nombre no puede estar vacío.");
            idAlumno = leerEntero("Introduce el ID del alumno: ");
        }
    }
}