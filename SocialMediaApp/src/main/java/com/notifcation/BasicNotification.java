/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.notifcation;

import com.MediaApp.DataHandlers.IDataObject;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

// BasicNotification Class 
// This class is a concrete implementation of the Notification interface. 
// It represents a simple notification with attributes like user ID, message, type, creation date, and read status, and actions.


  public class BasicNotification implements INotification, IDataObject {
    private String ID;
    private String userId;
    private String message;
    private String type;
    private Date createdAt;
    private boolean isRead;
    private Map<String, String> actions;

    // Constructor
    public BasicNotification( String userId, String message, String type,INotificationActionFactory actionFactory) {
            this.ID = UUID.randomUUID().toString();
            this.userId = userId;
            this.message = message;
            this.type = type;
            this.createdAt = new Date();
            this.isRead = false;
            this.actions = actionFactory.createActions(type, userId);
        }
    public BasicNotification() {
    }
    

    // Implementing IDataObject methods
    @Override
    public String getID() {
        return ID;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public void setIsRead(boolean isRead) {
        this.isRead = isRead;
    }

    public void setActions(Map<String, String> actions) {
        this.actions = actions;
    }

    @Override
    public void setID(String ID) {
        this.ID = ID;
    }
    @Override
    public BasicNotification clone() {
        BasicNotification cloned = new BasicNotification();
       if (this.ID != null && !this.ID.isEmpty()) { 
          cloned.setID(this.ID);
       } 
         else { 
          cloned.setID(UUID.randomUUID().toString()); // Generate new unique ID if none exists 
       }
        cloned.setUserId(this.userId);
        cloned.setMessage(this.message);
        cloned.setType(this.type);
        cloned.setCreatedAt(new Date(this.createdAt.getTime()));  // Ensuring date is deeply cloned
        cloned.markAsRead(this.isRead);

        // Deep clone mutable attributes
        cloned.setActions(new HashMap<>(this.actions));
        return cloned;
    }


    // Implementing INotification methods
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
        return new HashMap<>(actions);  // Returning a copy to ensure immutability
    }

    @Override
    public void markAsRead(boolean isRead) {
        this.isRead = isRead;
    }
}

