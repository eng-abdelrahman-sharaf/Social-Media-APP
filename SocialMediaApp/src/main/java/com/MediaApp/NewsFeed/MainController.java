package com.MediaApp.NewsFeed;

import com.MediaApp.ContentManagement.IPost;
import com.MediaApp.DataHandlers.PostDataBase;
import com.MediaApp.DataHandlers.StoryDataBase;
import com.MediaApp.ProfileManagement.ProfileApp;
import com.MediaApp.RequestsPage.RequestsPageController;
import com.MediaApp.SuggestedUsers.UserNodeController;
import com.MediaApp.UserAccountManagement.AuthorizedUserGetter;
import com.MediaApp.UserAccountManagement.IUserInfo;
import com.MediaApp.UserAccountManagement.UserInfo;
import com.MediaApp.UserAccountManagement.UserRoleDataBase;
import com.gui.content_mangement_components.ContentContainerComponent;
import com.gui.content_mangement_components.StageGetter;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.ImageView;
import javafx.scene.image.Image;
import javafx.scene.paint.Paint;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;
import java.util.List;

public class MainController {

    @FXML
    private ImageView logo;
    @FXML
    private ScrollPane postsPanel;

    @FXML
    private ScrollPane storiesPanel;

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
    private HBox SuggestedFriendsPane;
    @FXML
    private VBox FriendsStatusPane;
    @FXML
    private Button CreatePostButton;
    @FXML
    private Button CreateStoryButton;
    @FXML
    private HBox GroupsSuggestionsPane;

    @FXML
    private ScrollPane GroupsPostsPanel;

    @FXML
    private Button GoupPost;

    private IUserInfo Owner;
    private ContentContainerComponent postsContainer;
    private ContentContainerComponent storyContainer;
    private ContentContainerComponent GroupPostsContainer;
    public void initialize() {
        CreatePostButton.setOnAction(event -> CreatePost());
        CreateStoryButton.setOnAction(event -> CreateStory());
        ViewRequestsButton.setOnAction(event -> ViewRequest());// here
        GoupPost.setOnAction(event -> {
            CreateGroupPost();
        });
        postsContainer = new  ContentContainerComponent();
        GroupPostsContainer = new  ContentContainerComponent();
        GroupPostsContainer.setContainerWidth(700);
        postsContainer.setContainerWidth(230);
        storyContainer = new  ContentContainerComponent();
        storyContainer.setContainerWidth(230);
        storiesPanel.setContent(storyContainer);

    }

    private void CreateGroupPost() {
        openCreatePostPopup("group");
    }

    public void load(IUserInfo owner) {
        this.Owner = owner;

        // Set button icons
        setButtonIcon(RefreshButton, "/Icons/refresh-button.png");
        setButtonIcon(LogoutButton, "/Icons/check-out.png");
        setButtonIcon(ProfileButton, "/Icons/user.png");
        setButtonIcon(ViewRequestsButton, "/Icons/add-friend.png");
        setButtonIcon(CreatePostButton, "/Icons/more.png");
        setButtonIcon(CreateStoryButton, "/Icons/story.png");

        logo.setImage(new Image(Objects.requireNonNull(getClass().getResource("/Icons/Logo.png")).toExternalForm()));
        logo.setFitHeight(60);
        logo.setFitWidth(60);

        scrollPane.setFitToWidth(true);
        scrollPane.setFitToHeight(false);

        ArrayList<IUserInfo> friends = new ArrayList<>();
        for(String user: owner.getFriendsIDs()){
            friends.add(UserRoleDataBase.getInstance(null).readObject(user));
        }

        ArrayList<IPost> posts = new ArrayList<>();
        ArrayList<String> postsIDs  = new ArrayList<>();
        for(IUserInfo friend: friends){
            postsIDs.addAll(friend.getPostsIDs());
        }

        for(String postID: owner.getPostsIDs() ){
            posts.add(PostDataBase.getInstance(null).readObject(postID));
        }

        createSuggested(friends,GroupsSuggestionsPane,"friends");
        System.out.println(posts.size());
//        createSuggested(Suggestedusers,SuggestedFriendsPane,"group");
        createFriendStatus(friends);
        FillPostsPane(posts);
        FillGroupPostsPane(posts);
    }

    private void FillGroupPostsPane(List<IPost> posts) {
        GroupsPostsPanel.setContent(GroupPostsContainer);
        GroupPostsContainer.setItems(posts.toArray(new IPost[0]));
    }


