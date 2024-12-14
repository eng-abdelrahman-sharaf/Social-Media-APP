package com.MediaApp.GroupManagement;


import com.MediaApp.ContentManagement.IGroupPost;
import com.MediaApp.ContentManagement.IMedium;
import com.MediaApp.DataHandlers.GroupPostDataBase;
import com.MediaApp.DataHandlers.IMediumDataBase;
import com.MediaApp.DataHandlers.PostDataBase;
import com.MediaApp.DataHandlers.StoryDataBase;
import com.MediaApp.NewsFeed.NewsFeedApp;
import com.MediaApp.SignPage.DataValidator;
import com.MediaApp.SignPage.DataValidatorImpl;
import com.MediaApp.UserAccountManagement.AuthorizedUserGetter;
import com.MediaApp.UserAccountManagement.IUserInfo;
import com.MediaApp.UserAccountManagement.UserRoleDataBase;
import com.MediaApp.utils.ImageChooser;
import com.gui.content_mangement_components.ContentContainerComponent;
import com.gui.content_mangement_components.StageGetter;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import resources.com.MediaApp.Group.GroupRepository;
import resources.com.MediaApp.Group.IGroup;

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
    private ImageView cover;

    @FXML
    private TextArea description;

    @FXML
    private Text adminName;

    @FXML
    private ScrollPane postspanel;


    @FXML
    private Text name;

    private DataValidator dataValidator = new DataValidatorImpl();

    private void fillwithMediums(IMedium[] mediums , ScrollPane panel){
        ContentContainerComponent mediumsContent = new ContentContainerComponent();
        mediumsContent.setContainerWidth(460);
        mediumsContent.setItems(mediums);
        panel.setContent(mediumsContent);
    }



    private IGroup group;

    @FXML
    private VBox buttonsVBox;

    @FXML
    private Button goBackButton;


    public void hideButtons (){
        buttonsVBox.getChildren().clear();
        buttonsVBox.getChildren().add(goBackButton);
    }

    @FXML
    public void initialize() {
        if(group == null)return;
        if(!group.getAdminIds().contains(AuthorizedUserGetter.getInstance().getUserInfo().getID())) hideButtons();
        try {
            cover.setImage(new Image(group.getGroupPhoto()));
        }catch (RuntimeException e){
            System.out.println("can't load cover");
        }
        name.setText(group.getName());
        description.setText(group.getDescription());
        adminName.setText(UserRoleDataBase.getInstance(null).readObject(group.getPrimaryAdminId()).getName());

        ArrayList<IGroupPost> posts = new ArrayList<>();

        for(String postID : group.getPosts()){
            posts.add(GroupPostDataBase.getInstance(null).readObject(postID));
        }

        fillwithMediums(posts.toArray(new IMedium[0]), postspanel);
    }

    @FXML
    void ChangeBio(ActionEvent event) {
        String newBio = JOptionPane.showInputDialog("Enter new Description");
        if(!newBio.equals("")){
            group.setDescription(newBio);
            GroupRepository.getInstance(null).update(group.getID(), group);
            initialize();
        }
    }

    @FXML
    void gotoNewsFeed(ActionEvent event) {
        NewsFeedApp app = new NewsFeedApp();
        app.start(StageGetter.getInstance().getStage());
    }

    @FXML
    void ChangeCover(ActionEvent event) {
        String imagePath = ImageChooser.getImagePathFromUser();
        if (imagePath!=null) {
            group.setGroupPhoto(imagePath);
            GroupRepository.getInstance(null).update(group.getID(), group);
            initialize();
        }
    }

    @FXML
    void changeUsername(ActionEvent event) {
        String newUname = JOptionPane.showInputDialog("Enter username");
        if(dataValidator.isValidName(newUname))group.setName(newUname);
        else JOptionPane.showMessageDialog(null, "group Name should contain only letters and underscores, and be at least 2 characters long.");
        GroupRepository.getInstance(null).update(group.getID(), group);
        initialize();
    }

    public void setGroup(IGroup group) {
        this.group = group;
        initialize();
    }

    public IGroup getGroup() {
        return group;
    }
}
