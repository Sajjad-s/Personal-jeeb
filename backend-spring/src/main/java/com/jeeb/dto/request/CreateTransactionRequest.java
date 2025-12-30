package com.jeeb.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDate;

public record CreateTransactionRequest(
    @NotNull Long userId,
    @NotNull BigDecimal amount,
    @NotBlank String description,
    @NotNull LocalDate date
) {
}
