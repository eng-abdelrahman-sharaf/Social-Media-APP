package com.MediaApp.NewsFeed;

import com.MediaApp.UserAccountManagement.AuthorizedUserGetter;
import com.MediaApp.UserAccountManagement.IUserInfo;
import com.MediaApp.UserAccountManagement.UserInfoFactory;
import com.gui.content_mangement_components.StageGetter;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.util.ArrayList;

public class NewsFeedApp extends Application {

    public void run(){
        launch();
    }

    @Override
    public void start(Stage stage) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/NewsFeedTemplate/NewsFeed.fxml"));
            Scene scene = new Scene(loader.load());

            com.MediaApp.Main.dataLoading();

            MainController controller = loader.getController();
            UserInfoFactory userInfoFactory = new UserInfoFactory();
            controller.load(AuthorizedUserGetter.getInstance().getUserInfo());
            controller.start();
            // Set the scene and show the stage
            stage.setScene(scene);
            stage.setTitle("NewsFeed");
            stage.show();
            StageGetter.getInstance().setStage(stage);
            stage.setResizable(false);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
