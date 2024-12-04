
package com.MediaApp.UserAccountManagement;

/**
 *
 * @author abdah
 */
public interface UserFinder {
    UserInfo findUserByUserName(String userName);
    UserInfo findUserByEmail(String email);
}
