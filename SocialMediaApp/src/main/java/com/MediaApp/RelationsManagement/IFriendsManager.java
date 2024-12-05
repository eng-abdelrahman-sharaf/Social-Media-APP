package com.MediaApp.RelationsManagement;

import com.MediaApp.UserAccountManagement.UserInfo;

import java.util.List;

public interface IFriendsManager {
    public void removeFriend(UserInfo user1, UserInfo user2);
    public List<UserInfo> getSuggestedFriends(UserInfo user);
}
