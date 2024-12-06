// this class replaced by UserRoleDataBase





// this clas will be replaced or rewrited 

//package com.MediaApp.UserAccountManagement;
//
////import com.MediaApp.DataHandlers.ListStorageHandler;
//import java.util.ArrayList;
//import java.util.List;
//
//public class UserRole implements UserManager {
//
//
//    private List<UserInfo> userInfoList;
//
//    
//    public UserRole() {
//        this.userInfoList = new ArrayList<>();
//    }
//
//   @Override
//    public void addUser(UserInfo user) {
//        if (user != null) {
//            userInfoList.add(user);
//            System.out.println("User added: " + user.getUserID());
//        } else {
//            System.out.println("Cannot add a null user.");
//        }
//    }
//
//    @Override
//    public List<UserInfo> getUserInfoList() {
//        return new ArrayList<>(userInfoList); // Return a copy to maintain encapsulation
//    }
//    
//    
//     public void saveList(JsonStorageHandler<UserInfo> storageHandler) {
//        try {
//            storageHandler.saveList(userInfoList);
//            System.out.println("User list saved to file.");
//        } catch (Exception e) {
//            System.err.println("Failed to save user list: " + e.getMessage());
//        }
//    }
//
//    
//    // Loads the user list using the provided storage handler
//    public void loadList(JsonStorageHandler<UserInfo> storageHandler) {
//        try {
//            userInfoList = storageHandler.loadList();
//            System.out.println("User list loaded from file.");
//        } catch (Exception e) {
//            System.err.println("Failed to load user list: " + e.getMessage());
//        }
//    }
//
//   
//}
