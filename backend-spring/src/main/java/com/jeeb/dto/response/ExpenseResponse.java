package com.jeeb.dto.response;

import java.math.BigDecimal;
import java.time.LocalDate;

public record ExpenseResponse(
    Long id,
    Long userId,
    String name,
    BigDecimal amount,
    LocalDate date
) {
}
