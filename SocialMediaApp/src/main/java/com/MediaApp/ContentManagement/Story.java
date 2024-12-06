package com.MediaApp.ContentManagement;

import java.time.Duration;
import java.time.Instant;

public class Story extends Medium implements ITemporalMedium {

    String expirationTime;
    public Story(){
    }


    @Override
    public String getExpirationTime() {
        return this.expirationTime;
    }

    @Override
    public void setExpirationTime(String expirationTime) {
        this.expirationTime = expirationTime;
    }
}
