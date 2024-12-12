package com.MediaApp.SearchEngines;

import com.MediaApp.DataHandlers.IDataBase;
import com.MediaApp.DataHandlers.IDataObject;

public class test {
    public static void main(String[] args) {
        GroupFinderFactory factory = new GroupFinderFactory();

        // the part inside .create is only for testing (will be replaced by the real group database)
        GroupFinder groupFinder =  factory.create(new IDataBase() {
            @Override
            public IDataObject readObject(String ID) {
                return null;
            }

            @Override
            public IDataObject[] getData() {
                return new INamedDataObject[]{new INamedDataObject() {
                    @Override
                    public String getID() {
                        return "";
                    }

                    public String getName(){
                        return "hi";
                    }

                    @Override
                    public void setName(String name) {

                    }

                    @Override
                    public void setID(String ID) {

                    }

                    @Override
                    public IDataObject clone() {
                        return null;
                    }
                }};
            }

            @Override
            public void addObject(IDataObject object) {

            }

            @Override
            public void deleteObject(String ID) {

            }

            @Override
            public void update(String ID, IDataObject object) {

            }

            @Override
            public void reload() {

            }

            @Override
            public void save() {

            }
        });


        System.out.println(groupFinder.findByName("hi"));

    }
}
