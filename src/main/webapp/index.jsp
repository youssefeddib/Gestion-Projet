<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>GestionProjet</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        /* Importer la police */
        @import url('https://fonts.googleapis.com/css2?family=Playfair+Display:wght@700&family=Roboto:wght@400;700&display=swap');

        /* Style général */
        body {
            font-family: 'Roboto', sans-serif;
            background: url('https://i.pinimg.com/736x/d0/73/4d/d0734dfa4be312afc59ea8b787ebcc25.jpg') no-repeat center center fixed;
            background-size: cover;
            height: 100vh;
            overflow: hidden;
        }

        /* Barre de navigation */
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

        .navbar-nav .nav-link {

            color: black !important;
            font-weight: bold;
        }

        /* Conteneur principal */
        .container-box {
            position: absolute;
            top: 50%;
            left: 10%;
            transform: translateY(-50%);
            background: white;
            padding: 40px;
            border-radius: 10px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.2);
            width: 400px;
            text-align: center;
        }

        .btn-primary {
            background-color: black;
            border: none;
            border-radius: 20px;
            font-weight: bold;
            padding: 10px;
        }

        .btn-primary:hover {
            background-color: gray;
        }

        /* Masquer toutes les sections sauf l'accueil */
        .section {
            display: none;
        }

        /* Afficher uniquement la section active */
        .section.active {
            display: block;
        }
    </style>
</head>
<body>

<!-- Barre de navigation -->
<nav class="navbar navbar-expand-lg navbar-light">
    <div class="container">
        <img style="width: 70px; height: 70px;" src="img.png">
        <a class="navbar-brand" href="#" onclick="showSection('home')">ConstructionXpert</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarNav">
            <ul class="navbar-nav ms-auto">
                <li class="nav-item"><a class="nav-link" href="#" onclick="showSection('home')">ACCUEIL</a></li>
                <li class="nav-item"><a class="nav-link" href="#" onclick="showSection('inscription')">INSCRIRE</a></li>
                <li class="nav-item"><a class="nav-link" href="#" onclick="showSection('connexion')">CONNEXION</a></li>
            </ul>
        </div>
    </div>
</nav>

<!-- Accueil -->
<div id="home" class="container-box section active">
    <h2>Bienvenue sur GestionProjet</h2>
    <p>Optimisez la gestion de vos projets facilement.</p>
    <button class="btn btn-primary" onclick="showSection('inscription')">Commencer</button>
</div>

<!-- Inscription -->
<div id="inscription" class="container-box section">
    <h2>INSCRIPTION</h2>
    <form action="InscriptionServlet" method="post">
        <div class="mb-3">
            <label for="nom" class="form-label">NOM</label>
            <input type="text" class="form-control" id="nom" name="nom" required>
        </div>
        <div class="mb-3">
            <label for="email" class="form-label">EMAIL</label>
            <input type="email" class="form-control" id="email" name="email" required>
        </div>
        <div class="mb-3">
            <label for="password" class="form-label">MOT DE PASSE</label>
            <input type="password" class="form-control" id="password" name="password" required>
        </div>
        <button type="submit" class="btn btn-primary w-100">S'inscrire</button>
    </form>
    <p class="mt-3">Déjà inscrit ? <a href="#" onclick="showSection('connexion')">Se connecter</a></p>
</div>

<!-- Connexion -->
<div id="connexion" class="container-box section">
    <h2>CONNEXION</h2>
    <form action="ConnexionServlet" method="post">
        <div class="mb-3">
            <label for="emailLogin" class="form-label">EMAIL</label>
            <input type="email" class="form-control" id="emailLogin" name="email" required>
        </div>
        <div class="mb-3">
            <label for="passwordLogin" class="form-label">MOT DE PASSE</label>
            <input type="password" class="form-control" id="passwordLogin" name="password" required>
        </div>
        <button type="submit" class="btn btn-primary w-100">Se connecter</button>
    </form>
    <p class="mt-3">Pas encore de compte ? <a href="#" onclick="showSection('inscription')">S'inscrire</a></p>
</div>

<script>
    function showSection(sectionId) {
        document.querySelectorAll('.section').forEach(section => {
            section.classList.remove('active');
        });
        document.getElementById(sectionId).classList.add('active');
    }
</script>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
