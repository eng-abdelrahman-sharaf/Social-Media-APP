/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.notifcation;

import java.util.Date;

// Notification Interface 
// This interface defines the basic structure for all notification types, 
// ensuring that any notification will have methods to get the user ID, message, type, creation date, and read status.
public interface INotification {
    String getUserId();
    String getMessage();
    String getType();
    Date getCreatedAt();
    boolean isRead();
}
