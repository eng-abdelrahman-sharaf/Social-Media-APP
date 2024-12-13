
package com.MediaApp.UserAccountManagement;



import com.MediaApp.DataHandlers.*;
//import com.MediaApp.UserAccountManagement.ListStorageHandler;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class UserRoleDataBase extends DataBase<IUserInfo> {

    private static UserRoleDataBase instance;


    private UserRoleDataBase(MapStorageHandler<String, IUserInfo> handler) {
        super(handler);
    }

    @Override
    public IUserInfo[] getData() {
        return getObjectsStore().values().stream()
                .map(IUserInfo::clone)
                .toArray(IUserInfo[]::new);
    }

    // Singleton pattern
    public static UserRoleDataBase getInstance(MapStorageHandler<String, IUserInfo> handler) {
        if (instance == null) {
            instance = new UserRoleDataBase(handler);
        }
        return instance;
    }
}