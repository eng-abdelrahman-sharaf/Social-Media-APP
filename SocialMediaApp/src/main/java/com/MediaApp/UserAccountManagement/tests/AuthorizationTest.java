package com.MediaApp.UserAccountManagement.tests;

import com.MediaApp.UserAccountManagement.AuthorizedUserGetter;
import com.MediaApp.UserAccountManagement.IUserInfo;
import com.MediaApp.UserAccountManagement.UserInfoFactory;

/**
 * important example for log in and sign up
 */
public class AuthorizationTest {
    private static UserInfoFactory userInfoFactory = new UserInfoFactory();
    public static void main(String[] args) {
        // creation should be made only throw a factory or a builder
        IUserInfo authorizedUser = userInfoFactory.getUserInfo("test" , "testuname" , "123456" , "test.mail.com" , "3/1/2005");
        //setting authorized user
        AuthorizedUserGetter.getInstance().setUserInfo(authorizedUser);
        //getting authorized user
        AuthorizedUserGetter.getInstance().getUserInfo();

    }
}
