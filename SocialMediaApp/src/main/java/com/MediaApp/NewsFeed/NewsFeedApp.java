package com.MediaApp.NewsFeed;

import com.MediaApp.UserAccountManagement.AuthorizedUserGetter;
import com.MediaApp.UserAccountManagement.IUserInfo;
import com.gui.content_mangement_components.StageGetter;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.ArrayList;

public class NewsFeedApp extends Application {

    @Override
    public void start(Stage stage) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/NewsFeedTemplate/NewsFeed.fxml"));
            Scene scene = new Scene(loader.load());

            com.MediaApp.Main.dataLoading();

            // Get the controller from the FXMLloader
            MainController controller = loader.getController();
            IUserInfo user = AuthorizedUserGetter.getInstance().getUserInfo();
            controller.load(user,new ArrayList<>(),new ArrayList<>(), new ArrayList<>());
            controller.start();
            // Set the scene and show the stage
            stage.setScene(scene);
            stage.setTitle("NewsFeed");
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
