package com.MediaApp.RelationsManagement;

import com.MediaApp.UserAccountManagement.AuthorizedUserGetter;
import com.MediaApp.UserAccountManagement.IUserInfo;
import com.MediaApp.UserAccountManagement.UserRoleDataBase;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class FriendRequestsManager implements IFriendRequestsManager{

    @Override //User1 sends a Friend request to User2
    public void sendFriendRequest(IUserInfo sender , IUserInfo receiver )  {
        IUserInfo user1 = sender;
        IUserInfo user2 = receiver;
        if (user1.getBlockedAccountsIDs().contains(user2.getUserID())){
            JOptionPane.showMessageDialog(null, "this user is in your blocked accounts!");
        }
        else if(user2.getBlockedAccountsIDs().contains(user1.getUserID())) {
            JOptionPane.showMessageDialog(null, "You are blocked by this user");
        }
        else if (user2.getFriendsREquest().contains(user1.getUserID())) {
            JOptionPane.showMessageDialog(null,"Friend request already sent");
        }
        else if(user1.getFriendsIDs().contains(user2.getUserID())) {
            JOptionPane.showMessageDialog(null,"you are already friends");
        }
        else{
            List<String> arr = user2.getFriendsREquest();
            arr.add(user1.getUserID());
            user2.setFriendsREquest(arr);
            UserRoleDataBase.getInstance(null).update(user2.getID() , user2);
        }
    }

    @Override //User1 declines the Friend request from user2
    public void declineFriendRequest(IUserInfo sender , IUserInfo receiver ) {
        IUserInfo user1 = receiver;
        IUserInfo user2 = sender;
        if (user1.getFriendsREquest().contains(user2.getUserID())) {
            List<String> arr = user1.getFriendsREquest();
            arr.remove(user2.getUserID());
            user1.setFriendsREquest(arr);
            UserRoleDataBase.getInstance(null).update(user1.getID() , user1);
        }
    }

    @Override //user1 accepts the friend from user2
    public void acceptFriendRequest(IUserInfo sender , IUserInfo receiver ) {
        IUserInfo user1 = receiver;
        IUserInfo user2 = sender;
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

            UserRoleDataBase.getInstance(null).update(user1.getID() , user1);
            UserRoleDataBase.getInstance(null).update(user2.getID() , user2);
        }
    }


}
