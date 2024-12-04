/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.MediaApp.UserAccountManagement;

import java.util.ArrayList;
import java.util.List;

public class UserRole {

    private List<UserInfo> userInfoList;

    
    public UserRole() {
        this.userInfoList = new ArrayList<>();
    }

   
    public void addUser(UserInfo user) {
        if (user != null) {
            userInfoList.add(user);
            System.out.println("User added: " + user.getUserID());
        } else {
            System.out.println("Cannot add a null user.");
        }
    }

    
    public void saveList(ListStorageHandler<UserInfo> storageHandler, String filePath) {
        try {
            storageHandler.saveList(userInfoList, filePath);
            System.out.println("User list saved to: " + filePath);
        } catch (Exception e) {
            System.err.println("Failed to save user list: " + e.getMessage());
        }
    }

    
    public void loadList(ListStorageHandler<UserInfo> storageHandler, String filePath) {
        try {
            userInfoList = storageHandler.loadList(filePath);
            System.out.println("User list loaded from: " + filePath);
        } catch (Exception e) {
            System.err.println("Failed to load user list: " + e.getMessage());
        }
    }

    
    public List<UserInfo> getUserInfoList() {
        return userInfoList;
    }
}
