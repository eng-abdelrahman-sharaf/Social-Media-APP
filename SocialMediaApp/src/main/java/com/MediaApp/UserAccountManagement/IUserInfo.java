package com.MediaApp.UserAccountManagement;

import com.MediaApp.DataHandlers.IDataObject;
import com.MediaApp.SearchEngines.INamedDataObject;

import java.io.Serializable;
import java.util.List;

public interface IUserInfo extends INamedDataObject {
    // Getters and setters
    String getUserID();
    void setUserID(String userID);

    String getUserName();
    void setUserName(String userName);

    List<String> getFriendsIDs();
    void setFriendsIDs(List<String> friendsIDs);

    List<String> getBlockedAccountsIDs();
    void setBlockedAccountsIDs(List<String> blockedAccountsIDs);

    List<String> getPostsIDs();
    void setPostsIDs(List<String> postsIDs);

    String getBio();
    void setBio(String bio);

    String getHashedPassword();
    void setHashedPassword(String hashedPassword);

    String getStatus();
    void setStatus(String status);

    String getEmail();
    void setEmail(String email);

    String getDateOfBirth();
    void setDateOfBirth(String dateOfBirth);

    String getProfilePhotoPath();
    void setProfilePhotoPath(String profilePhotoPath);

    String getCoverPhotoPath();
    void setCoverPhotoPath(String coverPhotoPath);

    List<String> getStoriesIDs();
    void setStoriesIDs(List<String> storiesIDs);

    List<String> getFriendsREquest();
    void setFriendsREquest(List<String> friendsREquest);

    List<String> getJoinedGroups();
    void setJoinedGroups(List<String> joinedGroups);

    // Method for cloning
    IUserInfo clone();

    // Methods for displaying and getting name
    String getName();
    void setName(String name);

    // Method for getting ID
    String getID();
    void setID(String ID);

    // Optional: Method to add and remove friend requests
    void addFrinedRequestId(String id);
    void removeFirndREuest(String id);
}
