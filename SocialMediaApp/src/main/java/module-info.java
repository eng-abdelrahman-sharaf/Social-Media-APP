module com.example.socialmedia {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;

    exports com.MediaApp.ContentManagement to javafx.fxml, com.fasterxml.jackson.databind;
    opens com.MediaApp.ContentManagement;

    exports com.MediaApp.GroupManagement to javafx.fxml;
    opens com.MediaApp.GroupManagement;

    exports com.MediaApp.NewsFeed;
    opens com.MediaApp.NewsFeed to javafx.fxml;
    requires com.fasterxml.jackson.core;
    requires com.fasterxml.jackson.databind;
    requires java.management;
    requires jdk.sctp;
    exports com.MediaApp.ProfileManagement to javafx.fxml;
    opens com.MediaApp.ProfileManagement;
    exports com.MediaApp.SuggestedUsers;
    opens com.MediaApp.SuggestedUsers to javafx.fxml;

    exports resources.com.MediaApp.Group to com.fasterxml.jackson.databind;
    opens resources.com.MediaApp.Group;
    exports com.MediaApp.UserAccountManagement to  com.fasterxml.jackson.databind;
    opens com.MediaApp.UserAccountManagement;
    exports com.gui.content_mangement_components to javafx.fxml;
    opens com.gui.content_mangement_components;
    exports com.MediaApp.UserAccountManagement.tests to com.fasterxml.jackson.databind;
    opens com.MediaApp.UserAccountManagement.tests;
    exports com.MediaApp.authentication;
    opens com.MediaApp.authentication to javafx.fxml;
    opens com.MediaApp.RequestsPage to javafx.fxml;
    exports com.MediaApp.RequestsPage;
    exports com.gui to javafx.fxml;
    opens com.gui;

}