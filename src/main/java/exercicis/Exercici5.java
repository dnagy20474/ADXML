package exercicis;

import java.util.ArrayList;
import java.util.Scanner;

public class Exercici5 {

    // Declarem la variable de Scanner.
    static Scanner teclat = new Scanner(System.in);

    public static void main(String[] args) {

        // Variable per l'opció.
        int opcio = 0;

        // Variables de dades del pacient.
        String nom;
        String cognom;
        int edat = 0;
        String dni;

        // Variable per la assegurança.
        String esAssegurat = "";

        // Variable per gravetat.
        String gravetat = "";

        // Creació de ArrayList.
        ArrayList<String> dadesPacient = new ArrayList();

        // Variable de l'exercici.
        double preuBaseVisita = 50.50;

        // Variables per la opció 3:
        double preuAmbDescompte = 0.0;
        double preuAmbRecarrec = 0.0;

        // Menú del programa.
        do {
            // Mostrem les opcions del menú a l'usuari.
            System.out.println("1.- Dades actuals del pacient.");
            System.out.println("2.- Mostrar tota la informació del pacient.");
            System.out.println("3.- Calcular el cost.");
            System.out.println("0.- Salir.\n");

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

            if (opcio < 0 || opcio > 3) {
                System.out.println("Opció no vàlida. Ha de ser entre 0 i 3");
                System.out.println(); // Salt de línia.
            }

            // Condicións segons l'opció.
            if (opcio == 1) {
                // Demanem dades al usuari y guardem a ses seves variables.
                System.out.printf("Introdueix el nom del pacient: ");
                nom = teclat.nextLine();

                System.out.printf("Introdueix el cognom del pacient: ");
                cognom = teclat.nextLine();

                System.out.printf("Introdueix edad del pacient: ");
                edat = teclat.nextInt();
                teclat.nextLine(); // Consumim el salt de línia pendent.

                // Demanem el DNI.
                System.out.printf("Introdueix el dni del pacient: ");
                dni = teclat.nextLine();

                // Demanem si té assegurança.
                System.out.printf("¿Te assegurança? (Si/No) ");
                esAssegurat = teclat.nextLine();

                // Demanem la gravetat del pacient.
                System.out.printf("¿Quina gravetat té? (Alta/Baixa) ");
                gravetat = teclat.nextLine();

                // Afegim les variables al ArrayList.
                dadesPacient.add(nom);
                dadesPacient.add(cognom);
                dadesPacient.add(String.valueOf(edat));
                dadesPacient.add(dni);
                dadesPacient.add(esAssegurat);
                dadesPacient.add(gravetat);

                System.out.println("Les dades han quedat registrades!");

                System.out.println(); // Salt de línia.

            } else if (opcio == 2) {
                System.out.println("Mostrem la informació del pacient: ");

                // Mostrem totes les dades del ArrayList.
                for (String dades :  dadesPacient) {
                    System.out.println(dades);
                }

                System.out.println(); // Salto de línia.

            } else if (opcio == 3) {
                // Condicions que demana l'exercici.
                if (edat < 18 || esAssegurat.equals("Si")) {
                    // Afegim un decompte si compleix la condició i o guardem a la seva variable.
                    preuAmbDescompte =  preuBaseVisita * 0.50;

                    // Mostrem el preu final per pantalla.
                    System.out.printf("Preu final: %.2f\n",preuAmbDescompte);
                    System.out.println(); // Salt de línia.
                } else if (edat > 18 && gravetat.equals("Alta")) {
                    // Li posem un rècarrec si compleix les dues condicions a la vegada.
                    preuAmbRecarrec = preuBaseVisita + 300.00;

                    // Mostrem el preu final per pantalla.
                    System.out.printf("Preu final: %.2f\n", preuAmbRecarrec);
                    System.out.println(); // Salt de línia.
                } else {
                    // Mostrem el preu final per pantalla.
                    System.out.printf("Preu final: %.2f\n",  preuBaseVisita);
                    System.out.println(); // Salt de línia.
                }
            } else if (opcio == 0) {
                System.out.println("Tancant el sistema...");
                System.out.println(); // Salt de línia.
            }
        } while (opcio != 0);

    }
}