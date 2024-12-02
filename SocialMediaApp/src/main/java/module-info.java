module com.programming2.socialmediaapp {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.base;
    requires javafx.graphics;

    opens com.programming2.socialmediaapp to javafx.fxml;
    exports com.programming2.socialmediaapp;
}
