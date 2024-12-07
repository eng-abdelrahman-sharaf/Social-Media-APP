package com.MediaApp.UserAccountManagement.tests;


import com.MediaApp.DataHandlers.JsonMapStorageHandler;
import com.MediaApp.DataHandlers.MapStorageHandler;
import com.MediaApp.UserAccountManagement.UserInfo;
import com.MediaApp.UserAccountManagement.UserRoleDataBase;

import java.io.IOException;
import java.util.Arrays;

public class UserInfoStorageTest {

    public static void main(String[] args) throws IOException {
        String filePath = "user.json";
        
        // Create a storage handler for the HashMap
        MapStorageHandler<String, UserInfo> storageHandler = new JsonMapStorageHandler<>(String.class, UserInfo.class, filePath);
        
        // Get the singleton instance of UserRoleDataBase
        UserRoleDataBase userRoleDataBase = UserRoleDataBase.getInstance(storageHandler);

        System.out.println(userRoleDataBase.readObject("nogea"));
        for(Object datum : Arrays.stream(userRoleDataBase.getData()).toArray() ){
            System.out.println(datum);
        }

        // Create some user objects
        UserInfo user1 = new UserInfo("nogea", "Ali", "hashedPassword1", "ali@example.com", "1990-05-15");
        UserInfo user2 = new UserInfo("magdi", "Omar", "hashedPassword2", "omar@example.com", "1992-07-20");
        UserInfo user3 = new UserInfo("gogo", "Amr", "hashedPassword3", "amr@example.com", "1992-04-20");



        userRoleDataBase.save();
    }
}


