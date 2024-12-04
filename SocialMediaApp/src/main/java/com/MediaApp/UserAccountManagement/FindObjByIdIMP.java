/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.MediaApp.UserAccountManagement;

import com.MediaApp.DataHandlers.IDataObject;
import java.util.List;

/**
 *
 * @author abdah
 */
public class FindObjByIdIMP implements IFindObjById {
    
 @Override
    public IDataObject findObjById(String id, List<IDataObject> list) {
        for (IDataObject obj : list) {
            if (obj.getUser().equalsIgnoreCase(id)) {
                return obj; // Return the found object
            }
        }
        return null; // Return null if no match is found
    }
}

