package ud2.exercici1;

import java.sql.*;
import java.text.DateFormat;

public class Exercici1 {

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/tienda";
        String usuari = "root";
        String contrasenya = "KeepCalm21."; // Contrasenya

        System.out.println("Iniciant el programa...");

        // Utilitzem try-with-resources per obrir la connexió de manera segura
        try {
            System.out.println("Intentant connectar a la base de dades...");

            Connection conn = DriverManager.getConnection(url, usuari, contrasenya);

            // Si la línia anterior falla, Java salta directament al 'catch' i aquesta línia NO s'executarà
            System.out.println("Connexió establerta correctament!");

        } catch (SQLException e) {
            // Aquest bloc només s'executa si es llança una excepció de tipus SQLException
            System.err.println("\n[ERROR] No s'ha pogut connectar a la base de dades.");

            // Propietats útils de l'objecte d'excepció (e):
            System.err.println("Missatge de l'error: " + e.getMessage());
            System.err.println("Codi d'estat SQL: " + e.getSQLState());
            System.err.println("Codi d'error del proveïdor: " + e.getErrorCode());

            // Imprimeix tota la traça de l'error per saber exactament en quina línia ha fallat
            // e.printStackTrace();

        } finally {
            // Aquest codi s'executarà SEMPRE
            System.out.println("\nBloc 'finally': El programa ha acabat de gestionar l'intent de connexió.");
        }
        System.out.println("El programa continua viu gràcies al 'catch' i no s'ha penjat!");
    }

    // Métode per a insertar dadas.
    public static void insertar(Connection conn, int idUsuario, String nombre, String email,
                                boolean moroso, String fechaAlta, String fechaBaja) throws SQLException {
        String sql = "INSERT INTO USUARIOS (idUsuario, nombre, email, moroso, fechaAlta, " +
                "fechaBaja) " + "VALUES (?, ?, ?, ?, ?, ?)";

        // Control d'error.
        try (PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

        }
    }
}