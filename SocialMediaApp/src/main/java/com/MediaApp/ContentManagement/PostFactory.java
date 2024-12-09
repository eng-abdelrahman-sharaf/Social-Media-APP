package com.MediaApp.ContentManagement;

import java.time.Instant;

public class PostFactory implements IMediumFactory{


    public PostFactory() {
    }

    @Override
    public IPost createMedium(String ID, String AuthorID, Content content, String timestamp) {
        Post post = new Post();
        post.setID(ID);
        post.setAuthorID(AuthorID);
        post.setContent(content);
        post.setTimeStamp(timestamp);
        return post;
    }

}
