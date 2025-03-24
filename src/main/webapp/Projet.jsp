<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Ajouter un Projet</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        @import url('https://fonts.googleapis.com/css2?family=Playfair+Display:wght@700&family=Roboto:wght@400;700&display=swap');
        body {
            font-family: 'Roboto', sans-serif;
            background: url('https://i.pinimg.com/736x/7a/1c/c4/7a1cc44e8356752747500a5271cd4325.jpg') no-repeat center center fixed;
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
            text-align: center;
        }
        .form-wrapper {
            display: flex;
            justify-content: center;
            align-items: center;
            height: calc(100vh - 60px);
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
                    <a class="btn btn-outline-dark me-2" href="#">ACCUEIL</a>
                </li>
                <li class="nav-item">
                    <a class="btn btn-outline-dark me-2" href="#">INSCRIRE</a>
                </li>
                <li class="nav-item">
                    <a class="btn btn-outline-dark" href="#">CONNEXION</a>
                </li>
            </ul>
        </div>
    </div>
</nav>

<!-- Formulaire -->
<div class="form-wrapper">
    <div class="form-container">
        <h3 class="mb-4 fw-bold">Ajouter un Projet</h3>
        <form action="gestionProjet" method="post">
            <div class="mb-3">
                <input type="text" class="form-control" name="nom" placeholder="Nom de Projet" required>
            </div>
            <div class="mb-3">
                <input type="text" class="form-control" name="description" placeholder="Description" required>
            </div>
            <div class="mb-3">
                <input type="date" class="form-control" name="date_debut" required>
            </div>
            <div class="mb-3">
                <input type="date" class="form-control" name="date_fin" required>
            </div>
            <button type="submit" class="btn btn-primary">Ajouter</button>
        </form>
    </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>

