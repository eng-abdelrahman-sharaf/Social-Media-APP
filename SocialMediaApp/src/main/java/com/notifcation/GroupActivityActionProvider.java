/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.notifcation;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author abdah
 */
public class GroupActivityActionProvider implements ActionProvider {
    @Override
    public Map<String, String> createActions(String userId) {
        Map<String, String> actions = new HashMap<>();
        actions.put("Join Group", "/group/join/" + userId);
        actions.put("Leave Group", "/group/leave/" + userId);
        return actions;
    }
}
