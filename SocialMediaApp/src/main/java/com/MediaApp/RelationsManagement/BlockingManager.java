package com.MediaApp.RelationsManagement;

import com.MediaApp.UserAccountManagement.UserInfo;

public class BlockingManager implements IBlockingManager{
    @Override // user1 blocks user2
    public void blockUser(UserInfo user1, UserInfo user2) {
        if (!user1.getBlockedAccountsIDs().contains(user2.getUserID())) {
            user1.addBlockedAccount(user2.getUserID());
            user1.removeFriend(user2.getUserID());
            user2.removeFriend(user1.getUserID());
        }
    }


    @Override //user1 unblocks user2
    public void unblockUser(UserInfo user1, UserInfo user2) {
        if (user1.getBlockedAccountsIDs().contains(user2.getUserID())) {
            user1.removeBlockedAccount(user2.getUserID());
        }
    }


}
