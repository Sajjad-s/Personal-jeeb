package com.jeeb.dto.response;

import java.math.BigDecimal;
import java.time.LocalDate;

public record TransactionResponse(
    Long id,
    Long userId,
    BigDecimal amount,
    String description,
    LocalDate date
) {
}
