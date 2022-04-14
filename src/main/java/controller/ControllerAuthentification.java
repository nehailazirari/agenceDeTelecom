package controller;

import model.DatabaseConnection;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;


import java.io.File;
import  java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
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


    @Override
    public  void initialize(URL url, ResourceBundle resourceBundle){
        File brandingFile = new File("image/nana.jpg");
        Image brandingImage = new Image(brandingFile.toURI().toString());
        brandingImageView.setImage(brandingImage);

        File lockFile = new File("image/imagesk.png");
        Image lockImage = new Image(lockFile.toURI().toString());
        lockImageView.setImage(lockImage);

    }
    public  void loginButtonOnAction(ActionEvent event){

        if(usernameTexField.getText().isBlank() == false && entrerPasswordField.getText().isBlank() == false){
           validateLogin();
        }
        else{
            loginMessageLabel.setText("Please enter username and password");
        }
    }



     public void cancelButtonOnAction(ActionEvent event) {

        Stage stage = (Stage) cancelButton.getScene().getWindow();
        stage.close();
    }
    public void validateLogin(){
        DatabaseConnection connectNew = new DatabaseConnection();
        Connection conncetDB = connectNew.getConnectionD();
        String verifyLogin = "SELECT idcount FROM gestiondatabase.user_account where username= '"+usernameTexField.getText()+"' and password= '"+entrerPasswordField.getText()+"'";
        try {
            Statement statement =conncetDB.createStatement();
            ResultSet queryResult= statement.executeQuery(verifyLogin);
            while(queryResult.next()){
                if(queryResult.getInt(1)== 1){
                    loginMessageLabel.setText("congratulations!");
                }
                else{
                    loginMessageLabel.setText("Invalide login. Please try again");

                }
            }
        }
        catch (Exception e){
            e.printStackTrace();
            e.getCause();
        }
    }
}