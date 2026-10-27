package exercicis.exercici8;

import java.util.ArrayList;

public class Registre {

    // Atributs
    String id;
    String nomComplet;
    String ciutat;
    ArrayList<Registre> registres; // ArrayList pels registres.

    // Constructor
    public Registre(String id, String nomComplet, String ciutat) {
        this.setId(id);
        this.setNomComplet(nomComplet);
        this.setCiutat(ciutat);
    }

    // Un constructor per l'ArrayList.
    public Registre(ArrayList<Registre> registres) {
        this.registres = registres;
    }

    // Mètode per comprobar si és de Barcelona o no.
    public void esDeBarcelona() {

        boolean trobat = false;

        // Recorrem l'ArrayList.
        for (Registre r : registres) {

            // Comprovem si troba el String de ciutat que posi Barcelona.
            if (r.getCiutat().equals("Barcelona")) {
                trobat = true;
                break;
            }
        }

        // Si la trobat mostrem el resultat per consola.
        if (trobat) {
            System.out.println("Hi ha un usuari de Barcelona.");
        } else {
            System.out.println("No tenim cap usuari de Barcelona.");
        }
    }

    // Mètode toString().
    @Override
    public String toString() {
        String res = ""; // Variable per salts de lìnea, etc.

        // Si no está buit l'ArrayList el mostrem.
        if (registres != null) {

            // Recorrem l'ArrayList i posam els espais en el toString.
            for (Registre r : registres) {
                res += r.toString() + "\n";
            }

            return res;
        }

        // SI no hi ha res o només el r1 per exemple, el mostrem per a que no doni error.
        return "id=" + this.id +
                ", nomComplet='" + this.nomComplet + '\'' +
                ", ciutat='" + this.ciutat + '\'';
    }

    // Getters i Setters.
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNomComplet() {
        return nomComplet;
    }

    public void setNomComplet(String nomComplet) {
        this.nomComplet = nomComplet;
    }

    public String getCiutat() {
        return ciutat;
    }

    public void setCiutat(String ciutat) {
        this.ciutat = ciutat;
    }
}