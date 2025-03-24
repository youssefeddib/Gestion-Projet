package Servlet;

import DAO.ProjetDAO;
import Model.ProjetModel;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/gestionProjet")
public class ProjetServlet extends HttpServlet {

    private ProjetDAO projetDAO;

    @Override
    public void init() throws ServletException {
        super.init();
        projetDAO = new ProjetDAO();
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<ProjetModel> projets = projetDAO.listerProjets();
        request.setAttribute("projets", projets);
        request.getRequestDispatcher("/ListeProjet.jsp").forward(request, response);
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nom = request.getParameter("nom");
        String description = request.getParameter("description");
        String dateDebut = request.getParameter("date_debut");
        String dateFin = request.getParameter("date_fin");

        if (nom == null || nom.isEmpty() || description == null || description.isEmpty() ||
                dateDebut == null || dateDebut.isEmpty() || dateFin == null || dateFin.isEmpty()) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Les informations du projet sont incomplètes");
            return;
        }

        ProjetModel projet = new ProjetModel(nom, description, dateDebut, dateFin);
        projetDAO.ajouterProjet(projet);


        response.sendRedirect(request.getContextPath() + "/gestionProjet");
    }


    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String projetId = request.getParameter("id");

        if (projetId != null && !projetId.isEmpty()) {
            try {
                int id = Integer.parseInt(projetId);
                projetDAO.supprimerProjet(id);
                response.setStatus(HttpServletResponse.SC_OK);  // إعادة الحالة 200 عند النجاح
            } catch (NumberFormatException e) {
                response.sendError(HttpServletResponse.SC_BAD_REQUEST, "ID de projet invalide");
            }
        } else {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "L'ID du projet est manquant");
        }
    }
}


