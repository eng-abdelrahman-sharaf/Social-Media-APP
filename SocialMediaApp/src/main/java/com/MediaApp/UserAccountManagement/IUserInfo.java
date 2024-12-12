package com.MediaApp.UserAccountManagement;

import com.MediaApp.DataHandlers.IDataObject;
import com.MediaApp.SearchEngines.INamedDataObject;

import java.util.ArrayList;
import java.util.List;

public interface IUserInfo extends INamedDataObject {

    public String getUserID();

    public void setUserID(String userID);

    public String getUserName();

    public void setUserName(String userName);
    public List<String> getFriendsIDs();

    public void setFriendsIDs(List<String> friendsIDs);

    public List<String> getBlockedAccountsIDs();

    public void setBlockedAccountsIDs(List<String> blockedAccountsIDs);

    public List<String> getPostsIDs();

    public void setPostsIDs(List<String> postsIDs);

    public String getBio();

    public void setBio(String bio);

    public String getHashedPassword();

    public void setHashedPassword(String hashedPassword);

    public String getStatus();

    public void setStatus(String status);

    public String getEmail();

    public void setEmail(String email);

    public String getDateOfBirth();

    public void setDateOfBirth(String dateOfBirth);

    public String getProfilePhotoPath();

    public void setProfilePhotoPath(String profilePhotoPath);

    public String getCoverPhotoPath();

    public void setCoverPhotoPath(String coverPhotoPath);

    public List<String> getStoriesIDs();

    public void setStoriesIDs(List<String> storiesIDs);
    public List<String> getFriendsREquest();
    public void addFrinedRequestId(String id );
    public void removeFirndREuest(String id );
    public void setFriendsREquest(List<String> friendsREquest);
    public UserInfo  clone();
    public String toString();




}
