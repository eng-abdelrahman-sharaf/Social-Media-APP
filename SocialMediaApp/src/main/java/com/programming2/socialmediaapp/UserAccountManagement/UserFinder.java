/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.programming2.socialmediaapp.UserAccountManagement;

public interface UserFinder {
    UserInfo findUserById(String userId);
    UserInfo findUserByUserName(String userName);
    UserInfo findUserByEmail(String email);
}