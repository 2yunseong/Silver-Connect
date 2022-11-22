package com.confident.silverconnect.dto.household;

import com.confident.silverconnect.domain.Household.Household;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@NoArgsConstructor
@Getter
@Setter
public class HouseholdCreateDto {
    @NotNull
    private String address;
    @NotNull
    private String residentName;
    @NotNull
    private Integer residentAge;
    @NotNull
    private String residentPhoneNumber;

    @Builder
    public HouseholdCreateDto(String address, String residentName, Integer residentAge, String residentPhoneNumber) {
        this.address = address;
        this.residentName = residentName;
        this.residentAge = residentAge;
        this.residentPhoneNumber = residentPhoneNumber;
    }

    public Household toEntity() {
        return Household.builder()
                .address(address)
                .residentName(residentName)
                .residentAge(residentAge)
                .residentPhoneNumber(residentPhoneNumber)
                .build();

    }
}
