package com.MediaApp.NewsFeed;

import com.MediaApp.ContentManagement.IGroupPost;
import com.MediaApp.ContentManagement.IMedium;
import com.MediaApp.ContentManagement.IPost;
import com.MediaApp.ContentManagement.IStory;
import com.MediaApp.DataHandlers.GroupPostDataBase;
import com.MediaApp.DataHandlers.PostDataBase;
import com.MediaApp.DataHandlers.StoryDataBase;
import com.MediaApp.GroupManagement.GroupApp;
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
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.image.ImageView;
import javafx.scene.image.Image;
import javafx.scene.paint.Paint;
import javafx.stage.Modality;
import javafx.stage.Stage;
import resources.com.MediaApp.Group.GroupRepository;
import resources.com.MediaApp.Group.IGroup;

import javax.management.Notification;
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

    @FXML
    private Button SearchButton;

    @FXML
    private Button SearchButton2;

    @FXML
    private TextField UserQuery;

    @FXML
    private TextField groupQuery;

    @FXML
    private Button NotificationsButton;

    private IUserInfo Owner;
    private ContentContainerComponent postsContainer;
    private ContentContainerComponent storyContainer;
    private ContentContainerComponent GroupPostsContainer;
    private SearchEngine searchEngine;
    public void initialize() {
        CreatePostButton.setOnAction(event -> CreatePost());
        CreateStoryButton.setOnAction(event -> CreateStory());
        ViewRequestsButton.setOnAction(event -> ViewRequest());// here
//        ViewRequestsButton.setVisible(false);
        GoupPost.setOnAction(event -> {
            CreateGroupPost();
        });
        SearchButton.setOnAction(event -> UserSearchButtonAction());
        SearchButton2.setOnAction(event -> GroupSearchButtonAction());

        NotificationsButton.setOnAction(event -> DisplayNotifications());
        searchEngine = new SearchEngine();
        postsContainer = new  ContentContainerComponent();
        GroupPostsContainer = new  ContentContainerComponent();
        GroupPostsContainer.setContainerWidth(600);
        postsContainer.setContainerWidth(230);
        storyContainer = new  ContentContainerComponent();
        storyContainer.setContainerWidth(230);
        storiesPanel.setContent(storyContainer);

    }

    private void DisplayNotifications() {
        List<String> notifications = new ArrayList<>();
        notifications.add("Hatem OStora.");
        notifications.add("Hatem wow.");
        notifications.add("عضلات حاتم ضخمة");
        notifications.add("lksjdfpjkepo");

        Stage notificationsStage = new Stage();
        notificationsStage.setTitle("Notifications");

        VBox vbox = new VBox(10); // Layout for notifications
        vbox.setPadding(new javafx.geometry.Insets(10));

        for (String notification : notifications) {
            Button button = new Button(notification);
            button.setStyle("-fx-font-size: 14px; -fx-background-color: white; -fx-background-radius: 10;");

            button.setOnMousePressed(event -> {
                button.setStyle("-fx-font-size: 14px; -fx-background-color: white; -fx-background-radius: 10; -fx-effect: dropshadow(gaussian, black, 10, 0.2, 0, 0);");
            });

            button.setOnMouseReleased(event -> {
                button.setStyle("-fx-font-size: 14px; -fx-background-color: white; -fx-background-radius: 15;");
            });

            button.setOnAction(event -> {
                // Action when a notification button is clicked (e.g., show more details)
                System.out.println(notification + " clicked.");
            });

            vbox.getChildren().add(button);
        }

        ScrollPane scrollPane = new ScrollPane(vbox);
        scrollPane.setFitToWidth(true);
        scrollPane.setFitToHeight(true);

        Scene scene = new Scene(scrollPane, 300, 200);
        notificationsStage.setScene(scene);
        notificationsStage.initModality(Modality.APPLICATION_MODAL);
        notificationsStage.show();
    }






    private void GroupSearchButtonAction() {
        String targetName = groupQuery.getText();
        List<IGroup> groups = new ArrayList<>();
        for(IGroup group : GroupRepository.getInstance(null).getData()){
            if(group.getName().toLowerCase().contains(targetName.toLowerCase())){
                groups.add(group);
            }
        }

        for(IGroup group : groups){
            System.out.println(group.getName());
            System.out.println("target" + targetName);
        }

        Stage stage = new Stage();
        stage.setTitle("Search Results");

        ListView<IGroup> listView = new ListView<>();
        listView.getItems().addAll(groups);

        listView.setCellFactory(lv -> new ListCell<>() {
            @Override
            protected void updateItem(IGroup group, boolean empty) {
                super.updateItem(group, empty);
                setText((group == null || empty) ? null : group.getName());
            }
        });

        listView.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                // newValue is the button you press on it is of typre user info choose the action
                GroupApp groupApp = new GroupApp();
                groupApp.start(StageGetter.getInstance().getStage() , newValue);
//                profileApp.start(StageGetter.getInstance().getStage() , newValue);
            }
        });

        Scene scene = new Scene(listView, 400, 300);
        stage.setScene(scene);

        stage.show();
    }



    private void UserSearchButtonAction() {
        List<UserInfo> us = searchEngine.search(UserQuery.getText(), "users");

        Stage stage = new Stage();
        stage.setTitle("Search Results");

        ListView<UserInfo> listView = new ListView<>();
        listView.getItems().addAll(us);

        listView.setCellFactory(lv -> new ListCell<>() {
            @Override
            protected void updateItem(UserInfo user, boolean empty) {
                super.updateItem(user, empty);
                setText((user == null || empty) ? null : user.getName());
            }
        });

        listView.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                // newValue is the button you press on it is of typre user info choose the action
                ProfileApp profileApp = new ProfileApp();
                profileApp.start(StageGetter.getInstance().getStage() , newValue);
            }
        });

        Scene scene = new Scene(listView, 400, 300);
        stage.setScene(scene);

        stage.show();
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

        ArrayList<String> postsIDs = new ArrayList<>();
        ArrayList<String> storiesIDs = new ArrayList<>();

        ArrayList<IUserInfo> friends = new ArrayList<>();
        for(String user: owner.getFriendsIDs()){
            IUserInfo friend = UserRoleDataBase.getInstance(null).readObject(user);
            friends.add(friend);
            postsIDs.addAll(friend.getPostsIDs());
            storiesIDs.addAll(friend.getStoriesIDs());
        }


        ArrayList<IPost> posts = new ArrayList<>();

        for(String postID: postsIDs ){
            posts.add(PostDataBase.getInstance(null).readObject(postID));
        }

        ArrayList<IStory> stories = new ArrayList<>();

        for(String storyID: storiesIDs ){
            stories.add(StoryDataBase.getInstance(null).readObject(storyID));
        }

        ArrayList<IMedium> groupPosts = new ArrayList<>();
        for(String groupID: owner.getJoinedGroups()){
            System.out.println(groupID);
            try {
                IGroup group = GroupRepository.getInstance(null).readObject(groupID);
                for(String postID : group.getPosts()){
                    System.out.println("post id = " + postID);
                    IGroupPost grouppost = GroupPostDataBase.getInstance(null).readObject(postID);
                    if(grouppost != null)groupPosts.add(grouppost);
                    System.out.println( "posts====" + GroupPostDataBase.getInstance(null).getData());
                }
            }catch (NullPointerException e){
                e.printStackTrace();
            }
        }

//        createSuggested(Suggestedusers,SuggestedFriendsPane,"group");
        createFriendStatus(friends);
        FillPostsPane(posts);
        FillStoriesPane(stories);
        FillGroupPostsPane(groupPosts);
    }

    private void FillGroupPostsPane(List<IMedium> posts) {
        GroupsPostsPanel.setContent(GroupPostsContainer);
        System.out.println(posts);
        GroupPostsContainer.setItems(posts.toArray(new IMedium[0]));
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

    public void createSuggestedGroups(){

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
        GroupRepository.getInstance(null).reload();
        GroupPostDataBase.getInstance(null).reload();
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

        this.Owner = userdb.readObject(Owner.getID());
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

    public void FillStoriesPane(List<IStory> stories) {
        storiesPanel.setContent(storyContainer);
        storyContainer.setItems(stories.toArray(new IStory[0]));
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

            controller.setRequests(this.Owner.getUserID());
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
