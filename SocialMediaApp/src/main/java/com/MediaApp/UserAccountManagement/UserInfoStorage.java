package com.MediaApp.UserAccountManagement;


import com.MediaApp.DataHandlers.IDataObject;
import com.MediaApp.DataHandlers.JsonMapStorageHandler;
import com.MediaApp.DataHandlers.MapStorageHandler;
import com.MediaApp.SignPage.DataValidator;
import com.MediaApp.SignPage.DataValidatorImpl;
import com.MediaApp.SignPage.SignUpService;
import com.MediaApp.SignPage.SignUpServiceImpl;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class UserInfoStorage {

    public static void main(String[] args) throws IOException {
      
//              

        String filePath = "user_data_Map.json";
        
        // Create a storage handler for the HashMap
        MapStorageHandler<String, IDataObject> storageHandler = new JsonMapStorageHandler<>(String.class, IDataObject.class, filePath);
        
        // Get the singleton instance of UserRoleDataBase
        UserRoleDataBase userRoleDataBase = UserRoleDataBase.getInstance(storageHandler);
        
        // Create some user objects
        UserInfo user1 = new UserInfo("user123", "Ali", "hashedPassword1", "ali@example.com", "1990-05-15");
        UserInfo user2 = new UserInfo("user456", "Omar", "hashedPassword2", "omar@example.com", "1992-07-20");
        UserInfo user3 = new UserInfo("user789", "Amr", "hashedPassword3", "amr@example.com", "1992-04-20");

        // Add users to the database
        userRoleDataBase.addObject(user1);
        userRoleDataBase.addObject(user2);
        userRoleDataBase.addObject(user3);
        
       // init the file for the first time runnig the prog only
        userRoleDataBase.save();
        // Read a user object
//        IDataObject retrievedUser = userRoleDataBase.readObject("user123");
//        System.out.println("Retrieved User: " + retrievedUser);

        // Update a user object
//        UserInfo updatedUser = new UserInfo("user123", "Ali Updated", "newHashedPassword", "ali.updated@example.com", "1990-05-15");
//        userRoleDataBase.update("user123", updatedUser);
//        System.out.println("Updated User: " + userRoleDataBase.readObject("user123"));
//
//        // Get all users
//        IDataObject[] allUsers = userRoleDataBase.getData();
//        System.out.println("All Users: " + allUsers);
//
//        // Delete a user object
//        userRoleDataBase.deleteObject("user456");
//        System.out.println("After Deletion, All Users: " + userRoleDataBase.getData());
//        
//        // Reload the data to ensure it reflects the current state
//        userRoleDataBase.reload();
//        System.out.println("Reloaded Users: " + userRoleDataBase.getData());
    }
}





























//        String filePath = "user_data_hasedPlus.json";
//        JsonMapStorageHandler<String, UserInfo> MapStorageHandler = new JsonMapStorageHandler<>(String.class, UserInfo.class, filePath);
//
//        
//        HashMap<String, UserInfo> userMap = new HashMap<>();
//
//        // Example UserInfo objects to add to the map
//        UserInfo user1 = new UserInfo("user123", "Ali", "hashedPassword1", "user123@example.com", "1990-05-15");
//        UserInfo user2 = new UserInfo("user456", "Omar", "hashedPassword2", "user456@example.com", "1992-07-20");
//        UserInfo user3 = new UserInfo("user6", "Amr", "hashedPassword4", "user42356@example.com", "1992-04-20");
//
//        // Add users to the map using their userID as the key
//        userMap.put(user1.getUserID(), user1);
//        userMap.put(user2.getUserID(), user2);
//        userMap.put(user3.getUserID(), user3);
//
//        // Save the map of users using JsonMapStorageHandler
//        MapStorageHandler.saveMap(userMap);
//        System.out.println("Saved successfully! User map: " + userMap);
//
//        // Load the map of users back from the JSON file
//        HashMap<String, UserInfo> loadedUserMap = MapStorageHandler.loadMap();
//        System.out.println("Loaded successfully! User map: " + loadedUserMap);



// Create instances of UserRole and JSON storage handler
//        UserRole userRole = new UserRole();
//        String filePath2 = "user_data_hased.json";
//        JsonStorageHandler<UserInfo> storageHandler = new JsonStorageHandler<>(UserInfo.class, filePath2);
//        UserRole userRole = new UserRole();
//        DataValidator dataValidator = new DataValidatorImpl();
//        
        
