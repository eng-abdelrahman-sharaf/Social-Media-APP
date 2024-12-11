package com.MediaApp.authentication;

import com.MediaApp.NewsFeed.NewsFeedApp;
import com.MediaApp.SignPage.DataValidator;
import com.MediaApp.SignPage.DataValidatorFactory;
import com.MediaApp.SignPage.SignUpServiceFactory;
import com.MediaApp.UserAccountManagement.*;
import com.gui.PageLoader;
import com.gui.content_mangement_components.StageGetter;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import javax.swing.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class SignupController extends Application {


    @FXML
    private ImageView Logo;

    @FXML
    private DatePicker dobField;

    @FXML
    private TextField emailField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private TextField usernameField;


    @FXML
    void gotoStartup(ActionEvent event) {
        StartupController startupController = new StartupController();
        startupController.start(StageGetter.getInstance().getStage());
    }

    @FXML
    void signUp(ActionEvent event) {
        SignUpServiceFactory signUpServiceFactory = new SignUpServiceFactory();
        UserFinderFactory userFinderFactory = new UserFinderFactory();
        DataValidatorFactory dataValidatorFactory = new DataValidatorFactory();

        String uname =  usernameField.getText();
        String pass = passwordField.getText();
        String dob ;
        try {
            dob = dobField.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        }catch (NullPointerException e){
            JOptionPane.showMessageDialog(null, "Please select a date");
            return;
        }
        System.out.println(dob);
        String email = emailField.getText();

        UserFinder userFinder = userFinderFactory.create(UserRoleDataBase.getInstance(null));
        DataValidator dataValidator = dataValidatorFactory.createObject();
        String result = signUpServiceFactory.createSignUpService(userFinder , dataValidator , UserRoleDataBase.getInstance(null)).signUp(uname ,email , dob , pass , pass);
        String message = result.split("," , 2 )[1];
        if(Boolean.parseBoolean(result.split(",")[0])){
            new NewsFeedApp().start(StageGetter.getInstance().getStage());
        }
        else {
            JOptionPane.showMessageDialog(null, message );
        }
    }



    @Override
    public void start(Stage stage) {
        PageLoader loader = new PageLoader("Login" , getClass().getResource("/LoginPage/SignupPage.fxml") , stage);
        loader.load();
    }

    @FXML
    public void initialize(){
        Logo.setImage(new Image(getClass().getResourceAsStream("/Icons/Logo.png")));
    }
}
