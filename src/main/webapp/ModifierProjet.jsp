<%@ page import="Model.ProjetModel" %>
<%@ page import="DAO.ProjetDAO" %>
<%@ page import="java.util.List" %>

<%
    // Récupérer l'ID du projet à modifier depuis la requête
    String modifierParam = request.getParameter("modifier");
    int idpr = (modifierParam != null) ? Integer.parseInt(modifierParam) : -1; // Default to -1 if invalid ID
    ProjetDAO pr = new ProjetDAO();

    ProjetModel projet = null;
    if (idpr != -1) {
        projet = pr.getProjetById(idpr);
    }
%>

<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Modifier un Projet</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        @import url('https://fonts.googleapis.com/css2?family=Playfair+Display:wght@700&family=Roboto:wght@400;700&display=swap');

        body {
            font-family: 'Roboto', sans-serif;
            background: url('https://images.pexels.com/photos/585418/pexels-photo-585418.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1') no-repeat center center fixed;
            background-size: cover;
            height: 100vh;
        }
        .navbar {
            background: rgba(255, 255, 255, 0.42);
            backdrop-filter: blur(10px);
        }
        .navbar-brand {
            font-family: 'Roboto', serif;
            font-size: 24px;
            font-weight: bold;
            color: black !important;
        }
        .form-container {
            background: rgba(255, 255, 255, 0.42);
            padding: 30px;
            border-radius: 10px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.2);
            width: 100%;
            max-width: 450px;
            position: absolute;
            top: 25%;
            left: 10%;
        }
        .form-wrapper {
            display: flex;
            justify-content: center;
            align-items: center;
            height: calc(100vh - 60px);
        }
        .form-container h3 {
            color: #ffae00;
            text-align: center;
        }
        .mb-3 {
            text-align: left;
        }
        .btn-primary {
            width: 100%;
        }
    </style>
</head>
<body>

<!-- Navbar -->
<nav class="navbar navbar-expand-lg navbar-light shadow-sm">
    <div class="container">
        <img style="width: 70px; height: 70px;" src="img.png">
        <a class="navbar-brand text-dark" href="#">ConstructionXpert</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse justify-content-end" id="navbarNav">
            <ul class="navbar-nav">
                <li class="nav-item">
                    <a class="btn btn-outline-dark me-2" href="/GestionProjet/gestionProjet">Liste Projets</a>
                </li>
            </ul>
        </div>
    </div>
</nav>

<!-- Formulaire -->
<div class="form-wrapper">
    <div class="form-container">
        <h3 class="mb-4 fw-bold">Modifier un Projet</h3>

        <% if (projet != null) { %>
        <form action="gestionProjet?action=edit" method="post">
            <input type="hidden" name="id" value="<%= projet.getId() %>">

            <div class="mb-3">
                <p><strong>Nom du Projet</strong></p>
                <input type="text" class="form-control" name="nom" value="<%= projet.getNom() %>" required>
            </div>

            <div class="mb-3">
                <p><strong>Description</strong></p>
                <input type="text" class="form-control" name="description" value="<%= projet.getDescription() %>" required>
            </div>

            <div class="mb-3">
                <p><strong>Date de Début</strong></p>
                <input type="date" class="form-control" name="date_debut" value="<%= projet.getDateDebut() %>" required>
            </div>

            <div class="mb-3">
                <p><strong>Date de Fin</strong></p>
                <input type="date" class="form-control" name="date_fin" value="<%= projet.getDateFin() %>" required>
            </div>

            <button type="submit" class="btn btn-primary">Modifier</button>
        </form>
        <% } else { %>
        <p class="text-center text-danger">Le projet demandé n'existe pas.</p>
        <% } %>
    </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
