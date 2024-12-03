module com.example.socialmedia {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens com.MediaApp to javafx.fxml;
    exports com.MediaApp;
    exports com.MediaApp.ContentManagment;
    opens com.MediaApp.ContentManagment to javafx.fxml;
    exports com.MediaApp.NewsFeed;
    opens com.MediaApp.NewsFeed to javafx.fxml;

}