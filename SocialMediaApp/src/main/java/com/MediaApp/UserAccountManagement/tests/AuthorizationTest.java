package com.MediaApp.UserAccountManagement.tests;

import com.MediaApp.UserAccountManagement.AuthorizedUserGetter;
import com.MediaApp.UserAccountManagement.UserInfo;

/**
 * important example for log in and sign up
 */
public class AuthorizationTest {
    public static void main(String[] args) {
        // creation should be made only throw a factory or a builder
        UserInfo authorizedUser = new UserInfo();
        //setting authorized user
        AuthorizedUserGetter.getInstance().setUserInfo(authorizedUser);
        //getting authorized user
        AuthorizedUserGetter.getInstance().getUserInfo();

    }
}
