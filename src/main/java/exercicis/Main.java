package exercicis;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        double euro = 0;
        double dolar = 0;
        double divisaDolar = 1.14;

        System.out.println("Introduce un valor en Euros: ");
        euro = sc.nextDouble();

        dolar = euro * divisaDolar;

        System.out.println(euro + "€ son " + dolar + " dolars.");
    }
}