//        UserInfo user1 = new UserInfo("user123","Ali", "hashedPassword1", "user123@example.com", "1990-05-15");
//        UserInfo user2 = new UserInfo("user456","omar", "hashedPassword2", "user456@example.com", "1992-07-20");
//        UserInfo user3 = new UserInfo("user6","amr", "hashedPassword4", "user42356@example.com", "1992-04-20");
//        
////        System.out.println(user1 instanceof UserInfo);
//        // Add users to the role
//        userRole.addUser(user1);
//        userRole.addUser(user2);
//        userRole.addUser(user3);
        
        //Save and load the user list
//        userRole.saveList(storageHandler);
//        System.out.println("saved succ" + userRole.getUserInfoList());

//        userRole.loadList(storageHandler);
//          System.out.println(userRole.getUserInfoList());
//       //  Print loaded user info
        
//        storageHandler.saveList(userRole.getUserInfoList());
//        System.out.println("Saved successfully: " + userRole.getUserInfoList());

        // Load the user list
//        userRole.loadList(storageHandler);
//        System.out.println("Loaded users: " + userRole.getUserInfoList());
//    }


//        UserFinder userFinder = new UserFinderImpl(userRole.getUserInfoList());
//        LoginService loginService = new LoginServiceImpl(userFinder); 
//        boolean iss= loginService.login("john_doe", "password123");
//        System.out.println(iss);
//        System.out.println(loginService.login("john_doe", "password123"));
//        System.out.println(loginService.login("Ali", "hashedPassword1"));
//        System.out.println(loginService.login("user456@example.com", "hashedPassword2"));
//        
//       SignUpService signUpService = new SignUpServiceImpl(userFinder, dataValidator, userRole.getUserInfoList());
//       String result = signUpService.signUp("john_doe", "john@example.com", "1995-05-15", "StrongPass1", "WeakPass2");
//        System.out.println(result); 
        
//        String result2 = signUpService.signUp("john_doe", "john@example.com", "1995-05-15", "StrongPass1", "StrongPass1");
        // Console Output: "Success: User signed up successfully!"
//        System.out.println(result2);  // Output: "True, User signed up successfully!"
//        System.out.println(userRole.getUserInfoList());
//    for (UserInfo user : userRole.getUserInfoList()) {
//        System.out.println(user);
//  }
//    }

//}




     //we don't need to use this class any more 
      // this class was replaced by JsonStorageHandler  
