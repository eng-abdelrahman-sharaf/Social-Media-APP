package com.MediaApp.RelationsManagement;

import com.MediaApp.UserAccountManagement.IUserInfo;

public interface IFriendRequestsManager {
    public void sendFriendRequest(IUserInfo sender , IUserInfo receiver ) throws Exception;
    public void declineFriendRequest(IUserInfo sender , IUserInfo receiver );
    public void acceptFriendRequest(IUserInfo sender , IUserInfo receiver );
}