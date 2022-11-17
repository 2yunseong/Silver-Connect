package com.confident.silverconnect.domain.Schedule;

import com.confident.domain.Household.Household;
import com.confident.silverconnect.domain.Household.Household;
import com.confident.silverconnect.domain.User.User;
import com.sun.istack.NotNull;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@NoArgsConstructor
@Getter
@Entity
public class Schedule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "household_id", nullable = false)
    private Household household;

    @NotNull
    private LocalDateTime dateTime;

    @Builder
    public Schedule(User user, Household household, LocalDateTime dateTime) {
        this.user = user;
        this.household = household;
        this.dateTime = dateTime;
    }
}
