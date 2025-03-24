<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="Model.ProjetModel" %>

<%
    // Récupération de la liste des projets depuis la requête
    List<ProjetModel> projets = (List<ProjetModel>) request.getAttribute("projets");
    if (projets == null) {
        projets = new ArrayList<>();
    }
%>

<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Liste des Projets</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>

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
            font-size: 24px;
            font-weight: bold;
            color: black !important;
        }

        .project-container {

            padding: 30px;
            border-radius: 10px;
            width: 90%;
            max-width: 1100px;
            margin: auto;
            margin-top: 50px;

        }

        .card {
            border-radius: 15px;
            transition: transform 0.2s;
            background: rgba(255, 255, 255, 0.42);
            backdrop-filter: blur(10px);
            border: none;

        }
        .card img {
            width: 100%;
            height: 100%;
            margin: auto;
            border-radius: 15px;

        .card:hover {
            transform: scale(1.05);
        }

        .btn-group {

            margin: auto;
            gap: 20px;
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
                    <a class="btn btn-outline-dark me-2" href="Projet.jsp">Ajouter un Projet</a>
                </li>
            </ul>
        </div>
    </div>
</nav>

<!-- Liste des Projets -->
<div class="project-container">
    <h3 class="text-center mb-4">Liste des Projets</h3>
    <div class="row">
        <% if (projets.isEmpty()) { %>
        <p class="text-center text-muted">Aucun projet ajouté pour l'instant.</p>
        <% } else {
            for (ProjetModel projet : projets) { %>
        <div class="col-md-4">
            <div class="card p-3 mb-4 shadow-sm">
                <img src="https://images.pexels.com/photos/585419/pexels-photo-585419.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1" alt="Project Icon">
                <h5 class="text-warning text-center" ><%= projet.getNom() %></h5>
                <p><strong>Description:</strong> <%= projet.getDescription() %></p>
                <strong>Date_Debut:</strong> <%= projet.getDateDebut() %>
                 <strong>Date_Fin:</strong> <%= projet.getDateFin() %>
                <div class="btn-group">

                <form action="ModifierProjet.jsp" method="post">
                    <input type="hidden" name="modifier" value="<%= projet.getId() %>">
                    <button type="submit" class="btn btn-primary">Modifier</button>
                </form>

                    <form action="gestionProjet?action=delete" method="post">
                    <input type="hidden" name="supprimer" value="<%= projet.getId() %>">
                    <button type="submit" class="btn btn-danger">Supprimer</button>
                </form>
                </div>
            </div>
        </div>
        <% }
        } %>
    </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
