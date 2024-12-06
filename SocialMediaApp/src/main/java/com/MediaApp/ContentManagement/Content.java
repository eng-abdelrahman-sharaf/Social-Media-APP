package com.MediaApp.ContentManagement;

import java.util.ArrayList;

public class Content implements IContent {
    String text;
    String[] attachments;

    public Content() {
    }

    @Override
    public String getText() {
        return text;
    }

    @Override
    public String[] getAttachments() {
        return attachments;
    }

    public void setAttachments(String[] attachments) {
        this.attachments = attachments;
    }

    @Override
    public void setText(String text) {
        this.text = text;
    }

}
