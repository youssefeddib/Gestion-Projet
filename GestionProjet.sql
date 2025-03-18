CREATE DATABASE GestionProjet;
USE GestionProjet;

CREATE TABLE Projet (
                        id INT AUTO_INCREMENT PRIMARY KEY,
                        nom VARCHAR(255) NOT NULL,
                        description TEXT,
                        date_debut DATE,
                        date_fin DATE
);

CREATE TABLE Tache (
                       id INT AUTO_INCREMENT PRIMARY KEY,
                       nom VARCHAR(255) NOT NULL,
                       statut ENUM('En attente', 'En cours', 'Terminée') DEFAULT 'En attente',
                       date_debut DATE,
                       date_fin date,
                       projet_id INT,
                       FOREIGN KEY (projet_id) REFERENCES projet(id) ON DELETE CASCADE
);

CREATE TABLE Ressource (
                           id INT AUTO_INCREMENT PRIMARY KEY,
                           nom VARCHAR(255) NOT NULL,
                           type VARCHAR(100) NOT NULL
);

insert into Projet (nom, description, date_debut, date_fin) values
                                                                ('ahmed', 'projet de maison', '2024-03-09', '2025-03-09'),
                                                                ('rachid', 'projet carte', '2023-03-09', '2025-03-09');

INSERT INTO Tache (nom, statut, date_debut, date_fin, projet_id) VALUES
                                                                     ('Préparer le terrain', 'En attente', '2025-03-05', '2025-03-10', 1),
                                                                     ('Construire les fondations', 'En attente', '2025-03-15', '2025-04-05', 1),
                                                                     ('Poser la charpente', 'En attente', '2025-04-10', '2025-05-15', 1),
                                                                     ('Installer l’électricité', 'En attente', '2025-06-01', '2025-07-01', 1),
                                                                     ('Peinture et finitions', 'En attente', '2025-08-01', '2025-09-10', 1),

                                                                     ('Démolition intérieure', 'En cours', '2025-04-20', '2025-04-25', 2),
                                                                     ('Refaire l’isolation', 'En attente', '2025-05-01', '2025-05-20', 2),
                                                                     ('Pose des cloisons', 'En attente', '2025-05-25', '2025-06-15', 2),
                                                                     ('Installation du mobilier', 'En attente', '2025-07-15', '2025-08-10', 2);


INSERT INTO Ressource (nom, type) VALUES
                                      ('Béton', 'Matériau'),
                                      ('Bois', 'Matériau'),
                                      ('Câbles électriques', 'Équipement'),
                                      ('Peinture blanche', 'Matériau'),
                                      ('Outils de maçonnerie', 'Outil'),
                                      ('Isolation thermique', 'Matériau');