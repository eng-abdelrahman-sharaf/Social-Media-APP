package com.MediaApp.ContentManagement;

import java.time.Instant;

public class PostFactory implements IMediumFactory{

    String ID;
    String AuthorID;
    Content content;
    String timestamp;

    public PostFactory(String ID, String AuthorID, Content content, String timestamp) {
        this.ID = ID;
        this.AuthorID = AuthorID;
        this.content = content;
        this.timestamp = timestamp;
    }

    @Override
    public Post createMedium() {
        Post post = new Post();
        post.setID(ID);
        post.setAuthorID(AuthorID);
        post.setContent(content);
        post.setTimeStamp(timestamp);
        return post;
    }

}
