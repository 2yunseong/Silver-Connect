package com.confident.silverconnect.web;

import com.confident.silverconnect.dto.schedule.ScheduleInfoDto;
import com.confident.silverconnect.dto.schedule.ScheduleSimpleDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
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
                                                                               @PathVariable(value = "month") Integer month,
                                                                               @ModelAttribute(value = "accessToken") String accessToken) {
        return ResponseEntity.ok().build();
    }

    @Operation(summary = "특정 id의 스케줄 캘린더 포멧 조회")
    @GetMapping("/api/calendar/{userId}/schedule/{scheduleId}")
    public ResponseEntity<ScheduleInfoDto> getScheduleDtoByScheduleId(@PathVariable(value = "userId") Long userid,
                                                                      @PathVariable(value = "scheduleId") Long scheduleId,
                                                                      @ModelAttribute(value = "accessToken") String accessToken) {
        return ResponseEntity.ok().build();
    }
}