package com.MediaApp.UserAccountManagement.tests;


import com.MediaApp.DataHandlers.JsonMapStorageHandler;
import com.MediaApp.DataHandlers.MapStorageHandler;
import com.MediaApp.UserAccountManagement.IUserInfo;
import com.MediaApp.UserAccountManagement.UserInfoClassType;
import com.MediaApp.UserAccountManagement.UserInfoFactory;
import com.MediaApp.UserAccountManagement.UserRoleDataBase;

import java.io.IOException;
import java.util.Arrays;

public class UserInfoStorageTest {

    private static UserInfoFactory userInfoFactory = new UserInfoFactory();

    public static void main(String[] args) throws IOException {
        String filePath = "user.json";
        
        // Create a storage handler for the HashMap
        MapStorageHandler<String, IUserInfo> storageHandler = new JsonMapStorageHandler<>(String.class, UserInfoClassType.type, filePath);
        
        // Get the singleton instance of UserRoleDataBase
        UserRoleDataBase userRoleDataBase = UserRoleDataBase.getInstance(storageHandler);

        System.out.println(userRoleDataBase.readObject("nogea"));
        for(Object datum : Arrays.stream(userRoleDataBase.getData()).toArray() ){
            System.out.println(datum);
        }

        // Create some user objects
        IUserInfo user1 = userInfoFactory.getUserInfo("nogea", "Ali", "hashedPassword1", "ali@example.com", "1990-05-15");
        IUserInfo user2 = userInfoFactory.getUserInfo("magdi", "Omar", "hashedPassword2", "omar@example.com", "1992-07-20");
        IUserInfo user3 = userInfoFactory.getUserInfo("gogo", "Amr", "hashedPassword3", "amr@example.com", "1992-04-20");



        userRoleDataBase.save();
    }
}


