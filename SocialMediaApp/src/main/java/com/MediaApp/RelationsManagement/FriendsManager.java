package com.MediaApp.RelationsManagement;

import com.MediaApp.UserAccountManagement.UserInfo;

import java.util.ArrayList;
import java.util.List;

public class FriendsManager implements IFriendsManager{

   //IN COMPLETE
   @Override
   public List<UserInfo> getSuggestedFriends(UserInfo user) {
       List<UserInfo> suggestedFriends = new ArrayList<>();
       for (String friendID : user.getFriendsIDs()) {
           UserInfo friend = getUserByID(friendID);
           for (String mutualFriendID : friend.getFriendsIDs()) {
               if (!user.getFriendsIDs().contains(mutualFriendID) &&
                       !user.getBlockedAccountsIDs().contains(mutualFriendID) &&
                       !user.getUserID().equals(mutualFriendID)) {
                   suggestedFriends.add(getUserByID(mutualFriendID));
               }
           }
       }
       return suggestedFriends;
   }


    @Override //User1 unfriends User2
    public void removeFriend(UserInfo user1, UserInfo user2) {
        if (user1.getFriendsIDs().contains(user2.getUserID())) {
            user1.removeFriend(user2.getUserID());
            user2.removeFriend(user1.getUserID());
        }
    }


}
