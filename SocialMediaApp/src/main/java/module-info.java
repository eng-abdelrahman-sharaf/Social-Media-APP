module com.example.socialmedia {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;

    exports com.MediaApp.ContentManagement to javafx.fxml, com.fasterxml.jackson.databind;
    opens com.MediaApp.ContentManagement;

    exports com.MediaApp.NewsFeed;
    opens com.MediaApp.NewsFeed to javafx.fxml;
    requires com.fasterxml.jackson.core;
    requires com.fasterxml.jackson.databind;
    requires java.base;
    exports com.MediaApp.ProfileManagement to javafx.fxml;
    opens com.MediaApp.ProfileManagement;
    exports com.MediaApp.SuggestedUsers;
    opens com.MediaApp.SuggestedUsers to javafx.fxml;

    exports com.MediaApp.UserAccountManagement to  com.fasterxml.jackson.databind;
    opens com.MediaApp.UserAccountManagement;
    exports com.gui.content_mangement_components to javafx.fxml;
    opens com.gui.content_mangement_components;
    exports com.MediaApp.UserAccountManagement.tests to com.fasterxml.jackson.databind;
    opens com.MediaApp.UserAccountManagement.tests;
    exports com.MediaApp.LoginPage;
    opens com.MediaApp.LoginPage to javafx.fxml;
    opens com.MediaApp.RequestsPage to javafx.fxml;
    exports com.MediaApp.RequestsPage;

}