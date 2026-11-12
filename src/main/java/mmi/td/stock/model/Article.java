package mmi.td.stock.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nom;
    private String categorie;
    private double prixUni;
    private int qte;

    public Article(String nom, String categorie, double prixUni, int qte) {
        this.nom = nom;
        this.categorie = categorie;
        this.prixUni = prixUni;
        this.qte = qte;
    }

    public Article() {
    }

    public Long getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    public double getPrixUni() {
        return prixUni;
    }

    public void setPrixUni(double prixUni) {
        this.prixUni = prixUni;
    }

    public int getQte() {
        return qte;
    }

    public void setQte(int qte) {
        this.qte = qte;
    }
}
