package com.MediaApp.ContentManagement;

import java.time.Instant;

/**
 *
 * @author ADMIN
 */
public interface IMedium {
    String getID();
    String getAuthorID();
    IContent getContent();
    Instant getTimeStamp();
    void setID(String ID);
    void setAuthorID(String AuthorID);
    void setTimeStamp(Instant timeStamp);
    void setContent(IContent content);
}
