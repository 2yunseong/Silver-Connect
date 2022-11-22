package com.confident.silverconnect.dto.guardian;

import com.confident.silverconnect.domain.Household.Household;
import com.confident.silverconnect.domain.guardian.Guardian;
import lombok.Getter;

@Getter
public class GuardianUpdateRequestDto {
    private String name;
    private Integer age;
    private String phoneNumber;

    private String residentPhoneNumber;

    public Guardian toEntity(Household household){
        return Guardian.builder()
                .household(household)
                .name(name)
                .age(age)
                .phoneNumber(phoneNumber)
                .build();
    }
}