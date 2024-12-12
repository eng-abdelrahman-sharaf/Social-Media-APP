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
public class GroupPostServiceImpl implements GroupPostService {
    private final GroupRepository repository = GroupRepository.getInstance();

    @Override
    public void addPost(String groupId, String authorId, Content content) {
        Group group = repository.findById(groupId);
        if (group != null && group.getMemberIds().contains(authorId)) {
            GroupPost post = new GroupPost(groupId, authorId, content);
            group.getPosts().add(post);
            repository.save(group);
        } else {
            throw new IllegalArgumentException("User is not a member of the group or group not found.");
        }
    }

    @Override
    public void editPost(String groupId, String postId, String userId, Content newContent) {
        Group group = repository.findById(groupId);
        if (group != null) {
            GroupPost post = findPost(group, postId);
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
        Group group = repository.findById(groupId);
        if (group != null) {
            GroupPost post = findPost(group, postId);
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

    private GroupPost findPost(Group group, String postId) {
        return group.getPosts().stream()
                .filter(post -> post.getPostId().equals(postId))
                .findFirst()
                .orElse(null);
    }
}