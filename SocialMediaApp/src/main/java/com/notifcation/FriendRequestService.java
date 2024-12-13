/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.notifcation;

import com.MediaApp.UserAccountManagement.IUserInfo;

// FriendRequestService Class 
// This class handles the logic for sending friend request notifications. 
// It uses the NotificationService to create and send notifications.
public class FriendRequestService {
    private INotificationService notificationService;

    public FriendRequestService(INotificationService notificationService) {
        this.notificationService = notificationService;
    }

    public void sendFriendRequest(IUserInfo sender, IUserInfo receiver) {
        // Logic to send friend request
        INotification notification = new BasicNotification(receiver.getUserID(), 
            sender.getUserName() + " sent you a friend request.", "Friend Request");
        notificationService.sendNotification(notification);
    }
}
