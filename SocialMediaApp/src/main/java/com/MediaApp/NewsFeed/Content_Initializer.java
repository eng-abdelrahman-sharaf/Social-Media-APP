package com.MediaApp.NewsFeed;

import com.MediaApp.ContentManagement.Content;
import com.MediaApp.ContentManagement.Post;
import com.MediaApp.ContentManagement.Story;
import com.MediaApp.DataHandlers.PostDataBase;
import com.MediaApp.DataHandlers.StoryDataBase;
import com.MediaApp.UserAccountManagement.UserInfo;
import com.MediaApp.UserAccountManagement.UserRoleDataBase;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.stage.FileChooser;

import java.io.File;
import java.time.Instant;
import java.util.List;
import java.util.UUID;

public class Content_Initializer {

    @FXML
    private Button ImageChooser;

    @FXML
    private Button PostButton;

    @FXML
    private TextArea Caption;

    private UserInfo currentUser;
    private String selectedImage;

    private String type;
    public void settter(UserInfo user, String type) {
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
                Post newPost = new Post();
                newPost.setID(postId.toString());
                newPost.setAuthorID(currentUser.getID());
                newPost.setContent(content);
                newPost.setTimeStamp(String.valueOf(Instant.now()));
                List<String> ps = currentUser.getPostsIDs();
                ps.add(postId.toString());
                currentUser.setPostsIDs(ps);
                PostDataBase.getInstance(null).addObject(newPost);
                UserRoleDataBase.getInstance(null).update(currentUser.getID(),currentUser);
                System.out.println("post created");
            }
            else{
                Story newStory = new Story();
                newStory.setID(postId.toString());
                newStory.setAuthorID(currentUser.getID());
                newStory.setContent(content);
                newStory.setTimeStamp(String.valueOf(Instant.now()));
                System.out.println("Story created");
                List<String> ss = currentUser.getStoriesIDs();
                ss.add(postId.toString());
                currentUser.setStoriesIDs(ss);
                StoryDataBase.getInstance(null).addObject(newStory);
                UserRoleDataBase.getInstance(null).update(currentUser.getID(),currentUser);
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
