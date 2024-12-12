//package com.MediaApp.RelationsManagement;
//
//import com.MediaApp.UserAccountManagement.FindObjByIdIMP;
//import com.MediaApp.UserAccountManagement.IUserInfo;
//import com.MediaApp.UserAccountManagement.UserInfo;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class FriendsManager implements IFriendsManager{
//
//   //IN COMPLETE
//   @Override
//   public List<UserInfo> getSuggestedFriends(UserInfo user) {
//       List<UserInfo> suggestedFriends = new ArrayList<>();
//       FindObjByIdIMP findObjByIdIMP = new FindObjByIdIMP();
//       for (String friendID : user.getFriendsIDs()) {
//           UserInfo friend = getUserByID(friendID);
//           for (String mutualFriendID : friend.getFriendsIDs()) {
//               if (!user.getFriendsIDs().contains(mutualFriendID) &&
//                       !user.getBlockedAccountsIDs().contains(mutualFriendID) &&
//                       !user.getUserID().equals(mutualFriendID)) {
//                   suggestedFriends.add(getUserByID(mutualFriendID));
//               }
//           }
//       }
//       return suggestedFriends;
//   }
//
//
//    @Override //User1 unfriends User2
//    public void removeFriend(UserInfo user1, UserInfo user2) {
//        if (user1.getFriendsIDs().contains(user2.getUserID())) {
//
//            List<String> arr = user1.getFriendsIDs();
//            arr.remove(user2.getUserID());
//            user1.setFriendsIDs(arr);
//
//            List<String> arr2 = user2.getFriendsIDs();
//            arr.remove(user1.getUserID());
//            user2.setFriendsIDs(arr);
//
////            user1.removeFriend(user2.getUserID());
////            user2.removeFriend(user1.getUserID());
//        }
//    }
//
//
//    @Override
//    public void removeFriend(IUserInfo user1, IUserInfo user2) {
//
//    }
//
//    @Override
//    public List<IUserInfo> getSuggestedFriends(IUserInfo user) {
//        return List.of();
//    }
//}
