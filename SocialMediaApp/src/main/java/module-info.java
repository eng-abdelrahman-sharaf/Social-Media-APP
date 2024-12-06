module com.example.socialmedia {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens com.MediaApp to javafx.fxml;
    exports com.MediaApp;
    exports com.MediaApp.ContentManagement;
    opens com.MediaApp.ContentManagement to javafx.fxml;
    exports com.MediaApp.NewsFeed;
    opens com.MediaApp.NewsFeed to javafx.fxml;
    requires com.fasterxml.jackson.core;
    requires com.fasterxml.jackson.databind;
    exports com.MediaApp.ProfileManagement to javafx.fxml;
    opens com.MediaApp.ProfileManagement;
    exports SuggestedUsers;
    opens SuggestedUsers to javafx.fxml;

}