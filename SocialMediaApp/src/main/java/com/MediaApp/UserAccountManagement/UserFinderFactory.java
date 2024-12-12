package com.MediaApp.UserAccountManagement;

import com.MediaApp.DataHandlers.IDataBase;

public class UserFinderFactory {
    public UserFinder create(IDataBase userdb) {
        return  new UserFinderImpl(userdb);
    }
}
