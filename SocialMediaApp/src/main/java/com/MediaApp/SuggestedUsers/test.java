package com.MediaApp.SuggestedUsers;

import com.MediaApp.UserAccountManagement.UserInfo;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class test extends Application {
    @Override
    public void start(Stage primaryStage) {
        try {
            VBox root = new VBox();
            root.setSpacing(10);

            UserInfo sampleUser = new UserInfo("adfad","asdas","asdfacsxd","asydg@djc.sudg","16/07/200");
            sampleUser.setProfilePhotoPath("/Icons/user.png");
            UserNodeController controller = new UserNodeController();
            root.getChildren().add(controller.createUserNode(sampleUser));

            Scene scene = new Scene(root, 400, 300);
            primaryStage.setTitle("User Node Test");
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
