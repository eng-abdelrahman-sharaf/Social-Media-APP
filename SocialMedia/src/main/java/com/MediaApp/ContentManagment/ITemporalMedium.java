package com.MediaApp.ContentManagment;

import java.time.Instant;

public interface TemporalMedium {
    Instant getExpirationTime();
    void setExpirationTime(Instant expirationTime);
}