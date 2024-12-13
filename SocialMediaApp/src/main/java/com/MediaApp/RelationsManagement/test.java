package com.MediaApp.RelationsManagement;

import com.MediaApp.UserAccountManagement.AuthorizedUserGetter;
import com.MediaApp.UserAccountManagement.IUserInfo;
import com.MediaApp.UserAccountManagement.UserInfoFactory;
import com.MediaApp.UserAccountManagement.UserRoleDataBase;

import java.util.List;


public class test {
    public static void main(String[] args) {
        UserRoleDataBase userDB=  UserRoleDataBase.getInstance(null);

        // testing blockingManager
        UserInfoFactory userInfoFactory = new UserInfoFactory();
        IUserInfo userInfo = (IUserInfo) userDB.getData()[0];
        IUserInfo blockedUser =  (IUserInfo) userDB.getData()[1];
        AuthorizedUserGetter.getInstance().setUserInfo(userInfo);
        IBlockingManager bm = new BlockingManager();
        bm.unblockUser(blockedUser);

        // testing FriendsRequest Manager (
        // sending to a blocked account
        // sending to unblocked account
        // accepting request
        // )
        FriendRequestsManager fm = new FriendRequestsManager();
        fm.sendFriendRequest(userDB.getData()[0] , userDB.getData()[1]);

        // testing FriendsManager
        FriendsManager fm2 = new FriendsManager();
        System.out.println(fm2.getSuggestedFriends(userDB.getData()[0]));
        fm2.removeFriend(userDB.getData()[0] , userDB.getData()[1]);
    }
}
