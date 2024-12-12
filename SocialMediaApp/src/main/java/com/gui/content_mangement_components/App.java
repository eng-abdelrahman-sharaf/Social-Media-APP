package com.gui.content_mangement_components;

import com.MediaApp.DataHandlers.JsonMapStorageHandler;
import com.MediaApp.DataHandlers.MapStorageHandler;
import com.MediaApp.DataHandlers.PostDataBase;
import com.MediaApp.DataHandlers.StoryDataBase;
import com.MediaApp.NewsFeed.MainController;
import com.MediaApp.UserAccountManagement.UserRoleDataBase;
import com.gui.PageLoader;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

import com.MediaApp.UserAccountManagement.IUserInfo;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
        PageLoader loader = new PageLoader("NewsFeed" , getClass().getResource("/NewsFeedTemplate/NewsFeed.fxml") , stage);
        loader.load();
    }

    public static void main(String[] args) {
        launch();
    }

}