package exercicis.exercici17;

//import jakarta.xml.bind.annotation.XmlElement;

// Es defineix el nom de l'etiqueta arrel de l'XML
//@XmlRootElement(name = "alumne")

public class Alumne {


    private String nom;
    private int edat;


    // JAXB requereix obligatòriament un constructor buit (sense paràmetres)
    public Alumne() {}


    public Alumne(String nom, int edat) {
        this.nom = nom;
        this.edat = edat;
    }


//    @XmlElement // Mapeja el mètode o variable amb una etiqueta <nom>
//    public String getNom() {
//        return nom;
//    }


    public void setNom(String nom) {
        this.nom = nom;
    }


//    @XmlElement // Mapeja el mètode o variable amb una etiqueta <edat>
//    public int getEdat() {
//        return edat;
//    }


    public void setEdat(int edat) {
        this.edat = edat;
    }
}
