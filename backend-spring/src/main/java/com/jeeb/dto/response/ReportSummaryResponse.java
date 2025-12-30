package com.jeeb.dto.response;

import java.math.BigDecimal;

public record ReportSummaryResponse(
    Long userId,
    BigDecimal totalIncome,
    BigDecimal totalExpense,
    BigDecimal net
) {
}
