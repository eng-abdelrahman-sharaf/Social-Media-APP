/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.notifcation;

/**
 *
 * @author abdah
 */
import java.util.List;

public class NotificationProcessor {
    public void printMessages(List<INotification> notifications) {
        for (INotification notification : notifications) {
            System.out.println("Notification Message: " + notification.getMessage());
        }
    }
}

