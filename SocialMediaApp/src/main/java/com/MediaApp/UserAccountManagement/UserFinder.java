
package com.MediaApp.UserAccountManagement;

/**
 *
 * @author abdah
 */
public interface UserFinder {
    IUserInfo findUserByUserName(String userName);
    IUserInfo findUserByEmail(String email);
}
