package com.confident.silverconnect.service;

import com.confident.silverconnect.domain.Household.Household;
import com.confident.silverconnect.domain.Household.HouseholdRepository;
import com.confident.silverconnect.dto.household.HouseholdCreateDto;
import com.confident.silverconnect.dto.household.HouseholdUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class HouseholdService {

    private final HouseholdRepository householdRepository;

    private static final String NOT_FOUND_HOUSEHOLD_MESSAGE = "해당 가구를 찾을 수 없습니다";


    public Household createHousehold(HouseholdCreateDto householdCreateDto) {
        Household household = householdCreateDto.toEntity();

        return householdRepository.save(household);
    }

    public Household getHouseholdById(long id) {
        return householdRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException(NOT_FOUND_HOUSEHOLD_MESSAGE));
    }

    public Household getByPhoneNumber(String phoneNumber) {
        return householdRepository.getByResidentPhoneNumber(phoneNumber)
                .orElseThrow(() -> new IllegalArgumentException(NOT_FOUND_HOUSEHOLD_MESSAGE));

    }

    public List<Household> getAll() {
        return householdRepository.findAll();
    }

    public List<Household> getAllOrderByRisk() {
        return householdRepository.getAllByOrderByRiskDesc();
    }

    @Transactional
    public Household updateHouseholdById(long id, HouseholdUpdateRequestDto householdUpdateRequestDto) {
        Household household =  getHouseholdById(id);
        household.update(householdUpdateRequestDto);

        return household;
    }

    public void deleteHouseholdById(long id) {
        householdRepository.deleteById(id);
    }

    public Household findById(Integer householdId) {
        return householdRepository.findById(Long.valueOf(householdId)).orElseThrow(() -> new IllegalArgumentException("해당 household가 존재하지 않습니다."));
    }

    public Household getByResidentName(String residentName) {
        return householdRepository.getByResidentName(residentName).orElseThrow(() -> new IllegalArgumentException("해당 household가 존재하지 않습니다."));
    }
}
