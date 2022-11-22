package com.confident.silverconnect.service;

import com.confident.silverconnect.domain.Household.Household;
import com.confident.silverconnect.domain.Household.HouseholdRepository;
import com.confident.silverconnect.dto.household.HouseholdCreateDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class HouseholdService {

    private final HouseholdRepository householdRepository;


    public long createHousehold(HouseholdCreateDto householdCreateDto) {
        Household household = householdCreateDto.toEntity();
        return householdRepository.save(household).getId();
    }

    public Household getByPhoneNumber(String phoneNumber) {
        return householdRepository.getByPhoneNumber(phoneNumber).orElseThrow(() -> new IllegalArgumentException("해당하는 household가 없습니다"));

    }
}
