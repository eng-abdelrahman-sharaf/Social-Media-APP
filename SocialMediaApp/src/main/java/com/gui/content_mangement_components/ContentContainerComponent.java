/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gui.content_mangement_components;

import com.MediaApp.ContentManagement.IMedium;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.VBox;

import javax.swing.*;
import java.io.IOException;

/**
 *
 * @author ADMIN
 */
public class ContentContainerComponent extends  VBox{

    private double containerWidth = 250;// default value of 250
    private IMedium mediums[] = {};//empty by default

   @FXML
   private VBox container;


    public ContentContainerComponent() {
        FXMLLoader loader = new FXMLLoader(ContentContainerComponent.class.getResource("contentContainer.fxml"));
        loader.setRoot(this);
        loader.setController(this);
        try {
            loader.load();
        } catch (IOException e) {
            System.out.println("content container component load error");
        }

        draw();

    }

    // draw elements [can be used to refresh the container]
    // used when updating attributes like width or items
    public void draw(){
        container.getChildren().clear();
        container.setPrefWidth(containerWidth);
        double height = 10;
        for(IMedium medium : mediums) {
            ContentComponent child = new ContentComponent();
            child.setContainerWidth(containerWidth);
            child.setMedium(medium);
            height+=child.getHeight()+30;
            container.getChildren().add(child);
        }
        setPrefHeight(height);
    }

    public void setItems(IMedium[] contents) {
        this.mediums = contents;
        draw();
    }

    public IMedium[] getMediums() {
        return mediums;
    }

    public void setContainerWidth(double containerWidth) {
        this.containerWidth = containerWidth;
        draw();
    }

    public double getContainerWidth() {
        return containerWidth;
    }
}
