package com.MediaApp.ContentManagement;

/**
 *
 * @author ADMIN
 */
public interface IContent {
    String getText();
    String [] getAttachments();
    void setText(String text);
    void addAttachment(String filename);
}
