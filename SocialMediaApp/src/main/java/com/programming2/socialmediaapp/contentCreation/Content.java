/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.programming2.socialmediaapp.contentCreation;

/**
 *
 * @author ADMIN
 */
public interface Content {
    String getText();
    String [] getAttachments();
    void setText(String text);
    void addAttachment(String filename);
}
