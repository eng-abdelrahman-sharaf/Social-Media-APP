package com.programming2.socialmediaapp.contentCreation;

import java.time.Instant;

public interface TemporalMedium {
    Instant getExpirationTime();
    void setExpirationTime(Instant expirationTime);
}
