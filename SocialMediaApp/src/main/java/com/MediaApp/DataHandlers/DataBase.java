package com.MediaApp.DataHandlers;

import com.MediaApp.UserAccountManagement.IUserInfo;

import java.io.IOException;
import java.util.HashMap;

public abstract class DataBase<T extends IDataObject> implements IDataBase<T>{
    private HashMap<String, T> objectsStore = new HashMap<>();
    private final MapStorageHandler<String , T> storageHandler;

    protected DataBase(MapStorageHandler<String , T> storageHandler) {
        this.storageHandler = storageHandler;
        reload();
    }

    protected HashMap<String, T> getObjectsStore() {
        return objectsStore;
    }

    public void save(T object) {
        objectsStore.put(object.getID(), object);
    }

    @Override
    public T readObject(String ID) {
        T object = objectsStore.get(ID);
        if(object == null) return null;
        return (T)object.clone();
    }

    public abstract T[] getData();

    @Override
    public void addObject(T object) {
        reload();
        objectsStore.put(object.getID(), object);
        save();
    }

    @Override
    public void deleteObject(String ID) {
        reload();
        objectsStore.remove(ID);
        save();
    }

    @Override
    public void update(String ID, T object) {
        reload();
        objectsStore.put(ID, (T)object.clone());
        save();
    }

    @Override
    public void reload() {
        try {
            objectsStore = storageHandler.loadMap();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void save() {
        try {
            storageHandler.saveMap(objectsStore);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
