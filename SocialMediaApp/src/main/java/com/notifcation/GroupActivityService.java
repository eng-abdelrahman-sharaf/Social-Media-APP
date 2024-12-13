/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.notifcation;

import com.MediaApp.UserAccountManagement.IUserInfo;

/**
 *
 * @author abdah
 */
public class GroupActivityService {
    private INotificationService notificationService;

    public GroupActivityService(INotificationService notificationService) {
        this.notificationService = notificationService;
    }

//    public void addUserToGroup(IUserInfo user, Group group) {
//        // Logic to add user to group
//        INotification notification = new BasicNotification(user.getUserID(), 
//            "You were added to the group " + group.getName() + ".", "Group Activity");
//        notificationService.sendNotification(notification);
//    }
}

