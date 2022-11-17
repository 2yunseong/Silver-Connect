package com.confident.silverconnect.domain.Household;

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
public class Household {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String address;

    @NotNull
    private Risk risk;

    @NotNull
    private String residentName;

    @NotNull
    private Integer residentAge;

    @NotNull
    private String residentPhoneNumber;

    @Builder
    public Household(String address, String residentName, Integer residentAge, String residentPhoneNumber) {
        this.address = address;
        this.risk = Risk.SAFE;
        this.residentName = residentName;
        this.residentAge = residentAge;
        this.residentPhoneNumber = residentPhoneNumber;
    }
}
