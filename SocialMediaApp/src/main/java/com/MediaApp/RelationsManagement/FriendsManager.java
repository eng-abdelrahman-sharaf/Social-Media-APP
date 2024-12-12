package com.MediaApp.RelationsManagement;

import com.MediaApp.UserAccountManagement.FindObjByIdIMP;
import com.MediaApp.UserAccountManagement.IUserInfo;
import com.MediaApp.UserAccountManagement.UserFinderFactory;
import com.MediaApp.UserAccountManagement.UserRoleDataBase;

import java.util.ArrayList;
import java.util.List;

public class FriendsManager implements IFriendsManager{

   //IN COMPLETE
   @Override
   public List<IUserInfo> getSuggestedFriends(IUserInfo user) {
       List<IUserInfo> suggestedFriends = new ArrayList<>();
       for (String friendID : user.getFriendsIDs()) {
           IUserInfo friend = UserRoleDataBase.getInstance(null).readObject(friendID);
           for (String mutualFriendID : friend.getFriendsIDs()) {
               if (!user.getFriendsIDs().contains(mutualFriendID) &&
                   !user.getBlockedAccountsIDs().contains(mutualFriendID) &&
                   !user.getUserID().equals(mutualFriendID)) {
                   suggestedFriends.add(UserRoleDataBase.getInstance(null).readObject(mutualFriendID));
               }
           }
       }
       return suggestedFriends;
   }


    @Override //User1 unfriends User2
    public void removeFriend(IUserInfo user1, IUserInfo user2) {
        if (user1.getFriendsIDs().contains(user2.getUserID())) {

            List<String> arr = user1.getFriendsIDs();
            arr.remove(user2.getUserID());
            user1.setFriendsIDs(arr);

            List<String> arr2 = user2.getFriendsIDs();
            arr.remove(user2.getUserID());
            user2.setFriendsIDs(arr);

            UserRoleDataBase.getInstance(null).update(user1.getID() , user1);
            UserRoleDataBase.getInstance(null).update(user2.getID() , user2);
        }
    }


}
