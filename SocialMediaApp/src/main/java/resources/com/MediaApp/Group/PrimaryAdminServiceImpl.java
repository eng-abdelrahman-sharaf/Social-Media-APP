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

public class PrimaryAdminServiceImpl implements PrimaryAdminService {
    private final GroupRepository repository = GroupRepository.getInstance();
    private final GroupPostService postService = (GroupPostService) new GroupPostServiceImpl();

    @Override
    public void promoteToAdmin(String groupId, String userId) {
        Group group = repository.findById(groupId);
        if (group != null && !group.getAdminIds().contains(userId)) {
            group.getAdminIds().add(userId);
            repository.save(group);
        } else {
            throw new IllegalArgumentException("User is already an admin or group not found.");
        }
    }

    @Override
    public void demoteAdmin(String groupId, String adminId) {
        Group group = repository.findById(groupId);
        if (group != null && group.getAdminIds().contains(adminId) && !group.getPrimaryAdminId().equals(adminId)) {
            group.getAdminIds().remove(adminId);
            repository.save(group);
        } else {
            throw new IllegalArgumentException("User is not an admin or is the primary admin or group not found.");
        }
    }

    @Override
    public void removeMember(String groupId, String memberId) {
        Group group = repository.findById(groupId);
        if (group != null && group.getMemberIds().contains(memberId)) {
            group.getMemberIds().remove(memberId);
            repository.save(group);
        } else {
            throw new IllegalArgumentException("User is not a member of the group or group not found.");
        }
    }

    @Override
    public void deleteGroup(String groupId) {
        Group group = repository.findById(groupId);
        if (group != null) {
            repository.delete(groupId);
        } else {
            throw new IllegalArgumentException("Group not found.");
        }
    }

    @Override
    public void editPost(String groupId, String postId, String userId, Content newContent) {
        postService.editPost(groupId, postId, userId, newContent);
    }

    @Override
    public void deletePost(String groupId, String postId, String userId) {
        postService.deletePost(groupId, postId, userId);
    }
}