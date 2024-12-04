package com.MediaApp.ContentManagement;

public interface IDataBase {
    public IDataObject[] getData();
    public IDataBase getInstance();
    public void refresh();
}