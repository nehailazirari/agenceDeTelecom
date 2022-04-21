package Controller;

import Model.DatabaseConnection;
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


    @Override
    public  void initialize(URL url, ResourceBundle resourceBundle){
       brandingImageView.setImage(new Image("Pictures/img.png"));
        lockImageView.setImage(new Image("Pictures/img_1.png"));

        /*File brandingFile = new File("Pictures/img.png");

        Image brandingImage = new Image(brandingFile.toURI().toString());
        brandingImageView.setImage(brandingImage);

        File lockFile = new File("Pictures/img_1.png");
        Image lockImage = new Image(lockFile.toURI().toString());
        lockImageView.setImage(lockImage);*/

    }

    public  void loginButtonOnAction(ActionEvent event) throws SQLException, IOException {

        /*if(usernameTexField.getText().isBlank() == false && entrerPasswordField.getText().isBlank() == false){
            validateLogin();
        }
        else{
            loginMessageLabel.setText("Entrer votre nom d'utilisateur et mot de passe");
        }*/
        String verifyLogin = "SELECT * FROM gestiondaatabase.user_account where Nom_d_utilsateur= '"+usernameTexField.getText()+"' and mot_de_passe= '"+entrerPasswordField.getText()+"'";
        ResultSet queryResult= DatabaseConnection.Afficher(verifyLogin);

        if (queryResult.next()==false) {  //retrieve data
            loginMessageLabel.setText("Invalide login. Please try again");

        }
        else{
            Parent tableViewParent = FXMLLoader.load(getClass().getResource("/Layout/Accueil.fxml"));
            Scene tableViewScene = new Scene(tableViewParent );

            //This line gets the Stage information
            Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
            window.setScene(tableViewScene);
            window.show();

        }
    }



    public void cancelButtonOnAction(ActionEvent event) {

        Stage stage = (Stage) cancelButton.getScene().getWindow();
        stage.close();
    }
    /*public void login(){
        int i = 0;
        DatabaseConnection connectNew = new DatabaseConnection();
        Connection conncetDB = connectNew.getConnectionD();
        String verifyLogin = "SELECT id FROM gestiondatabase.user_account where Nom_d_utilisateur= '"+usernameTexField.getText()+"' and mot_de_passe '"+entrerPasswordField.getText()+"'";

        ResultSet queryResult= DatabaseConnection.Afficher(verifyLogin);
        try {
            while (queryResult.next()) {
                if (queryResult.getInt(1) == 1) {
                    //loginMessageLabel.setText("congratulations!");
                    createPage();
                    i = 1;
                }
            }
            if (i == 0)
                loginMessageLabel.setText("Invalide login. Please try again");
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }*/
    public void validateLogin() throws SQLException {
        String verifyLogin = "SELECT id FROM gestiondatabase.user_account where Nom_d_utilisateur= '"+usernameTexField.getText()+"' and mot_de_passe '"+entrerPasswordField.getText()+"'";
       ResultSet queryResult= DatabaseConnection.Afficher(verifyLogin);
        while (queryResult.next()) {  //retrieve data
            String data1 = queryResult.getString(1);

            System.out.println("id :  "+data1);

        }
    }


}
