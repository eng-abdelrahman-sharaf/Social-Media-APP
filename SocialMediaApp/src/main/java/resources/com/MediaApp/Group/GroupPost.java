/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package resources.com.MediaApp.Group;

/**
 *
 * @author ay654
 */
import com.MediaApp.ContentManagement.Content;
import com.MediaApp.DataHandlers.IDataObject;

import java.time.Instant;
import java.util.UUID;

public class GroupPost implements IDataObject {
    private String postId;
    private String groupId;
    private String authorId;
    private Content content;
    private String timestamp;

    public GroupPost(String groupId, String authorId, Content content) {
        this.postId = UUID.randomUUID().toString();
        this.groupId = groupId;
        this.authorId = authorId;
        this.content = content;
        this.timestamp = Instant.now().toString();
    }

    public GroupPost() {
    }

    public String getPostId() {
        return postId;
    }

    public String getGroupId() {
        return groupId;
    }

    public String getAuthorId() {
        return authorId;
    }

    public Content getContent() {
        return content;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setContent(Content content) {
        this.content = content;
    }

    @Override
    public String getID() {
        return postId;
    }

    @Override
    public void setID(String ID) {
        this.postId = ID;
    }

    @Override
    public GroupPost clone() {
        GroupPost cloned = new GroupPost();
        cloned.setID(this.postId);
        cloned.groupId = this.groupId;
        cloned.authorId = this.authorId;
        cloned.content = this.content;
        cloned.timestamp = this.timestamp;
        return cloned;
    }
}