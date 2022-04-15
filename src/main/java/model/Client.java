package model;

public class Client  {

    private  int id_client;
    private String nom;
    private String prenom;
    private  String CIN;
    private  String Adresse;
    private int Age ;


    //Constructeur
    public Client(int id_client,  String nom, String prenom, String CIN, String adresse, int age) {
        this.setId_client(id_client);
        this.setNom(nom);
        this.setPrenom(prenom);
        this.setCIN(CIN);
        this.setAdresse(adresse);
        this.setAge(age);

    }


    //Getters and Setters
    public int getId_client() {
        return id_client;
    }
    public void setId_client(int id_client) {
        this.id_client = id_client;
    }

    public String getNom() {
        return nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getCIN() {return CIN;}
    public void setCIN(String CIN) {
        this.CIN = CIN;
    }

    public String getAdresse() {
        return Adresse;}
    public void setAdresse(String adresse) {
        Adresse = adresse;
    }

    public int getAge() {
        return Age;
    }
    public void setAge(int age) {
        Age = age;
    }


}
