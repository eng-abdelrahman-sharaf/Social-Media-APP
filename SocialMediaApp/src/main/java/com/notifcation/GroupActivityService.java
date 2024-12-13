
package com.notifcation;

import com.MediaApp.UserAccountManagement.IUserInfo;
import resources.com.MediaApp.Group.Group;

// GroupActivityService Class 
// This class handles the logic for group activity notifications.
// It uses the NotificationService to create and send notifications.
public class GroupActivityService {
    private INotificationService notificationService;
    private INotificationActionFactory actionFactory;
    
    public GroupActivityService(INotificationService notificationService,INotificationActionFactory actionFactory ) {
        this.notificationService = notificationService;
        
        this.actionFactory = actionFactory;
    }

    public void addUserToGroup(IUserInfo user, Group group) {
        // Logic to add user to group
        INotification notification = new BasicNotification(user.getUserID(), 
            "You were added to the group " + group.getName() + ".", "Group Activity", actionFactory);
        notificationService.sendNotification(notification);
    }
}

