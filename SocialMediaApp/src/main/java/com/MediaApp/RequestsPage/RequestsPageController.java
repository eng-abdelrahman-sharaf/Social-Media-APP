package com.MediaApp.RequestsPage;

import com.MediaApp.SuggestedUsers.UserNodeController;
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

    public void setRequests(String userID) {
        UserNodeController userNodeController = new UserNodeController();
        UserRoleDataBase userDB = UserRoleDataBase.getInstance(null);
        IUserInfo User = userDB.readObject(userID);
        List<IUserInfo> users = new ArrayList<>();
        System.out.println(User.getFriendsREquest());

        for (String id : User.getFriendsREquest()) {
            users.add((IUserInfo) userDB.readObject(id));
            System.out.println("akjbdlas");
        }

        for (IUserInfo user : users) {
            Button userNodeButton = (Button) userNodeController.createUserNode(user);
            userNodeButton.setOnAction(event -> {
                     List<String> ls =   User.getFriendsIDs();
                     ls.add(user.getUserID());
                     User.setFriendsIDs(ls);
                    List<String> ls2 =   User.getFriendsREquest();
                     ls2.remove(user.getUserID());
                     User.setFriendsREquest(ls2);
                     userNodeButton.setVisible(false);
                     userDB.update(user.getID() , user);
                     userDB.update(User.getID() , User);
                RequestsPane.getChildren().remove(userNodeButton);

            });

            try{
                ImageView icon = new ImageView(new Image(Objects.requireNonNull(getClass().getResource(user.getProfilePhotoPath())).toExternalForm()));
                icon.setFitHeight(20);
                icon.setFitWidth(20);
                userNodeButton.setGraphic(icon);
            }catch (Exception e){}
            RequestsPane.getChildren().add(userNodeButton);
            System.out.println("akjbdlas");
        }
    }
}
