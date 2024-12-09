package com.MediaApp.ContentManagement;

import java.time.Duration;
import java.time.Instant;

public class StoryFactory implements IMediumFactory {

    public StoryFactory() {
    }

    @Override
    public IStory createMedium(String ID, String AuthorID, Content content, String timestamp) {
        Story story = new Story();
        story.setID(ID);
        story.setAuthorID(AuthorID);
        story.setContent(content);
        story.setTimeStamp(timestamp);
        story.setExpirationTime( String.valueOf( Instant.parse(timestamp).plus( Duration.ofDays(1) ) ) );
        return story;
    }
}
