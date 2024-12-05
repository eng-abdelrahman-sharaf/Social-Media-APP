package com.MediaApp.ProfileManagement;


import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classe
s/Class.java to edit this template
 */

/**
 *
 * @author ADMIN
 */
public class Controller {
    
    @FXML
    private ImageView avatar;

    @FXML
    private ImageView cover;

    @FXML
    private TextArea description;

    @FXML
    public void initialize() {
//        Image img = new Image(Controller.class.getResource("avatar.jpg").toString());
        cover.setImage(new Image(Controller.class.getResource("avatar.jpg").toString()));
//        System.out.println(avatar);
        System.out.println(Controller.class.getResource("avatar.jpg").toString());
    }
    
}
