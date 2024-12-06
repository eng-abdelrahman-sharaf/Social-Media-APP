package com.MediaApp.NewsFeed;

import com.MediaApp.UserAccountManagement.UserInfo;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.List;
import java.util.ArrayList;

public class test extends Application {

    @Override
    public void start(Stage stage) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/NewsFeedTemplate/NewsFeed.fxml"));
            Scene scene = new Scene(loader.load());

            // Get the controller from the FXMLloader
            MainController controller = loader.getController();
            UserInfo bora3y = new UserInfo("BORA3Y", "BOR3Y", "lakssd", "BORA3Y@example.com", "01/01/1990");
            bora3y.setStatus("Online");
            List<UserInfo> users = new ArrayList<>();
            users.add(bora3y);
            users.add(new UserInfo("meow", "samee7", "hjalkdsn", "Samee7@example.com", "15/02/1985"));
            users.add(new UserInfo("hasnaa", "hasnaa", "alicebrown123", "HASNAA@example.com", "20/03/1992"));

            // Pass the list of users to the controller's load method
            controller.load(users,users);
            // Set the scene and show the stage
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
