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
    FXMLLoader fxmlLoader;

    public PageLoader(String title , URL fxmlFileLocation , Stage stage) {
        this.title = title;
        this.fxmlFileLocation = fxmlFileLocation;
        this.stage = stage;
    }

    public void load()  {
        StageGetter.getInstance().setStage(stage);
        fxmlLoader = new FXMLLoader(fxmlFileLocation);
        System.out.println("loading from " + fxmlFileLocation);
        try {
            stage.setScene(new Scene(fxmlLoader.load()));
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("cannot load the page correctly");
        }
        stage.setTitle(title);
        stage.show();
    }

    public void setFxmlLoader(FXMLLoader fxmlLoader) {
        this.fxmlLoader = fxmlLoader;
    }

    public FXMLLoader getFxmlLoader() {
        return fxmlLoader;
    }
}
