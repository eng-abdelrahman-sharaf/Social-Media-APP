package com.MediaApp.Model;

import java.time.Instant;

public interface TemporalMedium {
    Instant getExpirationTime();
    void setExpirationTime(Instant expirationTime);
}
