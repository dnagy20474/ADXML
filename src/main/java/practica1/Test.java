package practica1;

public class Test {

    public static void main(String[] args) {

        // Instanciamos la clase GenerarListado para poder ejecutarla.
        GenerarListado gl = new GenerarListado();

        // Llamamos el método de la clase GenerarListado.
        gl.generarDatos();

        System.out.println();

        // Instanciamos la clase de GestionFichero.
        GestionFichero gf = new GestionFichero();
        gf.menu(); // LLamamos al método del menú.

    }
}