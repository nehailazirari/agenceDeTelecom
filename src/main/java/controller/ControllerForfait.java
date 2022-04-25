package controller;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import model.DatabaseConnection;
import model.Forfait;

import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;
import java.util.ResourceBundle;

public class ControllerForfait implements Initializable {

    @FXML
    private Button btnADD;

    @FXML
    private Button btnDelete;

    @FXML
    private TextField btnID;

    @FXML
    private TextField btnNbGiga;

    @FXML
    private TextField btnNbHeures;

    @FXML
    private TextField btnNbSMS;

    @FXML
    private TextField btnPrix;

    @FXML
    private TextField btnRS;

    @FXML
    private Button btnUP;

    @FXML
    private TableColumn<Forfait, Integer> clnGiga;

    @FXML
    private TableColumn<Forfait, Integer> clnID;

    @FXML
    private TableColumn<Forfait, Integer> clnNbHeures;

    @FXML
    private TableColumn<Forfait, Float> clnPrix;

    @FXML
    private TableColumn<Forfait, String> clnRS;

    @FXML
    private TableColumn<Forfait,Integer> clnSMS;

    @FXML
    private TableView<Forfait> tableForfait;
    ObservableList<Forfait> list= FXCollections.observableArrayList();
    DatabaseConnection obj = new DatabaseConnection();
    int indexe;

    @FXML
    void ajouter(MouseEvent event) {
        String idText=  btnID.getText();
        String heuresText = btnNbHeures.getText();
        String prixText = btnPrix.getText();
        String smsText = btnNbSMS.getText();
        String gigaText = btnNbGiga.getText();
        String rsText = btnRS.getText();



        if( idText.equals("") ||  heuresText.equals("") || prixText.equals("")|| smsText.equals("")|| gigaText.equals("")) {
            Alert a1 = new Alert(Alert.AlertType.ERROR, "Champ vide", ButtonType.OK);
            a1.show();
        }

        else{
            tableForfait.getItems().clear();
            //Ajout dans la table de l interface
            //list.add(new Forfait(Integer.parseInt(idText), Float.parseFloat(prixText),Integer.parseInt(heuresText),Integer.parseInt(gigaText),Integer.parseInt(smsText),rsText) );
            //tableForfait.setItems(list);

            //ajout dans la base de donnée
            String s="insert into forfait values("+Integer.parseInt(idText)+","+Float.parseFloat(prixText)+","+Integer.parseInt(heuresText)+","+Integer.parseInt(gigaText)+","+Integer.parseInt(smsText)+",'"+rsText+"' )" ;
            obj.gereMAJ(s);


            btnID.setText("");
            btnNbGiga.setText("");
            btnNbSMS.setText("");
            btnRS.setText("");
            btnPrix.setText("");
            btnNbHeures.setText("");
            showForfait();
        }
    }

    @FXML
    void modifier(MouseEvent event) {
        String idText=  btnID.getText();
        String heuresText = btnNbHeures.getText();
        String prixText = btnPrix.getText();
        String smsText = btnNbSMS.getText();
        String gigaText = btnNbGiga.getText();
        String rsText = btnRS.getText();

        int selectedID = tableForfait.getSelectionModel().getSelectedIndex();
        int ancien_numero=list.get(selectedID).getIdForfait();

        if( idText.equals("") ||  heuresText.equals("") || prixText.equals("")|| smsText.equals("")|| gigaText.equals("")) {
            Alert a1 = new Alert(Alert.AlertType.ERROR, "Champ vide", ButtonType.OK);
            a1.show();
        }

        else{
            tableForfait.getItems().clear();
            //Ajout dans la table de l interface
            //list.add(new Forfait(Integer.parseInt(idText), Float.parseFloat(prixText),Integer.parseInt(heuresText),Integer.parseInt(gigaText),Integer.parseInt(smsText),rsText) );
            //tableForfait.setItems(list);

            //ajout dans la base de donnée
            String s="update  forfait set Idforfait = "+Integer.parseInt(idText)+", Prix ="+Float.parseFloat(prixText)+",NbHeures = "+Integer.parseInt(heuresText)+",` NbGega`= "+Integer.parseInt(gigaText)+",NbSMS = "+Integer.parseInt(smsText)+",Reseaux_sociaux = '"+rsText+"' WHERE  Idforfait="+ancien_numero;
            obj.gereMAJ(s);

            btnID.setText("");
            btnNbGiga.setText("");
            btnNbSMS.setText("");
            btnRS.setText("");
            btnPrix.setText("");
            btnNbHeures.setText("");
            showForfait();
        }
    }

    @FXML
    void supprimer(MouseEvent event) {
        Alert a1 = new Alert(Alert.AlertType.CONFIRMATION, "Confirmer la suppresion de cet enregistrement", ButtonType.OK, ButtonType.NO);
        //a1.show();
        Optional<ButtonType> resultat = a1.showAndWait();
        if (resultat.get() == ButtonType.OK) {
            int selectedID = tableForfait.getSelectionModel().getSelectedIndex();
            int id = list.get(selectedID).getIdForfait();

            //Suppression de la base de donnée

            String s = " delete from forfait where Idforfait=" + id;
            obj.gereMAJ(s);

            //Supression de la table de l interface
            tableForfait.getItems().clear();
            tableForfait.setItems(list);

            btnID.setText("");
            btnNbGiga.setText("");
            btnNbSMS.setText("");
            btnRS.setText("");
            btnPrix.setText("");
            btnNbHeures.setText("");
            showForfait();
        }
    }
    void showForfait(){
        clnID.setCellValueFactory(new PropertyValueFactory<Forfait, Integer>("idForfait"));
        clnPrix.setCellValueFactory(new PropertyValueFactory<Forfait, Float>("prix"));
        clnNbHeures.setCellValueFactory(new PropertyValueFactory<Forfait, Integer>("NbHeures"));
        clnGiga.setCellValueFactory(new PropertyValueFactory<Forfait, Integer>("NbGega"));
        clnSMS.setCellValueFactory(new PropertyValueFactory<Forfait, Integer>("NbSMS"));
        clnRS.setCellValueFactory(new PropertyValueFactory<Forfait, String>("reseaux_sociaux"));


        tableForfait.setItems(list);

        //afficher les données a partir de la base de donnée

        String sql = "select * from forfait";
        ResultSet res = obj.afficher(sql);

        try {
            while (res.next()) {
                list.add(new Forfait(res.getInt(1), res.getFloat(2), res.getInt(3), res.getInt(4), res.getInt(5),res.getString(6)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        tableForfait.setItems(list);

        //Afficher les elements d une ligne détéctée
        tableForfait.setRowFactory(tv -> {

            TableRow<Forfait> row = new TableRow<>();
            row.setOnMouseClicked(event -> {
                if (!row.isEmpty() && event.getButton() == MouseButton.PRIMARY) {

                    indexe = row.getIndex(); //on a l indice de la ligne selectionnée

                    //Récuperation des valeurs a partir de la ligne selectionnée

                    btnID.setText(String.valueOf(list.get(indexe).getIdForfait()));  //On remplit les champs a partir de la liste
                    btnPrix.setText(String.valueOf(list.get(indexe).getPrix()));
                    btnNbHeures.setText(String.valueOf(list.get(indexe).getNbHeures()));
                    btnNbGiga.setText(String.valueOf(list.get(indexe).getNbGega()));
                    btnNbSMS.setText(String.valueOf(list.get(indexe).getNbSMS()));
                    btnRS.setText(String.valueOf(list.get(indexe).getReseaux_sociaux()));

                }

            });
            return row;
        });
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        showForfait();
    }
}


