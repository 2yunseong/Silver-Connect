package com.confident.silverconnect.service;


import com.confident.silverconnect.domain.User.User;
import com.confident.silverconnect.domain.User.UserRepository;
import com.confident.silverconnect.dto.user.UserPasswordUpdateDto;
import com.confident.silverconnect.dto.user.UserUpdateRequestDto;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Slf4j
@Service
@Transactional(rollbackFor = Exception.class)
public class UserService {
    private final UserRepository userRepository;

    private static final String NOT_FOUND_USER_MESSAGE = "해당 회원을 찾을 수 없습니다";
    private static final String NOT_CORRECT_USER_MESSAGE = "비밀번호나 이메일이 일치하지 않습니다.";

    @Transactional
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Transactional
    public User setPassword(UserPasswordUpdateDto userPasswordUpdateDto) {
        User user = userRepository.findByName(userPasswordUpdateDto.getUserName()).get(0);
        user.setPassword(userPasswordUpdateDto.getPassword());
        return userRepository.save(user);
    }

    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Transactional
    public Long countAllUser() {
        return userRepository.count();
    }

    /**
     * Get User By One userId
     *
     * @param id : userId
     * @return User
     */
    @Transactional
    public User findUserById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException(NOT_FOUND_USER_MESSAGE));
    }

    /**
     * Get User By One name
     *
     * @param name : name
     * @return List<UserResponseDto>
     * 동명이인이 있을 수 있어서 List를 받는다.
     */
    @Transactional
    public List<User> findUserByUserName(String name) {
        List<User> users = userRepository.findByName(name);
        if (users.isEmpty()) {
            throw new IllegalArgumentException(NOT_FOUND_USER_MESSAGE);
        }
        return users;
    }


    @Transactional
    public User findUserByYearAndUserName(String name, Long phoneNumber) {
        List<User> findUser = userRepository.findByName(name).stream()
                .filter(m -> m.getPhoneNumber().equals(phoneNumber))
                .collect(Collectors.toList());
        if (findUser.isEmpty()) {
            throw new IllegalArgumentException(NOT_CORRECT_USER_MESSAGE);
        }
        return findUser.stream().findFirst().get();
    }

    /**
     * Get User By One email
     *
     * @param email
     * @return User
     */
    @Transactional
    public User findUserByUserEmail(String email) {
        return userRepository.findByEmail(email).orElseThrow(() -> new IllegalArgumentException("없는 이메일입니다."));
    }

    /**
     * delete One User Data
     * @return void
     * @Param userId
     */
    public void deleteUserById(final Long userId) {
//        관리자만 삭제할 수 있게 관리자 인증 추가 예정
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException(NOT_FOUND_USER_MESSAGE));
        userRepository.delete(user);
    }

    /**
     * update One User Data
     *
     * @return boolean
     * @Param email : String!, password : String!, year : Int!, name : String!
     */
    public User updateUser(Long userId, UserUpdateRequestDto userUpdateRequestDto) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException(NOT_FOUND_USER_MESSAGE));
        user.update(userUpdateRequestDto);
        return user;
    }

    public User createUser(User user) {
        return userRepository.save(user);
    }
}

