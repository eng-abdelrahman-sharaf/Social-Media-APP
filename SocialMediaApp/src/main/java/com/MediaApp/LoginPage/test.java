package com.MediaApp.NewsFeed;

import com.MediaApp.ContentManagement.Content;
import com.MediaApp.ContentManagement.IContent;
import com.MediaApp.ContentManagement.Post;
import com.MediaApp.Main;
import com.MediaApp.UserAccountManagement.UserInfo;
import com.MediaApp.UserAccountManagement.UserRoleDataBase;
import com.gui.content_mangement_components.StageGetter;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.time.Instant;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class test1 extends Application {

    @Override

    public void start(Stage stage) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/LoginPage/LoginPage.fxml"));
            Scene scene = new Scene(loader.load());



            MainController controller = loader.getController();;
            controller.start();
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
