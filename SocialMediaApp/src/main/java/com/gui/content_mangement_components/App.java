package com.gui.content_mangement_components;

import com.MediaApp.ContentManagement.Post;
import com.MediaApp.DataHandlers.JsonMapStorageHandler;
import com.MediaApp.DataHandlers.MapStorageHandler;
import com.MediaApp.DataHandlers.PostDataBase;
import com.MediaApp.DataHandlers.StoryDataBase;
import com.MediaApp.NewsFeed.MainController;
import com.MediaApp.UserAccountManagement.UserRoleDataBase;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

import com.MediaApp.ContentManagement.Story;
import com.MediaApp.UserAccountManagement.UserInfo;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
        scene = new Scene(loadFXML("/NewsFeedTemplate/NewsFeed"), 640, 480);
        stage.setScene(scene);
        stage.show();
    }

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        System.out.println(App.class.getResource(fxml+".fxml"));
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        launch();
    }

}