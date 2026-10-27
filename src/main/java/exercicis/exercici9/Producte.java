package exercicis.exercici9;

public class Producte {

    private int codi;
    private double preu;

    public Producte(int codi, double preu) {
        this.codi = codi;
        this.preu = preu;
    }

    @Override
    public String toString() {
        return "Producte{codi=" + codi + ", preu=" + preu + "}";
    }
}