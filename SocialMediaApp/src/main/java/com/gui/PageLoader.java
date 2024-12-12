package com.gui;

import com.gui.content_mangement_components.StageGetter;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

public class PageLoader {
    private String title;
    private URL fxmlFileLocation;
    private Stage stage;
    public PageLoader(String title , URL fxmlFileLocation , Stage stage) {
        this.title = title;
        this.fxmlFileLocation = fxmlFileLocation;
        this.stage = stage;
    }

    public void load() {
        StageGetter.getInstance().setStage(stage);
        FXMLLoader loader = new FXMLLoader(fxmlFileLocation);
        try {
            stage.setScene(new Scene(loader.load()));
        } catch (IOException e) {
            System.out.println("cannot load the page correctly");
        }
        stage.setTitle(title);
        stage.show();
    }


}
