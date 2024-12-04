/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.MediaApp.DataHandlers;

import com.MediaApp.ContentManagement.IDataObject;

/**
 *
 * @author ADMIN
 */
public interface IDataBase {
    public IDataObject[] getData();
    public IDataBase getInstance(IDataLoader loader);
    public void refresh();
}