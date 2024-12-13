
package com.MediaApp.DataHandlers;

import com.MediaApp.ContentManagement.IPost;
import com.MediaApp.UserAccountManagement.IUserInfo;

import java.io.IOException;
import java.util.HashMap;

public class PostDataBase extends DataBase<IPost> implements IMediumDataBase<IPost> {

    private static PostDataBase instance;

    private PostDataBase(MapStorageHandler<String, IPost> handler) {
        super(handler);
    }

    // Singleton pattern
    public static PostDataBase getInstance(MapStorageHandler<String, IPost> handler) {
        if (instance == null) {
            instance = new PostDataBase(handler);
        }
        return instance;
    }

    @Override
    public IPost[] getData() {
        return getObjectsStore().values().stream()
                .map(IPost::clone)
                .toArray(IPost[]::new);
    }
}