package com.MediaApp.ContentManagement;

class Story extends Medium implements IStory {

    String timeStamp;
    String expirationTime;
    public Story(){
    }


    @Override
    public String getExpirationTime() {
        return this.expirationTime;
    }

    @Override
    public void setExpirationTime(String expirationTime) {
        this.expirationTime = expirationTime;
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
