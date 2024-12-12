
package com.MediaApp.UserAccountManagement;

import com.MediaApp.SearchEngines.NamedFinder;

/**
 *
 * @author abdah
 */
public interface UserFinder extends NamedFinder {
    IUserInfo findUserByUserName(String userName);
    IUserInfo findUserByEmail(String email);
}
