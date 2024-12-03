package com.programming2.socialmediaapp.contentCreation;

import java.time.Instant;

public class Post implements PermanentMedium{

    String ID;
    String AuthorID;
    Content content;
    Instant timestamp;
    public Post(String ID, String AuthorID, Content content, Instant timestamp) {
        setID(ID);
        setAuthorID(AuthorID);
        setContent(content);
        setTimeStamp(timestamp);
    }

    @Override
    public String getID() {
        return ID;
    }

    @Override
    public String getAuthorID() {
        return AuthorID;
    }

    @Override
    public Content getContent() {
        return content;
    }

    @Override
    public Instant getTimeStamp() {
        return timestamp;
    }

    @Override
    public void setID(String ID) {
        this.ID = ID;
    }

    @Override
    public void setAuthorID(String AuthorID) {
        this.AuthorID = AuthorID;
    }

    @Override
    public void setTimeStamp(Instant timeStamp) {
        this.timestamp = timeStamp;
    }

    @Override
    public void setContent(Content content) {
        this.content = content;
    }
}
