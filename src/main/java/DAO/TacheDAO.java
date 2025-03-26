package DAO;

import Model.TacheModel;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static DAO.DBconnexion.getConnection;

public class TacheDAO {

    public void ajouterTache(TacheModel tache) {
        String sql = "INSERT INTO Tache (nom, statut, date_debut, date_fin, projet_id) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, tache.getNom());
            stmt.setString(2, tache.getStatut());
            stmt.setString(3, tache.getDateDebut());
            stmt.setString(4, tache.getDateFin());
            stmt.setInt(5, tache.getProjetId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void supprimerTache(int id) {
        String sql = "DELETE FROM Tache WHERE id = ?";
        try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void modifierTache(TacheModel tache) {
        String sql = "UPDATE Tache SET nom = ?, statut = ?, date_debut = ?, date_fin = ?, projet_id = ? WHERE id = ?";
        try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, tache.getNom());
            stmt.setString(2, tache.getStatut());
            stmt.setString(3, tache.getDateDebut());
            stmt.setString(4, tache.getDateFin());
            stmt.setInt(5, tache.getProjetId());
            stmt.setInt(6, tache.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public TacheModel getTacheById(int id) {
        TacheModel tache = null;
        String sql = "SELECT * FROM Tache WHERE id = ?";
        try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    tache = new TacheModel(
                            rs.getInt("id"),
                            rs.getString("nom"),
                            rs.getString("statut"),
                            rs.getString("date_debut"),
                            rs.getString("date_fin"),
                            rs.getInt("projet_id")
                    );
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tache;
    }

    public List<TacheModel> getTachesByProjetId(int projetId) {
        List<TacheModel> taches = new ArrayList<>();
        String sql = "SELECT * FROM Tache WHERE projet_id = ?";
        try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, projetId);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    TacheModel tache = new TacheModel(
                            rs.getInt("id"),
                            rs.getString("nom"),
                            rs.getString("statut"),
                            rs.getString("date_debut"),
                            rs.getString("date_fin"),
                            rs.getInt("projet_id")
                    );
                    taches.add(tache);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return taches;
    }
}

