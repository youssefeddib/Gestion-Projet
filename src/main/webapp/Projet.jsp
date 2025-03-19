<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="Model.ProjetModel" %>

<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Gestion des Projets</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        body {
            font-family: 'Roboto', sans-serif;
            background-color: #f8f9fa;
        }

        .container-box {
            max-width: 900px;
            margin: 50px auto;
            background: #fff;
            padding: 30px;
            border-radius: 10px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
        }

        h2 {
            color: #007bff;
            text-align: center;
            margin-bottom: 30px;
        }

        .form-container {
            background-color: #f8f9fa;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
            margin-bottom: 40px;
        }

        .form-container h3 {
            color: #007bff;
            margin-bottom: 20px;
            text-align: center;
        }

        .form-control {
            border-radius: 8px;
            padding: 12px;
        }

        .btn-primary {
            background-color: #007bff;
            border: none;
            border-radius: 20px;
            font-weight: bold;
            padding: 12px;
            width: 100%;
            margin-top: 20px;
        }

        .btn-primary:hover {
            background-color: #0056b3;
        }

        .project-card {
            background-color: #fff;
            border-radius: 8px;
            padding: 20px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
            margin-bottom: 20px;
        }

        .project-card h5 {
            color: #007bff;
            margin-bottom: 15px;
        }

        .project-card p {
            color: #333;
        }

        .row .col-md-4 {
            margin-bottom: 30px;
        }
    </style>
</head>
<body>

<!-- Gestion des projets -->
<div id="gestion" class="container-box section active">
    <h2>Gestion des Projets</h2>

    <!-- Formulaire d'ajout d'un projet -->
    <div class="form-container">
        <h3>Ajouter un nouveau projet</h3>
        <form action="gestionProjet" method="post">
            <div class="mb-3">
                <label for="nom" class="form-label">Nom du projet</label>
                <input type="text" class="form-control" id="nom" name="nom" required>
            </div>

            <div class="mb-3">
                <label for="description" class="form-label">Description</label>
                <textarea class="form-control" id="description" name="description" required></textarea>
            </div>

            <div class="mb-3">
                <label for="date_debut" class="form-label">Date de début</label>
                <input type="date" class="form-control" id="date_debut" name="date_debut" required>
            </div>

            <div class="mb-3">
                <label for="date_fin" class="form-label">Date de fin</label>
                <input type="date" class="form-control" id="date_fin" name="date_fin" required>
            </div>

            <button type="submit" class="btn btn-primary">Ajouter</button>
        </form>
    </div>

    <!-- Liste des projets -->
    <h3>Liste des projets</h3>
    <div class="row">
        <%
            // Récupérer l'objet projets depuis la requête
            List<ProjetModel> projets = (List<ProjetModel>) request.getAttribute("projets");
            if (projets != null) {
                for (ProjetModel projet : projets) {
        %>
        <div class="col-md-4">
            <div class="project-card">
                <h5><%= projet.getNom() %></h5>
                <p><strong>Description:</strong> <%= projet.getDescription() %></p>
                <p><strong>Date de début:</strong> <%= projet.getDateDebut() %></p>
                <p><strong>Date de fin:</strong> <%= projet.getDateFin() %></p>
            </div>
        </div>
        <%
                }
            }
        %>
    </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
