package com.jeeb.repository;

import com.jeeb.entity.Reminder;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReminderRepository extends JpaRepository<Reminder, Long> {
    List<Reminder> findByUserId(Long userId);
}
