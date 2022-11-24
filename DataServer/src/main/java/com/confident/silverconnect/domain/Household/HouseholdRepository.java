package com.confident.silverconnect.domain.Household;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface HouseholdRepository extends JpaRepository<Household, Long> {
    Optional<Household> getByResidentPhoneNumber(String phoneNumber);

    Optional<Household> getByResidentName(String residentName);
}
