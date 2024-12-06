/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.MediaApp.DataHandlers;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;

/**
 *
 * @author abdah
 */

//public class JsonMapStorageHandler<K, V> implements MapStorageHandler<K, V> {
public class JsonMapStorageHandler<K, V extends IDataObject> implements MapStorageHandler<K, V> {  

    private final String filePath;
    private final Class<K> keyType;
    private final Class<V> valueType;

    public JsonMapStorageHandler(Class<K> keyType, Class<V> valueType, String filePath) {
        this.keyType = keyType;
        this.valueType = valueType;
        this.filePath = filePath;
    }

    @Override
    public void saveMap(HashMap<K, V> dataMap) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.writerWithDefaultPrettyPrinter().writeValue(new File(filePath), dataMap);
    }

    @Override
    public HashMap<K, V> loadMap() throws IOException {
         File file = new File(filePath);
        if (!file.exists()) {
            return new HashMap<>(); // Return an empty HashMap if the file doesn't exist
        }

        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(
            file,
            objectMapper.getTypeFactory().constructMapType(HashMap.class, keyType, valueType)
        );
    }
}
