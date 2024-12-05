package com.MediaApp.ContentManagement;

import java.time.Instant;

public interface ITemporalMedium {
    Instant getExpirationTime();
    void setExpirationTime(Instant expirationTime);
}