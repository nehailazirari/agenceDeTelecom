module bredggsolution {
    requires javafx.controls;
    requires javafx.fxml;
    requires  java.sql;
    requires  javafx.graphics;


    exports model;
    exports controller;
    opens controller ;
    opens model;
}