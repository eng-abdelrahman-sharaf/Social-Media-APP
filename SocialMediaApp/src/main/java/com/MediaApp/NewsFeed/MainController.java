package com.MediaApp.NewsFeed;

import javafx.fxml.FXML;
import javafx.scene.layout.VBox;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.ImageView;
import javafx.scene.image.Image;

import java.util.Objects;

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

    public void initialize() {
        setButtonIcon(RefreshButton, "/Icons/refresh-button.png");
        setButtonIcon(LogoutButton, "/Icons/check-out.png");
        setButtonIcon(ProfileButton, "/Icons/user.png");
        setButtonIcon(ViewRequestsButton, "/Icons/add-friend.png");

        logo.setImage(new Image(Objects.requireNonNull(getClass().getResource("/Icons/Logo.png")).toExternalForm()));
        logo.setFitHeight(60);
        logo.setFitWidth(60);

        scrollPane.setFitToWidth(true);
        scrollPane.setFitToHeight(false);


    }

    private void setButtonIcon(Button button, String imagePath) {
        ImageView icon = new ImageView(new Image(Objects.requireNonNull(getClass().getResource(imagePath)).toExternalForm()));
        icon.setFitHeight(20);
        icon.setFitWidth(20);
        button.setGraphic(icon);
    }


//    public void addPost(Post post) {
//        try {
//            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/MediaApp/template/ImagePost.fxml"));
//            AnchorPane postNode = loader.load();
//
//            ImagePostController controller = loader.getController();
//            controller.setPost(post);
//            ContentPane.getChildren().add(postNode);
//        } catch (IOException e) {
//            System.err.println("Error loading the post: " + e.getMessage());
//        }
//    }
//
}
