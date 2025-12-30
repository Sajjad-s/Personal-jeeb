package com.jeeb.service;

import com.jeeb.dto.response.ReportSummaryResponse;
import com.jeeb.repository.ExpenseRepository;
import com.jeeb.repository.IncomeRepository;
import java.math.BigDecimal;
import org.springframework.stereotype.Service;

@Service
public class ReportService {
    private final IncomeRepository incomeRepository;
    private final ExpenseRepository expenseRepository;

    public ReportService(IncomeRepository incomeRepository, ExpenseRepository expenseRepository) {
        this.incomeRepository = incomeRepository;
        this.expenseRepository = expenseRepository;
    }

    public ReportSummaryResponse summary(Long userId) {
        BigDecimal totalIncome = incomeRepository.findByUserId(userId).stream()
            .map(income -> income.getAmount())
            .reduce(BigDecimal.ZERO, BigDecimal::add);
        BigDecimal totalExpense = expenseRepository.findByUserId(userId).stream()
            .map(expense -> expense.getAmount())
            .reduce(BigDecimal.ZERO, BigDecimal::add);
        BigDecimal net = totalIncome.subtract(totalExpense);
        return new ReportSummaryResponse(userId, totalIncome, totalExpense, net);
    }
}
