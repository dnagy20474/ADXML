package exercici17;

import jakarta.xml.bind.*;
import java.io.*;


public class XmlToObjecte {

    // Mètode que rep la ruta i retorna l'objecte Alumne
    public static Alumne carregarAlumneDesDeXml(String rutaFitxer) throws Exception {
        // 1. Inicialitzar JAXB per a la classe Alumne
        JAXBContext context = JAXBContext.newInstance(Alumne.class);

        // 2. Crear l'Unmarshaller
        Unmarshaller unmarshaller = context.createUnmarshaller();

        // 3. Llegir el fitxer XML i fer el binding a l'objecte
        File fitxer = new File(rutaFitxer);

        return (Alumne) unmarshaller.unmarshal(fitxer);
    }
}
