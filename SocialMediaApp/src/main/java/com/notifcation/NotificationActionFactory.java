package com.notifcation;



import java.util.HashMap;
import java.util.Map;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author abdah
 */
public class NotificationActionFactory implements INotificationActionFactory {
    private final Map<String, ActionProvider> actionProviders = new HashMap<>();

    public NotificationActionFactory() {
        actionProviders.put("Friend Request", new FriendRequestActionProvider());
        actionProviders.put("New Post", new NewPostActionProvider());
        actionProviders.put("Group Activity", new GroupActivityActionProvider());
    }

    @Override
    public Map<String, String> createActions(String notificationType, String userId) {
        ActionProvider provider = actionProviders.get(notificationType);
        if (provider != null) {
            return provider.createActions(userId);
        }
        return new HashMap<>();
    }

    public void registerActionProvider(String notificationType, ActionProvider provider) {
        actionProviders.put(notificationType, provider);
    }
}

