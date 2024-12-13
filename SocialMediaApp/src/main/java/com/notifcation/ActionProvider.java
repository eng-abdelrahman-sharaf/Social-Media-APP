/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.notifcation;

import java.util.Map;

/**
 *
 * @author abdah
 */
public interface ActionProvider {
    Map<String, String> createActions(String userId);
}

