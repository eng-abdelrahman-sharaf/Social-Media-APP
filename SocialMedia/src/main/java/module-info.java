module com.example.socialmedia {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens com.MediaApp to javafx.fxml;
    exports com.MediaApp;
    exports com.MediaApp.Model;
    opens com.MediaApp.Model to javafx.fxml;
    exports com.MediaApp.controllers;
    opens com.MediaApp.controllers to javafx.fxml;

}