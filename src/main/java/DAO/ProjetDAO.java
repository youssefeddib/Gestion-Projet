package DAO;

import Model.ProjetModel;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProjetDAO {


    public void ajouterProjet(ProjetModel projet) {
        String sql = "INSERT INTO projet (nom, description, date_debut, date_fin) VALUES (?, ?, ?, ?)";
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


    public void supprimerProjet(int id) {
        String sql = "DELETE FROM projet WHERE id = ?";
        try (Connection conn = DBconnexion.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public List<ProjetModel> listerProjets() {
        List<ProjetModel> projets = new ArrayList<>();
        String query = "SELECT * FROM projet";
        try (Connection conn = DBconnexion.getConnection();
             PreparedStatement ps = conn.prepareStatement(query);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                ProjetModel projet = new ProjetModel();
                projet.setId(rs.getInt("id"));
                projet.setNom(rs.getString("nom"));
                projet.setDescription(rs.getString("description"));
                projet.setDateDebut(rs.getString("date_debut"));
                projet.setDateFin(rs.getString("date_fin"));
                projets.add(projet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return projets;
    }
}
