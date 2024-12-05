/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.MediaApp.DataHandlers;

/**
 *
 * @author ADMIN
 */
public interface IDataObject extends Cloneable{
    public String getID();

    public void setID(String ID);
    
    // clone the object deeply insure that you clone the references [mutable attributes] like arrays , lists  , ...
    public IDataObject clone();
}

