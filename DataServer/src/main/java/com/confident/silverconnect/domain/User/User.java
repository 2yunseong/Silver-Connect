package com.confident.silverconnect.domain.User;

import com.confident.silverconnect.dto.user.UserUpdateRequestDto;
import com.sun.istack.NotNull;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@NoArgsConstructor
@Getter
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String email;

    @NotNull
    private String password;

    @NotNull
    private String name;

    @NotNull
    private String phoneNumber;

    @Builder
    public User(String email, String password, String name, String phoneNumber) {
        this.email = email;
        this.password = password;
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public void setPassword(String password){
        this.password = password;
    }

    public void update(UserUpdateRequestDto userUpdateRequestDto){
        this.email = userUpdateRequestDto.getEmail();
        this.name = userUpdateRequestDto.getName();
        this.phoneNumber = userUpdateRequestDto.getPhoneNumber();
        this.password = userUpdateRequestDto.getPassword();
    }
}
