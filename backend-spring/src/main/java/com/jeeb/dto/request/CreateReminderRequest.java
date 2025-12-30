package com.jeeb.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDateTime;

public record CreateReminderRequest(
    @NotNull Long userId,
    @NotBlank String type,
    @NotNull Long referenceId,
    @NotBlank String medium,
    @NotNull LocalDateTime time
) {
}
