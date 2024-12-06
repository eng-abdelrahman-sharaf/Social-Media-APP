package com.MediaApp.RelationsManagement;

import com.MediaApp.UserAccountManagement.UserInfo;

public interface IFriendRequestsManager {
    public void sendFriendRequest(UserInfo user1, UserInfo user2) throws Exception;
    public void declineFriendRequest(UserInfo user1, UserInfo user2);
    public void acceptFriendRequest(UserInfo user1, UserInfo user2);
}
