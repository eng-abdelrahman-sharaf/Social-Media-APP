package com.MediaApp.Model;/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author ADMIN
 */
public interface IContent {
    String getText();
    String [] getAttachments();
    void setText(String text);
    void addAttachment(String filename);
}
