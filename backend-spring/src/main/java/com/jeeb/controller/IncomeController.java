package com.jeeb.controller;

import com.jeeb.dto.request.CreateIncomeRequest;
import com.jeeb.dto.response.IncomeResponse;
import com.jeeb.service.IncomeService;
import jakarta.validation.Valid;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/incomes")
public class IncomeController {
    private final IncomeService incomeService;

    public IncomeController(IncomeService incomeService) {
        this.incomeService = incomeService;
    }

    @GetMapping
    public List<IncomeResponse> list(@RequestParam Long userId) {
        return incomeService.listByUser(userId);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public IncomeResponse create(@Valid @RequestBody CreateIncomeRequest request) {
        return incomeService.create(request);
    }
}
