package controller;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ControllerAccueil  implements Initializable{

    @FXML
    private ImageView image_client;

    @FXML
    private ImageView image_facture;

    @FXML
    private ImageView image_forfait;
    @FXML
    private ImageView user;



    @Override
    public void initialize(URL url, ResourceBundle rb) {
        File brandingFile = new File("image/client.jpg");

        Image brandingImage = new Image(brandingFile.toURI().toString());
        image_client.setImage(brandingImage);

        File lockFile = new File("image/facture.png");
        Image lockImage = new Image(lockFile.toURI().toString());
        image_facture.setImage(lockImage);
        File lockFile4 = new File("image/forfait.jpg");
        Image lockImage4 = new Image(lockFile4.toURI().toString());
        image_forfait.setImage(lockImage4);
        //image_forfait.setImage(new Image("image/forfait.jpg"));
        //user.setImage(new Image("image/user1.jpg"));

    }

    @FXML
    void acceder_client(ActionEvent event) throws IOException {
        //Parent tableViewParent = FXMLLoader.load(getClass().getResource("/View/Client.fxml"));
        Parent tableViewParent = FXMLLoader.load(getClass().getResource("/View/Home.fxml"));
        Scene tableViewScene = new Scene(tableViewParent );

        //This line gets the Stage information
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(tableViewScene);
        window.show();


    }

    @FXML
    void acceder_facture(ActionEvent event) throws IOException {
        //Parent tableViewParent = FXMLLoader.load(getClass().getResource("/View/Facture.fxml"));
        Parent tableViewParent = FXMLLoader.load(getClass().getResource("/View/Home.fxml"));
        Scene tableViewScene = new Scene(tableViewParent);

        //This line gets the Stage information
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

        window.setScene(tableViewScene);
        window.show();


    }

    @FXML
    void acceder_forfait(ActionEvent event) throws IOException {
        //Parent tableViewParent = FXMLLoader.load(getClass().getResource("/View/Forfait.fxml"));
        Parent tableViewParent = FXMLLoader.load(getClass().getResource("/View/Home.fxml"));
        Scene tableViewScene = new Scene(tableViewParent);

        //This line gets the Stage information
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

        window.setScene(tableViewScene);
        window.show();

    }



}