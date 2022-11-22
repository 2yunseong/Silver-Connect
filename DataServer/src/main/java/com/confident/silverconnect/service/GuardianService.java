package com.confident.silverconnect.service;

import com.confident.silverconnect.domain.guardian.Guardian;
import com.confident.silverconnect.domain.guardian.GuardianRepository;
import com.confident.silverconnect.dto.guardian.GuardianUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class GuardianService {
    private static final String NOT_FOUND_GUARDIAN_MESSAGE = "해당하는 보호자가 없습니다.";
    private final GuardianRepository guardianRepository;
    public List<Guardian> findAll(Integer page) {
        Pageable pageable = PageRequest.of(page, 20);
        return guardianRepository.findAll(pageable).stream().collect(Collectors.toList());
    }

    public Guardian findById(Long userId) {
        return guardianRepository.findById(userId).orElseThrow(() -> new IllegalArgumentException("없는 유저입니다"));
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

    public Guardian findByEmail(String userEmail) {
        return guardianRepository.findByEmail(userEmail).get();
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
}