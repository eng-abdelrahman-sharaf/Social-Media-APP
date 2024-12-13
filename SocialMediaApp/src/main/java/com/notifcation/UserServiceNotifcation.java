/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.notifcation;

import java.util.List;

/**
 *
 * @author abdah
 */
public class UserServiceNotifcation {
    private INotificationService notificationService;

    public UserServiceNotifcation(INotificationService notificationService) {
        this.notificationService = notificationService;
    }

    public List<INotification> fetchNotifications(String userId) {
        return notificationService.getNotifications(userId);
    }
}

