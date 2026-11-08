package exercicis.exercici15;

import java.io.*;

public class CrearPunts {

    public static void main(String[] args) {
        int[] punts = {23, 45, 67, 16, 81, 26, 78};

        try (RandomAccessFile raf = new RandomAccessFile("punts.dat", "rw")) {
            for (int i = 0; i < punts.length; i++) {
                raf.writeInt(punts[i]);   // cada int ocupa 4 bytes
            }
            System.out.println("Fitxer punts.dat creat amb " + punts.length + " jugadors.");
        } catch (IOException e) {
            System.err.println("[ERROR] No s'ha pogut crear el fitxer: " + e.getMessage());
        }
    }
}