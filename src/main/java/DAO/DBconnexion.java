package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBconnexion {
    private static final String URL = "jdbc:mysql://localhost:3306/GestionProjet";
    private static final String USER = "root";
    private static final String PASSWORD = "youssef";

    public static Connection getConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Erreur de connexion à la base de données");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
