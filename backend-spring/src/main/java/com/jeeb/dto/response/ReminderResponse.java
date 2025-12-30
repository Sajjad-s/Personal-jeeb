package com.jeeb.dto.response;

import java.time.LocalDateTime;

public record ReminderResponse(
    Long id,
    Long userId,
    String type,
    Long referenceId,
    String medium,
    LocalDateTime time,
    String status
) {
}
