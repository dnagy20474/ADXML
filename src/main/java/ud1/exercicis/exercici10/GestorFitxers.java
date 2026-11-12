package ud1.exercicis.exercici10;

import java.io.*;
import java.nio.file.*;
import java.nio.file.attribute.*;
import java.util.*;

public class GestorFitxers {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int opcio;

        do {
            mostrarMenu();
            try {
                opcio = Integer.parseInt(sc.nextLine().trim());
            } catch (NumberFormatException e) {
                opcio = -1;
            }

            switch (opcio) {
                case 1:
                    crearFitxer();
                    break;
                case 2:
                    crearDirectori();
                    break;
                case 3:
                    eliminarFitxer();
                    break;
                case 4:
                    copiarFitxer();
                    break;
                case 5:
                    moureFitxer();
                    break;
                case 6:
                    consultarInfo();
                    break;
                case 0:
                    System.out.println("Adéu!");
                    break;
                default:
                    System.out.println("Opció no vàlida, torna-ho a provar.");
            }
        } while (opcio != 0);
    }

    static void mostrarMenu() {
        System.out.println();
        System.out.println("===== GESTOR DE FITXERS =====");
        System.out.println("1. Crear fitxer");
        System.out.println("2. Crear directori");
        System.out.println("3. Eliminar fitxer");
        System.out.println("4. Copiar fitxer");
        System.out.println("5. Moure fitxer");
        System.out.println("6. Consultar informació");
        System.out.println("0. Sortir");
        System.out.print("Tria una opció: ");
    }

    static Path demanarRuta(String missatge) {
        System.out.print(missatge);
        String text = sc.nextLine().trim();
        try {
            return Paths.get(text);
        } catch (InvalidPathException e) {
            System.out.println("Error: la ruta no és vàlida.");
            return null;
        }
    }

    static void crearFitxer() {
        Path ruta = demanarRuta("Ruta del fitxer a crear: ");
        if (ruta == null) return;

        try {
            Files.createFile(ruta);
            System.out.println("Fitxer creat correctament.");
        } catch (FileAlreadyExistsException e) {
            System.out.println("Error: el fitxer ja existeix.");
        } catch (NoSuchFileException e) {
            System.out.println("Error: el directori pare no existeix.");
        } catch (IOException e) {
            System.out.println("Error en crear el fitxer: " + e.getMessage());
        }
    }

    static void crearDirectori() {
        Path ruta = demanarRuta("Ruta del directori a crear: ");
        if (ruta == null) return;

        try {
            Files.createDirectory(ruta);
            System.out.println("Directori creat correctament.");
        } catch (FileAlreadyExistsException e) {
            System.out.println("Error: ja existeix un fitxer o directori amb aquest nom.");
        } catch (NoSuchFileException e) {
            System.out.println("Error: el directori pare no existeix.");
        } catch (IOException e) {
            System.out.println("Error en crear el directori: " + e.getMessage());
        }
    }

    static void eliminarFitxer() {
        Path ruta = demanarRuta("Ruta del fitxer a eliminar: ");
        if (ruta == null) return;

        try {
            Files.delete(ruta);
            System.out.println("Eliminat correctament.");
        } catch (NoSuchFileException e) {
            System.out.println("Error: el fitxer no existeix.");
        } catch (DirectoryNotEmptyException e) {
            System.out.println("Error: el directori no està buit.");
        } catch (IOException e) {
            System.out.println("Error en eliminar: " + e.getMessage());
        }
    }

    static void copiarFitxer() {
        Path origen = demanarRuta("Ruta d'origen: ");
        if (origen == null) return;
        Path desti = demanarRuta("Ruta de destí: ");
        if (desti == null) return;

        try {
            Files.copy(origen, desti);
            System.out.println("Fitxer copiat correctament.");
        } catch (NoSuchFileException e) {
            System.out.println("Error: no existeix el fitxer o el directori: " + e.getMessage());
        } catch (FileAlreadyExistsException e) {
            System.out.println("Error: el destí ja existeix.");
        } catch (IOException e) {
            System.out.println("Error en copiar: " + e.getMessage());
        }
    }

    static void moureFitxer() {
        Path origen = demanarRuta("Ruta d'origen: ");
        if (origen == null) return;
        Path desti = demanarRuta("Ruta de destí: ");
        if (desti == null) return;

        try {
            Files.move(origen, desti);
            System.out.println("Fitxer mogut correctament.");
        } catch (NoSuchFileException e) {
            System.out.println("Error: no existeix el fitxer o el directori: " + e.getMessage());
        } catch (FileAlreadyExistsException e) {
            System.out.println("Error: el destí ja existeix.");
        } catch (IOException e) {
            System.out.println("Error en moure: " + e.getMessage());
        }
    }

    static void consultarInfo() {
        Path ruta = demanarRuta("Ruta a consultar: ");
        if (ruta == null) return;

        if (!Files.exists(ruta)) {
            System.out.println("Error: la ruta no existeix.");
            return;
        }

        try {
            BasicFileAttributes attrs = Files.readAttributes(ruta, BasicFileAttributes.class);

            System.out.println("--- Informació ---");
            System.out.println("Nom: " + ruta.getFileName());
            System.out.println("Ruta absoluta: " + ruta.toAbsolutePath());
            System.out.println("Tipus: " + (Files.isDirectory(ruta) ? "Directori" : "Fitxer"));
            System.out.println("Mida: " + attrs.size() + " bytes");
            System.out.println("Creat: " + attrs.creationTime());
            System.out.println("Última modificació: " + attrs.lastModifiedTime());
            System.out.println("Es pot llegir: " + Files.isReadable(ruta));
            System.out.println("Es pot escriure: " + Files.isWritable(ruta));
        } catch (IOException e) {
            System.out.println("Error en llegir la informació: " + e.getMessage());
        }
    }
}