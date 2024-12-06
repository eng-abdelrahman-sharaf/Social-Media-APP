package com.MediaApp.ContentManagement;

import com.MediaApp.DataHandlers.IDataObject;

import java.time.Instant;

/**
 *
 * @author ADMIN
 */
public interface IMedium extends IDataObject {
    String getAuthorID();
    Content getContent();
    String getTimeStamp();
    void setAuthorID(String AuthorID);
    void setTimeStamp(String timeStamp);
    void setContent(Content content);
}
