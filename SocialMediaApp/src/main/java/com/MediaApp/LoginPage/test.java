package com.MediaApp.LoginPage;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class test extends Application {

    @Override
    public void start(Stage stage) {
        try {
            int x = 5;
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/LoginPage/LoginPage.fxml"));
            System.out.println(loader);
            Scene scene = new Scene(loader.load());
            stage.setScene(scene);
            stage.show();
            stage.setResizable(false);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        System.out.println("asdf");
        launch(args);
    }
}
