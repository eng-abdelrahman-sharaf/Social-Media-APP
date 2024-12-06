package com.MediaApp.ContentManagement;

import java.time.Duration;
import java.time.Instant;

public class StoryFactory implements IMediumFactory {
    String ID;
    String AuthorID;
    Content content;
    String timestamp;

    public StoryFactory(String ID, String AuthorID, Content content, String timestamp) {
        this.ID = ID;
        this.AuthorID = AuthorID;
        this.content = content;
        this.timestamp = timestamp;
    }

    @Override
    public Story createMedium() {
        Story story = new Story();
        story.setID(ID);
        story.setAuthorID(AuthorID);
        story.setContent(content);
        story.setTimeStamp(timestamp);
        story.setExpirationTime( String.valueOf( Instant.parse(timestamp).plus( Duration.ofDays(1) ) ) );
        return story;
    }
}
