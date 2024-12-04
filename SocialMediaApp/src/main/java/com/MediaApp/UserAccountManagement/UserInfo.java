
package com.MediaApp.UserAccountManagement;

import java.util.List;

public class UserInfo {
    private String userID;
    private List<String> friendsIDs;
    private List<String> blockedAccountsIDs;
    private List<String> postsIDs;
    private String bio;
    private String hashedPassword;
    private String status;
    private String email;
    private String dateOfBirth;
    private String profilePhotoPath;
    private String coverPhotoPath;
    private List<String> storiesIDs;

    // Constructor 1 using when signup
    public UserInfo(String userID, String hashedPassword, String email, String dateOfBirth) {
        this.userID = userID;
        
        this.hashedPassword = hashedPassword;
        
        this.email = email;
        this.dateOfBirth = dateOfBirth;
        
        
        
    }
    // Constructor 2 using when read from json file .
    public UserInfo(String userID, List<String> friendsIDs, List<String> blockedAccountsIDs, List<String> postsIDs,
                String bio, String hashedPassword, String status, String email, String dateOfBirth,
                String profilePhotoPath, String coverPhotoPath, List<String> storiesIDs) {
        this.userID = userID;
        this.friendsIDs = friendsIDs;
        this.blockedAccountsIDs = blockedAccountsIDs;
        this.postsIDs = postsIDs;
        this.bio = bio;
        this.hashedPassword = hashedPassword;
        this.status = status;
        this.email = email;
        this.dateOfBirth = dateOfBirth;
        this.profilePhotoPath = profilePhotoPath;
        this.coverPhotoPath = coverPhotoPath;
        this.storiesIDs = storiesIDs;
    }
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

    public List<String> getFriendsIDs() {
        return friendsIDs;
    }

    public void setFriendsIDs(List<String> friendsIDs) {
        this.friendsIDs = friendsIDs;
    }

    public List<String> getBlockedAccountsIDs() {
        return blockedAccountsIDs;
    }

    public void setBlockedAccountsIDs(List<String> blockedAccountsIDs) {
        this.blockedAccountsIDs = blockedAccountsIDs;
    }

    public List<String> getPostsIDs() {
        return postsIDs;
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
        return storiesIDs;
    }

    public void setStoriesIDs(List<String> storiesIDs) {
        this.storiesIDs = storiesIDs;
    }

    // display user information
    @Override
    public String toString() {
        return "\n[" +
                "userID: '" + userID + '\'' +
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
                '}';
    }
}


