package com.MediaApp.RelationsManagement;

import com.MediaApp.UserAccountManagement.UserInfo;

public interface IBlockingManager {
    public void blockUser(UserInfo user1, UserInfo user2);
    public void unblockUser(UserInfo user1, UserInfo user2);
}
