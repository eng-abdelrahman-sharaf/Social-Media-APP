/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.notifcation;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

// BasicNotification Class 
// This class is a concrete implementation of the Notification interface. 
// It represents a simple notification with attributes like user ID, message, type, creation date, and read status, and actions.

public class BasicNotification implements INotification {
    private String userId;
    private String message;
    private String type;
    private Date createdAt;
    private boolean isRead;
    private Map<String, String> actions = new HashMap<>();

    // Constructor
    public BasicNotification(String userId, String message, String type) {
        this.userId = userId;
        this.message = message;
        this.type = type;
        this.createdAt = new Date();
        this.isRead = false;
        this.actions = actionFactory.createActions(type,userId);
    }

    // Getters and setters
    @Override
    public String getUserId() {
        return userId;
    }

    @Override
    public String getMessage() {
        return message;
    }

    @Override
    public String getType() {
        return type;
    }

    @Override
    public Date getCreatedAt() {
        return createdAt;
    }

    @Override
    public boolean isRead() {
        return isRead;
    }
    @Override 
    public Map<String, String> getActions() {
        return actions;
    }
}
