/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.notifcation;

import java.util.Date;

/**
 *
 * @author abdah
 */
public interface INotification {
    String getUserId();
    String getMessage();
    String getType();
    Date getCreatedAt();
    boolean isRead();
}
