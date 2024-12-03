/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.programming2.socialmediaapp.UserAccountManagement;

import java.io.IOException;
import java.util.List;

public interface ListStorageHandler<T> {
    void saveList(List<T> dataList, String filePath) throws IOException;

    List<T> loadList(String filePath) throws IOException;
}
