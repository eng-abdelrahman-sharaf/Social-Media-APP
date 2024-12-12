package com.MediaApp.UserAccountManagement;

public class AuthorizedUserGetter {
    private static AuthorizedUserGetter instance;
    private IUserInfo userInfo;
    private AuthorizedUserGetter() {}
    public static AuthorizedUserGetter getInstance() {
        if(instance == null) {
            instance = new AuthorizedUserGetter();
        }
        return instance;
    }

    public IUserInfo getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(IUserInfo userInfo) {
        this.userInfo = userInfo;
    }
}
