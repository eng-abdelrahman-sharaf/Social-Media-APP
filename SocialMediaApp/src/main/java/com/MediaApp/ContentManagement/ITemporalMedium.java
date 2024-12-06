package com.MediaApp.ContentManagement;

import java.time.Instant;

public interface ITemporalMedium {
    String getExpirationTime();
    void setExpirationTime(String expirationTime);
}