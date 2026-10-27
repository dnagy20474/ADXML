package exercicis.exerici16;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

public class LlegirXML {

    public static void main(String[] args) {
        try {

            // 1. Crear el constructor del document
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

            DocumentBuilder builder = factory.newDocumentBuilder();

            // 2. Carregar el fitxer XML
            File fitxerXML = new File("animals.xml");

            //aplicar el parser per donar format al document
            Document document = builder.parse(fitxerXML);

            // 3. Normalitzar l'estructura de l'arbre de nodes
            document.getDocumentElement().normalize();

            // Mostrem l'element arrel per consola
            System.out.println("Element arrel: " + document.getDocumentElement().getNodeName());

            // 4. Obtenir la llista de nodes de l'etiqueta "alumne"
            NodeList llistaAnimals = document.getElementsByTagName("animals");


            // 5. Recórrer la llista de nodes trobats
            for (int i = 0; i < llistaAnimals.getLength(); i++) {
                Node node = llistaAnimals.item(i);

                // Comprovem si el node actual és un Element
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element elementAnimal = (Element) node;

                    // Llegir l'atribut 'id' de l'element alumne
                    String id = elementAnimal.getAttribute("id");

                    // Llegir el contingut
                    String nom = elementAnimal.getElementsByTagName("nom").item(0).getTextContent();

                    String categoria = elementAnimal.getElementsByTagName("categoria").item(0).getTextContent();

                    // Mostrar les dades extretes
                    System.out.println("Animal id: " + id);
                    System.out.println("  > Nom: " + nom);
                    System.out.println("  > Categoria: " + categoria);
                    System.out.println("---------------------------------------------");
                }
            }

        } catch (Exception e) {
            // Gestió bàsica d'errors (fitxer no trobat, XML mal format, etc.)
            e.printStackTrace();
        }
    }
}