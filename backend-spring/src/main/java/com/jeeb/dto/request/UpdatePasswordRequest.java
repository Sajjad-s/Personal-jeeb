package com.jeeb.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record UpdatePasswordRequest(
    @NotBlank String oldPassword,
    @Size(min = 5) String newPassword
) {
}
