package com.confident.silverconnect.dto.schedule;

import com.confident.silverconnect.domain.Household.Risk;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class ScheduleSimpleDto {

    private Long id;
    private Long epochTime;
    private String residentName;
    private Risk risk;

    @Builder
    public ScheduleSimpleDto(Long id, Long epochTime, String residentName, Risk risk) {
        this.id = id;
        this.epochTime = epochTime;
        this.residentName = residentName;
        this.risk = risk;
    }
}
