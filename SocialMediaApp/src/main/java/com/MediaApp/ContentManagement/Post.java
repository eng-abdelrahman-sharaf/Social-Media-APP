package com.MediaApp.ContentManagement;

class Post extends Medium implements IPost {
    private String timeStamp;

    public Post() {
    }

    @Override
    public String getTimeStamp() {
        return timeStamp;
    }

    @Override
    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }

}
