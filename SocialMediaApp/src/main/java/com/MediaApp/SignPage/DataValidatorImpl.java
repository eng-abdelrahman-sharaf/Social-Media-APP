/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.MediaApp.SignPage;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.regex.Pattern;

public class DataValidatorImpl implements DataValidator {

    @Override
    public boolean isValidName(String name) {
        return name != null && name.matches("[A-Za-z_]{2,}"); // Only characters and _
    }

    @Override
    public boolean isValidID(String id) {
        return id != null && id.matches("\\w{4,10}");
    }

    @Override
    public boolean isValidEmail(String email) {
        String emailRegex = "^[\\w-\\.]+@[\\w-\\.]+\\.[a-z]{2,}$";
        return email != null && Pattern.matches(emailRegex, email);
    }

    @Override
    public boolean isValidDate(String dateStr) {
        try {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate date = LocalDate.parse(dateStr, formatter);
        // Check if the date is not in the future
        return date.isBefore(LocalDate.now()) || date.isEqual(LocalDate.now()); 
    } catch (DateTimeParseException e) {
        return false;
    }
    }

    @Override
    public boolean isValidStatus(String status) {
        String[] allowedStatuses = {"active", "offline", "on call"};
        for (String allowedStatus : allowedStatuses) {
            if (allowedStatus.equalsIgnoreCase(status)) return true;
        }
        return false;
    }

    @Override
    public boolean isValidPhoneNumber(String phoneNumber) {
        return phoneNumber != null && phoneNumber.matches("\\d{6,}");
    }

    @Override
    public boolean isStrongPassword(String password) {
        if (password == null || password.length() < 6) return false;
        String regex = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).{6,}$"; // Medium strength: at least 1 lowercase, 1 uppercase, 1 digit, and minimum 6 characters
        return Pattern.matches(regex, password);
    }
}