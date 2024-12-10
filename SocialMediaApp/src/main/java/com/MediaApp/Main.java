/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.MediaApp;

//import com.MediaApp.GUI.App;

import com.MediaApp.ContentManagement.*;
import com.MediaApp.DataHandlers.*;
import com.MediaApp.NewsFeed.NewsFeedApp;
import com.MediaApp.UserAccountManagement.AuthorizedUserGetter;
import com.MediaApp.UserAccountManagement.IUserInfo;
import com.MediaApp.UserAccountManagement.UserInfoClassType;
import com.MediaApp.UserAccountManagement.UserRoleDataBase;

/**
 *
 * @author ADMIN
 */
public class Main {
    public static void dataLoading(){
        String postFilePath = "post.json";
        String storyFilePath = "story.json";
        String userFilePath = "user.json";
        // Create a storage handler for the HashMap
        MapStorageHandler<String, IPost> postHandler = new JsonMapStorageHandler<>(String.class, PostClassType.type, postFilePath);
        MapStorageHandler<String, IStory> storyHandler = new JsonMapStorageHandler<>(String.class, StoryClassType.type, storyFilePath);
        MapStorageHandler<String, IUserInfo> userHandler = new JsonMapStorageHandler<>(String.class, UserInfoClassType.type, userFilePath);
        // Get the singleton instance of UserRoleDataBase
        PostDataBase.getInstance(postHandler);
        StoryDataBase.getInstance(storyHandler);
//        UserInfo user = new UserInfo();
//        user.setBio("bio");
        UserRoleDataBase.getInstance(userHandler);
    }

    public static void main(String[] args) {
        dataLoading();
        //for testing only
        //will be handled through login page
        AuthorizedUserGetter.getInstance().setUserInfo((IUserInfo) UserRoleDataBase.getInstance(null).getData()[0]);
        NewsFeedApp.main(null);
    }
}
