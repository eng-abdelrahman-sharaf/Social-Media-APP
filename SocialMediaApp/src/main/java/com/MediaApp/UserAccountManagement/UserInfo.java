
package com.MediaApp.UserAccountManagement;


import com.MediaApp.DataHandlers.DataObject;
import com.MediaApp.DataHandlers.IDataObject;
import com.MediaApp.SearchEngines.INamedDataObject;

import java.util.ArrayList;
import java.util.List;

public class UserInfo implements IUserInfo {
    private String userID;
    private String userName;
    private List<String> friendsIDs= new ArrayList<>();
    private List<String> blockedAccountsIDs= new ArrayList<>();
    private List<String> postsIDs= new ArrayList<>();
    private String bio;
    private String hashedPassword;
    private String status;
    private String email;
    private String dateOfBirth;
    private String profilePhotoPath;
    private String coverPhotoPath;
    private List<String> storiesIDs= new ArrayList<>();
    private List<String> friendsREquest= new ArrayList<>();
    private List<String> joinedGroups= new ArrayList<>();

    // Constructor 1 using when signup
    public UserInfo(String userID,String userName,String hashedPassword, String email, String dateOfBirth) {
        this.userID = userID;
        this.userName = userName;
        this.hashedPassword = hashedPassword;

        this.email = email;
        this.dateOfBirth = dateOfBirth;


        
    }
    // Constructor 2 
//    public UserInfo(String userID,String userName,List<String> friendsIDs, List<String> blockedAccountsIDs, List<String> postsIDs,
//                String bio, String hashedPassword, String status, String email, String dateOfBirth,
//                String profilePhotoPath, String coverPhotoPath, List<String> storiesIDs) {
//        this.userID = userID;
//        this.userName = userName;
//        this.friendsIDs = friendsIDs != null ? friendsIDs : new ArrayList<>();
//        this.blockedAccountsIDs = blockedAccountsIDs != null ? blockedAccountsIDs : new ArrayList<>();
//        this.postsIDs = postsIDs != null ? postsIDs : new ArrayList<>();
//        this.bio = bio;
//        this.hashedPassword = hashedPassword;
//        this.status = status;
//        this.email = email;
//        this.dateOfBirth = dateOfBirth;
//        this.profilePhotoPath = profilePhotoPath;
//        this.coverPhotoPath = coverPhotoPath;
//        this.storiesIDs = storiesIDs != null ? storiesIDs : new ArrayList<>();
//    }
    // Default constructor JSON used when load
    public UserInfo() {
        
    }

    // Getters and Setters
    
    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }
    
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
    public List<String> getFriendsIDs() {
        return  new ArrayList<>(friendsIDs);
    }

    public void setFriendsIDs(List<String> friendsIDs) {
        this.friendsIDs = friendsIDs;
    }

    public List<String> getBlockedAccountsIDs() {
        return  new ArrayList<>(blockedAccountsIDs);
    }

    public void setBlockedAccountsIDs(List<String> blockedAccountsIDs) {
        this.blockedAccountsIDs = blockedAccountsIDs;
    }

    public List<String> getPostsIDs() {
        return  new ArrayList<>(postsIDs);
    }

    public void setPostsIDs(List<String> postsIDs) {
        this.postsIDs = postsIDs;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getHashedPassword() {
        return hashedPassword;
    }

    public void setHashedPassword(String hashedPassword) {
        this.hashedPassword = hashedPassword;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getProfilePhotoPath() {
        return profilePhotoPath;
    }

    public void setProfilePhotoPath(String profilePhotoPath) {
        this.profilePhotoPath = profilePhotoPath;
    }

    public String getCoverPhotoPath() {
        return coverPhotoPath;
    }

    public void setCoverPhotoPath(String coverPhotoPath) {
        this.coverPhotoPath = coverPhotoPath;
    }

    public List<String> getStoriesIDs() {
        return  new ArrayList<>(storiesIDs);
    }

    public void setStoriesIDs(List<String> storiesIDs) {
        this.storiesIDs = storiesIDs;
    }
    public List<String> getFriendsREquest() {
        return new ArrayList<>(friendsREquest);
    }
    public void addFrinedRequestId(String id ){
        friendsREquest.add(id);

    }
    public void removeFirndREuest(String id ){
        friendsREquest.remove(id);
        
    }
    public void setFriendsREquest(List<String> friendsREquest) {
        this.friendsREquest = friendsREquest;
    }

    public List<String> getJoinedGroups() {
        return  new ArrayList<>(joinedGroups);
    }

    public void setJoinedGroups(List<String> joinedGroups) {
        this.joinedGroups = joinedGroups;
    }

    @Override
    public String getID() {
        return userID;
    }
     @Override
    public void setID(String ID) {
        this.userID =ID;
    }
    
    @Override
    public UserInfo  clone() {
        UserInfo cloned = new UserInfo();
        cloned.setUserID(this.userID);
        cloned.setUserName(this.userName);
        cloned.setHashedPassword(this.hashedPassword);
        cloned.setEmail(this.email);
        cloned.setDateOfBirth(this.dateOfBirth);
        cloned.setBio(this.bio);
        cloned.setStatus(this.status);
        cloned.setProfilePhotoPath(this.profilePhotoPath);
        cloned.setCoverPhotoPath(this.coverPhotoPath);
        
        // Deep clone mutable attributes
        cloned.setFriendsIDs(new ArrayList<>(this.friendsIDs));
        cloned.setBlockedAccountsIDs(new ArrayList<>(this.blockedAccountsIDs));
        cloned.setPostsIDs(new ArrayList<>(this.postsIDs));
        cloned.setStoriesIDs(new ArrayList<>(this.storiesIDs));
        cloned.setFriendsREquest(new ArrayList<>(this.friendsREquest));

        return cloned;
    }
   

    // display user information
    @Override
    public String toString() {
        return "\n[" +
                "userID: '" + userID + '\'' +
                ",userName: '" + userName + '\'' +
                ", friendsIDs=" + friendsIDs +
                ", blockedAccountsIDs=" + blockedAccountsIDs +
                ", postsIDs=" + postsIDs +"\n"+
                ", Bio='" + bio + '\'' +
                ", hashedPassword='" + hashedPassword + '\'' +
                ", status='" + status + '\'' +
                ", email='" + email + '\'' +"\n"+
                ", dateOfBirth='" + dateOfBirth + '\'' +
                ", profilePhotoPath='" + profilePhotoPath + '\'' +
                ", coverPhotoPath='" + coverPhotoPath + '\'' +
                ", storiesIDs=" + storiesIDs +
                ", friendsREquest=" + friendsREquest +
                '}';
    }


    @Override
    public String getName() {
        return this.userName;
    }

    @Override
    public void setName(String name) {
        setUserName(name);
    }
}

