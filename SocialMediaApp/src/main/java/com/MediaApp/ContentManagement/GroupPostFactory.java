package com.MediaApp.ContentManagement;

import java.util.UUID;

public class GroupPostFactory {
    public IGroupPost create(String AuthorID, Content content, String timestamp , String groupID) {
        GroupPost groupPost =  new GroupPost();
        groupPost.setID(UUID.randomUUID().toString());
        groupPost.setAuthorID(AuthorID);
        groupPost.setContent(content);
        groupPost.setTimeStamp(timestamp);
        groupPost.setGroupID(groupID);
        return groupPost;
    }
}
