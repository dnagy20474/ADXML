package exercicis;

import java.util.Scanner;

public class Exercici4 {

    // Variable de Scanner.
    static Scanner teclat = new Scanner(System.in);

    public static void main(String[] args) {

        // Variable per l'opció.
        int opcio = 0;

        // Menú del programa.
        do {
            // Mostrem les opcions del menú a l'usuari.
            System.out.println("1.- Llegir un missatge.");
            System.out.println("2.- Mostra el missatge per pantalla.");
            System.out.println("3.- Sortir\n");

            System.out.printf("Selecciona una opció: ");

            // Validació de l'entrada per evitar InputMismatchException
            while (!teclat.hasNextInt()) {
                System.out.println("Ha de ser un número enter.");
                teclat.next(); // Neteja l'entrada no vàlida del buffer
                System.out.printf("Selecciona una opció: ");
            }

            opcio = teclat.nextInt();
            teclat.nextLine(); // Neteja el salt de línia restant al buffer

            System.out.println(); // Salt de línia.

            if (opcio <= 0 || opcio > 3) {
                System.out.println("Opció no vàlida. Ha de ser entre 1 i 3.");
                System.out.println(); // Salt de línia.
            }

            // Condicións segons l'opció.
            if (opcio == 1) {
                System.out.println("Has seleccionat la opció 1.");
            } else if (opcio == 2) {
                System.out.println("Has seleccionat la opció 2.");
            } else if (opcio == 3) {
                System.out.println("Has seleccionat la opció 3.");
            }
        } while (opcio != 3);

    }
}
