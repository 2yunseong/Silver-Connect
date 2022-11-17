package com.confident.silverconnect.web;

import com.confident.silverconnect.dto.Schedule.ScheduleInfoDto;
import com.confident.silverconnect.dto.Schedule.ScheduleSimpleDto;
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

    @Operation(summary = "특정 월의 스케줄들 조회")
    @GetMapping("/api/calendar/{userId}/month/{month}")
    public ResponseEntity<List<ScheduleSimpleDto>> getMonthlySchedulesByUserId(@PathVariable(value = "userId") Long userid,
                                                                               @PathVariable(value = "month") Integer month) {
        return ResponseEntity.ok().build();
    }

    @Operation(summary = "일별 스케줄 상세 조회")
    @GetMapping("/api/schedule/{scheduleId}")
    public ResponseEntity<ScheduleInfoDto> getScheduleDtoByScheduleId(@PathVariable(value = "scheduleId") Long scheduleId) {
        return ResponseEntity.ok().build();
    }
}
