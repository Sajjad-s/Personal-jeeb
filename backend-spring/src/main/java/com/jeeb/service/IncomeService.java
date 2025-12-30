package com.jeeb.service;

import com.jeeb.dto.request.CreateIncomeRequest;
import com.jeeb.dto.response.IncomeResponse;
import com.jeeb.entity.Income;
import com.jeeb.repository.IncomeRepository;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class IncomeService {
    private final IncomeRepository incomeRepository;

    public IncomeService(IncomeRepository incomeRepository) {
        this.incomeRepository = incomeRepository;
    }

    public List<IncomeResponse> listByUser(Long userId) {
        return incomeRepository.findByUserId(userId).stream()
            .map(this::toResponse)
            .toList();
    }

    public IncomeResponse create(CreateIncomeRequest request) {
        Income income = new Income(request.userId(), request.name(), request.amount(), request.date());
        return toResponse(incomeRepository.save(income));
    }

    private IncomeResponse toResponse(Income income) {
        return new IncomeResponse(
            income.getId(),
            income.getUserId(),
            income.getName(),
            income.getAmount(),
            income.getDate()
        );
    }
}
