package com.confident.silverconnect.domain.Schedule;

import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface ScheduleRepository extends JpaRepository<Schedule, Long> {

    List<Schedule> findByDateTimeBetween(LocalDateTime start, LocalDateTime end);

    List<Schedule> findByUser_IdAndDateTimeBetween(Long userId, LocalDateTime start, LocalDateTime end);

    void deleteByDateTimeBetween(LocalDateTime start, LocalDateTime end);
}
