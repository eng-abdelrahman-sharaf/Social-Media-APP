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
public interface IFindObjById {
    IDataObject findObjById(String id, List<IDataObject> list);

}
