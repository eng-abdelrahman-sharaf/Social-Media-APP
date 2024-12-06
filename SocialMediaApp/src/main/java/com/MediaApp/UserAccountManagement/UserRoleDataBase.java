/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.MediaApp.UserAccountManagement;



import com.MediaApp.DataHandlers.IDataBase;
import com.MediaApp.DataHandlers.IDataObject;
import com.MediaApp.UserAccountManagement.ListStorageHandler;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class UserRoleDataBase implements IDataBase {

    private static UserRoleDataBase instance;
    private HashMap<String, IDataObject> dataMap;
    private ListStorageHandler<IDataObject> storageHandler;

    private UserRoleDataBase(ListStorageHandler<IDataObject> handler) {
        this.storageHandler = handler;
        this.dataMap = new HashMap<>();
        reload(); // Initial load
    }

    // Singleton pattern
    public static UserRoleDataBase getInstance(ListStorageHandler<IDataObject> handler) {
        if (instance == null) {
            instance = new UserRoleDataBase(handler);
        }
        return instance;
    }


    @Override
    public IDataObject readObject(String ID) {
        IDataObject object = dataMap.get(ID);
        return (object != null) ? object.clone() : null; // Return a clone
    }

    @Override
    public IDataObject[] getData() {
        return dataMap.values().stream()
                .map(IDataObject::clone)
                .toArray(IDataObject[]::new); // Return cloned objects
    }

    @Override
    public void addObject(IDataObject object) {
        reload(); // Refresh data
        dataMap.put(object.getID(), object.clone()); // Store a clone
        save(); // Save changes
    }

    @Override
    public void deleteObject(String ID) {
        reload(); // Refresh data
        dataMap.remove(ID); // Remove the object
        save(); // Save changes
    }

    @Override
    public void update(String ID, IDataObject object) {
        reload(); // Refresh data
        dataMap.put(ID, object.clone()); // Update with a clone
        save(); // Save changes
    }

    @Override
    public void reload() {
        try {
            List<IDataObject> loadedData = storageHandler.loadList();
            dataMap.clear(); // Clear current data
            for (IDataObject obj : loadedData) {
                dataMap.put(obj.getID(), obj); // Add loaded objects to map
            }
        } catch (IOException e) {
            e.printStackTrace(); // Handle exception
        }
    }

    @Override
    public void save() {
        try {
            storageHandler.saveList(new ArrayList<>(dataMap.values())); // Save map values
        } catch (IOException e) {
            e.printStackTrace(); // Handle exception
        }
    }
}