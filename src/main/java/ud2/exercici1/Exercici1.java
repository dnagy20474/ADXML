package ud2.exercici1;

import java.sql.*;

public class Exercici1 {

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/tienda";
        String usuari = "root";
        String contrasenya = "KeepCalm21."; // Contrasenya

        System.out.println("Iniciant el programa...");

        // try-with-resources: la connexió es tanca sola a l'acabar el bloc
        try (Connection conn = DriverManager.getConnection(url, usuari, contrasenya)) {
            System.out.println("Connexió establerta correctament!");

            // 1) Inserim un usuari de prova
            insertar(conn, 1, "Pepe", "pepe@correo.com", false, "2026-11-13 10:00:00", null);

            // 2) Mostrem el contingut de la taula USUARIOS
            listarUsuarios(conn);

        } catch (SQLException e) {
            System.err.println("\n[ERROR] No s'ha pogut connectar o executar la consulta.");
            System.err.println("Missatge de l'error: " + e.getMessage());
            System.err.println("Codi d'estat SQL: " + e.getSQLState());
            System.err.println("Codi d'error del proveïdor: " + e.getErrorCode());
        } finally {
            System.out.println("\nBloc 'finally': El programa ha acabat.");
        }
    }

    // Mètode per a inserir dades.
    public static void insertar(Connection conn, int idUsuario, String nombre, String email,
                                boolean moroso, String fechaAlta, String fechaBaja) throws SQLException {

        // Fèiem l'insert amb el String a la taula USUARIOS.
        String sql = "INSERT INTO USUARIOS (IdUsuario, Nombre, Email, Moroso, FechaAlta, FechaBaja) " +
                "VALUES (?, ?, ?, ?, ?, ?)";

        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, idUsuario);
            ps.setString(2, nombre);
            ps.setString(3, email);
            ps.setBoolean(4, moroso);
            ps.setString(5, fechaAlta);
            ps.setString(6, fechaBaja); // si és null, es guarda NULL

            int filas = ps.executeUpdate();
            System.out.println("Files inserides: " + filas);
        } catch (SQLException e) {
            // Per exemple, si l'IdUsuario ja existeix (clau duplicada)
            System.err.println("No s'ha pogut inserir: " + e.getMessage());
        }
    }

    // Mètode per a mostrar la taula USUARIOS.
    public static void listarUsuarios(Connection conn) throws SQLException {
        String sql = "SELECT IdUsuario, Nombre, Email, Moroso, FechaAlta, FechaBaja FROM USUARIOS";

        try (Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            System.out.println("\n--- TAULA USUARIOS ---");
            while (rs.next()) {
                System.out.println(rs.getInt("IdUsuario") + " | "
                        + rs.getString("Nombre") + " | "
                        + rs.getString("Email") + " | "
                        + rs.getBoolean("Moroso") + " | "
                        + rs.getTimestamp("FechaAlta") + " | "
                        + rs.getTimestamp("FechaBaja"));
            }
        }
    }
}