package exercicis.exercici9;

public class FormatLiniaException extends Exception {
    public FormatLiniaException(String message) {
        super(message);
        // Excepció seva de la clase FormatLiniaException.
        System.out.println("Format de Lína: ");
    }
}
