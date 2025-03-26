package Servlet;

import DAO.TacheDAO;
import Model.TacheModel;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/gestionTache")
public class TacheServlet extends HttpServlet {

    private TacheDAO tacheDAO = new TacheDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        Integer projetId = request.getParameter("projetId") != null ? Integer.parseInt(request.getParameter("projetId")) : null;

        if (projetId == null) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Le projetId est requis.");
            return;  // Empêche l'exécution du reste du code si le projetId est manquant
        }

        if ("add".equals(action)) {
            // Préparez le formulaire d'ajout avec le projetId
            request.setAttribute("projetId", projetId);
            request.getRequestDispatcher("/AjouterTache.jsp").forward(request, response);
        } else if ("edit".equals(action)) {
            // Préparez le formulaire de modification
            int tacheId = Integer.parseInt(request.getParameter("modifier"));
            TacheModel tache = tacheDAO.getTacheById(tacheId);
            if (tache != null) {
                request.setAttribute("tache", tache);
                request.setAttribute("projetId", projetId);  // Ajout du projetId dans l'attribut de requête
                request.getRequestDispatcher("/modifierTache.jsp").forward(request, response);
            } else {
                response.sendError(HttpServletResponse.SC_NOT_FOUND, "Tâche introuvable");
            }
        } else if ("delete".equals(action)) {
            int tacheId = Integer.parseInt(request.getParameter("supprimer"));
            tacheDAO.supprimerTache(tacheId);  // Suppression de la tâche
            response.sendRedirect(request.getContextPath() + "/gestionTache?action=list&projetId=" + projetId);  // Redirection après suppression
        } else if ("list".equals(action)) {
            // Lister les tâches d'un projet spécifique
            List<TacheModel> taches = tacheDAO.getTachesByProjetId(projetId);
            request.setAttribute("taches", taches);
            request.setAttribute("projetId", projetId);  // Ajout du projetId pour l'affichage
            request.getRequestDispatcher("/Tache.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        Integer projetId = request.getParameter("projetId") != null ? Integer.parseInt(request.getParameter("projetId")) : null;

        if (projetId == null) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Le projetId est requis.");
            return;  // Empêche l'exécution du reste du code si le projetId est manquant
        }

        if ("add".equals(action)) {
            // Ajouter une nouvelle tâche
            String nom = request.getParameter("nom");
            String statut = request.getParameter("statut");
            String dateDebut = request.getParameter("date_debut");
            String dateFin = request.getParameter("date_fin");

            TacheModel tache = new TacheModel(nom, statut, dateDebut, dateFin, projetId);
            tacheDAO.ajouterTache(tache);
            response.sendRedirect(request.getContextPath() + "/gestionTache?action=list&projetId=" + projetId);  // Redirection vers la liste des tâches
        } else if ("edit".equals(action)) {
            // Modifier une tâche existante
            int id = Integer.parseInt(request.getParameter("modifier"));
            String nom = request.getParameter("nom");
            String statut = request.getParameter("statut");
            String dateDebut = request.getParameter("date_debut");
            String dateFin = request.getParameter("date_fin");

            TacheModel tache = new TacheModel(id, nom, statut, dateDebut, dateFin, projetId);
            tacheDAO.modifierTache(tache);
            response.sendRedirect(request.getContextPath() + "/gestionTache?action=list&projetId=" + projetId);  // Redirection vers la liste des tâches
        } else if ("delete".equals(action)) {
            // Supprimer une tâche
            int tacheId = Integer.parseInt(request.getParameter("supprimer"));
            tacheDAO.supprimerTache(tacheId);
            response.sendRedirect(request.getContextPath() + "/gestionTache?action=list&projetId=" + projetId);  // Redirection après suppression
        }else if ("list".equals(action)) {
            // Lister les tâches d'un projet spécifique
            List<TacheModel> taches = tacheDAO.getTachesByProjetId(projetId);
            request.setAttribute("taches", taches);
            request.setAttribute("projetId", projetId);  // Ajout du projetId pour l'affichage
            request.getRequestDispatcher("/Tache.jsp").forward(request, response);
        }
    }
}

