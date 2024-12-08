package com.MediaApp.ProfileManagement;


import com.MediaApp.ContentManagement.IMedium;
import com.MediaApp.ContentManagement.Post;
import com.MediaApp.DataHandlers.*;
import com.MediaApp.UserAccountManagement.AuthorizedUserGetter;
import com.MediaApp.UserAccountManagement.UserInfo;
import com.MediaApp.UserAccountManagement.UserRoleDataBase;
import com.gui.content_mangement_components.ContentContainerComponent;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import javax.swing.*;
import java.util.ArrayList;

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
    private ScrollPane postspanel;

    @FXML
    private ScrollPane storiespanel;

    private void fillwithMediums(String [] IDs , IMediumDataBase db , ScrollPane panel){
//        String [] postsIDs = user.getPostsIDs().toArray(new String[0]);
        ArrayList<IMedium> mediums = new ArrayList<>();
        for(String ID : IDs) {
            mediums.add((IMedium) db.readObject(ID));
        }
        ContentContainerComponent mediumsContent = new ContentContainerComponent();
        mediumsContent.setContainerWidth(380);
        mediumsContent.setItems(mediums.toArray(new IMedium[0]));
        panel.setContent(mediumsContent);
    }

    private UserInfo user;

    @FXML
    public void initialize() {
        user = AuthorizedUserGetter.getInstance().getUserInfo();
        fillwithMediums(user.getPostsIDs().toArray(new String[0]), PostDataBase.getInstance(null) , postspanel);
        fillwithMediums(user.getStoriesIDs().toArray(new String[0]), StoryDataBase.getInstance(null) , storiespanel);
    }
    
}
