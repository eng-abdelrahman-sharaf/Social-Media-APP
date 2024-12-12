package com.MediaApp.SearchEngines;

import com.MediaApp.DataHandlers.IDataBase;

public class GroupFinderImpl  implements GroupFinder {

    private IDataBase groupdb;

    GroupFinderImpl(Builder builder) {
        this.groupdb = builder.groupdb;
    }


    @Override
    public INamedDataObject findByName(String name) {
        for(Object obj : groupdb.getData()){
            INamedDataObject group = (INamedDataObject) obj;
            if(group.getName().equals(name)){
                return group;
            }
        }
        return null;
    }


    public static class Builder{

        private IDataBase groupdb;

        public Builder(){}

        public Builder setGroupdb(IDataBase groupdb){
            this.groupdb = groupdb;
            return this;
        }

        public GroupFinder build(){
            return new GroupFinderImpl(this);
        }

    }
}
