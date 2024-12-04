/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.MediaApp.ContentManagement;

import java.time.Instant;

/**
 *
 * @author ADMIN
 */
public class Test {
    public static void main(){
        Story s = new Story("", "", null, Instant.MIN);        
        System.out.println("story:"+s);
        Post p = new Post("", "", null, Instant.MIN);
        System.out.println("post:"+p);
        
    }

    
}
