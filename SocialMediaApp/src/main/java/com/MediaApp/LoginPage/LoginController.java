package com.MediaApp.LoginPage;

import com.MediaApp.DataHandlers.IDataObject;
import com.MediaApp.DataHandlers.JsonMapStorageHandler;
import com.MediaApp.DataHandlers.MapStorageHandler;
import com.MediaApp.NewsFeed.test;
import com.MediaApp.UserAccountManagement.UserInfo;
import com.MediaApp.UserAccountManagement.UserRoleDataBase;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.awt.*;

public class LoginController {
    @FXML
    ImageView Logo;

    @FXML
    javafx.scene.control.TextField usernameField;

    @FXML
    PasswordField passwordField;

    @FXML
    Button loginButton;

    @FXML
    public void initialize() {
        Logo.setImage(new Image(getClass().getResource("/Icons/Logo.png").toExternalForm()));
        loginButton.setOnAction(event -> handlelogin());
    }

    private void handlelogin() {
       String username = usernameField.getText();
       String password =  passwordField.getText();
       MapStorageHandler<String, UserInfo> userHandler = new JsonMapStorageHandler<>(String.class, UserInfo.class, "user.json");
       UserRoleDataBase.getInstance(userHandler);
        IDataObject[] userDB = UserRoleDataBase.getInstance(null).getData();
        for (IDataObject user : userDB) {
            if (username.equalsIgnoreCase(((UserInfo)user).getUserName())){
                if(password.equals(((UserInfo)user).getHashedPassword()))
                    System.out.println("login success");
            }
            else
                System.out.println("login failed");
        }


    }


}
