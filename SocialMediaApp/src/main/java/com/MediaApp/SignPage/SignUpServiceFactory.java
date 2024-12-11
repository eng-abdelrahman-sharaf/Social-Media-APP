package com.MediaApp.SignPage;

import com.MediaApp.DataHandlers.IDataBase;
import com.MediaApp.UserAccountManagement.IUserInfo;
import com.MediaApp.UserAccountManagement.UserFinder;

import java.util.List;

public class SignUpServiceFactory {
    public SignUpService createSignUpService(UserFinder userFinder, DataValidator dataValidator, IDataBase userdb){
        return new SignUpServiceImpl(userFinder , dataValidator , userdb);
    }
}
