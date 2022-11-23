package com.confident.silverconnect.service;

import com.confident.silverconnect.domain.Household.Household;
import com.confident.silverconnect.domain.Schedule.Schedule;
import com.confident.silverconnect.domain.Schedule.ScheduleRepository;
import com.confident.silverconnect.domain.User.User;
import com.confident.silverconnect.domain.guardian.Guardian;
import com.confident.silverconnect.dto.schedule.ScheduleCreateDto;
import com.confident.silverconnect.dto.schedule.ScheduleInfoDto;
import com.confident.silverconnect.dto.schedule.ScheduleSimpleDto;
import com.confident.silverconnect.util.EpochTime;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ScheduleService {

    private final ScheduleRepository scheduleRepository;
    private final UserService userService;
    private final HouseholdService householdService;
    private final GuardianService guardianService;

    private static final String NOT_FOUND_SCHEDULE_MESSAGE = "해당 일정을 찾을 수 없습니다";


    public Schedule createSchedule(ScheduleCreateDto scheduleCreateDto) {
        User user = userService.findUserById(scheduleCreateDto.getUserId());
        Household household = householdService.getHouseholdById(scheduleCreateDto.getHouseholdId());
        LocalDateTime dateTime = EpochTime.toLocalDateTime(scheduleCreateDto.getEpochSecond());

        return scheduleRepository.save(new Schedule(user, household, dateTime));
    }

    public Schedule getScheduleById(long id) {
        return scheduleRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException(NOT_FOUND_SCHEDULE_MESSAGE));
    }

    public ScheduleCreateDto getScheduleCreateDtoById(long id) {
        return new ScheduleCreateDto(getScheduleById(id));
    }

    public ScheduleInfoDto getScheduleInfoDtoById(long id) {
        Schedule schedule = getScheduleById(id);
        Guardian guardian = guardianService.findByHouseholdId(schedule.getHousehold().getId());

        return new ScheduleInfoDto(schedule, guardian);
    }

    public List<ScheduleSimpleDto> getScheduleSimpleDtoByUserIdAndMonth(long userId, int month) {
        LocalDateTime start = LocalDateTime.of(2022, month, 1, 0, 0);
        LocalDateTime end = LocalDateTime.of(2022, month, 31, 0, 0);

        return scheduleRepository.findByUser_IdAndDateTimeBetween(userId, start, end).stream().map(ScheduleSimpleDto::new).collect(Collectors.toList());
    }

    @Transactional
    public Schedule updateSchedule(long id, ScheduleCreateDto scheduleCreateDto) {
        User user = userService.findUserById(scheduleCreateDto.getUserId());
        Household household = householdService.getHouseholdById(scheduleCreateDto.getHouseholdId());
        LocalDateTime dateTime = EpochTime.toLocalDateTime(scheduleCreateDto.getEpochSecond());

        Schedule schedule = getScheduleById(id);
        schedule.update(user, household, dateTime);

        return schedule;
    }

    public void deleteSchedule(long id) {
        scheduleRepository.deleteById(id);
    }
}
