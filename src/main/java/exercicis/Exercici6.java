package exercicis;

import java.util.ArrayList;
import java.util.Scanner;

public class Exercici6 {

    // Declarem un Scanner per tota sa clase.
    static Scanner teclat = new Scanner(System.in);

    // Creem un ArrayList per els números decimals.
    static ArrayList<Double> numDecimals = new ArrayList<>();

    // Guardam el total de les despeses.
    static double totalDespeses = 0;

    public static void main(String[] args) {

        // Cridem el mètode mostrarMenu().
        mostrarMenu();

    }

    // Creem el mètode mostrarMenu().
    public static void mostrarMenu() {

        // Mostrem el menú amb les opcions.
        System.out.println("--- GESTOR DE DESPESES ---");
        System.out.println("1. Despeses. (L’usuari pot introduir un número indeterminat de despeses. Cal calcular el total de les despeses)");
        System.out.println("2. Pressupost.( Demana un valor que anomenarem pressupost. Comprovar si estem en perill (Alerta). Mostra el missatge pertinent.)");
        System.out.println("0. Sortir");

        // Demanem a l'usuari quina opció tria.
        System.out.printf("Selecciona una opció: ");
        int opcio = teclat.nextInt();

        // Condicions segons l'opció escollida.
        if (opcio == 1) {

            // Cridem el mètode calcularTotal().
            totalDespeses = calcularTotal();

        } else if (opcio == 2) {

            // Demanam el pressupost.
            System.out.printf("Introdueix el pressupost: ");
            double pressupost = teclat.nextDouble();

            // Comprovam si hem superat el pressupost.
            comprovarAlerta(totalDespeses, pressupost);

        } else if (opcio == 0) {

            System.out.println("Sortint del programa...");

        } else {

            System.out.println("Opció no vàlida.");

        }
    }

    // Creem el mètode calcularTotal per l'opció 1.
    public static double calcularTotal() {

        // Buidam l'ArrayList per evitar acumular despeses anteriors.
        numDecimals.clear();

        // Demanam quantes despeses vol introduir.
        int numVegades;

        do {

            System.out.printf("Quantes despeses vols introduir? (Mínim 3): ");
            numVegades = teclat.nextInt();

            if (numVegades < 3) {
                System.out.println("Has d'introduir com a mínim 3 despeses.");
            }

        } while (numVegades < 3);

        // Demanam les despeses i les guardam dins l'ArrayList.
        for (int i = 0; i < numVegades; i++) {

            System.out.printf("Introdueix la despesa %d: ", i + 1);
            numDecimals.add(teclat.nextDouble());

        }

        // Variable per guardar la suma.
        double suma = 0;

        // Recorrem l'ArrayList i sumam totes les despeses.
        for (int i = 0; i < numDecimals.size(); i++) {

            suma += numDecimals.get(i);

        }

        // Mostram el resultat.
        System.out.printf("El total gastat és: %.2f €%n", suma);

        // Retornam la suma.
        return suma;
    }

    // Creem el mètode comprovarAlerta.
    public static void comprovarAlerta(double total, double pressupost) {

        // Comprovam si el total supera el pressupost.
        if (total > pressupost) {

            System.out.println("ALERTA: Has superat el pressupost!");

        } else {

            System.out.println("Tot correcte. Estàs dins del pressupost.");

        }
    }
}