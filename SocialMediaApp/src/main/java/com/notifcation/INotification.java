/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.notifcation;

import java.util.Date;
import java.util.Map;

// Notification Interface 
// This interface defines the basic structure for all notification types, 
// ensuring that any notification will have methods to get the user ID, message, type, creation date, and read status, and actions.
public interface INotification {
    String getUserId();
    String getMessage();
    String getType();
    Date getCreatedAt();
    boolean isRead();
    Map<String, String> getActions();  // Key: Action, Value: URL or Command
    void markAsRead(boolean isRead);
}
