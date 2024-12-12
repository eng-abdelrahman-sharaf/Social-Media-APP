package com.MediaApp.SearchEngines;

import com.MediaApp.DataHandlers.IDataObject;

public interface INamedDataObject extends IDataObject {

    String getName();
    void setName(String name);

}


