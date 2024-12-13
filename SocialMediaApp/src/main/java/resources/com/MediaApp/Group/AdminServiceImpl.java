/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package resources.com.MediaApp.Group;

/**
 *
 * @author ay654
 */
public class AdminServiceImpl implements AdminService {
    private final GroupRepository repository = GroupRepository.getInstance(null);

    @Override
    public void approveMembership(String groupId, String userId) {
        IGroup group = (IGroup)repository.readObject(groupId);
        if (!group.getMemberIds().contains(userId)) {
            group.getMemberIds().add(userId);
        } else {
            throw new IllegalArgumentException("User is already a member of the group.");
        }
    }

    @Override
    public void removeMember(String groupId, String memberId) {
        IGroup group = repository.readObject(groupId);
        if (group.getMemberIds().contains(memberId)) {
            group.getMemberIds().remove(memberId);
        } else {
            throw new IllegalArgumentException("User is not a member of the group.");
        }
    }
}