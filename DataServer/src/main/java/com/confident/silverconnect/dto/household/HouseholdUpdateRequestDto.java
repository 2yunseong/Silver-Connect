package com.confident.silverconnect.dto.household;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@NoArgsConstructor
@Getter
@Setter
public class HouseholdUpdateRequestDto {

    @NotNull
    private String address;
    @NotNull
    private String residentName;
    @NotNull
    private Integer residentAge;
    @NotNull
    private String residentPhoneNumber;

    @Builder
    public HouseholdUpdateRequestDto(String address, String residentName, Integer residentAge, String residentPhoneNumber) {
        this.address = address;
        this.residentName = residentName;
        this.residentAge = residentAge;
        this.residentPhoneNumber = residentPhoneNumber;
    }
}
