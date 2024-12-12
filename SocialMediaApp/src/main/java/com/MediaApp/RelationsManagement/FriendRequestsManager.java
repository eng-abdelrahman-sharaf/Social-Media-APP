package com.MediaApp.RelationsManagement;

import com.MediaApp.UserAccountManagement.IUserInfo;

import java.util.ArrayList;
import java.util.List;

public class FriendRequestsManager implements IFriendRequestsManager{

    @Override //User1 sends a Friend request to User2
    public void sendFriendRequest(IUserInfo user1, IUserInfo user2) throws Exception {
        if (user1.getBlockedAccountsIDs().contains(user2.getUserID()) ||
                user2.getBlockedAccountsIDs().contains(user1.getUserID())) {
            throw new Exception("User is in BlockList");
        }
        if (user2.getFriendsREquest().contains(user1.getUserID())) {
            throw new Exception("Friend request already sent");
        }
       List<String> arr = user2.getFriendsREquest();
        arr.add(user1.getUserID());
        user2.setFriendsREquest(arr);
//        user2.addFriendRequest(user1.getUserID());
    }

    @Override //User1 declines the Friend request from user2
    public void declineFriendRequest(IUserInfo user1, IUserInfo user2) {
        if (user1.getFriendsREquest().contains(user2.getUserID())) {
            List<String> arr = user1.getFriendsREquest();
            arr.remove(user2.getUserID());
            user1.setFriendsREquest(arr);
//            user1.removeFriendRequest(user2.getUserID());
        }
    }

    @Override //user1 accepts the friend from user2
    public void acceptFriendRequest(IUserInfo user1, IUserInfo user2) {
        if (user1.getFriendsREquest().contains(user2.getUserID())) {
            List<String> arr = user1.getFriendsIDs();
            arr.add(user2.getUserID());
            user1.setFriendsIDs(arr);
            List<String> arr2 = user2.getFriendsIDs();
            arr2.add(user1.getUserID());
            user2.setFriendsIDs(arr2);
            List<String> arr3 = user1.getFriendsREquest();
            arr3.remove(user2.getUserID());
            user1.setFriendsREquest(arr3);

//
//            user1.addFriend(user2.getUserID());
//            user2.addFriend(user1.getUserID());
//            user1.removeFriendRequest(user2.getUserID());
        }
    }


}
