package exercicis.exercici9;

public class CodiProducteException extends Exception {
    public CodiProducteException(String message) {
        super(message);
        // Excepció seva de la clase CodiProducteException.
        System.out.println("Codi producte: ");
    }
}
