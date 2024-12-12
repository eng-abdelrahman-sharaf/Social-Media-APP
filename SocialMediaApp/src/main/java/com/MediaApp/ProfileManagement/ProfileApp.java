package com.MediaApp.ProfileManagement;


import com.MediaApp.UserAccountManagement.IUserInfo;
import com.gui.PageLoader;
import com.gui.content_mangement_components.StageGetter;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import static javafx.application.Application.launch;

/**
 * JavaFX App
 */
public class ProfileApp extends Application {

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