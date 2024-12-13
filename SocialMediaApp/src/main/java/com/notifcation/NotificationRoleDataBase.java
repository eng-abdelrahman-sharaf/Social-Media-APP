/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.notifcation;

import com.MediaApp.DataHandlers.DataBase;
import com.MediaApp.DataHandlers.MapStorageHandler;
import java.io.IOException;
import java.util.stream.Stream;

public class NotificationRoleDataBase extends DataBase<INotification> {

    private static NotificationRoleDataBase instance;

    private NotificationRoleDataBase(MapStorageHandler<String, INotification> handler) {
        super(handler);
    }

    @Override
    public INotification[] getData() {
        return getObjectsStore().values().stream()
                .map(INotification::clone)
                .toArray(INotification[]::new);
    }

    // Singleton pattern
    public static NotificationRoleDataBase getInstance(MapStorageHandler<String, INotification> handler) {
        if (instance == null) {
            instance = new NotificationRoleDataBase(handler);
        }
        return instance;
    }
}
