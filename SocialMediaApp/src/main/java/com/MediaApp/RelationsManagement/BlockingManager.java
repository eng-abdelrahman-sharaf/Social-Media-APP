package com.MediaApp.RelationsManagement;

import com.MediaApp.UserAccountManagement.AuthorizedUserGetter;
import com.MediaApp.UserAccountManagement.IUserInfo;
import com.MediaApp.UserAccountManagement.UserRoleDataBase;

import java.util.List;

public class BlockingManager implements IBlockingManager{
    private final UserRoleDataBase userDB;
    public BlockingManager() {
        userDB = UserRoleDataBase.getInstance(null);
    }

    @Override // user1 blocks user2
    public void blockUser(IUserInfo user) {
        IUserInfo user1 = AuthorizedUserGetter.getInstance().getUserInfo();
        IUserInfo user2 = user;
        if (!user1.getBlockedAccountsIDs().contains(user2.getUserID())) {

            //add user1 to blocked
            List<String> arr = user1.getBlockedAccountsIDs();
            arr.add(user2.getUserID());
            user1.setBlockedAccountsIDs(arr);

            //remove user1 from friends list if exists
            List<String> arr2 = user1.getFriendsIDs();
            arr2.remove(user2.getUserID());
            user1.setFriendsIDs(arr2);

            //remove uer1 from user2's friends list if exist
            List<String> arr3 = user2.getFriendsIDs();
            arr3.remove(user1.getUserID());
            user2.setFriendsIDs(arr3);


            userDB.update(user1.getUserID(), user1);
            userDB.update(user2.getUserID(), user2);

//            user1.addBlockedAccount(user2.getUserID());
//            user1.removeFriend(user2.getUserID());
//            user2.removeFriend(user1.getUserID());
        }
    }


    @Override //user1 unblocks user2
    public void unblockUser(IUserInfo user) {
        IUserInfo user1 = AuthorizedUserGetter.getInstance().getUserInfo();
        IUserInfo user2 = user;
        if (user1.getBlockedAccountsIDs().contains(user2.getUserID())) {
            List<String> arr = user1.getBlockedAccountsIDs();
            arr.remove(user2.getUserID());
            user1.setBlockedAccountsIDs(arr);

            userDB.update(user1.getUserID(), user1);
            userDB.update(user2.getUserID(), user2);

//            user1.removeBlockedAccount(user2.getUserID());
        }
    }


}
