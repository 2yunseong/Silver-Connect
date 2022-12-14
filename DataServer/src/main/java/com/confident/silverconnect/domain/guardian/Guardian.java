package com.confident.silverconnect.domain.guardian;

import com.confident.silverconnect.domain.Household.Household;
import com.confident.silverconnect.dto.guardian.GuardianUpdateRequestDto;
import com.sun.istack.NotNull;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@Entity
public class Guardian {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "household_id", nullable = false)
    private Household household;

    @NotNull
    private String name;

    @NotNull
    private Integer age;

    @NotNull
    private String phoneNumber;

    @Builder
    public Guardian(Household household, String name, Integer age, String phoneNumber) {
        this.household = household;
        this.name = name;
        this.age = age;
        this.phoneNumber = phoneNumber;
    }

    public void update(GuardianUpdateRequestDto userUpdateRequestDto) {
        this.name = userUpdateRequestDto.getName();
        this.age = userUpdateRequestDto.getAge();
        this.phoneNumber = userUpdateRequestDto.getPhoneNumber();
    }
}
