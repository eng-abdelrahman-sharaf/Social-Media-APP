/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.notifcation;

import com.MediaApp.UserAccountManagement.IUserInfo;

// FriendRequestService Class 
// This class handles the logic for sending friend request notifications. 
// It uses the NotificationService to create and send notifications.and action factory.
public class FriendRequestService {
    private INotificationService notificationService;
    private INotificationActionFactory actionFactory;
    
    public FriendRequestService(INotificationService notificationService,INotificationActionFactory actionFactory ) {
        this.notificationService = notificationService;
        this.actionFactory= actionFactory;
    }

    public void sendFriendRequest(IUserInfo sender, IUserInfo receiver) {
        // Logic to send friend request
        INotification notification = new BasicNotification(receiver.getUserID(), 
            sender.getUserName() + " sent you a friend request.", "Friend Request");
        notificationService.sendNotification(notification);
    }
}
