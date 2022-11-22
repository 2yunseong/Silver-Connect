package com.confident.silverconnect.dto.user;

import com.confident.silverconnect.domain.User.User;
import lombok.Getter;

@Getter
public class UserUpdateRequestDto {
    private String email;
    private String password;
    private String name;
    private String phoneNumber;

    public User toEntity() {
        return User.builder().
                email(email)
                .password(password)
                .name(name)
                .phoneNumber(phoneNumber)
                .build();
    }
}
