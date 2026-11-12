package ud1.exercicis.exercici17;

import org.w3c.dom.*;
import javax.xml.parsers.*;
import java.io.*;

public class LlegirXML {

    public static void main(String[] args) {
        try {

            // 1. Crear el constructor del document
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();

            // 2. Carregar el fitxer XML
            File fitxerXML = new File("animals.xml");
            Document document = builder.parse(fitxerXML);

            // 3. Normalitzar l'estructura de l'arbre de nodes
            document.getDocumentElement().normalize();

            // Mostrem l'element arrel per consola
            System.out.println("Element arrel: " + document.getDocumentElement().getNodeName());

            // 4. Obtenir la llista de nodes de l'etiqueta "animal" (en singular!)
            NodeList llistaAnimals = document.getElementsByTagName("animal");
            System.out.println("Total d'animals: " + llistaAnimals.getLength());
            System.out.println("---------------------------------------------");

            // 5. Recórrer la llista de nodes trobats
            for (int i = 0; i < llistaAnimals.getLength(); i++) {
                Node node = llistaAnimals.item(i);

                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element elementAnimal = (Element) node;

                    String id = elementAnimal.getAttribute("id");
                    String nom = elementAnimal.getElementsByTagName("nom").item(0).getTextContent();
                    String categoria = elementAnimal.getElementsByTagName("categoria").item(0).getTextContent();

                    System.out.println("Animal id: " + id);
                    System.out.println("  > Nom: " + nom);
                    System.out.println("  > Categoria: " + categoria);
                    System.out.println("---------------------------------------------");
                }
            }

        } catch (Exception e) {
            // fitxer no trobat, XML mal format, etc.
            e.printStackTrace();
        }
    }
}