/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.notifcation;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

// NotificationServiceImpl Class 
// This class is a concrete implementation of the NotificationService interface. 
// It handles storing and retrieving notifications.

public class NotificationServiceImpl implements INotificationService {
    private List<INotification> notifications = new ArrayList<>();

    @Override
    public void sendNotification(INotification notification) {
        notifications.add(notification);
    }

    public List<INotification> getNotifications(String userId) {
        return notifications.stream()
            .filter(notification -> notification.getUserId().equals(userId) && !notification.isRead())
            .collect(Collectors.toList());
    }
}
//Can't apply singlton here bec each user has his own notifcation list 
