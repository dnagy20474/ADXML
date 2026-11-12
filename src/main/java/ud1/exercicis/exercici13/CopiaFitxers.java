package ud1.exercicis.exercici13;

import java.io.*;
import java.util.*;

public class CopiaFitxers {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Fitxer d'origen: ");
        String origen = sc.nextLine().trim();
        System.out.print("Fitxer de destí (versió lenta): ");
        String desti1 = sc.nextLine().trim();
        System.out.print("Fitxer de destí (versió amb buffer): ");
        String desti2 = sc.nextLine().trim();

        // Versió 1: byte a byte, sense buffer
        long inici1 = System.currentTimeMillis();
        long bytes1 = copiarSenseBuffer(origen, desti1);
        long temps1 = System.currentTimeMillis() - inici1;

        // Versió 2: amb BufferedInputStream i BufferedOutputStream
        long inici2 = System.currentTimeMillis();
        long bytes2 = copiarAmbBuffer(origen, desti2);
        long temps2 = System.currentTimeMillis() - inici2;

        if (bytes1 < 0 || bytes2 < 0) {
            System.out.println("La còpia no s'ha pogut completar.");
            return;
        }

        System.out.println();
        System.out.println("===== RESULTATS =====");
        System.out.println("Sense buffer: " + temps1 + " ms (" + bytes1 + " bytes)");
        System.out.println("Amb buffer:   " + temps2 + " ms (" + bytes2 + " bytes)");

        if (temps2 > 0) {
            System.out.printf("La versió amb buffer és %.2f vegades més ràpida.%n", (double) temps1 / temps2);
        } else {
            System.out.println("La versió amb buffer ha trigat menys d'1 ms.");
        }
    }

    // Versió lenta: cada read() i write() va directe al disc
    static long copiarSenseBuffer(String origen, String desti) {
        long total = 0;
        try (FileInputStream fis = new FileInputStream(origen);
             FileOutputStream fos = new FileOutputStream(desti)) {

            int b;
            while ((b = fis.read()) != -1) {
                fos.write(b);
                total++;
            }
        } catch (IOException e) {
            System.err.println("[ERROR] Còpia sense buffer: " + e.getMessage());
            return -1;
        }
        return total;
    }

    // Versió ràpida: els fluxos bàsics es passen als constructors dels fluxos amb buffer
    static long copiarAmbBuffer(String origen, String desti) {
        long total = 0;
        try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream(origen));
             BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(desti))) {

            int b;
            while ((b = bis.read()) != -1) {
                bos.write(b);
                total++;
            }
        } catch (IOException e) {
            System.err.println("[ERROR] Còpia amb buffer: " + e.getMessage());
            return -1;
        }
        return total;
    }
}