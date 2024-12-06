package com.MediaApp.ContentManagement;

import com.MediaApp.DataHandlers.IDataObject;

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
    public Medium clone() {
        try {
            return (Medium) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException("not cloneable");
        }
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
