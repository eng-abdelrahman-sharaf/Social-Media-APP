package com.MediaApp.Model;

import java.time.Instant;

public interface ITemporalMedium extends IMedium {
    Instant getExpirationTime();
    void setExpirationTime(Instant expirationTime);
}
