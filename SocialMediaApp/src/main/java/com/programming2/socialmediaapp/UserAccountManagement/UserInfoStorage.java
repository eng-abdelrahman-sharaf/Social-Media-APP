package com.programming2.socialmediaapp.UserAccountManagement;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class UserInfoStorage {

    // save user info to a JSON file
    public static void saveUserInfoToFile(UserInfo userInfo, String filePath) throws IOException {
        // serialization
        ObjectMapper objectMapper = new ObjectMapper();
        
        // Write the UserInfo object to the specified file path
        objectMapper.writeValue(new File(filePath), userInfo);
    }

    // load user info from a JSON file
    public static UserInfo loadUserInfoFromFile(String filePath) throws IOException {
        // deserialization
        ObjectMapper objectMapper = new ObjectMapper();
        
        // Read the JSON file and convert it to a UserInfo object
        //can write like this UserInfo user = objectMapper.readValue(new File(filePath), UserInfo.class); then return user
        return objectMapper.readValue(new File(filePath), UserInfo.class);
    }

    public static void main(String[] args) {
        // Example usage:
        try {
            // Create a UserInfo object
            UserInfo userInfo = new UserInfo("user123", "5f4dcc3b5aa765d61d8327deb882cf99", "user123@example.com", "1990-05-15");
            userInfo.setFriendsIDs(List.of("user456", "user789", "user101"));
            userInfo.setBlockedAccountsIDs(List.of("post001", "post002"));
            userInfo.setPostsIDs(List.of("post001", "post002"));
            userInfo.setBio("Just another tech enthusiast exploring the world!");
            userInfo.setStatus("Active");
            userInfo.setProfilePhotoPath("/images/profile123.jpg");
            userInfo.setCoverPhotoPath("/images/cover123.jpg");
            userInfo.setStoriesIDs(List.of("story001", "story002"));

            // Save the UserInfo object to a file
            saveUserInfoToFile(userInfo, "user123_info.json");

            // Load the UserInfo object from the file
            UserInfo loadedUserInfo = loadUserInfoFromFile("user123_info.json");

            // Display the loaded user info
            System.out.println(loadedUserInfo);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
