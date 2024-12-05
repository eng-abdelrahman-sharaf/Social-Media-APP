package com.MediaApp.RelationsManagement;

import com.MediaApp.UserAccountManagement.UserInfo;

public class FriendRequestsManager implements IFriendRequestsManager{

    @Override //User1 sends a Friend request to User2
    public void sendFriendRequest(UserInfo user1, UserInfo user2) throws Exception {
        if (user1.getBlockedAccountsIDs().contains(user2.getUserID()) ||
                user2.getBlockedAccountsIDs().contains(user1.getUserID())) {
            throw new Exception("User is in BlockList");
        }
        if (user2.getFriendsREquest().contains(user1.getUserID())) {
            throw new Exception("Friend request already sent");
        }
        user2.addFriendRequest(user1.getUserID());
    }

    @Override //User1 declines the Friend request from user2
    public void declineFriendRequest(UserInfo user1, UserInfo user2) {
        if (user1.getFriendsREquest().contains(user2.getUserID())) {
            user1.removeFriendRequest(user2.getUserID());
        }
    }

    @Override //user1 accepts the friend from user2
    public void acceptFriendRequest(UserInfo user1, UserInfo user2) {
        if (user1.getFriendsREquest().contains(user2.getUserID())) {
            user1.addFriend(user2.getUserID());
            user2.addFriend(user1.getUserID());
            user1.removeFriendRequest(user2.getUserID());
        }
    }


}
