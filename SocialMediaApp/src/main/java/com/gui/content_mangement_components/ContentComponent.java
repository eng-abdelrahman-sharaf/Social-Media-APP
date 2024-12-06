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
import java.util.ArrayList;

public class ContentComponent extends VBox {
    private double containerWidth = 250;

    @FXML
    private ImageView avatar;

    @FXML
    private VBox container;

    private ArrayList<ImageView> images;

    private String[] links;

    @FXML
    private Text text;

    private IMedium Medium;

    public ContentComponent() {
        FXMLLoader loader = new FXMLLoader(ContentComponent.class.getResource("content.fxml"));
        loader.setRoot(this);
        loader.setController(this);
        this.images = new ArrayList<>();
        try {
            loader.load();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null,"content component load error");
        }
    }

    public void setMedium(IMedium medium) {
        this.Medium = medium;
        this.text.setText(medium.getContent().getText());

        // the link will be like /com/gui/content_mangement_components/cover.jpg
        this.links = medium.getContent().getAttachments();
        for(int i = 0 ;i <links.length ; i++){
            try{
                images.add(i, new ImageView());
                System.out.println(i);
                container.getChildren().add(images.get(i));
                images.get(i).setImage(new Image(links[i]));
                System.out.println("images loaded successfully");
            }catch (IllegalArgumentException e){
                images.get(i).setFitHeight(0);
                images.get(i).setFitWidth(0);
                images.get(i).setImage(null);
            }
            catch (IndexOutOfBoundsException e){
                System.out.println("index out of bounds");
            }
        }
        setContainerWidth(containerWidth);
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
        for(int i = 0 ; i < images.size() ; i++){

            try {
                double imageWidth = images.get(i).getImage().getWidth();
                double imageHeight = images.get(i).getImage().getHeight();
                double ratio = imageHeight / imageWidth;
                images.get(i).setFitWidth(innerWidth);
                images.get(i).setFitHeight(innerWidth);
                images.get(i).setFitHeight(innerWidth * ratio);
            }catch (NullPointerException e){

            }
        }
    }

    public double getContainerWidth() {
        return containerWidth;
    }
}
