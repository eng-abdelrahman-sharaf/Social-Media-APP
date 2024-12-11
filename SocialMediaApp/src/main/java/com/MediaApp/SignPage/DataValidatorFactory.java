package com.MediaApp.SignPage;

public class DataValidatorFactory {
    public DataValidator createObject(){
        return new DataValidatorImpl();
    }
}
