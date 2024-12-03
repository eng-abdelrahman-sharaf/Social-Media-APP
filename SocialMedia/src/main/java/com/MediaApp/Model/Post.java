package com.MediaApp.Model;

import java.time.Instant;

public class Post extends Medium {
    public Post(String ID, String AuthorID, IContent content, Instant timestamp) {
        super(ID, AuthorID, content, timestamp);
    }
}
