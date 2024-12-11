package com.MediaApp.SignPage;

import com.MediaApp.UserAccountManagement.UserFinder;

public class LoginServiceFactory {
    public LoginService create(UserFinder userFinder) {
        return new LoginServiceImpl(userFinder);
    }
}
