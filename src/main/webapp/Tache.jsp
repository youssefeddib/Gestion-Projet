<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="Model.TacheModel" %>

<%
    // Récupération de la liste des tâches depuis la requête
    List<TacheModel> taches = (List<TacheModel>) request.getAttribute("taches");
    int projetId = Integer.parseInt(request.getParameter("projetId"));

    if (taches == null) {
        taches = new ArrayList<>();
    }
%>

<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Liste des Tâches</title>
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

        .task-container {
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
            border: 1px solid black;
            margin: 10px;
        }

        .card img {
            width: 100%;
            height: 100%;
            margin: auto;
        }

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
                    <a class="btn btn-outline-dark me-2" href="gestionTache?action=add&projetId=<%= projetId %>">Ajouter une Tâche</a>
                </li>
            </ul>
        </div>
    </div>
</nav>

<!-- Liste des Tâches -->
<div class="task-container">
    <h3 class="text-center mb-4">Liste des Tâches</h3>
    <div class="row">
        <% if (taches.isEmpty()) { %>
        <p class="text-center text-muted">Aucune tâche ajoutée pour l'instant.</p>
        <% } else {
            for (TacheModel tache : taches) { %>
        <div class="col-md-4">
            <div class="card p-3 mb-4 shadow-sm">
                <img src="https://images.pexels.com/photos/585419/pexels-photo-585419.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1" alt="Task Icon">
                <h5 class="text-warning text-center " ><%= tache.getNom() %></h5>
                <p><strong>Statut:</strong> <%= tache.getStatut() %></p>
                <strong>Date Début:</strong> <%= tache.getDateDebut() %><br>
                <strong>Date Fin:</strong> <%= tache.getDateFin() %>
                <div class="btn-group">
                    <form action="gestionTache?action=edit&projetId=<%= projetId %>" method="post">
                        <input type="hidden" name="modifier" value="<%= tache.getId() %>">
                        <button type="submit" class="btn btn-primary">Modifier</button>
                    </form>

                    <form action="gestionTache?action=delete&projetId=<%= projetId %>" method="post">
                        <input type="hidden" name="supprimer" value="<%= tache.getId() %>">
                        <input type="hidden" name="projetId" value="<%= projetId %>">  <!-- Projet ID caché -->
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
