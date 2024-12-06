package com.MediaApp.ContentManagement;

import com.MediaApp.DataHandlers.IDataObject;

import java.time.Instant;

/**
 *
 * @author ADMIN
 */
public interface IMedium extends IDataObject {
    String getAuthorID();
    IContent getContent();
    Instant getTimeStamp();
    void setAuthorID(String AuthorID);
    void setTimeStamp(Instant timeStamp);
    void setContent(IContent content);
}
