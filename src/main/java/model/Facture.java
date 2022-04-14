package model;

import java.util.Date;

public class Facture {
    private int numero_Facture ;
    private int numero_client;
    private double montant;
    private Date date_delivrance;
    private String Etat_paiement;

    // Constructeur
    public Facture(int numero_Facture, int numero_client, double montant, Date date_delivrance, String etat_paiement) {
        
        setNumero_Facture(numero_Facture);
        setNumero_client(numero_client);
        setMontant(montant);
        setDate_delivrance(date_delivrance);
        setEtat_paiement(etat_paiement);
       

    }

    // Getters and setters
    public  int getNumero_Facture() {
        return numero_Facture;
    }

    public  void setNumero_Facture(int numero_Facture) {
        this.numero_Facture = numero_Facture;
    }

    public int getNumero_client() {
        return numero_client;
    }

    public void setNumero_client(int numero_client) {
        this.numero_client = numero_client;
    }

    public double getMontant() {
        return montant;
    }

    public void setMontant(double montant) {
        this.montant = montant;
    }

    public Date getDate_delivrance() {
        return date_delivrance;
    }

    public void setDate_delivrance(Date date_delivrance) {
        this.date_delivrance = date_delivrance;
    }

    public String getEtat_paiement() {
        return Etat_paiement;
    }

    public void setEtat_paiement(String etat_paiement) {
        Etat_paiement = etat_paiement;
    }

}

