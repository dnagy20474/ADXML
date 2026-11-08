package exercicis.exercici17;

import jakarta.xml.bind.*;
import java.io.*;

public class MarshalUnmarshal {

    public static void main(String[] args) {
        File fitxer = new File("animals_jaxb.xml");

        try {
            JAXBContext context = JAXBContext.newInstance(Animals.class);

            // ---------- MARSHAL: objectes Java -> XML ----------
            Animals animals = new Animals();
            animals.afegir(new Animal(1, "Lleó", "Mamífer"));
            animals.afegir(new Animal(2, "Àguila", "Ocell"));
            animals.afegir(new Animal(3, "Clownfish", "Peix"));
            animals.afegir(new Animal(4, "Tortuga", "Rèptil"));

            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.marshal(animals, fitxer);
            System.out.println("Marshal fet: s'ha creat '" + fitxer.getName() + "'.");
            marshaller.marshal(animals, System.out);

            // ---------- UNMARSHAL: XML -> objectes Java ----------
            Unmarshaller unmarshaller = context.createUnmarshaller();
            Animals llegits = (Animals) unmarshaller.unmarshal(fitxer);

            System.out.println("\nUnmarshal fet. Animals llegits: " + llegits.getLlista().size());
            for (Animal a : llegits.getLlista()) {
                System.out.println(a);
            }

        } catch (JAXBException e) {
            System.err.println("[ERROR] Problema amb JAXB: " + e.getMessage());
        }
    }
}