//
//package com.MediaApp.UserAccountManagement;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.fasterxml.jackson.core.type.TypeReference;
//
//import java.io.File;
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.List;
//
//public class UserInfoStorage {
//
//    // save user info to a JSON file
//    public static void saveUserInfoToFile(UserInfo userInfo, String filePath) throws IOException {
//        // serialization
//        ObjectMapper objectMapper = new ObjectMapper();
//        
//        // Write the UserInfo object to the specified file path
//        objectMapper.writeValue(new File(filePath), userInfo);
//    }
//
//    // load user info from a JSON file
//    public static UserInfo loadUserInfoFromFile(String filePath) throws IOException {
//        // deserialization
//        ObjectMapper objectMapper = new ObjectMapper();
//        
//        // Read the JSON file and convert it to a UserInfo object
//        //can write like this UserInfo user = objectMapper.readValue(new File(filePath), UserInfo.class); then return user
//        return objectMapper.readValue(new File(filePath), UserInfo.class);
//    }
//    public static void saveUserListToFile(List<UserInfo> userList, String filePath) throws IOException {
//        ObjectMapper objectMapper = new ObjectMapper();
//        objectMapper.writeValue(new File(filePath), userList);
//    }
//
//    // Load an ArrayList of UserInfo objects from a JSON file
//    public static List<UserInfo> loadUserListFromFile(String filePath) throws IOException {
//        ObjectMapper objectMapper = new ObjectMapper();
//        return objectMapper.readValue(new File(filePath), new TypeReference<List<UserInfo>>() {});
//    }
//    
//
//    public static void main(String[] args) {
//        // Example usage:
//         try {
//            // Create sample UserInfo objects
//            UserInfo user1 = new UserInfo("user123", "5f4dcc3b5aa765d61d8327deb882cf99", "user123@example.com", "1990-05-15");
//            user1.setFriendsIDs(List.of("user456", "user789", "user101"));
//            user1.setBlockedAccountsIDs(List.of("post001", "post002"));
//            user1.setPostsIDs(List.of("post001", "post002"));
//            user1.setBio("Just another tech enthusiast exploring the world!");
//            user1.setStatus("Active");
//            user1.setProfilePhotoPath("/images/profile123.jpg");
//            user1.setCoverPhotoPath("/images/cover123.jpg");
//            user1.setStoriesIDs(List.of("story001", "story002"));
//
//            UserInfo user2 = new UserInfo("user456", "e99a18c428cb38d5f260853678922e03", "user456@example.com", "1992-08-25");
//            user2.setFriendsIDs(List.of("user123", "user789"));
//            user2.setBlockedAccountsIDs(List.of("post003"));
//            user2.setPostsIDs(List.of("post003", "post004"));
//            user2.setBio("A curious mind and a coding enthusiast!");
//            user2.setStatus("Active");
//            user2.setProfilePhotoPath("/images/profile456.jpg");
//            user2.setCoverPhotoPath("/images/cover456.jpg");
//            user2.setStoriesIDs(List.of("story003"));
//
//            // Create a list of UserInfo objects
//            List<UserInfo> userList = new ArrayList<>();
//            userList.add(user1);
//            userList.add(user2);
//
//            // Save the user list to a file
//            saveUserListToFile(userList, "user_list.json");
//
//            // Load the user list from the file
//            List<UserInfo> loadedUserList = loadUserListFromFile("user_list.json");
//
//            // Display the loaded user list
//            for (UserInfo user : loadedUserList) {
//                System.out.println(user);
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//}


    // this class was to test the interfaces before add User role 
//package com.MediaApp.UserAccountManagement;
//
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.List;
//
//public class UserInfoStorage {
//
//    private final IndividualStorageHandler<UserInfo> individualHandler;
//    private final ListStorageHandler<UserInfo> listHandler;
//
//    public UserInfoStorage(IndividualStorageHandler<UserInfo> individualHandler, ListStorageHandler<UserInfo> listHandler) {
//        this.individualHandler = individualHandler;
//        this.listHandler = listHandler;
//    }
//
//    public static void main(String[] args) {
//        try {
//            // Instantiate the JSON storage handler
//            JsonStorageHandler<UserInfo> jsonHandler = new JsonStorageHandler<>(UserInfo.class);
//            UserInfoStorage userInfoStorage = new UserInfoStorage(jsonHandler, jsonHandler);
//
//            // Create a sample UserInfo object
//            UserInfo user = new UserInfo("user123", "5f4dcc3b5aa765d61d8327deb882cf99", "user123@example.com", "1990-05-15");
//            user.setBio("Just another tech enthusiast exploring the world!");
//            user.setStatus("Active");
//            UserInfo user2 = new UserInfo("user456", "e99a18c428cb38d5f260853678922e03", "user456@example.com", "1992-08-25");
//            user2.setFriendsIDs(List.of("user123", "user789"));
//            user2.setBlockedAccountsIDs(List.of("post003"));
//            
//            
//            // Save the user to a file
//            String singleUserFilePath = "user123.json";
//            userInfoStorage.individualHandler.save(user, singleUserFilePath);
//
//            // Load the user from the file
//            UserInfo loadedUser = userInfoStorage.individualHandler.load(singleUserFilePath);
//            System.out.println("====Loaded User: " + loadedUser);
//            
/////////--------------------------------------------------------------------
//            // Create a list of UserInfo objects
//            List<UserInfo> userList = new ArrayList<>();
//            userList.add(user);
//            userList.add(user2);
//
////            // Save the list to a file
//            String userListFilePath = "users.json";
//            userInfoStorage.listHandler.saveList(userList, userListFilePath);
//            System.out.println("Saving user list: " + userList);
//
//            // Load the list from the file
//            List<UserInfo> loadedUsers = userInfoStorage.listHandler.loadList(userListFilePath);
//            System.out.println("+++Loaded Users: " + loadedUsers);
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//}
//
