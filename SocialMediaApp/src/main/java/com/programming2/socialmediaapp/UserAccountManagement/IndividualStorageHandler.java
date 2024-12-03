package com.programming2.socialmediaapp.UserAccountManagement;

import java.io.IOException;

public interface IndividualStorageHandler<T> {
    void save(T data, String filePath) throws IOException;

    T load(String filePath) throws IOException;
}
