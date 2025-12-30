package com.jeeb.dto.response;

import java.time.Instant;

public record UserResponse(
    Long id,
    String email,
    String status,
    Instant createdAt
) {
}
