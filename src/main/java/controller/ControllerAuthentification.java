package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import model.DatabaseConnection;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;


public class ControllerAuthentification implements Initializable {

    @FXML
    private TextField entrerPasswordField;

    @FXML
    private Button login;

    @FXML
    private TextField usernameTexField;
    @FXML
    private  Button cancelButton;

    @FXML
    private Label loginMessageLabel;
    @FXML
    private ImageView brandingImageView;
    @FXML
    private ImageView lockImageView;
    DatabaseConnection obj = new DatabaseConnection();
    @Override
    public  void initialize(URL url, ResourceBundle resourceBundle){
       File brandingFile = new File("image/nana.jpg");

        Image brandingImage = new Image(brandingFile.toURI().toString());
        brandingImageView.setImage(brandingImage);

        File lockFile = new File("image/imagesk.png");
        Image lockImage = new Image(lockFile.toURI().toString());
        lockImageView.setImage(lockImage);

    }

    public  void loginButtonOnAction(ActionEvent event) throws SQLException, IOException {

        if(usernameTexField.getText().isBlank() == false && entrerPasswordField.getText().isBlank() == false){
            validateLogin(event);
        }
        else{
            loginMessageLabel.setText("Entrer votre nom d'utilisateur et mot de passe");
        }

    }



    public void cancelButtonOnAction(ActionEvent event) {

        Stage stage = (Stage) cancelButton.getScene().getWindow();
        stage.close();
    }
    public void validateLogin(ActionEvent event){
        int i = 0;
        String verifyLogin = "SELECT * FROM user_account where username = '"+usernameTexField.getText()+"' and password ='"+entrerPasswordField.getText()+"'";

        ResultSet queryResult= obj.afficher(verifyLogin);
        try {
            while (queryResult.next()) {
                if (queryResult.getInt(1) == 1) {
                    createPage(event);
                    i = 1;
                }
            }
            if (i == 0)
                loginMessageLabel.setText("Invalide login. Please try again");
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
    void createPage(ActionEvent event){
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


}
