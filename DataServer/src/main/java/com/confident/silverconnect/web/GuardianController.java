package com.confident.silverconnect.web;

import com.confident.silverconnect.domain.Household.Household;
import com.confident.silverconnect.domain.guardian.Guardian;
import com.confident.silverconnect.dto.guardian.GuardianFindDto;
import com.confident.silverconnect.dto.guardian.GuardianUpdateRequestDto;
import com.confident.silverconnect.service.GuardianService;
import com.confident.silverconnect.service.HouseholdService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class GuardianController {
    private final GuardianService guardianService;
    private final HouseholdService householdService;

    @Operation(summary = "보호자 보호자가입", description = "보호자 보호자가입 로직")
    @ApiResponses({
            @ApiResponse(responseCode = "Guardian ", description = "보호자가입 Guardian")
    })
    @PostMapping("/api/guardian")
    public ResponseEntity<Guardian> singup(GuardianUpdateRequestDto guardianUpdateRequestDto){
        String phoneNumber = guardianUpdateRequestDto.getResidentPhoneNumber();
        Household household = householdService.getByPhoneNumber(phoneNumber);
        Guardian guardian = guardianService.createGuardian(guardianUpdateRequestDto.toEntity(household));
        return new ResponseEntity<>(guardian, HttpStatus.OK);
    }


    @Operation(summary = "household id 로 guardian 조회", description = "household id 로 guardian 조회")
    @ApiResponses({
            @ApiResponse(responseCode = "Guardian ", description = "보호자조회 Guardian")
    })
    @GetMapping("/api/guardian/")
    public ResponseEntity<Guardian> findByHouseholdId(Long householdId){
        Guardian guardian = guardianService.findByHouseholdId(householdId);

        return new ResponseEntity<>(guardian, HttpStatus.OK);
    }


    @Operation(summary = "보호자 전체 조회", description = "보호자 전체 조회")
    @ApiResponses({
            @ApiResponse(responseCode = "Guardian ", description = "보호자조회 Guardian")
    })
    @GetMapping("/api/guardian/all/")
    public ResponseEntity<List<Guardian>> findAll(){
        List<Guardian> listGuardian = guardianService.findAll();
        return new ResponseEntity<>(listGuardian, HttpStatus.OK);
    }

    @Operation(summary = "findGuardianById", description = "Id로 보호자조회")
    @ApiResponses({
            @ApiResponse(responseCode = "Guardian Object", description = "검색 유저 return")
    })
    @GetMapping("/api/guardian/{guardianId}")
    public ResponseEntity<Guardian> findGuardianById(@PathVariable Long guardianId) {
        Guardian guardian = guardianService.findById(guardianId);
        return new ResponseEntity<>(guardian, HttpStatus.OK);
    }

    @Operation(summary = "전체 보호자 수 조회", description = "전체 보호자 수 조회")
    @ApiResponses({
            @ApiResponse(description = "Role에 따른 보호자 조ghl return")
    })
    @GetMapping("/api/guardian/count")
    public ResponseEntity<Long> countAllGuardian(){
        Long numberAllGuardian = guardianService.countAll();
        return new ResponseEntity<>(numberAllGuardian, HttpStatus.OK);
    }


    @Operation(summary = "이름으로 보호자 조회", description = "동명이인 포함 보호자 정보 조회")
    @ApiResponses({
            @ApiResponse(description = "이름으로 보호자 조회")
    })
    @GetMapping("/api/guardiannames/{guardianName}")
    public ResponseEntity<List<Guardian>> findGuardianByGuardianName(@PathVariable String guardianName){
        List<Guardian> guardianListByGuardianName = guardianService.findByName(guardianName);
        return new ResponseEntity<>(guardianListByGuardianName, HttpStatus.OK);
    }

    @Operation(summary = "Email 찾기 기능", description = "Email 찾기 ( 기수, 이름 ) 으로 조회")
    @ApiResponses({
            @ApiResponse(description = "Email에 따른 보호자 조횐 return")
    })
    @GetMapping("/api/guardian/find-email/")
    public ResponseEntity<Guardian> findEmail(@Valid GuardianFindDto guardianFindDto){
        Guardian guardianByYearAndGuardianName = guardianService.findGuardianByPhoneNumberAndName(guardianFindDto.getName(), guardianFindDto.getPhoneNumber());
        return new ResponseEntity<>(guardianByYearAndGuardianName, HttpStatus.OK);
    }

    @Operation(summary = "보호자정보 수정", description = "보호자정보 수정")
    @ApiResponses({
            @ApiResponse(description = "Role에 따른 보호자 조회 return")
    })
    @PostMapping("/api/guardian/{guardianId}")
    public Guardian updateGuardian(@PathVariable Long guardianId, GuardianUpdateRequestDto guardianUpdateRequestDto) {
        return guardianService.update(guardianId, guardianUpdateRequestDto);
    }

    @Operation(summary = "보호자삭제", description = "보호자 삭제")
    @ApiResponses({
            @ApiResponse(description = "보호자 삭제 Response")
    })
    @DeleteMapping("/api/guardian/{guardianId}")
    public ResponseEntity<Guardian> deleteGuardian(@PathVariable Long guardianId) {
        guardianService.deleteById(guardianId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}