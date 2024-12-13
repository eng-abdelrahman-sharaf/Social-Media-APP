/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.MediaApp;

//import com.MediaApp.GUI.App;

import com.MediaApp.ContentManagement.*;
import com.MediaApp.DataHandlers.*;
import com.MediaApp.NewsFeed.NewsFeedApp;
import com.MediaApp.ProfileManagement.ProfileApp;
import com.MediaApp.UserAccountManagement.AuthorizedUserGetter;
import com.MediaApp.UserAccountManagement.IUserInfo;
import com.MediaApp.UserAccountManagement.UserInfoClassType;
import com.MediaApp.UserAccountManagement.UserRoleDataBase;
import com.MediaApp.authentication.StartupController;
import com.gui.content_mangement_components.StageGetter;
import resources.com.MediaApp.Group.GroupClassType;
import resources.com.MediaApp.Group.GroupPostService;
import resources.com.MediaApp.Group.GroupRepository;
import resources.com.MediaApp.Group.IGroup;

/**
 *
 * @author ADMIN
 */
public class Main {
    public static void dataLoading(){
        String postFilePath = "post.json";
        String storyFilePath = "story.json";
        String userFilePath = "user.json";
        String groupFilePath = "group.json";
        String groupPostFilePath = "group-posts.json";
        // Create a storage handler for the HashMap
        MapStorageHandler<String, IPost> postHandler = new JsonMapStorageHandler<>(String.class, PostClassType.type, postFilePath);
        MapStorageHandler<String, IStory> storyHandler = new JsonMapStorageHandler<>(String.class, StoryClassType.type, storyFilePath);
        MapStorageHandler<String, IUserInfo> userHandler = new JsonMapStorageHandler<>(String.class, UserInfoClassType.type, userFilePath);
        MapStorageHandler<String, IGroup> groupHandler = new JsonMapStorageHandler<>(String.class, GroupClassType.type, groupFilePath);
        MapStorageHandler<String , IGroupPost> groupPostHandler = new JsonMapStorageHandler<>(String.class, GroupPostClassType.type, groupPostFilePath);
        // Get the singleton instance of UserRoleDataBase
        PostDataBase.getInstance(postHandler);
        StoryDataBase.getInstance(storyHandler);
//        UserInfo user = new UserInfo();
//        user.setBio("bio");
        UserRoleDataBase.getInstance(userHandler);
        GroupRepository.getInstance(groupHandler);
        GroupPostDataBase.getInstance(groupPostHandler);
    }

    public static void main(String[] args) {
        dataLoading();


        // for testing only
        // sign in with abdo Aa1234

        new StartupController().run();


//        ProfileApp profileApp = new ProfileApp();

//        profileApp.start(StageGetter.getInstance().getStage() , UserRoleDataBase.getInstance(null).getData()[0]);

    }
}
