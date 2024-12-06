package com.MediaApp.NewsFeed;

import SuggestedUsers.UserNodeController;
import com.MediaApp.UserAccountManagement.UserInfo;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.ImageView;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;

import java.awt.*;
import java.util.Objects;
import java.util.List;

public class MainController {

    @FXML
    private ImageView logo;

    @FXML
    private VBox ButtonsPane;

    @FXML
    private Button RefreshButton;

    @FXML
    private Button LogoutButton;

    @FXML
    private Button ProfileButton;

    @FXML
    private Button ViewRequestsButton;

    @FXML
    private ScrollPane scrollPane;

    @FXML
    private VBox ContentPane;

    @FXML
    private Button PostButton;

    @FXML
    private HBox SuggestedFriendsPane;

    @FXML
    private VBox FriendsStatusPane;

    public void load(List<UserInfo> Suggestedusers, List<UserInfo> Friends /* posts*/) {
        // Set button icons
        setButtonIcon(RefreshButton, "/Icons/refresh-button.png");
        setButtonIcon(LogoutButton, "/Icons/check-out.png");
        setButtonIcon(ProfileButton, "/Icons/user.png");
        setButtonIcon(ViewRequestsButton, "/Icons/add-friend.png");

        logo.setImage(new Image(Objects.requireNonNull(getClass().getResource("/Icons/Logo.png")).toExternalForm()));
        logo.setFitHeight(60);
        logo.setFitWidth(60);

        scrollPane.setFitToWidth(true);
        scrollPane.setFitToHeight(false);

        createSuggestedUsers(Suggestedusers);
        createFriendStatus(Friends);
    }

    private void setButtonIcon(Button button, String imagePath) {
        ImageView icon = new ImageView(new Image(Objects.requireNonNull(getClass().getResource(imagePath)).toExternalForm()));
        icon.setFitHeight(20);
        icon.setFitWidth(20);
        button.setGraphic(icon);
    }

    // this method takes a list of UserInfo objects as a parameter and adds them to the SuggestedFriendsPane
    public void createSuggestedUsers(List<UserInfo> users) {
        for (UserInfo user : users) {
            if (user.getProfilePhotoPath() == null) {
                user.setProfilePhotoPath("/Icons/user.png");
            }
            UserNodeController controller = new UserNodeController();
            SuggestedFriendsPane.getChildren().add(controller.createUserNode(user));
        }
    }

    public void createFriendStatus(List<UserInfo> users) {
        for (UserInfo user : users) {
            if (user.getProfilePhotoPath() == null) {
                user.setProfilePhotoPath("/Icons/user.png");
            }

            if (user.getStatus() != null ){
                UserNodeController controller = new UserNodeController();
                Node  node = controller.createUserNode(user);
                Button button = (Button) node;
                button.setTextFill(Paint.valueOf("Green"));
                FriendsStatusPane.getChildren().add(button);
            }
            else {
                UserNodeController controller = new UserNodeController();
                FriendsStatusPane.getChildren().add(controller.createUserNode(user));
            }

        }
    }
}
