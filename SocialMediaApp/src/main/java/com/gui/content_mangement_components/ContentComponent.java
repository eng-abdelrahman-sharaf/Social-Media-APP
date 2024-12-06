package com.gui.content_mangement_components;

import com.MediaApp.ContentManagement.IContent;
import com.MediaApp.ContentManagement.IMedium;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

import javax.swing.*;
import java.io.IOException;

public class ContentComponent extends VBox {
    private double containerWidth = 250;

    @FXML
    private ImageView avatar;

    @FXML
    private VBox container;

    @FXML
    private ImageView image;

    @FXML
    private Text text;

    private IMedium Medium;

    public ContentComponent() {
        FXMLLoader loader = new FXMLLoader(ContentComponent.class.getResource("content.fxml"));
        loader.setRoot(this);
        loader.setController(this);
        try {
            loader.load();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null,"content component load error");
        }
    }

    public void setMedium(IMedium medium) {
        this.Medium = medium;
        this.text.setText(medium.getContent().getText());

        try{
            this.image.setImage(new Image("/fka.gkp"));
        }catch (IllegalArgumentException e){
            this.image.setFitHeight(0);
            this.image.setFitWidth(0);
            this.image.setImage(null);
        }


    }

    public IMedium getMedium() {
        return Medium;
    }

    public void setContainerWidth(double containerWidth) {
        this.containerWidth = containerWidth;
        container.setPrefWidth(containerWidth);
        double padding = containerWidth*0.025;
        double innerWidth = containerWidth - 2 * padding;
        container.setPadding(new Insets(padding, padding, padding, padding));
        text.setWrappingWidth(innerWidth);
        avatar.setFitWidth(40);
        avatar.setFitHeight(40);
        try {
            double imageWidth = image.getImage().getWidth();
            double imageHeight = image.getImage().getHeight();
            double ratio = imageHeight / imageWidth;
            image.setFitWidth(innerWidth);
            image.setFitHeight(innerWidth * ratio);
        }catch (NullPointerException e){
            
        }
    }

    public double getContainerWidth() {
        return containerWidth;
    }
}
