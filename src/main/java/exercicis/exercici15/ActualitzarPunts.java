package exercicis.exercici15;

import java.io.*;

public class ActualitzarPunts {

    static final int MIDA_INT = 4;

    public static void main(String[] args) {
        int idJugador = 4;
        int puntsGuanyador = 99;

        try (RandomAccessFile raf = new RandomAccessFile("punts.dat", "rw")) {

            mostrarPunts(raf, "Abans");

            // els ids comencen a 1, per tant la posició és (id - 1) * 4 bytes
            long posicio = (long) (idJugador - 1) * MIDA_INT;

            if (posicio + MIDA_INT > raf.length()) {
                System.out.println("Error: el jugador " + idJugador + " no existeix.");
                return;
            }

            raf.seek(posicio);
            int puntsActuals = raf.readInt();
            System.out.println("\nJugador " + idJugador + ": tenia " + puntsActuals + " punts.");

            // després del readInt el punter ha avançat, cal tornar a posar-lo
            raf.seek(posicio);
            raf.writeInt(puntsGuanyador);
            System.out.println("Ara té " + puntsGuanyador + " punts. Ha guanyat!\n");

            mostrarPunts(raf, "Després");

        } catch (IOException e) {
            System.err.println("[ERROR] Problema amb el fitxer punts.dat: " + e.getMessage());
        }
    }

    static void mostrarPunts(RandomAccessFile raf, String titol) throws IOException {
        System.out.println("--- " + titol + " ---");
        raf.seek(0);
        int id = 1;
        while (raf.getFilePointer() < raf.length()) {
            System.out.println("Jugador " + id + ": " + raf.readInt());
            id++;
        }
    }
}