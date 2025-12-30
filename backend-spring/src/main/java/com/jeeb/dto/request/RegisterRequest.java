package com.jeeb.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record RegisterRequest(
    @Email @NotBlank String email,
    @Size(min = 5) String password
) {
}
