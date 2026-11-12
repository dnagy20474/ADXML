package ud1.exercicis.exercici18;

public class Cotxe {

    private String marca;
    private String model;
    private int any;
    private boolean electric;

    // Jackson necessita un constructor buit
    public Cotxe() {
    }

    public Cotxe(String marca, String model, int any, boolean electric) {
        this.marca = marca;
        this.model = model;
        this.any = any;
        this.electric = electric;
    }

    public String getMarca() { return marca; }
    public void setMarca(String marca) { this.marca = marca; }

    public String getModel() { return model; }
    public void setModel(String model) { this.model = model; }

    public int getAny() { return any; }
    public void setAny(int any) { this.any = any; }

    public boolean isElectric() { return electric; }
    public void setElectric(boolean electric) { this.electric = electric; }

    @Override
    public String toString() {
        return marca + " " + model + " (" + any + ") - elèctric: " + (electric ? "sí" : "no");
    }
}