<%@ page import="Model.TacheModel" %>
<%@ page import="java.util.List" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%
    TacheModel tache = (TacheModel) request.getAttribute("tache");
    int projetId = (int) request.getAttribute("projetId");

    if (tache == null) {
        response.sendError(HttpServletResponse.SC_NOT_FOUND, "Tâche introuvable");
        return;
    }
%>

<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Modifier Tâche</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
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
                    <a class="btn btn-outline-dark me-2" href="gestionTache?action=list&projetId=<%= projetId %>">Retour à la liste</a>
                </li>
            </ul>
        </div>
    </div>
</nav>

<!-- Formulaire de modification de la tâche -->
<div class="container mt-5">
    <h2 class="text-center">Modifier la Tâche</h2>
    <form action="gestionTache?action=edit&projetId=<%= projetId %>" method="post">
        <input type="hidden" name="modifier" value="<%= tache.getId() %>">
        <input type="hidden" name="projetId" value="<%= projetId %>">

        <div class="form-group">
            <label for="nom">Nom de la tâche:</label>
            <input type="text" class="form-control" id="nom" name="nom" value="<%= tache.getNom() %>" required>
        </div>

        <div class="form-group">
            <label for="statut">Statut:</label>
            <input type="text" class="form-control" id="statut" name="statut" value="<%= tache.getStatut() %>" required>
        </div>

        <div class="form-group">
            <label for="date_debut">Date de début:</label>
            <input type="date" class="form-control" id="date_debut" name="date_debut" value="<%= tache.getDateDebut() %>" required>
        </div>

        <div class="form-group">
            <label for="date_fin">Date de fin:</label>
            <input type="date" class="form-control" id="date_fin" name="date_fin" value="<%= tache.getDateFin() %>" required>
        </div>

        <button type="submit" class="btn btn-primary">Modifier</button>
    </form>

</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
