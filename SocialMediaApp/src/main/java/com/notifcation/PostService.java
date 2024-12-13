/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.notifcation;

import com.MediaApp.ContentManagement.IPost;
import com.MediaApp.UserAccountManagement.IUserInfo;
import java.util.List;

/**
 *
 * @author abdah
 */
public class PostService {
    private INotificationService notificationService;

    public PostService(INotificationService notificationService) {
        this.notificationService = notificationService;
    }

//    public void newGroupPost(Group group, IPost post) {
//        // Logic to create new post in group
//        List<IUserInfo> members = group.getMembers();
//        for (IUserInfo member : members) {
//            INotification notification = new BasicNotification(member.getUserID(), 
//                "New post in group " + group.getName() + ".", "New Post");
//            notificationService.sendNotification(notification);
//        }
//    }
}
