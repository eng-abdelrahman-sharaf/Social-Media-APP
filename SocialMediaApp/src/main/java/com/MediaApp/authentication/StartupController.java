package com.MediaApp.authentication;
import com.gui.PageLoader;
import com.gui.content_mangement_components.StageGetter;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class StartupController extends Application {
    @FXML
    private ImageView Logo;

    @FXML
    private Button login;

    @FXML
    private Button signup;

    public void initialize() {
        Logo.setImage(new Image(StartupController.class.getResource("/Icons/logo.png").toString()));
    }


    @FXML
    void gotoLogin(ActionEvent event) {
        LoginController loginController = new LoginController();
        loginController.start(StageGetter.getInstance().getStage());
    }

    @FXML
    void gotoSignup(ActionEvent event) {
        SignupController signupController = new SignupController();
        signupController.start(StageGetter.getInstance().getStage());
    }

    @Override
    public void start(Stage stage){
        PageLoader pageLoader = new PageLoader("Connect Hub" , getClass().getResource("/LoginPage/Startup.fxml") , stage);
        pageLoader.load();
    }

    public void run(){
        launch();
    }
}

