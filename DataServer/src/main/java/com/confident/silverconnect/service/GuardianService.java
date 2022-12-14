package com.confident.silverconnect.service;

import com.confident.silverconnect.domain.Household.Household;
import com.confident.silverconnect.domain.guardian.Guardian;
import com.confident.silverconnect.domain.guardian.GuardianRepository;
import com.confident.silverconnect.dto.guardian.GuardianUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class GuardianService {
    private final GuardianRepository guardianRepository;

    private static final String NOT_FOUND_GUARDIAN_MESSAGE = "해당하는 보호자가 없습니다.";


    public List<Guardian> findAll() {
        return guardianRepository.findAll();
    }

    public Guardian findById(Long userId) {
        return guardianRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException(NOT_FOUND_GUARDIAN_MESSAGE));
    }

    public Long countAll() {
        return guardianRepository.count();
    }

    public List<Guardian> findByName(String name) {
        return guardianRepository.findByName(name);
    }

    public Guardian findGuardianByPhoneNumberAndName(String name, Long phoneNumber) {
        return guardianRepository.findByName(name).stream()
                .filter(m -> m.getPhoneNumber().equals(phoneNumber))
                .collect(Collectors.toList()).get(0);
    }

    public Guardian findByHouseholdId(long householdId) {
        return guardianRepository.findByHousehold_Id(householdId)
                .orElseThrow(() -> new IllegalArgumentException(NOT_FOUND_GUARDIAN_MESSAGE));
    }

    public Guardian update(Long userId, GuardianUpdateRequestDto userUpdateRequestDto) {
        Guardian guardian = guardianRepository.findById(userId)
                .orElseThrow(()->new IllegalArgumentException(NOT_FOUND_GUARDIAN_MESSAGE));
        guardian.update(userUpdateRequestDto);
        return guardian;
    }

    public void deleteById(Long userId) {
        if( guardianRepository.findById(userId).isEmpty() ) throw new IllegalArgumentException(NOT_FOUND_GUARDIAN_MESSAGE);
        guardianRepository.deleteById(userId);
    }

    public Guardian createGuardian(Guardian guardian) {
        return guardianRepository.save(guardian);
    }
}