/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.programming2.socialmediaapp.UserAccountManagement;

import java.util.ArrayList;
import java.util.List;

public class UserRole implements UserManager {

    private List<UserInfo> userInfoList;

    public UserRole() {
        this.userInfoList = new ArrayList<>();
    }

    @Override
    public void addUser(UserInfo user) {
        if (user != null) {
            userInfoList.add(user);
            System.out.println("User added: " + user.getUserID());
        } else {
            System.out.println("Cannot add a null user.");
        }
    }

    @Override
    public List<UserInfo> getUserInfoList() {
        return new ArrayList<>(userInfoList); // Return a copy to maintain encapsulation
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

    public UserInfo findUserById(List<UserInfo> userList, String userId) {
    for (UserInfo user : userList) {
        if (user.getUserID().equals(userId)) {
            return user; // Return the reference to the matching UserInfo object
        }
    }
    return null; // Return null if no user is found with the given ID
}
   
}
