// now file has 2 diff codes 
// The current one take list and save HashMap (id,obj) in the file 
        //oad HashMap (id,obj) and return list from the file
//one other noted codes 
  //code 2 : ake list and save list in the file ( noted )
package com.MediaApp.UserAccountManagement;

import com.MediaApp.DataHandlers.IDataObject;
import com.MediaApp.DataHandlers.ListStorageHandler;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JsonStorageHandler<T extends IDataObject> implements ListStorageHandler<T> {

    
    private final Class<T> type;
    private final String filePath;
    public JsonStorageHandler(Class<T> type, String filePath) {
        this.type = type;
        this.filePath = filePath;
    }

    
        //this code take list and save HashMap (id,obj) in the file 
    
    @Override
    public void saveList(List<T> dataList) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
       // Enable pretty printing
        //objectMapper.writerWithDefaultPrettyPrinter();
        
        Map<String, T> userMap = new HashMap<>();
        
        // Convert list to HashMap
        for (T item : dataList) {
            userMap.put(item.getID(), item);
        }
        
        // Save the HashMap as JSON
        objectMapper.writeValue(new File(filePath), userMap);
    }
    //this code load HashMap (id,obj) and return list from the file
    @Override
    public List<T> loadList() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        
        Map<String, T> userMap = objectMapper.readValue(
            new File(filePath),
            objectMapper.getTypeFactory().constructMapType(Map.class, String.class, type)
        );

        return List.copyOf(userMap.values());
    }
        
//        // Load the HashMap from JSON
//        Map<String, T> userMap = objectMapper.readValue(new File(filePath),
//                new TypeReference<Map<String, T>>() {});
//        
//        // Convert the HashMap values back to a List
//        return List.copyOf(userMap.values());
    }
    

    
   //this code take list and save list in the file 
    //this code load listt and return list from the file
//    // ListStorageHandler implementation
//    @Override
//    public void saveList(List<T> dataList) throws IOException {
//        ObjectMapper objectMapper = new ObjectMapper();
//        objectMapper.writeValue(new File(filePath), dataList);
//    }
//
//    @Override
//    public List<T> loadList() throws IOException {
//        ObjectMapper objectMapper = new ObjectMapper();
//        return objectMapper.readValue(new File(filePath),
//                objectMapper.getTypeFactory().constructCollectionType(List.class, type));
//    }

       

