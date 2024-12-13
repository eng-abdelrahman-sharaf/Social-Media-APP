
package com.MediaApp.DataHandlers;


import com.MediaApp.ContentManagement.IPost;
import com.MediaApp.ContentManagement.IStory;

import java.io.IOException;
import java.util.HashMap;

public class StoryDataBase extends DataBase<IStory> implements IMediumDataBase<IStory> {

    private static StoryDataBase instance;
    private HashMap<String, IStory> dataMap;
    private MapStorageHandler<String, IStory> storageHandler;

    private StoryDataBase(MapStorageHandler<String, IStory> handler) {
        super(handler);
    }

    // Singleton pattern
    public static StoryDataBase getInstance(MapStorageHandler<String, IStory> handler) {
        if (instance == null) {
            instance = new StoryDataBase(handler);
        }
        return instance;
    }

    @Override
    public IStory[] getData() {
        return getObjectsStore().values().stream()
                .map(IStory::clone)
                .toArray(IStory[]::new);
    }
}