module com.example.socialmedia {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    exports com.MediaApp.ContentManagement to javafx.fxml;
    opens com.MediaApp.ContentManagement;

    exports com.MediaApp.NewsFeed;
    opens com.MediaApp.NewsFeed to javafx.fxml;
    requires com.fasterxml.jackson.core;
    requires com.fasterxml.jackson.databind;
    exports com.MediaApp.ProfileManagement to javafx.fxml;
    opens com.MediaApp.ProfileManagement;
    exports SuggestedUsers;
    opens SuggestedUsers to javafx.fxml;

    exports com.gui.content_mangement_components to javafx.fxml;
    opens com.gui.content_mangement_components;
}