package com.confident.silverconnect.web;

import com.confident.silverconnect.dto.schedule.ScheduleCreateDto;
import com.confident.silverconnect.service.ScheduleService;
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

    private final ScheduleService scheduleService;


    @Operation(summary = "스케줄 추가")
    @PostMapping("/api/schedule")
    public ResponseEntity<Long> createSchedule(@Valid @ModelAttribute ScheduleCreateDto scheduleCreateDto) {
        long id = scheduleService.createSchedule(scheduleCreateDto).getId();

        return ResponseEntity.ok(id);
    }

    @Operation(summary = "스케줄 모든 정보 조회")
    @GetMapping("/api/schedule/{scheduleId}")
    public ResponseEntity<ScheduleCreateDto> getScheduleDtoByScheduleId(@PathVariable(value = "scheduleId") Long scheduleId) {
        ScheduleCreateDto scheduleCreateDto = scheduleService.getScheduleCreateDtoById(scheduleId);

        return ResponseEntity.ok(scheduleCreateDto);
    }

    @Operation(summary = "스케줄 수정")
    @PutMapping("/api/schedule/{scheduleId}")
    public ResponseEntity<Long> updateSchedule(@PathVariable(value = "scheduleId") Long scheduleId,
                                               @Valid @ModelAttribute ScheduleCreateDto scheduleCreateDto) {
        long id = scheduleService.updateSchedule(scheduleId, scheduleCreateDto).getId();

        return ResponseEntity.ok(id);
    }

    @Operation(summary = "스케줄 삭제")
    @DeleteMapping("/api/schedule/{scheduleId}")
    public ResponseEntity<Long> deleteSchedule(@PathVariable(value = "scheduleId") Long scheduleId) {
        scheduleService.deleteSchedule(scheduleId);

        return ResponseEntity.ok().build();
    }
}
