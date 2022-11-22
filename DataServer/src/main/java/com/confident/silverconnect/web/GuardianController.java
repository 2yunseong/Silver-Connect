package com.confident.silverconnect.web;

import com.confident.silverconnect.domain.guardian.Guardian;
import com.confident.silverconnect.dto.guardian.GuardianFindDto;
import com.confident.silverconnect.dto.guardian.GuardianUpdateRequestDto;
import com.confident.silverconnect.service.GuardianService;
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

    @GetMapping("/api/user/all/{page}")
    public ResponseEntity<List<Guardian>> findAll(@PathVariable int page){
        List<Guardian> listGuardian = guardianService.findAll(page);
        return new ResponseEntity<>(listGuardian, HttpStatus.OK);
    }

    @Operation(summary = "findGuardianById", description = "Id로 회원조회")
    @ApiResponses({
            @ApiResponse(responseCode = "Guardian Object", description = "검색 유저 return")
    })
    @GetMapping("/api/user/{userId}")
    public ResponseEntity<Guardian> findGuardianById(@PathVariable Long userId) {
        Guardian guardian = guardianService.findById(userId);
        return new ResponseEntity<>(guardian, HttpStatus.OK);
    }

    @Operation(summary = "전체 회원 수 조회", description = "전체 회원 수 조회")
    @ApiResponses({
            @ApiResponse(description = "Role에 따른 회원 조횐 return")
    })
    @GetMapping("/api/user/count")
    public ResponseEntity<Long> countAllGuardian(){
        Long numberAllGuardian = guardianService.countAll();
        return new ResponseEntity<>(numberAllGuardian, HttpStatus.OK);
    }


    @Operation(summary = "이름으로 회원 조회", description = "동명이인 포함 회원 정보 조회")
    @ApiResponses({
            @ApiResponse(description = "이름으로 회원 조회")
    })
    @GetMapping("/api/usernames/{userName}")
    public ResponseEntity<List<Guardian>> findGuardianByGuardianName(@PathVariable String userName){
        List<Guardian> userListByGuardianName = guardianService.findByName(userName);
        return new ResponseEntity<>(userListByGuardianName, HttpStatus.OK);
    }

    @Operation(summary = "Email 찾기 기능", description = "Email 찾기 ( 기수, 이름 ) 으로 조회")
    @ApiResponses({
            @ApiResponse(description = "Email에 따른 회원 조횐 return")
    })
    @GetMapping("/api/user/find-email/")
    public ResponseEntity<Guardian> findEmail(@Valid GuardianFindDto guardianFindDto){
        Guardian userByYearAndGuardianName = guardianService.findGuardianByPhoneNumberAndName(guardianFindDto.getName(), guardianFindDto.getPhoneNumber());
        return new ResponseEntity<>(userByYearAndGuardianName, HttpStatus.OK);
    }

    @Operation(summary = "Email로 회원 조회", description = "이메일로 회원 조회")
    @ApiResponses({
            @ApiResponse(description = "Role에 따른 회원 조횐 return")
    })
    @GetMapping("/api/user/email/{userEmail}")
    public ResponseEntity<Guardian> findGuardianByEmail(@PathVariable String userEmail) {
        Guardian userByGuardianEmail = guardianService.findByEmail(userEmail);
        return new ResponseEntity<>(userByGuardianEmail,HttpStatus.OK);
    }

    @Operation(summary = "회원정보 수정", description = "회원정보 수정")
    @ApiResponses({
            @ApiResponse(description = "Role에 따른 회원 조회 return")
    })
    @PostMapping("/api/user/{userId}")
    public Guardian updateGuardian(@PathVariable Long userId, GuardianUpdateRequestDto userUpdateRequestDto) {
        return guardianService.update(userId, userUpdateRequestDto);
    }

    @Operation(summary = "회원삭제", description = "회원 삭제")
    @ApiResponses({
            @ApiResponse(description = "회원 삭제 Response")
    })
    @DeleteMapping("/api/user/{userId}")
    public ResponseEntity<Guardian> deleteGuardian(@PathVariable Long userId) {
        guardianService.deleteById(userId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}