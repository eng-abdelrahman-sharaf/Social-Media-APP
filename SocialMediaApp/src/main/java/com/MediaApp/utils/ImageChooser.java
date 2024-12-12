package com.MediaApp.utils;

import javafx.stage.FileChooser;

import java.io.File;

public class ImageChooser {
    public static String getImagePathFromUser(){
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().add(
                new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg", "*.jpeg", "*.gif")
        );

        File file = fileChooser.showOpenDialog(null);
        if(file == null) return null;
        return file.toURI().toString();
    }
}
