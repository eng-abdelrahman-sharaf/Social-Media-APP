/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.MediaApp.NewsFeed;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author ADMIN
 */
public class test extends Application {
    FXMLLoader loader = new FXMLLoader(getClass().getResource("NewsFeed.fxml"));
    @Override
   public void start(Stage stage){
        try{
            stage.setScene(loader.load());
            stage.show();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public static void main(String[] args){
        launch(args);
    }
    
}
