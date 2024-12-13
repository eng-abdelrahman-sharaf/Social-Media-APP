/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package resources.com.MediaApp.Group;

/**
 *
 * @author ay654
 */
public class GroupDeletionService {
    private final GroupRepository repository = GroupRepository.getInstance(null);

    public void deleteGroup(String groupId, String userId) {
        IGroup group = repository.readObject(groupId);
        if (group.getPrimaryAdminId().equals(userId)) {
            repository.deleteObject(groupId);
        } else {
            throw new IllegalArgumentException("Only the primary admin can delete the group.");
        }
    }
}