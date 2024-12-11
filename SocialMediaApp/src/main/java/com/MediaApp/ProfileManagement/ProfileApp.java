package com.MediaApp.ProfileManagement;


import com.gui.PageLoader;
import com.gui.content_mangement_components.StageGetter;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import static javafx.application.Application.launch;

/**
 * JavaFX App
 */
public class ProfileApp extends Application {

    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
        PageLoader loader = new PageLoader("Profile" , ProfileApp.class.getResource("profile.fxml") , stage);
        loader.load();
    }


    public static void main(String[] args) {
        launch();
    }

}