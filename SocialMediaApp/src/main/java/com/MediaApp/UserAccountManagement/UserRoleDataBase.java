
package com.MediaApp.UserAccountManagement;



import com.MediaApp.DataHandlers.IDataBase;
import com.MediaApp.DataHandlers.IDataObject;
import com.MediaApp.DataHandlers.MapStorageHandler;
import com.MediaApp.UserAccountManagement.ListStorageHandler;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class UserRoleDataBase implements IDataBase {

    private static UserRoleDataBase instance;
    private HashMap<String, IDataObject> dataMap;
    private MapStorageHandler<String, IDataObject> storageHandler;

    private UserRoleDataBase(MapStorageHandler<String, IDataObject> handler) {
        this.storageHandler = handler;
        this.dataMap = new HashMap<>();
        reload(); // Initial load
    }

    // Singleton pattern
    public static UserRoleDataBase getInstance(MapStorageHandler<String, IDataObject> handler) {
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
                .toArray(IDataObject[]::new); // Return cloned objects in Array
        // if you want Return hashMap use the following code 
        
        // Create a new HashMap to store cloned objects
//        HashMap<String, IDataObject> clonedDataMap = new HashMap<>();
//
//        // Populate the cloned map with cloned objects
//        for (Map.Entry<String, IDataObject> entry : dataMap.entrySet()) {
//            clonedDataMap.put(entry.getKey(), entry.getValue().clone());
//        }
//
//        return clonedDataMap; // Return the HashMap of cloned objects

        
        
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
            dataMap = storageHandler.loadMap(); // Load the HashMap from storage
        } catch (IOException e) {
            e.printStackTrace(); // Handle exception
        }
    }

    @Override
    public void save() {
        try {
            storageHandler.saveMap(dataMap); // Save the HashMap
        } catch (IOException e) {
            e.printStackTrace(); // Handle exception
        }
    }
}