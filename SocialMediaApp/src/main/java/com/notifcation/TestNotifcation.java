/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.notifcation;

import com.MediaApp.DataHandlers.JsonMapStorageHandler;
import com.MediaApp.DataHandlers.MapStorageHandler;
import com.MediaApp.UserAccountManagement.AuthorizedUserGetter;
import com.MediaApp.UserAccountManagement.IUserInfo;

public class TestNotifcation {

    public static void main(String[] args) {
        // Create an action factory instance
        INotificationActionFactory actionFactory = new NotificationActionFactory();

        // Create notifications
        INotification notification1 = new BasicNotification("user123", "You have a new friend request", "Friend Request", actionFactory);
        INotification notification2 = new BasicNotification("user456", "Your post received a new comment", "New Post", actionFactory);

        // Create a JsonMapStorageHandler for notifications
        MapStorageHandler<String, INotification> storageHandler = new JsonMapStorageHandler<>(
                String.class,
                BasicNotification.class,
                "notifications.json"
        );

        // Get the NotificationRoleDataBase instance
        NotificationRoleDataBase notificationDB = NotificationRoleDataBase.getInstance(storageHandler);

        // Add notifications to the database
        notificationDB.addObject(notification1);
        notificationDB.addObject(notification2);

        // Read and print notification messages from the database
        INotification retrievedNotification1 = notificationDB.readObject(notification1.getID());
        INotification retrievedNotification2 = notificationDB.readObject(notification2.getID());

        System.out.println("Retrieved Notification 1 Message: " + (retrievedNotification1 != null ? retrievedNotification1.getMessage() : "Not found"));
        System.out.println("Retrieved Notification 2 Message: " + (retrievedNotification2 != null ? retrievedNotification2.getMessage() : "Not found"));

        // Example usage of AuthorizedUserGetter
        IUserInfo authorizedUser = AuthorizedUserGetter.getInstance().getUserInfo();
        System.out.println("Authorized User: " + authorizedUser.getUserName());
    }
}

