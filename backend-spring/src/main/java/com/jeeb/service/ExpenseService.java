package com.jeeb.service;

import com.jeeb.dto.request.CreateExpenseRequest;
import com.jeeb.dto.response.ExpenseResponse;
import com.jeeb.entity.Expense;
import com.jeeb.repository.ExpenseRepository;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class ExpenseService {
    private final ExpenseRepository expenseRepository;

    public ExpenseService(ExpenseRepository expenseRepository) {
        this.expenseRepository = expenseRepository;
    }

    public List<ExpenseResponse> listByUser(Long userId) {
        return expenseRepository.findByUserId(userId).stream()
            .map(this::toResponse)
            .toList();
    }

    public ExpenseResponse create(CreateExpenseRequest request) {
        Expense expense = new Expense(request.userId(), request.name(), request.amount(), request.date());
        return toResponse(expenseRepository.save(expense));
    }

    private ExpenseResponse toResponse(Expense expense) {
        return new ExpenseResponse(
            expense.getId(),
            expense.getUserId(),
            expense.getName(),
            expense.getAmount(),
            expense.getDate()
        );
    }
}
