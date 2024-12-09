package com.MediaApp.ContentManagement;

public interface IMediumFactory {
    IMedium createMedium(String ID, String AuthorID, Content content, String timestamp);
}
