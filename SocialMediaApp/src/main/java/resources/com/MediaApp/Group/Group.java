/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package resources.com.MediaApp.Group;

/**
 *
 * @author ay654
 */

import com.MediaApp.ContentManagement.GroupPost;
import com.MediaApp.ContentManagement.IGroupPost;
import com.MediaApp.ContentManagement.IMediumFactory;

import java.util.*;

public class Group implements IGroup {
    private String groupId;
    private String name;
    private String description;
    private String groupPhoto;
    private String primaryAdminId;
    private List<String> adminIds = new ArrayList<>();
    private List<String> memberIds = new ArrayList<>();
    private List<String> posts  = new ArrayList<>();
    private List<String> requestsUserIDs = new ArrayList<>();

    private Group(){
    }

    private Group(Builder builder) {
        this.groupId = builder.groupId;
        this.name = builder.name;
        this.description = builder.description;
        this.groupPhoto = builder.groupPhoto;
        this.primaryAdminId = builder.primaryAdminId;
        this.requestsUserIDs = builder.requestsUserIDs;
    }

    @Override
    public String getID() {
        return getGroupId();
    }

    @Override
    public void setID(String ID) {
        this.groupId = ID;
    }

    @Override
    public Group clone() {
        Group group = null;
        try {
            group = (Group) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
        group.setAdminIds(new ArrayList<>(this.adminIds));
        group.setPosts(new ArrayList<>(this.posts));
        group.setRequestsUserIDs(new ArrayList<>(this.requestsUserIDs));
        group.setMemberIds(new ArrayList<>(this.memberIds));
        return group;
    }

    public static class Builder {
        private String groupId;
        private String name;
        private String description;
        private String groupPhoto;
        private String primaryAdminId;
        private List<String> adminIds = new ArrayList<>();
        private List<String> memberIds = new ArrayList<>();
        private List<IGroupPost> posts = new ArrayList<>();
        private List<String> requestsUserIDs = new ArrayList<>();

        public Builder setRequestsUserIDs(List<String> requestsUserIDs) {
            this.requestsUserIDs = requestsUserIDs;
            return this;
        }

        public Builder setGroupId(String groupId) {
            this.groupId = groupId;
            return this;
        }

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setDescription(String description) {
            this.description = description;
            return this;
        }

        public Builder setGroupPhoto(String groupPhoto) {
            this.groupPhoto = groupPhoto;
            return this;
        }

        public Builder setPrimaryAdminId(String primaryAdminId) {
            this.primaryAdminId = primaryAdminId;
            this.adminIds.add(primaryAdminId);
            if(!this.memberIds.contains(primaryAdminId)){this.memberIds.add(primaryAdminId);}
            return this;
        }

        public Builder addMember(String memberId) {
            this.memberIds.add(memberId);
            return this;
        }

        public Builder addAdmin(String adminId) {
            this.adminIds.add(adminId);
            return this;
        }
        
        public Builder addPost(IGroupPost post) {
            this.posts.add(post);
            return this;
        }

        public Builder setPosts(List<IGroupPost> posts) {
            this.posts = posts;
            return this;
        }

        public Group build() {
            return new Group(this);
        }
    }

    @Override
    public String getGroupId() {
        return groupId;
    }

    @Override
    public List<String> getRequestsUserIDs() {
        return requestsUserIDs;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public String getGroupPhoto() {
        return groupPhoto;
    }

    @Override
    public String getPrimaryAdminId() {
        return primaryAdminId;
    }

    @Override
    public List<String> getAdminIds() {
        return adminIds;
    }

    @Override
    public List<String> getMemberIds() {
        return memberIds;
    }

    @Override
    public List<String> getPosts() {
        return posts;
    }


    @Override
    public void setAdminIds(List<String> adminIds) {
        this.adminIds = adminIds;
    }

    @Override
    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    @Override
    public void setGroupPhoto(String groupPhoto) {
        this.groupPhoto = groupPhoto;
    }

    @Override
    public void setMemberIds(List<String> memberIds) {
        this.memberIds = memberIds;
    }

    @Override
    public void setPosts(List<String> posts) {
        this.posts = posts;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void setPrimaryAdminId(String primaryAdminId) {
        this.primaryAdminId = primaryAdminId;
    }

    @Override
    public void setRequestsUserIDs(List<String> requestsUserIDs) {
        this.requestsUserIDs = requestsUserIDs;
    }
}

