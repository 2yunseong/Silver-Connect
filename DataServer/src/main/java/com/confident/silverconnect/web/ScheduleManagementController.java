package com.confident.silverconnect.web;

import com.confident.silverconnect.dto.Schedule.ScheduleInfoDto;
import com.confident.silverconnect.dto.Schedule.ScheduleSaveDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Tag(name = "스케줄 API", description = "스케줄 추가, 조회, 수정, 삭제")
@RequiredArgsConstructor
@RestController
public class ScheduleManagementController {


    @Operation(summary = "스케줄 추가")
    @PostMapping("/api/schedule")
    public ResponseEntity<Long> createSchedule(@Valid @ModelAttribute ScheduleSaveDto scheduleSaveDto) {
        return ResponseEntity.ok().build();
    }

    @Operation(summary = "스케줄 모든 정보 조회")
    @GetMapping("/api/schedule/{scheduleId}")
    public ResponseEntity<ScheduleSaveDto> getScheduleDtoByScheduleId(@PathVariable(value = "scheduleId") Long scheduleId) {
        return ResponseEntity.ok().build();
    }

    @Operation(summary = "스케줄 수정")
    @PutMapping("/api/schedule")
    public ResponseEntity<Long> updateSchedule(@Valid @ModelAttribute ScheduleSaveDto scheduleSaveDto) {
        return ResponseEntity.ok().build();
    }

    @Operation(summary = "스케줄 삭제")
    @DeleteMapping("/api/schedule/{scheduleId}")
    public ResponseEntity<Long> deleteSchedule(@PathVariable(value = "scheduleId") Long scheduleId) {
        return ResponseEntity.ok().build();
    }
}
