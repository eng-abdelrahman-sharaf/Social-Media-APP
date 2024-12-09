
package com.MediaApp.DataHandlers;


import com.MediaApp.ContentManagement.IStory;

import java.io.IOException;
import java.util.HashMap;

public class StoryDataBase implements IMediumDataBase {

    private static StoryDataBase instance;
    private HashMap<String, IStory> dataMap;
    private MapStorageHandler<String, IStory> storageHandler;

    private StoryDataBase(MapStorageHandler<String, IStory> handler) {
        this.storageHandler = handler;
        this.dataMap = new HashMap<>();
        reload(); // Initial load
    }

    // Singleton pattern
    public static StoryDataBase getInstance(MapStorageHandler<String, IStory> handler) {
        if (instance == null) {
            instance = new StoryDataBase(handler);
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
    }

    @Override
    public void addObject(IDataObject object) {
        reload(); // Refresh data
        dataMap.put(object.getID(), (IStory) object.clone()); // Store a clone
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
        dataMap.put(ID, (IStory) object.clone()); // Update with a clone
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