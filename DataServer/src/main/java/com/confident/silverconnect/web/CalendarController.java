package com.confident.silverconnect.web;

import com.confident.silverconnect.dto.schedule.ScheduleInfoDto;
import com.confident.silverconnect.dto.schedule.ScheduleSimpleDto;
import com.confident.silverconnect.service.ScheduleService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Tag(name = "캘린더 API", description = "캘린더 기능에 맞춰 스케줄들을 다양하게 조회")
@RequiredArgsConstructor
@RestController
public class CalendarController {

    private final ScheduleService scheduleService;


    @Operation(summary = "특정 월의 스케줄들 조회")
    @GetMapping("/api/calendar/{userId}/month/{month}")
    public ResponseEntity<List<ScheduleSimpleDto>> getMonthlySchedulesByUserId(@PathVariable(value = "userId") Long userid,
                                                                               @PathVariable(value = "month") Integer month) {
        List<ScheduleSimpleDto> scheduleSimpleDtos = scheduleService.getScheduleSimpleDtoByUserIdAndMonth(userid, month);

        return ResponseEntity.ok(scheduleSimpleDtos);
    }

    @Operation(summary = "특정 id의 스케줄 캘린더 포멧 조회")
    @GetMapping("/api/calendar/schedule/{scheduleId}")
    public ResponseEntity<ScheduleInfoDto> getScheduleInfoDtoByScheduleId(@PathVariable(value = "scheduleId") Long scheduleId) {
        ScheduleInfoDto scheduleInfoDto = scheduleService.getScheduleInfoDtoById(scheduleId);

        return ResponseEntity.ok(scheduleInfoDto);
    }
}