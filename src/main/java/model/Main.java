package model;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        Parent system = FXMLLoader.load(getClass().getResource("/view/Authentification.fxml"));
        stage.initStyle(StageStyle.UNDECORATED);
        stage.setScene(new Scene( system,608, 417));
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}