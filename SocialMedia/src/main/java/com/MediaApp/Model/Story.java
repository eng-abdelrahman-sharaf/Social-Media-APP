package com.MediaApp.Model;

import java.time.Duration;
import java.time.Instant;

public class Story extends Medium implements ITemporalMedium {

    Instant expirationTime;
    public Story(String ID, String AuthorID, IContent content, Instant timestamp){
        super(ID, AuthorID, content, timestamp);
        expirationTime = timestamp.plus(Duration.ofDays(1));
    }


    @Override
    public Instant getExpirationTime() {
        return this.expirationTime;
    }

    @Override
    public void setExpirationTime(Instant expirationTime) {
        this.expirationTime = expirationTime;
    }
}
