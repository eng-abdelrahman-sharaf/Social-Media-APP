package com.MediaApp.SuggestedUsers;

import com.MediaApp.UserAccountManagement.UserInfo;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class UserNodeController {
    @FXML
    private Button suggestedUser;

    public void initialize(UserInfo user) {
        suggestedUser.setText(user.getUserName());
        ImageView icon = loadImage(user.getProfilePhotoPath());
        icon.setFitHeight(20);
        icon.setFitWidth(20);
        suggestedUser.setGraphic(icon);
    }

    private ImageView loadImage(String path) {
        try {
            Image image = new Image(getClass().getResource(path).toExternalForm());
            return new ImageView(image);
        } catch (NullPointerException e) {
            return new ImageView(); // Return an empty ImageView
        }
    }

    //this funciton is used to create a usernode from the fxml file and return it
    public Parent createUserNode(UserInfo user) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/UserNode/UserNode.fxml"));
            Parent node = loader.load();

            UserNodeController controller = loader.getController();
            controller.initialize(user);
            if (user.getProfilePhotoPath() == null) {
                user.setProfilePhotoPath("/Icons/user.png");
            }

            return node;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
