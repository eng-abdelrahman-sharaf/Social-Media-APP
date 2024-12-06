package com.gui.content_mangement_components;

import com.MediaApp.DataHandlers.PostDataBase;
import com.MediaApp.DataHandlers.StoryDataBase;
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
        scene = new Scene(loadFXML("test"), 640, 480);
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
        // creating database
        String filePath = "post.json";
        // Create a storage handler for the HashMap
        MapStorageHandler<String, Post> postHandler = new JsonMapStorageHandler<>(String.class, Post.class, filePath);
        MapStorageHandler<String, Story> storyHandler = new JsonMapStorageHandler<>(String.class, Story.class, filePath);
        MapStorageHandler<String, userInfo> userHandler = new JsonMapStorageHandler<>(String.class, UserInfo.class, filePath);
        // Get the singleton instance of UserRoleDataBase
        PostDataBase postdb = PostDataBase.getInstance(storageHandler);
        StoryDataBase storydb = StoryDataBase.getInstance(storyHandler);

        launch();
    }

}