package com.confident.silverconnect.web;

import com.confident.silverconnect.dto.schedule.ScheduleSimpleDto;
import com.confident.silverconnect.service.ScheduleService;
import com.confident.silverconnect.service.SchedulingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class SchedulingController {

    private final SchedulingService schedulingService;
    private final ScheduleService scheduleService;


    @PutMapping("/api/scheduling")
    public ResponseEntity<Void> triggerTodayScheduling() {
        schedulingService.startSchedulingByLocalData();

        return ResponseEntity.ok().build();
    }

    @PutMapping("/api/risk")
    public ResponseEntity<Void> triggerUpdateRisk() {
        schedulingService.updateRisks();

        return ResponseEntity.ok().build();
    }

    @GetMapping("/api/scheduling/{day}")
    public ResponseEntity<List<ScheduleSimpleDto>> getAllScheduleByDay(@PathVariable(value = "day") Integer day) {
        List<ScheduleSimpleDto> scheduleSimpleDtos = scheduleService.getScheduleSimpleDtoByDay(day);

        return ResponseEntity.ok(scheduleSimpleDtos);
    }

    @DeleteMapping("/api/scheduling/{day}")
    public ResponseEntity<Void> deleteAllScheduleByDay(@PathVariable(value = "day") Integer day) {
        scheduleService.deleteAllScheduleByDay(day);

        return ResponseEntity.ok().build();
    }
}
