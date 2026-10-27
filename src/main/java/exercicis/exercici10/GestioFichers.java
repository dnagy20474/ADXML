package exercicis.exercici10;

import java.io.*;
import java.util.*;

public class GestioFichers {

    // Atributs de la clase.
    static Scanner teclat = new Scanner(System.in);

    // Mètode per a crear fixer.
    public static void crearFixer(File f) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(f))) {

            bw.write(""); // Escribim en buid, només per crear el fitxer.

            System.out.println("El fixer s'ha creat correctament!" + "\n");
        } catch (IOException e) {
            System.out.println("ERROR: no se a podido crear el fichero; " + e);
        }
    }

    // Mètode pel menú.
    public static void menu() {

        int opcio; // Declarem la variable de l'opció.

        do {
            System.out.println("-----------");
            System.out.println("    MENU   ");
            System.out.println("-----------" + "\n");

            System.out.println("1. Crear fitxer");
            System.out.println("2. Crear directori");
            System.out.println("3. Eliminar fitxer");
            System.out.println("4. Copiar fitxer");
            System.out.println("5. Moure fitxer");
            System.out.println("6. Consultar informació");
            System.out.println("0. Sortir");

            System.out.printf("Seleccionar una opció: ");
            opcio = teclat.nextInt(); // Guardem la selecció.

            // Feim un switch modern per les condicións.
            switch (opcio) {
                case 1 -> crearFixer(new File("crearFitxer.txt"));
                case 0 -> System.out.println("Has sortir del programa!");

                default -> System.out.println("Tens que seleccionar de la opció 0 - 6");
            }
        } while (opcio != 0);
    }
}