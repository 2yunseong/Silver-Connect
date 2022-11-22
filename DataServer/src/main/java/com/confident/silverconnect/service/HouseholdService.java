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

    private static final String NOT_FOUND_HOUSEHOLD_MESSAGE = "해당 가구를 찾을 수 없습니다";


    public long createHousehold(HouseholdCreateDto householdCreateDto) {
        Household household = householdCreateDto.toEntity();

        return householdRepository.save(household).getId();
    }

    public Household getHouseholdById(long id) {
        return householdRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException(NOT_FOUND_HOUSEHOLD_MESSAGE));
    }
}
