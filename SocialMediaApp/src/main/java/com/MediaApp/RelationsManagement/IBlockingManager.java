package com.MediaApp.RelationsManagement;

import com.MediaApp.UserAccountManagement.IUserInfo;

public interface IBlockingManager {
    public void blockUser(IUserInfo user1, IUserInfo user2);
    public void unblockUser(IUserInfo user1, IUserInfo user2);
}
