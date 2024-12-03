/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.programming2.socialmediaapp.UserAccountManagement;
import java.util.List;

public class UserFinderImpl implements UserFinder {
    private List<UserInfo> userList;
   
    // Constructor to initialize with user list
    public UserFinderImpl(List<UserInfo> userList) {
        this.userList = userList;
    }

    @Override
    public UserInfo findUserById(String userId) {
        for (UserInfo user : userList) {
            if (user.getUserID().equals(userId)) {
                return user; 
            }
        }
        return null; 
    }

    @Override
    public UserInfo findUserByUserName(String userName) {
        for (UserInfo user : userList) {
            if (user.getUserName().equalsIgnoreCase(userName)) {
                return user; 
            }
        }
        return null; 
    }

    @Override
    public UserInfo findUserByEmail(String email) {
        for (UserInfo user : userList) {
            if (user.getEmail().equalsIgnoreCase(email)) {
                return user; 
            }
        }
        return null; 
    }
}
