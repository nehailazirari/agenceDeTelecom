package Controller;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

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
        image_client.setImage(new Image("Pictures/client.jpg"));
        image_facture.setImage(new Image("Pictures/facture.png"));
        image_forfait.setImage(new Image("Pictures/forfait.jpg"));
        user.setImage(new Image("Pictures/user1.jpg"));

    }

    @FXML
    void acceder_client(ActionEvent event) throws IOException {
        //Parent tableViewParent = FXMLLoader.load(getClass().getResource("/View/Client.fxml"));
        Parent tableViewParent = FXMLLoader.load(getClass().getResource("/View/Menu.fxml"));
        Scene tableViewScene = new Scene(tableViewParent );

        //This line gets the Stage information
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(tableViewScene);
        window.show();


    }

    @FXML
    void acceder_facture(ActionEvent event) throws IOException {
        //Parent tableViewParent = FXMLLoader.load(getClass().getResource("/View/Facture.fxml"));
        Parent tableViewParent = FXMLLoader.load(getClass().getResource("/View/Menu.fxml"));
        Scene tableViewScene = new Scene(tableViewParent);

        //This line gets the Stage information
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

        window.setScene(tableViewScene);
        window.show();


    }

    @FXML
    void acceder_forfait(ActionEvent event) throws IOException {
        //Parent tableViewParent = FXMLLoader.load(getClass().getResource("/View/Forfait.fxml"));
        Parent tableViewParent = FXMLLoader.load(getClass().getResource("/View/Menu.fxml"));
        Scene tableViewScene = new Scene(tableViewParent);

        //This line gets the Stage information
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

        window.setScene(tableViewScene);
        window.show();

    }



}

