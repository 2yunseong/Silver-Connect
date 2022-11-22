package com.confident.silverconnect.domain.Household;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface HouseholdRepository extends JpaRepository<Household, Long> {
    Optional<Household> getByPhoneNumber(String phoneNumber);
}
