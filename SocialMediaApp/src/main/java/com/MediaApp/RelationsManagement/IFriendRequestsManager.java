package com.MediaApp.RelationsManagement;

import com.MediaApp.UserAccountManagement.IUserInfo;

public interface IFriendRequestsManager {
    public void sendFriendRequest(IUserInfo user1, IUserInfo user2) throws Exception;
    public void declineFriendRequest(IUserInfo user1, IUserInfo user2);
    public void acceptFriendRequest(IUserInfo user1, IUserInfo user2);
}
