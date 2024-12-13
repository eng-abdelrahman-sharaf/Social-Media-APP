package com.MediaApp.DataHandlers;

import com.MediaApp.ContentManagement.IGroupPost;
import com.MediaApp.ContentManagement.IPost;

public class GroupPostDataBase extends DataBase<IGroupPost>{



    private static GroupPostDataBase instance;

    private GroupPostDataBase(MapStorageHandler<String, IGroupPost> handler) {
        super(handler);
    }

    // Singleton pattern
    public static GroupPostDataBase getInstance(MapStorageHandler<String, IGroupPost> handler) {
        if (instance == null) {
            instance = new GroupPostDataBase(handler);
        }
        return instance;
    }

    @Override
    public IGroupPost[] getData() {
        return getObjectsStore().values().stream()
                .map(IGroupPost::clone)
                .toArray(IGroupPost[]::new);
    }

}
