package com.confident.silverconnect.util;

import com.confident.silverconnect.domain.Household.Household;
import com.confident.silverconnect.domain.Household.HouseholdRepository;
import com.confident.silverconnect.domain.Schedule.Schedule;
import com.confident.silverconnect.domain.Schedule.ScheduleRepository;
import com.confident.silverconnect.domain.User.User;
import com.confident.silverconnect.domain.User.UserRepository;
import com.confident.silverconnect.domain.guardian.Guardian;
import com.confident.silverconnect.domain.guardian.GuardianRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;

@Component
@RequiredArgsConstructor
public class DummyGenerator {

    private final UserRepository userRepository;
    private final HouseholdRepository householdRepository;
    private final GuardianRepository guardianRepository;
    private final ScheduleRepository scheduleRepository;

    @PostConstruct
    @Transactional
    public void init() {
        User user1 = User.builder()
                .email("pak@gmail.com")
                .password("pak")
                .name("박복지")
                .phoneNumber("010-1234-1111")
                .build();
        User user2 = User.builder()
                .email("kim@gmail.com")
                .password("kim")
                .name("김복지")
                .phoneNumber("010-1234-1112")
                .build();
        user1 = userRepository.save(user1);
        user2 = userRepository.save(user2);

        Household household1 = Household.builder()
                .address("광주광역시 북구 오치동 406 우미아파트 106동 402호")
                .residentName("임거주")
                .residentAge(78)
                .residentPhoneNumber("010-1234-2222")
                .build();
        Household household2 = Household.builder()
                .address("광주광역시 북구 오치동 406 우미아파트 108동 201호")
                .residentName("심거주")
                .residentAge(75)
                .residentPhoneNumber("010-1234-2223")
                .build();
        Household household3 = Household.builder()
                .address("광주광역시 북구 대천로 40 혁신대운아파트 101동 103호")
                .residentName("권거주")
                .residentAge(71)
                .residentPhoneNumber("010-1234-2224")
                .build();
        Household household4 = Household.builder()
                .address("광주광역시 북구 대천로 40 혁신대운아파트 102동 203호")
                .residentName("김거주")
                .residentAge(80)
                .residentPhoneNumber("010-1234-2225")
                .build();
        Household household5 = Household.builder()
                .address("광주광역시 북구 저불 21 모아미래도아파트 101동 105호")
                .residentName("장거주")
                .residentAge(77)
                .residentPhoneNumber("010-1234-2226")
                .build();
        Household household6 = Household.builder()
                .address("광주광역시 북구 저불 21 모아미래도아파트 101동 108호")
                .residentName("전거주")
                .residentAge(79)
                .residentPhoneNumber("010-1234-2227")
                .build();
        Household household7 = Household.builder()
                .address("광주광역시 북구 저불 21 모아미래도아파트 104동 202호")
                .residentName("엄거주")
                .residentAge(82)
                .residentPhoneNumber("010-1234-2228")
                .build();
        Household household8 = Household.builder()
                .address("광주광역시 북구 저불 21 모아미래도아파트 106동 101호")
                .residentName("망거주")
                .residentAge(88)
                .residentPhoneNumber("010-1234-2229")
                .build();
        household1 = householdRepository.save(household1);
        household2 = householdRepository.save(household2);
        household3 = householdRepository.save(household3);
        household4 = householdRepository.save(household4);
        household5 = householdRepository.save(household5);
        household6 = householdRepository.save(household6);
        household7 = householdRepository.save(household7);
        household8 = householdRepository.save(household8);

        Guardian guardian1 = Guardian.builder()
                .household(household1)
                .name("임보호")
                .age(45)
                .phoneNumber("010-1234-3333")
                .build();
        Guardian guardian2 = Guardian.builder()
                .household(household2)
                .name("심보호")
                .age(45)
                .phoneNumber("010-1234-3334")
                .build();
        Guardian guardian3 = Guardian.builder()
                .household(household3)
                .name("권보호")
                .age(45)
                .phoneNumber("010-1234-3335")
                .build();
        Guardian guardian4 = Guardian.builder()
                .household(household4)
                .name("김보호")
                .age(45)
                .phoneNumber("010-1234-3336")
                .build();
        Guardian guardian5 = Guardian.builder()
                .household(household5)
                .name("장보호")
                .age(45)
                .phoneNumber("010-1234-3337")
                .build();
        Guardian guardian6 = Guardian.builder()
                .household(household6)
                .name("전보호")
                .age(45)
                .phoneNumber("010-1234-3338")
                .build();
        Guardian guardian7 = Guardian.builder()
                .household(household7)
                .name("엄보호")
                .age(45)
                .phoneNumber("010-1234-3339")
                .build();
        Guardian guardian8 = Guardian.builder()
                .household(household8)
                .name("망보호")
                .age(45)
                .phoneNumber("010-1234-3340")
                .build();
        guardian1 = guardianRepository.save(guardian1);
        guardian2 = guardianRepository.save(guardian2);
        guardian3 = guardianRepository.save(guardian3);
        guardian4 = guardianRepository.save(guardian4);
        guardian5 = guardianRepository.save(guardian5);
        guardian6 = guardianRepository.save(guardian6);
        guardian7 = guardianRepository.save(guardian7);
        guardian8 = guardianRepository.save(guardian8);

        Schedule schedule1_1 = Schedule.builder()
                .user(user1)
                .household(household1)
                .dateTime(LocalDateTime.of(2022, 12, 1, 7, 0))
                .build();
        Schedule schedule1_2 = Schedule.builder()
                .user(user1)
                .household(household2)
                .dateTime(LocalDateTime.of(2022, 12, 1, 9, 0))
                .build();
        Schedule schedule1_3 = Schedule.builder()
                .user(user1)
                .household(household3)
                .dateTime(LocalDateTime.of(2022, 12, 2, 13, 0))
                .build();
        Schedule schedule1_4 = Schedule.builder()
                .user(user1)
                .household(household4)
                .dateTime(LocalDateTime.of(2022, 12, 3, 15, 0))
                .build();
        Schedule schedule2_1 = Schedule.builder()
                .user(user2)
                .household(household5)
                .dateTime(LocalDateTime.of(2022, 12, 1, 7, 0))
                .build();
        Schedule schedule2_2 = Schedule.builder()
                .user(user2)
                .household(household6)
                .dateTime(LocalDateTime.of(2022, 12, 1, 9, 0))
                .build();
        Schedule schedule2_3 = Schedule.builder()
                .user(user2)
                .household(household7)
                .dateTime(LocalDateTime.of(2022, 12, 2, 13, 0))
                .build();
        Schedule schedule2_4 = Schedule.builder()
                .user(user2)
                .household(household8)
                .dateTime(LocalDateTime.of(2022, 12, 3, 15, 0))
                .build();

        scheduleRepository.save(schedule1_1);
        scheduleRepository.save(schedule1_2);
        scheduleRepository.save(schedule1_3);
        scheduleRepository.save(schedule1_4);
        scheduleRepository.save(schedule2_1);
        scheduleRepository.save(schedule2_2);
        scheduleRepository.save(schedule2_3);
        scheduleRepository.save(schedule2_4);
    }
}
