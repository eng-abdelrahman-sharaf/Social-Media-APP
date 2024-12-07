package com.MediaApp.UserAccountManagement;

public class AuthorizedUserGetter {
    private static AuthorizedUserGetter instance;
    private UserInfo userInfo;
    private AuthorizedUserGetter() {}
    public static AuthorizedUserGetter getInstance() {
        if(instance == null) {
            instance = new AuthorizedUserGetter();
        }
        return instance;
    }

    public UserInfo getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }
}
