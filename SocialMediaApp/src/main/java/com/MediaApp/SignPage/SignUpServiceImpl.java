/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.MediaApp.SignPage;

import com.MediaApp.DataHandlers.IDataObject;
import com.MediaApp.UserAccountManagement.UserFinder;
import com.MediaApp.UserAccountManagement.UserInfo;
import com.MediaApp.UserAccountManagement.UserRoleDataBase;
import java.util.List;

public class SignUpServiceImpl implements SignUpService {
    private final UserFinder userFinder;
    private final DataValidator dataValidator;  
    private UserRoleDataBase userRoleDataBaseSignup= UserRoleDataBase.getInstance();
    
    public SignUpServiceImpl(UserFinder userFinder, DataValidator dataValidator) {
        this.userFinder = userFinder;
        this.dataValidator = dataValidator;
    }

    @Override
    public String signUp(String userName, String email, String dateOfBirth, String password, String confirmPassword) {
        // Check if passwords match
        if (!password.equals(confirmPassword)) {
            System.out.println("Error: Passwords do not match. Ensure both password fields are identical.");
            return "False, Passwords do not match.";
        }

        // Validate username
        if (!dataValidator.isValidName(userName)) {
            System.out.println("Error: Invalid username. It should contain only letters and underscores, and be at least 2 characters long.");
            return "False, Invalid username. Only letters and underscores _";
        }

        // Validate email
        if (!dataValidator.isValidEmail(email)) {
            System.out.println("Error: Invalid email. Ensure it follows the format: example@domain.com.");
            return "False, Invalid email format. ex: example@domain.com.";
        }

        // Validate date of birth
        if (!dataValidator.isValidDate(dateOfBirth)) {
            System.out.println("Error: Invalid date of birth. It should be in the format yyyy-MM-dd, and cannot be in the future.");
            return "False, Invalid date of birth. Use yyyy-MM-dd..";
        }

        // Validate password strength
        if (!dataValidator.isStrongPassword(password)) {
            System.out.println("Error: Weak password. It should contain at least 1 lowercase letter, 1 uppercase letter, 1 digit, and be at least 6 characters long.");
            return "False, Weak password. At least 1 lowercase, 1 uppercase, 1 digit, 6+ chars.";
        }

        // Ensure the username is unique
        if (userFinder.findUserByUserName(userName) != null) {
            System.out.println("Error: Username is already taken. Please choose a different one.");
            return "False, Username is already taken. Please choose a different one.";
        }

        // Ensure the email is unique
        if (userFinder.findUserByEmail(email) != null) {
            System.out.println("Error: Email is already registered. Please use a different email.");
            return "False, Email is already registered. Please use a different email.";
        }

        // Create a new user
        IDataObject[] allUsers = userRoleDataBaseSignup.getData();
        String userID = "U" + (allUsers.length + 1); // Use `length` property for arrays
        UserInfo newUser = new UserInfo(userID, userName, password.hashCode() + "", email, dateOfBirth); // Hash the password for security

        userRoleDataBaseSignup.addObject(newUser);
        

        System.out.println("Success: User signed up successfully!");
        return "True, User signed up successfully!";
    }
}

