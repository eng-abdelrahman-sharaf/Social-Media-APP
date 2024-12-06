/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.MediaApp;

//import com.MediaApp.GUI.App;

import com.MediaApp.ContentManagement.Post;
import com.MediaApp.ContentManagement.Story;
import com.MediaApp.DataHandlers.*;
import com.MediaApp.UserAccountManagement.UserInfo;
import com.MediaApp.UserAccountManagement.UserRoleDataBase;

/**
 *
 * @author ADMIN
 */
public class Main {
    public static void dataLoading(){
        String postFilePath = "post.json";
        String storyFilePath = "story.json";
        String userFilePath = "/user.json";
        // Create a storage handler for the HashMap
        MapStorageHandler<String, Post> postHandler = new JsonMapStorageHandler<>(String.class, Post.class, postFilePath);
        MapStorageHandler<String, Story> storyHandler = new JsonMapStorageHandler<>(String.class, Story.class, storyFilePath);
        MapStorageHandler<String, UserInfo> userHandler = new JsonMapStorageHandler<>(String.class, UserInfo.class, userFilePath);
        // Get the singleton instance of UserRoleDataBase
        PostDataBase.getInstance(postHandler);
        StoryDataBase.getInstance(storyHandler);
        UserInfo user = new UserInfo();
        user.setBio("bio");
        UserRoleDataBase.getInstance(userHandler).addObject(user);

    }
}
