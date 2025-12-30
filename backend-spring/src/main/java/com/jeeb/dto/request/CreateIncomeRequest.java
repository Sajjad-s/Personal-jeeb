package com.jeeb.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDate;

public record CreateIncomeRequest(
    @NotNull Long userId,
    @NotBlank String name,
    @NotNull BigDecimal amount,
    @NotNull LocalDate date
) {
}
