//if you want to save list or load in any where any list of obj and any database type
/*
 JsonStorageHandler<UserInfo> storageHandler = new JsonStorageHandler<>(UserInfo.class, filePath);
            
            storageHandler.saveList(userInfoList);

            userInfoList = storageHandler.loadList();

*/
package com.MediaApp.UserAccountManagement;

import java.io.IOException;
import java.util.List;

public interface ListStorageHandler<T> {
    void saveList(List<T> dataList) throws IOException;

    List<T> loadList() throws IOException;
}
