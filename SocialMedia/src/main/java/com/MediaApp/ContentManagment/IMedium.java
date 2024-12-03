package com.MediaApp.Model;/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import java.time.Instant;

/**
 *
 * @author ADMIN
 */
public interface IMedium {
    String getID();
    String getAuthorID();
    IContent getContent();
    Instant getTimeStamp();
    void setID(String ID);
    void setAuthorID(String AuthorID);
    void setTimeStamp(Instant timeStamp);
    void setContent(IContent content);
}
