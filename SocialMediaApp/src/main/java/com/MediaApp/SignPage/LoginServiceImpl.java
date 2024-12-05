
package com.MediaApp.SignPage;

import com.MediaApp.UserAccountManagement.UserFinder;
import com.MediaApp.UserAccountManagement.UserInfo;
import java.util.Objects;


public class LoginServiceImpl implements LoginService {

    private final UserFinder userFinder;

    public LoginServiceImpl(UserFinder userFinder) {
        this.userFinder = userFinder;
    }

    @Override
    public boolean login(String usernameOrEmail, String password) {
        UserInfo user = null;

        // Check if input is an email or username and find the user
        if (usernameOrEmail.contains("@")) {
            user = userFinder.findUserByEmail(usernameOrEmail);
        } else {
            user = userFinder.findUserByUserName(usernameOrEmail);
        }

        // Return false if user not found
        if (user == null) {
            return false;
        }

        // Validate hashed password 
        return validatePassword(password, user.getHashedPassword());
    }

    // Placeholder for password validation
    private boolean validatePassword(String password, String hashedPassword) {
        // In a real application, you'd use a secure hashing library like BCrypt or Argon2
        return Objects.equals(password, hashedPassword);
//        return Objects.equals(hashPassword(password), hashedPassword);
    }

    // Simulated hashing function
    private String hashPassword(String password) {
        
        return Integer.toHexString(password.hashCode());
    }
}