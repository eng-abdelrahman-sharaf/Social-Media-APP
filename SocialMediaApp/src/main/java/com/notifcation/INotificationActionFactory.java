/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.notifcation;

import java.util.Map;

// INotificationActionFactory Interface 
// This interface defines the method for creating actions for different notification types.
public interface INotificationActionFactory {
    Map<String, String> createActions(String notificationType, String userId);
}
