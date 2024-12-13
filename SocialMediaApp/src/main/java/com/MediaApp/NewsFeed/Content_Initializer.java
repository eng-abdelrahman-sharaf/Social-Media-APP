package com.MediaApp.NewsFeed;

import com.MediaApp.ContentManagement.*;
import com.MediaApp.DataHandlers.PostDataBase;
import com.MediaApp.DataHandlers.StoryDataBase;
import com.MediaApp.UserAccountManagement.IUserInfo;
import com.MediaApp.UserAccountManagement.UserRoleDataBase;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextArea;
import javafx.stage.FileChooser;

import java.io.File;
import java.time.Instant;
import java.util.List;
import java.util.UUID;

public class Content_Initializer {

    private PostFactory postFactory = new PostFactory();
    private StoryFactory storyFactory = new StoryFactory();

    @FXML
    private Button ImageChooser;

    @FXML
    private Button PostButton;

    @FXML
    private TextArea Caption;

    @FXML
    private ChoiceBox<String/*put group instead of String*/> GroupChoicePane;



    private IUserInfo currentUser;
    private String selectedImage;

    private String type;
    public void settter(IUserInfo user, String type) {
        this.currentUser = user;
        this.type = type;
    }

    @FXML
    public void initialize() {
        ImageChooser.setOnAction(event -> chooseImage());
        PostButton.setOnAction(event -> handlePost());
    }

    private void chooseImage() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().add(
                new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg", "*.jpeg", "*.gif")
        );

        File file = fileChooser.showOpenDialog(ImageChooser.getScene().getWindow());
        if (file != null) {
            selectedImage = file.toURI().toString();
            System.out.println("Image selected: " + file.getAbsolutePath());
        }
    }

    private void handlePost() {
        if (currentUser == null || type == null) {
            System.out.println("current USer" + currentUser);
            System.out.println("Information missing");
            return;
        }

        String caption = Caption.getText();
        if (!caption.isEmpty()) {
            Content content = new Content();
            content.setText(caption);
            content.setAttachments(new String[]{selectedImage});
            UUID postId = UUID.randomUUID();
            if(type.equalsIgnoreCase("post")) {
                IPost newPost = postFactory.createMedium(postId.toString() , currentUser.getID() , content , String.valueOf(Instant.now()));
                List<String> ps = currentUser.getPostsIDs();
                ps.add(postId.toString());
                currentUser.setPostsIDs(ps);
                PostDataBase.getInstance(null).addObject(newPost);
                UserRoleDataBase.getInstance(null).update(currentUser.getID(),currentUser);
                System.out.println("post created");
            }
            else if (type.equalsIgnoreCase("story")){
                IStory newStory = storyFactory.createMedium(postId.toString() , currentUser.getID() , content , String.valueOf(Instant.now()));
                System.out.println("Story created");
                List<String> ss = currentUser.getStoriesIDs();
                ss.add(postId.toString());
                currentUser.setStoriesIDs(ss);
                StoryDataBase.getInstance(null).addObject(newStory);
                UserRoleDataBase.getInstance(null).update(currentUser.getID(),currentUser);
            }
            else {
                // handle group post creation logic
                System.out.println("Group post creation is not implemented");
            }

            System.out.println("Post created with caption: " + caption);

            if (selectedImage != null) {
                content.setAttachments(new String[]{selectedImage});
            }
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("Caption is empty. Post not created.");
            alert.showAndWait();
        }

    }
}
