package com.jeeb.service;

import com.jeeb.dto.request.CreateReminderRequest;
import com.jeeb.dto.response.ReminderResponse;
import com.jeeb.entity.Reminder;
import com.jeeb.repository.ReminderRepository;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class ReminderService {
    private final ReminderRepository reminderRepository;

    public ReminderService(ReminderRepository reminderRepository) {
        this.reminderRepository = reminderRepository;
    }

    public List<ReminderResponse> listByUser(Long userId) {
        return reminderRepository.findByUserId(userId).stream()
            .map(this::toResponse)
            .toList();
    }

    public ReminderResponse create(CreateReminderRequest request) {
        Reminder reminder = new Reminder(
            request.userId(),
            request.type(),
            request.referenceId(),
            request.medium(),
            request.time(),
            "pending"
        );
        return toResponse(reminderRepository.save(reminder));
    }

    private ReminderResponse toResponse(Reminder reminder) {
        return new ReminderResponse(
            reminder.getId(),
            reminder.getUserId(),
            reminder.getType(),
            reminder.getReferenceId(),
            reminder.getMedium(),
            reminder.getTime(),
            reminder.getStatus()
        );
    }
}
