package controller;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import model.Client;
import model.DatabaseConnection;

import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;
import java.util.ResourceBundle;

public class ControllerClient implements Initializable {
    @FXML
    private TableColumn<Client, String> Colonne_Adresse;

    @FXML
    private TableColumn<Client, Integer> Colonne_Age;

    @FXML
    private TableColumn<Client, String> Colonne_CIN;

    @FXML
    private TableColumn<Client, String> Colonne_Prenom;

    @FXML
    private TableColumn<Client, Integer> Colonne_idClient;

    @FXML
    private TableColumn<Client, String> Colonne_nom;

    @FXML
    private Button button_AjouterClient;

    @FXML
    private Button button_ChercherClient;

    @FXML
    private TableView<Client> tableview;
    @FXML
    private TextField Adresse_field;

    @FXML
    private TextField Age_field;

    @FXML
    private TextField CIN_field;

    @FXML
    private TextField id_field;

    @FXML
    private TextField nom_field;

    @FXML
    private TextField prenom_field;
    @FXML
    private Button button_ModifierClient;
    @FXML
    private Button button_SupprimerClient;
    @FXML
    private ImageView imageclient;


    ObservableList<Client> list= FXCollections.observableArrayList();
    DatabaseConnection obj =new DatabaseConnection();
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        //imageclient.setImage(new Image("Pictures/client.png"));

        Colonne_idClient.setCellValueFactory(new PropertyValueFactory<Client,Integer>("id_client"));
        Colonne_nom.setCellValueFactory(new PropertyValueFactory<Client,String>("Nom"));
        Colonne_Prenom.setCellValueFactory(new PropertyValueFactory<Client,String>("Prenom"));
        Colonne_CIN.setCellValueFactory(new PropertyValueFactory<Client,String>("CIN"));
        Colonne_Adresse.setCellValueFactory(new PropertyValueFactory<Client,String>("Adresse"));
        Colonne_Age.setCellValueFactory(new PropertyValueFactory<Client,Integer>("Age"));

        //afficher les données a partir de la base de donnée

        String sql="select * from client";
        ResultSet res= obj.afficher(sql);

            try {
               while(res.next()){
                   list.add(new Client(res.getInt(1),res.getString(2),res.getString(3),res.getString(4),res.getString(5), res.getInt(6) ));
               }
            } catch (SQLException e) {
                e.printStackTrace();
            }

        tableview.setItems(list);
        }


    //Vérifier qu une chaine de caractere est un nombre

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
    void AjouterClient(ActionEvent event) {
        String id= id_field.getText();
        String nom = nom_field.getText();
        String prenom = prenom_field.getText();
        String CIN = CIN_field.getText();
        String  adresse= Adresse_field.getText();
        String age = Age_field.getText();

        //Vérification des champs

        //Champs vide
       if( id.equals("") ||  nom.equals("") || prenom.equals("")|| CIN.equals("")|| adresse.equals("")|| age.equals("")) {
           Alert a1 = new Alert(Alert.AlertType.ERROR, "Champ vide", ButtonType.OK);
           a1.show();
       }
       //Vérification que les id et l age sont des entiers
       if(est_entier(id)==false || est_entier(age)==false) {
           Alert a1 = new Alert(Alert.AlertType.ERROR, "Veillez saisir un entier", ButtonType.OK);
           a1.show();

       }
        else{

            //Ajout dans la table de l interface
            list.add(new Client(Integer.parseInt(id), nom, prenom, CIN, adresse, Integer.parseInt(age) ) );
            tableview.setItems(list);

           //ajout dans la base de donnée
           String s="insert into client values("+Integer.parseInt(id)+",'"+nom+"','"+prenom+"','"+CIN+"','"+adresse+"',"+Integer.parseInt(age)+")" ;
           obj.gereMAJ(s);


            id_field.setText("");
            nom_field.setText("");
            prenom_field.setText("");
            Adresse_field.setText("");
            CIN_field.setText("");
            Age_field.setText("");
        }

    }

    @FXML
    void SupprimerClient(ActionEvent event) {
        Alert a1 = new Alert(Alert.AlertType.CONFIRMATION, "Confirmer la suppresion de cet enregistrement", ButtonType.OK,ButtonType.NO);
        //a1.show();
        Optional<ButtonType> resultat= a1.showAndWait();
        if(resultat.get()==ButtonType.OK) {
            int selectedID = tableview.getSelectionModel().getSelectedIndex();
            int id = list.get(selectedID).getId_client();

            //Suppression de la base de donnée

            String s = " delete from client where idClient=" + id;
            obj.gereMAJ(s);

            //Supression de la table de l interface
            list.remove(selectedID);
            tableview.setItems(list);
        }



    }

    public void ModifiererClient(ActionEvent actionEvent) {

        int selectedID = tableview.getSelectionModel().getSelectedIndex();
        int ancien_id=list.get(selectedID).getId_client();

        int id= Integer.parseInt(id_field.getText());
        String nom = nom_field.getText();
        String prenom = prenom_field.getText();
        String CIN = CIN_field.getText();
        String  adresse= Adresse_field.getText();
        int age = Integer.parseInt(Age_field.getText());

        Client f;
        f = new Client(id,nom,prenom,CIN,adresse,age);
        list.set(selectedID,f);

        //Modification dans la base de donnée
        String s="UPDATE Client SET idClient="+ id +", nom='"+nom+"',prenom='"+prenom +"', CIN='"+CIN+"',Adresse='"+adresse+"'" +"Age="+age+
                "WHERE  idClient="+ancien_id ;

        obj.gereMAJ(s);




    }
    @FXML
    void ChercherClient(ActionEvent event) {

        }


}
