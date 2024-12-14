/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package resources.com.MediaApp.Group;

import com.MediaApp.UserAccountManagement.IUserInfo;
import com.MediaApp.UserAccountManagement.UserRoleDataBase;

import java.util.ArrayList;
import java.util.List;

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
            UserRoleDataBase userDB =  UserRoleDataBase.getInstance(null);
            group.getRequestsUserIDs().remove(userId);
            IUserInfo userInfo = (IUserInfo) userDB.readObject(userId);
            List<String> groupsIDs  = userInfo.getJoinedGroups();
            groupsIDs.add(groupId);
            userInfo.setJoinedGroups(groupsIDs);
            userDB.update(userId , userInfo);
            repository.update(groupId, group);
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