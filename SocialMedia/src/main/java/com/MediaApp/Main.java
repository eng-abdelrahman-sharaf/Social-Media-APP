// Ensure the resource paths are correct and check their existence in your project's resource folder.
// For example, assuming the FXML files are under `src/main/resources/com/MediaApp/template/`

package com.MediaApp;

import com.MediaApp.controllers.MainController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import java.io.IOException;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("/com/MediaApp/template/hello-view.fxml"));

        // Load the scene
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("ConnectHub!");
        stage.setScene(scene);

        // Set the stage icon
        Image icon = new Image(getClass().getResource("/com/Icons/Logo.png").toExternalForm());
        stage.getIcons().add(icon);
        stage.show();

        MainController mc = fxmlLoader.getController();

    }

    public static void main(String[] args) {
        launch();
    }
}

// The MainController class remains the same as you provided.