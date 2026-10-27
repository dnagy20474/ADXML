package exercicis.exercici9;

public class Caixer {

    private String[] productesRebuts = {
            "101#4.55",
            "302#gratis",
            "303#",
            "P04#12,99",
            "P04#12.99",
            "1.99#",
            "#"
    };

    public void processarRegistre() {

        for (String registre : productesRebuts) {

            try {

                // Comprovar que la línia tengui el format correcte
                String[] parts = registre.split("#", -1);

                if (parts.length != 2) {
                    throw new FormatLiniaException(
                            "Format incorrecte. S'esperava CODI#PREU."
                    );
                }

                String codiText = parts[0];
                String preuText = parts[1];

                // Comprovar el codi
                if (!codiText.matches("\\d{3}")) {
                    throw new CodiProducteException(
                            "El codi ha de ser un enter de 3 dígits."
                    );
                }

                int codi = Integer.parseInt(codiText);

                // Comprovar el preu
                if (preuText.isEmpty()) {
                    throw new PreuProducteException(
                            "El preu no pot estar buit."
                    );
                }

                double preu;

                try {
                    preu = Double.parseDouble(preuText);
                } catch (NumberFormatException e) {
                    throw new PreuProducteException(
                            "El preu no és un decimal vàlid."
                    );
                }

                // Si tot és correcte, creem el producte
                Producte producte = new Producte(codi, preu);

                System.out.println("Producte correcte: " + producte);

            } catch (FormatLiniaException e) {

                System.out.println(
                        "Error de format: " + registre +
                                " -> " + e.getMessage()
                );

            } catch (CodiProducteException e) {

                System.out.println(
                        "Error de codi: " + registre +
                                " -> " + e.getMessage()
                );

            } catch (PreuProducteException e) {

                System.out.println(
                        "Error de preu: " + registre +
                                " -> " + e.getMessage()
                );
            }
        }
    }
}