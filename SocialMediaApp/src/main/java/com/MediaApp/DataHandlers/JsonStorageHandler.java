package com.MediaApp.UserAccountManagement;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class JsonStorageHandler<T> implements  ListStorageHandler<T> {

    
    private final Class<T> type;
    private final String filePath;
    public JsonStorageHandler(Class<T> type, String filePath) {
        this.type = type;
        this.filePath = filePath;
    }

   
    // ListStorageHandler implementation
    @Override
    public void saveList(List<T> dataList) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.writeValue(new File(filePath), dataList);
    }

    @Override
    public List<T> loadList() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(new File(filePath),
                objectMapper.getTypeFactory().constructCollectionType(List.class, type));
    }
}
       

