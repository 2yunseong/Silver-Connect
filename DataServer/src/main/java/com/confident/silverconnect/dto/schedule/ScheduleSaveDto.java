package com.confident.silverconnect.dto.schedule;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@NoArgsConstructor
@Getter
@Setter
public class ScheduleSaveDto {

    @NotNull
    private Long userId;

    @NotNull
    private Long householdId;

    @NotNull
    private Long epochTime;

    @Builder
    public ScheduleSaveDto(Long userId, Long householdId, Long epochTime) {
        this.userId = userId;
        this.householdId = householdId;
        this.epochTime = epochTime;
    }
}
