
package com.MediaApp.UserAccountManagement;

import java.io.IOException;
import java.util.List;

public interface ListStorageHandler<T> {
    void saveList(List<T> dataList) throws IOException;

    List<T> loadList() throws IOException;
}
