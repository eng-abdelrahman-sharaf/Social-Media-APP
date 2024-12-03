package com.programming2.socialmediaapp.UserAccountManagement;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.type.TypeReference;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
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
    public static void saveUserListToFile(List<UserInfo> userList, String filePath) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.writeValue(new File(filePath), userList);
    }

    // Load an ArrayList of UserInfo objects from a JSON file
    public static List<UserInfo> loadUserListFromFile(String filePath) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(new File(filePath), new TypeReference<List<UserInfo>>() {});
    }
    

    public static void main(String[] args) {
        // Example usage:
         try {
            // Create sample UserInfo objects
            UserInfo user1 = new UserInfo("user123", "5f4dcc3b5aa765d61d8327deb882cf99", "user123@example.com", "1990-05-15");
            user1.setFriendsIDs(List.of("user456", "user789", "user101"));
            user1.setBlockedAccountsIDs(List.of("post001", "post002"));
            user1.setPostsIDs(List.of("post001", "post002"));
            user1.setBio("Just another tech enthusiast exploring the world!");
            user1.setStatus("Active");
            user1.setProfilePhotoPath("/images/profile123.jpg");
            user1.setCoverPhotoPath("/images/cover123.jpg");
            user1.setStoriesIDs(List.of("story001", "story002"));

            UserInfo user2 = new UserInfo("user456", "e99a18c428cb38d5f260853678922e03", "user456@example.com", "1992-08-25");
            user2.setFriendsIDs(List.of("user123", "user789"));
            user2.setBlockedAccountsIDs(List.of("post003"));
            user2.setPostsIDs(List.of("post003", "post004"));
            user2.setBio("A curious mind and a coding enthusiast!");
            user2.setStatus("Active");
            user2.setProfilePhotoPath("/images/profile456.jpg");
            user2.setCoverPhotoPath("/images/cover456.jpg");
            user2.setStoriesIDs(List.of("story003"));

            // Create a list of UserInfo objects
            List<UserInfo> userList = new ArrayList<>();
            userList.add(user1);
            userList.add(user2);

            // Save the user list to a file
            saveUserListToFile(userList, "user_list.json");

            // Load the user list from the file
            List<UserInfo> loadedUserList = loadUserListFromFile("user_list.json");

            // Display the loaded user list
            for (UserInfo user : loadedUserList) {
                System.out.println(user);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
