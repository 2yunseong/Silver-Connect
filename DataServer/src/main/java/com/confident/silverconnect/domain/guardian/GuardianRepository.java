package com.confident.silverconnect.domain.guardian;

import com.confident.silverconnect.domain.Household.Household;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface GuardianRepository extends JpaRepository<Guardian , Long> {
    List<Guardian> findByName(String name);
    Optional<Guardian> findByHousehold_Id(Long householdId);
}
