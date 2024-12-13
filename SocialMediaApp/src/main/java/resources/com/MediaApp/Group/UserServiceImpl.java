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

public class UserServiceImpl implements UserService {
    private final GroupRepository repository = GroupRepository.getInstance();
    private final GroupPostService postService = (GroupPostService) new GroupPostServiceImpl();

    @Override
    public void postToGroup(String groupId, String userId, Content content) {
        postService.addPost(groupId, userId, content);
    }

    @Override
    public void leaveGroup(String groupId, String userId) {
        Group group = repository.findById(groupId);
        if (group != null && group.getMemberIds().contains(userId)) {
            group.getMemberIds().remove(userId);
            repository.save(group);
            System.out.println("User " + userId + " has left the group: " + group.getName());
        } else {
            throw new IllegalArgumentException("User is not a member of this group or group not found.");
        }
    }
}