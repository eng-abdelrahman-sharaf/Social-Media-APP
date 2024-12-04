
package com.MediaApp.UserAccountManagement;

import java.io.IOException;
import java.util.List;

public interface ListStorageHandler<T> {
    void saveList(List<T> dataList, String filePath) throws IOException;

    List<T> loadList(String filePath) throws IOException;
}
