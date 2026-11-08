package exercicis.exercici11;

import java.io.*;

public class ComparadorLectura {

    static final String NOM_FITXER = "registre_temperatures.txt";

    public static void main(String[] args) {
        System.out.println("Llegint '" + NOM_FITXER + "' de dues maneres...\n");

        // Mètode A: FileReader caràcter a caràcter
        long iniciA = System.currentTimeMillis();
        int liniesA = llegirAmbFileReader();
        long tempsA = System.currentTimeMillis() - iniciA;

        // Mètode B: BufferedReader amb readLine()
        long iniciB = System.currentTimeMillis();
        int liniesB = llegirAmbBufferedReader();
        long tempsB = System.currentTimeMillis() - iniciB;

        if (liniesA < 0 || liniesB < 0) {
            System.out.println("No s'ha pogut completar la comparació.");
            return;
        }

        // Fase 3: informe
        System.out.println("========== INFORME DE RESULTATS ==========");
        System.out.println("Mètode A (FileReader):     " + tempsA + " ms (" + liniesA + " línies)");
        System.out.println("Mètode B (BufferedReader): " + tempsB + " ms (" + liniesB + " línies)");

        if (tempsB == 0) {
            // per no dividir entre 0
            System.out.println("El mètode B ha trigat menys d'1 ms, no es pot calcular la proporció exacta.");
            System.out.println("Com a mínim és " + tempsA + " vegades més ràpid.");
        } else {
            double vegades = (double) tempsA / tempsB;
            System.out.printf("El mètode B és %.2f vegades més ràpid que el A.%n", vegades);
        }
    }

    static int llegirAmbFileReader() {
        int linies = 0;
        try (FileReader fr = new FileReader(NOM_FITXER)) {
            int c;
            while ((c = fr.read()) != -1) {
                if (c == '\n') {
                    linies++;
                }
            }
        } catch (IOException e) {
            System.err.println("[ERROR] Mètode A: " + e.getMessage());
            return -1;
        }
        return linies;
    }

    static int llegirAmbBufferedReader() {
        int linies = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(NOM_FITXER))) {
            while (br.readLine() != null) {
                linies++;
            }
        } catch (IOException e) {
            System.err.println("[ERROR] Mètode B: " + e.getMessage());
            return -1;
        }
        return linies;
    }
}