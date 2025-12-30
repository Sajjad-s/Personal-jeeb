package com.jeeb.repository;

import com.jeeb.entity.Income;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IncomeRepository extends JpaRepository<Income, Long> {
    List<Income> findByUserId(Long userId);
}
