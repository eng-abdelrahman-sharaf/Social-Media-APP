package com.MediaApp.RequestsPage;

import com.MediaApp.RelationsManagement.FriendRequestsManager;
import com.MediaApp.SuggestedUsers.UserNodeController;
import com.MediaApp.UserAccountManagement.AuthorizedUserGetter;
import com.MediaApp.UserAccountManagement.IUserInfo;
import com.MediaApp.UserAccountManagement.UserRoleDataBase;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class RequestsPageController {
    @FXML
    private VBox RequestsPane;

    @FXML
    public void initialize() {
    }

    public void setRequests(IUserInfo owner) {
        UserNodeController userNodeController = new UserNodeController();
        UserRoleDataBase userDB = UserRoleDataBase.getInstance(null);
        List<IUserInfo> users = new ArrayList<>();
        for (String id : AuthorizedUserGetter.getInstance().getUserInfo().getFriendsREquest()) {
            users.add((IUserInfo) userDB.readObject(id));
            System.out.println(id);
        }
        RequestsPane.getChildren().clear();
        for (IUserInfo user : users) {
            Button userNodeButton = (Button) userNodeController.createUserNode(user);
            userNodeButton.setOnAction(event -> {

                        FriendRequestsManager friendRequestsManager = new FriendRequestsManager();
                        friendRequestsManager.acceptFriendRequest(user , AuthorizedUserGetter.getInstance().getUserInfo());
//                     List<String> ls =   owner.getFriendsIDs();
//                     ls.add(user.getUserID());
//                     owner.setFriendsIDs(ls);
//                    List<String> ls2 =   owner.getFriendsREquest();
//                     ls2.remove(user.getUserID());
//                     owner.setFriendsREquest(ls2);
                     userNodeButton.setVisible(false);
                RequestsPane.getChildren().remove(userNodeButton);

            });

            ImageView icon = new ImageView(new Image(Objects.requireNonNull(getClass().getResource(user.getProfilePhotoPath())).toExternalForm()));
            icon.setFitHeight(20);
            icon.setFitWidth(20);
            userNodeButton.setGraphic(icon);
            RequestsPane.getChildren().add(userNodeButton);
        }
    }
}
