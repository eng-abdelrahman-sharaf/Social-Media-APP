package com.MediaApp.ContentManagement;

class GroupPost extends Medium implements IGroupPost {
    private String groupID;
    private String timeStamp;

    @Override
    public String getTimeStamp() {
        return timeStamp;
    }

    @Override
    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }

    @Override
    public String getGroupID() {
        return groupID;
    }

    @Override
    public void setGroupID(String groupID) {
        this.groupID = groupID;
    }
}
