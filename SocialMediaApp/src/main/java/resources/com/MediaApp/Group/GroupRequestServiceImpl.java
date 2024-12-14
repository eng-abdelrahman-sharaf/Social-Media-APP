package resources.com.MediaApp.Group;

import com.MediaApp.DataHandlers.IDataBase;
import com.MediaApp.UserAccountManagement.IUserInfo;
import com.MediaApp.UserAccountManagement.UserRoleDataBase;

public class GroupRequestServiceImpl implements GroupRequestService {

    private GroupRepository groupRepository = GroupRepository.getInstance(null);
    private IDataBase userRoleDataBase;
    public GroupRequestServiceImpl(IDataBase userRoleDataBase) {
        this.userRoleDataBase = userRoleDataBase;
    }

    @Override
    public void SendJoinRequest(String groupID, String userID) {
        IGroup group = groupRepository.readObject(groupID);
        IUserInfo userInfo = (IUserInfo) userRoleDataBase.readObject(userID);
        if(group != null && userInfo != null) {
            group.getRequestsUserIDs().add(userID);
            System.out.println(group.getRequestsUserIDs());
            groupRepository.update(group.getID() , group);
        }
        else {
            throw new IllegalArgumentException("User or Group doesn't exist");
        }
    }
}
