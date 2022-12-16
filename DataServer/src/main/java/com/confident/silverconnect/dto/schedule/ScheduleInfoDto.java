package com.confident.silverconnect.dto.schedule;

import com.confident.silverconnect.domain.Household.Risk;
import com.confident.silverconnect.domain.Schedule.Schedule;
import com.confident.silverconnect.domain.guardian.Guardian;
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

    public ScheduleInfoDto(Schedule schedule, Guardian guardian) {
        this.id = schedule.getId();
        this.householdId = schedule.getHousehold().getId();
        this.residentName = schedule.getHousehold().getResidentName();
        this.residentAge = schedule.getHousehold().getResidentAge();
        this.householdAddress = schedule.getHousehold().getAddress();
        this.guardianId = guardian.getId();
        this.guardianName = guardian.getName();
        this.guardianPhoneNumber = guardian.getPhoneNumber();
        this.risk = schedule.getHousehold().getRisk();
    }
}
