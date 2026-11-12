package ud1.exercicis.exercici18;

import com.fasterxml.jackson.core.type.*;
import com.fasterxml.jackson.databind.*;

import java.io.*;
import java.util.*;

public class JsonCotxes {

    public static void main(String[] args) {
        ObjectMapper mapper = new ObjectMapper();
        // perquè el JSON de sortida quedi amb sagnats i es pugui llegir bé
        mapper.enable(SerializationFeature.INDENT_OUTPUT);

        File fitxerEntrada = new File("cotxes.json");
        File fitxerSortida = new File("cotxes_nou.json");

        try {
            // ---------- DESERIALITZAR: JSON -> objectes Java ----------
            List<Cotxe> cotxes = mapper.readValue(fitxerEntrada, new TypeReference<List<Cotxe>>() {});

            System.out.println("Cotxes llegits: " + cotxes.size());
            for (Cotxe c : cotxes) {
                System.out.println("  " + c);
            }

            // modifiquem la llista per comprovar que realment treballem amb objectes
            cotxes.add(new Cotxe("Renault", "Zoe", 2022, true));

            // ---------- SERIALITZAR: objectes Java -> JSON ----------
            mapper.writeValue(fitxerSortida, cotxes);
            System.out.println("\nS'ha creat '" + fitxerSortida.getName() + "' amb " + cotxes.size() + " cotxes.");
            System.out.println(mapper.writeValueAsString(cotxes));

        } catch (IOException e) {
            System.err.println("[ERROR] Problema amb el fitxer JSON: " + e.getMessage());
        }
    }
}