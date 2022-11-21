package com.confident.silverconnect.dto.user;

import com.sun.istack.NotNull;
import lombok.Getter;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
public class UserUpdateRequestDto {
    private String email;
    private String password;
    private String name;
    private String phoneNumber;
}
