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

public class test extends Application {

    @Override
    public void start(Stage stage) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/NewsFeedTemplate/NewsFeed.fxml"));
            Scene scene = new Scene(loader.load());

            Main.dataLoading();

            // Get the controller from the FXMLloader
            MainController controller = loader.getController();
            UserInfo user = (UserInfo) UserRoleDataBase.getInstance(null).getData()[0];
            controller.load(user,new ArrayList<>(),new ArrayList<>(), new ArrayList<>());
            controller.start();
            // Set the scene and show the stage
            stage.setScene(scene);
            stage.show();
            StageGetter.getInstance().setStage(stage);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