    private void setButtonIcon(Button button, String imagePath) {
        ImageView icon = new ImageView(new Image(Objects.requireNonNull(getClass().getResource(imagePath)).toExternalForm()));
        icon.setFitHeight(20);
        icon.setFitWidth(20);
        button.setGraphic(icon);
    }

    // this method takes a list of IUserInfo objects as a parameter and adds them to the SuggestedFriendsPane
    public void createSuggested(List<IUserInfo> users, HBox pane, String type) {
        SuggestedFriendsPane.getChildren().clear();
        for (IUserInfo user : users) {
            if (user.getProfilePhotoPath() == null) {
                user.setProfilePhotoPath("/Icons/user.png");
            }
            UserNodeController controller = new UserNodeController();
            Button userButton = (Button) controller.createUserNode(user);
            if(type.equalsIgnoreCase("group")) {
                userButton.setOnAction(event -> {
                    List<String> ls = user.getFriendsIDs();
                    ls.add(user.getUserID());
                    user.setFriendsIDs(ls);
                    userButton.setVisible(false);
                    pane.getChildren().remove(userButton);
                });
            }
            else{
                //Implementation needed
                userButton.setOnAction(event -> {
                    System.out.println("implementaion missing");
                });
            }
            pane.getChildren().add(userButton);
        }
    }

    public void createFriendStatus(List<IUserInfo> users) {
        FriendsStatusPane.getChildren().clear();
        for (IUserInfo user : users) {
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

    @FXML
    private void ProfileButtonAction(ActionEvent event) throws IOException {
        ProfileApp app = new ProfileApp();

        Stage stage = StageGetter.getInstance().getStage();
//        Stage popupStage = new Stage();
//        popupStage.initModality(Modality.APPLICATION_MODAL);
//        popupStage.setTitle("Profile");

        app.start(StageGetter.getInstance().getStage());

    }

    @FXML
    private void ViewRequestButtonAction(ActionEvent event) {

    }


    @FXML
    private void RefreshButtonAction(ActionEvent event) {
        PostDataBase.getInstance(null).reload();
        UserRoleDataBase userdb = UserRoleDataBase.getInstance(null);
        userdb.reload();
        StoryDataBase.getInstance(null).reload();
        List<IUserInfo> users = new ArrayList<>();
        for(Object user : Arrays.stream(userdb.getData()).toArray()){
            users.add((IUserInfo) user);
        }
        System.out.println(users);

        ArrayList <IPost> posts = new ArrayList<>();
        for(Object post :PostDataBase.getInstance(null).getData()){
            posts.add((IPost) post);
        }

        load(this.Owner);
    }


    @FXML
    private void LogoutButtonAction(ActionEvent event) {
        IUserInfo user =  AuthorizedUserGetter.getInstance().getUserInfo();
        user.setStatus(null);
        UserRoleDataBase.getInstance(null).update(user.getID(), user);
        StageGetter.getInstance().getStage().close();
    }


    private void openCreatePostPopup(String type) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/NewsFeedTemplate/InitializePost.fxml"));
            Parent createPostRoot = loader.load();

            // Get the controller for the create post panel
            Content_Initializer createPostController = loader.getController();
            createPostController.settter(this.Owner,type);
            // Create a new stage for the popup
            Stage popupStage = new Stage();

            if (!type.equalsIgnoreCase("group"))
                popupStage.setHeight(153);
            popupStage.setResizable(false);

            popupStage.initModality(Modality.APPLICATION_MODAL);
            popupStage.setTitle("Create Content");

            Scene scene = new Scene(createPostRoot);
            popupStage.setScene(scene);
            popupStage.show();


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void FillPostsPane(List<IPost> posts) {
        postsPanel.setContent(postsContainer);
        postsContainer.setItems(posts.toArray(new IPost[0]));
    }


    public void start(){
        RefreshButtonAction(null);
    }


    public void CreatePost() {
        openCreatePostPopup("post");
    }

    public void CreateStory() {
        openCreatePostPopup("story");
    }

    public void ViewRequest() {
        Stage stage = new Stage();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/RequestsPage/RequestsPage.fxml"));

        try {
            Parent root = loader.load();
            RequestsPageController controller = loader.getController();

            controller.setRequests(this.Owner);
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }




}

