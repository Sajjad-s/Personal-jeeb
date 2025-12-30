package com.jeeb.controller;

import com.jeeb.dto.request.CreateReminderRequest;
import com.jeeb.dto.response.ReminderResponse;
import com.jeeb.service.ReminderService;
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
@RequestMapping("/api/reminders")
public class ReminderController {
    private final ReminderService reminderService;

    public ReminderController(ReminderService reminderService) {
        this.reminderService = reminderService;
    }

    @GetMapping
    public List<ReminderResponse> list(@RequestParam Long userId) {
        return reminderService.listByUser(userId);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ReminderResponse create(@Valid @RequestBody CreateReminderRequest request) {
        return reminderService.create(request);
    }
}
