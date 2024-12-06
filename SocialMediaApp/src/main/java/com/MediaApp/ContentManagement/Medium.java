package com.MediaApp.ContentManagement;

import com.MediaApp.DataHandlers.IDataObject;

import java.time.Instant;

public class Medium implements IMedium{
    String ID;
    String AuthorID;
    Content content;
    String timestamp;
    public Medium() {
    }

    @Override
    public String getID() {
        return ID;
    }

    @Override
    public String getAuthorID() {
        return AuthorID;
    }

    public Content getContent() {
        return content;
    }

    @Override
    public String getTimeStamp() {
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
    public void setTimeStamp(String timeStamp) {
        this.timestamp = timeStamp;
    }

    @Override
    public void setContent(Content content) {
        this.content = content;
    }
}
