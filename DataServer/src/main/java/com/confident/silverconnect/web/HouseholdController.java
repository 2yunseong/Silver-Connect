package com.confident.silverconnect.web;

import com.confident.silverconnect.domain.Household.Household;
import com.confident.silverconnect.dto.household.HouseholdCreateDto;
import com.confident.silverconnect.dto.household.HouseholdUpdateRequestDto;
import com.confident.silverconnect.service.HouseholdService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class HouseholdController {

    private final HouseholdService householdService;


    @PostMapping("/api/household")
    public ResponseEntity<Household> createHousehold(HouseholdCreateDto householdCreateDto) {
        Household household = householdService.createHousehold(householdCreateDto);

        return ResponseEntity.ok(household);
    }

    @GetMapping("/api/household/{id}")
    public ResponseEntity<Household> getHousehold(@PathVariable(value = "id") Long id) {
        Household household = householdService.getHouseholdById(id);

        return ResponseEntity.ok(household);
    }

    @PutMapping("/api/household/{id}")
    public ResponseEntity<Household> updateHousehold(@PathVariable(value = "id") Long id,
                                                     HouseholdUpdateRequestDto householdUpdateRequestDto) {
        Household household = householdService.updateHouseholdById(id, householdUpdateRequestDto);

        return ResponseEntity.ok(household);
    }

    @DeleteMapping("/api/household/{id}")
    public ResponseEntity<Household> deleteHousehold(@PathVariable(value = "id") Long id) {
        householdService.deleteHouseholdById(id);

        return ResponseEntity.ok().build();
    }
}
