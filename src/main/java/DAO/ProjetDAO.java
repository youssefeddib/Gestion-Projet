package DAO;

import Model.ProjetModel;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static DAO.DBconnexion.getConnection;

public class ProjetDAO {


    public void ajouterProjet(ProjetModel projet) {
        String sql = "INSERT INTO projet (nom, description, date_debut, date_fin) VALUES (?, ?, ?, ?)";
        try (Connection conn = getConnection();
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
        try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public List<ProjetModel> listerProjets() {
        List<ProjetModel> projets = new ArrayList<>();
        String query = "SELECT * FROM projet";
        try (Connection conn = getConnection();
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
    public void updateProjet(ProjetModel projet) {
        String sql = "UPDATE projet SET nom = ?, description = ?, date_debut = ?, date_fin = ? WHERE id = ?";
        try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, projet.getNom());
            stmt.setString(2, projet.getDescription());
            stmt.setString(3, projet.getDateDebut());
            stmt.setString(4, projet.getDateFin());
            stmt.setInt(5, projet.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public ProjetModel getProjetById(int id) {
        ProjetModel projet = null;
        String sql = "SELECT * FROM projet WHERE id = ?";

        try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);  // On passe l'ID en paramètre dans la requête
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    // Récupération des données du projet et création d'un objet ProjetModel
                    String nom = rs.getString("nom");
                    String description = rs.getString("description");
                    String dateDebut = rs.getString("date_debut");
                    String dateFin = rs.getString("date_fin");

                    // Initialisation de l'objet ProjetModel
                    projet = new ProjetModel(id, nom, description, dateDebut, dateFin);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return projet;
    }


}
