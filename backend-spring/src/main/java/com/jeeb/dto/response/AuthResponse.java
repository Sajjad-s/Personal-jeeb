package com.jeeb.dto.response;

public record AuthResponse(
    UserResponse user,
    String message
) {
}
