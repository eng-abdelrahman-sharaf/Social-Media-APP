package com.MediaApp.ContentManagement;

public class GroupPost extends Medium implements IGroupPost {
    private String groupID;
    private String timeStamp;
    private String type = "com.MediaApp.ContentManagement.GroupPost";

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

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
