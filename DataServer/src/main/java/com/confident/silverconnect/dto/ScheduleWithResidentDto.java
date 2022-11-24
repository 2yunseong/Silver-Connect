package com.confident.silverconnect.dto;

import com.confident.silverconnect.domain.Household.Risk;
import com.confident.silverconnect.domain.guardian.Guardian;
import com.confident.silverconnect.dto.schedule.ScheduleSimpleDto;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class ScheduleWithResidentDto {

    private Long id;
    private Long epochTime;
    private String residentName;
    private Risk risk;

    private Guardian guardian;

    @Builder
    public ScheduleWithResidentDto(ScheduleSimpleDto scheduleSimpleDto, Guardian guardian) {
        this.id = scheduleSimpleDto.getId();
        this.epochTime = scheduleSimpleDto.getEpochTime();
        this.residentName = scheduleSimpleDto.getResidentName();
        this.risk = scheduleSimpleDto.getRisk();
        this.guardian = guardian;
    }

}
