package controller;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ControllerAccueil  implements Initializable{



    @FXML
    private ImageView accueil;

    @FXML
    private AnchorPane anchor;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //accueil.setImage(new Image("Pictures/accueill.jpg"));



    }


    @FXML
    void acceder_client(ActionEvent event) throws IOException {
        Parent tableViewParent = FXMLLoader.load(getClass().getResource("/view/Home.fxml"));
        Scene tableViewScene = new Scene(tableViewParent,800,500 );

        //This line gets the Stage information
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(tableViewScene);
        window.show();


    }

    @FXML
    void acceder_facture(ActionEvent event) throws IOException {
        Parent tableViewParent = FXMLLoader.load(getClass().getResource("/view/Home.fxml"));
        Scene tableViewScene = new Scene(tableViewParent,800,500);

        //This line gets the Stage information
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

        window.setScene(tableViewScene);
        window.show();


    }

    @FXML
    void acceder_forfait(ActionEvent event) throws IOException {
        Parent tableViewParent = FXMLLoader.load(getClass().getResource("/view/Home.fxml"));
        Scene tableViewScene = new Scene(tableViewParent,800,500);

        //This line gets the Stage information
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

        window.setScene(tableViewScene);
        window.show();

    }
    //Chargement des images

  /* @FXML
    public void initialize(){
       image_client.setImage(new Image("C:\\Users\\HP\\Documents\\EMI1\\Projet2\\photos\\client.png") );
       image_forfait.setImage(new Image("C:\\Users\\HP\\Documents\\EMI1\\Projet2\\photos\\telephone.png") );
       image_facture.setImage(new Image("C:\\Users\\HP\\Documents\\EMI1\\Projet2\\photos\\facturer.png") );
    }*/

}

