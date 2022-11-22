package com.confident.silverconnect.dto.schedule;

import com.confident.silverconnect.domain.Schedule.Schedule;
import com.confident.silverconnect.util.EpochTime;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@NoArgsConstructor
@Getter
@Setter
public class ScheduleCreateDto {

    @NotNull
    private Long userId;

    @NotNull
    private Long householdId;

    @NotNull
    private Long epochSecond;

    @Builder
    public ScheduleCreateDto(Long userId, Long householdId, Long epochSecond) {
        this.userId = userId;
        this.householdId = householdId;
        this.epochSecond = epochSecond;
    }

    public ScheduleCreateDto(Schedule schedule) {
        this.userId = schedule.getUser().getId();
        this.householdId = schedule.getHousehold().getId();
        this.epochSecond = EpochTime.toEpochSecond(schedule.getDateTime());
    }
}
