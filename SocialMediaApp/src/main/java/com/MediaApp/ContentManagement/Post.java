package com.MediaApp.ContentManagement;

import java.time.Instant;

public class Post extends Medium implements IPermanentMedium {
    public Post(String ID, String AuthorID, IContent content, Instant timestamp) {
        super(ID, AuthorID, content, timestamp);
    }
}
