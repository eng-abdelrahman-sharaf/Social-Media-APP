package com.MediaApp.Model;

import java.time.Instant;

public class PostFactory implements IMediumFactory{

    String ID;
    String AuthorID;
    IContent content;
    Instant timestamp;

    public PostFactory(String ID, String AuthorID, IContent content, Instant timestamp) {
        this.ID = ID;
        this.AuthorID = AuthorID;
        this.content = content;
        this.timestamp = timestamp;
    }

    @Override
    public Post createMedium() {
        return new Post(ID, AuthorID, content, timestamp);
    }

}
