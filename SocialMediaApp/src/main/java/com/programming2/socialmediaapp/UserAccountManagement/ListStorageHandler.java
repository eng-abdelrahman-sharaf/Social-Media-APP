//this is interface uses to save and load List<obj> 
//you can find the imp in file name : JsonStorageHandler 
package com.programming2.socialmediaapp.UserAccountManagement;

import java.io.IOException;
import java.util.List;

public interface ListStorageHandler<T> {
    void saveList(List<T> dataList, String filePath) throws IOException;

    List<T> loadList(String filePath) throws IOException;
}
