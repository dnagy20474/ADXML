package ud1.exercicis.exercici17;

import jakarta.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder = {"nom", "categoria"})
public class Animal {

    @XmlAttribute
    private int id;

    private String nom;
    private String categoria;

    // JAXB necessita un constructor buit
    public Animal() {
    }

    public Animal(int id, String nom, String categoria) {
        this.id = id;
        this.nom = nom;
        this.categoria = categoria;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }

    public String getCategoria() { return categoria; }
    public void setCategoria(String categoria) { this.categoria = categoria; }

    @Override
    public String toString() {
        return "Animal id: " + id + " | Nom: " + nom + " | Categoria: " + categoria;
    }
}