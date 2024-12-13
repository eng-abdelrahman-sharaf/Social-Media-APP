
package com.notifcation;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

// NotificationService Interface 
// This interface defines the methods for handling notifications, 
// ensuring that any class implementing it will have methods to send and fetch notifications.
public interface INotificationService {
    void sendNotification(INotification notification);
    public List<INotification> getNotifications(String userId);
    public void markNotificationAsRead(String userId, String type);

}



