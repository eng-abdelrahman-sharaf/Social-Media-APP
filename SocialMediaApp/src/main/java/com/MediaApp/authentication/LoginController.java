package com.MediaApp.authentication;

import com.MediaApp.DataHandlers.IDataObject;
import com.MediaApp.DataHandlers.JsonMapStorageHandler;
import com.MediaApp.DataHandlers.MapStorageHandler;
import com.MediaApp.NewsFeed.NewsFeedApp;
import com.MediaApp.SignPage.LoginService;
import com.MediaApp.SignPage.LoginServiceFactory;
import com.MediaApp.UserAccountManagement.*;
import com.gui.PageLoader;
import com.gui.content_mangement_components.StageGetter;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginController extends Application {

    @FXML
    private ImageView Logo;

    @FXML
    private Button loginButton1;

    @FXML
    private PasswordField passwordField;

    @FXML
    private TextField usernameField;

    @FXML
    void Login(ActionEvent event) {
        String username = usernameField.getText();
        String password =  passwordField.getText();
        MapStorageHandler<String, IUserInfo> userHandler = new JsonMapStorageHandler<>(String.class, UserInfoClassType.type, "user.json");
        UserRoleDataBase.getInstance(userHandler);
        IDataObject[] userDB = UserRoleDataBase.getInstance(null).getData();
        LoginServiceFactory loginServiceFactory = new LoginServiceFactory();
        UserFinderFactory userFinderFactory = new UserFinderFactory();
        UserFinder userFinder = userFinderFactory.create(UserRoleDataBase.getInstance(null));
        LoginService  loginService = loginServiceFactory.create(userFinder);
        if(loginService.login(username, password)){
            System.out.println("Login Successful");
            new NewsFeedApp().start(StageGetter.getInstance().getStage());
        }
        else{
            System.out.println("Login Failed");
        }

    }

    @FXML
    void gotoStartup(ActionEvent event) {
        StartupController startupController = new StartupController();
        startupController.start(StageGetter.getInstance().getStage());
    }

    @FXML
    void passwordField(ActionEvent event) {

    }

    @FXML
    void unameField(ActionEvent event) {

    }

    @FXML
    public void initialize() {
        Logo.setImage(new Image(getClass().getResource("/Icons/Logo.png").toExternalForm()));
    }


    @Override
    public void start(Stage stage) {
        PageLoader loader = new PageLoader("Login" , getClass().getResource("/LoginPage/LoginPage.fxml") , stage);
        loader.load();
    }
}
