package Model;

public class TacheModel {
    private int id;
    private String nom;
    private String statut;
    private String dateDebut;
    private String dateFin;
    private int projetId;

    public TacheModel(int id, String nom, String statut, String dateDebut, String dateFin, int projetId) {
        this.id = id;
        this.nom = nom;
        this.statut = statut;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.projetId = projetId;
    }

    public TacheModel(String nom, String statut, String dateDebut, String dateFin, int projetId) {
        this.nom = nom;
        this.statut = statut;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.projetId = projetId;
    }

    public TacheModel() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getStatut() {
        return statut;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }

    public String getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(String dateDebut) {
        this.dateDebut = dateDebut;
    }

    public String getDateFin() {
        return dateFin;
    }

    public void setDateFin(String dateFin) {
        this.dateFin = dateFin;
    }

    public int getProjetId() {
        return projetId;
    }

    public void setProjetId(int projetId) {
        this.projetId = projetId;
    }
}
