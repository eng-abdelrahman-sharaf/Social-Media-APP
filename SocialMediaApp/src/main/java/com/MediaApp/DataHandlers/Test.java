package com.MediaApp.DataHandlers;

import com.MediaApp.ContentManagement.*;
import com.MediaApp.UserAccountManagement.IUserInfo;
import com.MediaApp.UserAccountManagement.UserRoleDataBase;

import java.time.Instant;

public class Test {
    public static void main(String[] args) {


        // creating database
        String filePath = "post.json";
        // Create a storage handler for the HashMap
        MapStorageHandler<String, IPost> storageHandler = new JsonMapStorageHandler<>(String.class, PostClassType.type, filePath);
        // Get the singleton instance of UserRoleDataBase
        PostDataBase postdb = PostDataBase.getInstance(storageHandler);

        // creating post
        Content content = new Content();
        content.setText("apwldp[wkfoawmjopamnfomwaopfmaw[f[pawkmf[wpamfwap[mfp[awmf[pawlkfdp[aw [kwa[p kw[pfak [pkwap[f lkwap[ kp[wkaf [pk[p k [pkawp[ k[pdwakp[ fkw[ap");
        content.setAttachments(new String[]{"/com/gui/content_mangement_components/cover.jpg","/com/gui/content_mangement_components/cover.jpg","/com/gui/content_mangement_components/cover.jpg"});

        PostFactory postFactory = new PostFactory();
        IPost post = postFactory.createMedium("4613646" , "4f6a68w" , content , String.valueOf(Instant.now()));

        postdb.addObject(post);
        postdb.addObject(post);
        postdb.addObject(post);
        postdb.addObject(post);

//        MapStorageHandler<String , IGroupPost> groupsHandler = new JsonMapStorageHandler<>(String.class , GroupPostClassType.type, "group-posts.json" );
//        GroupPostDataBase.getInstance(groupsHandler).addObject();
    }
}
