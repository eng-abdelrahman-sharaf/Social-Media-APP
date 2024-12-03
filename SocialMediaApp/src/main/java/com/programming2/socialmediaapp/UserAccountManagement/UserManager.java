/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.programming2.socialmediaapp.UserAccountManagement;

import java.util.List;

interface UserManager {
    void addUser(UserInfo user);
    List<UserInfo> getUserInfoList();
}
