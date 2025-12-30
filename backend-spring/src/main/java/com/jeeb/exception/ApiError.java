package com.jeeb.exception;

import java.time.Instant;

public record ApiError(
    String code,
    String message,
    Instant timestamp
) {
}
