package exercicis.exercici9;

public class PreuProducteException extends RuntimeException {
    public PreuProducteException(String message) {
        super(message);
        // Excepció seva de la clase PreuProducte Exception.
        System.out.println("Preu del producte: ");
    }
}
