package DAO;

import Model.Projet;
import DAO.DBconnexion;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProjetDAO {
    public void ajouterProjet(Projet projet) {
        String sql = "INSERT INTO Projet (nom, description, date_debut, date_fin) VALUES (?, ?, ?, ?)";
        try (Connection conn = DBconnexion.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, projet.getNom());
            stmt.setString(2, projet.getDescription());
            stmt.setString(3, projet.getDateDebut());
            stmt.setString(4, projet.getDateFin());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Projet> listerProjets() {
        List<Projet> projets = new ArrayList<>();
        String sql = "SELECT * FROM Projet";
        try (Connection conn = DBconnexion.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                projets.add(new Projet(
                        rs.getInt("id"),
                        rs.getString("nom"),
                        rs.getString("description"),
                        rs.getString("date_debut"),
                        rs.getString("date_fin")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return projets;
    }
}
