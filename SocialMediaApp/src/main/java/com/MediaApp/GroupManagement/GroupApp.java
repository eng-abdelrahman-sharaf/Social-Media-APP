package com.MediaApp.GroupManagement;


import com.MediaApp.UserAccountManagement.IUserInfo;
import com.gui.PageLoader;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import resources.com.MediaApp.Group.IGroup;

/**
 * JavaFX App
 */
public class GroupApp extends Application {

    private static Scene scene;

    @Override
    public void start(Stage stage)  {
        PageLoader loader = new PageLoader("group" , GroupApp.class.getResource("group.fxml") , stage);
        loader.load();
    }

    public void start(Stage stage , IGroup Group) {
        PageLoader loader = new PageLoader("group" , GroupApp.class.getResource("group.fxml") , stage);
        loader.load();
        Controller controller = loader.getFxmlLoader().getController();
        controller.setGroup(Group);
    }

    public  void run() {
        launch();
    }

    public static void main(String[] args) {
        launch();
    }

}