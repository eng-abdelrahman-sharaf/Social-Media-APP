/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.MediaApp.DataHandlers;

import com.MediaApp.UserAccountManagement.ListStorageHandler;

/**
 *
 * @author ADMIN
 */
public interface IDataBase {
    public IDataBase getInstance(ListStorageHandler<IDataObject> loader );
    public void save(IDataObject[] data);
    public IDataObject[] getData();
    public void refresh();
}