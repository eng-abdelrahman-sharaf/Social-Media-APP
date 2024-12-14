package com.MediaApp.RequestsPage;

import com.MediaApp.SuggestedUsers.UserNodeController;
import com.MediaApp.UserAccountManagement.IUserInfo;
import com.MediaApp.UserAccountManagement.UserRoleDataBase;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import resources.com.MediaApp.Group.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class GroupRequestsController {
        @FXML
        private VBox RequestsPane;

        @FXML
        public void initialize() {
        }

        public void setRequests(String groupID) {
            IGroup group = GroupRepository.getInstance(null).readObject(groupID);
            UserNodeController userNodeController = new UserNodeController();
            UserRoleDataBase userDB = UserRoleDataBase.getInstance(null);
            List<IUserInfo> users = new ArrayList<>();

            for (String id : group.getRequestsUserIDs()) {
                users.add((IUserInfo) userDB.readObject(id));
            }

            RequestsPane.getChildren().clear();

            for (IUserInfo user : users) {
                Button userNodeButton = (Button) userNodeController.createUserNode(user);
                userNodeButton.setOnAction(event -> {
                    AdminService adminService = new AdminServiceImpl();
                    adminService.approveMembership(group.getGroupId() , user.getID());
                    userNodeButton.setVisible(false);
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
