package com.MediaApp.UserAccountManagement;

public class UserInfoFactory {

    public UserInfoFactory(){}

    public IUserInfo getUserInfo(String userID,String userName,String hashedPassword, String email, String dateOfBirth) {
        return  new UserInfo(userID,userName,hashedPassword,email,dateOfBirth);
    }
}
