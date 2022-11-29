package com.confident.silverconnect.web;

import com.confident.silverconnect.domain.User.User;
import com.confident.silverconnect.service.UserService;
import com.confident.silverconnect.dto.user.UserFindDto;
import com.confident.silverconnect.dto.user.UserUpdateRequestDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequiredArgsConstructor
@RestController
public class UserController {
    private final UserService userService;

    @Operation(summary = "회원가입", description = "회원가입 로직")
    @ApiResponses({
            @ApiResponse(responseCode = "User", description = "회원가입 User")
    })
    @PostMapping("/api/user")
    public ResponseEntity<User> singup(UserUpdateRequestDto userUpdateRequestDto){
        User user = userService.createUser(userUpdateRequestDto.toEntity());
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @GetMapping("/api/user/all/{page}")
    public ResponseEntity<List<User>> findUserAll(@PathVariable int page){
        List<User> listUser = userService.findAll();
        return new ResponseEntity<>(listUser, HttpStatus.OK);
    }

    @Operation(summary = "findUserById", description = "Id로 회원조회")
    @ApiResponses({
            @ApiResponse(responseCode = "User Object", description = "검색 유저 return")
    })
    @GetMapping("/api/user")
    public ResponseEntity<User> findUserById(Long id) {
        User account = userService.findUserById(id);
        return new ResponseEntity<>(account, HttpStatus.OK);
    }

    @Operation(summary = "전체 회원 수 조회", description = "전체 회원 수 조회")
    @ApiResponses({
            @ApiResponse(description = "Role에 따른 회원 조횐 return")
    })
    @GetMapping("/api/user/count/")
    public ResponseEntity<Long> countAllUser(){
        Long numberAllUser = userService.countAllUser();
        return new ResponseEntity<>(numberAllUser, HttpStatus.OK);
    }


    @Operation(summary = "이름으로 회원 조회", description = "동명이인 포함 회원 정보 조회")
    @ApiResponses({
            @ApiResponse(description = "이름으로 회원 조회")
    })
    @GetMapping("/api/user/{userName}")
    public ResponseEntity<List<User>> findUserByUserName(@PathVariable String userName){
        List<User> userListByUserName = userService.findUserByUserName(userName);
        return new ResponseEntity<>(userListByUserName, HttpStatus.OK);
    }

    @Operation(summary = "Email 찾기 기능", description = "Email 찾기 ( 기수, 이름 ) 으로 조회")
    @ApiResponses({
            @ApiResponse(description = "Email에 따른 회원 조횐 return")
    })
    @GetMapping("/api/user/find-email/")
    public ResponseEntity<User> findEmail(@Valid UserFindDto userFindDto){
        User userByYearAndUserName = userService.findUserByYearAndUserName(userFindDto.getUserName(), userFindDto.getYear());
        return new ResponseEntity<>(userByYearAndUserName, HttpStatus.OK);
    }

    @Operation(summary = "Email로 회원 조회", description = "이메일로 회원 조회")
    @ApiResponses({
            @ApiResponse(description = "Role에 따른 회원 조횐 return")
    })
    @GetMapping("/api/user/email/{userEmail}")
    public ResponseEntity<User> findUserByEmail(@PathVariable String userEmail) {
        User userByUserEmail = userService.findUserByUserEmail(userEmail);
        return new ResponseEntity<>(userByUserEmail,HttpStatus.OK);
    }

    @Operation(summary = "회원정보 수정", description = "회원정보 수정")
    @ApiResponses({
            @ApiResponse(description = "Role에 따른 회원 조회 return")
    })
    @PostMapping("/api/user/{userId}")
    public User updateUser(@PathVariable Long userId, UserUpdateRequestDto userUpdateRequestDto) {
        return userService.updateUser(userId, userUpdateRequestDto);
    }

    @Operation(summary = "회원삭제", description = "회원 삭제")
    @ApiResponses({
            @ApiResponse(description = "회원 삭제 Response")
    })
    @DeleteMapping("/api/user/{userId}")
    public ResponseEntity<User> deleteUser(@PathVariable Long userId) {
        userService.deleteUserById(userId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
