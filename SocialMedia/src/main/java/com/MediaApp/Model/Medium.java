package com.MediaApp.Model;

import java.time.Instant;

public class Medium implements IMedium{
    String ID;
    String AuthorID;
    IContent content;
    Instant timestamp;
    public Medium(String ID, String AuthorID, IContent content, Instant timestamp) {
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

    public IContent getContent() {
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
    public void setContent(IContent content) {
        this.content = content;
    }
}
