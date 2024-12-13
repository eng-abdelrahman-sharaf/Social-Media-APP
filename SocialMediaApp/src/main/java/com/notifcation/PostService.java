/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.notifcation;

import com.MediaApp.ContentManagement.IPost;
import com.MediaApp.UserAccountManagement.IUserInfo;
import java.util.List;
import resources.com.MediaApp.Group.Group;

// PostService Class 
// This class handles the logic for new post notifications. 
// It uses the NotificationService to create and send notifications.

public class PostService {
    private INotificationService notificationService;

    private INotificationActionFactory actionFactory;
    
    public PostService(INotificationService notificationService, INotificationActionFactory actionFactory) {
        this.notificationService = notificationService;
        this.actionFactory = actionFactory;
    }

    public void newGroupPost(Group group, IPost post) {
        // Logic to create new post in group
        List<String> members = group.getMemberIds();
        for (String member : members) {
            INotification notification = new BasicNotification(member, 
                "New post in group " + group.getName() + ".", "New Post");
            notificationService.sendNotification(notification);
        }
    }
}
