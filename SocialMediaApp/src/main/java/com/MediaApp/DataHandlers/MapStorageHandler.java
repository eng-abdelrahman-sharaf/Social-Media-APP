/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.MediaApp.DataHandlers;

import java.io.IOException;
import java.util.HashMap;

/**
 *
 * @author abdah
 */
// this interface Handle HAshmap  it save load take return only hashmap ( id , obj ) JSON or any other type of database
public interface MapStorageHandler<K, V> {
    void saveMap(HashMap<K, V> dataMap) throws IOException;

    HashMap<K, V> loadMap() throws IOException;
}