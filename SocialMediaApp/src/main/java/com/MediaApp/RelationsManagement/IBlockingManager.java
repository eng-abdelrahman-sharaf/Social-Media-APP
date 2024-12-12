package com.MediaApp.RelationsManagement;

import com.MediaApp.UserAccountManagement.IUserInfo;

public interface IBlockingManager {
    public void blockUser( IUserInfo user );
    public void unblockUser( IUserInfo user2 );
}
