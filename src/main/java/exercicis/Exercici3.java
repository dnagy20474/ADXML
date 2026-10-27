package exercicis;

import java.util.Scanner;

public class Exercici3 {

    // Declarem es programa fora del main, per a poder emprar-lo a tota sa clase.
    static Scanner sc = new Scanner(System.in);

    static void main() {

        // Variables del exercici.
        double preuBillet = 0.0;
        double dinersEstalviats = 0.0;

        // Demanem a l'usuari el cost del bitllet:
        System.out.printf("¿Quant costa el bitllet? ");

        // Bucle per a que es repeteixqui fins que sigui doble o enter.
        while (!sc.hasNextDouble()) {
            // Demanem a l'usuari el cost del billet un altra vegada:
            sc.next(); // Fem un salt de buffer perquè no doni error.
            System.out.printf("¿Quant costa el bitllet? ");
        }
        preuBillet = sc.nextDouble(); // Guardem el valor correcte a sa variable correspondent.

        // Demanem a l'usuari els diners estalviats:
        System.out.printf("¿Quants diners tens estalviats? ");

        // Bucle perquè es repeteixi fins que sigui doble o enter.
        while (!sc.hasNextDouble()) {
            // Demanem a l'usuari els diners estalviats un altra vegada:
            sc.next(); // Fem un salt de buffer perquè no doni error.
            System.out.printf("¿Quants diners tens estalviats? ");
        }
        dinersEstalviats = sc.nextDouble(); // Guardem el valor correcte a sa variable correspondent.

        if (!majorAZero(preuBillet, dinersEstalviats)) { // Condició per veure que singuin majors a zero.
        } else {
            // Condicions per comprar el billet.
            if (dinersEstalviats >= preuBillet) {
                System.out.printf("Bon viatge! Pots comprar el bitllet");
            } else {
                // Calculem la resta que ens queda per poder comprar el billet.
                double resta = preuBillet - dinersEstalviats;

                System.out.printf("No tens prou diners. Et falten " + resta + "€ para poder viatjar.");

                System.out.println(); // espai de línea.
                // Mostrem el resultat específic que ens demana l'enunciat.
                System.out.printf("Valor %.2f €  \n", resta);
            }
        }

        sc.close();
    }

    // Creem métode per comprobar que sigui major a 0.
    private static boolean majorAZero(double preuBillet, double dinersEstalviats) {
        if (preuBillet <= 0 || dinersEstalviats <= 0) {
            System.out.printf("Tens que intruduir un valor positiu, major a 0!");
            return false;
        }
        return true;
    }
}
