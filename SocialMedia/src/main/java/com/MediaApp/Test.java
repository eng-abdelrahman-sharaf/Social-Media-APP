//

package com.MediaApp;

import com.MediaApp.NewsFeed.MainController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import java.io.IOException;

public class Test extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Test.class.getResource("/com/MediaApp/template/NewsFeed.fxml"));

        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("ConnectHub!");
        stage.setScene(scene);

        Image icon = new Image(getClass().getResource("/com/Icons/Logo.png").toExternalForm());
        stage.getIcons().add(icon);
        stage.show();

        MainController mc = fxmlLoader.getController();

    }

    public static void main(String[] args) {
        launch();
    }
}

