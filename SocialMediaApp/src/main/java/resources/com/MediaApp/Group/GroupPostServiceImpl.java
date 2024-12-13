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
import com.MediaApp.ContentManagement.GroupPostFactory;
import com.MediaApp.ContentManagement.IGroupPost;
import com.MediaApp.ContentManagement.IMediumFactory;

import java.time.Instant;

public class GroupPostServiceImpl implements GroupPostService {
    private final GroupRepository repository = GroupRepository.getInstance(null);

    @Override
    public void addPost(String groupId, String authorId, Content content) {
        IGroup group = repository.readObject(groupId);
        if (group != null && (group.getMemberIds().contains(authorId))) {
            IGroupPost post = new GroupPostFactory().create(authorId, content , Instant.now().toString() , groupId);
            group.getPosts().add(post);
            repository.save(group);
        } else {
            System.out.println(groupId + "," + authorId);
            throw new IllegalArgumentException("User is not a member of the group or group not found.");
        }
    }

    @Override
    public void editPost(String groupId, String postId, String userId, Content newContent) {
        IGroup group = repository.readObject(groupId);
        if (group != null) {
            IGroupPost post = findPost(group, postId);
            if (post != null) {
                if (group.getAdminIds().contains(userId) || group.getPrimaryAdminId().equals(userId)) {
                    post.setContent(newContent);
                    repository.save(group);
                } else {
                    throw new IllegalArgumentException("User is not authorized to edit this post.");
                }
            } else {
                throw new IllegalArgumentException("Post not found in the group.");
            }
        } else {
            throw new IllegalArgumentException("Group not found.");
        }
    }

    @Override
    public void deletePost(String groupId, String postId, String userId) {
        IGroup group = repository.readObject(groupId);
        if (group != null) {
            IGroupPost post = findPost(group, postId);
            if (post != null) {
                if (group.getAdminIds().contains(userId) || group.getPrimaryAdminId().equals(userId)) {
                    group.getPosts().remove(post);
                    repository.save(group);
                } else {
                    throw new IllegalArgumentException("User is not authorized to delete this post.");
                }
            } else {
                throw new IllegalArgumentException("Post not found in the group.");
            }
        } else {
            throw new IllegalArgumentException("Group not found.");
        }
    }

    private IGroupPost findPost(IGroup group, String postId) {
        return group.getPosts().stream()
                .filter(post -> post.getID().equals(postId))
                .findFirst()
                .orElse(null);
    }
}