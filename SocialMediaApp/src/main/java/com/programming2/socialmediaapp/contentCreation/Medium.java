/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.programming2.socialmediaapp.contentCreation;

import java.time.Instant;

/**
 *
 * @author ADMIN
 */
public interface Medium {
    String getID();
    String getAuthorID();
    Content getContent();
    Instant getTimeStamp();
    void setID(String ID);
    void setAuthorID(String AuthorID);
    void setTimeStamp(Instant timeStamp);
    void setContent(Content content);
}
