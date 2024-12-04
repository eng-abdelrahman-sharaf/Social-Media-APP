package com.MediaApp.UserAccountManagement;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class JsonStorageHandler<T> implements IndividualStorageHandler<T>, ListStorageHandler<T> {

    
    private final Class<T> type;

    public JsonStorageHandler(Class<T> type) {
        
        this.type = type;
    }

    // IndividualStorageHandler implementation
    @Override
    public void save(T data, String filePath) throws IOException {
         ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.writeValue(new File(filePath), data);
    }

    @Override
    public T load(String filePath) throws IOException {
         ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(new File(filePath), type);
    }

    // ListStorageHandler implementation
    @Override
    public void saveList(List<T> dataList, String filePath) throws IOException {
         ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.writeValue(new File(filePath), dataList);
    }

   @Override
    public List<T> loadList(String filePath) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(new File(filePath), objectMapper.getTypeFactory().constructCollectionType(List.class, type));

        //return objectMapper.readValue(new File(filePath), new TypeReference<List<T>>() {});
}
}
