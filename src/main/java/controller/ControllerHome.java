package controller;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ControllerHome implements Initializable {

    @FXML
    private Button closeButton;

    @FXML
    private AnchorPane root;
    Parent fxml;
    @FXML
    void accueil(MouseEvent event) {
        Parent system = null;
        try {
            system = FXMLLoader.load(getClass().getResource("/view/Accueil.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(new Scene( system,800, 500));
        stage.show();
    }
    @FXML
    void facture() {
        try {
            fxml = FXMLLoader.load(getClass().getResource("/view/Facture"));
       } catch (IOException e) {
            e.printStackTrace();
        }
        root.getChildren().removeAll();
        root.getChildren().setAll(fxml);

    }

    @FXML
    void forfait() {
        try {
            fxml = FXMLLoader.load(getClass().getResource("/view/Forfait.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        root.getChildren().removeAll();
        root.getChildren().setAll(fxml);
    }
    @FXML
    void client(MouseEvent event) {
        try {
            fxml = FXMLLoader.load(getClass().getResource("/view/Client.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        root.getChildren().removeAll();
        root.getChildren().setAll(fxml);

    }

    @FXML
    void closeButtonOnAction(ActionEvent event) {
        Stage stage = (Stage) closeButton.getScene().getWindow();
        stage.close();
        Platform.exit();

    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.forfait();
    }
}
