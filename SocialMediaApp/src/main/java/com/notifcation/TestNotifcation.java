///*
// * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
// * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
// */
//package com.notifcation;
//
//import com.MediaApp.ContentManagement.Content;
//import com.MediaApp.ContentManagement.IMediumFactory;
//import com.MediaApp.UserAccountManagement.AuthorizedUserGetter;
//import com.MediaApp.UserAccountManagement.IUserInfo;
//import com.MediaApp.UserAccountManagement.UserInfoFactory;
//
//import java.util.List;
//
//import resources.com.MediaApp.Group.Group;
//import resources.com.MediaApp.Group.GroupFactory;
//import resources.com.MediaApp.Group.IGroupFactory;
//
///**
// *
// * @author abdah
// */
//public class TestNotifcation {
//
//    public static void main(String[] args) {
//        // Initialize the notification service and action factory
//        INotificationService notificationService = new NotificationServiceImpl();
//        NotificationActionFactory actionFactory = new NotificationActionFactory();
//
//        // Register the new EventActionProvider
//        actionFactory.registerActionProvider("Event", new EventActionProvider());
//
//        // Create services for different notification types
//        FriendRequestService friendRequestService = new FriendRequestService(notificationService, actionFactory);
//        GroupActivityService groupActivityService = new GroupActivityService(notificationService, actionFactory);
//        PostService postService = new PostService(notificationService, actionFactory);
//
//        UserInfoFactory userInfoFactory = new UserInfoFactory();
//
//
//        // Create some users and a group for testing
//        IUserInfo user1 = userInfoFactory.getUserInfo("1", "Alice", "hashedpassword1", "alice@example.com", "1990-01-01");
//        IUserInfo user2 = userInfoFactory.getUserInfo("2", "Bob", "hashedpassword2", "bob@example.com", "1990-02-01");
//
//
//        // Create a GroupFactory instance and a group for testing
//        IGroupFactory groupFactory = new GroupFactory();
//        Group group = groupFactory.createGroup("Java Developers", "A group for Java enthusiasts", "groupPhoto.jpg",user1.getUserID());
//
//        // Add user2 to the group
//        group.getMemberIds().add(user2.getUserID());
//
//        // Create a post for the group
//        Content content = new Content(); content.setText("Welcome to the Java group!");
//        IMediumFactory.GroupPost post = new IMediumFactory.GroupPost(group.getGroupId(), user1.getUserID(), content);
//
//        // Set the authorized user
//        AuthorizedUserGetter.getInstance().setUserInfo(user1);
//        // Send notifications of different types
//        friendRequestService.sendFriendRequest(user1, user2);
//        groupActivityService.addUserToGroup(user2, group);
//        postService.newGroupPost(group, post);
//
////        System.out.println("1----------------");
//        // Send an event notification
////        INotification eventNotification = new BasicNotification(user2.getUserID(), "You have an upcoming event.", "Event", actionFactory);
////        notificationService.sendNotification(eventNotification);
//        System.out.println("222----------------");
//
//        // Fetch and display notifications for user2
//        List<INotification> notifications = notificationService.getNotifications(user2.getUserID());
//        notifications.forEach(notification -> {
//            System.out.println(notification.getMessage());
//            notification.getActions().forEach((action, url) -> System.out.println(action + ": " + url));
//         });
//
//        System.out.println("444----------------");
//        // Simulate user accepting a friend request
//        notificationService.markNotificationAsRead(user2.getUserID(), "Friend Request");
//
////        // Fetch and display updated notifications for user2
//        List<INotification> updatedNotifications = notificationService.getNotifications(user2.getUserID());
//        updatedNotifications.forEach(notification -> {
//        System.out.println(notification.getMessage());
//        notification.getActions().forEach((action, url) -> System.out.println(action + ": " + url));
//        });
//
//
//
//   IUserInfo authorizedUser = AuthorizedUserGetter.getInstance().getUserInfo();
//   System.out.println("Authorized User: " + authorizedUser.getUserName()); }
//}
//
//
//
//// Action provider for event notifications
////class EventActionProvider implements ActionProvider {
////    @Override
////    public Map<String, String> createActions(String userId) {
////        Map<String, String> actions = new HashMap<>();
////        actions.put("RSVP", "/event/rsvp/" + userId);
////        return actions;
////    }
////}
//
//
//
