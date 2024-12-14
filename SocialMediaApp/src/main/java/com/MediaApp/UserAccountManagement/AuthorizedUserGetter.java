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
        return UserRoleDataBase.getInstance(null).readObject(userInfo.getUserID());
    }

    public void setUserInfo(IUserInfo userInfo) {
        this.userInfo = userInfo;
    }
}
