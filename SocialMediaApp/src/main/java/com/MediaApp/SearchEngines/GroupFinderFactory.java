package com.MediaApp.SearchEngines;

import com.MediaApp.DataHandlers.IDataBase;

public class GroupFinderFactory {
    public  GroupFinder create(IDataBase groupdb ) {
        return new GroupFinderImpl.Builder().setGroupdb(groupdb).build();
    }
}
