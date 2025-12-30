package com.jeeb.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record UpdateEmailRequest(
    @Email @NotBlank String email,
    @NotBlank String password
) {
}
