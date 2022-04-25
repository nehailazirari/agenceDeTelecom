package model;

public class Forfait {
    private int  idForfait, NbHeures, NbGega, NbSMS;
    private float prix;
    private String reseaux_sociaux;
    public  Forfait(int idForfait, float prix, int NbHeures, int NbGega,  int NbSMS, String reseaux_sociaux ){
        setIdForfait(idForfait);
        setNbHeures(NbHeures);
        setNbGega(NbGega);
        setNbSMS(NbSMS);
        setPrix(prix);
        setReseaux_sociaux(reseaux_sociaux);
    }
    public void setIdForfait(int idForfait){
        this.idForfait=idForfait;
    }
    public void setNbHeures(int NbHeures){
        this.NbHeures=NbHeures;
    }
    public  void setNbGega(int NbGega){
        this.NbGega = NbGega;
    }
    public void setNbSMS(int NbSMS){
        this.NbSMS = NbSMS;
    }
    public void setPrix(float prix){
        this.prix = prix;
    }
    public void setReseaux_sociaux(String reseaux_sociaux){
        this.reseaux_sociaux = reseaux_sociaux;
    }
    public int getIdForfait(){
        return idForfait;
    }
    public int getNbHeures(){
        return  NbHeures;
    }
    public int getNbGega(){
        return NbGega;
    }
    public  int getNbSMS(){
        return NbSMS;
    }
    public  float getPrix(){
        return prix;
    }
    public String getReseaux_sociaux(){
        return reseaux_sociaux;
    }


}
