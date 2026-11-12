package ud1.exercicis.exercici17;

import jakarta.xml.bind.annotation.*;
import java.util.*;

@XmlRootElement(name = "animals")
@XmlAccessorType(XmlAccessType.FIELD)
public class Animals {

    // cada element de la llista es converteix en un <animal>
    @XmlElement(name = "animal")
    private List<Animal> llista = new ArrayList<>();

    public Animals() {
    }

    public List<Animal> getLlista() { return llista; }
    public void setLlista(List<Animal> llista) { this.llista = llista; }

    public void afegir(Animal a) {
        llista.add(a);
    }
}