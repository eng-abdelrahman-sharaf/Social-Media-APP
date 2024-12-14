package com.MediaApp.ProfileManagement;


import com.MediaApp.ContentManagement.IMedium;
import com.MediaApp.DataHandlers.*;
import com.MediaApp.NewsFeed.NewsFeedApp;
import com.MediaApp.RelationsManagement.FriendRequestsManager;
import com.MediaApp.RelationsManagement.FriendsManager;
import com.MediaApp.RelationsManagement.IFriendRequestsManager;
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
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import resources.com.MediaApp.Group.GroupRequestService;
import resources.com.MediaApp.Group.GroupRequestServiceImpl;

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
    private Text email;

    @FXML
    private ScrollPane postspanel;

    @FXML
    private ScrollPane storiespanel;

    @FXML
    private Text username;

    private DataValidator dataValidator = new DataValidatorImpl();

    private void fillwithMediums(String [] IDs , IMediumDataBase db , ScrollPane panel){
//        String [] postsIDs = user.getPostsIDs().toArray(new String[0]);
        ArrayList<IMedium> mediums = new ArrayList<>();
        for(String ID : IDs) {
            mediums.add((IMedium) db.readObject(ID));
        }
        ContentContainerComponent mediumsContent = new ContentContainerComponent();
        mediumsContent.setContainerWidth(460);
        mediumsContent.setItems(mediums.toArray(new IMedium[0]));
        panel.setContent(mediumsContent);
    }



    private IUserInfo user;

    @FXML
    private VBox buttonsVBox;

    @FXML
    private Button goBackButton;


    @FXML
    private Button joinRequestButton;

    public void hideButtons (){
        buttonsVBox.getChildren().clear();
        buttonsVBox.getChildren().add(joinRequestButton);
        buttonsVBox.getChildren().add(goBackButton);
    }

    @FXML
    public void initialize() {
        IUserInfo autherized = AuthorizedUserGetter.getInstance().getUserInfo();
        if(user == null)user = autherized;
        if(user.getID().equals(autherized.getID())) hideButtons();
        if(user.getFriendsIDs().contains(autherized.getID())) joinRequestButton.setDisable(true);
        if(user.getFriendsREquest().contains(autherized.getID())) joinRequestButton.setDisable(true);
        try {
            cover.setImage(new Image(user.getCoverPhotoPath()));
        }catch (RuntimeException e){}
        try {
            avatar.setImage(new Image(user.getProfilePhotoPath()));
        }catch (RuntimeException e){}
        username.setText(user.getUserName());
        description.setText(user.getBio());
        email.setText(user.getEmail());
        fillwithMediums(user.getPostsIDs().toArray(new String[0]), PostDataBase.getInstance(null) , postspanel);
        fillwithMediums(user.getStoriesIDs().toArray(new String[0]), StoryDataBase.getInstance(null) , storiespanel);
    }

    @FXML
    void ChangeBio(ActionEvent event) {
        String newBio = JOptionPane.showInputDialog("Enter email address");
        if(!newBio.equals("")){
            user.setBio(newBio);
            UserRoleDataBase.getInstance(null).update(user.getID(), user);
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
            user.setCoverPhotoPath(imagePath);
            UserRoleDataBase.getInstance(null).update(user.getID(), user);
            initialize();
        }
    }

    @FXML
    void ChangeEmail(ActionEvent event) {
        String newemail = JOptionPane.showInputDialog("Enter email address");
        if(dataValidator.isValidEmail(newemail))user.setEmail(newemail);
        else JOptionPane.showMessageDialog(null, "Invalid email address");
        UserRoleDataBase.getInstance(null).update(user.getID(), user);
        initialize();
    }

    @FXML
    void ChangePassword(ActionEvent event) {
        String newPassword = JOptionPane.showInputDialog("Enter password");
        if(dataValidator.isStrongPassword(newPassword))user.setHashedPassword(Integer.toHexString(newPassword.hashCode()));
        else JOptionPane.showMessageDialog(null, "Password should contains at least 1 lowercase, 1 uppercase, 1 digit, and be least of 6 characters");
        UserRoleDataBase.getInstance(null).update(user.getID(), user);
        initialize();
    }

    @FXML
    void changeProfile(ActionEvent event) {
        String imagePath = ImageChooser.getImagePathFromUser();
        if (imagePath!=null) {
            user.setProfilePhotoPath(imagePath);
            UserRoleDataBase.getInstance(null).update(user.getID(), user);
            initialize();
        }
    }

    @FXML
    void changeUsername(ActionEvent event) {
        String newUname = JOptionPane.showInputDialog("Enter username");
        if(dataValidator.isValidName(newUname))user.setUserName(newUname);
        else JOptionPane.showMessageDialog(null, "username should contain only letters and underscores, and be at least 2 characters long.");
        UserRoleDataBase.getInstance(null).update(user.getID(), user);
        initialize();
    }

    public void setUser(IUserInfo user) {
        this.user = user;
        initialize();
    }

    @FXML
    void joinRequest(ActionEvent event) {
        IFriendRequestsManager fm = new FriendRequestsManager();
        fm.sendFriendRequest(AuthorizedUserGetter.getInstance().getUserInfo() , user);
        initialize();
    }


    public IUserInfo getUser() {
        return user;
    }
}
