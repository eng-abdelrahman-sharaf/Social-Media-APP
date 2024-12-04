package com.MediaApp.ContentManagement;

import java.util.ArrayList;

public class imageEnhancedContent implements IContent {
    String text;
    ArrayList<String> images;

    imageEnhancedContent(String text) {
        images = new ArrayList<>();
        setText(text);
    }

    @Override
    public String getText() {
        return text;
    }

    @Override
    public String[] getAttachments() {
        return images.toArray(String[]::new);
    }

    @Override
    public void setText(String text) {
        this.text = text;
    }

    @Override
    public void addAttachment(String filename) {
        images.add(filename);
    }
}
