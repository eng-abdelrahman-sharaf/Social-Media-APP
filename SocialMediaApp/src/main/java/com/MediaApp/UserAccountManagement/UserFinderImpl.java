/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.MediaApp.UserAccountManagement;

/**
 *
 * @author abdah
 */
import com.MediaApp.DataHandlers.IDataBase;
import com.MediaApp.DataHandlers.IDataObject;
import com.MediaApp.SearchEngines.INamedDataObject;

import java.util.List;

public class UserFinderImpl implements UserFinder {
    private IDataBase userdb;
   
    // Constructor to initialize with user list
    public UserFinderImpl(IDataBase userdb) {
        this.userdb = userdb;
    }
    
    @Override
    public IUserInfo findUserByUserName(String userName) {
        for (IDataObject obj : userdb.getData()) {
            IUserInfo user = (IUserInfo)obj;
            if (user.getUserName().equalsIgnoreCase(userName)) {
                return user;
            }
        }
        return null; 
    }

    @Override
    public IUserInfo findUserByEmail(String email) {
        for (IDataObject obj : userdb.getData()) {
            IUserInfo userInfo = (IUserInfo)obj;
            if (userInfo.getEmail().equalsIgnoreCase(email)) {
                return userInfo;
            }
        }
        return null; 
    }

    @Override
    public INamedDataObject findByName(String name) {
        return findUserByUserName(name);
    }
}
