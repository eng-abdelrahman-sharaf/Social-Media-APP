/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package resources.com.MediaApp.Group;

/**
 *
 * @author ay654
 */
import java.util.*;

public class Group {
    private String groupId;
    private String name;
    private String description;
    private String groupPhoto;
    private String primaryAdminId;
    private List<String> adminIds;
    private List<String> memberIds;

    private Group(Builder builder) {
        this.groupId = builder.groupId;
        this.name = builder.name;
        this.description = builder.description;
        this.groupPhoto = builder.groupPhoto;
        this.primaryAdminId = builder.primaryAdminId;
        this.adminIds = builder.adminIds;
        this.memberIds = builder.memberIds;
    }

    public static class Builder {
        private String groupId;
        private String name;
        private String description;
        private String groupPhoto;
        private String primaryAdminId;
        private List<String> adminIds = new ArrayList<>();
        private List<String> memberIds = new ArrayList<>();

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

        public Group build() {
            return new Group(this);
        }
    }

    public String getGroupId() {
        return groupId;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getGroupPhoto() {
        return groupPhoto;
    }

    public String getPrimaryAdminId() {
        return primaryAdminId;
    }

    public List<String> getAdminIds() {
        return adminIds;
    }

    public List<String> getMemberIds() {
        return memberIds;
    }
}
