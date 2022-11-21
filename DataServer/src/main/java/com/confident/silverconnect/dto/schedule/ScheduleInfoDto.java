package com.confident.silverconnect.dto.schedule;

import com.confident.silverconnect.domain.Household.Risk;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class ScheduleInfoDto {

    private Long id;
    private Long householdId;
    private String residentName;
    private Integer residentAge;
    private String householdAddress;
    private Long guardianId;
    private String guardianName;
    private String guardianPhoneNumber;
    private Risk risk;

    @Builder
    public ScheduleInfoDto(Long id, Long householdId, String residentName, Integer residentAge, String householdAddress, Long guardianId, String guardianName, String guardianPhoneNumber, Risk risk) {
        this.id = id;
        this.householdId = householdId;
        this.residentName = residentName;
        this.residentAge = residentAge;
        this.householdAddress = householdAddress;
        this.guardianId = guardianId;
        this.guardianName = guardianName;
        this.guardianPhoneNumber = guardianPhoneNumber;
        this.risk = risk;
    }
}
