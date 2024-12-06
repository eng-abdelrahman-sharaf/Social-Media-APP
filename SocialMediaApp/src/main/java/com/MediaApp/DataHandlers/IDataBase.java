/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.MediaApp.DataHandlers;

import com.MediaApp.UserAccountManagement.ListStorageHandler;



//CRUD => Create Read Update Delete
//singleton must be applied (only one instance of the class)
public interface IDataBase {
    
    // Read action [read object from the database]
    // Return the object if found, otherwise return null
    // The returned object should be a **clone** of the object in the database
    public IDataObject readObject(String ID);

    // Read all objects from the database
    // Return an array of **cloned** objects [deep cloning]
    public IDataObject[] getData();

    // Create action [add new object to the database]
    // reload should be called inside this method (before adding the object)
    // save should be called inside this method (after adding the object)
    public void addObject(IDataObject object);
    
    // Delete action [delete object from the database]
    // reload should be called inside this method (before deleting the object)
    // save should be called inside this method (after deleting the object)
    public void deleteObject(String ID);

    // updating an object in the database
    // reload should be called inside this method (before updating the object)
    // save should be called inside this method (after updating the object)
    public void update(String ID, IDataObject object);

    
    // Reload the database to get the latest data
    // it is used when the refresh button is clicked
    public void reload();
    
    // Save the database to keep the data
    public void save();
}