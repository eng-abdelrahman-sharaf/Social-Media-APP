package com.MediaApp.DataHandlers;

public class DataObject implements IDataObject{
    private String ID;


    @Override
    public String getID() {
        return ID;
    }

    @Override
    public void setID(String ID) {
        this.ID = ID;
    }

    @Override
    public IDataObject clone() {
        try {
            return (IDataObject) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException("not cloneable");
        }
    }
}
