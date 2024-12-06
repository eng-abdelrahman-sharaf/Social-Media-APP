package com.MediaApp.NewsFeed;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class test extends Application {
    FXMLLoader loader = new FXMLLoader(getClass().getResource("/NewsFeedTemplate/NewsFeed.fxml"));

    @Override
    public void start(Stage stage){
        try {
            Scene scene = new Scene(loader.load());
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
