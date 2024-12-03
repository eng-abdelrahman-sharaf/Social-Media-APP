package com.MediaApp.Model;

import java.time.Instant;

public class StoryFactory implements IMediumFactory {
    String ID;
    String AuthorID;
    IContent content;
    Instant timestamp;

    public StoryFactory(String ID, String AuthorID, IContent content, Instant timestamp) {
        this.ID = ID;
        this.AuthorID = AuthorID;
        this.content = content;
        this.timestamp = timestamp;
    }

    @Override
    public Story createMedium() {
        return new Story(ID, AuthorID, content, timestamp);
    }
}
