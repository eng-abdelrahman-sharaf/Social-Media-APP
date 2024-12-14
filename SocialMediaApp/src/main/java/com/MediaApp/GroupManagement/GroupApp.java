package com.MediaApp.GroupManagement;


import com.MediaApp.UserAccountManagement.IUserInfo;
import com.gui.PageLoader;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * JavaFX App
 */
public class GroupApp extends Application {

    private static Scene scene;

    @Override
    public void start(Stage stage)  {
        PageLoader loader = new PageLoader("Profile" , ProfileApp.class.getResource("profile.fxml") , stage);
        loader.load();
    }

    public void start(Stage stage , IUserInfo userInfo) {
        PageLoader loader = new PageLoader("Profile" , ProfileApp.class.getResource("profile.fxml") , stage);
        loader.load();
        Controller controller = loader.getFxmlLoader().getController();
        controller.setUser(userInfo);
    }

    public  void run() {
        launch();
    }

    public static void main(String[] args) {
        launch();
    }

}