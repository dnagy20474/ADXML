package practica1;

public class Test {

    public static void main(String[] args) {

        // Llamamos el método de la clase GenerarListado.
        GenerarListado.generarDatos();

        System.out.println();

        // Instanciamos la clase de GestionFichero.
        LeerCSV gf = new LeerCSV();
        gf.menu(); // LLamamos al método del menú.

    }
}