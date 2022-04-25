package controller;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseButton;
import model.DatabaseConnection;
import model.Facture;

import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.Optional;
import java.util.ResourceBundle;

public class ControllerFacture implements Initializable {



    @FXML
    private TableColumn<Facture, Integer> Colonne_NumeroFacture;

    @FXML
    private TableColumn<Facture, Date> Colonne_dateDélivrance;

    @FXML
    private TableColumn<Facture, String> Colonne_etatPaiement;

    @FXML
    private TableColumn<Facture, Integer> Colonne_idClient;

    @FXML
    private TableColumn<Facture,Double > Colonne_montant;

    @FXML
    private Button button_AjouterFacture;

    @FXML
    private Button button_ChercherFacture;

    @FXML
    private Button button_ModifierFacture;

    @FXML
    private Button button_SupprimerFacture;

    @FXML
    private TextField delivrance_field;

    @FXML
    private TextField etatpaiementfield;


    @FXML
    private TextField id_field;

    @FXML
    private TextField montant_field;

    @FXML
    private TextField numero_field;

    @FXML
    private TableView<Facture> tableviewFacture;
    DatabaseConnection obj = new DatabaseConnection();

    //liste des lignes

    ObservableList<Facture> list= FXCollections.observableArrayList();
    int indexe;
    private TextField numero_field1;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        Colonne_NumeroFacture.setCellValueFactory(new PropertyValueFactory<Facture, Integer>("numero_Facture"));
        Colonne_idClient.setCellValueFactory(new PropertyValueFactory<Facture, Integer>("id_client"));
        Colonne_montant.setCellValueFactory(new PropertyValueFactory<Facture, Double>("montant"));
        Colonne_dateDélivrance.setCellValueFactory(new PropertyValueFactory<Facture, Date>("date_delivrance"));
        Colonne_etatPaiement.setCellValueFactory(new PropertyValueFactory<Facture, String>("etat_paiement"));


        tableviewFacture.setItems(list);

        //afficher les données a partir de la base de donnée

        String sql = "select * from gestiondaatabase.Facture";
        ResultSet res = obj.afficher(sql);

        try {
            while (res.next()) {
                list.add(new Facture(res.getInt(1), res.getInt(2), res.getDouble(3), res.getString(4), res.getString(5)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        tableviewFacture.setItems(list);

        //Afficher les elements d une ligne détéctée
        tableviewFacture.setRowFactory(tv -> {

        TableRow<Facture> row = new TableRow<>();
        row.setOnMouseClicked(event -> {
            if (!row.isEmpty() && event.getButton() == MouseButton.PRIMARY) {

                indexe = row.getIndex(); //on a l indice de la ligne selectionnée

                //Récuperation des valeurs a partir de la ligne selectionnée

                numero_field.setText(String.valueOf(list.get(indexe).getNumero_Facture()));  //On remplit les champs a partir de la liste
                id_field.setText(String.valueOf(list.get(indexe).getId_client()));
                montant_field.setText(String.valueOf(list.get(indexe).getMontant()));
                etatpaiementfield.setText(list.get(indexe).getEtat_paiement());
                delivrance_field.setText(list.get(indexe).getDate_delivrance());


            }

        });
            return row;
        });
    }



    public  boolean est_entier(String s){
        boolean numeric = true;
        try
        {
            int num = Integer.parseInt(s);
        } catch (NumberFormatException e)
        {
            numeric = false;
        }
        return numeric;
    }


    @FXML
    void AjouterFacture(ActionEvent event) {

        String Numero=  numero_field.getText();
        String idclient = id_field.getText();
        String montant = montant_field.getText();
        String etat_paiement = etatpaiementfield.getText();
        String date = delivrance_field.getText();


        //Vérification des champs

        //Champs vide
        if( Numero.equals("") ||  idclient.equals("") || montant.equals("")|| etat_paiement.equals("")|| date.equals("")) {
            Alert a1 = new Alert(Alert.AlertType.ERROR, "Champ vide", ButtonType.OK);
            a1.show();
        }
        //Vérification que les id et l age sont des entiers
        if(est_entier(Numero)==false || est_entier(idclient)==false) {
            Alert a1 = new Alert(Alert.AlertType.ERROR, "Veillez saisir un entier", ButtonType.OK);
            a1.show();

        }
        else{

            //Ajout dans la table de l interface
            list.add(new Facture(Integer.parseInt(Numero), Integer.parseInt(idclient),101,etat_paiement,date) );
            tableviewFacture.setItems(list);

            //ajout dans la base de donnée
            String s="insert into Facture values("+Integer.parseInt(Numero)+","+Integer.parseInt(idclient)+","+Float.parseFloat(montant)+",'"+etat_paiement+"','"+date+"' )" ;
            obj.gereMAJ(s);


            numero_field.setText("");
            id_field.setText("");
            montant_field.setText("");
            etatpaiementfield.setText("");
            delivrance_field.setText("");

        }

    }

    @FXML
    void ChercherFacture(ActionEvent event) {

    }

    @FXML
    void ModifiererFacture(ActionEvent event) {

        int selectedID = tableviewFacture.getSelectionModel().getSelectedIndex();
        int ancien_numero=list.get(selectedID).getNumero_Facture();


        int Numero= Integer.parseInt(numero_field.getText());
        int idclient = Integer.parseInt(id_field.getText());
        double montant = Double.parseDouble(montant_field.getText());
        String etat_paiement = etatpaiementfield.getText();
        String date = delivrance_field.getText();

        Facture f =new Facture(Numero,idclient,montant,etat_paiement,date);
        list.set(selectedID,f);

        //Modification dans la base de donnée
        String s="UPDATE facture SET Numero_Facture="+ Numero +", idClient="+idclient+",montant="+montant +", date_delivrance='"+date+"' , etat_de_paiement='"+etat_paiement+"'" +
                "WHERE  Numero_Facture="+ancien_numero ;

        obj.gereMAJ(s);




    }

    @FXML
    void SupprimerClientFacture(ActionEvent event) {
        Alert a1 = new Alert(Alert.AlertType.CONFIRMATION, "Confirmer la suppresion de cet enregistrement", ButtonType.OK,ButtonType.NO);
        //a1.show();
        Optional<ButtonType> resultat= a1.showAndWait();
        if(resultat.get()==ButtonType.OK) {
            int selectedID = tableviewFacture.getSelectionModel().getSelectedIndex();
            int id = list.get(selectedID).getId_client();

            //Suppression de la base de donnée

            String s = " delete from gestiondaatabase.facture where Numero_Facture=" + id;
            obj.gereMAJ(s);

            //Supression de la table de l interface
            list.remove(selectedID);
            tableviewFacture.setItems(list);

    }}

}
