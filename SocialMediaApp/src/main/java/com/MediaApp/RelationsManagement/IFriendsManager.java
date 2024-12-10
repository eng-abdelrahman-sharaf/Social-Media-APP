package com.MediaApp.RelationsManagement;

import com.MediaApp.UserAccountManagement.IUserInfo;

import java.util.List;

public interface IFriendsManager {
    public void removeFriend(IUserInfo user1, IUserInfo user2);
    public List<IUserInfo> getSuggestedFriends(IUserInfo user);
}
